package com.jucaipen.dao;

import com.jucaipen.model.Sign;

/**
 * @author Administrator
 *
 *  ǩ��
 */
public interface SignDao {
	
	/**
	 * @param userId
	 * @return �����û�id��ȡǩ����Ϣ
	 */
	public Sign findSignByUid(int userId);
	
	/**
	 * @param sign
	 * @return ���ǩ����Ϣ
	 */
	public int addSign(Sign sign);
	
	/**
	 * @param sign
	 * @return  ����ǩ���ܱ�
	 */
	public int updateSign(Sign sign);
	
	/**
	 * @param uId
	 * @return  ��ȡǩ������
	 */
	public int findSignCount(int uId);

}
