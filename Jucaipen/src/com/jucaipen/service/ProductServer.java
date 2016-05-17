package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.ProductDao;
import com.jucaipen.daoimp.ProductImp;
import com.jucaipen.model.Product;

public class ProductServer {
	/**
	 * @return ��ѯ���в�Ʒ
	 */
	public static List<Product> findALL(int pager) {
		ProductDao dao = new ProductImp();
		return dao.findAll(pager);
	}

	/**
	 * @param id
	 * @return ����id��ѯ��Ʒ��Ϣ
	 */
	public static Product findProduct(int id) {
		ProductDao dao = new ProductImp();
		return dao.findProduct(id);
	}

	/**
	 * @param teacherId
	 * @return ���ݽ�ʦID��ȡ��Ʒ��Ϣ
	 */
	public List<Product> findProductByTeacherId(int teacherId, int page) {
		ProductDao dao = new ProductImp();
		return dao.findProductByTeacherId(teacherId, page);
	}

	/**
	 * @param types
	 * @return ������Ʒ�����ȡ��Ʒ��Ϣ
	 */
	public List<Product> findProductByTypes(int types, int page) {
		ProductDao dao = new ProductImp();
		return dao.findProductByTypes(types, page);
	}

	/**
	 * @param saleState
	 * @return ��������״̬��ȡ��Ʒ��Ϣ
	 */
	public List<Product> findProductBySaleState(int saleState, int page) {
		ProductDao dao = new ProductImp();
		return dao.findProductBySaleState(saleState, page);
	}

	/**
	 * @param isDeleted
	 * @return ������Ʒ״̬��ȡ��Ʒ��Ϣ
	 */
	public List<Product> findProductByProductState(int isDeleted, int page) {
		ProductDao dao = new ProductImp();
		return dao.findProductByProductState(isDeleted, page);
	}

	/**
	 * @param lastCount
	 * @return ��ȡ���������Ʒ��Ϣ
	 */
	public List<Product> findLastProduct(int lastCount) {
		ProductDao dao = new ProductImp();
		return dao.findLastProduct(lastCount);
	}

}
