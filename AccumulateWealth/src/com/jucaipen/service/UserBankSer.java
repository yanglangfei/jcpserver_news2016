package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.UserBankDao;
import com.jucaipen.daoimp.UserBankImp;
import com.jucaipen.model.UserBank;

/**
 * @author Administrator
 *
 *  �û����п���Ϣ
 */
public class UserBankSer  {

	public static List<UserBank> findAllBankInfo(int userId) {
		//��ȡ�û��������п���Ϣ
		UserBankDao dao=new UserBankImp();
		return dao.findAllBankInfo(userId);
	}

	public static int addUserBank(UserBank bank) {
		UserBankDao dao=new UserBankImp();
		return dao.addUserBank(bank);
	}

	public static int removeUserBank(int id) {
		UserBankDao dao=new UserBankImp();
		return dao.removeUserBank(id);
	}

}
