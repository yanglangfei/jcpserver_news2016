package com.jucaipen.model;

/**
 * @author Administrator
 *
 *   �ݲ���   JCP_Studio
 */
public class Studio {
	private int page;
	private int totlePage;
	/**
	 *  id
	 */
	private int id;
	/**
	 *  ����
	 */
	private String title;
	/**
	 * �ؼ���
	 */
	private String keyWord;
	/**
	 * ����
	 */
	private String desc;
	/**
	 * ���
	 */
	private String jianjie;
	/**
	 * ����ͼƬ
	 */
	private String imageUrl;
	/**
	 * ����
	 */
	private int goods;
	/**
	 * ����
	 */
	private int renQi;
	/**
	 *  ����ʱ��
	 */
	private String insertDate;
	/**
	 * ��ʼʱ��
	 */
	private String startDate;
	/**
	 *  ����ʱ��
	 */
	private String endDate;
	/**
	 *  ԭ����Ƶid
	 */
	private int originalId;
	/**
	 *  ��Ƶֱ��id
	 */
	private int videoLiveId;
	/**
	 *  ��Ƶ��Ŀid
	 */
	private int videoColumnId;
	/**
	 *  ��Ŀ��ַ
	 */
	private String studioUrl;
	/**
	 *  �Ƿ����  1δ��ʼ  2������ 3����
	 */
	private int isEnd;
	/**
	 *   �Ƿ�ɾ�� 0���� 1ɾ��
	 */
	private int isDel;
	/**
	 *  ����id
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getJianjie() {
		return jianjie;
	}
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getRenQi() {
		return renQi;
	}
	public void setRenQi(int renQi) {
		this.renQi = renQi;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
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
	public int getOriginalId() {
		return originalId;
	}
	public void setOriginalId(int originalId) {
		this.originalId = originalId;
	}
	public int getVideoLiveId() {
		return videoLiveId;
	}
	public void setVideoLiveId(int videoLiveId) {
		this.videoLiveId = videoLiveId;
	}
	public int getVideoColumnId() {
		return videoColumnId;
	}
	public void setVideoColumnId(int videoColumnId) {
		this.videoColumnId = videoColumnId;
	}
	public String getStudioUrl() {
		return studioUrl;
	}
	public void setStudioUrl(String studioUrl) {
		this.studioUrl = studioUrl;
	}
	public int getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
}
