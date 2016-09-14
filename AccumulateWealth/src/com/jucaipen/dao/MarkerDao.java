package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Marker;

/**
 * @author Administrator
 *
 *   ����
 */
public interface MarkerDao {
	
	/**
	 * @return  ��ȡ���д�����Ϣ
	 */
	public List<Marker> findAll();
	
	/**
	 * @param id
	 * @return ͨ��id��ȡ������Ϣ
	 */
	public Marker findMarkerById(int id);
	
	/**
	 * @param uId
	 * @param page
	 * @return ͨ���û�id��ȡ���ͼ�¼
	 */
	public List<Marker> findMarkerByUserId(int uId,int page);
	
	/**
	 * @param type
	 * @param userId
	 * @return ͨ���û�id�ͷ����ȡ������Ϣ
	 */
	public List<Marker> findMarkerByUserIdAndType(int type,int userId,int page);
	/**
	 * @param logId
	 * @param top
	 * @return  ������־��ȡ�������������Ϣ
	 */
	public List<Marker> findTopMarkerByLogId(int logId ,int top);
	
	/**
	 * @param marker
	 * @return ��Ӵ�����Ϣ
	 */
	public int addMarker(Marker marker);
	
	/**
	 * @param tId
	 * @return  ��ȡ��ʦ���͵���Ϣ    ��ȡ�۵������Ϣ
	 */
	public List<Marker> findMarkerByTeacherId(int tId,int type);

}
