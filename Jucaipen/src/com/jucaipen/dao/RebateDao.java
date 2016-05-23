package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Rebate;

public interface RebateDao {
	
	/**
	 * @param id
	 * @return ͨ��id��ȡ������Ϣ
	 */
	public  Rebate findRebateById(int id);
	
	/**
	 * @param teacherId
	 * @return ���ݽ�ʦ��ȡ������Ϣ
	 */
	public List<Rebate> findRebateByTid(int teacherId,int page);
	
	/**
	 * @param rebate
	 * @return ��ӷ�����¼
	 */
	public int addRebate(Rebate rebate);

}
