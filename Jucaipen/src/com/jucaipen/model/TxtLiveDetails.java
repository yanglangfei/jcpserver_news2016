package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator          --------------�����Ѹ���
 *   
 *   ����ֱ������
 *
 */

@SuppressWarnings("serial")
public class TxtLiveDetails implements Serializable{
	/**
	 * id
	 */
	private int id;
	/**
	 * ���ֱ��id
	 */
	private int fk_liveId;
	/**
	 * �������
	 */
	private int fk_commId;
	/**
	 * ����
	 */
	private String bodys;
	/**
	 * ͼƬ·��
	 */
	private String image;
	/**
	 * ֱ�����ͣ�0�۵㣬1�ظ����ѻ�����
	 */
	private int liveType;
	/**
	 * �ϴ�ʱ��
	 */
	private String insertDate;
	/**
	 * �Ƿ��շ�     1   ��     2  ��
	 */
	private int isFree;
	/**
	 * �շѼ۸�
	 */
	private double livePrice;
	/**
	 *  ���ݷ���id
	 */
	private int fk_contentId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFk_liveId() {
		return fk_liveId;
	}
	public void setFk_liveId(int fk_liveId) {
		this.fk_liveId = fk_liveId;
	}
	public int getFk_commId() {
		return fk_commId;
	}
	public void setFk_commId(int fk_commId) {
		this.fk_commId = fk_commId;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getLiveType() {
		return liveType;
	}
	public void setLiveType(int liveType) {
		this.liveType = liveType;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getIsFree() {
		return isFree;
	}
	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}
	public double getLivePrice() {
		return livePrice;
	}
	public void setLivePrice(double livePrice) {
		this.livePrice = livePrice;
	}
	public int getFk_contentId() {
		return fk_contentId;
	}
	public void setFk_contentId(int fk_contentId) {
		this.fk_contentId = fk_contentId;
	}

}
