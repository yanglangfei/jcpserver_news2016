package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Bank;

/**
 * @author Administrator
 *
 *  ������Ϣ
 */
public interface BankDao {
	
	/**
	 * @return ��ȡ����������Ϣ
	 */
	public List<Bank> findAllBank();
	
	/**
	 * @param id
	 * @return ����id��ȡ������Ϣ
	 */
	public Bank findBankById(int id);

}
