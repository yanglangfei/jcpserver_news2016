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
import com.jucaipen.model.Guardian;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLiveMsg;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.timetask.VideoLiveMsgTask;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 *   直播聊天室
 */
@SuppressWarnings("serial")
public class LiveChat extends HttpServlet {
	private static final String GET_LIVE_MSG="http://www.jucaipen.com/TeacherLive/ashx/VideoLive.ashx?action=GetMsgList";
	private static final String SEND_LIVE_MSG="http://www.jucaipen.com/TeacherLive/ashx/VideoLive.ashx?action=APPSendMsg";
	private  Map<String, String> params=new HashMap<String, String>();
	private Timer timer;
	private boolean isManager;
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
			int teacherId=chatMsg.getTeacherId();
				int opType=chatMsg.getOpType();
				if(opType==1){
					//上线   --推送历史记录
					int maxId=requestMsg(userId, liveId);
					timer = new Timer();
					VideoLiveMsgTask task=new VideoLiveMsgTask(maxId,userId,liveId,isManager);
					timer.scheduleAtFixedRate(task, new Date(), 2000);
				}else if(opType==2){
					//聊天
					String msg=chatMsg.getMsg();
					int toId=chatMsg.getToId();
					String result=sendMsg(userId, liveId, msg, teacherId, toId);
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
	
	
	/**
	 * @param uId
	 * @param lId
	 * @param msg
	 * @param toId
	 * @return   发送消息
	 */
	public  String sendMsg(int uId, int lId, String msg,int tId, int toId){
		int gurdianId;
		User fromUser;
		User toUser;
		Guardian fromGuardian = null;
		if(uId>0){
			fromUser=UserServer.findUserChatInfo(uId);
			fromGuardian = GuardianSer.findIsGuardian(tId, uId);
			toUser=UserServer.findUserChatInfo(toId);
			if(toUser==null){
				toUser=new User();
			}
		}else{
			fromUser=new User();
			toUser=new User();
		}
		if(fromGuardian!=null){
			gurdianId=fromGuardian.getId();
		}else{
			gurdianId=0;
		}
		params.clear();
		params.put("lid", lId+"");
		params.put("msg", msg);
		params.put("userlevel", fromUser.getUserLeval()+"");
		params.put("isroomadmin", fromUser.getIsRoomAdmin()+"");
		params.put("issysadmin", fromUser.getIsSysAdmin()+"");
		params.put("ischatadmin", fromUser.getIsRoomManager()+"");
		params.put("isserverid",fromUser.getServerId()+"");
		params.put("isshouhuzhe",gurdianId+"");
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
	public  int requestMsg(int uId, int lId){
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
		params.clear();
		params.put("lid", lId+"");
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
			JPushClient client = JPushUtils.getJPush();
			PushPayload msgs = JPushUtils.createMsg("msg", "liveMsg", pushMsg, null);
		    JPushUtils.pushMsg(client, msgs);
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
