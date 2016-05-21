package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  -----------------新增数据
 *
 *  守护者     JCP_ShouHuZhe
 */
@SuppressWarnings("serial")
public class Guardian implements Serializable{
	/**
	 * 当前页 
	 */
	private int page;
	/**
	 *  总页数
	 */
	private int totlePage;
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  FK_UserId
	 */
	private int userId;
	/**
	 *  FK_TearchId
	 */
	private int teacherId;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 *  Ip
	 */
	private String ip;
	/**
	 *  StartDate
	 */
	private String startDate;
	/**
	 * EndDate 
	 */
	private String endDate;
	/**
	 *  State  0正常，1停止服务，2已删除
	 */
	private int state;
	
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
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
