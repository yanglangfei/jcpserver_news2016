package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.ProvinceDao;
import com.jucaipen.daoimp.ProvinceImp;
import com.jucaipen.model.Province;

public class ProvinceServer {
	/**
	 * @return  ��������ʡ����Ϣ
	 */
	public static List<Province> getProvinces(){
		ProvinceDao dao=new ProvinceImp();
		return dao.findAll();
	}
	/**
	 * @param id
	 * @return  ����ĳ��ʡ����Ϣ
	 */
	public static Province getProvince(int id){
		ProvinceDao dao=new ProvinceImp();
		return dao.findProvince(id);
	}

}
