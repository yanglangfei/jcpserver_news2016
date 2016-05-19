package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.IdeaSaleDao;
import com.jucaipen.daoimp.IdeaSaleImp;
import com.jucaipen.model.IdeaSale;

/**
 * @author Administrator
 *   观点销售信息
 */
public class IdeaSaleServer{

	/**
	 * @return   获取所有的观点购买信息
	 */
	public static List<IdeaSale> findAllTxtLiveSale() {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findAllTxtLiveSale();
	}

	/**
	 * @param userId
	 * @return   根据用户id获取观点购买信息
	 */
	public static List<IdeaSale> findTxtLiveSaleByUid(int userId) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByUid(userId);
	}

	/**
	 * @param teacherId
	 * @return   根据讲师id获取观点购买信息
	 */
	public static List<IdeaSale> findTxtLiveSaleByTeacherId(int teacherId) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByTeacherId(teacherId);
	}

	/**
	 * @param liveId
	 * @return   根据直播id获取观点购买信息
	 */
	public static List<IdeaSale> findTxtLiveSaleByLiveId(int liveId) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByLiveId(liveId);
	}

	/**
	 * @param uId
	 * @param liveId
	 * @return   获取用户指定的观点购买信息
	 */
	public static IdeaSale findTxtLiveSaleByUiDAndLiveId(int uId, int ideaId) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByUiDAndLiveId(uId, ideaId);
	}

	/**
	 * @param id
	 * @return  根据id获取观点购买信息
	 */
	public static IdeaSale findTxtLiveSaleById(int id) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleById(id);
	}

	/**
	 * @param orderCode
	 * @return   根据订单号获取观点购买信息
	 */
	public static IdeaSale findTxtLiveSaleByOrderCode(String orderCode) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByOrderCode(orderCode);
	}
	/**
	 * @param uId
	 * @param count
	 * @return   获取用户最近的几条观点购买记录
	 */
	public static List<IdeaSale> findTxtLiveSaleByUserLastCount(int uId, int count) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByUserLastCount(uId, count);
	}

}
