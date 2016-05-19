package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.IdeaSaleDao;
import com.jucaipen.daoimp.IdeaSaleImp;
import com.jucaipen.model.IdeaSale;

/**
 * @author Administrator
 *   �۵�������Ϣ
 */
public class IdeaSaleServer{

	/**
	 * @return   ��ȡ���еĹ۵㹺����Ϣ
	 */
	public static List<IdeaSale> findAllTxtLiveSale() {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findAllTxtLiveSale();
	}

	/**
	 * @param userId
	 * @return   �����û�id��ȡ�۵㹺����Ϣ
	 */
	public static List<IdeaSale> findTxtLiveSaleByUid(int userId) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByUid(userId);
	}

	/**
	 * @param teacherId
	 * @return   ���ݽ�ʦid��ȡ�۵㹺����Ϣ
	 */
	public static List<IdeaSale> findTxtLiveSaleByTeacherId(int teacherId) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByTeacherId(teacherId);
	}

	/**
	 * @param liveId
	 * @return   ����ֱ��id��ȡ�۵㹺����Ϣ
	 */
	public static List<IdeaSale> findTxtLiveSaleByLiveId(int liveId) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByLiveId(liveId);
	}

	/**
	 * @param uId
	 * @param liveId
	 * @return   ��ȡ�û�ָ���Ĺ۵㹺����Ϣ
	 */
	public static IdeaSale findTxtLiveSaleByUiDAndLiveId(int uId, int ideaId) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByUiDAndLiveId(uId, ideaId);
	}

	/**
	 * @param id
	 * @return  ����id��ȡ�۵㹺����Ϣ
	 */
	public static IdeaSale findTxtLiveSaleById(int id) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleById(id);
	}

	/**
	 * @param orderCode
	 * @return   ���ݶ����Ż�ȡ�۵㹺����Ϣ
	 */
	public static IdeaSale findTxtLiveSaleByOrderCode(String orderCode) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByOrderCode(orderCode);
	}
	/**
	 * @param uId
	 * @param count
	 * @return   ��ȡ�û�����ļ����۵㹺���¼
	 */
	public static List<IdeaSale> findTxtLiveSaleByUserLastCount(int uId, int count) {
		IdeaSaleDao dao=new IdeaSaleImp();
		return dao.findTxtLiveSaleByUserLastCount(uId, count);
	}

}
