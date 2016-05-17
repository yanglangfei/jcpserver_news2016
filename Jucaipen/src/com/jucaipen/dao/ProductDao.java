package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Product;

public interface ProductDao {
	/**
	 * @return   ��ѯ���в�Ʒ��Ϣ
	 */
	public List<Product> findAll(int pager);

	/**
	 * @param id
	 * @return   ����id��ѯ��Ʒ��Ϣ
	 */
	public Product findProduct(int id);
	/**
	 * @param teacherId
	 * @return   ���ݽ�ʦID��ȡ��Ʒ��Ϣ
	 */
	public List<Product> findProductByTeacherId(int teacherId,int page);
	/**
	 * @param types
	 * @return   ������Ʒ���ͻ�ȡ��Ʒ��Ϣ
	 */
	public List<Product> findProductByTypes(int types,int page);
	
	/**
	 * @param saleState
	 * @return  ��������״̬��ȡ��Ʒ��Ϣ
	 */
	public List<Product> findProductBySaleState(int saleState,int page);
	
	/**
	 * @param isDeleted
	 * @return  ������Ʒ״̬��ȡ��Ʒ��Ϣ
	 */
	public List<Product> findProductByProductState(int isDeleted,int page);
	
	/**
	 * @param lastCount
	 * @return  ��ȡ������ߵļ�����Ʒ
	 */
	public List<Product> findLastProduct(int lastCount);

}
