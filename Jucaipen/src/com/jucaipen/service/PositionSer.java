package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.PositionDao;
import com.jucaipen.daoimp.PositionImp;
import com.jucaipen.model.Position;

public class PositionSer {

	/**
	 * @param id
	 * @return ����id��ȡ��λ��Ϣ
	 */
	public static Position findPositionById(int id) {
		PositionDao dao=new PositionImp();
		return dao.findPositionById(id);
	}

	/**
	 * @return ��ȡ���еĸ�λ��Ϣ
	 */
	public static List<Position> findAll() {
		PositionDao dao=new PositionImp();
		return dao.findAll();
	}

}
