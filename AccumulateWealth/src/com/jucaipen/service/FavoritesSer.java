package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.FavoritesDao;
import com.jucaipen.daoimp.FavoritesImp;
import com.jucaipen.model.Favorites;

public class FavoritesSer {
	/**
	 * @param uId
	 * @param nId
	 * @return �ղ���Ϣ
	 */
	public static int insertNews( Favorites newsFavorites) {
		FavoritesDao dao = new FavoritesImp();
		return dao.insertFavorites(newsFavorites);
	}

	/**
	 * @param uId
	 * @param nId
	 * @return ȡ���ղ�����
	 */
	public static int cancelNews(int uId, int nId,int type) {
		FavoritesDao dao = new FavoritesImp();
		return dao.cancelFavorites(uId, nId,type);
	}

	/**
	 * @param uId
	 * @return ��ѯ���û��������ղص�������Ϣ
	 */
	public static List<Favorites> findNewsFavoByUser(int uId, int pager) {
		FavoritesDao dao = new FavoritesImp();
		return dao.findFavorites(uId, pager);
	}
	/**
	 * @param uId
	 * @param nId
	 * @return  ��ѯ�����Ƿ��ղ�
	 */
	public static Favorites findNewsIsCollect(int uId,int nId,int type){
		FavoritesDao dao=new FavoritesImp();
		return dao.findFavouritesByUidAndNid(uId, nId,type);
	}
	
	/**
	 * @param uId
	 * @param type
	 * @param page
	 * @return ��ȡ�û����ղصķ�����Ϣ
	 */
	public static List<Favorites> findFavourateByUidAndType(int uId,int type,int page){
		FavoritesDao dao=new FavoritesImp();
		return dao.findFavourateByUidAndType(uId, type, page);
	}

}
