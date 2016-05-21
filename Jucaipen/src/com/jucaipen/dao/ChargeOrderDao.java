package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.ChargeOrder;

/**
 * @author Administrator
 *
 *  ��ֵ����
 */
public interface ChargeOrderDao {
	
	/**
	 * @param id
	 * @return ͨ��id��ȡ��ֵ��¼
	 */
	public ChargeOrder findOrderById(int id);
	
	/**
	 * @param userId
	 * @return  ͨ���û�id��ȡ��ֵ��¼
	 */
	public List<ChargeOrder> findOrderByUid(int userId,int page);
	
	/**
	 * @param order
	 * @return ��Ӷ���
	 */
	public int addOrder(ChargeOrder order);
	
}
