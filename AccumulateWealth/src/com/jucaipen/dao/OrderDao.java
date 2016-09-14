package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Order;

/**
 * @author Administrator
 * 
 * 
 *         ������Ϣ
 */
public interface OrderDao {

	/**
	 * @return ��ȡ�����б�
	 */
	public List<Order> findAllPayOrderList(int page);

	/**
	 * @param uId
	 * @return �����û�ID����ȡ������Ϣ
	 */
	public List<Order> findPayOrderByUid(int uId, int page);

	/**
	 * @param payState
	 * @return ���ݸ���״̬��ȡ������Ϣ
	 */
	public List<Order> findPayOrderByPayState(int payState, int page);

	/**
	 * @param orderState
	 * @return ���ݶ���״̬��ȡ������Ϣ
	 */
	public List<Order> findPayOrderByOrderState(int orderState, int page);

	/**
	 * @param teacherId
	 * @return ���ݽ�ʦID��ȡ������Ϣ
	 */
	public List<Order> findPayOrderByTeacherId(int teacherId, int page);

	/**
	 * @param productState
	 * @return ������Ʒ״̬��ȡ������Ϣ
	 */
	public List<Order> findPayOrderByProductState(int productState, int page);

	/**
	 * @param lastCount
	 * @return ��ȡ�������������Ϣ
	 */
	public List<Order> findLastPayOrder(int lastCount);

	/**
	 * @param id
	 * @return ����ID��ȡ������Ϣ
	 */
	public Order findPayOrderById(int id);
	
	
	/**
	 * @param payOrder
	 * @return   ��Ӷ�����Ϣ
	 */
	public int addPayOrder(Order payOrder);
	
	/**
	 * @param payType
	 * @param payDate
	 * @return    �ı�֧��״̬
	 */
	public int changePayState(int payType,String payDate,String orderCode);
}
