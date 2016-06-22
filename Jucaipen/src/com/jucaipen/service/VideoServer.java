package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.VideoDao;
import com.jucaipen.daoimp.VideoImp;
import com.jucaipen.model.Video;

public class VideoServer {
	/**
	 * @return ��ѯ������Ƶ��Ϣ
	 */
	public static List<Video> findAll(int page) {
		VideoDao dao = new VideoImp();
		return dao.findAll(page);
	}

	/**
	 * @param classId
	 * @return ���ݷ���id ��ѯ��Ӧ��Ƶ
	 */
	public static List<Video> findVideoByClassId(String classId,int page) {
		VideoDao dao = new VideoImp();
		return dao.findVideoByClassId(classId,page);
	}
	
	/**
	 * @param teacherId
	 * @param page
	 * @return
	 */
	public static List<Video> findVideoByTeacherId(int teacherId,int page){
		VideoDao dao=new VideoImp();
		return dao.findVideoByTeacherId(teacherId, page);
	}
	
	public static List<Video> findAllVideoByCommId(int commId,int page){
		VideoDao dao=new VideoImp();
		return dao.findAllVideoByCommId(commId, page);
	}
	
	public static List<Video> findLastVideoByCommId(int commId,int count){
		VideoDao dao=new VideoImp();
		return dao.findLastVideoByCommId(commId, count);
	}
	
	/**
	 * @param typeId
	 * @param page
	 * @return
	 */
	public static List<Video> findVideoByType(int typeId, int page) {
		VideoDao dao=new VideoImp();
		return dao.findVideoByType(typeId, page);
	}
	
	/**
	 * @param teacherId
	 * @param type
	 * @param page
	 * @return
	 */
	public static List<Video> findVideoByTeacherIdAndType(int teacherId, int type,
			int page) {
		VideoDao dao=new VideoImp();
		return dao.findVideoByTeacherIdAndType(teacherId, type, page);
	}
	
	/**
	 * @param teacherId
	 * @param classId
	 * @param page
	 * @return
	 */
	public static List<Video> findVideoByTeacherIdAndClassId(int teacherId,
			String classId, int page) {
		VideoDao dao=new VideoImp();
		return dao.findVideoByTeacherIdAndClassId(teacherId, classId, page);
	}
	
	/**
	 * @param type
	 * @param classId
	 * @param page
	 * @return
	 */
	public static List<Video> findVideoByTypeAndClassId(int type, String classId, int page) {
		VideoDao dao=new VideoImp();
		return dao.findVideoByTypeAndClassId(type, classId, page);
	}
	
	/**
	 * @param type
	 * @param classId
	 * @param teacherId
	 * @param page
	 * @return
	 */
	public static List<Video> findVideoByTypeAndClassIdAndTeacherId(int type,
			String classId, int teacherId, int page) {
		VideoDao dao=new VideoImp();
		return dao.findVideoByTypeAndClassIdAndTeacherId(type, classId, teacherId, page);
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
	
	public static List<Video>  findVideoByClassId(int classId){
		VideoDao dao=new VideoImp();
		return dao.findVideoByClassId(classId);
		
	}
	
	public static List<Video> findVideoByLast(int count){
		VideoDao dao=new VideoImp();
		return dao.findVideoByLast(count);
	}

}
