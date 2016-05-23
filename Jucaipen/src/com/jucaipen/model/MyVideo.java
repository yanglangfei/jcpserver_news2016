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
