package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.CityDao;
import com.jucaipen.daoimp.CityImp;
import com.jucaipen.model.City;

public class CityServer {
	/**
	 * @param pId
	 * @return ��ѯʡ���µ����г�����Ϣ
	 */
	public static List<City> getCitys(int pId) {
		CityDao dao = new CityImp();
		return dao.findCitys(pId);
	}

	/**
	 * @param id
	 * @return ��ѯָ��������Ϣ
	 */
	public static City getCity(int id) {
		CityDao dao = new CityImp();
		return dao.findCity(id);
	}

	/**
	 * @param pager
	 * @return  ��ѯ���г�����Ϣ
	 */
	public static List<City> findAll(int pager) {
		CityDao dao = new CityImp();
		return dao.findAll(pager);
	}

}
