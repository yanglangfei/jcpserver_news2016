package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Equity;

/**
 * @author ylf ��Ȩ����
 * 
 */
public interface EquityDao {
	/**
	 * @return ��ѯ���й�Ȩ
	 */
	public List<Equity> findAll(int pager);
	/**
	 * @param id
	 * @return  ��ѯ��Ȩ��ϸ��Ϣ
	 */
	public Equity findEquity(int id);

	/**
	 * @return ��ѯ�ö���Ȩ
	 */
	public List<Equity> findByTop(int isTop);

	/**
	 * @param isRecom
	 *            ��ѯ�Ƽ���Ȩ
	 * @return
	 */
	public List<Equity> frindByRecomment(int isRecom,int pager);
	/**
	 * @return  ��ѯ��ҳ��ʾ������
	 */
	public List<Equity> findIndexEquity();

}
