package com.jucaipen.model;

/**
 * @author Administrator
 *
 *  //   opType    1   上线       2    聊天      3   下线
	// {"fromId":1,"liveId:1","opType":2,"toId":0,msg:"hello"}
 */
public class ChatMsgObject {
	private int fromId;
	private int liveId;
	private int opType;
	private int toId;
	private String msg;
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public int getLiveId() {
		return liveId;
	}
	public void setLiveId(int liveId) {
		this.liveId = liveId;
	}
	public int getOpType() {
		return opType;
	}
	public void setOpType(int opType) {
		this.opType = opType;
	}
	public int getToId() {
		return toId;
	}
	public void setToId(int toId) {
		this.toId = toId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
