package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.KnowledgeClass;

/**
 * @author Administrator
 *
 *  ֪ʶ������Ϣ
 */
public interface KnowledgeClassDao {
	
	/**
	 * @param id
	 * @return ͨ��id��ȡ֪ʶ������Ϣ
	 */
	public KnowledgeClass findKnowledgeById(int id);
	
	/**
	 * @return ��ȡ���е�֪ʶ������Ϣ
	 */
	public List<KnowledgeClass> findAllKnowledgeClass();
	

}
