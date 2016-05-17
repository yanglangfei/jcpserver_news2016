package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.NewsCommRes;
/**
 * @author ylf
 * 
 *  �������ۻ�Ӧ
 */
public interface NewsCommResDao {
	/**
	 * @param uId
	 * @param nId
	 * @param cId
	 * @return  ������Żظ�
	 */
	public boolean insertNewsRes(int uId,int nId,int cId);
	/**
	 * @param uId
	 * @param nId
	 * @param cId
	 * @return  ȡ�����Ż�Ӧ
	 */
	public boolean cancleNewsRes(int uId,int nId,int cId);
	/**
	 * @param uId
	 * @return  ��ѯ��ǰ�û������е����ۻ�Ӧ
	 */
	public List<NewsCommRes> findResByUser(int uId,int pager);
	/**
	 * @param nId
	 * @return  ��ѯ��ǰ���������еĻظ�
	 */
	public List<NewsCommRes> findResByNews(int nId,int pager);
	/**
	 * @param cId
	 * @return  ��ѯ��ǰ�����µ����лظ�
	 */
	public List<NewsCommRes> findResByCommen(int cId,int pager);
	/**
	 * @param id
	 * @return ��ѯ����������ϸ��Ϣ
	 */
	public NewsCommRes findResInfo(int id);
	/**
	 * @param nId
	 * @param cId
	 * @return  ��ѯָ�������������µĻظ�
	 */
	public List<NewsCommRes> findComm(int nId,int cId,int pager);

}
