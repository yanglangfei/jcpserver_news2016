package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   ����
 *
 */
@SuppressWarnings("serial")
public class City implements Serializable {
	/**
	 * ������Ϣ��ǰҳ��
	 */
	private int pager;
	/**
	 * ������Ϣ��ҳ��
	 */
	private int totlePager;
	/**
	 * ����id
	 */
	private int id;
	/**
	 * ��������ʡ��id
	 */
	private int provinceId;
	/**
	 * ��������
	 */
	private String name;
	/**
	 * ����
	 */
	private int sortId;
	
	public City(int id, int provinceId, String name, int sortId) {
		this.id = id;
		this.provinceId = provinceId;
		this.name = name;
		this.sortId = sortId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
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
	
	

}
