package com.jucaipen.model;

/**
 * @author Administrator
 *
 *  ս��������Ϣ
 */
public class TacticsSale {
	private int page;
	private int totlePage;
	/**
	 *   id
	 */
	private int id;
	/**
	 *  �û�id
	 */
	private int userId;
	/**
	 *   ս��id
	 */
	private int tacticsId;
	
	private String tacticsTitle;
	
	private String tacticeImage;
	
	private String teacherName;
	/**
	 *  �ֻ���
	 */
	private String telPhone;
	/**
	 *   ���ʱ��
	 */
	private String insertDate;
	/**
	 *  ��ʼʱ��
	 */
	private String startDate;
	/**
	 *   ����ʱ��
	 */
	private String endDate;
	/**
	 *   �Ƿ����
	 */
	private int isStop;
	/**
	 *   IP
	 */
	private String ip;
	/**
	 *  ��ע��Ϣ
	 */
	private String remark;
	
	
	public String getTacticsTitle() {
		return tacticsTitle;
	}
	public void setTacticsTitle(String tacticsTitle) {
		this.tacticsTitle = tacticsTitle;
	}
	public String getTacticeImage() {
		return tacticeImage;
	}
	public void setTacticeImage(String tacticeImage) {
		this.tacticeImage = tacticeImage;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTacticsId() {
		return tacticsId;
	}
	public void setTacticsId(int tacticsId) {
		this.tacticsId = tacticsId;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
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
	public int getIsStop() {
		return isStop;
	}
	public void setIsStop(int isStop) {
		this.isStop = isStop;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
