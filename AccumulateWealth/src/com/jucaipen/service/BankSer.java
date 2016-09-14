package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.BankDao;
import com.jucaipen.daoimp.BankImp;
import com.jucaipen.model.Bank;

/**
 * @author Administrator
 *
 *  ������Ϣ
 */
public class BankSer {

	/**
	 * @return ��ȡ����������Ϣ
	 */
	public static List<Bank> findAllBank() {
		BankDao dao=new BankImp();
		return dao.findAllBank();
	}

	/**
	 * @param id
	 * @return ����id��ȡ������Ϣ
	 */
	public static Bank findBankById(int id) {
		BankDao dao=new BankImp();
		return dao.findBankById(id);
	}

}
