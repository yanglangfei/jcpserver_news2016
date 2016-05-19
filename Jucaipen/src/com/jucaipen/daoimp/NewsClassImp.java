package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.NewsClassDao;
import com.jucaipen.model.NewsClass;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

public class NewsClassImp implements NewsClassDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<NewsClass> nList = new ArrayList<NewsClass>();

	public List<NewsClass> findAllBigClass() {
		// 获取一级分类所有信息
		nList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPNewsBigClass");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String BigName = res.getString(SqlUtil.NEWONECLASS_BIGNAME);
				String KeyWord = res.getString(SqlUtil.NEWONECLASS_KEYWORD);
				String Description = res.getString(SqlUtil.NEWONECLASS_DESC);
				String TempleteName = res
						.getString(SqlUtil.NEWONECLASS_MODELNAME);
				String FilePath = res.getString(SqlUtil.NEWONECLASS_FILEPATH);
				String LinkUrl = res.getString(SqlUtil.NEWONECLASS_LINKURL);
				int sortId = res.getInt(SqlUtil.NEWONECLASS_SORTID);
				NewsClass nBigClass = new NewsClass(id, BigName, KeyWord,
						Description, TempleteName, FilePath, sortId);
				nBigClass.setLinkUrl(LinkUrl);
				nList.add(nBigClass);
			}
			return nList;

		} catch (Exception e) {
		}

		return null;
	}

	public List<NewsClass> findBigClassById(int id) {
		// 根据id 获取分类信息
		nList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPNewsBigClass where Id="
					+ id);
			while (res.next()) {
				String BigName = res.getString(SqlUtil.NEWONECLASS_BIGNAME);
				String KeyWord = res.getString(SqlUtil.NEWONECLASS_KEYWORD);
				String Description = res.getString(SqlUtil.NEWONECLASS_DESC);
				String TempleteName = res
						.getString(SqlUtil.NEWONECLASS_MODELNAME);
				String FilePath = res.getString(SqlUtil.NEWONECLASS_FILEPATH);
				String LinkUrl = res.getString(SqlUtil.NEWONECLASS_LINKURL);
				int sortId = res.getInt(SqlUtil.NEWONECLASS_SORTID);
				NewsClass nBigClass = new NewsClass(id, BigName, KeyWord,
						Description, TempleteName, FilePath, sortId);
				nBigClass.setLinkUrl(LinkUrl);
				nList.add(nBigClass);
			}
			return nList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
