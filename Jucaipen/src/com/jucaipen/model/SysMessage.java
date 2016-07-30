package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  -----------------��������
 *
 *  ϵͳ��Ϣ   JCP_Mess
 */
@SuppressWarnings("serial")
public class SysMessage implements Serializable{
	private int page;
	private int totlePage;
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  Title
	 */
	private String title;
	/**
	 *  MessContent
	 */
	private String content;
	/**
	 * ��Ϣ���ͣ�0ϵͳ��Ϣ��1ϵͳ���棩  MessType
	 */
	private int type;
	/**
	 *    ������  FK_SendUserId
	 */
	private int senderId;
	
	/**
	 *   ������Ϣ���ǳ�
	 */
	private String sendName;
	/**
	 *  �ռ���  FK_ReceiveUserId
	 */
	private int receiverId;
	
	/**
	 *  ������Ϣ���ǳ�
	 */
	private String receiverName;
	/**
	 *  SendDate
	 */
	private String sendDate;
	/**
	 *  ReceiveDate
	 */
	private String receiveDate;
	/**
	 *  IsRead  �Ƿ����Ķ���0��1�ǣ�
	 */
	private int isRead;
	
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
}
