package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator   ------------��������
 *
 *   ���� ��   JCP_Contribute
 */
@SuppressWarnings("serial")
public class Contribute implements Serializable{
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  �����û�id FK_UserId
	 */
	private int userId;
	/**
	 *  ������ʦ FK_TearchId
	 */
	private int teacherId;
	/**
	 *  ����id  FK_Id
	 */
	private int fk_id;
	/**
	 *  ����ʱ��  InsertDate
	 */
	private String insertDate;
	/**
	 *  �ܾ۲Ʊ�   ����    AllJucaibi
	 */
	private int allJucaiBills;
	/**
	 *  �������� 1������Ʒ  3��ͨ�ػ� 4�����ʴ� 5������ʦ 6����ֱ�����ѹ۵� 7�Ķ������ʴ� 8���򸶷���־  9������־      ComType
	 */
	private int comType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getFk_id() {
		return fk_id;
	}
	public void setFk_id(int fk_id) {
		this.fk_id = fk_id;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getAllJucaiBills() {
		return allJucaiBills;
	}
	public void setAllJucaiBills(int allJucaiBills) {
		this.allJucaiBills = allJucaiBills;
	}
	public int getComType() {
		return comType;
	}
	public void setComType(int comType) {
		this.comType = comType;
	}
}
