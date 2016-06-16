package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.StudioDao;
import com.jucaipen.daoimp.StudioImp;
import com.jucaipen.model.Studio;

/**
 * @author Administrator
 *
 *  �ݲ���
 */
public class StudioSer{

	/**
	 * @param page
	 * @return ��ȡ�����ݲ�����Ϣ
	 */
	public static List<Studio> findAll(int page) {
		StudioDao dao=new StudioImp();
		return dao.findAll(page);
	}

	/**
	 * @param id
	 * @return ����id��ȡ�ݲ�����Ϣ
	 */
	public static Studio findStudioById(int id) {
		StudioDao dao=new StudioImp();
		return dao.findStudioById(id);
	}

	/**
	 * @param columnId
	 * @param page
	 * @return ��ȡ��Ŀ�µ��ݲ�����Ϣ
	 */
	public static List<Studio> findStudioByColumnId(int columnId, int page) {
		StudioDao dao=new StudioImp();
		return dao.findStudioByColumnId(columnId, page);
	}
	
	/**
	 * @param week
	 * @return  ��ȡ�����ݲ���Ŀ��
	 */
	public static List<Studio> findStudioByToday(int week){
		StudioDao dao=new StudioImp();
		return dao.findStudioByToday(week);
	}

}
