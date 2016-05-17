package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.NewSmallDao;
import com.jucaipen.model.NewsSmallClass;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

public class NewSmallImp implements NewSmallDao {
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private List<NewsSmallClass> newsSmallClasses;

	public List<NewsSmallClass> findAllSmallClass() {
		newsSmallClasses = new ArrayList<NewsSmallClass>();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPNewsSmallClass");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				int bigId = res.getInt(SqlUtil.NEWTWOCLASS_BIGID);
				String smallName = res.getString(SqlUtil.NEWTWOCLASS_SMALLNAME);
				String keyWord = res.getString(SqlUtil.NEWTWOCLASS_KEYWORD);
				String descprite = res.getString(SqlUtil.NEWTWOCLASS_DESC);
				String modelName = res.getString(SqlUtil.NEWTWOCLASS_MODELPATH);
				String filePath = res.getString(SqlUtil.NEWTWOCLASS_FILEPATH);
				String linkUrl = res.getString(SqlUtil.NEWTWOCLASS_LINKURL);
				int sort = res.getInt(SqlUtil.NEWTWOCLASS_SORTID);
				NewsSmallClass nsc = new NewsSmallClass(id, smallName);
				nsc.setBigId(bigId);
				nsc.setKeyWord(keyWord);
				nsc.setDescript(descprite);
				nsc.setTempleteName(modelName);
				nsc.setFilePath(filePath);
				nsc.setPxId(sort);
				nsc.setLinkUrl(linkUrl);
				newsSmallClasses.add(nsc);
			}
			return newsSmallClasses;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<NewsSmallClass> findSmallClassByBigId(int bigId) {
		newsSmallClasses = new ArrayList<NewsSmallClass>();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select Id,SmallName,BigId from JCPNewsSmallClass where BigId="
							+ bigId);
			while (res.next()) {
				int id = res.getInt(1);
				int bId = res.getInt(3);
				String smallName = res.getString(2);
				NewsSmallClass nsc = new NewsSmallClass(id, smallName);
				nsc.setBigId(bId);
				newsSmallClasses.add(nsc);
			}
			return newsSmallClasses;
		} catch (Exception e) {
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public NewsSmallClass findSmallClassById(int id) {
		return null;
	}

	public NewsSmallClass findSmallClassBySidAndBigId(int id, int bigId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select SmallName from JCPNewsSmallClass where BigId="
							+ bigId + " AND Id=" + id);
			while (res.next()) {
			   String name=res.getString(1);
			   NewsSmallClass nsc=new NewsSmallClass(id, name);
			   return nsc;
			}
		} catch (Exception e) {
		}

		return null;
	}

}
