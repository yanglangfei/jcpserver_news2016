package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.NewsFavoritesDao;
import com.jucaipen.daoimp.NewsFavoritesImp;
import com.jucaipen.model.NewsFavorites;

public class NewsFavoritesSer {
	/**
	 * @param uId
	 * @param nId
	 * @return 收藏信息
	 */
	public static int insertNews(int uId, NewsFavorites newsFavorites) {
		NewsFavoritesDao dao = new NewsFavoritesImp();
		return dao.insertNewsFavorites(uId, newsFavorites);
	}

	/**
	 * @param uId
	 * @param nId
	 * @return 取消收藏新闻
	 */
	public static int cancelNews(int uId, int nId) {
		NewsFavoritesDao dao = new NewsFavoritesImp();
		return dao.cancelNewsFavorites(uId, nId);
	}

	/**
	 * @param uId
	 * @return 查询该用户下所有收藏的新闻信息
	 */
	public static List<NewsFavorites> findNewsFavoByUser(int uId, int pager) {
		NewsFavoritesDao dao = new NewsFavoritesImp();
		return dao.findNewsFavorites(uId, pager);
	}
	/**
	 * @param uId
	 * @param nId
	 * @return  查询新闻是否被收藏
	 */
	public static NewsFavorites findNewsIsCollect(int uId,int nId){
		NewsFavoritesDao dao=new NewsFavoritesImp();
		return dao.findNewsFavouritesByUidAndNid(uId, nId);
	}

}
