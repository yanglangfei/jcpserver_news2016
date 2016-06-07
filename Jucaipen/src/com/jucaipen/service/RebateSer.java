package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.RebateDao;
import com.jucaipen.daoimp.RebateImp;
import com.jucaipen.model.Rebate;

/**
 * @author Administrator
 *
 *  返利
 */
public class RebateSer {

	/**
	 * @param id
	 * @return 根据id获取返利信息
	 */
	public static Rebate findRebateById(int id) {
		RebateDao dao=new RebateImp();
		return dao.findRebateById(id);
	}

	/**
	 * @param teacherId
	 * @param page
	 * @return 根据讲师id获取返利信息   分页
	 */
	public static List<Rebate> findRebateByTid(int teacherId, int page) {
		RebateDao dao=new RebateImp();
		return dao.findRebateByTid(teacherId, page);
	}
	
	/**
	 * @param teacherId
	 * @return 根据讲师id获取返利信息  无分页
	 */
	public static List<Rebate> findRebateByTid(int teacherId) {
		RebateDao dao=new RebateImp();
		return dao.findRebateByTid(teacherId);
	}

	/**
	 * @param rebate
	 * @return 添加返利信息
	 */
	public static int addRebate(Rebate rebate) {
		RebateDao dao=new RebateImp();
		return dao.addRebate(rebate);
	}

	/**
	 * @param uId
	 * @param tId
	 * @return  获取用户贡献讲师聚财币信息
	 */
	public static List<Rebate> findRebate(int uId,int tId){
		RebateDao dao=new RebateImp();
		return dao.findRebate(uId, tId);
	}
	
}
