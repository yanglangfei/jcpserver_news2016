package com.jucaipen.timetask;

import java.util.List;
import java.util.TimerTask;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.PushPayload;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLiveMsg;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveMsgSer;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;
public class VideoLiveMsgTask extends TimerTask{

	private int maxId;
	private int userId;
	private int liveId;
	private boolean isManager;


	public VideoLiveMsgTask(int maxId, int userId, int liveId,boolean isManager) {
		this.maxId=maxId;
		this.userId=userId;
		this.liveId=liveId;
		this.isManager=isManager;
	}

	@Override
	public void run() {
		checkMsg(maxId, liveId, userId,isManager);
	}
	
	
	/**
	 *   实时监测消息
	 */
	public void checkMsg(int mId,int liveId,int userId,boolean isM){
		List<VideoLiveMsg> msgs;
		User user;
		if(userId>0){
			user=UserServer.findUserChatInfo(userId);
		}else{
			user=new User();
		}
		int isRoomAdmin=user.getIsRoomAdmin();
		int isRoomManager=user.getIsRoomManager();
		int isSysAdmin=user.getIsSysAdmin();
		int isTeacher=user.getIsTeacher();
		if(isSysAdmin==1||isRoomAdmin==1||isRoomManager==1||isTeacher==1){
			 msgs = VideoLiveMsgSer.findVideoMsgByMaxId(mId, liveId, false);
			 isM=true;
		}else{
			msgs = VideoLiveMsgSer.findVideoMsgByMaxId(mId, liveId, true);
			isM=false;
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
			PushPayload msgObj = JPushUtils.createMsg("msg", "liveMsg", pushMsg, null);
			JPushUtils.pushMsg(client, msgObj);
			if(isM){
				maxId= msgs.get(msgs.size()-1).getId();
			}else{
				maxId=msgs.get(msgs.size()-1).getShenhe();
			}
		}
	}
	

}
