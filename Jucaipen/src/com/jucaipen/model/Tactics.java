package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *  ս��
 */
@SuppressWarnings("serial")
public class Tactics implements Serializable{
	private int page;
	private int totlePage;
	/**
	 *  id 
	 */
	private int id;
	/**
	 *  ����
	 */
	private String title;
	/**
	 *  ����
	 */
	private String desc;
	/**
	 *  ��������
	 */
	private int orderNum;
	/**
	 *  ����ͼƬ
	 */
	private String imageUrl;
	/**
	 *  ��ʦid
	 */
	private int teacherId;
	/**
	 *  ���ʱ��
	 */
	private String insertDate;
	/**
	 * �Ƿ�һ�긶�� 0�� 1��
	 */
	private int isYear;
	/**
	 * �Ƿ�1�¸��� 0�� 1��
	 */
	private int isMoth;
	/**
	 *  ÿ�����
	 */
	private double yearMoney;
	/**
	 *  ÿ�·���
	 */
	private double mothMoney;
	/**
	 *  �Ƿ�ɾ�� 0���� 1ɾ��
	 */
	private int isDel;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getIsYear() {
		return isYear;
	}
	public void setIsYear(int isYear) {
		this.isYear = isYear;
	}
	public int getIsMoth() {
		return isMoth;
	}
	public void setIsMoth(int isMoth) {
		this.isMoth = isMoth;
	}
	public double getYearMoney() {
		return yearMoney;
	}
	public void setYearMoney(double yearMoney) {
		this.yearMoney = yearMoney;
	}
	public double getMothMoney() {
		return mothMoney;
	}
	public void setMothMoney(double mothMoney) {
		this.mothMoney = mothMoney;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
}
