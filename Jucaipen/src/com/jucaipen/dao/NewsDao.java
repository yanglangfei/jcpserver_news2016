package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.News;
/**
 * @author ylf
 * 
 *         ���Ų�����
 * 
 */
public interface NewsDao {
	/**
	 * @return ��ѯ��������
	 */
	public List<News> findAll(int pager);

	/**
	 * @param bigId
	 * @return ���ݷ����ѯ����
	 */
	public List<News> findNewsBybigId(int classId, int pager);


	/**
	 * @param isIndex
	 * @return ��ѯ��ҳ��ʾ������
	 */
	public List<News> findNewsByIndex(int isIndex, int pager);


	/**
	 * @param isBest
	 * @return ��ѯ��ѡ����
	 */
	public List<News> findNewsByBest(int isBest, int pager);

	/**
	 * @param isTop
	 * @return ��ѯ�ö�����
	 */
	public List<News> findNewsByTop(int isTop, int pager);
	/**
	 * @param id
	 * @return  ��ѯָ��������Ϣ
	 */
	public News findNews(int id);
	/**
	 * @param classId
	 * @param isIndex
	 * @return ��ѯ��������ҳ��ʾ������
	 */
	public List<News> findNewsIndex(int classId,int isIndex);
	/**
	 * @param id
	 * @return   ͨ��ָ������id ��ȡ�������
	 */
	public List<News> findRelatedNewsById(int id);
	/**
	 * @param count
	 * @return   ��ѯ���µ�count������
	 */
	public List<News> findLastNewsByNewsNum(int count);
	
	/**
	 * @param hits
	 * @return   �޸����ŵ����
	 */
	public int upDateHits(int hits,int id);
	/**
	 * @param Commens
	 * @return   �޸�������
	 */
	public int upDateComments(int Commens,int id);
}
