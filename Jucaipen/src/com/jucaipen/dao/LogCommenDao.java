package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.LogCommen;
public interface LogCommenDao {
	/**
	 * @param logCommen
	 * @return  �����־����
	 */
	public int insertLogComm(LogCommen logCommen);
	/**
	 * @param id
	 * @return ����id��ȡ��־������ϸ��Ϣ
	 */
	public LogCommen findLogCommBuId(int id);
	/**
	 * @return ��ȡ������־������Ϣ
	 */
	public List<LogCommen> findAllComm();
	/**
	 * @param uid
	 * @return  �����û�id��ȡ��־������Ϣ
	 */
	public List<LogCommen> findLogCommByUserId(int uid);
	/**
	 * @param logId
	 * @return ������־id��ȡ��־������Ϣ
	 */
	public List<LogCommen> findLogCommByLogId(int logId,int page);
	/**
	 * @param uid
	 * @param logId
	 * @return  �����û�id����־id��ѯ��־����
	 */
	public List<LogCommen> findLogCommByUidAndLogId(int uid,int logId);
}
