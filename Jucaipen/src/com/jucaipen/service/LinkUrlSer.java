package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.LinkUrlDao;
import com.jucaipen.daoimp.LinkUrlImp;
import com.jucaipen.model.LinkUrl;

/**
 * @author Administrator
 * ����URL
 */
public class LinkUrlSer  {

	/**
	 * @param id
	 * @return ͨ��id��ȡ����URL
	 */
	public  static LinkUrl findUrlById(int id) {
		LinkUrlDao dao=new LinkUrlImp();
		return dao.findUrlById(id);
	}

	/**
	 * @return ��ȡ���е�����URL
	 */
	public static List<LinkUrl> findAll() {
		LinkUrlDao dao=new LinkUrlImp();
		return dao.findAll();
	}

}
