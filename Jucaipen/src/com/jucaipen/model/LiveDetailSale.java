package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator   ------------------------��������
 *
 *   ��������ֱ����Ϣ   JCP_LiveDetailSale
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
	 * ������ʦ  FK_TearchId
	 */
	private int teacherId;
	
	/**
	 *  ֱ��������ʦ
	 */
	private String ownTeacher;
	/**
	 *  �������  OrderCode
	 */
	private String orderCode;
	/**
	 *   ֱ���۵�id  FK_LiveDetailId
	 */
	private int liveDetailId;
	
	private String fk_txtTitle;
	
	/**
	 *  ֱ������
	 */
	private String detailBody;
	
	/**
	 *  InsertDate
	 */
	private String insertDate;
	
	public String getFk_txtTitle() {
		return fk_txtTitle;
	}
	public void setFk_txtTitle(String fk_txtTitle) {
		this.fk_txtTitle = fk_txtTitle;
	}
	public String getOwnTeacher() {
		return ownTeacher;
	}
	public void setOwnTeacher(String ownTeacher) {
		this.ownTeacher = ownTeacher;
	}
	public String getDetailBody() {
		return detailBody;
	}
	public void setDetailBody(String detailBody) {
		this.detailBody = detailBody;
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
