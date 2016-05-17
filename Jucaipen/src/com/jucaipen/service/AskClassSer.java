package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.AskClassDao;
import com.jucaipen.daoimp.AskClassImp;
import com.jucaipen.model.AskClass;

public class AskClassSer{

	/**
	 * @return 获取所有的问题分类
	 */
	public static List<AskClass> findAllClass() {
		AskClassDao dao=new AskClassImp();
		return dao.findAllClass();
	}

	/**
	 * @param id
	 * @return 根据id获取问题分类
	 */
	public static AskClass findAskClassById(int id) {
		AskClassDao dao=new AskClassImp();
		return dao.findAskClassById(id);
	}

}
