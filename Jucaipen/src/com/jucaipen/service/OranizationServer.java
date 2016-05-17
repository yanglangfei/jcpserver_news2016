package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.OranizationDao;
import com.jucaipen.daoimp.OranizationImp;
import com.jucaipen.model.Organization;

public class OranizationServer {
	/**
	 * @return ��ѯ���л�����Ϣ
	 */
	public static List<Organization> getOrganizations(int pager){
		OranizationDao dao=new OranizationImp();
		return dao.findAll(pager);
	}
	/**
	 * @param id
	 * @return  ��ѯ����������Ϣ
	 */
	public static Organization getOrganization(int id){
		OranizationDao dao=new OranizationImp();
		return dao.findOrganization(id);
	}

}
