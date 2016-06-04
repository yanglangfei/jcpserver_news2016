package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Position;

/**
 * @author Administrator
 *
 *  ��λ
 */
public interface PositionDao {
	
	/**
	 * @param id
	 * @return ͨ��id��ȡ��λ��Ϣ
	 */
	public Position findPositionById(int id);
	
	/**
	 * @return ��ȡ���и�λ��Ϣ
	 */
	public List<Position> findAll();
	
	/**
	 * @param cId
	 * @return �����ʸ�֤���ͻ�ȡ��Ӧ�ĸ�λ
	 */
	public List<Position> findPositionByCid(int cId);

}
