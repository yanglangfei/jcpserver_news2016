package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *   文字直播购买信息
 */
@SuppressWarnings("serial")
public class TxtLiveSale implements Serializable{
	private int page;
	private int totlePage;
	private int id;
	private int userId;
	private int teacherId;
	private String teacherName;
	private String fk_title;
	private String orderCode;
	private int fk_txtId;
	private String insertDate;
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getFk_title() {
		return fk_title;
	}
	public void setFk_title(String fk_title) {
		this.fk_title = fk_title;
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
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getFk_txtId() {
		return fk_txtId;
	}
	public void setFk_txtId(int fk_txtId) {
		this.fk_txtId = fk_txtId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
}
