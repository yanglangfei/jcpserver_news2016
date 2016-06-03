package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.AccountDao;
import com.jucaipen.daoimp.AccountImp;
import com.jucaipen.model.Account;

public class AccountSer{

	/**
	 * @return  ��ȡ�����˻���Ϣ
	 */
	public static List<Account> findAllAccount() {
		AccountDao dao=new AccountImp();
		return dao.findAllAccount();
	}

	/**
	 * @param id
	 * @return  ����id��ȡ�˻���Ϣ
	 */
	public static Account findAccountById(int id) {
		AccountDao dao=new AccountImp();
		return dao.findAccountById(id);
	}

	/**
	 * @param uId
	 * @return  �����û���Ϣ��ȡ�˻���Ϣ
	 */
	public static Account findAccountByUserId(int uId) {
		AccountDao dao=new AccountImp();
		return dao.findAccountByUserId(uId);
	}
	
	/**
	 * @param uId
	 * @param newBills
	 * @return  �޸ľ۲Ʊ�����
	 */
	public static int updateBills(int uId,int newBills){
		AccountDao dao=new AccountImp();
		return dao.updateBills(uId, newBills);
	}
	
	/**
	 * @param uId
	 * @param integeral
	 * @return �޸Ļ�����Ϣ
	 */
	public static int updateIntegeral(int uId,int integeral){
		AccountDao dao=new AccountImp();
		return dao.updateIntegeral(uId, integeral);
	}

}
