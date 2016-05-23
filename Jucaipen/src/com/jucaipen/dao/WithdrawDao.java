package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Withdraw;

public interface WithdrawDao {
	
	/**
	 * @param id
	 * @return ͨ��id��ȡ������Ϣ
	 */
	public Withdraw  findWithDrawById(int id);
	
	/**
	 * @param userId
	 * @param page
	 * @return ͨ���û���ȡ������Ϣ
	 */
	public List<Withdraw> findWithDrawByUserId(int userId,int page);
	
	/**
	 * @param withdraw
	 * @return ���������Ϣ
	 */
	public int addWithDraw(Withdraw withdraw);

}
