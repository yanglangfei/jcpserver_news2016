package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Tactics;

/**
 * @author Administrator
 *
 *  ս��
 */
public interface TacticsDao {
	
	/**
	 * @param page
	 * @return ��ȡ����ս��
	 */
	public List<Tactics> findAll(int page);
	
	/**
	 * @param id
	 * @return  ����id��ȡս����Ϣ
	 */
	public Tactics findTacticsById(int id);
	
	/**
	 * @param tId
	 * @param page
	 * @return  ���ݽ�ʦid��ȡս����Ϣ   ��ҳ
	 */
	public List<Tactics> findTacticsByTeacherId(int tId,int page);
	/**
	 * @param tId
	 * @return  ���ݽ�ʦid��ȡս����Ϣ  �޷�ҳ
	 */
	public List<Tactics> findTacticsByTeacherId(int tId);

}
