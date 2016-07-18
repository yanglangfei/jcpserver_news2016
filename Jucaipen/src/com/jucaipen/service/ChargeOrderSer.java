package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.ChargeOrderDao;
import com.jucaipen.daoimp.ChargeOrderImp;
import com.jucaipen.model.ChargeOrder;

/**
 * @author Administrator
 * 充值记录
 */
public class ChargeOrderSer {

	/**
	 * @param id
	 * @return  根据id获取充值信息
	 */
	public static ChargeOrder findOrderById(int id) {
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.findOrderById(id);
	}

	/**
	 * @param userId
	 * @param page
	 * @return 根据用户id获取充值记录
	 */
	public static List<ChargeOrder> findOrderByUid(int userId, int page) {
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.findOrderByUid(userId, page);
	}
	
	public static List<ChargeOrder> findOrderByUidAndState(int uId,int state,int page){
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.findOrderByUidAndState(uId, state, page);
	}

	/**
	 * @param order
	 * @return 添加充值记录
	 */
	public static int addOrder(ChargeOrder order) {
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.addOrder(order);
	}
	
	/**
	 * @param orderCode
	 * @param state
	 * @param payDate
	 * @param ip
	 * @return  修改充值订单状态
	 */
	public static int updatePayState(String orderCode,int state,String payDate,String ip){
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.updatePayState(orderCode, state, payDate, ip);
	}

}
