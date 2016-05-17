package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *   区
 *
 */
@SuppressWarnings("serial")
public class Area implements Serializable {
	/**
	 *  区信息总页数
	 */
	private int totlePager;
	/**
	 *  区信息当前页数
	 */
	private int pager;
	/**
	 * 区id
	 */
	private int id;
	/**
	 * 区所属省份id
	 */
	private int provinceId;
	/**
	 * 区所属城市id
	 */
	private int cityId;
	/**
	 * 区名称
	 */
	private String name;
	/**
	 * 分类
	 */
	private int sortId;
	
	public Area(int id, int provinceId, int cityId, String name, int sortId) {
		this.id = id;
		this.provinceId = provinceId;
		this.cityId = cityId;
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
