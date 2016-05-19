package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.OrderDetail;

/**
 * @author Administrator
 * 
 * 
 *         ������ϸ��Ϣ
 */
public interface OrderDetailDao {

	/**
	 * @return ��ȡ������ϸ��Ϣ�б�
	 */
	public List<OrderDetail> findAllPayProductList(int page);

	/**
	 * @param uId
	 * @return �����û�ID����ȡ������ϸ��Ϣ
	 */
	public List<OrderDetail> findPayProductByUid(int uId,int page);

	/**
	 * @param productId
	 * @return ������ƷID��ȡ������Ϣ
	 */
	public List<OrderDetail> findPayProductByProductId(int productId,int page);

	/**
	 * @param orderId
	 * @return ���ݶ���ID��ȡ������ϸ��Ϣ
	 */
	public OrderDetail findPayProductByOrderId(String orderId);

	/**
	 * @param isDeleted
	 * @return ����IsDelete
	 */
	public List<OrderDetail> findPayProductByIsDeleted(int isDeleted,int page);

	/**
	 * @param productType
	 * @return ������Ʒ���ͻ�ȡ������ϸ��Ϣ
	 */
	public List<OrderDetail> findPayProductByProductType(int productType,int page);

	/**
	 * @param id
	 * @return ����ID��ȡ������ϸ��Ϣ
	 */
	public OrderDetail findPayProductById(int id);

	/**
	 * @param lastCount
	 * @return ��ȡ�������������ϸ��Ϣ
	 */
	public List<OrderDetail> findLastPayProduct(int lastCount);
	
	
	/**
	 * @param payProduct
	 * @return   ��Ӷ�����Ϣ
	 */
	public int addPayProductInfo(OrderDetail payProduct);

}
