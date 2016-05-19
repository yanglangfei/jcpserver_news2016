package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Comment;
/**
 * @author ylf
 * 
 *         新闻评论
 * 
 */
public interface NewsCommDao {
	/**
	 * @param uId
	 * @param nId
	 * @return 添加评论
	 */
	public int insertNewsComm(int uId, Comment comment);

	/**
	 * @param uId
	 * @param comment
	 * @return 添加新闻回复
	 */
	public int insertNewsRes(int uId, Comment comment);

	/**
	 * @param uId
	 * @param nId
	 * @return 取消评论
	 */
	public int cancelNewsComm(int uId, int nId);

	/**
	 * @param uId
	 *            (type 0 评论 非0 回复)
	 * @return 查询当前用户下所有的新闻评论
	 */
	public List<Comment> findNewsComment(int uId, int type, int pager);

	/**
	 * @param uId
	 * @param type
	 * @param pager
	 * @return 查询当前用户下的回复
	 */
	public List<Comment> findNewsCommentRes(int uId, int type, int pager);

	/**
	 * @param nId
	 * @return 查询当前新闻下所有评论
	 */
	public List<Comment> findCommenByNews(int nId, int pager);

	/**
	 * @param id
	 * @return 查询评论赞数
	 */
	public Comment findComment(int id);

	/**
	 * @param id
	 * @return 修改评论信息
	 */
	public int updateCommentGoods(int id, int goodNum);

	/**
	 * @param pager
	 * @param id
	 * @param type
	 * @return 根据分类、id 分类查询评论信息
	 */
	public List<Comment> findCommentByTypeId(int pager, int id, int type);

}
