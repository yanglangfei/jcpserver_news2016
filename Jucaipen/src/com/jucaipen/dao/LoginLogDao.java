package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.LoginLog;
/**
 * @author YLF
 * 
 *   ��¼��־������
 *
 */
public interface LoginLogDao {
	/**
	 * @param log
	 * @return  ��ӵ�¼��־
	 */
	public int insertLog(LoginLog log);
	/**
	 * @param id
	 * @return  ɾ����¼��־
	 */
	public int deleteLog(int id);
	/**
	 * @param id
	 * @return  ����id���ҵ�¼��־
	 */
	public LoginLog findLog(int id);
	/**
	 * @param userId
	 * @return  ���ҵ�ǰ�û������еĵ�¼��־��Ϣ
	 */
	public List<LoginLog> findLogByUser(int userId,int pager);

}
