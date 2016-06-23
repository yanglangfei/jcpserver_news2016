package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Rebate;

public interface RebateDao {
	
	/**
	 * @param id
	 * @return ͨ��id��ȡ������Ϣ
	 */
	public  Rebate findRebateById(int id);
	
	
	public int contributeBills(int uId,int tId);
	
	/**
	 * @param teacherId
	 * @return ���ݽ�ʦ��ȡ������Ϣ  ��ҳ
	 */
	public List<Rebate> findRebateByTid(int teacherId,int page);
	
	
	/**
	 * @param userId
	 * @return  ��ȡ�ҵķ�����Ϣ
	 */
	public List<Rebate> findRebateByUserId(int userId,int page);
	
	/**
	 * @param teacherId
	 * @param 
	 * @return  ���ݽ�ʦ��ȡ������Ϣ  �޷�ҳ
	 */
	public List<Rebate> findRebateByTid(int teacherId);

	
	/**
	 * @param rebate
	 * @return ��ӷ�����¼
	 */
	public int addRebate(Rebate rebate);
	
	/**
	 * @param uId
	 * @param tId
	 * @return  ��ȡ�û����׽�ʦ�۲Ʊ���Ϣ
	 */
	public List<Rebate> findRebate(int uId,int tId);

}
