package com.jucaipen.main.live;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.PushPayload;
import com.jucaipen.model.ChatMsgObject;
import com.jucaipen.model.TxtLiveMsg;
import com.jucaipen.model.User;
import com.jucaipen.service.TxtMsgSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.timetask.TxtChatMsgTask;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 *
 *  文字直播互动
 */
@SuppressWarnings("serial")
public class TxtChat extends HttpServlet {
	private boolean isManager;
	private String ip;
	private Timer timer;
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
					int maxId=requestChatMsg(userId,liveId);
					timer = new Timer();
					TxtChatMsgTask task=new TxtChatMsgTask(maxId,userId,liveId,isManager);
					timer.scheduleAtFixedRate(task, new Date(), 2000);
				}else if(opType==2){
					//聊天
					String msg=chatMsg.getMsg();
					int toId=chatMsg.getToId();
					String result = sendChatMsg(userId, liveId,msg,toId);
					out.print(result);
				}else{
					//下线
					if(timer!=null){
						timer.cancel();
					}
				}
		}
		out.flush();
		out.close();
	}
	private String sendChatMsg(int userId, int liveId, String msg, int toId) {
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
		int isSysAdmin=fromUser.getIsSysAdmin();
		TxtLiveMsg msgObj=new TxtLiveMsg();
		msgObj.setIp(ip);
		msgObj.setIsRoomAdmin(isRoomAdmin);
		msgObj.setIsSysAdmin(isSysAdmin);
		msgObj.setMessBody(msg);
		msgObj.setReceiverId(toId);
		msgObj.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		msgObj.setSendFace(fromUser.getFaceImage());
		msgObj.setUserId(userId);
		msgObj.setShenhe(0);
		msgObj.setTxtLiveId(liveId);
		int isSuccess = TxtMsgSer.addMsg(msgObj);
		return isSuccess==1 ?JsonUtil.getRetMsg(0, "消息发送成功") : JsonUtil.getRetMsg(1,"消息发送失败");
		
	}
	
	
	private int requestChatMsg(int userId, int liveId) {
		List<TxtLiveMsg> msgs;
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
			 msgs = TxtMsgSer.findLastTxtMsg(10, liveId, false);
		}else{
			isManager=false;
			msgs = TxtMsgSer.findLastTxtMsg(10, liveId, true);
		}
		if(msgs!=null){
			for(TxtLiveMsg m : msgs){
				int senId=m.getUserId();
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
				m.setUserName(fu.getUserName());
				m.setReceiverName(fu.getUserName());
				m.setUserLeavel(fu.getUserLeval());
			}
		}
		
		String pushMsg = JsonUtil.createTxtMsgArray(msgs);
		JPushClient client = JPushUtils.getJPush();
		PushPayload msgObj = JPushUtils.createMsg("msg", "txtMsg", pushMsg, null);
		JPushUtils.pushMsg(client, msgObj);
		System.out.println(pushMsg);
		if(msgs!=null&&msgs.size()>0){
			if(isManager){
				return msgs.get(msgs.size()-1).getId();
			}else{
				return msgs.get(msgs.size()-1).getShenhe();
			}
		}else{
			return -1;
		}}

}
