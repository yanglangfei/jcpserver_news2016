package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Knowledge;

/**
 * @author Administrator
 *
 *  ֪ʶ
 */
public interface KnowledgeDao {
	
	/**
	 * @param id
	 * @return ����id��ȡ֪ʶ��Ϣ
	 */
	public Knowledge findKnowledgeById(int id);
	
	/**
	 * @param classId
	 * @param page
	 * @return  ���ݷ����ȡ֪ʶ��Ϣ
	 */
	public List<Knowledge> findKnowledgeByClassId(int classId,int page);
	
	/**
	 * @return ��ȡ���е�֪ʶ��Ϣ
	 */
	public List<Knowledge> findAllKnowledge(int page);
	/**
	 * @param id
	 * @return  ��ȡ����ƪ��Ϣ
	 */
	public Knowledge findTitleById(int id,int classId);
	
	public int addHits(int id,int hits,int xnHits);
	

}
