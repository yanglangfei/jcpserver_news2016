package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  -------------��������
 *
 *  ��λ    JCP_Position
 */
@SuppressWarnings("serial")
public class Position implements Serializable{
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  PositionName
	 */
	private String name;
	/**
	 *  Remark
	 */
	private String remark;
	/**
	 * �ʸ�֤����  FK_CenId
	 */
	private int fk_CenId;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getFk_CenId() {
		return fk_CenId;
	}
	public void setFk_CenId(int fk_CenId) {
		this.fk_CenId = fk_CenId;
	}
}
