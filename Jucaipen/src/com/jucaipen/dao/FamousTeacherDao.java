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
	 * @param tId
	 * @return  ��ȡ��ʦ������Ϣ
	 */
	public FamousTeacher findTeacherBaseInfo(int tId);
	
	/**
	 * @param fans
	 * @param id
	 * @return  ���·�˿����
	 */
	public int updateFansNum(int fans,int id);
	
	/**
	 * @param num
	 * @param id
	 * @return  ������������
	 */
	public int updateAskNum(int num,int id);
	
	/**
	 * @return ��ȡ������ʦ��Ϣ   ��ҳ
	 */
	public List<FamousTeacher> findAllFamousTeacher(int page);
	
	/**
	 * @return  ��ȡ���н�ʦ��Ϣ    ����ҳ
	 */
	public List<FamousTeacher> findAllTeacher();
	
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
	
	/**
	 * @param id
	 * @return  ��ȡ���������
	 */
	public int findMaxAsk(int id);
	
	/**
	 * @param tId
	 * @return  ��ȡ��ʦ�ػ���Ϣ
	 */
	public FamousTeacher findPurchInfo(int tId);
	

}
