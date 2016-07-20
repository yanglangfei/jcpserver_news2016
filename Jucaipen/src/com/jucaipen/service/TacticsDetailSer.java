package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TacticsDetailsDao;
import com.jucaipen.daoimp.TacticsDetailsImp;
import com.jucaipen.model.TacticsDetails;

/**
 * @author Administrator
 *  ս����ϸ��Ϣ
 */
public class TacticsDetailSer  {

	/**
	 * @param id
	 * @return  ����id��ȡս����ϸ��Ϣ
	 */
	public static TacticsDetails findDetailsById(int id) {
		TacticsDetailsDao dao=new TacticsDetailsImp();
		return dao.findDetailsById(id);
	}

	/**
	 * @param fkId
	 * @return ����ս��id��ȡս����ϸ��Ϣ
	 */
	public static List<TacticsDetails> findDetailsByFkId(int fkId) {
		TacticsDetailsDao dao=new TacticsDetailsImp();
		return dao.findDetailsByFkId(fkId);
	}

}
