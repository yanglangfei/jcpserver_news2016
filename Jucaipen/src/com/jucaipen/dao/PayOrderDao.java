package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.PayOrder;

/**
 * @author Administrator
 * 
 * 
 *         ������Ϣ
 */
public interface PayOrderDao {

	/**
	 * @return ��ȡ�����б�
	 */
	public List<PayOrder> findAllPayOrderList(int page);

	/**
	 * @param uId
	 * @return �����û�ID����ȡ������Ϣ
	 */
	public List<PayOrder> findPayOrderByUid(int uId, int page);

	/**
	 * @param payState
	 * @return ���ݸ���״̬��ȡ������Ϣ
	 */
	public List<PayOrder> findPayOrderByPayState(int payState, int page);

	/**
	 * @param orderState
	 * @return ���ݶ���״̬��ȡ������Ϣ
	 */
	public List<PayOrder> findPayOrderByOrderState(int orderState, int page);

	/**
	 * @param teacherId
	 * @return ���ݽ�ʦID��ȡ������Ϣ
	 */
	public List<PayOrder> findPayOrderByTeacherId(int teacherId, int page);

	/**
	 * @param productState
	 * @return ������Ʒ״̬��ȡ������Ϣ
	 */
	public List<PayOrder> findPayOrderByProductState(int productState, int page);

	/**
	 * @param lastCount
	 * @return ��ȡ�������������Ϣ
	 */
	public List<PayOrder> findLastPayOrder(int lastCount);

	/**
	 * @param id
	 * @return ����ID��ȡ������Ϣ
	 */
	public PayOrder findPayOrderById(int id);
	
	
	/**
	 * @param payOrder
	 * @return   ��Ӷ�����Ϣ
	 */
	public int addPayOrder(PayOrder payOrder);
	
	/**
	 * @param payType
	 * @param payDate
	 * @return    �ı�֧��״̬
	 */
	public int changePayState(int payType,String payDate,String orderCode);
}
