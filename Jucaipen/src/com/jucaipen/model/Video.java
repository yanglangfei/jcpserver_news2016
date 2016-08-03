package com.jucaipen.model;

import java.io.Serializable;
/**
 * @author ylf           ---------�����Ѹ���    5.18
 * 
 *   ��Ƶ
 *
 */
@SuppressWarnings("serial")
public class Video implements Serializable{
	/**
	 *   ��Ƶid
	 */
	private int id;
	/**
	 *   ������Ƶ����     1   Ȥ��     2   ����
	 */
	private int playType;
	
	private String vid;
	
	private String uid;
	/**
	 *  �Ƿ��շ�
	 */
	private boolean isCharge;
	
	/**
	 * ��Ƶ����
	 */
	private String title;
	/**
	 *    �Ƿ���    0  �й���     1    δ����      2  �ѹ���
	 */
	private int isPurch;
	/**
	 *   �Ƿ�����ר��
	 */
	private boolean isSpecial;
	/**
	 * ����
	 */
	private String descript;
	/**
	 * �����
	 */
	private int HitCount;
	/**
	 *  ���ⲥ����
	 */
	private int XnHitCount;
	/**
	 * ����ʱ��
	 */
	private String InsertDate;
	/**
	 * ��Ƶ��������
	 */
	private String VideoDate;
	/**
	 * ����id
	 */
	private int classId;
	/**
	 *   ��Ƶ����   0 ���    1  ����
	 */
	private int videoType;
	/**
	 *   Ӧ�����
	 */
	private String allMoney;
	/**
	 *   ʵ�����
	 */
	private String payMoney;
	/**
	 *  ������ʦ
	 */
	private int teacherId;
	/**
	 * �Ƿ��ö������������ö������������ö�����
	 */
	private int IsTop;
	/**
	 *   �Ƿ�ѡ   0  ��   1  ��
	 */
	private int isBest;
	/**
	 *  ������
	 */
	private int goods;
	/**
	 * ��ƵURL
	 */
	private String VideoUrl;
	/**
	 * ������
	 */
	private int CommCount;
	/**
	 * �ؼ���
	 */
	private String keyWords;
	/**
	 * ͼƬ
	 */
	private String Images;
	/**
	 *  ������Ƶ����
	 */
	private int typeId;
	/**
	 *  �������ݷ��࣬�������Ŵ���
	 */
	private int contentId;
	/**
	 * �Ƿ��Ǳ�վ��Ƶ�����������ǡ��������ǡ���
	 */
	private int IsMySiteVideo;
	/**
	 *  ����ר��
	 */
	private int pecialId;
	/**
	 *  ����id
	 */
	private int sortId;
	/**
	 *   ��̬ҳ��URL
	 */
	private String htmlUrl;	
	/**
	 * ���Ƿ���ҳ��ʾ����������ҳ������������ҳ��ʾ��
	 */
	private int IsIndex;
	/**
	 * �Ƿ��Ƽ������������Ƽ����������������Ƽ�����
	 */
	private int IsTuijian;
	
	/**
	 *   �¸��۸�
	 */
	private int mothPrice;
	/**
	 *   �����۸�
	 */
	private int quartPrice;
	/**
	 * �긶�۸�
	 */
	private int yearPrice;
	private int page;
	private int totlePage;
	
	
	public Video() {
		super();
	}
	public Video(int id, String title) {
		this.id = id;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlayType() {
		return playType;
	}
	public void setPlayType(int playType) {
		this.playType = playType;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public boolean isCharge() {
		return isCharge;
	}
	public void setCharge(boolean isCharge) {
		this.isCharge = isCharge;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIsPurch() {
		return isPurch;
	}
	public void setIsPurch(int isPurch) {
		this.isPurch = isPurch;
	}
	public boolean isSpecial() {
		return isSpecial;
	}
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public int getHitCount() {
		return HitCount;
	}
	public void setHitCount(int hitCount) {
		HitCount = hitCount;
	}
	public int getXnHitCount() {
		return XnHitCount;
	}
	public void setXnHitCount(int xnHitCount) {
		XnHitCount = xnHitCount;
	}
	public String getInsertDate() {
		return InsertDate;
	}
	public void setInsertDate(String insertDate) {
		InsertDate = insertDate;
	}
	public String getVideoDate() {
		return VideoDate;
	}
	public void setVideoDate(String videoDate) {
		VideoDate = videoDate;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getVideoType() {
		return videoType;
	}
	public void setVideoType(int videoType) {
		this.videoType = videoType;
	}
	public String getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}
	public String getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getIsTop() {
		return IsTop;
	}
	public void setIsTop(int isTop) {
		IsTop = isTop;
	}
	public int getIsBest() {
		return isBest;
	}
	public void setIsBest(int isBest) {
		this.isBest = isBest;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public String getVideoUrl() {
		return VideoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		VideoUrl = videoUrl;
	}
	public int getCommCount() {
		return CommCount;
	}
	public void setCommCount(int commCount) {
		CommCount = commCount;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getImages() {
		return Images;
	}
	public void setImages(String images) {
		Images = images;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getIsMySiteVideo() {
		return IsMySiteVideo;
	}
	public void setIsMySiteVideo(int isMySiteVideo) {
		IsMySiteVideo = isMySiteVideo;
	}
	public int getPecialId() {
		return pecialId;
	}
	public void setPecialId(int pecialId) {
		this.pecialId = pecialId;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public String getHtmlUrl() {
		return htmlUrl;
	}
	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
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
	public int getMothPrice() {
		return mothPrice;
	}
	public void setMothPrice(int mothPrice) {
		this.mothPrice = mothPrice;
	}
	public int getQuartPrice() {
		return quartPrice;
	}
	public void setQuartPrice(int quartPrice) {
		this.quartPrice = quartPrice;
	}
	public int getYearPrice() {
		return yearPrice;
	}
	public void setYearPrice(int yearPrice) {
		this.yearPrice = yearPrice;
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
	
}
