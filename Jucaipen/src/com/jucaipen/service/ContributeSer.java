package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.ContributeDao;
import com.jucaipen.daoimp.ContributeImp;
import com.jucaipen.model.Contribute;

/**
 * @author Administrator
 *
 * ����
 */
public class ContributeSer{

	/**
	 * @param id
	 * @return ����id��ȡ������Ϣ
	 */
	public static  Contribute findContributeById(int id) {
		ContributeDao dao=new ContributeImp();
		return dao.findContributeById(id);
	}

	/**
	 * @param uId
	 * @return  �����û�id��ȡ���װ�
	 */
	public static List<Contribute> findContributeByUid(int uId) {
		ContributeDao dao=new ContributeImp();
		return dao.findContributeByUid(uId);
	}

	/**
	 * @param uId
	 * @param tId
	 * @return ��ȡ�û���ĳ����ʦ�Ĺ���
	 */
	public static List<Contribute> findContributeByUidAndTid(int uId, int tId) {
		ContributeDao dao=new ContributeImp();
		return dao.findContributeByUidAndTid(uId, tId);
	}

	/**
	 * @param uId
	 * @param fkId
	 * @return ��ȡ�û��Թ��� id �Ĺ���
	 */
	public static List<Contribute> findContributeByUidAndFkId(int uId, int fkId) {
		ContributeDao dao=new ContributeImp();
		return dao.findContributeByUidAndFkId(uId, fkId);
	}

	/**
	 * @return  ��ȡ���еĹ���
	 */
	public static List<Contribute> findAllContribute() {
		ContributeDao dao=new ContributeImp();
		return dao.findAllContribute();
	}

}
