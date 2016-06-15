package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Video;

public interface VideoDao {
	/**
	 * @return  获取所有视频
	 */
	public List<Video> findAll(int page);
	/**
	 * @return  根据分类id 获取视频
	 */
	public List<Video> findVideoByClassId(String classId,int page);
	/**
	 * @param teacherId
	 * @param page
	 * @return
	 */
	public List<Video> findVideoByTeacherId(int teacherId,int page);
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
	 * @param type
	 * @param classId
	 * @param page
	 * @return
	 */
	public List<Video> findVideoByTypeAndClassId(int type,String classId,int page);
	
	
	/**
	 * @param count
	 * @return  获取最近几条视频
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
	 * @param id
	 * @return   根据id 获取视频详细信息
	 */
	public Video findVideoById(int id);
	/**
	 * @param isIndex
	 * @return  查询首页、非首页视频信息
	 */
	public List<Video> findVideoByIsIndex(int isIndex);
	/**
	 * @param iisIndex
	 * @param classId
	 * @return   查询首页分类下的视频
	 */
	public List<Video> findVideoByIndexId(int isIndex,int classId);
	/**
	 * @param isRecomm
	 * @return    查询推荐、不推荐视频
	 */
	public List<Video> findVideoByIsReComm(int isRecomm);
	/**
	 * @param isRecomm
	 * @param classId
	 * @return    查询推荐的分类视频
	 */
	public List<Video> findVideoByIsRecommId(int isRecomm,int classId);
	/**
	 * @param isTop
	 * @return   查询置顶、不置顶视频
	 */
	public List<Video> findVideoByIsTop(int isTop);
	/**
	 * @param isTop
	 * @param classId
	 * @return   查询分类的置顶视频
	 */
	public List<Video> findVideoByIsTopId(int isTop,int classId);
	/**
	 * @param isMySite
	 * @return  查询是否是本站视频
	 */
	public List<Video> findVideoByIsMySite(int isMySite);
	/**
	 * @param isMySit
	 * @param classId
	 * @return   查询本站的分类视频
	 */
	public List<Video> findVideoByMySitId(int isMySit,int classId);
	/**
	 * @param id
	 * @return  通过id 获取视频资源
	 */
	public Video findVideoRecouresById(int id);
	
	
	/**
	 * @param count
	 * @param classId
	 * @return    根据分类获取最近几条视频直播
	 */
	public List<Video> findVideoByClassIdLast(int count,int classId);
	
	/**
	 * @param classId
	 * @return  根据classId获取视频信息   无分页信息
	 */
	public List<Video> findVideoByClassId(int classId);

}
