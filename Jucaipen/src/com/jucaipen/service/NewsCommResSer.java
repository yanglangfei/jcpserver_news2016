package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.NewsCommResDao;
import com.jucaipen.daoimp.NewsCommResImp;
import com.jucaipen.model.NewsCommRes;

public class NewsCommResSer {
	/**
	 * @param uId
	 * @param nId
	 * @param cId
	 * @return  ������ۻظ�
	 */
	public static boolean insertCommRes(int uId, int nId, int cId) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.insertNewsRes(uId, nId, cId);
	}

	/**
	 * @param uId
	 * @param nId
	 * @param cId
	 * @return  ȡ�����ۻظ�
	 */
	public static boolean cancelCommRes(int uId, int nId, int cId) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.cancleNewsRes(uId, nId, cId);
	}

	/**
	 * @param uId
	 * @return  ��ѯ��ǰ�û������е����ۻظ�
	 */
	public static List<NewsCommRes> findCommResByUser(int uId,int pager) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.findResByUser(uId,pager);
	}

	/**
	 * @param nId
	 * @return  ��ѯ�����������е����ۻظ�
	 */
	public static List<NewsCommRes> findCommResByNews(int nId,int pager) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.findResByNews(nId,pager);
	}

	/**
	 * @param cId
	 * @return ��ѯ��ǰ�����µĻظ�
	 */
	public static List<NewsCommRes> findCommResByComm(int cId,int pager) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.findResByCommen(cId,pager);
	}

	/**
	 * @param id
	 * @return  ��ѯ�ظ���ϸ����
	 */
	public static  NewsCommRes findCommResById(int id) {
		NewsCommResDao dao = new NewsCommResImp();
		return dao.findResInfo(id);
	}
	/**
	 * @param nId
	 * @param cId
	 * @return  ��ѯ��ǰ�����¸������µ����лظ���Ϣ
	 */
	public static List<NewsCommRes> findCommRes(int nId,int cId,int pager){
		NewsCommResDao dao=new NewsCommResImp();
		return dao.findComm(nId, cId,pager);
	}

}
