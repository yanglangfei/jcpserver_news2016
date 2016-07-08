package com.jucaipen.main.live;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.PushPayload;
import com.jucaipen.model.ChatMsgObject;
import com.jucaipen.model.Studio;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLiveMsg;
import com.jucaipen.service.StudioSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.timetask.StudioMsgTask;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 *
 *   演播室互动
 */
@SuppressWarnings("serial")
public class StudioChat extends HttpServlet {
	private Timer timer;
	private boolean isManager;
	private static final String GET_LIVE_MSG="http://www.jucaipen.com/TeacherLive/ashx/VideoLive.ashx?action=GetMsgList";
	private static final String SEND_LIVE_MSG="http://www.jucaipen.com/TeacherLive/ashx/VideoLive.ashx?action=APPSendMsg";
	private Map<String, String> params=new HashMap<String, String>();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String msgObject=request.getParameter("msgObject");
		if(StringUtil.isNotNull(msgObject)){
			ChatMsgObject chatMsg = JsonUtil.parseChatMsg(msgObject);
			int userId=chatMsg.getFromId();
			int liveId=chatMsg.getLiveId();
				int opType=chatMsg.getOpType();
				if(opType==1){
					//上线   --推送历史记录
					int maxId=requestMsg(userId, liveId);
					//int maxId=requestChatMsg(userId,liveId);
					timer = new Timer();
					StudioMsgTask task=new StudioMsgTask(maxId,userId,liveId,isManager);
					timer.scheduleAtFixedRate(task, new Date(), 2000);
				}else if(opType==2){
					//聊天
					String msg=chatMsg.getMsg();
					int toId=chatMsg.getToId();
					String result=sendMsg(userId, liveId, msg, toId);
					//String result = sendChatMsg(userId, liveId,msg,toId);
					out.print(result);
				}else{
					//下线
					if(timer!=null){
						timer.cancel();
						timer=null;
					}
				}
		}
		out.flush();
		out.close();
	}

	/*private String sendChatMsg(int userId, int studioId, String msg, int toId) {
		Studio studio=StudioSer.findStudioById(studioId);
		int liveId=studio.getVideoLiveId();
		if(liveId<=0){
			return null;
		}
		User fromUser;
		User toUser;
		if(userId>0){
			fromUser=UserServer.findUserChatInfo(userId);
			toUser=UserServer.findBaseInfoById(toId);
			if(toUser==null){
				toUser=new User();
			}
		}else{
			fromUser=new User();
			toUser=new User();
		}
		int isRoomAdmin=fromUser.getIsRoomAdmin();
		int isRoomManager=fromUser.getIsRoomManager();
		int isSysAdmin=fromUser.getIsSysAdmin();
		String nickName=fromUser.getNickName();
		int leavel=fromUser.getUserLeval();
		int isTeacher=fromUser.getIsTeacher();
		VideoLiveMsg msgObj=new VideoLiveMsg();
		msgObj.setIp(ip);
		msgObj.setIsChatAdmin(isRoomManager);
		msgObj.setBuyProductId(fromUser.getBuyProductId());
		msgObj.setIsRoomAdmin(isRoomAdmin);
		msgObj.setIsServer(fromUser.getServerId());
		msgObj.setIsShouhu(0);
		msgObj.setIsSysAdmin(isSysAdmin);
		msgObj.setIsTeacher(isTeacher);
		msgObj.setMsg(msg);
		msgObj.setReceiverId(toId);
		msgObj.setSendDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		msgObj.setSendName(nickName);
		msgObj.setSendUserId(userId);
		msgObj.setShenhe(0);
		msgObj.setUserLeavel(leavel);
		msgObj.setVideoLiveId(liveId);
		int isSuccess = VideoLiveMsgSer.addMsg(msgObj);
		return isSuccess==1 ?JsonUtil.getRetMsg(0, "消息发送成功") : JsonUtil.getRetMsg(1,"消息发送失败");
		
	}

	*//**
	 * @param userId
	 * @param liveId
	 * @return  上线请求数据
	 *//*
	private int requestChatMsg(int userId, int studioId) {
		Studio studio = StudioSer.findStudioById(studioId);
		if(studio==null){
			return -1;
		}
		int liveId=studio.getVideoLiveId();
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
			isManager=true;
			 msgs = VideoLiveMsgSer.findLastLiveMsg(10, liveId, false);
		}else{
			isManager=false;
			msgs = VideoLiveMsgSer.findLastLiveMsg(10, liveId, true);
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
		
		String pushMsg = JsonUtil.createLiveMsgArray(msgs);
		JPushClient client = JPushUtils.getJPush();
		PushPayload msgObj = JPushUtils.createMsg("msg", "studioMsg", pushMsg, null);
		JPushUtils.pushMsg(client, msgObj);
		if(msgs!=null&&msgs.size()>0){
			if(isManager){
				return msgs.get(msgs.size()-1).getId();
			}else{
				return msgs.get(msgs.size()-1).getShenhe();
			}
			
		}else{
			return -1;
		}
	}*/
	
	
	/**
	 * @param uId
	 * @param lId
	 * @param msg
	 * @param toId
	 * @return   发送消息
	 */
	public  String sendMsg(int uId, int sId, String msg, int toId){
		Studio studio=StudioSer.findStudioById(sId);
		int liveId=studio.getVideoLiveId();
		if(liveId<=0){
			return null;
		}
		User fromUser;
		User toUser;
		if(uId>0){
			fromUser=UserServer.findUserChatInfo(uId);
			toUser=UserServer.findUserChatInfo(toId);
			if(toUser==null){
				toUser=new User();
			}
		}else{
			fromUser=new User();
			toUser=new User();
		}
		params.clear();
		params.put("lid", liveId+"");
		params.put("msg", msg);
		params.put("userlevel", fromUser.getUserLeval()+"");
		params.put("isroomadmin", fromUser.getIsRoomAdmin()+"");
		params.put("issysadmin", fromUser.getIsSysAdmin()+"");
		params.put("ischatadmin", fromUser.getIsRoomManager()+"");
		params.put("isserverid",fromUser.getServerId()+"");
		params.put("isshouhuzhe",0+"");
		params.put("isteacher",fromUser.getIsTeacher()+"");
		params.put("buyproductid",fromUser.getBuyProductId()+"");
		params.put("nickName", fromUser.getNickName());
		params.put("userid", uId+"");
		String result=LoginUtil.sendHttpPost(SEND_LIVE_MSG, params);
		JSONObject object=new JSONObject(result);
		boolean isSend=object.getBoolean("IsLogin");
		String Msg=object.getString("Msg");
		if(isSend){
			return JsonUtil.getRetMsg(0, "消息发送成功");
		}else{
			return JsonUtil.getRetMsg(1, Msg);
		}
	}
	
	/**
	 * @param uId
	 * @param lId
	 * @param tId   上线请求消息
	 */
	public  int requestMsg(int uId, int sId){
		Studio studio = StudioSer.findStudioById(sId);
		if(studio==null){
			return -1;
		}
		int liveId=studio.getVideoLiveId();
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
			 isManager=true;
		}else{
			isManager=false;
		}
		params.put("lid", liveId+"");
		params.put("topid", 0+"");
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
				JPushClient client = JPushUtils.getJPush();
				PushPayload msgs = JPushUtils.createMsg("msg", "studioMsg", pushMsg, null);
			    JPushUtils.pushMsg(client, msgs);
			}
			if(msgObjs.size()>0){
				if(isManager){
					return  msgObjs.get(msgObjs.size()-1).getId();
				}else{
					return msgObjs.get(msgObjs.size()-1).getShenhe();
				}
			}
		}
		return 0;
	}

}
