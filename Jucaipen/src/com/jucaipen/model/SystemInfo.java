package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   ϵͳ��Ϣ
 */
@SuppressWarnings("serial")
public class SystemInfo implements Serializable {
	/**
	 * ϵͳ��Ϣ��ҳ��
	 */
	private int totlePage;
	/**
	 * ϵͳ��Ϣ��ǰҳ
	 */
	private int page;
	/**
	 * ��Ϣid
	 */
	private int id;
	/**
	 * ��Ϣ������
	 */
	private int receiveId;
	/**
	 * ��Ϣ������
	 */
	private int sendId;   
	/**
	 * ��Ϣ����
	 */
	private String title;
	/**
	 * ��Ϣ����
	 */
	private String bodys;
	/**
	 * ������Ϣʱ��
	 */
	private String sendDate;
	/**
	 * �Ķ���Ϣʱ��
	 */
	private String readDate;
	/**
	 * ��Ϣ����
	 */
	private int type;
	
	public SystemInfo(int id, int receiveId, int sendId, String title,
			String bodys, String sendDate, String readDate, int type) {
		this.id = id;
		this.receiveId = receiveId;
		this.sendId = sendId;
		this.title = title;
		this.bodys = bodys;
		this.sendDate = sendDate;
		this.readDate = readDate;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}
	public int getSendId() {
		return sendId;
	}
	public void setSendId(int sendId) {
		this.sendId = sendId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getReadDate() {
		return readDate;
	}
	public void setReadDate(String readDate) {
		this.readDate = readDate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
	

}
