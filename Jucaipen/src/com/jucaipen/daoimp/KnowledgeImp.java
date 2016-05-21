package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.KnowledgeDao;
import com.jucaipen.model.Knowledge;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 *
 *  知识
 */
public class KnowledgeImp implements KnowledgeDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Knowledge> knowledges=new ArrayList<Knowledge>();
	
	/**
	 * @return 查询知识总页数
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_BasicKnowledge "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}


	@Override
	public Knowledge findKnowledgeById(int id) {
		//根据id获取知识信息
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_BasicKnowledge WHERE Id="+id);
			while (res.next()) {
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Knowledge> findKnowledgeByClassId(int classId, int page) {
		//根据分类获取知识信息
		knowledges.clear();
		int totlePage=getTotlePage("WHERE FK_ClassId="+classId);
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_BasicKnowledge WHERE FK_ClassId="
							+ classId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id=res.getInt("Id");  //Id
				String title=res.getString("Title"); //Title
				String keyWord=res.getString("KeyWord"); //KeyWord
				String body=res.getString("Bodys");  //Bodys
				int hits=res.getInt("HitCount");  //HitCount
				int xnHits=res.getInt("HitXNCount");  //HitXNCount
				String insertDate=res.getString("InsertDate"); //InsertDate
				int fromId=res.getInt("FK_FromId"); //FK_FromId
				String image=res.getString("ImageUrl");  //ImageUrl
				String zuoZhe=res.getString("ZuoZhe");  //ZuoZhe
				int zans=res.getInt("Zan");  //Zan
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Knowledge> findAllKnowledge(int page) {
		//获取所有的知识信息
		knowledges.clear();
		int totlePage=getTotlePage("");
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_BasicKnowledge"
							+") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
