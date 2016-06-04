package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.MarkerDao;
import com.jucaipen.daoimp.MarkerImp;
import com.jucaipen.model.Marker;

public class MarkerSer{

	/**
	 * @param id
	 * @return ����id��ȡ������Ϣ
	 */
	public static Marker findMarkerById(int id) {
		MarkerDao dao=new MarkerImp();
		return dao.findMarkerById(id);
	}

	/**
	 * @param uId
	 * @param page
	 * @return �����û�id��ȡ������Ϣ
	 */
	public static List<Marker> findMarkerByUserId(int uId, int page) {
		MarkerDao dao=new MarkerImp();
		return dao.findMarkerByUserId(uId, page);
	}

	/**
	 * @param type
	 * @param userId
	 * @param page
	 * @return �����û�id��ȡ�����µĴ�����Ϣ
	 */
	public static List<Marker> findMarkerByUserIdAndType(int type, int userId, int page) {
		MarkerDao dao=new MarkerImp();
		return dao.findMarkerByUserIdAndType(type, userId, page);
	}

	/**
	 * @param logId
	 * @param top
	 * @return ������־id��ȡ���͵����������¼
	 */
	public static List<Marker> findTopMarkerByLogId(int logId, int top) {
		MarkerDao dao=new MarkerImp();
		return dao.findTopMarkerByLogId(logId, top);
	}

	/**
	 * @param marker
	 * @return ��Ӵ��ͼ�¼
	 */
	public static int addMarker(Marker marker) {
		MarkerDao dao=new MarkerImp();
		return dao.addMarker(marker);
	}
	
	/**
	 * @param tId
	 * @param type
	 * @return  ��ȡ��ʦ���͵���Ϣ ��ȡ�۵������Ϣ
	 */
	public static List<Marker> findMarkerByTeacherId(int tId,int type){
		MarkerDao dao=new MarkerImp();
		return dao.findMarkerByTeacherId(tId, type);
	}
	
	/**
	 * @return  ��ȡ���еĴ�����Ϣ
	 */
	public static List<Marker>  findAll(){
		MarkerDao dao=new MarkerImp();
		return dao.findAll();
	}

}
