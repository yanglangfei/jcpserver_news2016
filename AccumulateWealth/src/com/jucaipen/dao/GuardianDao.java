package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Guardian;

/**
 * @author Administrator
 *
 *  �ػ��� 
 */
public interface GuardianDao {
	
	/**
	 * @param id
	 * @return ����id��ȡ�ػ�����Ϣ
	 */
	public Guardian findGuardianById(int id);
	
	/**
	 * @param userId
	 * @return ͨ���û�id��ȡ���ػ�����Ϣ
	 */
	public List<Guardian> findGurdianByUid(int userId,int page);
	
	/**
	 * @param teacherId
	 * @return ͨ����ʦid��ȡ�ػ��ҵ���Ϣ   ��ҳ
	 */
	public List<Guardian> findGuradianByTeacherId(int teacherId,int page);
	
	/**
	 * @param teacherId
	 * @return ͨ����ʦid��ȡ�ػ��ҵ���Ϣ   �޷�ҳ
	 */
	public List<Guardian> findGuradianByTeacherId(int teacherId);

	
	/**
	 * @param guardian
	 * @return ����ػ���Ϣ
	 */
	public int addGuardian(Guardian guardian);
	
	/**
	 * @param teacherId
	 * @param userId
	 * @return  ��ȡ�Ƿ��ػ�
	 */
	public Guardian findIsGuardian(int teacherId,int userId);

}
