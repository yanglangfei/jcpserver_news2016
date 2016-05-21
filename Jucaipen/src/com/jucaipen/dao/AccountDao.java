package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Account;

/**
 * @author Administrator
 *
 *  账户信息
 */
public interface AccountDao {
	
	/**
	 * @return  获取所有账户信息
	 */
	public List<Account> findAllAccount();
	
	/**
	 * @param id
	 * @return  通过id获取账户信息
	 */
	public Account findAccountById(int id);
	/**
	 * @param uId
	 * @return  通过用户id获取账户信息
	 */
	public Account findAccountByUserId(int uId);
	

}
