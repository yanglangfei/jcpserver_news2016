package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Report;

public interface ReportDao {
	
	/**
	 * @param id
	 * @return  ����id��ȡ�ٱ���Ϣ
	 */
	public Report findRepoterById(int id);
	
	/**
	 * @param userId
	 * @return �����û�id��ȡ�ٱ���Ϣ
	 */
	public List<Report> findRepoterByUserId(int userId,int page);
	
	/**
	 * @param userId
	 * @param type
	 * @param page
	 * @return ��ȡ�û��µķ���ٱ���Ϣ
	 */
	public List<Report> findRepoterByUserIdAndType(int userId,int type,int page);
	/**
	 * @param report
	 * @return ��Ӿٱ���Ϣ
	 */
	public int addRepoter(Report report);

}
