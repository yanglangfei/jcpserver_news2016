package com.jucaipen.dao;

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
	public TacticsDetails findDetailsByFkId(int fkId);
	
	

}
