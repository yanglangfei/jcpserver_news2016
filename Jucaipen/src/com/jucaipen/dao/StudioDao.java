package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Studio;

/**
 * @author Administrator
 *
 * �ݲ���
 */
public interface StudioDao {
	
	
	/**
	 * @return ��ȡ�����ݲ���
	 */
	public List<Studio> findAll(int page);
	
	/**
	 * @param id
	 * @return ����id��ȡ�ݲ�����Ϣ
	 */
	public Studio findStudioById(int id);
	
	/**
	 * @param columnId
	 * @return ���ݣ���Ŀid��ȡ�ݲ�����Ϣ
	 */
	public List<Studio> findStudioByColumnId(int columnId,int page);
	
	/**
	 * @param week
	 * @return  ��ȡ�����ݲ���Ϣ
	 */
	public List<Studio>  findStudioByToday(int week);
	
	/**
	 * @param week
	 * @return  ��ȡ�ݲ���������
	 */
	public List<Studio>  findStudioFansByToday(int week);

}
