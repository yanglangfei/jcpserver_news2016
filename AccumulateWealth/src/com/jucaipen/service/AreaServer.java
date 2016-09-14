package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.AreaDao;
import com.jucaipen.daoimp.AreaImp;
import com.jucaipen.model.Area;


public class AreaServer {
	/**
	 * @param pId
	 * @param cId
	 * @return   ��ѯʡ���µ���������Ϣ
	 */
	public static List<Area> getAreas(int pId,int cId){
		AreaDao dao=new AreaImp();
		return dao.findAreas(pId, cId);
	}
	/**
	 * @param id
	 * @return  ��ѯ����������Ϣ
	 */
	public static Area getArea(int id){
		AreaDao dao=new AreaImp();
		return dao.findArea(id);
	}

}
