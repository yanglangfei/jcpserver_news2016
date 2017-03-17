package com.jucaipen.timetask;

import java.util.List;
import java.util.TimerTask;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

import com.jucaipen.model.TxtLiveMsg;
import com.jucaipen.model.User;
import com.jucaipen.service.TxtMsgSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;

public class TxtChatMsgTask extends TimerTask{
	private int maxId;
	private int userId;
	private int liveId;
	private boolean isManager;
	private int msgType;
	private PushPayload msgObj;

	public TxtChatMsgTask(int maxId, int userId, int liveId,boolean isManager,int msgType) {
		this.maxId=maxId;
		this.userId=userId;
		this.liveId=liveId;
		this.isManager=isManager;
		this.msgType=msgType;
	}

	@Override
	public void run() {
		checkMsg(maxId, liveId, userId,isManager,msgType);
	}

	private void checkMsg(int mId, int lId, int uId,boolean isM, int type) {
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
			isM=true;
			 msgs = TxtMsgSer.findTxtMsgByMaxId(mId, liveId, false,type);
		}else{
			isM=false;
			msgs = TxtMsgSer.findTxtMsgByMaxId(mId, liveId, true,type);
		}
		
		if (msgs != null&&msgs.size()>0) {
			for (TxtLiveMsg m : msgs) {
				int senId = m.getUserId();
				int toId = m.getReceiverId();
				User fu = UserServer.findBaseInfoById(senId);
				if (fu == null) {
					fu = new User();
				}
				m.setSendFace(fu.getFaceImage());
				User tu = UserServer.findBaseInfoById(toId);
				if (tu == null) {
					tu = new User();
				}
				m.setReceiverFace(tu.getFaceImage());
				m.setUserName(fu.getNickName());
				m.setReceiverName(fu.getNickName());
				m.setUserLeavel(fu.getUserLeval());
			}
			String pushMsg = JsonUtil.createTxtMsgArray(msgs);
			JPushClient client = JPushUtils.getJPush();
			if(type==0){
				msgObj = JPushUtils.createMsg("msg", "qiaoqiao", pushMsg, null);
			}else{
				msgObj = JPushUtils.createMsg("msg", "txtMsg", pushMsg, null);
			}
			PushResult res = JPushUtils.pushMsg(client, msgObj);
			System.out.println("msg:"+pushMsg);
			System.out.println("res:"+res.toString());
			if(isM){
				maxId= msgs.get(msgs.size()-1).getId();
			}else{
				maxId=msgs.get(msgs.size()-1).getShenhe();
			}
		}
	}

}
