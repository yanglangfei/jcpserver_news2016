package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF         ---------------�����Ѹ���
 * 
 *         �����б�
 * 
 */
@SuppressWarnings("serial")
public class ExpressionInfo implements Serializable {
	/**
	 * ����id
	 */
	private int id;
	/**
	 * ����id
	 */
	private int classId;
	/**
	 * ����
	 */
	private String name;
	/**
	 * �������ӵ�ַ
	 */
	private String faceurl;
	/**
	 * ��������
	 */
	private int sortId;

	public ExpressionInfo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}


	public String getFaceurl() {
		return faceurl;
	}

	public void setFaceurl(String faceurl) {
		this.faceurl = faceurl;
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


}
