package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  -----------新增数据
 *
 *  推荐   JCP_TuiJian
 */
@SuppressWarnings("serial")
public class Recommder implements Serializable{
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  UserId
	 */
	private int userId;
	/**
	 *  推荐人  ParentUserId
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
	 *  Type  推荐用户（0推荐普通用户，1推荐讲师）
	 */
	private int type;
	/**
	 *  Integral  所获积分奖励
	 */
	private int Integral;
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
