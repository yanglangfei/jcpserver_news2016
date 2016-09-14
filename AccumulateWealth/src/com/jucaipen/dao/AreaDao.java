package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Area;

public interface AreaDao {
	/**
	 * @param pId
	 * @param cId
	 * @return  ��ѯ��������������Ϣ
	 */
	public List<Area> findAreas(int pId,int cId);
	/**
	 * @param id
	 * @param pId
	 * @param cId
	 * @return   ��ѯĳ������Ϣ
	 */
	public Area findArea(int id);

}
