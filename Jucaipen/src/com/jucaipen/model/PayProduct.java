package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ��Ʒ������ϸ��Ϣ
 *
 */
@SuppressWarnings("serial")
public class PayProduct implements Serializable{
	/**
	 * ��ǰҳ��
	 */
	private int page;
	/**
	 * ��ҳ��
	 */
	private int totlePage;
	/**
	 * id 
	 */
	private int id;
	/**
	 *  ����ID
	 */
	private String orderId;
	/**
	 *   ��ƷID 
	 */
	private int productId;
	/**
	 * ԭ��
	 */
	private String price;
	/**
	 * �ּ�
	 */
	private String nowPrice;
	/**
	 *   ��������
	 */
	private int buyCount;
	/**
	 *   �ܽ��
	 */
	private String allMoney;
	/**
	 *  ��Ʒ����
	 */
	private String productTitle;
	/**
	 * ���ֶ�Ϊ��Լ�Բ�Ʒר���ֶΣ�ֵΪ��Լ������
	 */
	private int xuYueYear;
	/**
	 * ���ֶ�Ϊ��Լ�Բ�Ʒר���ֶΣ�ֵΪ��Լ������
	 */
	private int xuYueMonth;
	/**
	 * ���ֶ�Ϊ��Լ�Բ�Ʒר���ֶΣ�ֵΪ��Լ������
	 */
	private int xuYueDay;
	/**
	 * 
	 */
	private int productType;
	/**
	 * �û�ID
	 */
	private int userId;
	/**
	 * ��Ʒ״̬��1��������4��ɾ����
	 */
	private int isDelete;
	public PayProduct() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public String getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public int getXuYueYear() {
		return xuYueYear;
	}
	public void setXuYueYear(int xuYueYear) {
		this.xuYueYear = xuYueYear;
	}
	public int getXuYueMonth() {
		return xuYueMonth;
	}
	public void setXuYueMonth(int xuYueMonth) {
		this.xuYueMonth = xuYueMonth;
	}
	public int getXuYueDay() {
		return xuYueDay;
	}
	public void setXuYueDay(int xuYueDay) {
		this.xuYueDay = xuYueDay;
	}
	public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
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

	

}
