package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Account;

/**
 * @author Administrator
 *
 *  �˻���Ϣ
 */
public interface AccountDao {
	
	/**
	 * @return  ��ȡ�����˻���Ϣ
	 */
	public List<Account> findAllAccount();
	
	/**
	 * @param id
	 * @return  ͨ��id��ȡ�˻���Ϣ
	 */
	public Account findAccountById(int id);
	/**
	 * @param uId
	 * @return  ͨ���û�id��ȡ�˻���Ϣ
	 */
	public Account findAccountByUserId(int uId);
	
	/**
	 * @param uId
	 * @return  �޸��˻��۲Ʊ�����
	 */
	public int updateBills(int uId,int newBills);
	
	/**
	 * @param uId
	 * @param integeral
	 * @return  �޸Ļ�����Ϣ
	 */
	public int updateIntegeral(int uId,int integeral);
	
	/**
	 * @param account
	 * @return  ����˻���Ϣ
	 */
	public int addAccount(Account account);
	

}
