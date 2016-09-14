package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.GiftClass;

public interface GiftClassDao {
	/**
	 * @return  ��ȡ���е���Ʒ������Ϣ
	 */
	public List<GiftClass> findAllClass();
	/**
	 * @param id
	 * @return ����id��ȡ������Ϣ
	 */
	public GiftClass findIdByClass(int id);
	
	public List<GiftClass>  findTopClass(int top);

}
