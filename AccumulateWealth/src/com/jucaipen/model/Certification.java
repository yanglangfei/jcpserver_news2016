package com.jucaipen.model;

/**
 * @author Administrator    ------------------��������
 *
 *   �ʸ�֤��     JCP_Certification
 */
public class Certification {
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  ֤����������   TypeName
	 */
	private String typeName;
	/**
	 *  ��ע˵��   Remark
	 */
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
