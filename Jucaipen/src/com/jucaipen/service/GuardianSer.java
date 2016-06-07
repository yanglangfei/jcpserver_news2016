package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.GuardianDao;
import com.jucaipen.daoimp.GuardianImp;
import com.jucaipen.model.Guardian;

/**
 * @author Administrator
 *
 *  �ػ���
 */
public class GuardianSer  {

	/**
	 * @param id
	 * @return ͨ��id��ȡ�ػ���Ϣ
	 */
	public static  Guardian findGuardianById(int id) {
		GuardianDao dao=new GuardianImp();
		return dao.findGuardianById(id);
	}

	/**
	 * @param userId
	 * @param page
	 * @return ͨ���û�id��ȡ���ػ���
	 */
	public static List<Guardian> findGurdianByUid(int userId, int page) {
		GuardianDao dao=new GuardianImp();
		return dao.findGurdianByUid(userId, page);
	}

	/**
	 * @param teacherId
	 * @param page
	 * @return ͨ����ʦid��ȡ�ػ��ҵ�  ��ҳ
	 */
	public static List<Guardian> findGuradianByTeacherId(int teacherId, int page) {
		GuardianDao dao=new GuardianImp();
		return dao.findGuradianByTeacherId(teacherId, page);
	}

	
	/**
	 * @param teacherId
	 * @return ͨ����ʦid��ȡ�ػ��ҵ�   �޷�ҳ
	 */
	public static List<Guardian> findGuradianByTeacherId(int teacherId) {
		GuardianDao dao=new GuardianImp();
		return dao.findGuradianByTeacherId(teacherId);
	}
	
	
	/**
	 * @param guardian
	 * @return ����ػ���Ϣ
	 */
	public static int addGuardian(Guardian guardian) {
		GuardianDao dao=new GuardianImp();
		return dao.addGuardian(guardian);
	}

}
