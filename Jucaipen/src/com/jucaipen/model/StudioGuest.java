package com.jucaipen.model;

/**
 * @author Administrator
 * 
 *         �ݲ��Ҽα� JCP_StudioGuest
 */
public class StudioGuest {
	private int page;
	private int totlePage;
	/**
	 * id
	 */
	private int id;
	/**
	 *  �α�����
	 */
	private String name;
	/**
	 * �α�ͷ��
	 */
	private String headFace;
	/**
	 * �α�ͷ��
	 */
	private String leavl;
	/**
	 * �α����
	 */
	private String jianjie;
	/**
	 * �α��ó�
	 */
	private String hoby;
	/**
	 * �����ݲ���id
	 */
	private int studioId;
	/**
	 * ����id
	 */
	private int sortId;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadFace() {
		return headFace;
	}
	public void setHeadFace(String headFace) {
		this.headFace = headFace;
	}
	public String getLeavl() {
		return leavl;
	}
	public void setLeavl(String leavl) {
		this.leavl = leavl;
	}
	public String getJianjie() {
		return jianjie;
	}
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	public String getHoby() {
		return hoby;
	}
	public void setHoby(String hoby) {
		this.hoby = hoby;
	}
	public int getStudioId() {
		return studioId;
	}
	public void setStudioId(int studioId) {
		this.studioId = studioId;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
}
