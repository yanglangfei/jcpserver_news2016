package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TeacherDynamicDao;
import com.jucaipen.daoimp.TeacherDynamicImp;
import com.jucaipen.model.TeacherDynamic;

public class TeacherDynamicSer{
	
	/**
	 * @param dynamic
	 * @return  ��ӽ�ʦ��̬��Ϣ
	 */
	public int insertDynamic(TeacherDynamic dynamic){
		TeacherDynamicDao dao=new TeacherDynamicImp();
		return dao.insertDynamic(dynamic);
	}

	/**
	 * @return ��ȡ���еĽ�ʦ��̬
	 */
	public List<TeacherDynamic> findAllDynamic() {
		TeacherDynamicDao dao=new TeacherDynamicImp();
		return dao.findAllDynamic();
	}

	/**
	 * @param type
	 * @return  �������ͻ�ȡ��ʦ��̬
	 */
	public List<TeacherDynamic> findDynamicByType(int type) {
		TeacherDynamicDao dao=new TeacherDynamicImp();
		return dao.findDynamicByType(type);
	}

	/**
	 * @param id
	 * @return  ����id��ȡ��ʦ��̬��ϸ��Ϣ
	 */
	public TeacherDynamic findDynamicById(int id) {
		TeacherDynamicDao dao=new TeacherDynamicImp();
		return dao.findDynamicById(id);
	}

}
