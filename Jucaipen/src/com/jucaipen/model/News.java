package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author ylf
 * 
 *         ������
 * 
 */
@SuppressWarnings("serial")
public class News implements Serializable {
	/**
	 * ��ҳ��
	 */
	private int totlePager;
	/**
	 * ��ǰ����ҳ��
	 */
	private int pager;
	/**
	 * ģ������
	 */
	private String modelName;
	/**
	 * ���ű���
	 */
	private String title;
	/**
	 * ��������
	 */
	private String descript;
	/**
	 * ����
	 */
	private String reporter;
	/**
	 * ���Źؼ���
	 */
	private String KeyWord;
	/**
	 * ����id
	 */
	private int id;
	/**
	 * ��������
	 */
	private String Bodys;
	/**
	 * ����ͼƬ����
	 */
	private String ImageUrl;
	/**
	 * ժҪ
	 */
	private String summary;
	/**
	 * ���Ŵ���
	 */
	private int bigId;
	/**
	 * ����С��
	 */
	private int smallId;
	/**
	 * ��Դ
	 */
	private int comeFrom;
	/**
	 * �����
	 */
	private int hits;
	/**
	 * ������
	 */
	private int comments;
	/**
	 * ����ʱ��
	 */
	private String publishDate;
	/**
	 * ������
	 */
	private String publishUser;
	/**
	 * �Ƿ��ö���1 �ö� 0���ö���
	 */
	private int isTop;
	/**
	 * �Ƿ�ѡ
	 */
	private int isBest;
	/**
	 * �Ƿ���ͼƬ����
	 */
	private int isImage;
	/**
	 * �Ƿ���ҳ��ʾ
	 */
	private int isIndex;
	/**
	 * �������
	 */
	private String relatedNews;
	/**
	 * ������ַ
	 */
	private String htmlPath;
	/**
	 * ������Դ
	 */
	private String from;
	
	

	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getHtmlPath() {
		return htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	public News(int id) {
		this.id=id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getKeyWord() {
		return KeyWord;
	}

	public void setKeyWord(String keyWord) {
		KeyWord = keyWord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBodys() {
		return Bodys;
	}

	public void setBodys(String bodys) {
		Bodys = bodys;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getBigId() {
		return bigId;
	}

	public void setBigId(int bigId) {
		this.bigId = bigId;
	}

	public int getSmallId() {
		return smallId;
	}

	public void setSmallId(int smallId) {
		this.smallId = smallId;
	}

	public int getComeFrom() {
		return comeFrom;
	}

	public void setComeFrom(int comeFrom) {
		this.comeFrom = comeFrom;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublishUser() {
		return publishUser;
	}

	public void setPublishUser(String publishUser) {
		this.publishUser = publishUser;
	}

	public int getIsTop() {
		return isTop;
	}

	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}

	public int getIsBest() {
		return isBest;
	}

	public void setIsBest(int isBest) {
		this.isBest = isBest;
	}

	public int getIsImage() {
		return isImage;
	}

	public void setIsImage(int isImage) {
		this.isImage = isImage;
	}

	public int getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(int isIndex) {
		this.isIndex = isIndex;
	}

	public String getRelatedNews() {
		return relatedNews;
	}

	public void setRelatedNews(String relatedNews) {
		this.relatedNews = relatedNews;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getPager() {
		return pager;
	}

	public void setPager(int pager) {
		this.pager = pager;
	}

	public int getTotlePager() {
		return totlePager;
	}

	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	

}
