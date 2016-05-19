package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator     ------------数据已更新
 *
 *    观点销售信息
 *
 */
@SuppressWarnings("serial")
public class IdeaSale implements Serializable{
	private int id;
	/**
	 *   购买用户id 
	 */
	private int userId;
	/**
	 *  直播讲师id
	 */
	private int teacherId;
	/**
	 * 订单号
	 */
	private String orderCode;
	/**
	 *   直播id
	 */
	private int logId;
	/**
	 *    订单生成时间
	 */
	private String insertDate;
	public IdeaSale(int id, int userId, int teacherId, String orderCode,
			int logId, String insertDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.teacherId = teacherId;
		this.orderCode = orderCode;
		this.logId = logId;
		this.insertDate = insertDate;
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
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public int getLogId() {
		return logId;
	}
	public void setLiveId(int logId) {
		this.logId = logId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	
	

}
