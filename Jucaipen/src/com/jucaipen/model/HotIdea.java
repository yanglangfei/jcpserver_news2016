package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 * ���Ź۵�
 *
 */
@SuppressWarnings("serial")
public class HotIdea implements Serializable{
	/**
	 * ���ݵ�ǰҳ��
	 */
	private int page;
	/**
	 * ������ҳ��
	 */
	private int totlePgae;
	/**
	 *  �۵�id
	 */
	private int id;
	/**
	 * �۵����
	 */
	private String title;
	/**
	 * �۵�����
	 */
	private String bodys;
	/**
	 * ��������
	 */
	private int goods;
	/**
	 * �����
	 */
	private int hits;
	/**
	 * ������
	 */
	private int commens;
	/**
	 * ����۵�ʱ��
	 */
	private String insertDate;
	/**
	 * ����id
	 */
	private int classId;
	/**
	 *   ��ô��ͽ��
	 */
	private double rewardMoney;
	/**
	 * ����۵��ʦid
	 */
	private int teacherId;
	/**
	 * ���ͼƬ
	 */
	private String logImage;
	/**
	 *  �Ƿ��Ƽ�   0   ��   1  ��
	 */
	private int isTuijian;
	/**
	 *  �Ƿ��ö�    0  ��    1��
	 */
	private int top;
	/**
	 *  �Ƿ�ѡ   0��    1��
	 */
	private int isBest;
	/**
	 * 
	 */
	private int isIndex;
	/**
	 *  �Ƿ����
	 */
	private int isFree;
	/**
	 *   ��Ҫ֧���۲Ʊ�
	 */
	private int jucaiBills; 
	/**
	 * 
	 */
	private String freeBody;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotlePgae() {
		return totlePgae;
	}
	public void setTotlePgae(int totlePgae) {
		this.totlePgae = totlePgae;
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
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getCommens() {
		return commens;
	}
	public void setCommens(int commens) {
		this.commens = commens;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public double getRewardMoney() {
		return rewardMoney;
	}
	public void setRewardMoney(double rewardMoney) {
		this.rewardMoney = rewardMoney;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getLogImage() {
		return logImage;
	}
	public void setLogImage(String logImage) {
		this.logImage = logImage;
	}
	public int getIsTuijian() {
		return isTuijian;
	}
	public void setIsTuijian(int isTuijian) {
		this.isTuijian = isTuijian;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getIsBest() {
		return isBest;
	}
	public void setIsBest(int isBest) {
		this.isBest = isBest;
	}
	public int getIsIndex() {
		return isIndex;
	}
	public void setIsIndex(int isIndex) {
		this.isIndex = isIndex;
	}
	public int getIsFree() {
		return isFree;
	}
	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}
	public int getJucaiBills() {
		return jucaiBills;
	}
	public void setJucaiBills(int jucaiBills) {
		this.jucaiBills = jucaiBills;
	}
	public String getFreeBody() {
		return freeBody;
	}
	public void setFreeBody(String freeBody) {
		this.freeBody = freeBody;
	}

}
