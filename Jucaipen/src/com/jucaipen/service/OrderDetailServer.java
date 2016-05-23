package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.OrderDetailDao;
import com.jucaipen.daoimp.OrderDetailImp;
import com.jucaipen.model.OrderDetail;

public class OrderDetailServer {

	/**
	 * @return ��ȡȫ��������Ϣ
	 */
	public static List<OrderDetail> findAllPayProductList(int page) {
		OrderDetailDao dao = new OrderDetailImp();
		return dao.findAllPayProductList(page);
	}

	/**
	 * @param uId
	 * @return �����û�ID��ȡ������ϸ��Ϣ
	 */
	public static List<OrderDetail> findPayProductByUid(int uId, int page) {
		OrderDetailDao dao = new OrderDetailImp();
		return dao.findPayProductByUid(uId, page);
	}

	/**
	 * @param productId
	 * @return ������ƷID��ȡ������ϸ��Ϣ
	 */
	public static List<OrderDetail> findPayProductByProductId(int productId, int page) {
		OrderDetailDao dao = new OrderDetailImp();
		return dao.findPayProductByProductId(productId, page);
	}

	/**
	 * @param orderId
	 * @return ���ݶ���ID��ȡ������ϸ��Ϣ
	 */
	public static OrderDetail findPayProductByOrderId(String orderId) {
		OrderDetailDao dao = new OrderDetailImp();
		return dao.findPayProductByOrderId(orderId);
	}

	/**
	 * @param isDeleted
	 * @return ����״̬��ȡ������ϸ��Ϣ
	 */
	public static List<OrderDetail> findPayProductByIsDeleted(int isDeleted, int page) {
		OrderDetailDao dao = new OrderDetailImp();
		return dao.findPayProductByIsDeleted(isDeleted, page);
	}

	/**
	 * @param productType
	 * @return ������Ʒ���ͻ�ȡ������ϸ��Ϣ
	 */
	public static List<OrderDetail> findPayProductByProductType(int productType,
			int page) {
		OrderDetailDao dao = new OrderDetailImp();
		return dao.findPayProductByProductType(productType, page);
	}

	/**
	 * @param id
	 * @return ����ID��ȡ������ϸ��Ϣ
	 */
	public static OrderDetail findPayProductById(int id) {
		OrderDetailDao dao = new OrderDetailImp();
		return dao.findPayProductById(id);
	}

	/**
	 * @param lastCount
	 * @return ��ȡ�������������ϸ��Ϣ
	 */
	public static List<OrderDetail> findLastPayProduct(int lastCount) {
		OrderDetailDao dao = new OrderDetailImp();
		return dao.findLastPayProduct(lastCount);
	}
	
	/**
	 * @param lastCount
	 * @return ��Ӷ�����ϸ��Ϣ
	 */
	public static int addPayProductInfo(OrderDetail payProduct) {
		OrderDetailDao dao = new OrderDetailImp();
		return dao.addPayProductInfo(payProduct);
	}
	

}
