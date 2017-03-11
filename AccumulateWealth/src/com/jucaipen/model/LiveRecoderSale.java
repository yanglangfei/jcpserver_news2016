package com.jucaipen.model;

/**
 * @author ���ʷ�
 *2017��3��11��  ����11:27:50
 *
 *   ֱ�������¼��    ����
 */
public class LiveRecoderSale {
	
	/**
	 *   id
	 */
	private int id;
	
	/**
	 *    ֱ����¼id
	 */
	private int liveRecoderId;
	
	/**
	 *   ��ʦid
	 */
	private int teacherId;
	
	/**
	 *   ����ʱ��
	 */
	private String purchDate;
	
	/**
	 *   ֧���ľ۲Ʊ�
	 */
	private int payBills;
	
	/**
	 *   �����û�
	 */
	private int userId;
	
	/**
	 *  ��ע
	 */
	private String remark;
	
	public LiveRecoderSale(int id, int liveRecoderId, int teacherId,
			String purchDate, int payBills, int userId, String remark) {
		this.id = id;
		this.liveRecoderId = liveRecoderId;
		this.teacherId = teacherId;
		this.purchDate = purchDate;
		this.payBills = payBills;
		this.userId = userId;
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLiveRecoderId() {
		return liveRecoderId;
	}

	public void setLiveRecoderId(int liveRecoderId) {
		this.liveRecoderId = liveRecoderId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getPurchDate() {
		return purchDate;
	}

	public void setPurchDate(String purchDate) {
		this.purchDate = purchDate;
	}

	public int getPayBills() {
		return payBills;
	}

	public void setPayBills(int payBills) {
		this.payBills = payBills;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
