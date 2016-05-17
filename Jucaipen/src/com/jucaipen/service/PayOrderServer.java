package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.PayOrderDao;
import com.jucaipen.daoimp.PayOrderImp;
import com.jucaipen.model.PayOrder;

public class PayOrderServer {

	/**
	 * @return ��ȡȫ���Ķ�����Ϣ
	 */
	public static List<PayOrder> findAllPayOrderList(int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findAllPayOrderList(page);
	}

	/**
	 * @param uId
	 * @return �����û�ID��ȡ������Ϣ
	 */
	public static List<PayOrder> findPayOrderByUid(int uId, int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderByUid(uId, page);
	}

	/**
	 * @param payState
	 * @return ����֧��״̬��ȡ������Ϣ
	 */
	public static List<PayOrder> findPayOrderByPayState(int payState, int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderByPayState(payState, page);
	}

	/**
	 * @param orderState
	 * @return ���ݶ���״̬��ȡ������Ϣ
	 */
	public static List<PayOrder> findPayOrderByOrderState(int orderState, int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderByOrderState(orderState, page);
	}

	/**
	 * @param teacherId
	 * @return ���ݽ�ʦID��ȡ������Ϣ
	 */
	public static List<PayOrder> findPayOrderByTeacherId(int teacherId, int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderByTeacherId(teacherId, page);
	}

	/**
	 * @param productState
	 * @return ������Ʒ״̬��ȡ������Ϣ
	 */
	public static List<PayOrder> findPayOrderByProductState(int productState, int page) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderByProductState(productState, page);
	}

	/**
	 * @param lastCount
	 * @return ��ȡ�����������
	 */
	public static List<PayOrder> findLastPayOrder(int lastCount) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findLastPayOrder(lastCount);
	}

	/**
	 * @param id
	 * @return ����ID��ȡ������Ϣ
	 */
	public static PayOrder findPayOrderById(int id) {
		PayOrderDao dao = new PayOrderImp();
		return dao.findPayOrderById(id);
	}
	
	/**
	 * @param id
	 * @return ��Ӷ�����Ϣ
	 */
	public static int addPayOrder(PayOrder payOrder) {
		PayOrderDao dao = new PayOrderImp();
		return dao.addPayOrder(payOrder);
	}
	
	/**
	 * @param lastCount
	 * @return �޸Ķ���֧��״̬
	 */
	public static int changePayState(int payType,String payDate,String orderCode) {
		PayOrderDao dao = new PayOrderImp();
		return dao.changePayState(payType, payDate, orderCode);
	}

}
