package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TxtLiveSaleDao;
import com.jucaipen.daoimp.TxtLiveSaleImp;
import com.jucaipen.model.TxtLiveSale;

/**
 * @author Administrator
 *   ����ֱ��������Ϣ
 */
public class TxtLiveSaleServer{

	/**
	 * @return   ��ȡ���е�����ֱ��������Ϣ
	 */
	public static List<TxtLiveSale> findAllTxtLiveSale() {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findAllTxtLiveSale();
	}

	/**
	 * @param userId
	 * @return   �����û�id��ȡ������Ϣ
	 */
	public static List<TxtLiveSale> findTxtLiveSaleByUid(int userId) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByUid(userId);
	}

	/**
	 * @param teacherId
	 * @return   ���ݽ�ʦid��ȡ������Ϣ
	 */
	public static List<TxtLiveSale> findTxtLiveSaleByTeacherId(int teacherId) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByTeacherId(teacherId);
	}

	/**
	 * @param liveId
	 * @return   ����ֱ��id��ȡ������Ϣ
	 */
	public static List<TxtLiveSale> findTxtLiveSaleByLiveId(int liveId) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByLiveId(liveId);
	}

	/**
	 * @param uId
	 * @param liveId
	 * @return   ��ȡ�û�ָ����ֱ��������Ϣ
	 */
	public static TxtLiveSale findTxtLiveSaleByUiDAndLiveId(int uId, int liveId) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByUiDAndLiveId(uId, liveId);
	}

	/**
	 * @param id
	 * @return  ����id��ȡ������Ϣ
	 */
	public static TxtLiveSale findTxtLiveSaleById(int id) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleById(id);
	}

	/**
	 * @param orderCode
	 * @return   ���ݶ����Ż�ȡ������Ϣ
	 */
	public static TxtLiveSale findTxtLiveSaleByOrderCode(String orderCode) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByOrderCode(orderCode);
	}
	/**
	 * @param uId
	 * @param count
	 * @return   ��ȡ�û�����ļ��������¼
	 */
	public static List<TxtLiveSale> findTxtLiveSaleByUserLastCount(int uId, int count) {
		TxtLiveSaleDao dao=new TxtLiveSaleImp();
		return dao.findTxtLiveSaleByUserLastCount(uId, count);
	}

}
