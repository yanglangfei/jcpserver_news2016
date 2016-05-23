package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.MySpecialDao;
import com.jucaipen.daoimp.MySpecialImp;
import com.jucaipen.model.MySpecial;

public class MySpecialSer {

	/**
	 * @param id
	 * @return ͨ��id��ȡ�ҵ�ר����Ϣ
	 */
	public static MySpecial findSpecialById(int id) {
		MySpecialDao dao=new MySpecialImp();
		return dao.findSpecialById(id);
	}

	/**
	 * @param userId
	 * @param page
	 * @return �����û�id��ȡ�ҵ�ר����Ϣ
	 */
	public static List<MySpecial> findSpecialByUid(int userId, int page) {
		MySpecialDao dao=new MySpecialImp();
		return dao.findSpecialByUid(userId, page);
	}

	/**
	 * @param special
	 * @return ���ר����Ϣ
	 */
	public int addSpecial(MySpecial special) {
		MySpecialDao dao=new MySpecialImp();
		return dao.addSpecial(special);
	}

	/**
	 * @param id
	 * @return ɾ��ר����¼
	 */
	public static int removeSpecial(int id) {
		MySpecialDao dao=new MySpecialImp();
		return dao.removeSpecial(id);
	}

}
