package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Video;

public interface VideoDao {
	/**
	 * @return  ��ȡ������Ƶ
	 */
	public List<Video> findAll();
	/**
	 * @return  ���ݷ���id ��ȡ��Ƶ
	 */
	public List<Video> findVideoByClassId(int classId);
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
	 * @param isPublic
	 * @return   ��ѯ�Ƿ��ǹ�����
	 */
	public List<Video> findVideoByIsPublic(int isPublic);
	/**
	 * @param isPublic
	 * @param classId
	 * @return   ��ѯ�����µĹ�����Ƶ
	 */
	public List<Video> findVideoByIsPublicId(int isPublic ,int classId);
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

}
