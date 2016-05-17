package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF
 * 
 *   ��Ʒ
 *
 */
@SuppressWarnings("serial")
public class Product implements Serializable{
	/**
	 * ��Ʒ��Ϣ��ǰҳ
	 */
	private int pager;
	/**
	 * ��Ʒ��Ϣ��ҳ��
	 */
	private int totlePager;
	/**
	 * ��Ʒid
	 */
	private int id;
	/**
	 * ��Ʒ����
	 */
	private String productTitle;
	/**
	 * ��Ʒԭ��
	 */
	private String price;
	/**
	 * �ּ�
	 */
	private String nowPrice;
	
	/**
	 *  ��ʦID   ��ʦId(����0ʱ���ò�ƷΪϵͳ��Ʒ��������ĳ����ʦ�Ĳ�Ʒ)
	 */
	private int tearchId;
	/**
	 *   ��Ʒ���ͣ�1��һ�������ۣ�2����Լ�����ۣ�
	 */
	private int types;
	/**
	 * ���ֶ�Ϊ��Լ�Բ�Ʒר���ֶΣ�ֵΪ��Լ������
	 */
	private int xuYueYear;
	/**
	 * ���ֶ�Ϊ��Լ�Բ�Ʒר���ֶΣ�ֵΪ��Լ������
	 */
	private int xuYueMonth;
	/**
	 *  ���ֶ�Ϊ��Լ�Բ�Ʒר���ֶΣ�ֵΪ��Լ������
	 */
	private int xuYueDay;
	/**
	 * ����״̬��1���������ۣ�2����ͣ���ۣ�
	 */
	private int saleType;
	/**
	 * ��Ʒ״̬��1��������4��ɾ����
	 */
	private int isDelete;
	/**
	 *   ����
	 */
	private int pxId;
	public Product(int pager, int totlePager, int id, String productTitle,
			String price, String nowPrice, int tearchId, int types,
			int xuYueYear, int xuYueMonth, int xuYueDay, int saleType,
			int isDelete, int pxId) {
		super();
		this.pager = pager;
		this.totlePager = totlePager;
		this.id = id;
		this.productTitle = productTitle;
		this.price = price;
		this.nowPrice = nowPrice;
		this.tearchId = tearchId;
		this.types = types;
		this.xuYueYear = xuYueYear;
		this.xuYueMonth = xuYueMonth;
		this.xuYueDay = xuYueDay;
		this.saleType = saleType;
		this.isDelete = isDelete;
		this.pxId = pxId;
	}
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
	}
	public int getTotlePager() {
		return totlePager;
	}
	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
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
	public int getTearchId() {
		return tearchId;
	}
	public void setTearchId(int tearchId) {
		this.tearchId = tearchId;
	}
	public int getTypes() {
		return types;
	}
	public void setTypes(int types) {
		this.types = types;
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
	public int getSaleType() {
		return saleType;
	}
	public void setSaleType(int saleType) {
		this.saleType = saleType;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public int getPxId() {
		return pxId;
	}
	public void setPxId(int pxId) {
		this.pxId = pxId;
	}
	

	

}
