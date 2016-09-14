package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Recommder;

public interface RecommderDao {
	
	/**
	 * @param id
	 * @return ����id��ȡ�Ƽ���Ϣ
	 */
	public Recommder findRecommderById(int id);
	
	/**
	 * @param parentId
	 * @param page
	 * @return ��ȡ���Ƽ����û���Ϣ
	 */
	public List<Recommder> findRecommderByParentId(int parentId,int page);
	
	/**
	 * @param recommder
	 * @return ����Ƽ���Ϣ
	 *  
	 */
	public int addRecommder(Recommder recommder);

}
