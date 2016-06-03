package com.jucaipen.model;

/**
 * @author Administrator   ----------��������
 *
 *   �˻���ϸ��Ϣ
 */
public class AccountDetail {
	private int page;
	private int totlePage;
	/**
	 *  id
	 */
	private int id;
	/**
	 * �������
	 */
	private String orderCode;
	/**
	 *  ���ѻ�֧�����
	 */
	private double detailMoney;
	/**
	 * �������� 0���룬1����
	 */
	private int detailType;
	/**
	 * 0��1���֣�2�۲Ʊ�
	 */
	private int state;
	/**
	 *  ��ע
	 */
	private String remark;
	/**
	 * ���ʱ��
	 */
	private String insertDate;
	/**
	 * 0������1��ɾ��
	 */
	private int isDel;
	/**
	 *  �û�id
	 */
	private int userId;
	
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
	
	
	public AccountDetail() {
		
	}
	public AccountDetail(int id, String orderCode, double detailMoney,
			int detailType, int state, String remark, String insertDate,
			int isDel, int userId) {
		this.id = id;
		this.orderCode = orderCode;
		this.detailMoney = detailMoney;
		this.detailType = detailType;
		this.state = state;
		this.remark = remark;
		this.insertDate = insertDate;
		this.isDel = isDel;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public double getDetailMoney() {
		return detailMoney;
	}
	public void setDetailMoney(double detailMoney) {
		this.detailMoney = detailMoney;
	}
	public int getDetailType() {
		return detailType;
	}
	public void setDetailType(int detailType) {
		this.detailType = detailType;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
