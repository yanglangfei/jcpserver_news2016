package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ���
 *
 */
@SuppressWarnings("serial")
public class FeedBack implements Serializable{
	/**
	 * 
	 */
	private int id;
	/**
	 * �û�id(δ��¼�û�IdΪ0)
	 */
	private int userId;
	/**
	 * ��ʵ����
	 */
	private String trueName;
	/**
	 * ��ϵ�绰
	 */
	private String mobileNum;
	/**
	 * �������
	 */
	private String body;
	/**
	 * ����ʱ��
	 */
	private String insertDate;
	/**
	 * IP��ַ
	 */
	private String ip;
	/**
	 * ״̬���Ѵ���1������δ����2����
	 */
	private int type;
	
	public FeedBack(int id, int userId, String trueName, String mobileNum,
			String body, String insertDate, String ip, int type) {
		this.id = id;
		this.userId = userId;
		this.trueName = trueName;
		this.mobileNum = mobileNum;
		this.body = body;
		this.insertDate = insertDate;
		this.ip = ip;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	

}
