package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.NewsFavoritesDao;
import com.jucaipen.daoimp.NewsFavoritesImp;
import com.jucaipen.model.NewsFavorites;

public class NewsFavoritesSer {
	/**
	 * @param uId
	 * @param nId
	 * @return �ղ���Ϣ
	 */
	public static int insertNews(int uId, NewsFavorites newsFavorites) {
		NewsFavoritesDao dao = new NewsFavoritesImp();
		return dao.insertNewsFavorites(uId, newsFavorites);
	}

	/**
	 * @param uId
	 * @param nId
	 * @return ȡ���ղ�����
	 */
	public static int cancelNews(int uId, int nId) {
		NewsFavoritesDao dao = new NewsFavoritesImp();
		return dao.cancelNewsFavorites(uId, nId);
	}

	/**
	 * @param uId
	 * @return ��ѯ���û��������ղص�������Ϣ
	 */
	public static List<NewsFavorites> findNewsFavoByUser(int uId, int pager) {
		NewsFavoritesDao dao = new NewsFavoritesImp();
		return dao.findNewsFavorites(uId, pager);
	}
	/**
	 * @param uId
	 * @param nId
	 * @return  ��ѯ�����Ƿ��ղ�
	 */
	public static NewsFavorites findNewsIsCollect(int uId,int nId){
		NewsFavoritesDao dao=new NewsFavoritesImp();
		return dao.findNewsFavouritesByUidAndNid(uId, nId);
	}

}
