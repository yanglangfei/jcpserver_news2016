package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *
 *  ���ҿ��� TextLive
 */
@SuppressWarnings("serial")
public class ReadTape implements Serializable{
	/**
	 * id
	 */
	private int id;
	/**
	 * ����
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
	 * ������
	 */
	private int goods;
	/**
	 * ����
	 */
	private int fans;
	/**
	 * �Ƿ��ο�
	 */
	private int isYouKe;
	/**
	 * ��ʦid
	 */
	private int teacherId;
	/**
	 * �Ƿ���� 0 ���ڽ���  1�ѽ���  2 δ��ʼ
	 */
	private int isEnd;
	
	public ReadTape() {
		super();
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
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}
	public int getIsYouKe() {
		return isYouKe;
	}
	public void setIsYouKe(int isYouKe) {
		this.isYouKe = isYouKe;
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
