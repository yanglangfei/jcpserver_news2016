package com.jucaipen.service;

import com.jucaipen.dao.SiteConfigDao;
import com.jucaipen.daoimp.SiteConfigImp;
import com.jucaipen.model.SiteConfig;

/**
 * @author YLF
 * 
 *
 */
public class SiteConfigSer{

	/**
	 * @return   ��ȡ������Ϣ
	 */
	public static SiteConfig findSiteConfig() {
		SiteConfigDao dao=new SiteConfigImp();
		return dao.findSiteConfig();
	}
}
