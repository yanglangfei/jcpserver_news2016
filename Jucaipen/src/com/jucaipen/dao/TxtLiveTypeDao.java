package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.TxtLiveType;

/**
 * @author Administrator
 *
 *  ����ֱ��������Ϣ
 */
public interface TxtLiveTypeDao {
	
	/**
	 * @return
	 *   ��ȡ��������ֱ��������Ϣ
	 */
	public List<TxtLiveType> findAll();
	
	/**
	 * @param id
	 * @return ����id��ȡ����ֱ��������Ϣ
	 */
	public TxtLiveType findTypeById(int id); 

}
