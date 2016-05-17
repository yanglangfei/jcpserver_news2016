package com.jucaipen.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ylf
 * 
 *   ϵͳ��Ϣ�Ķ�
 *
 */
@SuppressWarnings("serial")
public class ReadInfo implements Serializable {
	/**
	 * ��ȡ��Ϣ��ǰҳ
	 */
	private int pager;
	/**
	 * ��ȡ��Ϣ��ҳ��
	 */
	private int totlePager;
	/**
	 * ��ȡ��Ϣid
	 */
	private int id;
	/**
	 * ��ȡ��Ϣ�û�id
	 */
	private int uId;
	/**
	 * ��ȡ��Ϣid
	 */
	private int messageId;
	/**
	 * ��ȡ��Ϣʱ��
	 */
	private Date readDate;
	
	public ReadInfo(int id, int uId, int messageId, Date readDate) {
		this.id = id;
		this.uId = uId;
		this.messageId = messageId;
		this.readDate = readDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public Date getReadDate() {
		return readDate;
	}
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
	}
	public int getTotlePager() {
		return totlePager;
	}
	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	
	

}
