package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.PayProductDao;
import com.jucaipen.daoimp.PayProductImp;
import com.jucaipen.model.PayProduct;

public class PayProductServer {

	/**
	 * @return ��ȡȫ��������Ϣ
	 */
	public static List<PayProduct> findAllPayProductList(int page) {
		PayProductDao dao = new PayProductImp();
		return dao.findAllPayProductList(page);
	}

	/**
	 * @param uId
	 * @return �����û�ID��ȡ������ϸ��Ϣ
	 */
	public static List<PayProduct> findPayProductByUid(int uId, int page) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductByUid(uId, page);
	}

	/**
	 * @param productId
	 * @return ������ƷID��ȡ������ϸ��Ϣ
	 */
	public static List<PayProduct> findPayProductByProductId(int productId, int page) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductByProductId(productId, page);
	}

	/**
	 * @param orderId
	 * @return ���ݶ���ID��ȡ������ϸ��Ϣ
	 */
	public static PayProduct findPayProductByOrderId(String orderId) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductByOrderId(orderId);
	}

	/**
	 * @param isDeleted
	 * @return ����״̬��ȡ������ϸ��Ϣ
	 */
	public static List<PayProduct> findPayProductByIsDeleted(int isDeleted, int page) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductByIsDeleted(isDeleted, page);
	}

	/**
	 * @param productType
	 * @return ������Ʒ���ͻ�ȡ������ϸ��Ϣ
	 */
	public static List<PayProduct> findPayProductByProductType(int productType,
			int page) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductByProductType(productType, page);
	}

	/**
	 * @param id
	 * @return ����ID��ȡ������ϸ��Ϣ
	 */
	public static PayProduct findPayProductById(int id) {
		PayProductDao dao = new PayProductImp();
		return dao.findPayProductById(id);
	}

	/**
	 * @param lastCount
	 * @return ��ȡ�������������ϸ��Ϣ
	 */
	public static List<PayProduct> findLastPayProduct(int lastCount) {
		PayProductDao dao = new PayProductImp();
		return dao.findLastPayProduct(lastCount);
	}
	
	/**
	 * @param lastCount
	 * @return ��Ӷ�����ϸ��Ϣ
	 */
	public static int addPayProductInfo(PayProduct payProduct) {
		PayProductDao dao = new PayProductImp();
		return dao.addPayProductInfo(payProduct);
	}
	

}
