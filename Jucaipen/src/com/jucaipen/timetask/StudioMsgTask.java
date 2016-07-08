package com.jucaipen.timetask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.PushPayload;
import com.jucaipen.model.Studio;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLiveMsg;
import com.jucaipen.service.StudioSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;

public class StudioMsgTask extends TimerTask{

	private int maxId;
	private int userId;
	private int liveId;
	private  Map<String, String> params=new HashMap<String, String>();
	private boolean isManager;
	private static final String GET_LIVE_MSG="http://192.168.1.131/TeacherLive/ashx/VideoLive.ashx?action=GetMsgList";

	public StudioMsgTask(int maxId, int userId, int liveId,boolean isManager) {
		this.maxId=maxId;
		this.userId=userId;
		this.liveId=liveId;
		this.isManager=isManager;
	}

	@Override
	public void run() {
		//checkLiveMsg(maxId, liveId, userId,isManager);
		checkMsg(maxId, liveId, userId, isManager);
	}
	
	
	private void checkMsg(int mId,int sId,int uId,boolean isM){
		Studio studio=StudioSer.findStudioById(sId);
		if(studio==null){
			return ;
		}
		int liveId=studio.getVideoLiveId();
		if(liveId<=0){
			return ;
		}
		User user;
		if(uId>0){
			user=UserServer.findUserChatInfo(uId);
		}else{
			user=new User();
		}
		int isRoomAdmin=user.getIsRoomAdmin();
		int isRoomManager=user.getIsRoomManager();
		int isSysAdmin=user.getIsSysAdmin();
		if(isSysAdmin==1||isRoomAdmin==1||isRoomManager==1){
			 isM=true;
		}else{
			isM=false;
		}
		params.clear();
		params.put("lid", liveId+"");
		params.put("topid", mId+"");
		params.put("IsServerId", user.getServerId()+"");
		String result=LoginUtil.sendHttpPost(GET_LIVE_MSG, params);
		List<VideoLiveMsg>  msgObjs =JsonUtil.repCompleMsgObj(result);
		if(msgObjs!=null){
			for(VideoLiveMsg liveMsg : msgObjs){
				int sendId=liveMsg.getSendUserId();
				int receiverId=liveMsg.getReceiverId();
				User fromUser = UserServer.findBaseInfoById(sendId);
				User toUser = UserServer.findBaseInfoById(receiverId);
				if(fromUser==null){
					fromUser=new User();
				}
				liveMsg.setSendFace(fromUser.getFaceImage());
				if(toUser==null){
					toUser=new User();
				}
				liveMsg.setReceiverFace(toUser.getFaceImage());
			}
			String pushMsg=JsonUtil.createLiveMsg(msgObjs);
			if(msgObjs.size()>0&&pushMsg!=null){
				System.out.println("pushMsg:"+pushMsg);
				JPushClient client = JPushUtils.getJPush();
				PushPayload msgs = JPushUtils.createMsg("msg", "studioMsg", pushMsg, null);
			    JPushUtils.pushMsg(client, msgs);
			}
		    if(msgObjs.size()>0){
				if(isM){
					maxId=  msgObjs.get(msgObjs.size()-1).getId();
				}else{
					maxId= msgObjs.get(msgObjs.size()-1).getShenhe();
				}
			}
			
		}
	}
	

	/*private void checkLiveMsg(int mId, int sId, int uId,boolean isM) {
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
*/
}
