package com.jucaipen.dao;

import com.jucaipen.model.CheckDetail;

/**
 * @author Administrator
 *
 *  �����ϸ��Ϣ
 */
public interface CheckDetailDao {
	
	/**
	 * @param id
	 * @return  ͨ��id��ȡ�����Ϣ
	 */
	public CheckDetail findCheckById(int id);
	
	/**
	 * @param applyId
	 * @return ͨ������id��ȡ�����Ϣ
	 */
	public CheckDetail findCheckByApplyId(int applyId);

}
