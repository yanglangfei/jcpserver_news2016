package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.UserBank;

public interface UserBankDao {
	
	/**
	 * @param userId
	 * @return  ��ȡ�û��󶨵��������п���Ϣ
	 */
	public List<UserBank> findAllBankInfo(int userId);
	
	/**
	 * @param bank
	 * @return ������п���Ϣ
	 */
	public int addUserBank(UserBank bank);
	
	/**
	 * @param id
	 * @return ������п���Ϣ
	 */
	public int removeUserBank(int id);

}
