package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.VideoDao;
import com.jucaipen.daoimp.VideoImp;
import com.jucaipen.model.Video;

public class VideoServer {
	/**
	 * @return ��ѯ������Ƶ��Ϣ
	 */
	public static List<Video> findAll() {
		VideoDao dao = new VideoImp();
		return dao.findAll();
	}

	/**
	 * @param classId
	 * @return ���ݷ���id ��ѯ��Ӧ��Ƶ
	 */
	public static List<Video> findVideoByClassId(int classId) {
		VideoDao dao = new VideoImp();
		return dao.findVideoByClassId(classId);
	}

	/**
	 * @param id
	 * @return ����id ��ѯ��Ƶ��ϸ��Ϣ
	 */
	public static Video findVideoById(int id) {
		VideoDao dao = new VideoImp();
		return dao.findVideoById(id);
	}

	/**
	 * @param isIndex
	 * @return   ��ѯ��ҳ��Ƶ
	 */
	public static List<Video> findVideoByIsIndex(int isIndex) {
		VideoDao dao = new VideoImp();
		return dao.findVideoByIsIndex(isIndex);
	}
	/**
	 * @param isIndex
	 * @param classId
	 * @return   ��ѯ��ҳ�µķ�����Ϣ
	 */
	public static List<Video> findVideoByIsIndexId(int isIndex,int classId){
		VideoDao dao=new VideoImp();
		return dao.findVideoByIndexId(isIndex, classId);
	}
	/** 
	 * @param id
	 * @return  ͨ��id��ȡ��Ƶ������Դ
	 */ 
	public static Video findVideoResourceById(int id){ 
		VideoDao dao=new VideoImp();
		return dao.findVideoRecouresById(id);
	}
	
	/**
	 * @param count
	 * @param classId
	 * @return    ���ݷ���id��ȡ�������Ƶ��Ϣ
	 */
	public static List<Video> findVideoByClassIdLast(int count,int classId){
		VideoDao dao=new VideoImp();
		return dao.findVideoByClassIdLast(count, classId);

	}

}
