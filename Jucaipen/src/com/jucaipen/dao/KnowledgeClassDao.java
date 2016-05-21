package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.KnowledgeClass;

/**
 * @author Administrator
 *
 *  知识分类信息
 */
public interface KnowledgeClassDao {
	
	/**
	 * @param id
	 * @return 通过id获取知识分类信息
	 */
	public KnowledgeClass findKnowledgeById(int id);
	
	/**
	 * @return 获取所有的知识分类信息
	 */
	public List<KnowledgeClass> findAllKnowledgeClass();
	

}
