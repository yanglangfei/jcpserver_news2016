package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.RebateDao;
import com.jucaipen.daoimp.RebateImp;
import com.jucaipen.model.Rebate;

/**
 * @author Administrator
 *
 *  ����
 */
public class RebateSer {

	/**
	 * @param id
	 * @return ����id��ȡ������Ϣ
	 */
	public static Rebate findRebateById(int id) {
		RebateDao dao=new RebateImp();
		return dao.findRebateById(id);
	}

	/**
	 * @param teacherId
	 * @param page
	 * @return ���ݽ�ʦid��ȡ������Ϣ   ��ҳ
	 */
	public static List<Rebate> findRebateByTid(int teacherId, int page) {
		RebateDao dao=new RebateImp();
		return dao.findRebateByTid(teacherId, page);
	}
	
	/**
	 * @param userId
	 * @param page
	 * @return  ��ȡ�ҵķ�����Ϣ
	 */
	public static List<Rebate> findRebateByUserId(int userId,int page){
		RebateDao dao=new RebateImp();
		return dao.findRebate(userId, page);
	}
	
	public static int contributeBills(int uId,int tId){
		RebateDao dao=new RebateImp();
		return dao.contributeBills(uId, tId);
	}
	
	/**
	 * @param teacherId
	 * @return ���ݽ�ʦid��ȡ������Ϣ  �޷�ҳ
	 */
	public static List<Rebate> findRebateByTid(int teacherId) {
		RebateDao dao=new RebateImp();
		return dao.findRebateByTid(teacherId);
	}

	/**
	 * @param rebate
	 * @return ��ӷ�����Ϣ
	 */
	public static int addRebate(Rebate rebate) {
		RebateDao dao=new RebateImp();
		return dao.addRebate(rebate);
	}

	/**
	 * @param uId
	 * @param tId
	 * @return  ��ȡ�û����׽�ʦ�۲Ʊ���Ϣ
	 */
	public static List<Rebate> findRebate(int uId,int tId){
		RebateDao dao=new RebateImp();
		return dao.findRebate(uId, tId);
	}
	
}
