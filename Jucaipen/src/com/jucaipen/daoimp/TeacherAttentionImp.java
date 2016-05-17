package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.TeacherAttentionDao;
import com.jucaipen.model.TeacherAttention;
import com.jucaipen.utils.JdbcUtil;

public class TeacherAttentionImp implements TeacherAttentionDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;
	private List<TeacherAttention> teacherAttentions = new ArrayList<TeacherAttention>();
	
	
	/**
	 * @return ��ѯ������ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPTearch_Attention "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int insertAttention(TeacherAttention attention) {
		// ��ӹ�ע
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCPTearch_Attention(UserId,TearchId) VALUES ("
							+ attention.getUserId()
							+ ","
							+ attention.getTeacherId() + ")");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public int cancleAttention(int tId, int uId) {
		//ȡ����ע
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			isSuccess=sta.executeUpdate("DELETE FROM JCPTearch_Attention WHERE UserId="+uId+" AND TearchId="+tId);
		    return isSuccess;
		} catch (Exception e) {
		}
		return 0;
	}


	public List<TeacherAttention> findAllAttention() {
		// �������еĹ�ע
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Attention ORDER BY Id");
			teacherAttentions = getAttention(res,1,1);
			return teacherAttentions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TeacherAttention> findAttentionByUid(int userId) {
		// ��ѯ��ǰ�û��µ�����
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Attention WHERE UserId="
							+ userId + " ORDER BY Id");
			teacherAttentions = getAttention(res,1,1);
			return teacherAttentions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TeacherAttention> findAttentionBytid(int tId,int page) {
		int totlePage=findTotlePager("WHERE TearchId="+tId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY Id desc) AS RowNumber,* FROM JCPTearch_Attention"
							+ " where TearchId="
							+ tId
							+ ") A "
							+ "WHERE RowNumber > "
							+ 15
							* (page - 1));
			teacherAttentions = getAttention(res,page,totlePage);
			return teacherAttentions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public TeacherAttention findAttentionByUidAndTid(int uId, int tId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCPTearch_Attention WHERE UserId="
							+ uId + " and TearchId=" + tId + " ORDER BY Id");
			teacherAttentions = getAttention(res,1,1);
			if(teacherAttentions.size()>0){
			   return teacherAttentions.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<TeacherAttention> getAttention(ResultSet result,int page,int totlePage) {
		teacherAttentions.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int userId = result.getInt("UserId");
				int teacherId = result.getInt("TearchId");
				TeacherAttention attention = new TeacherAttention(id, userId,
						teacherId);
				attention.setTotlePage(totlePage);
				attention.setPage(page);
				teacherAttentions.add(attention);
			}
			return teacherAttentions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
