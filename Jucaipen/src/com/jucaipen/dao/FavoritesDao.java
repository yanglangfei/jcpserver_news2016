package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Favorites;
/**
 * @author ylf
 * 
 *   �ղ�
 *
 */
public interface FavoritesDao {
	/**
	 * @param uId
	 * @param nId
	 * @return  ����ղ�
	 */
	public int insertFavorites(Favorites newsFavorites);
	/**
	 * @param uId
	 * @param nId
	 * @return ȡ���ղ�
	 */
	public int cancelFavorites(int uId,int nId,int type);
	/**
	 * @param uId
	 * @return  ��ѯ��ǰ�û������е��ղ�
	 */
	public List<Favorites> findFavorites(int uId,int pager);
	/**
	 * @param uId
	 * @param nId
	 * @return  �����û�id��֪ʶ/��Ƶid��ѯ�ղ���Ϣ
	 */
	public Favorites findFavouritesByUidAndNid(int uId,int nId,int type);
	
	/**
	 * @param uId
	 * @param type
	 * @param page
	 * @return  �����û�id��ѯ�����µ��ղ�
	 */
	public List<Favorites> findFavourateByUidAndType(int uId,int type ,int page);

}
