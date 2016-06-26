package com.jucaipen.timetask;

import java.util.List;
import java.util.TimerTask;
import cn.jpush.api.JPushClient;
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

	public TxtChatMsgTask(int maxId, int userId, int liveId) {
		this.maxId=maxId;
		this.userId=userId;
		this.liveId=liveId;
	}

	@Override
	public void run() {
		checkMsg(maxId, liveId, userId);
	}

	private void checkMsg(int mId, int lId, int uId) {
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
			 msgs = TxtMsgSer.findTxtMsgByMaxId(mId, liveId, false);
		}else{
			msgs = TxtMsgSer.findTxtMsgByMaxId(mId, liveId, true);
		}
		if(msgs!=null&&msgs.size()>0){
			String pushMsg = JsonUtil.createTxtMsgArray(msgs);
			JPushClient client = JPushUtils.getJPush();
			PushPayload msgObj = JPushUtils.createMsg("alert", "≤‚ ‘œ˚œ¢", pushMsg, null);
			JPushUtils.pushMsg(client, msgObj);
			maxId= msgs.get(msgs.size()-1).getId();
		}
	}

}
