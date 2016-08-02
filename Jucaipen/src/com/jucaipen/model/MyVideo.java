package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  --------------��������
 *
 *   �ҵ���Ƶ   JCP_MyVideo
 */
@SuppressWarnings("serial")
public class MyVideo implements Serializable{
	private int page;
	private int totlePage;
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  FK_UserId
	 */
	private int userId;
	/**
	 *  FK_VideoId
	 */
	private int videoId;
	
	/**
	 *  ������Ƶ����
	 */
	private String videoTitle;
	
	/**
	 *  ������Ƶ����ͼƬ
	 */
	private String videoImag;
	
	private String videoUrl;
	
	private int fk_specialId;
	
	private int xnHits;
	
	private int classId;
	
	/**
	 *  InsertDate
	 */
	private String insertDate;
    /**
     *  Remark
     */
    private String remark;
    /**
     *   �Ƿ�ɾ����0��1�ǣ� IsDel
     */
    private int isDel;
    /**
     *  �Ƿ�ֹͣ��0��1�ǣ� IsStop
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
    
    
    
    
    
    
	public int getXnHits() {
		return xnHits;
	}
	public void setXnHits(int xnHits) {
		this.xnHits = xnHits;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public int getFk_specialId() {
		return fk_specialId;
	}
	public void setFk_specialId(int fk_specialId) {
		this.fk_specialId = fk_specialId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getVideoImag() {
		return videoImag;
	}
	public void setVideoImag(String videoImag) {
		this.videoImag = videoImag;
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
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
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
