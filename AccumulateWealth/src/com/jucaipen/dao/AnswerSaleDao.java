package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.AnswerSale;

/**
 * @author Administrator
 *
 * �ش�����
 */
public interface AnswerSaleDao {
	/**
	 * @param id
	 * @return  ����id��ȡ�ش�������Ϣ
	 */
	public AnswerSale findSaleById(int id);
	
	/**
	 * @param userId
	 * @return �����û�id��ȡ������Ϣ
	 */
	public List<AnswerSale> findSaleByUid(int userId,int page);
	
	/**
	 * @param orderCode
	 * @return  ���ݶ�����Ż�ȡ������Ϣ
	 */
	public AnswerSale findSaleByOrderCode(String orderCode);
	
	/**
	 * @param teacherId
	 * @param userId
	 * @return ��ѯ����Ľ�ʦ�µ�������Ϣ
	 */
	public List<AnswerSale> findSaleByTeacherAndUid(int teacherId,int userId);
	
	/**
	 * @param uId
	 * @param askId
	 * @return �����û�id������id��ȡ������Ϣ
	 */
	public AnswerSale findSaleByUserIdAndAskId(int uId,int askId);

}
