package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *   ����˽ļ
 *
 */
@SuppressWarnings("serial")
public class PrivatePlace implements Serializable {
	/**
	 *   ˽ļid
	 */
	private int id;
	/**
	 * ˽ļ����
	 */
	private String title;
	/**
	 *  ��������
	 */
	private String managerName;
	/**
	 * ����ר��ҳ���ַ
	 */
	private String LinkPageUrl;
	/**
	 *  ����ͼƬ
	 */
	private String ManagerImage;
	/**
	 *  Ͷ���ż�
	 */
	private String MenKan;
	/**
	 *  ����
	 */
	private int grade;
	/**
	 *  ��������
	 */
	private String ThisYearShouyi;
	/**
	 *  ȥ������
	 */
	private String LastYearShouyi;
	/**
	 * �Ƽ�����
	 */
	private String TuijianInfo;
	/**
	 * �Ƿ���ҳ��ʾ
	 */
	private int IsIndex;
	/**
	 * �Ƿ��Ƽ�
	 */
	private int IsTuijian;
	/**
	 * �Ƿ��ö�
	 */
	private int IsTop;
	
	public PrivatePlace(int id, String title, String managerName) {
		this.id = id;
		this.title = title;
		this.managerName = managerName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getLinkPageUrl() {
		return LinkPageUrl;
	}
	public void setLinkPageUrl(String linkPageUrl) {
		LinkPageUrl = linkPageUrl;
	}
	public String getManagerImage() {
		return ManagerImage;
	}
	public void setManagerImage(String managerImage) {
		ManagerImage = managerImage;
	}
	public String getMenKan() {
		return MenKan;
	}
	public void setMenKan(String menKan) {
		MenKan = menKan;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getThisYearShouyi() {
		return ThisYearShouyi;
	}
	public void setThisYearShouyi(String thisYearShouyi) {
		ThisYearShouyi = thisYearShouyi;
	}
	public String getLastYearShouyi() {
		return LastYearShouyi;
	}
	public void setLastYearShouyi(String lastYearShouyi) {
		LastYearShouyi = lastYearShouyi;
	}
	public String getTuijianInfo() {
		return TuijianInfo;
	}
	public void setTuijianInfo(String tuijianInfo) {
		TuijianInfo = tuijianInfo;
	}
	public int getIsIndex() {
		return IsIndex;
	}
	public void setIsIndex(int isIndex) {
		IsIndex = isIndex;
	}
	public int getIsTuijian() {
		return IsTuijian;
	}
	public void setIsTuijian(int isTuijian) {
		IsTuijian = isTuijian;
	}
	public int getIsTop() {
		return IsTop;
	}
	public void setIsTop(int isTop) {
		IsTop = isTop;
	}
	

}
