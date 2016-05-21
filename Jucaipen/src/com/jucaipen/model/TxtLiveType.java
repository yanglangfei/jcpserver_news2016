package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  -------新增数据
 *
 *  文字直播分类   JCP_TxtLive_Type
 */
@SuppressWarnings("serial")
public class TxtLiveType implements Serializable{
	/**
	 *  Id
	 */
	private int type;
	/**
	 *  TypeName  
	 */
	private String name;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 *  SortId
	 */
	private int sortId;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
}
