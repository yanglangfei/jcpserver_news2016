package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.InvestmentType;


/**
 * @author Administrator
 *
 *  Ͷ�ʷ��
 */
public interface InvestmentTypeDao {
	
	/**
	 * @param id
	 * @return ͨ��id��ȡͶ�ʷ��
	 */
	public InvestmentType findTypeById(int id);
	
	/**
	 * @return ��ȡ���е�Ͷ�ʷ��
	 */
	public List<InvestmentType> findAllTypes();

}
