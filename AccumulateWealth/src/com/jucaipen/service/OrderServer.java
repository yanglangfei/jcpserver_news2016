package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.OrderDao;
import com.jucaipen.daoimp.OrderImp;
import com.jucaipen.model.Order;

public class OrderServer {

	/**
	 * @return ��ȡȫ���Ķ�����Ϣ
	 */
	public static List<Order> findAllPayOrderList(int page) {
		OrderDao dao = new OrderImp();
		return dao.findAllPayOrderList(page);
	}

	/**
	 * @param uId
	 * @return �����û�ID��ȡ������Ϣ
	 */
	public static List<Order> findPayOrderByUid(int uId, int page) {
		OrderDao dao = new OrderImp();
		return dao.findPayOrderByUid(uId, page);
	}

	/**
	 * @param payState
	 * @return ����֧��״̬��ȡ������Ϣ
	 */
	public static List<Order> findPayOrderByPayState(int payState, int page) {
		OrderDao dao = new OrderImp();
		return dao.findPayOrderByPayState(payState, page);
	}

	/**
	 * @param orderState
	 * @return ���ݶ���״̬��ȡ������Ϣ
	 */
	public static List<Order> findPayOrderByOrderState(int orderState, int page) {
		OrderDao dao = new OrderImp();
		return dao.findPayOrderByOrderState(orderState, page);
	}

	/**
	 * @param teacherId
	 * @return ���ݽ�ʦID��ȡ������Ϣ
	 */
	public static List<Order> findPayOrderByTeacherId(int teacherId, int page) {
		OrderDao dao = new OrderImp();
		return dao.findPayOrderByTeacherId(teacherId, page);
	}

	/**
	 * @param productState
	 * @return ������Ʒ״̬��ȡ������Ϣ
	 */
	public static List<Order> findPayOrderByProductState(int productState, int page) {
		OrderDao dao = new OrderImp();
		return dao.findPayOrderByProductState(productState, page);
	}

	/**
	 * @param lastCount
	 * @return ��ȡ�����������
	 */
	public static List<Order> findLastPayOrder(int lastCount) {
		OrderDao dao = new OrderImp();
		return dao.findLastPayOrder(lastCount);
	}

	/**
	 * @param id
	 * @return ����ID��ȡ������Ϣ
	 */
	public static Order findPayOrderById(int id) {
		OrderDao dao = new OrderImp();
		return dao.findPayOrderById(id);
	}
	
	/**
	 * @param id
	 * @return ��Ӷ�����Ϣ
	 */
	public static int addPayOrder(Order payOrder) {
		OrderDao dao = new OrderImp();
		return dao.addPayOrder(payOrder);
	}
	
	/**
	 * @param lastCount
	 * @return �޸Ķ���֧��״̬
	 */
	public static int changePayState(int payType,String payDate,String orderCode) {
		OrderDao dao = new OrderImp();
		return dao.changePayState(payType, payDate, orderCode);
	}

}
