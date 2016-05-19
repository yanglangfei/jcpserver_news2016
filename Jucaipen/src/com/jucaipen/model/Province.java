package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf          -----------------------�����Ѹ���
 *  ʡ��
 */
@SuppressWarnings("serial")
public class Province implements Serializable {
	/**
	 * ʡ����Ϣ��ǰҳ
	 */
	private int pager;
	/**
	 * ʡ����Ϣ��ҳ��
	 */
	private int totlePager;
	/**
	 * ʡ��id
	 */
	private int id;
	/**
	 * ʡ��name
	 */
	private String name;
	/**
	 * ����
	 */
	private int sortId;
	/**
	 *  ��ע
	 */
	private String proRemark;
	
	public Province(int id, String name, int sortId) {
		this.id = id;
		this.name = name;
		this.sortId = sortId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getProSort() {
		return sortId;
	}
	public void setProSort(int sortId) {
		sortId = sortId;
	}
	public String getProRemark() {
		return proRemark;
	}
	public void setProRemark(String proRemark) {
		this.proRemark = proRemark;
	}
	
	
	

}
