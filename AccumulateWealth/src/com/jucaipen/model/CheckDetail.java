package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator ------------��������
 * 
 *         �����Ϣ JCP_ShenHe_Detail
 */
@SuppressWarnings("serial")
public class CheckDetail implements Serializable {
	/**
	 * Id
	 */
	private int id;
	/**
	 *  FK_ApplyId  ����id
	 */
	private int applyId;
	/**
	 *  Cause   ʧ��ԭ��
	 */
	private String reason;
	/**
	 *  PassDate   ���ͨ��ʱ��
	 */
	private String passDate;
	/**
	 *  �����  Auditor
	 */
	private String auditor;
	/**
	 *  ��̨�û�ID
	 */
	private int fk_AdminUserId;
	/**
	 *  State
	 */
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getPassDate() {
		return passDate;
	}
	public void setPassDate(String passDate) {
		this.passDate = passDate;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public int getFk_AdminUserId() {
		return fk_AdminUserId;
	}
	public void setFk_AdminUserId(int fk_AdminUserId) {
		this.fk_AdminUserId = fk_AdminUserId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
