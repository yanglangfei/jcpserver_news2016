package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.MyPresent;

/**
 * @author Administrator
 *
 *  ��Ʒ ���Լ�ӵ�еģ�
 */
public interface MyPresentDao {
	/**
	 * @param uId
	 * @param page
	 * @return  ��ȡ�ҵ���Ʒ 
	 */
	public List<MyPresent> findPresentByUserId(int uId,int page);
	
	/**
	 * @param id
	 * @return ͨ��id��ȡ�ҵ���Ʒ
	 */
	public MyPresent findPresentById(int id);
	/**
	 * @param present
	 * @return ������Ʒ
	 */
	public int addPresent(MyPresent present);
	/**
	 * @param present
	 * @return  ������Ʒ  ���޸���Ʒ������
	 */
	public int sendPresent(MyPresent present);

}