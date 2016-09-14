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
import com.jucaipen.model.Studio;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLive;
import com.jucaipen.model.VideoLiveMsg;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.StudioSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.timetask.StudioMsgTask;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *         
 *         演播室互动
 */
public class StudioChat extends HttpServlet {
	private static final long serialVersionUID = -3343269386742774065L;
	private Timer timer;
	private boolean isManager;
	//private static final String GET_LIVE_MSG = "http://192.168.1.132/TeacherLive/ashx/VideoLive.ashx?action=GetMsgList";
	//private static final String SEND_LIVE_MSG = "http://192.168.1.132/TeacherLive/ashx/VideoLive.ashx?action=APPSendMsg";

	private static final String GET_LIVE_MSG = "http://www.jucaipen.com/TeacherLive/ashx/VideoLive.ashx?action=GetMsgList";
	private static final String SEND_LIVE_MSG = "http://www.jucaipen.com/TeacherLive/ashx/VideoLive.ashx?action=APPSendMsg";
	private Map<String, String> params = new HashMap<String, String>();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String msgObject = request.getParameter("msgObject");
		if (StringUtil.isNotNull(msgObject)) {
			ChatMsgObject chatMsg = JsonUtil.parseChatMsg(msgObject);
			int userId = chatMsg.getFromId();
			int liveId = chatMsg.getLiveId();
			int opType = chatMsg.getOpType();
			if (opType == 1) {
				// 上线 --推送历史记录
				int maxId = requestMsg(userId, liveId);
				timer = new Timer();
				StudioMsgTask task = new StudioMsgTask(maxId, userId, liveId,
						isManager);
				timer.scheduleAtFixedRate(task, new Date(), 2000);
			} else if (opType == 2) {
				// 聊天
				String msg = chatMsg.getMsg();
				int toId = chatMsg.getToId();
				String result = sendMsg(userId, liveId, msg, toId);
				out.print(result);
			} else {
				// 下线
				if (timer != null) {
					timer.cancel();
					timer = null;
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
	 * @return 发送消息
	 */
	public String sendMsg(int uId, int sId, String msg, int toId) {
		Studio studio = StudioSer.findStudioById(sId);
		int liveId = studio.getVideoLiveId();
		int gurdianId;
		int teacherId=0;
		Guardian fromGuardian=null;
		VideoLive live = VideoLiveServer.getRoomInfo(liveId);
		if(live!=null){
			teacherId=live.getTeacherId();
		}
		if (liveId <= 0) {
			return null;
		}
		User fromUser;
		User toUser;
		if (uId > 0) {
			fromUser = UserServer.findUserChatInfo(uId);
			fromGuardian = GuardianSer.findIsGuardian(teacherId, uId);
			toUser = UserServer.findUserChatInfo(toId);
			if (toUser == null) {
				toUser = new User();
			}
		} else {
			return JsonUtil.getRetMsg(3, "请先登录");
		}
		
		if(fromGuardian!=null){
			gurdianId=fromGuardian.getId();
		}else{
			gurdianId=0;
		}
		params.clear();
		params.put("lid", liveId + "");
		params.put("msg", msg);
		params.put("userlevel", fromUser.getUserLeval() + "");
		params.put("isroomadmin", fromUser.getIsRoomAdmin() + "");
		params.put("issysadmin", fromUser.getIsSysAdmin() + "");
		params.put("ischatadmin", fromUser.getIsRoomManager() + "");
		params.put("isserverid", fromUser.getServerId() + "");
		params.put("isshouhuzhe", gurdianId+ "");
		params.put("isteacher", fromUser.getIsTeacher() + "");
		params.put("buyproductid", fromUser.getBuyProductId() + "");
		params.put("nickName", fromUser.getNickName());
		params.put("userid", uId + "");
		String result = LoginUtil.sendHttpPost(SEND_LIVE_MSG, params);
		JSONObject object = new JSONObject(result);
		boolean isSend = object.getBoolean("IsLogin");
		String Msg = object.getString("Msg");
		if (isSend) {
			return JsonUtil.getRetMsg(0, "消息发送成功");
		} else {
			return JsonUtil.getRetMsg(1, Msg);
		}
	}

	/**
	 * @param uId
	 * @param teacherId 
	 * @param lId
	 * @param tId
	 *            上线请求消息
	 */
	public int requestMsg(int uId, int sId) {
		int serverId=0;
		int teacherId=0;
		Studio studio = StudioSer.findStudioById(sId);
		if (studio == null) {
			return -1;
		}
		int liveId = studio.getVideoLiveId();
		VideoLive live=VideoLiveServer.getRoomInfo(liveId);
		if(live!=null){
		   teacherId=live.getTeacherId();
		}
		params.clear();
		User user;
		if (uId > 0) {
			user = UserServer.findUserChatInfo(uId);
		} else {
			user = new User();
		}
		int isRoomAdmin = user.getIsRoomAdmin();
		int fk_teacherId = user.getFk_roomTeacherId();
		if (isRoomAdmin==1&&teacherId==fk_teacherId) {
			isManager = true;
			serverId=1;
		} else {
			isManager = false;
			serverId=0;
		}
		params.put("lid", liveId + "");
		params.put("Topid", 0 + "");
		params.put("IsServerId", serverId + "");
		String result = LoginUtil.sendHttpPost(GET_LIVE_MSG, params);
		List<VideoLiveMsg> msgObjs = JsonUtil.repCompleMsgObj(result);
		if (msgObjs != null) {
			for (VideoLiveMsg liveMsg : msgObjs) {
				int sendId = liveMsg.getSendUserId();
				int receiverId = liveMsg.getReceiverId();
				User fromUser = UserServer.findBaseInfoById(sendId);
				User toUser = UserServer.findBaseInfoById(receiverId);
				if (fromUser == null) {
					fromUser = new User();
				}
				liveMsg.setSendFace(fromUser.getFaceImage());
				if (toUser == null) {
					toUser = new User();
				}
				liveMsg.setReceiverFace(toUser.getFaceImage());
			}
			String pushMsg = JsonUtil.createLiveMsg(msgObjs,false,uId);
			if (msgObjs.size() > 0 && pushMsg != null) {
				JPushClient client = JPushUtils.getJPush();
				PushPayload msgs = JPushUtils.createMsg("msg", "studioMsg",
						pushMsg, null);
				JPushUtils.pushMsg(client, msgs);
			}
			if (msgObjs.size() > 0) {
				if (isManager) {
					return msgObjs.get(msgObjs.size() - 1).getId();
				} else {
					return msgObjs.get(msgObjs.size() - 1).getShenhe();
				}
			}
		}
		return 0;
	}

}
