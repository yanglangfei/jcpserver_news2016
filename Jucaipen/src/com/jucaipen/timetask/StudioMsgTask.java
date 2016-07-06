package com.jucaipen.timetask;

import java.util.List;
import java.util.TimerTask;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

import com.jucaipen.model.Studio;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLiveMsg;
import com.jucaipen.service.StudioSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveMsgSer;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;

public class StudioMsgTask extends TimerTask{

	private int maxId;
	private int userId;
	private int liveId;
	private boolean isManager;

	public StudioMsgTask(int maxId, int userId, int liveId,boolean isManager) {
		this.maxId=maxId;
		this.userId=userId;
		this.liveId=liveId;
		this.isManager=isManager;
	}

	@Override
	public void run() {
		checkMsg(maxId, liveId, userId,isManager);
	}

	private void checkMsg(int mId, int sId, int uId,boolean isM) {
		Studio studio=StudioSer.findStudioById(sId);
		if(studio==null){
			return ;
		}
		int lId=studio.getVideoLiveId();
		if(lId<=0){
			return ;
		}
		List<VideoLiveMsg> msgs;
		User user;
		if(uId>0){
			user=UserServer.findUserChatInfo(uId);
		}else{
			user=new User();
		}
		
		int isRoomAdmin=user.getIsRoomAdmin();
		int isRoomManager=user.getIsRoomManager();
		int isSysAdmin=user.getIsSysAdmin();
		int isTeacher=user.getIsTeacher();
		if(isSysAdmin==1||isRoomAdmin==1||isRoomManager==1||isTeacher==1){
			isM=true;
			 msgs = VideoLiveMsgSer.findVideoMsgByMaxId(mId, lId, false);
		}else{
			isM=false;
			msgs = VideoLiveMsgSer.findVideoMsgByMaxId(mId, lId, true);
		}
		
		if(msgs!=null){
			for(VideoLiveMsg m : msgs){
				int senId=m.getSendUserId();
				int toId=m.getReceiverId();
				User fu=UserServer.findBaseInfoById(senId);
				if(fu==null){
					fu=new User();
				}
				m.setSendFace(fu.getFaceImage());
				User tu=UserServer.findBaseInfoById(toId);
				if(tu==null){
					tu=new User();
				}
				m.setReceiverFace(tu.getFaceImage());
			}
		}
		
		if(msgs!=null&&msgs.size()>0){
			String pushMsg = JsonUtil.createLiveMsgArray(msgs);
			JPushClient client = JPushUtils.getJPush();
			PushPayload msgObj = JPushUtils.createMsg("msg", "studioMsg", pushMsg, null);
			PushResult res = JPushUtils.pushMsg(client, msgObj);
			System.out.println("res:"+res.toString());
			if(isM){
				maxId= msgs.get(msgs.size()-1).getId();
			}else{
				maxId=msgs.get(msgs.size()-1).getShenhe();
			}
			
		}
	}

}
