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
	 * ����id
	 */
	private int classId;
	/**
	 * �ؼ���
	 */
	private String keyWord;
	/**
	 * ����۵�ʱ��
	 */
	private String insertDate;
	/**
	 * ����۵��ʦid
	 */
	private int teacherId;
	/**
	 * ���ͼƬ
	 */
	private String logImage;
	public HotIdea() {
	}
	
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
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
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
	
	
	
	
	
	
	
	
	
	
	

}
