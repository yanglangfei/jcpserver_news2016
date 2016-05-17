package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.TxtLiveSale;

public interface TxtLiveSaleDao {
	/**
	 * @return  ��ȡȫ����������Ϣ
	 */
	public List<TxtLiveSale> findAllTxtLiveSale();
	/**
	 * @param userId
	 * @return    ��ȡ�û��������Ϣ
	 */
	public List<TxtLiveSale> findTxtLiveSaleByUid(int userId);
	/**
	 * @param teacherId
	 * @return   ���ݽ�ʦ��ȡ������Ϣ
	 */
	public List<TxtLiveSale> findTxtLiveSaleByTeacherId(int teacherId);
	/**
	 * @param liveId
	 * @return   ����ֱ��id��ȡ������Ϣ
	 */
	public List<TxtLiveSale> findTxtLiveSaleByLiveId(int liveId);
	/**
	 * @param uId
	 * @param liveId
	 * @return   ��ȡ�û�������ض�ֱ����Ϣ
	 */
	public TxtLiveSale findTxtLiveSaleByUiDAndLiveId(int uId,int liveId);
	/**
	 * @param id
	 * @return   ����id��ȡ������Ϣ
	 */
	public TxtLiveSale findTxtLiveSaleById(int id);
	
	/**
	 * @param orderCode
	 * @return   ���ݶ����Ż�ȡ�����ֱ����Ϣ
	 */
	public TxtLiveSale findTxtLiveSaleByOrderCode(String orderCode);
	/**
	 * @param uId
	 * @param count
	 * @return   ��ȡ�û�������������ֱ����¼
	 */
	public List<TxtLiveSale> findTxtLiveSaleByUserLastCount(int uId,int count);



}
