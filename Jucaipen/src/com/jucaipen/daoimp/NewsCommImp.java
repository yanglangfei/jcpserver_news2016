package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.NewsCommDao;
import com.jucaipen.model.NewsComment;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

public class NewsCommImp implements NewsCommDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<NewsComment> newsComments;
	private int isSuccess;

	/**
	 * @return ��ѯ����������ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPNewsCommen "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * �����������
	 */
	public int insertNewsComm(int uId, NewsComment comment) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("insert into JCPNewsCommen ("
					+ SqlUtil.NEWSCOMM_UID + "," + SqlUtil.NEWSFAVORITES_NID
					+ "," + SqlUtil.NEWSCOMM_BODYS + "," + SqlUtil.NEWS_INSERT
					+ "," + SqlUtil.NEWSCOMM_PARENTID + ","
					+ SqlUtil.NEWSCOMM_REPNUM + "," + SqlUtil.NEWSCOMM_GOODNUM
					+ "," + SqlUtil.NEWSCOMM_COMMTYPE + ") values" + "("
					+ comment.getuId() + "," + comment.getnId() + ",'"
					+ comment.getBodys() + "','" + comment.getInsertDate()
					+ "'," + comment.getpId() + "," + comment.getRepCount() + ","
					+ comment.getGoodNum() + "," + comment.getCommType() + ")");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}
	
	/*
	 * ������Żظ�
	 * 
	 */
	public int insertNewsRes(int uId, NewsComment comment) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("insert into JCPNewsCommen ("
					+ SqlUtil.NEWSCOMM_UID + "," + SqlUtil.NEWSFAVORITES_NID
					+ "," + SqlUtil.NEWSCOMM_BODYS + "," + SqlUtil.NEWS_INSERT
					 + ","
					+ SqlUtil.NEWSCOMM_REPNUM + "," + SqlUtil.NEWSCOMM_GOODNUM
					+ "," + SqlUtil.NEWSCOMM_COMMTYPE + ") values" + "("
					+ comment.getuId() + "," + comment.getnId() + ",'"
					+ comment.getBodys() + "','" + comment.getInsertDate()
					+ "',"+ comment.getRepCount() + ","
					+ comment.getGoodNum() + "," + comment.getCommType() + ")");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	/*
	 * ȡ����������
	 */
	public int cancelNewsComm(int uId, int nId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("delete from JCPNewsCommen where UserId="
							+ uId + " and NewsId=" + nId);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * �޸�����
	 */
	public int updateCommentGoods(int id, int goodNum) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("update JCPNewsCommen set Good="
					+ goodNum + " where Id=" + id);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * ��ѯ���û������е�����������Ϣ
	 */
	public List<NewsComment> findNewsComment(int uId,int type, int pager) {
		int totlePager = findTotlePager("where UserId=" + uId+" AND ParentId="+type);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER ( ORDER BY Id DESC,InsertDate DESC) AS RowNumber,* FROM JCPNewsCommen"
							+ " where UserId=" + uId +") A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			newsComments = getNewsCommen(res, pager, totlePager);
			return newsComments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * ��ѯ���û������е��������ۻظ�
	 */
	public List<NewsComment> findNewsCommentRes(int uId,int type, int pager) {
		int totlePager = findTotlePager("where UserId=" + uId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER ( ORDER BY Id DESC,InsertDate DESC) AS RowNumber,* FROM JCPNewsCommen"
							+ " where UserId=" + uId + " AND  ParentId!="+type+") A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			newsComments = getNewsCommen(res, pager, totlePager);
			return newsComments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ��ѯ�����������е�������Ϣ
	 */
	public List<NewsComment> findCommenByNews(int nId, int pager) {
		int totlePager = findTotlePager("where NewsId=" + nId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY Id DESC,InsertDate DESC) AS RowNumber,* FROM JCPNewsCommen"
							+ " where NewsId=" + nId + " ) A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			newsComments = getNewsCommen(res, pager, totlePager);
			return newsComments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ���ݷ��ࡢid �����ѯ������Ϣ
	 */
	public List<NewsComment> findCommentByTypeId(int pager, int id, int type) {
		int totlePager = findTotlePager("where CommType=" + type
				+ " and NewsId=" + id);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY Id DESC,InsertDate DESC) AS RowNumber,* FROM JCPNewsCommen"
							+ " where CommType=" + type + " AND NewsId=" + id
							+ " ) A " + "WHERE RowNumber > " + 15 * (pager - 1));
			newsComments = getNewsCommen(res, pager, totlePager);
			return newsComments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ��ѯ�����۵���ϸ��Ϣ
	 */
	public NewsComment findComment(int id) {
		NewsComment nc = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select * from JCPNewsCommen where Id=" + id);
			newsComments = getNewsCommen(res, -1, -1);
			if (newsComments != null && newsComments.size() > 0) {
				nc = newsComments.get(0);
			}
			return nc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param result
	 * @return ��ȡ����������Ϣ
	 */
	public List<NewsComment> getNewsCommen(ResultSet result, int pager,
			int totlePager) {
		newsComments = new ArrayList<NewsComment>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.NEWS_ID);
				int uId = result.getInt(SqlUtil.EQUITYFAVORITES_UID);
				int pId = result.getInt("ParentId");
				int nId = result.getInt(SqlUtil.NEWSFAVORITES_NID);
				String bodys = result.getString(SqlUtil.NEWS_BODYS);
				String insertDate = result
						.getString(SqlUtil.EQUITYFAVORITES_DATE);
				int goodNum = result.getInt(SqlUtil.NEWSCOMM_GOODNUM);
				int isShow = result.getInt(SqlUtil.NEWSCOMM_ISSHOW);
				int respCount = result.getInt(SqlUtil.NEWSCOMM_REPNUM);
				NewsComment nc = new NewsComment();
				nc.setBodys(bodys);
				nc.setId(id);
				nc.setnId(nId);
				nc.setuId(uId);
				nc.setpId(pId);
				nc.setInsertDate(insertDate);
				nc.setIsShow(isShow);
				nc.setRepCount(respCount);
				nc.setGoodNum(goodNum);
				nc.setTotlePager(totlePager);
				nc.setPager(pager);
				newsComments.add(nc);
			}
			return newsComments;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	

}
