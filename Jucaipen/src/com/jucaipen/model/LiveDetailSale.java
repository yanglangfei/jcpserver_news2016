package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator   ------------------------新增数据
 *
 *   购买文字直播信息   JCP_LiveDetailSale
 */
@SuppressWarnings("serial")
public class LiveDetailSale implements Serializable{
	private int page;
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
	 * 所属讲师  FK_TearchId
	 */
	private int teacherId;
	/**
	 *  订单编号  OrderCode
	 */
	private String orderCode;
	/**
	 *   直播观点id  FK_LiveDetailId
	 */
	private int liveDetailId;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	
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
	public int getLiveDetailId() {
		return liveDetailId;
	}
	public void setLiveDetailId(int liveDetailId) {
		this.liveDetailId = liveDetailId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

}
