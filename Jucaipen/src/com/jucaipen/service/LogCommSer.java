package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.LogCommenDao;
import com.jucaipen.daoimp.LogCommImp;
import com.jucaipen.model.LogCommen;

public class LogCommSer{

	/**
	 * @param logCommen
	 * @return  �����־����
	 */
	public static int insertLogComm(LogCommen logCommen) {
		LogCommenDao dao=new LogCommImp();
		return dao.insertLogComm(logCommen);
	}

	/**
	 * @param id
	 * @return  ����id��ѯ��־��������
	 */
	public static LogCommen findLogCommBuId(int id) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommBuId(id);
	}

	/**
	 * @return  ��ѯ���е���־����
	 */
	public static List<LogCommen> findAllComm() {
		LogCommenDao dao=new LogCommImp();
		return dao.findAllComm();
	}

	/**
	 * @param uid
	 * @return  �����û�id��ѯ��־����
	 */
	public static List<LogCommen> findLogCommByUserId(int uid) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommByUserId(uid);
	}

	/**
	 * @param logId
	 * @return  ������־id��ѯ��־����
	 */
	public static List<LogCommen> findLogCommByLogId(int logId,int page) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommByLogId(logId,page);
	}

	/**
	 * @param uid
	 * @param logId
	 * @return  �����û�id����־id��ѯ��־����
	 */
	public static List<LogCommen> findLogCommByUidAndLogId(int uid, int logId) {
		LogCommenDao dao=new LogCommImp();
		return dao.findLogCommByUidAndLogId(uid, logId);
	}

}
