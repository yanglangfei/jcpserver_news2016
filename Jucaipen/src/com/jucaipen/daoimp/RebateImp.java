package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.RebateDao;
import com.jucaipen.model.Rebate;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         ������Ϣ
 */
public class RebateImp implements RebateDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Rebate> rebates = new ArrayList<Rebate>();

	/**
	 * @return ��ѯ������ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Rebate "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}

	@Override
	public Rebate findRebateById(int id) {
		// ����id��ȡ������Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_Rebate WHERE Id=" + id);
			while (res.next()) {
				int userId = res.getInt(2); // FK_TearchId
				int type = res.getInt(3); // RebateType
				double rebateMoney = res.getDouble(4); // RebateMoney
				int fromId = res.getInt(5); // FK_FromUserId
				String insertDate = res.getString(6); // InsertDate
				String remark = res.getString(7); // Ramerk
				Rebate rebate = new Rebate();
				rebate.setUserId(userId);
				rebate.setType(type);
				rebate.setRebateMoney(rebateMoney);
				rebate.setFromId(fromId);
				rebate.setInsertDate(insertDate);
				rebate.setRemark(remark);
				return rebate;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Rebate> findRebateByTid(int teacherId, int page) {
		// ���ݽ�ʦid��ȡ������Ϣ
		rebates.clear();
		int totlePage = getTotlePage("WHERE FK_TearchId=" + teacherId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Rebate WHERE FK_TearchId="
							+ teacherId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				int type = res.getInt("RebateType"); // RebateType
				double rebateMoney = res.getDouble("RebateMoney"); // RebateMoney
				int userId = res.getInt("FK_UserId"); // FK_FromUserId
				String insertDate = res.getString("InsertDate"); // InsertDate
				String remark = res.getString("Ramerk"); // Ramerk
				Rebate rebate = new Rebate();
				rebate.setFromId(teacherId);
				rebate.setType(type);
				rebate.setId(id);
				rebate.setTotlePage(totlePage);
				rebate.setPage(page);
				rebate.setRebateMoney(rebateMoney);
				rebate.setUserId(userId);
				rebate.setInsertDate(insertDate);
				rebate.setRemark(remark);
				rebates.add(rebate);
			}
			return rebates;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	
	@Override
	public List<Rebate> findRebateByUserId(int userId, int page) {
		// �����û�id��ȡ������Ϣ
		rebates.clear();
		int totlePage = getTotlePage("WHERE FK_UserId=" + userId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Rebate WHERE FK_UserId="
							+ userId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				int type = res.getInt("RebateType"); // RebateType
				double rebateMoney = res.getDouble("RebateMoney"); // RebateMoney
				int fromId = res.getInt("FK_FromUserId"); // FK_FromUserId
				String insertDate = res.getString("InsertDate"); // InsertDate
				String remark = res.getString("Ramerk"); // Ramerk
				Rebate rebate = new Rebate();
				rebate.setFromId(fromId);
				rebate.setType(type);
				rebate.setId(id);
				rebate.setTotlePage(totlePage);
				rebate.setPage(page);
				rebate.setRebateMoney(rebateMoney);
				rebate.setFromId(fromId);
				rebate.setInsertDate(insertDate);
				rebate.setRemark(remark);
				rebates.add(rebate);
			}
			return rebates;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
	
	

	@Override
	public int addRebate(Rebate rebate) {
		// ��ӷ�����Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta
					.executeUpdate("INSERT INTO JCP_Rebate(FK_FromId,RebateType,RebateMoney,FK_UserId,InsertDate,Ramerk) VALUES("
							+ rebate.getFromId()
							+ ","
							+ rebate.getType()
							+ ",'"
							+ rebate.getRebateMoney()
							+ "',"
							+ rebate.getUserId()
							+ ",'"
							+ rebate.getInsertDate()
							+ "','"
							+ rebate.getRemark() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<Rebate> findRebateByTid(int teacherId) {
		// ��ȡ��ʦ�µİ���Ϣ  
		rebates.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Rebate WHERE FK_TearchId="+teacherId);
			while (res.next()) {
				int id = res.getInt("Id");
				int type = res.getInt("RebateType"); // RebateType
				double rebateMoney = res.getDouble("RebateMoney"); // RebateMoney
				int userId = res.getInt("FK_UserId"); // FK_FromUserId
				String insertDate = res.getString("InsertDate"); // InsertDate
				String remark = res.getString("Ramerk"); // Ramerk
				Rebate rebate = new Rebate();
				rebate.setUserId(userId);
				rebate.setType(type);
				rebate.setId(id);
				rebate.setRebateMoney(rebateMoney);
				rebate.setFromId(teacherId);
				rebate.setInsertDate(insertDate);
				rebate.setRemark(remark);
				rebates.add(rebate);
			}
			return rebates;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Rebate> findRebate(int uId, int tId) {
		// ��ȡ�û����׽�ʦ�۲Ʊ���Ϣ
		rebates.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Rebate WHERE FK_TearchId="+tId+" AND FK_FromUserId="+uId);
			while (res.next()) {
				int id = res.getInt("Id");
				int type = res.getInt("RebateType"); // RebateType
				double rebateMoney = res.getDouble("RebateMoney"); // RebateMoney
				int fromId = res.getInt("FK_FromUserId"); // FK_FromUserId
				String insertDate = res.getString("InsertDate"); // InsertDate
				String remark = res.getString("Ramerk"); // Ramerk
				Rebate rebate = new Rebate();
				rebate.setType(type);
				rebate.setId(id);
				rebate.setRebateMoney(rebateMoney);
				rebate.setFromId(fromId);
				rebate.setInsertDate(insertDate);
				rebate.setRemark(remark);
				rebates.add(rebate);
			}
			return rebates;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
