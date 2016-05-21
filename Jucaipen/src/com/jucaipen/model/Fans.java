package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  ---------------新增数据
 *   
 *   粉丝   JCP_Fans
 *   
 */
@SuppressWarnings("serial")
public class Fans implements Serializable{
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
}
