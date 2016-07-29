package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.FansDao;
import com.jucaipen.daoimp.FansImp;
import com.jucaipen.model.Fans;

/**
 * @author Administrator
 *
 * ��˿��Ϣ
 */
public class FansSer {

	/**
	 * @param userId
	 * @param page
	 * @return �����û�id��ȡ��˿��Ϣ
	 */
	public static List<Fans> findFansByUid(int userId, int page) {
		FansDao dao=new FansImp();
		return dao.findFansByUid(userId, page);
	}
	
	/**
	 * @param userId
	 * @param page
	 * @return �����û�id��ȡ��˿��Ϣ
	 */
	public static List<Fans> findFansByUid(int userId) {
		FansDao dao=new FansImp();
		return dao.findFansByUid(userId);
	}


	/**
	 * @param teacherId
	 * @param page
	 * @return ���ݽ�ʦid��ȡ��˿��Ϣ
	 */
	public static List<Fans> findFansByTeacherId(int teacherId, int page) {
		FansDao dao=new FansImp();
		return dao.findFansByTeacherId(teacherId, page);
	}

	/**
	 * @param id
	 * @return ����id��ȡ��˿��Ϣ
	 */
	public static Fans findFansById(int id) {
		FansDao dao=new FansImp();
		return dao.findFansById(id);
	}
	
	/**
	 * @param uId
	 * @param tId
	 * @return  �ж��û��Ƿ��ע�ý�ʦ
	 */
	public static Fans findIsFans(int uId,int tId){
		FansDao dao=new FansImp();
		return dao.findIsFans(uId, tId);
	}
	
	/**
	 * @param fans
	 * @return  ��ӹ�ע
	 */
	public static int addFans(Fans fans){
		FansDao dao=new FansImp();
		return dao.addFans(fans);
	}
	
	/**
	 * @param id
	 * @return  ȡ����ע
	 */
	public static int cancelFans(int tId,int uId){
		FansDao dao=new FansImp();
		return dao.cancelFans(tId,uId);
	}

}
