package com.jucaipen.timetask;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.PushPayload;

import com.jucaipen.model.ChatMsgObject;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLiveMsg;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveMsgSer;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
public class VideoLiveMsgTask extends TimerTask{

	private  Map<String, String> params=new HashMap<String, String>();
	private int maxId;
	private int userId;
	private int liveId;
	private static final String GET_LIVE_MSG="http://192.168.1.132/TeacherLive/ashx/VideoLive.ashx?action=GetMsgList";
	private boolean isManager;
	private int teacherId;


	public VideoLiveMsgTask(int maxId, int userId, int liveId,int teacherId,boolean isManager) {
		this.maxId=maxId;
		this.userId=userId;
		this.liveId=liveId;
		this.isManager=isManager;
		this.teacherId=teacherId;
	}

	@Override
	public void run() {
		//checkLiveMsg(maxId, liveId, userId,isManager);
		checkMsg(maxId, liveId, userId, teacherId, isManager);
		
	}
	
	
	
	
	public  int checkMsg(int mId,int lId,int uId,int tId,boolean isM){
		//lid  tid  topid  IsServerId
		params.clear();
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
		params.put("lid", lId+"");
		params.put("tid", tId+"");
		params.put("topid", mId+"");
		params.put("IsServerId", user.getServerId()+"");
		String result=LoginUtil.sendHttpPost(GET_LIVE_MSG, params);
		List<ChatMsgObject>  msgObj =JsonUtil.repCompleMsgObj(result);
		if(msgObj.size()>0){
			if(isM){
				return  msgObj.get(msgObj.size()-1).getId();
			}else{
				return msgObj.get(msgObj.size()-1).getShenhe();
			}
		}
		return 0;
		
		/* {
		        "Id": 481,
		        "SendUserId": 6750,
		        "SendName": "钻石",
		        "Msg": "<img src=\"http://img.jucaipen.com/jucaipenUpload/2015/7/15/2015715174137.gif\">",
		        "shenhe": 284,
		        "ReceiverId": 0,
		        "ReceiverName": "",
		        "Fk_VideoLiveId": 1,
		        "BuyProductId": 0,
		        "IsSysAdmin": 1,
		        "IsRoomAdmin": 0,
		        "Isteacher": 0,
		        "IsShouhuzhe": 0,
		        "IsChatAdmin": 0,
		        "UserLevel": 1,
		        "IsSeverId": 0,
		        "SendDate": "2016-07-07T17:30:53",
		        "IP": "192.168.1.134"
		    }*/
		
	}
	
	
	
	/**
	 *   实时监测消息
	 */
	public void checkLiveMsg(int mId,int liveId,int userId,boolean isM){
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
