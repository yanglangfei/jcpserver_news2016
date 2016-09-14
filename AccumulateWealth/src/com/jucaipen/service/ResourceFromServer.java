package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.ResourceFromDao;
import com.jucaipen.daoimp.ResourceFromImp;
import com.jucaipen.model.ResourceSources;

public class ResourceFromServer {
	/**
	 * @return   ��ȡ������Ѷ��Դ��Ϣ
	 */
	public static List<ResourceSources> getResourceSources(int pager) {
		ResourceFromDao dao = new ResourceFromImp();
		return dao.findAll(pager);
	}

	/**
	 * @param id
	 * @return   ����id��ȡ��Ѷ��Դ��Ϣ
	 */
	public static String getRSources(int id) {
		ResourceFromDao dao = new ResourceFromImp();
		return dao.findResourceSources(id);
	}
}
