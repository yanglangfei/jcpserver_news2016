package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.RecommderDao;
import com.jucaipen.daoimp.RecommderImp;
import com.jucaipen.model.Recommder;

/**
 * @author Administrator
 *
 *  �Ƽ��û�
 */
public class RecommderSer {

	/**
	 * @param id
	 * @return  ����id��ȡ�Ƽ���Ϣ
	 */
	public static Recommder findRecommderById(int id) {
		RecommderDao dao=new RecommderImp();
		return dao.findRecommderById(id);
	}

	/**
	 * @param parentId
	 * @param page
	 * @return ��ȡ���Ƽ�����Ϣ
	 */
	public static List<Recommder> findRecommderByParentId(int parentId, int page) {
		RecommderDao dao=new RecommderImp();
		return dao.findRecommderByParentId(parentId, page);
	}

	/**
	 * @param recommder
	 * @return ����Ƽ���Ϣ
	 */
	public static int addRecommder(Recommder recommder) {
		RecommderDao dao=new RecommderImp();
		return dao.addRecommder(recommder);
	}

}
