package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.OrderEquity;

/**
 * @author ylf
 * 
 *    ԤԼ��Ȩ
 *
 */
public interface OrderEquityDao {
	/**
	 * @param uId
	 * @param eId
	 * @return   ԤԼ��Ȩ
	 */
	public int insertEquity(int uId,OrderEquity oe);
	/**
	 * @param uId
	 * @param eId
	 * @return   ȡ��ԤԼ��Ȩ
	 */
	public int cancelEquity(int uId,int eId,int oType);
	/**
	 * @param uId
	 * @return   ��ѯ��ǰ�û�ԤԼ�����й�Ȩ
	 */
	public List<OrderEquity> findOrderEquity(int uId,int pager);
}
