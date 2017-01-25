package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ���ʷ�
 *2017��1��23��  ����1:31:36
 *
 *   ҡһҡ��ǰ��Ϣ
 */
public class SharkInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 *  id
	 */
	private int id;
	/**
	 *   ���Ŷ��
	 */
	private int price;
	/**
	 * ʣ����
	 */
	private int syPrice;
	/**
	 *   ��ʼʱ��
	 */
	private String startDate;
	/**
	 * ����ʱ��
	 */
	private String endDate;
	/**
	 * ���췢��ʣ����˴���ʾ���췢���û�δ����������ȷ�����ɺ��ȡ���ֶ��Ƿ����0���������0��ʼ���Ÿ�
	 */
	private int addPeice;
	/**
	 *  ���췢��ʣ��ɷ��Ž��
	 */
	private int sYAddPeice;
	/**
	 *   ��ע˵��
	 */
	private String remark;
	
	public SharkInfo() {
		
	}
	public SharkInfo(int id, int price, int syPrice, String startDate,
			String endDate, int addPeice, int sYAddPeice, String remark) {
		this.id = id;
		this.price = price;
		this.syPrice = syPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.addPeice = addPeice;
		this.sYAddPeice = sYAddPeice;
		this.remark = remark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSyPrice() {
		return syPrice;
	}
	public void setSyPrice(int syPrice) {
		this.syPrice = syPrice;
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
	public int getAddPeice() {
		return addPeice;
	}
	public void setAddPeice(int addPeice) {
		this.addPeice = addPeice;
	}
	public int getsYAddPeice() {
		return sYAddPeice;
	}
	public void setsYAddPeice(int sYAddPeice) {
		this.sYAddPeice = sYAddPeice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
