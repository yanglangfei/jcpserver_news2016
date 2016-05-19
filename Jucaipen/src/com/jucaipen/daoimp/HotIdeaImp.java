package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.HotIdeaDao;
import com.jucaipen.model.HotIdea;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 * 
 *         ��־�����Ź۵� -----------------------JCP_Tearch_Log ---�����������
 */
public class HotIdeaImp implements HotIdeaDao {
	private List<HotIdea> ideas = new ArrayList<HotIdea>();
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private int isSuccess;

	/**
	 * @return ��ѯ������ҳ��
	 */
	public int findTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Tearch_Log "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}

	public int addHit(int ideaId, int hits) {
		// ��ӵ�����
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCP_Tearch_Log SET Hits="
					+ hits + " WHERE Id=" + ideaId);
			return isSuccess;
		} catch (Exception e) {
		}
		return -1;
	}

	public int addComment(int ideaId, int commCount) {
		// ���������
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("UPDATE JCP_Tearch_Log SET CommCount="
							+ commCount + " WHERE Id=" + ideaId);
			return isSuccess;
		} catch (Exception e) {
		}
		return -1;
	}

	public int addGood(int ideaId, int googs) {
		// ��ӵ�����
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCP_Tearch_Log SET Goods="
					+ googs + " WHERE Id=" + ideaId);
			return isSuccess;
		} catch (Exception e) {
		}
		return -1;
	}

	public HotIdea findGoodAndHitAndComm(int id) {
		// ��ȡ���������������������
		HotIdea idea = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Goods,CommCount,Hits FROM JCP_Tearch_Log WHERE Id="
							+ id);
			while (res.next()) {
				int goods = res.getInt("Goods");
				int comms = res.getInt("CommCount");
				int hits = res.getInt("Hits");
				idea = new HotIdea();
				idea.setId(id);
				idea.setHits(hits);
				idea.setCommens(comms);
				idea.setGoods(goods);
				return idea;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<HotIdea> findAllHotIdea(int page) {
		ideas.clear();
		try {
			int totlePage = findTotlePage("");
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 Id,InsertDate,Title,Bodys,Hits,FK_TearchId,Goods FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Tearch_Log) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			while (res.next()) {
				int id = res.getInt(1);
				String insertDate = res.getString(2);
				String title = res.getString(3);
				String body = res.getString(4);
				int hits = res.getInt(5);
				int teacherId = res.getInt(6);
				int goods=res.getInt(7);
				HotIdea idea = new HotIdea();
				idea.setId(id);
				idea.setTotlePgae(totlePage);
				idea.setPage(page);
				idea.setInsertDate(insertDate);
				idea.setBodys(body);
				idea.setHits(hits);
				idea.setTitle(title);
				idea.setGoods(goods);
				idea.setTeacherId(teacherId);
				ideas.add(idea);
			}
			return ideas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<HotIdea> findIdeaByCount(int count) {
		ideas.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP "
							+ count
							+ " Id,ISNULL (Title,'') Title,ISNULL (Bodys,'') Bodys,ISNULL (ImagesUrl,'') ImagesUrl FROM JCP_Tearch_Log  WHERE LEN(LogImg)>0 ORDER BY InsertDate DESC");
			while (res.next()) {
				int id = res.getInt("Id");
				String title = res.getString("Title");
				String bodys = res.getString("Bodys");
				String logImage = res.getString("ImagesUrl");
				HotIdea idea = new HotIdea();
				idea.setId(id);
				idea.setLogImage(logImage);
				idea.setBodys(bodys);
				idea.setTitle(title);
				ideas.add(idea);
			}
			return ideas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<HotIdea> findIdeaByTeacherId(int teacherId, int page) {
		try {
			int totlePage = findTotlePage("WHERE FK_TearchId=" + teacherId);
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Tearch_Log"
							+ " WHERE FK_TearchId=" + teacherId + " )A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			ideas = getHotIdea(res, page, totlePage);
			return ideas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public HotIdea findIdeaById(int id) {
		ideas.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Title,Bodys,InsertDate,Goods,FK_TearchId FROM JCP_Tearch_Log WHERE Id="
							+ id + " ORDER BY InsertDate DESC");
			while (res.next()) {
				String title = res.getString(1);
				String body = res.getString(2);
				String insertDate = res.getString(3);
				int goods = res.getInt(4);
				int teacherId = res.getInt(5);
				HotIdea idea = new HotIdea();
				idea.setId(id);
				idea.setBodys(body);
				idea.setTitle(title);
				idea.setInsertDate(insertDate);
				idea.setGoods(goods);
				idea.setTeacherId(teacherId);
				return idea;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<HotIdea> getHotIdea(ResultSet result, int page, int totlePage) {
		ideas.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				String title = result.getString("Title");
				String bodys = result.getString("Bodys");
				int goods = result.getInt("Goods");
				int hits = result.getInt("Hits");
				int comms = result.getInt("CommCount");
				int classId = result.getInt("FK_ClassId");
				String insertDate = result.getString("InsertDate");
				int teacherId = result.getInt("FK_TearchId");
				String logImage = result.getString("ImagesUrl");
				HotIdea idea = new HotIdea();
				idea.setPage(page);
				idea.setTotlePgae(totlePage);
				idea.setId(id);
				idea.setBodys(bodys);
				idea.setTitle(title);
				idea.setGoods(goods);
				idea.setHits(hits);
				idea.setCommens(comms);
				idea.setClassId(classId);
				idea.setInsertDate(insertDate);
				idea.setTeacherId(teacherId);
				idea.setLogImage(logImage);
				ideas.add(idea);
			}
			return ideas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
