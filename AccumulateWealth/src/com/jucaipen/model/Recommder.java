package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  -----------��������
 *
 *  �Ƽ�   JCP_TuiJian
 */
@SuppressWarnings("serial")
public class Recommder implements Serializable{
	private int page;
	private int totlePage;
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  UserId  ���Ƽ���
	 */
	private int userId;
	
	/**
	 *   ���Ƽ�������
	 */
	private String userName;
	
	/**
	 *   ���Ƽ����ֻ���
	 */
	private String userPhone;
	
	/**
	 *  ���Ƽ���ͷ��
	 */
	private String userFace;
	/**
	 *  �Ƽ���  ParentUserId
	 */
	private int parentUserId;
	
	
	/**
	 *  InsertDate  
	 */
	private String insertDate;
	/**
	 *  Remark
	 */
	private String remsrk;
	/**
	 *  Type  �Ƽ��û���0�Ƽ���ͨ�û���1�Ƽ���ʦ��
	 */
	private int type;
	/**
	 *  Integral  ������ֽ���
	 */
	private int Integral;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserFace() {
		return userFace;
	}
	public void setUserFace(String userFace) {
		this.userFace = userFace;
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
	public int getParentUserId() {
		return parentUserId;
	}
	public void setParentUserId(int parentUserId) {
		this.parentUserId = parentUserId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getRemsrk() {
		return remsrk;
	}
	public void setRemsrk(String remsrk) {
		this.remsrk = remsrk;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIntegral() {
		return Integral;
	}
	public void setIntegral(int integral) {
		Integral = integral;
	}

}
