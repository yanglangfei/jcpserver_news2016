package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.AnswerSaleDao;
import com.jucaipen.daoimp.AnswerSaleImp;
import com.jucaipen.model.AnswerSale;

/**
 * @author Administrator �ش�������Ϣ
 */
public class AnswerSaleSer {

	/**
	 * @param id
	 * @return ����id��ȡ�ش�������Ϣ
	 */
	public static AnswerSale findSaleById(int id) {
		AnswerSaleDao dao = new AnswerSaleImp();
		return dao.findSaleById(id);
	}

	/**
	 * @param userId
	 * @param page
	 * @return ��ȡ�û�����Ļش���Ϣ
	 */
	public static List<AnswerSale> findSaleByUid(int userId, int page) {
		AnswerSaleDao dao = new AnswerSaleImp();
		return dao.findSaleByUid(userId, page);
	}

	/**
	 * @param orderCode
	 * @return ���ݶ�����ȡ�ش�������Ϣ
	 */
	public static AnswerSale findSaleByOrderCode(String orderCode) {
		AnswerSaleDao dao = new AnswerSaleImp();
		return dao.findSaleByOrderCode(orderCode);
	}

	public static List<AnswerSale> findSaleByTeacherAndUid(int teacherId, int userId) {
		AnswerSaleDao dao = new AnswerSaleImp();
		return dao.findSaleByTeacherAndUid(teacherId, userId);
	}

	public static AnswerSale findSaleByUserIdAndAskId(int uId, int askId) {
		AnswerSaleDao dao = new AnswerSaleImp();
		return dao.findSaleByUserIdAndAskId(uId, askId);
	}

}
