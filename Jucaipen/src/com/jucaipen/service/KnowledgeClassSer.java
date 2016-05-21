package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.KnowledgeClassDao;
import com.jucaipen.daoimp.KnowledgeClassImp;
import com.jucaipen.model.KnowledgeClass;

public class KnowledgeClassSer  {

	/**
	 * @param id
	 * @return ����id��ȡ֪ʶ������Ϣ
	 */
	public static KnowledgeClass findKnowledgeById(int id) {
		KnowledgeClassDao dao=new KnowledgeClassImp();
		return dao.findKnowledgeById(id);
	}

	/**
	 * @return ��ȡ���е�֪ʶ������Ϣ
	 */
	public static List<KnowledgeClass> findAllKnowledgeClass() {
		KnowledgeClassDao dao=new KnowledgeClassImp();
		return dao.findAllKnowledgeClass();
	}

}
