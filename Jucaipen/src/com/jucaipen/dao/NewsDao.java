package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.News;
/**
 * @author ylf
 * 
 *         新闻操作类
 * 
 */
public interface NewsDao {
	/**
	 * @return 查询所有新闻
	 */
	public List<News> findAll(int pager);

	/**
	 * @param bigId
	 * @return 根据分类查询新闻
	 */
	public List<News> findNewsBybigId(int classId, int pager);


	/**
	 * @param isIndex
	 * @return 查询首页显示的新闻
	 */
	public List<News> findNewsByIndex(int isIndex, int pager);

	/**
	 * @param isImage
	 * @return 查询图片新闻
	 */
	public List<News> findNewsByImage(int isImage, int pager);

	/**
	 * @param isBest
	 * @return 查询精选新闻
	 */
	public List<News> findNewsByBest(int isBest, int pager);

	/**
	 * @param isTop
	 * @return 查询置顶新闻
	 */
	public List<News> findNewsByTop(int isTop, int pager);
	/**
	 * @param id
	 * @return  查询指定新闻信息
	 */
	public News findNews(int id);
	/**
	 * @param classId
	 * @param isIndex
	 * @return 查询分类且首页显示的新闻
	 */
	public List<News> findNewsIndex(int classId,int isIndex);
	/**
	 * @return  首页显示
	 *        不过滤图片
	 */
	public List<News> findIndexShow(int classId);
	
	/**
	 * @param bigId
	 * @return   首页显示     ---带有图片
	 */
	public List<News> findIndexShowIsImage(int classId);
	/**
	 * @param id
	 * @return   通过指定新闻id 获取相关新闻
	 */
	public List<News> findRelatedNewsById(int id);
	/**
	 * @param count
	 * @return   查询最新的count条新闻
	 */
	public List<News> findLastNewsByNewsNum(int count);
	
	/**
	 * @param hits
	 * @return   修改新闻点击数
	 */
	public int upDateHits(int hits,int id);
	/**
	 * @param Commens
	 * @return   修改评论数
	 */
	public int upDateComments(int Commens,int id);
}
