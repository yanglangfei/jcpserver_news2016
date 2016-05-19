package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.IdeaSale;

public interface IdeaSaleDao {
	/**
	 * @return  ��ȡȫ����������Ϣ
	 */
	public List<IdeaSale> findAllTxtLiveSale();
	/**
	 * @param userId
	 * @return    ��ȡ�û��������Ϣ
	 */
	public List<IdeaSale> findTxtLiveSaleByUid(int userId);
	/**
	 * @param teacherId
	 * @return   ���ݽ�ʦ��ȡ������Ϣ
	 */
	public List<IdeaSale> findTxtLiveSaleByTeacherId(int teacherId);
	/**
	 * @param liveId
	 * @return   ����ֱ��id��ȡ������Ϣ
	 */
	public List<IdeaSale> findTxtLiveSaleByLiveId(int liveId);
	/**
	 * @param uId
	 * @param liveId
	 * @return   ��ȡ�û�������ض�ֱ����Ϣ
	 */
	public IdeaSale findTxtLiveSaleByUiDAndLiveId(int uId,int liveId);
	/**
	 * @param id
	 * @return   ����id��ȡ������Ϣ
	 */
	public IdeaSale findTxtLiveSaleById(int id);
	
	/**
	 * @param orderCode
	 * @return   ���ݶ����Ż�ȡ�����ֱ����Ϣ
	 */
	public IdeaSale findTxtLiveSaleByOrderCode(String orderCode);
	/**
	 * @param uId
	 * @param count
	 * @return   ��ȡ�û�������������ֱ����¼
	 */
	public List<IdeaSale> findTxtLiveSaleByUserLastCount(int uId,int count);



}
