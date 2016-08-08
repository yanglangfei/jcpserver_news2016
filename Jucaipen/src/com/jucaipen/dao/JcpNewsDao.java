package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.JcpNews;

public interface JcpNewsDao {
	/**
	 * @return ��ѯ��������
	 */
	public List<JcpNews> findAll(int pager);

	/**
	 * @param bigId
	 * @return ���ݷ����ѯ����
	 */
	public List<JcpNews> findNewsBybigId(int bigId,int smallId, int pager);


	/**
	 * @param isIndex
	 * @return ��ѯ��ҳ��ʾ������
	 */
	public List<JcpNews> findNewsByIndex(int isIndex, int pager);


	/**
	 * @param isBest
	 * @return ��ѯ��ѡ����
	 */
	public List<JcpNews> findNewsByBest(int isBest, int pager);

	/**
	 * @param isTop
	 * @return ��ѯ�ö�����
	 */
	public List<JcpNews> findNewsByTop(int isTop, int pager);
	/**
	 * @param id
	 * @return  ��ѯָ��������Ϣ
	 */
	public JcpNews findNews(int id);
	/**
	 * @param classId
	 * @param isIndex
	 * @return ��ѯ��������ҳ��ʾ������
	 */
	public List<JcpNews> findNewsIndex(int bigId,int smallId,int isIndex);
	/**
	 * @param id
	 * @return   ͨ��ָ������id ��ȡ�������
	 */
	public List<JcpNews> findRelatedNewsById(int id);
	/**
	 * @param count
	 * @return   ��ѯ���µ�count������
	 */
	public List<JcpNews> findLastNewsByNewsNum(int count);
	
	public JcpNews findHitsAndGoods(int id);
	
	public int addGoods(int id,int goods);
	
	/**
	 * @param hits
	 * @return   �޸����ŵ����
	 */
	public int upDateHits(int xnHits,int hits,int id);
	/**
	 * @param Commens
	 * @return   �޸�������
	 */
	public int upDateComments(int Commens,int id);
}
