package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.KnowledgeDao;
import com.jucaipen.daoimp.KnowledgeImp;
import com.jucaipen.model.Knowledge;

public class KnowledgetSer {

	/**
	 * @param id
	 * @return ����id��ȡ֪ʶ��Ϣ
	 */
	public static Knowledge findKnowledgeById(int id) {
		KnowledgeDao dao=new KnowledgeImp();
		return dao.findKnowledgeById(id);
	}

	/**
	 * @param classId
	 * @param page
	 * @return  ���ݷ����ȡ֪ʶ��Ϣ
	 */
	public static List<Knowledge> findKnowledgeByClassId(int classId, int page) {
		KnowledgeDao dao=new KnowledgeImp();
		return dao.findKnowledgeByClassId(classId, page);
	}

	/**
	 * @param page
	 * @return ��ȡ����֪ʶ��Ϣ
	 */
	public static List<Knowledge> findAllKnowledge(int page) {
		KnowledgeDao dao=new KnowledgeImp();
		return dao.findAllKnowledge(page);
	}
	
	/**
	 * @param id
	 * @param classId
	 * @return ��ȡ����ƪ��Ϣ
	 */
	public static Knowledge findTitleById(int id,int classId){
		KnowledgeDao dao=new KnowledgeImp();
		return dao.findTitleById(id, classId);
	}

}
