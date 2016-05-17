package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.TeacherDynamic;

public interface TeacherDynamicDao {
	
	
	/**
	 * @param dynamic
	 * @return  ��ӽ�ʦ��̬
	 */
	public int insertDynamic(TeacherDynamic dynamic);
	
	/**
	 * @return ��ȡ��ʦ���ж�̬
	 */
	public List<TeacherDynamic> findAllDynamic();
	/**
	 * @param type
	 * @return ���ݷ����ȡ��ʦ��̬��Ϣ
	 */
	public List<TeacherDynamic> findDynamicByType(int type);
	/**
	 * @param id
	 * @return ���ݶ�̬id��ȡ��ʦ��̬��Ϣ
	 */
	public TeacherDynamic findDynamicById(int id);

}
