package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.NewsFavorites;
/**
 * @author ylf
 * 
 *   �ղ�����
 *
 */
public interface NewsFavoritesDao {
	/**
	 * @param uId
	 * @param nId
	 * @return  ����ղ�����
	 */
	public int insertNewsFavorites(int uId,NewsFavorites newsFavorites);
	/**
	 * @param uId
	 * @param nId
	 * @return ȡ���ղ�����
	 */
	public int cancelNewsFavorites(int uId,int nId);
	/**
	 * @param uId
	 * @return  ��ѯ��ǰ�û������е������ղ�
	 */
	public List<NewsFavorites> findNewsFavorites(int uId,int pager);
	/**
	 * @param uId
	 * @param nId
	 * @return  �����û�id������id��ѯ�ղ���Ϣ
	 */
	public NewsFavorites findNewsFavouritesByUidAndNid(int uId,int nId);

}
