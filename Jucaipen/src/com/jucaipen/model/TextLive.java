package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ����ֱ����Ϣ              -----------------------�����Ѹ���     5.18
 *
 */
@SuppressWarnings("serial")
public class TextLive implements Serializable{
	/**
	 * ����ֱ����ǰҳ��
	 */
	private int page;
	/**
	 *  ����ֱ����ҳ��
	 */
	private int totlePage;
	private boolean isCharge;
	
	private int txtPrice;
	
	private int isPurch;
	/**
	 * ֱ��id
	 */
	private int id;
	/**
	 * ֱ������
	 */
	private String title;
	/**
	 * ��ʼʱ��
	 */
	private String startDate;
	/**
	 * ����ʱ��
	 */
	private String endDate;
	/**
	 * ��������
	 */
	private int goods;
	/**
	 * 
	 */
	private int hits;
	/**
	 *  ��������
	 */
	private int xnHits;
	/**
	 * ��ʦid
	 */
	private int teacherId;
	/**
	 * �Ƿ������1δ��ʼ��2�����У�3�ѽ�����   
	 */
	private int isEnd;
	
	
	
	public boolean isCharge() {
		return isCharge;
	}
	public void setCharge(boolean isCharge) {
		this.isCharge = isCharge;
	}
	public int getTxtPrice() {
		return txtPrice;
	}
	public void setTxtPrice(int txtPrice) {
		this.txtPrice = txtPrice;
	}
	public int getIsPurch() {
		return isPurch;
	}
	public void setIsPurch(int isPurch) {
		this.isPurch = isPurch;
	}
	public int getXnHits() {
		return xnHits;
	}
	public void setXnHits(int xnHits) {
		this.xnHits = xnHits;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
	}

}
