package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ������Ϣ
 *
 */
@SuppressWarnings("serial")
public class ChatMessage implements Serializable{
	
	/**
	 *  ������Ϣid
	 */
	private int id;
	/**
	 * ������Ϣ����
	 */
	private String messageBody;
	/**
	 *  ������Ϣ��id
	 */
	private int senderId;
	/**
	 * ������Ϣ��id
	 */
	private int receiverId;
	/**
	 * ������Ϣ������
	 */
	private String senderName;
	/**
	 * ������Ϣ������
	 */
	private String receiverName;
	/**
	 * ������Ϣʱ��
	 */
	private String sendDate;
	/**
	 * �Ƿ����
	 */
	private int isCheck;
	/**
	 * ������id
	 */
	private int roomId;
	/**
	 * ������Ʒid
	 */
	private int buyProductId;
	private int receiverBuyId;
	private int receiveManager;
	private int sendManager;
	private int sendServerId;
	private int receiverServerId;
	/**
	 * ��Ϣ����
	 */
	private int messageType;
	
	public ChatMessage() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
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
	public int getBuyProductId() {
		return buyProductId;
	}
	public void setBuyProductId(int buyProductId) {
		this.buyProductId = buyProductId;
	}
	public int getReceiverBuyId() {
		return receiverBuyId;
	}
	public void setReceiverBuyId(int receiverBuyId) {
		this.receiverBuyId = receiverBuyId;
	}
	public int getReceiveManager() {
		return receiveManager;
	}
	public void setReceiveManager(int receiveManager) {
		this.receiveManager = receiveManager;
	}
	public int getSendManager() {
		return sendManager;
	}
	public void setSendManager(int sendManager) {
		this.sendManager = sendManager;
	}
	public int getSendServerId() {
		return sendServerId;
	}
	public void setSendServerId(int sendServerId) {
		this.sendServerId = sendServerId;
	}
	public int getReceiverServerId() {
		return receiverServerId;
	}
	public void setReceiverServerId(int receiverServerId) {
		this.receiverServerId = receiverServerId;
	}
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	
	

}
