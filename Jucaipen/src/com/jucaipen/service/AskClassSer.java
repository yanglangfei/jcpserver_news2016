package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.AskClassDao;
import com.jucaipen.daoimp.AskClassImp;
import com.jucaipen.model.AskClass;

public class AskClassSer{

	/**
	 * @return ��ȡ���е��������
	 */
	public static List<AskClass> findAllClass() {
		AskClassDao dao=new AskClassImp();
		return dao.findAllClass();
	}

	/**
	 * @param id
	 * @return ����id��ȡ�������
	 */
	public static AskClass findAskClassById(int id) {
		AskClassDao dao=new AskClassImp();
		return dao.findAskClassById(id);
	}

}
