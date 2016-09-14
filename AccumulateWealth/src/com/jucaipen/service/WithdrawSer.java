package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.WithdrawDao;
import com.jucaipen.daoimp.WithdrawImp;
import com.jucaipen.model.Withdraw;

public class WithdrawSer {

	/**
	 * @param id
	 * @return
	 *  ����id��ȡ������Ϣ
	 */
	public static  Withdraw findWithDrawById(int id) {
		WithdrawDao dao=new WithdrawImp();
		return dao.findWithDrawById(id);
	}

	/**
	 * @param userId
	 * @param page
	 * @return �����û�id��ȡ������Ϣ
	 */
	public static List<Withdraw> findWithDrawByUserId(int userId, int page) {
		WithdrawDao dao=new WithdrawImp();
		return dao.findWithDrawByUserId(userId, page);
	}

	/**
	 * @param withdraw
	 * @return ������ּ�¼
	 */
	public static int addWithDraw(Withdraw withdraw) {
		WithdrawDao dao=new WithdrawImp();
		return dao.addWithDraw(withdraw);
	}

}
