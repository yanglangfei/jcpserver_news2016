package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *  ϵͳ���˻�
 */
@SuppressWarnings("serial")
public class SysAccount implements Serializable{
	/**
	 *  ϵͳ���˻����û���ֵ����  ���;۲Ʊ����ӣ���ʦ����ʱ�۳���
	 */
	private int sysAccount;
	/**
	 *  ϵͳ���˻�����ʼ0���û�����ʱ���ӣ���ʦ����ʱ�۳����������˻�
	 */
	private int sysChildAccount;
	
	/**
	 *  �û�ʣ����
	 */
	private int userAccount;
	
	/**
	 *   ��Ʒ�����˻�
	 */
	private int giftAccount;
	
	/**
	 *  ֱ���۵������˻�
	 */
	private int txtLiveAccount;
	/**
	 *  ������־�����˻�
	 */
	private int payLogAccount;
	/**
	 *   �����ʴ������˻�
	 */
	private int payAskAccount;
	/**
	 *  ��ͨ�ػ������˻�
	 */
	private int openGurdianAccount;
	/**
	 *  ����ս�������˻�
	 */
	private int tactivsAccount;
	/**
	 *  ������Ƶ�������˻�
	 */
	private int payVideoAccount;
	
	/**
	 *  ����ר���������˻�
	 */
	private int paySpecialAccount;
	/**
	 *  ��ʦ�������˻�
	 */
	private int teacherRebateAccount;
	/**
	 *  ϵͳ�������˻�
	 */
	private int sysRebateAccount;
	/**
	 *  ϵͳ�������˻�
	 */
	private int sysDobateAccount;
	
	/**
	 *   �����˻�
	 */
	private int daShangAccount;
	

	public SysAccount() {
	}

	public int getSysAccount() {
		return sysAccount;
	}

	public void setSysAccount(int sysAccount) {
		this.sysAccount = sysAccount;
	}

	public int getSysChildAccount() {
		return sysChildAccount;
	}

	public void setSysChildAccount(int sysChildAccount) {
		this.sysChildAccount = sysChildAccount;
	}

	public int getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(int userAccount) {
		this.userAccount = userAccount;
	}

	public int getGiftAccount() {
		return giftAccount;
	}

	public void setGiftAccount(int giftAccount) {
		this.giftAccount = giftAccount;
	}

	public int getTxtLiveAccount() {
		return txtLiveAccount;
	}

	public void setTxtLiveAccount(int txtLiveAccount) {
		this.txtLiveAccount = txtLiveAccount;
	}

	public int getPayLogAccount() {
		return payLogAccount;
	}

	public void setPayLogAccount(int payLogAccount) {
		this.payLogAccount = payLogAccount;
	}

	public int getPayAskAccount() {
		return payAskAccount;
	}

	public void setPayAskAccount(int payAskAccount) {
		this.payAskAccount = payAskAccount;
	}

	public int getOpenGurdianAccount() {
		return openGurdianAccount;
	}

	public void setOpenGurdianAccount(int openGurdianAccount) {
		this.openGurdianAccount = openGurdianAccount;
	}

	public int getTactivsAccount() {
		return tactivsAccount;
	}

	public void setTactivsAccount(int tactivsAccount) {
		this.tactivsAccount = tactivsAccount;
	}

	public int getPayVideoAccount() {
		return payVideoAccount;
	}

	public void setPayVideoAccount(int payVideoAccount) {
		this.payVideoAccount = payVideoAccount;
	}

	public int getPaySpecialAccount() {
		return paySpecialAccount;
	}

	public void setPaySpecialAccount(int paySpecialAccount) {
		this.paySpecialAccount = paySpecialAccount;
	}

	public int getTeacherRebateAccount() {
		return teacherRebateAccount;
	}

	public void setTeacherRebateAccount(int teacherRebateAccount) {
		this.teacherRebateAccount = teacherRebateAccount;
	}

	public int getSysRebateAccount() {
		return sysRebateAccount;
	}

	public void setSysRebateAccount(int sysRebateAccount) {
		this.sysRebateAccount = sysRebateAccount;
	}

	public int getSysDobateAccount() {
		return sysDobateAccount;
	}

	public void setSysDobateAccount(int sysDobateAccount) {
		this.sysDobateAccount = sysDobateAccount;
	}

	public int getDaShangAccount() {
		return daShangAccount;
	}

	public void setDaShangAccount(int daShangAccount) {
		this.daShangAccount = daShangAccount;
	}
}
