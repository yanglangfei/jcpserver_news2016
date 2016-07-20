package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.TacticsDetails;

/**
 * @author Administrator
 *
 *  ս����ϸ��Ϣ
 */
public interface TacticsDetailsDao {
	
	/**
	 * @param id
	 * @return ����id��ȡ��ϸ��Ϣ
	 */
	public TacticsDetails findDetailsById(int id);
	
	/**
	 * @param fkId
	 * @return  ����ս��id��ȡ��ϸ��Ϣ
	 */
	public List<TacticsDetails> findDetailsByFkId(int fkId);
	
	

}
