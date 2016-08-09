package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.LiveDetailSale;

/**
 * @author Administrator
 *
 *  ����ֱ���۵���Ϣ
 */
public interface LiveDetailSaleDao {
	/**
	 * @param id
	 * @return ͨ��id��ȡ������Ϣ
	 */
	public LiveDetailSale findSaleById(int id);
	/**
	 * @param uId
	 * @return ͨ���û�id��ȡ������Ϣ
	 */
	public List<LiveDetailSale> findSaleByUid(int uId,int page);
	
	public LiveDetailSale findSaleByUserIdAndTxtIdAndDetailId(int uId,int detailId);
	
	/**
	 * @param sale
	 * @return ��ӹ�����Ϣ
	 */
	public int addSale(LiveDetailSale sale);

}
