package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ������Ϣʵ����
 *
 */
@SuppressWarnings("serial")
public class MessageObject implements Serializable {
	/**
	 * ��ϢΨһ��ʶ��
	 */
	private String uuId;
	
	/**
	 * ��Ϣid
	 */
	private int msgId;
	/**
	 *  ��Ϣ����   --0 ����   --1 ����   --2����
	 */
	private int msgType;
	/**
	 *   ������Ϣ�û�id
	 */
	private int fromUser;
	/**
	 *  ��������  ---1 ����   ---2˽��
	 */
	private int chatType;
	/**
	 *  ������Ϣ����
	 */
	private String message;
	/**
	 * ������Ϣ�û�id  ---Ĭ��-1 ����
	 */
	private int toUser;
	/**
	 * ������Ϣ�û��ǳ�
	 */
	private String fronName;
	/**
	 *  ������Ϣ�û��ǳ�
	 */
	private String toName;
	/**
	 * ���췿��id
	 */
	private int roomId;
	/**
	 * �Ƿ����
	 */
	private int isCheck;
	/**
	 * ������Ϣʱ��
	 */
	private String sendDate;
	/**
	 * �Ƿ��ǹ���Ա
	 */
	private int isManager;
	/**
	 * �Ƿ��ǿͷ�
	 */
	private int isServer;
	
	
	public String getUuId() {
		return uuId;
	}
	public void setUuId(String uuId) {
		this.uuId = uuId;
	}
	public int getIsServer() {
		return isServer;
	}
	public void setIsServer(int isServer) {
		this.isServer = isServer;
	}
	public int getIsManager() {
		return isManager;
	}
	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(int isCheck) {
		this.isCheck = isCheck;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public MessageObject(int msgType,int fromUser) {
		this.msgType = msgType;
		this.fromUser = fromUser;
	}
	public String getFronName() {
		return fronName;
	}

	public void setFronName(String fronName) {
		this.fronName = fronName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public int getMsgType() {
		return msgType;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
	public int getFromUser() {
		return fromUser;
	}
	public void setFromUser(int fromUser) {
		this.fromUser = fromUser;
	}
	public int getChatType() {
		return chatType;
	}
	public void setChatType(int chatType) {
		this.chatType = chatType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getToUser() {
		return toUser;
	}
	public void setToUser(int toUser) {
		this.toUser = toUser;
	}
	
	

}
