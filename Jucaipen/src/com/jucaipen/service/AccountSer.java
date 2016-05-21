package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.AccountDao;
import com.jucaipen.daoimp.AccountImp;
import com.jucaipen.model.Account;

public class AccountSer{

	/**
	 * @return  获取所有账户信息
	 */
	public static List<Account> findAllAccount() {
		AccountDao dao=new AccountImp();
		return dao.findAllAccount();
	}

	/**
	 * @param id
	 * @return  根据id获取账户信息
	 */
	public static Account findAccountById(int id) {
		AccountDao dao=new AccountImp();
		return dao.findAccountById(id);
	}

	/**
	 * @param uId
	 * @return  根据用户信息获取账户信息
	 */
	public static Account findAccountByUserId(int uId) {
		AccountDao dao=new AccountImp();
		return dao.findAccountByUserId(uId);
	}

}
