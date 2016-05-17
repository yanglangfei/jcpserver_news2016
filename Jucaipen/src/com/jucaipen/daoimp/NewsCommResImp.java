package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.NewsCommResDao;
import com.jucaipen.model.NewsCommRes;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

public class NewsCommResImp implements NewsCommResDao {
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private boolean isSuccess;
	private List<NewsCommRes> newsCommRes;

	/**
	 * @return ��ѯ�������ۻظ���ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPNewsCommenRep "
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
	 * ������ۻظ�
	 */
	public boolean insertNewsRes(int uId, int nId, int cId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.execute("insert into JCPNewsCommenRep values ()");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * ȡ�����ۻظ�
	 */
	public boolean cancleNewsRes(int uId, int nId, int cId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.execute("delete from JCPNewsCommenRep where UserId=" + uId
							+ " and NewsId=" + nId + " and CommId=" + cId);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * ��ѯ��ǰ�û������еĻظ�
	 */
	public List<NewsCommRes> findResByUser(int uId, int pager) {
		int totlePager = findTotlePager("where UserId=" + uId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPNewsCommenRep"
							+ " where UserId=" + uId + " ) A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			newsCommRes = getNewsCommRes(res, pager, totlePager);
			return newsCommRes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ��ѯ��ǰ���������е����ۻظ�
	 */
	public List<NewsCommRes> findResByNews(int nId, int pager) {
		int totlePager = findTotlePager("where NewsId=" + nId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPNewsCommen"
							+ " where NewsId=" + nId + " ) A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			newsCommRes = getNewsCommRes(res, pager, totlePager);
			return newsCommRes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ��ѯ�����������еĻظ�
	 */
	public List<NewsCommRes> findResByCommen(int cId, int pager) {
		int totlePager = findTotlePager("where CommId=" + cId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPNewsCommen"
							+ " where CommId=" + cId + " ) A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			newsCommRes = getNewsCommRes(res, pager, totlePager);
			return newsCommRes;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * ��ѯ���ۻظ���ϸ����
	 */
	public NewsCommRes findResInfo(int id) {
		NewsCommRes ncs = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPNewsCommenRep where Id="
					+ id);
			newsCommRes = getNewsCommRes(res, -1, -1);
			if (newsCommRes != null && newsCommRes.size() > 0) {
				ncs = newsCommRes.get(0);
			}
			return ncs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ��ѯ�������£������۵����лظ���Ϣ
	 */
	public List<NewsCommRes> findComm(int nId, int cId, int pager) {
		int totlePager = findTotlePager("where CommId=" + cId + " and NewsId="
				+ nId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPNewsCommen"
							+ " where CommId=" + cId + " and NewsId=" + nId
							+ " ) A " + "WHERE RowNumber > " + 15 * (pager - 1));
			newsCommRes = getNewsCommRes(res, pager, totlePager);
			return newsCommRes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param result
	 * @return ��ȡ�������ۻظ���Ϣ
	 */
	public List<NewsCommRes> getNewsCommRes(ResultSet result, int pager,
			int totlePager) {
		newsCommRes = new ArrayList<NewsCommRes>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.EQUITY_ID);
				int nId = result.getInt(SqlUtil.NEWSFAVORITES_NID);
				int uId = result.getInt(SqlUtil.EQUITYFAVORITES_UID);
				int commId = result.getInt(SqlUtil.NEWSCOMMRES_COMMID);
				String bodys = result.getString(SqlUtil.NEWS_BODYS);
				String insertDate = result
						.getString(SqlUtil.EQUITYFAVORITES_DATE);
				int goodNum = result.getInt(SqlUtil.NEWSCOMM_GOODNUM);
				int isShow = result.getInt(SqlUtil.NEWSCOMM_ISSHOW);
				NewsCommRes ncr = new NewsCommRes(id, uId, nId, commId, bodys,
						insertDate, goodNum, isShow);
				ncr.setTotlePager(totlePager);
				ncr.setPager(pager);
				newsCommRes.add(ncr);
			}
			return newsCommRes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
