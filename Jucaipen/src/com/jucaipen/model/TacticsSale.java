package com.jucaipen.model;

/**
 * @author Administrator
 *
 *  战法销售信息
 */
public class TacticsSale {
	private int page;
	private int totlePage;
	/**
	 *   id
	 */
	private int id;
	/**
	 *  用户id
	 */
	private int userId;
	/**
	 *   讲师id
	 */
	private int tacticsId;
	/**
	 *  手机号
	 */
	private String telPhone;
	/**
	 *   添加时间
	 */
	private String insertDate;
	/**
	 *  开始时间
	 */
	private String startDate;
	/**
	 *   结束时间
	 */
	private String endDate;
	/**
	 *   是否结束
	 */
	private int isStop;
	/**
	 *   IP
	 */
	private String ip;
	/**
	 *  备注信息
	 */
	private String remark;
	
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
