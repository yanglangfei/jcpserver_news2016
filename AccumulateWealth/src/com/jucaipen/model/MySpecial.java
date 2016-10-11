package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  ---------------��������
 *
 *   �ҵ�ר��     JCP_MySpecial  (�����¼)
 */
@SuppressWarnings("serial")
public class MySpecial implements Serializable{
	private int page;
	private int totlePage;
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  ����ר���û�id  FK_UserId
	 */
	private int userId;
	/**
	 *  ר��id  FK_SpecialId
	 */
	private int specialId;
	
	/**
	 *  ר������
	 */
	private String specialTitle;
	
	/**
	 *   ר��ͼƬ
	 */
	private String specialImage;
	
	private String specialDesc;
	
	/**
	 *   �Ƿ���    0   �ѹ���     1    δ����     2   �ѹ���
	 */
	private int isPurch;
	
	/**
	 *  ר����ʦ 
	 */
	private int specialTeacher;
	
	private String teacherName;
	
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 *  Remark
	 */
	private String remark;
	/**
	 *  �Ƿ�ɾ����0��1�ǣ� IsDel
	 */
	private int isDel;
	/**
	 *  �Ƿ�ֹͣ(0��1��)  IsStop
	 */
	private int isStop;
	/**
	 *  StartDate
	 */
	private String startDate;
	/**
	 *  EndDate
	 */
	private String endDate;
	
	public int getIsPurch() {
		return isPurch;
	}
	public void setIsPurch(int isPurch) {
		this.isPurch = isPurch;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getSpecialDesc() {
		return specialDesc;
	}
	public void setSpecialDesc(String specialDesc) {
		this.specialDesc = specialDesc;
	}
	public String getSpecialTitle() {
		return specialTitle;
	}
	public void setSpecialTitle(String specialTitle) {
		this.specialTitle = specialTitle;
	}
	public String getSpecialImage() {
		return specialImage;
	}
	public void setSpecialImage(String specialImage) {
		this.specialImage = specialImage;
	}
	public int getSpecialTeacher() {
		return specialTeacher;
	}
	public void setSpecialTeacher(int specialTeacher) {
		this.specialTeacher = specialTeacher;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
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
	public int getSpecialId() {
		return specialId;
	}
	public void setSpecialId(int specialId) {
		this.specialId = specialId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getIsStop() {
		return isStop;
	}
	public void setIsStop(int isStop) {
		this.isStop = isStop;
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
}