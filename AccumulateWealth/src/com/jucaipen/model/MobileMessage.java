package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF    ---------�����Ѹ���
 * 
 *   ������Ϣ
 *
 */
@SuppressWarnings("serial")
public class MobileMessage implements Serializable{
	/**
	 *  ����id
	 */
	private int id;
	/**
	 *  ���͵��ֻ���
	 */
	private String telPhone;
	/**
	 * ������
	 */
	private String actionCode;
	/**
	 *  ��������
	 */
	private String messageContent;
	/**
	 *  ����ʱ��
	 */
	private String sendDate;
	/**
	 *  �����豸   1 ��վ    2 APP
	 */
	private int sendDev;
	/**
	 *  ��������     1  --δ��֤     2  ---����֤     3  ---ʧЧ     4  ---ɾ��
	 */
	private int msgType;
	/**
	 * ��֤ʱ��
	 */
	private String checkDate;
	/**
	 * ��Ӧʱ��
	 */
	private String resptime;
	/**
	 * ��Ӧ״̬
	 */
	private int respstatus;
	/**
	 * ������Ϣid
	 */
	private String msgid;
	/**
	 * ����ip
	 */
	private String SendIp;
	/**
	 * ��ע
	 */
	private String remark;
	
	public MobileMessage() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
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
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public int getSendDev() {
		return sendDev;
	}
	public void setSendDev(int sendDev) {
		this.sendDev = sendDev;
	}
	public int getMsgType() {
		return msgType;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getResptime() {
		return resptime;
	}
	public void setResptime(String resptime) {
		this.resptime = resptime;
	}
	public int getRespstatus() {
		return respstatus;
	}
	public void setRespstatus(int respstatus) {
		this.respstatus = respstatus;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getSendIp() {
		return SendIp;
	}
	public void setSendIp(String sendIp) {
		SendIp = sendIp;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
