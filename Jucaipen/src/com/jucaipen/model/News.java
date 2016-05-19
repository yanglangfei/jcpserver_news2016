package com.jucaipen.model;

import java.io.Serializable;
/**
 * @author ylf          ---------------�����Ѹ���    5.18
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
	 * ���ű���
	 */
	private String title;
	/**
	 * ����id
	 */
	private int id;
	/**
	 * ���Źؼ���
	 */
	private String KeyWord;

	/**
	 * ��������
	 */
	private String Bodys;
	/**
	 * ���Ŵ���
	 */
	private int classId;
	/**
	 * �Ķ���
	 */
	private int hits;
	
	/**
	 *   �����Ķ���
	 */
	private int XnHits;
	/**
	 * ����ʱ��
	 */
	private String publishDate;
	/**
	 * ��Դ
	 */
	private int fromId;
	/**
	 * ����
	 */
	private String reporter;
	/**
	 * ����ͼƬ����
	 */
	private String ImageUrl;
	/**
	 *  ����
	 */
	private String writer;
	/**
	 * ������ַ
	 */
	private String htmlPath;
	/**
	 *  ����
	 */
	private int goods;
	/**
	 * ������
	 */
	private int comments;
	/**
	 * �Ƿ��ö���1 �ö� 0���ö���
	 */
	private int isTop;
	/**
	 * �Ƿ�ѡ
	 */
	private int isBest;
	/**
	 * ժҪ
	 */
	private String summary;
	/**
	 * �Ƿ���ҳ��ʾ
	 */
	private int isIndex;
	/**
	 *   �Ƿ��Ƽ�    0 ���Ƽ�   1  �Ƽ�
	 */
	private int isTuijian;
	/**
	 * ������
	 */
	private String publishUser;
	/**
	 * ������Դ
	 */
	private String from;
	
	
	public News(int id) {
		this.id = id;
	}
	public News(int totlePager, int pager, String title, int id,
			String keyWord, String bodys, int classId, int hits, int xnHits,
			String publishDate, int fromId, String reporter, String imageUrl,
			String writer, String htmlPath, int goods, int comments, int isTop,
			int isBest, String summary, int isIndex, int isTuijian,
			String publishUser, String from) {
		super();
		this.totlePager = totlePager;
		this.pager = pager;
		this.title = title;
		this.id = id;
		KeyWord = keyWord;
		Bodys = bodys;
		this.classId = classId;
		this.hits = hits;
		XnHits = xnHits;
		this.publishDate = publishDate;
		this.fromId = fromId;
		this.reporter = reporter;
		ImageUrl = imageUrl;
		this.writer = writer;
		this.htmlPath = htmlPath;
		this.goods = goods;
		this.comments = comments;
		this.isTop = isTop;
		this.isBest = isBest;
		this.summary = summary;
		this.isIndex = isIndex;
		this.isTuijian = isTuijian;
		this.publishUser = publishUser;
		this.from = from;
	}
	public int getTotlePager() {
		return totlePager;
	}
	public void setTotlePager(int totlePager) {
		this.totlePager = totlePager;
	}
	public int getPager() {
		return pager;
	}
	public void setPager(int pager) {
		this.pager = pager;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeyWord() {
		return KeyWord;
	}
	public void setKeyWord(String keyWord) {
		KeyWord = keyWord;
	}
	public String getBodys() {
		return Bodys;
	}
	public void setBodys(String bodys) {
		Bodys = bodys;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getXnHits() {
		return XnHits;
	}
	public void setXnHits(int xnHits) {
		XnHits = xnHits;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getHtmlPath() {
		return htmlPath;
	}
	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getIsIndex() {
		return isIndex;
	}
	public void setIsIndex(int isIndex) {
		this.isIndex = isIndex;
	}
	public int getIsTuijian() {
		return isTuijian;
	}
	public void setIsTuijian(int isTuijian) {
		this.isTuijian = isTuijian;
	}
	public String getPublishUser() {
		return publishUser;
	}
	public void setPublishUser(String publishUser) {
		this.publishUser = publishUser;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
     

}
