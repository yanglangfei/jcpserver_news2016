package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.EquityFavorites;

/**
 * @author ylf
 * 
 *   �ղء�ϲ����Ȩ
 *
 */
public interface  EquityFavoritesDao {
	/**
	 * @param uId
	 * @param nId
	 * @return   ����ղصĹ�Ȩ
	 */
	public int insertFavoritesEquity(int uId,EquityFavorites equityFavorites);
	/**
	 * @param uId
	 * @param nId
	 * @return   ȡ���ղصĹ�Ȩ
	 */
	public int cancelFavoritesEquity(int uId,int eId);
	/**
	 * @param uId
	 * @return  ��ѯ��ǰ�û��µ������ղع�Ȩ
	 */
	public List<EquityFavorites> findFavoritesEquity(int uId,int pager);
	/**
	 * @param id
	 * @return  ����id��ѯ�ղصĹ�Ȩ
	 */
	public EquityFavorites findEquityFavById(int id);
	/**
	 * @param uId
	 * @param eId
	 * @return  ��ѯ��Ȩ�Ƿ��ղ�
	 */
	public EquityFavorites findEquityIsCollect(int uId,int eId);
	
	

}
