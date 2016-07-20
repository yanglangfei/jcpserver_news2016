package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.TacticsSale;

/**
 * @author Administrator
 *  ս��������Ϣ
 */
public interface TacticsSaleDao {
	
	/**
	 * @param id
	 * @return  ����id��ȡս��������Ϣ
	 */
	public TacticsSale findSaleById(int id);
	
	/**
	 * @param uId
	 * @param page
	 * @return   �����û�id��ȡս��������Ϣ
	 */
	public List<TacticsSale> findSaleByUserId(int uId,int page);
	
	
	/**
	 * @param sale
	 * @return  ���ս��������Ϣ
	 */
	public int addSale(TacticsSale sale);
	
	/**
	 * @param id
	 * @return  ɾ��ս��������Ϣ
	 */
	public int delSale(int id);
	
	public TacticsSale findTacticsIsSale(int uId,int tacticsId);
	
	
	
	

}
