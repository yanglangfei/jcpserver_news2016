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
	
	public List<ChargeOrder> findOrderByUidAndState(int uId,int state,int page);
	
	/**
	 * @param order
	 * @return ��Ӷ���
	 */
	public int addOrder(ChargeOrder order);
	
	/**
	 * @param id
	 * @return  ɾ����ֵ������Ϣ
	 */
	public int deleteOrder(int id);
	
	/**
	 * @param orderCode
	 * @param state
	 * @param payDate
	 * @param ip
	 * @return  �޸�֧��״̬
	 */
	public int updatePayState(String orderCode,int state,String payDate,String ip);
	
}
