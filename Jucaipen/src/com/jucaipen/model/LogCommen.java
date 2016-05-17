package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *   ��־����
 *
 */
@SuppressWarnings("serial")
public class LogCommen implements Serializable{
	/**
	 * ��־���۵�ǰҳ
	 */
	private int page;
	
	/**
	 * ��־������ҳ��
	 */
	private int totlePage;
	/**
	 * ��־����id
	 */
	private int id;
	/**
	 * �����û�id
	 */
	private int userId;
	/**
	 * �ϼ�����id
	 */
	private int parentId;
	/**
	 * ������־id
	 */
	private int logId;
	/**
	 * ��������
	 */
	private String bodys;
	/**
	 * ����ʱ��
	 */
	private String insertDate;
	/**
	 * ������
	 */
	private int goods;
	/**
	 * �Ƿ���ʾ
	 */
	private int isShow;
	/**
	 * �ظ�����
	 */
	private int repCount;
	
	public LogCommen(int id, int userId, int parentId, int logId, String bodys,
			String insertDate, int goods, int isShow, int repCount) {
		this.id = id;
		this.userId = userId;
		this.parentId = parentId;
		this.logId = logId;
		this.bodys = bodys;
		this.insertDate = insertDate;
		this.goods = goods;
		this.isShow = isShow;
		this.repCount = repCount;
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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getBodys() {
		return bodys;
	}
	public void setBodys(String bodys) {
		this.bodys = bodys;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getIsShow() {
		return isShow;
	}
	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}
	public int getRepCount() {
		return repCount;
	}
	public void setRepCount(int repCount) {
		this.repCount = repCount;
	}
	

}
