package com.jucaipen.dao;

import com.jucaipen.model.SysAccount;

public interface SysAccountDao {
	
	/**
	 * @return  ��ֵ  �����˻�
	 */
	public int updatePurchInfo(int sysAccount,int childAccount,int userAccount);
	
	/**
	 * @param count
	 * @return   ��ȡ���˻���Ϣ
	 */
	public SysAccount findAccountInfo();
	
	/**
	 * @param sysAccount
	 * @param childAccount
	 * @param userAccount
	 * @return   �ػ�  �������˻���Ϣ
	 */
	public int updateGurdianInfo(int sysAccount,int childAccount,int userAccount,int gurdianAccount);

}
