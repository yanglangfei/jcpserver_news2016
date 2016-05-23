package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.RebateIntegeralDetail;

/**
 * @author Administrator
 *
 *  ��������
 */
public interface RebateIntegeralDetailDao {
	
	/**
	 * @param id
	 * @return ����id��ȡ�������ּ�¼
	 */
	public RebateIntegeralDetail findRebateIntegeralById(int id);
	
	/**
	 * @param userId
	 * @param page
	 * @return ͨ���û�id��ȡ����������Ϣ
	 */
	public List<RebateIntegeralDetail> findRebateIntegeralByUserId(int userId,int page);
	
	/**
	 * @param inDetail
	 * @return  ��������������Ϣ
	 */
	public int addRebateIntegeral(RebateIntegeralDetail inDetail);

}
