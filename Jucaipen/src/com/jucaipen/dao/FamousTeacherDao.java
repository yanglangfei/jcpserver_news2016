package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.FamousTeacher;

public interface FamousTeacherDao {
	
	/**
	 * @param condition
	 * @return ��ȡ��ʦ��Ϣ��ҳ��
	 */
	public int findTotlePage(String condition);
	
	/**
	 * @return  ��ȡ���з�˿����
	 */
	public List<FamousTeacher> findIndexData();
	
	/**
	 * @return ��ȡ������ʦ��Ϣ
	 */
	public List<FamousTeacher> findAllFamousTeacher(int page);
	
	/**
	 * @param count
	 * @return ��ȡ�Ƽ��ļ�����ʦ
	 */
	public List<FamousTeacher>  findFamousTeacherByIndex(int count);
	
	/**
	 * @param id
	 * @return ����id��ȡ��ʦ��Ϣ
	 */
	public FamousTeacher findFamousTeacherById(int id);
	

}
