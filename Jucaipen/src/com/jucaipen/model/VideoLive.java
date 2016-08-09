package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author YLF
 *
 *
 *   ֱ����                     ------------------------------�����Ѹ���    5.18
 */
/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class VideoLive implements Serializable{
	private int page;
	private int totlePage;
	
	/**
	 * �Ƿ�ͨ��Ƶֱ������
	 */  
	private boolean isLiveVideo;
	
	/**
	 *   �Ƿ��շ�
	 */
	private boolean isCharge;
	
	/**
	 *   ֱ���۸�
	 */
	private int livePrice;
	/**
	 *   �Ƿ���  
	 */
	private int isPurch;
	/**
	 *  ֱ��id
	 */
	private int id;
	/**
	 * ֱ������
	 */
	private String title;
	/**
	 * ֱ���ؼ���
	 */
	private String keyWord;
	/**
	 *  ����
	 */
	private String descript;
	/**
	 *  ֱ��������������
	 */
	private int classId;
	/**
	 *  ֱ��URL
	 */
	private String videoUrl;
	/**
	 *  ֱ������
	 */
	private String videoImage;
	/**
	 *  ֱ����ʦid
	 */
	private int teacherId;
	/**
	 * ֱ��״̬ 1δ��ʼ 2������ 3�ѽ���
	 */
	private int isEnd;
	/**
	 * ��ʼʱ��
	 */
	private String startDate;
	/**
	 *  ����ʱ��
	 */
	private String endDate;
	/**
	 *  ֱ������
	 */
	private int renQi;
	
	
	
	
	
	public boolean isCharge() {
		return isCharge;
	}
	public void setCharge(boolean isCharge) {
		this.isCharge = isCharge;
	}
	public int getLivePrice() {
		return livePrice;
	}
	public void setLivePrice(int livePrice) {
		this.livePrice = livePrice;
	}
	public int getIsPurch() {
		return isPurch;
	}
	public void setIsPurch(int isPurch) {
		this.isPurch = isPurch;
	}
	public boolean isLiveVideo() {
		return isLiveVideo;
	}
	public void setLiveVideo(boolean isLiveVideo) {
		this.isLiveVideo = isLiveVideo;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getVideoImage() {
		return videoImage;
	}
	public void setVideoImage(String videoImage) {
		this.videoImage = videoImage;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
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
	public int getRenQi() {
		return renQi;
	}
	public void setRenQi(int renQi) {
		this.renQi = renQi;
	}
}
