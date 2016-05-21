package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  ---------------新增数据
 *
 *   我的专辑     JCP_MySpecial  (购买记录)
 */
@SuppressWarnings("serial")
public class MySpecial implements Serializable{
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  购买专辑用户id  FK_UserId
	 */
	private int userId;
	/**
	 *  专辑id  FK_SpecialId
	 */
	private int specialId;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 *  Remark
	 */
	private String remark;
	/**
	 *  是否删除（0否，1是） IsDel
	 */
	private int isDel;
	/**
	 *  是否停止(0否，1是)  IsStop
	 */
	private int isStop;
	/**
	 *  StartDate
	 */
	private String startDate;
	/**
	 *  EndDate
	 */
	private String endDate;
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
	public int getSpecialId() {
		return specialId;
	}
	public void setSpecialId(int specialId) {
		this.specialId = specialId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getIsStop() {
		return isStop;
	}
	public void setIsStop(int isStop) {
		this.isStop = isStop;
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
}
