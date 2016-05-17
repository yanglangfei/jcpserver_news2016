package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *  ǩԼ
 */
@SuppressWarnings("serial")
public class Signing implements Serializable{
	/**
	 * ǩԼid
	 */
	private int id;
	/**
	 * ǩԼ�û�id
	 */
	private int userId;
	/**
	 * ǩԼ��ʦid
	 */
	private int teacherId;
	/**
	 * ��ʵ����
	 */
	private String trueName;
	/**
	 * ��ϵ��ʽ
	 */
	private String mobileNum;
	/**
	 * ǩԼʱ��
	 */
	private String insertDate;
	/**
	 * ��ʼʱ��
	 */
	private String startDate;
	/**
	 * ����ʱ��
	 */
	private String endDate;
	/**
	 * ȯ������
	 */
	private String QSName;
	/**
	 * �Ƿ���Ч��0��ʾδ��Ч��1��ʾ��Ч,2��ʾֹͣ����
	 */
	private int state;
	/**
	 * IP��ַ
	 */
	private String ip;
	/**
	 * ��Դ��1:PC��2���ֻ���ҳ��3��App��
	 */
	private int comeType;
	
	public Signing(int id, int userId, int teacherId, String trueName,
			String mobileNum, String insertDate, String qSName, int state, String ip, int comeType) {
		this.id = id;
		this.userId = userId;
		this.teacherId = teacherId;
		this.trueName = trueName;
		this.mobileNum = mobileNum;
		this.insertDate = insertDate;
		QSName = qSName;
		this.state = state;
		this.ip = ip;
		this.comeType = comeType;
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
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getQSName() {
		return QSName;
	}
	public void setQSName(String qSName) {
		QSName = qSName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getComeType() {
		return comeType;
	}
	public void setComeType(int comeType) {
		this.comeType = comeType;
	}
	

}
