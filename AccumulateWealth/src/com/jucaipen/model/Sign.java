package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  ----------------��������
 *
 *   ǩ��   JCP_QianDao
 */
@SuppressWarnings("serial")
public class Sign implements Serializable{
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  UserId
	 */
	private int userId;
	/**
	 *  ���ǩ��ʱ��  LastDate
	 */
	private String lastDate;
	/**
	 *  Ip
	 */
	private String ip;
	/**
	 *  ǩ������  QDCount
	 */
	private int signNum;
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
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getSignNum() {
		return signNum;
	}
	public void setSignNum(int signNum) {
		this.signNum = signNum;
	}
}
