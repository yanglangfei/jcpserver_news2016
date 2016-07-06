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
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLiveMsg;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveMsgSer;
import com.jucaipen.timetask.VideoLiveMsgTask;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;
/**
 * @author Administrator
 *   直播聊天室
 */
@SuppressWarnings("serial")
public class LiveChat extends HttpServlet {
	private String ip;
	private Timer timer;
	private boolean isManager;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ip=request.getRemoteAddr();
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
					VideoLiveMsgTask task=new VideoLiveMsgTask(maxId,userId,liveId,isManager);
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
	
	
	/**
	 * @param uId
	 * @param lId 
	 *    获取聊天信息
	 */
	private int  requestChatMsg(int uId, int lId) {
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
			isManager=true;
			 msgs = VideoLiveMsgSer.findLastLiveMsg(10, lId, false);
		}else{
			isManager=false;
			msgs = VideoLiveMsgSer.findLastLiveMsg(10, lId, true);
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
		PushPayload msgObj = JPushUtils.createMsg("msg", "liveMsg", pushMsg, null);
		JPushUtils.pushMsg(client, msgObj);
		if(msgs!=null&&msgs.size()>0){
			if(isManager){
				return msgs.get(msgs.size()-1).getId();
			}else{
				return msgs.get(msgs.size()-1).getShenhe();
			}
			
		}else{
			return 0;
		}
	}
	
	
	
	/**
	 * @param uId
	 * @param lId
	 * @param msg
	 * @param toId   用户发送消息
	 */
	public String sendChatMsg(int uId, int lId, String msg, int toId){
		User fromUser;
		User toUser;
		if(uId>0){
			fromUser=UserServer.findUserChatInfo(uId);
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
		msgObj.setSendUserId(uId);
		msgObj.setShenhe(0);
		msgObj.setUserLeavel(leavel);
		msgObj.setVideoLiveId(lId);
		int isSuccess = VideoLiveMsgSer.addMsg(msgObj);
		return isSuccess==1 ?JsonUtil.getRetMsg(0, "消息发送成功") : JsonUtil.getRetMsg(1,"消息发送失败");
		
	}

}
