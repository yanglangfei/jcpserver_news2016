package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  ------------新增数据
 *
 *  返利记录    JCP_Rebate
 */
@SuppressWarnings("serial")
public class Rebate implements Serializable{
	private int page;
	private int totlePage;
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  返利人  FK_TearchId
	 */
	private int teacherId;
	/**
	 *  返利类型（0讲师返利记录，1系统收入记录） RebateType
	 */
	private int type;
	/**
	 *   返利数量 RebateMoney
	 */
	private double rebateMoney;
	/**
	 *  该返利来自于谁  FK_FromUserId
	 */
	private int fromId;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 * Ramerk
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
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getRebateMoney() {
		return rebateMoney;
	}
	public void setRebateMoney(double rebateMoney) {
		this.rebateMoney = rebateMoney;
	}
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
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
}
