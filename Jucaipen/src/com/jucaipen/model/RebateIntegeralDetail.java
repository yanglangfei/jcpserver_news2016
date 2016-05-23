package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator  ----------------��������
 *
 *  �������ּ�¼    JCP_RebateIntegral_Detail
 */
@SuppressWarnings("serial")
public class RebateIntegeralDetail implements Serializable{
	private int page;
	private int totlePage;
	/**
	 *  Id
	 */
	private int id;
	/**
	 *  �����û�id  FK_UserId
	 */
	private int userId;
	/**
	 *  IntegralNum   ����������
	 */
	private int integralNum;
	/**
	 *  InsertDate
	 */
	private String insertDate;
	/**
	 *  ReMark
	 */
	private String remark;
	/**
	 *  Type  ����¼���ͣ�0�Ƽ��û�ע�᷵����1�Ƽ����뽲ʦ����,2���û�ע�᷵����3�û����۷���,4�û�ǩ��������
	 */
	private int type;
    /**
     *  FK_FromId   ��Դid
     */
    private int fromId;
    
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
	public int getIntegralNum() {
		return integralNum;
	}
	public void setIntegralNum(int integralNum) {
		this.integralNum = integralNum;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
}
