package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Video;

public interface VideoDao {
	/**
	 * @return  ��ȡ������Ƶ
	 */
	public List<Video> findAll(int page);
	/**
	 * @return  ���ݷ���id ��ȡ��Ƶ
	 */
	public List<Video> findVideoByClassId(String classId,int page);
	
	/**
	 * @return  ���ݷ���id ��ȡ��Ƶ
	 */
	public List<Video> findVideoByClassId(int classId,int page);
	/**
	 * @param teacherId
	 * @param page
	 * @return
	 */
	public List<Video> findVideoByTeacherId(int teacherId,int page);
	
	/**
	 * @param specialId
	 * @return  ��ȡͬ��ר������Ƶ��Ϣ
	 */
	public List<Video>  findVideoBySpecialId(int specialId);
	/**
	 * @param typeId
	 * @param page
	 * @return
	 */
	public List<Video> findVideoByType(int typeId,int page);
	/**
	 * @param teacherId
	 * @param type
	 * @param page
	 * @return
	 */
	public List<Video> findVideoByTeacherIdAndType(int teacherId,int type,int page);
	/**
	 * @param teacherId
	 * @param classId
	 * @param page
	 * @return
	 */
	public List<Video>  findVideoByTeacherIdAndClassId(int teacherId,String classId,int page);
	
	/**
	 * @param teacherId
	 * @param classId
	 * @param page
	 * @return
	 */
	public List<Video>  findVideoByTeacherIdAndClassId(int teacherId,int classId,int page);
	/**
	 * @param type
	 * @param classId
	 * @param page
	 * @return
	 */
	public List<Video> findVideoByTypeAndClassId(int type,String classId,int page);
	
	/**
	 * @param type
	 * @param classId
	 * @param page
	 * @return
	 */
	public List<Video> findVideoByTypeAndClassId(int type,int classId,int page);
	
	
	/**
	 * @param count
	 * @return  ��ȡ���������Ƶ
	 */
	public List<Video> findVideoByLast(int count);
	/**
	 * @param type
	 * @param classId
	 * @param teacherId
	 * @param page
	 * @return
	 */
	public List<Video> findVideoByTypeAndClassIdAndTeacherId(int type,String classId,int teacherId,int page);
	
	
	/**
	 * @param type
	 * @param classId
	 * @param teacherId
	 * @param page
	 * @return
	 */
	public List<Video> findVideoByTypeAndClassIdAndTeacherId(int type,int classId,int teacherId,int page);
	
	/**
	 * @param id
	 * @return   ����id ��ȡ��Ƶ��ϸ��Ϣ
	 */
	public Video findVideoById(int id);
	/**
	 * @param isIndex
	 * @return  ��ѯ��ҳ������ҳ��Ƶ��Ϣ
	 */
	public List<Video> findVideoByIsIndex(int isIndex);
	/**
	 * @param iisIndex
	 * @param classId
	 * @return   ��ѯ��ҳ�����µ���Ƶ
	 */
	public List<Video> findVideoByIndexId(int isIndex,int classId);
	/**
	 * @param isRecomm
	 * @return    ��ѯ�Ƽ������Ƽ���Ƶ
	 */
	public List<Video> findVideoByIsReComm(int isRecomm);
	/**
	 * @param isRecomm
	 * @param classId
	 * @return    ��ѯ�Ƽ��ķ�����Ƶ
	 */
	public List<Video> findVideoByIsRecommId(int isRecomm,int classId);
	/**
	 * @param isTop
	 * @return   ��ѯ�ö������ö���Ƶ
	 */
	public List<Video> findVideoByIsTop(int isTop);
	/**
	 * @param isTop
	 * @param classId
	 * @return   ��ѯ������ö���Ƶ
	 */
	public List<Video> findVideoByIsTopId(int isTop,int classId);
	/**
	 * @param isMySite
	 * @return  ��ѯ�Ƿ��Ǳ�վ��Ƶ
	 */
	public List<Video> findVideoByIsMySite(int isMySite);
	/**
	 * @param isMySit
	 * @param classId
	 * @return   ��ѯ��վ�ķ�����Ƶ
	 */
	public List<Video> findVideoByMySitId(int isMySit,int classId);
	/**
	 * @param id
	 * @return  ͨ��id ��ȡ��Ƶ��Դ
	 */
	public Video findVideoRecouresById(int id);
	
	
	/**
	 * @param count
	 * @param classId
	 * @return    ���ݷ����ȡ���������Ƶֱ��
	 */
	public List<Video> findVideoByClassIdLast(int count,int classId);
	
	/**
	 * @param count
	 * @param classId
	 * @return    ��ȡ��ѡ���������Ƶֱ��
	 */
	public List<Video> findVideoByIsBestLast(int count,int isBest);
	
	/**
	 * @param classId
	 * @return  ����classId��ȡ��Ƶ��Ϣ   �޷�ҳ��Ϣ
	 */
	public List<Video> findVideoByClassId(int classId);
	
	public List<Video> findLastVideoByCommId(int commId,int count);
	
	public List<Video> findAllVideoByCommId(int commId,int page);
	
	/**
	 * @param hits
	 * @param id
	 * @return  �޸ĵ����
	 */
	public int updateHits(int hits,int xnHits,int id);
	
	

}
