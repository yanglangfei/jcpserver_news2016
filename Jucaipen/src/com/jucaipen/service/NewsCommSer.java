package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.NewsCommDao;
import com.jucaipen.daoimp.NewsCommImp;
import com.jucaipen.model.NewsComment;

public class NewsCommSer {
	/**
	 * @param uId
	 * @param nId
	 * @return �����������
	 */
	public static int insertNewsComm(int uId, NewsComment comment) {
		NewsCommDao dao = new NewsCommImp();
		return dao.insertNewsComm(uId, comment);
	}

	/**
	 * @param uId
	 * @param nId
	 * @return ȡ����������
	 */
	public static int cancelNewsComm(int uId, int nId) {
		NewsCommDao dao = new NewsCommImp();
		return dao.cancelNewsComm(uId, nId);
	}

	/**
	 * @param uId
	 * @return ��ѯ��ǰ�û��µ�������������
	 */
	public static List<NewsComment> findNewsCommByUser(int uId,int type, int pager) {
		NewsCommDao dao = new NewsCommImp();
		return dao.findNewsComment(uId,type, pager);
	}

	
	/**
	 * @param uId
	 * @return ��ѯ��ǰ�û��µ��������Żظ�
	 */
	public static List<NewsComment> findNewsCommResByUser(int uId,int type, int pager) {
		NewsCommDao dao = new NewsCommImp();
		return dao.findNewsCommentRes(uId, type, pager);
	}
	
	/**
	 * @param nId
	 * @return ��ѯ��ǰ���������е�����
	 */
	public static List<NewsComment> findNewsCommByNews(int nId, int pager) {
		NewsCommDao dao = new NewsCommImp();
		return dao.findCommenByNews(nId, pager);
	}

	/**
	 * @param nId
	 * @return ��ѯ��ǰ���������е�����
	 */
	public static List<NewsComment> findCommByTypeId(int pager, int id, int type) {
		NewsCommDao dao = new NewsCommImp();
		return dao.findCommentByTypeId(pager, id, type);
	}

	/**
	 * @param id
	 * @return ��ѯ�����۵���ϸ����
	 */
	public static NewsComment findNewsCommById(int id) {
		NewsCommDao dao = new NewsCommImp();
		return dao.findComment(id);
	}

	/**
	 * @param cId
	 * @param goodNum
	 * @return �޸�����
	 */
	public static int updateComment(int cId, int goodNum) {
		NewsCommDao dao = new NewsCommImp();
		return dao.updateCommentGoods(cId, goodNum);
	}
}
