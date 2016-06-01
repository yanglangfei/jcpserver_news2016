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
	 * @return �����û�id��ȡ�ҹ�ע�Ľ�ʦ
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
	
	/**
	 * @param uId
	 * @param tId
	 * @return ��ѯ�û��Ƿ��ע��ʦ
	 */
	public Fans findIsFans(int uId,int tId);
	
	/**
	 * @param fans
	 * @return  ��ӹ�ע
	 */
	public int addFans(Fans fans);
	
	/**
	 * @param id
	 * @return  ȡ����ע
	 */
	public int cancelFans(int tId,int uId);

}
