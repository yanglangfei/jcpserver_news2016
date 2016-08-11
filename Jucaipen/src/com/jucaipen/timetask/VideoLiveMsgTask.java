package com.jucaipen.timetask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.PushPayload;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLiveMsg;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
public class VideoLiveMsgTask extends TimerTask{

	private  Map<String, String> params=new HashMap<String, String>();
	private int maxId;
	private int userId;
	private int liveId;
	private static final String GET_LIVE_MSG="http://192.168.1.132/TeacherLive/ashx/VideoLive.ashx?action=GetMsgList";

//	private static final String GET_LIVE_MSG="http://www.jucaipen.com/TeacherLive/ashx/VideoLive.ashx?action=GetMsgList";
	private boolean isManager;

	public VideoLiveMsgTask(int maxId, int userId, int liveId,boolean isManager) {
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
	
	
	
	
	public  void checkMsg(int mId,int lId,int uId,boolean isM){
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
		}else{
			isM=false;
		}
		params.clear();
		params.put("lid", lId+"");
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
			JPushClient client = JPushUtils.getJPush();
			PushPayload msgs = JPushUtils.createMsg("msg", "liveMsg", pushMsg, null);
		    JPushUtils.pushMsg(client, msgs);
		    if(msgObjs.size()>0){
				if(isM){
					maxId=  msgObjs.get(msgObjs.size()-1).getId();
				}else{
					maxId= msgObjs.get(msgObjs.size()-1).getShenhe();
				}
			}
			
		}
		
	}
	
}
