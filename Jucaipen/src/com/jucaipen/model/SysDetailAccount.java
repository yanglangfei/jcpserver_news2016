package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 
 *         ϵͳ��ϸ�˻�
 */
@SuppressWarnings("serial")
public class SysDetailAccount implements Serializable {
	private int id;
	private int userId;
	/**
	 * ��¼���ͣ�1�û���ֵ��2ϵͳ���ͣ�3���û����֣�4����Ʒ���ѣ�5��ֱ���۵㣬6������־��7�������ʴ�8����ͨ�ػ���9������ս����10��������Ƶ��
	 * 11����ר����12��ϵͳ���Ͳ�Ʒ 13,����
	 */
	private int type;
	/**
	 * 1���룬2֧��
	 */
	private int recoderType;
	private int orderId;
	private int price;
	private String insertDate;
	private String remark;
	private String ip;
	/**
	 * �Ƿ�ɾ����0�� 1�ǣ�
	 */
	private int isDel;

	public SysDetailAccount() {
		super();
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRecoderType() {
		return recoderType;
	}

	public void setRecoderType(int recoderType) {
		this.recoderType = recoderType;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
}
