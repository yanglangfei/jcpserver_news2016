package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.LoginLogDao;
import com.jucaipen.daoimp.LoginLogImp;
import com.jucaipen.model.LoginLog;

public class LoginLogServer {
	/**
	 * @param userId
	 * @return �����û�id��ѯ��¼��־
	 */
	public static List<LoginLog> findLogByUser(int userId, int pager) {
		LoginLogDao dao = new LoginLogImp();
		return dao.findLogByUser(userId, pager);
	}

	/**
	 * @param id
	 * @return ������־id����ѯ��¼��־��Ϣ
	 */
	public static LoginLog findLogById(int id) {
		LoginLogDao dao = new LoginLogImp();
		return dao.findLog(id);
	}

	/**
	 * @param log
	 * @return  ��ӵ�¼��־
	 */
	public static int insertLog(LoginLog log) {
		LoginLogDao dao = new LoginLogImp();
		return dao.insertLog(log);
	}

}
