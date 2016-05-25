package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Fans;


/**
 * @author Administrator
 *
 *  ��˿
 */
public interface FansDao {
	
	/**
	 * @param userId
	 * @return �����û�id��ȡ��˿��Ϣ
	 */
	public List<Fans> findFansByUid(int userId,int page);
	
	/**
	 * @param teacherId
	 * @return  ���ݽ�ʦid��ȡ��˿��Ϣ
	 */
	public List<Fans> findFansByTeacherId(int teacherId,int page);
	
	/**
	 * @param id
	 * @return ����id��ȡ��˿��Ϣ
	 */
	public Fans findFansById(int id);

}