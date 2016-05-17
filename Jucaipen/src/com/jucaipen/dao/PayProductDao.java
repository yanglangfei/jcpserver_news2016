package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.PayProduct;

/**
 * @author Administrator
 * 
 * 
 *         ������ϸ��Ϣ
 */
public interface PayProductDao {

	/**
	 * @return ��ȡ������ϸ��Ϣ�б�
	 */
	public List<PayProduct> findAllPayProductList(int page);

	/**
	 * @param uId
	 * @return �����û�ID����ȡ������ϸ��Ϣ
	 */
	public List<PayProduct> findPayProductByUid(int uId,int page);

	/**
	 * @param productId
	 * @return ������ƷID��ȡ������Ϣ
	 */
	public List<PayProduct> findPayProductByProductId(int productId,int page);

	/**
	 * @param orderId
	 * @return ���ݶ���ID��ȡ������ϸ��Ϣ
	 */
	public PayProduct findPayProductByOrderId(String orderId);

	/**
	 * @param isDeleted
	 * @return ����IsDelete
	 */
	public List<PayProduct> findPayProductByIsDeleted(int isDeleted,int page);

	/**
	 * @param productType
	 * @return ������Ʒ���ͻ�ȡ������ϸ��Ϣ
	 */
	public List<PayProduct> findPayProductByProductType(int productType,int page);

	/**
	 * @param id
	 * @return ����ID��ȡ������ϸ��Ϣ
	 */
	public PayProduct findPayProductById(int id);

	/**
	 * @param lastCount
	 * @return ��ȡ�������������ϸ��Ϣ
	 */
	public List<PayProduct> findLastPayProduct(int lastCount);
	
	
	/**
	 * @param payProduct
	 * @return   ��Ӷ�����Ϣ
	 */
	public int addPayProductInfo(PayProduct payProduct);

}
