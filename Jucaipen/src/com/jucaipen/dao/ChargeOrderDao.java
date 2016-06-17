package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.ChargeOrder;

/**
 * @author Administrator
 *
 *  充值订单
 */
public interface ChargeOrderDao {
	
	/**
	 * @param id
	 * @return 通过id获取充值记录
	 */
	public ChargeOrder findOrderById(int id);
	
	/**
	 * @param userId
	 * @return  通过用户id获取充值记录
	 */
	public List<ChargeOrder> findOrderByUid(int userId,int page);
	
	public List<ChargeOrder> findOrderByUidAndState(int uId,int state,int page);
	
	/**
	 * @param order
	 * @return 添加订单
	 */
	public int addOrder(ChargeOrder order);
	
	/**
	 * @param id
	 * @return  删除充值订单信息
	 */
	public int deleteOrder(int id);
	
}
