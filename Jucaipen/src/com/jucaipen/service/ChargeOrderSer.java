package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.ChargeOrderDao;
import com.jucaipen.daoimp.ChargeOrderImp;
import com.jucaipen.model.ChargeOrder;

/**
 * @author Administrator
 * ��ֵ��¼
 */
public class ChargeOrderSer {

	/**
	 * @param id
	 * @return  ����id��ȡ��ֵ��Ϣ
	 */
	public static ChargeOrder findOrderById(int id) {
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.findOrderById(id);
	}

	/**
	 * @param userId
	 * @param page
	 * @return �����û�id��ȡ��ֵ��¼
	 */
	public static List<ChargeOrder> findOrderByUid(int userId, int page) {
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.findOrderByUid(userId, page);
	}

	/**
	 * @param order
	 * @return ���ӳ�ֵ��¼
	 */
	public static int addOrder(ChargeOrder order) {
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.addOrder(order);
	}

}