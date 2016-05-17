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
	 * @return ����һ�������ѯ����
	 */
	public List<News> findNewsBybigId(int bigId, int pager);

	/**
	 * @param bigId
	 * @param smallId
	 * @return ����һ���������ѯ����
	 */
	public List<News> findNewsById(int bigId, int smallId, int pager);

	/**
	 * @param isIndex
	 * @return ��ѯ��ҳ��ʾ������
	 */
	public List<News> findNewsByIndex(int isIndex, int pager);

	/**
	 * @param isImage
	 * @return ��ѯͼƬ����
	 */
	public List<News> findNewsByImage(int isImage, int pager);

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
	 * @param bigId
	 * @param smallId
	 * @param isIndex
	 * @return   ��ѯ������������ҳ��ʾ������
	 */
	public List<News> findIndexNews(int bigId,int smallId,int isIndex);
	/**
	 * @param bigId
	 * @param isIndex
	 * @return ��ѯһ����������ҳ��ʾ������
	 */
	public List<News> findNewsIndex(int bigId,int isIndex);
	/**
	 * @return  ��ҳ��ʾ
	 *        ������ͼƬ
	 */
	public List<News> findIndexShow(int bigId);
	
	/**
	 * @param bigId
	 * @return   ��ҳ��ʾ     ---����ͼƬ
	 */
	public List<News> findIndexShowIsImage(int bigId);
	/**
	 * @param bigId
	 * @param smallId
	 * @return   ��ѯ��ҳ��ȨҪ����Ϣ
	 */
	public List<News> findNewsByIndexId(int bigId, int smallId,int top);
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
