package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF         ----------------------�����Ѹ���
 * 
 *    ������Ϣ
 *
 */
@SuppressWarnings("serial")
public class MailMessage implements Serializable{
	/**
	 * ��Ϣid
	 */
	private int id;
	/**
	 * �����ַ
	 */
	private String email;
	/**
	 * ������
	 */
	private String actionCode;
	/**
	 * ��Ϣ����
	 */
	private String messageContent;
	/**
	 * ״̬:(1��δ��֤��2������֤��3����ʧЧ��4��ɾ��)
	 */
	private int msgType;
	/**
	 * ����ʱ��
	 */
	private String sendDate;
	/**
	 * ��֤ʱ��
	 */
	private String checkDate;
	/**
	 * �û�id
	 */
	private int userId;
	
	public MailMessage() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getActionCode() {
		return actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public int getMsgType() {
		return msgType;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
