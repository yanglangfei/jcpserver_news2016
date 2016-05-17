package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.SigningDao;
import com.jucaipen.daoimp.SigningImp;
import com.jucaipen.model.Signing;

public class SigingSer{

	/**
	 * @param signing
	 * @return  ǩԼ
	 */
	public static int insertSigin(Signing signing) {
		SigningDao dao=new SigningImp();
		return dao.insertSigin(signing);
	}

	/**
	 * @param id
	 * @return  ����id��ȡǩԼ��ϸ��Ϣ
	 */
	public static Signing findSignById(int id) {
		SigningDao dao=new SigningImp();
		return dao.findSignById(id);
	}

	/**
	 * @return ��ȡ����ǩԼ��Ϣ
	 */
	public static List<Signing> findAllSigin() {
		SigningDao dao=new SigningImp();
		return dao.findAllSigin();
	}

	/**
	 * @param userId
	 * @return  �����û�id��ȡǩԼ��Ϣ
	 */
	public static List<Signing> findSignByUserId(int userId) {
		SigningDao dao=new SigningImp();
		return dao.findSignByUserId(userId);
	}

	/**
	 * @param teacherId
	 * @return  ���ݽ�ʦid��ȡǩԼ��Ϣ
	 */
	public static List<Signing> findSiginByTeacherId(int teacherId) {
		SigningDao dao=new SigningImp();
		return dao.findSiginByTeacherId(teacherId);
	}

	/**
	 * @param type
	 * @return  ����ǩԼ״̬��ȡǩԼ��Ϣ
	 */
	public static List<Signing> findSiginByType(int type) {
		SigningDao dao=new SigningImp();
		return dao.findSiginByType(type);
	}

}
