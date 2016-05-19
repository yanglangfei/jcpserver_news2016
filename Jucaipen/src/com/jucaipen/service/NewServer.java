package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.NewsDao;
import com.jucaipen.daoimp.NewsImp;
import com.jucaipen.model.News;

/**
 * @author ylf
 * 
 *         ���ŷ�����
 * 
 */
public class NewServer {
	private static List<News> news;

	/**
	 * @param pager
	 * @return ����ҳ����ѯָ��ҳ��������Ϣ
	 */
	public static List<News> queryNews(int pager) {
		NewsDao dao = new NewsImp();
		news = dao.findAll(pager);
		return news;

	}

	/**
	 * @param bigId
	 * @param pager
	 * @return ����һ�������ѯ������Ϣ
	 */
	public static List<News> queryNewsByBigId(int bigId, int pager) {
		NewsDao dao = new NewsImp();
		return dao.findNewsBybigId(bigId, pager);
	}


	/**
	 * @param id
	 * @return ����id ��ѯ������ϸ����
	 */
	public static News findNewsById(int id) {
		NewsDao dao = new NewsImp();
		return dao.findNews(id);
	}

	/**
	 * @param id
	 * @return ��ȡ�������
	 */
	public static List<News> findRelatedNewsById(int id) {
		NewsDao dao = new NewsImp();
		return dao.findRelatedNewsById(id);
	}

	/**
	 * @param count
	 * @return ��ȡ�����count������
	 */
	public static List<News> findLastNews(int count) {
		NewsDao dao = new NewsImp();
		return dao.findLastNewsByNewsNum(count);

	}
	
	/**
	 * @param hits
	 * @param id
	 * @return   �޸ĵ����
	 */
	public static int upDateHits(int hits,int id){
		NewsDao dao=new NewsImp();
		return dao.upDateHits(hits, id);
	}
	
	/**
	 * @param comments
	 * @param id
	 * @return   �޸�������
	 */
	public static int upDateComments(int comments,int id){
		NewsDao dao=new NewsImp();
		return dao.upDateComments(comments, id);
	}
	
	/**
	 * @param classId
	 * @param page
	 * @return   ���ݷ����ѯ����
	 */
	public static List<News>  findNewsByClassId(int classId,int page){
		NewsDao dao=new NewsImp();
		return dao.findNewsBybigId(classId, page);
	}

}
