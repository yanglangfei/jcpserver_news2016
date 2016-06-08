package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.MyPresentDao;
import com.jucaipen.daoimp.MyPresentImp;
import com.jucaipen.model.MyPresent;

public class MyPresentSer {

	/**
	 * @param uId
	 * @param page
	 * @return ��ȡ��ӵ�е���Ʒ
	 */
	public static List<MyPresent> findPresentByUserId(int uId, int page) {
		MyPresentDao dao=new MyPresentImp();
		return dao.findPresentByUserId(uId, page);
	}

	/**
	 * @param id
	 * @return ����id��ȡ��Ʒ��Ϣ
	 */
	public static MyPresent findPresentById(int id) {
		MyPresentDao dao=new MyPresentImp();
		return dao.findPresentById(id);
	}

	/**
	 * @param present
	 * @return �����Ʒ
	 */
	public static int addPresent(MyPresent present) {
		MyPresentDao dao=new MyPresentImp();
		return dao.addPresent(present);
	}

	/**
	 * @param present
	 * @return �޸���Ʒ��Ϣ
	 */
	public static int sendPresent(MyPresent present) {
		MyPresentDao dao=new MyPresentImp();
		return dao.sendPresent(present);
	}
	
	
	/**
	 * @param present
	 * @return �޸���Ʒ��Ϣ
	 */
	public static int sendPresent(int id,int num) {
		MyPresentDao dao=new MyPresentImp();
		return dao.sendPresent(id, num);
	}
	
	/**
	 * @param uId
	 * @param pId
	 * @return ��ȡ�û�ӵ�е�ĳ����Ʒ����
	 */
	public static MyPresent findParentByUid(int uId,int pId){
		MyPresentDao dao=new MyPresentImp();
		return dao.findParentByUid(uId, pId);
	}

}
