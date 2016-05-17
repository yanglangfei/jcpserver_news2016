package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.OranizationDao;
import com.jucaipen.daoimp.OranizationImp;
import com.jucaipen.model.Organization;

public class OranizationServer {
	/**
	 * @return 查询所有机构信息
	 */
	public static List<Organization> getOrganizations(int pager){
		OranizationDao dao=new OranizationImp();
		return dao.findAll(pager);
	}
	/**
	 * @param id
	 * @return  查询单个机构信息
	 */
	public static Organization getOrganization(int id){
		OranizationDao dao=new OranizationImp();
		return dao.findOrganization(id);
	}

}
