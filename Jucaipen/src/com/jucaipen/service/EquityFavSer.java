package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.EquityFavoritesDao;
import com.jucaipen.daoimp.EquityFavoritesImp;
import com.jucaipen.model.EquityFavorites;

/**
 * @author Administrator �ղع�Ȩ����
 */
public class EquityFavSer {
	/**
	 * @param uId
	 * @param nId
	 * @return �ղع�Ȩ
	 */
	public static int insertEquity(int uId, EquityFavorites equityFavorites) {
		EquityFavoritesDao dao = new EquityFavoritesImp();
		return dao.insertFavoritesEquity(uId, equityFavorites);
	}

	/**
	 * @param uId
	 * @param nId
	 * @return ȡ���ղع�Ȩ
	 */
	public static int cancelEquity(int uId, int nId) {
		EquityFavoritesDao dao = new EquityFavoritesImp();
		return dao.cancelFavoritesEquity(uId, nId);
	}

	/**
	 * @param uId
	 * @param page
	 * @return ��ѯ��ǰ�û��������ղصĹ�Ȩ��Ϣ
	 */
	public static List<EquityFavorites> findEquityByUid(int uId, int page) {
		EquityFavoritesDao dao = new EquityFavoritesImp();
		return dao.findFavoritesEquity(uId, page);
	}

	/**
	 * @param eId
	 * @return ����id��ѯ�ղصĹ�Ȩ����ϸ��Ϣ
	 */
	public static EquityFavorites findEquityById(int eId) {
		EquityFavoritesDao dao = new EquityFavoritesImp();
		return dao.findEquityFavById(eId);
	}

	/**
	 * @param uId
	 * @param eId
	 * @return  ��ѯ��Ȩ�Ƿ��ղ�
	 */
	public static EquityFavorites findEquityIsCollect(int uId, int eId) {
		EquityFavoritesDao dao = new EquityFavoritesImp();
		return dao.findEquityIsCollect(uId, eId);
	}

}
