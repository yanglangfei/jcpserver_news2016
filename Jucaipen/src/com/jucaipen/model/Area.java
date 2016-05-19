package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf             ----------------------��Ϣ�Ѹ���
 * 
 *   ��
 *
 */
@SuppressWarnings("serial")
public class Area implements Serializable {
	/**
	 *  ����Ϣ��ҳ��
	 */
	private int totlePager;
	/**
	 *  ����Ϣ��ǰҳ��
	 */
	private int pager;
	/**
	 * ��id
	 */
	private int id;
	/**
	 * ����������id
	 */
	private int cityId;
	/**
	 * ������
	 */
	private String name;
	/**
	 * ����
	 */
	private int sortId;
	/**
	 * ��ע
	 */
	private String remark;
	
	
	
	public Area( int id, int cityId, String name,
			int sortId, String remark) {
		this.id = id;
		this.cityId = cityId;
		this.name = name;
		this.sortId = sortId;
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
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
	public int getTotlePager() {
		return totlePager;
	}
	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
	}
	
	

}
