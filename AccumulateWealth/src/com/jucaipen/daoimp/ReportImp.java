package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.ReportDao;
import com.jucaipen.model.Report;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         �ٱ�
 */
public class ReportImp implements ReportDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Report> reports = new ArrayList<Report>();

	/**
	 * @return ��ѯ�ٱ���ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Report "
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
	public Report findRepoterById(int id) {
		// ����id��ȡ�ٱ���Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_Report WHERE Id=" + id);
			while (res.next()) {
				String body = res.getString(2); // bodys
				int type = res.getInt(3); // Fk_type
				int fkId = res.getInt(4); // Fk_Id
				int userId = res.getInt(5); // UserId
				String insertDate = res.getString(6); // InsertDate
				int isHandle = res.getInt(7); // Ishandle
				String handleRemark = res.getString(8); // handleRemabrk
				String handleDate = res.getString(9); // handleDate
				String handleRen = res.getString(10); // handleRen
				Report report = new Report();
				report.setBodys(body);
				report.setType(type);
				report.setFk_id(fkId);
				report.setInsertDate(insertDate);
				report.setHandleRemabrk(handleRemark);
				report.setHandleDate(handleDate);
				report.setUserId(userId);
				report.setIshandle(isHandle);
				report.setHandleRen(handleRen);
				return report;
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
	public List<Report> findRepoterByUserId(int userId, int page) {
		// ��ȡ�û��µľٱ���Ϣ
		reports.clear();
		int totlePage = getTotlePage("WHERE UserId=" + userId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Report WHERE UserId="
							+ userId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				String body = res.getString("bodys"); // bodys
				int type = res.getInt("Fk_type"); // Fk_type
				int fkId = res.getInt("Fk_Id"); // Fk_Id
				String insertDate = res.getString("InsertDate"); // InsertDate
				int isHandle = res.getInt("Ishandle"); // Ishandle
				String handleRemark = res.getString("handleRemabrk"); // handleRemabrk
				String handleDate = res.getString("handleDate"); // handleDate
				String handleRen = res.getString("handleRen"); // handleRen
				Report report = new Report();
				report.setBodys(body);
				report.setType(type);
				report.setFk_id(fkId);
				report.setId(id);
				report.setTotlePage(totlePage);
				report.setPage(page);
				report.setInsertDate(insertDate);
				report.setHandleRemabrk(handleRemark);
				report.setHandleDate(handleDate);
				report.setUserId(userId);
				report.setIshandle(isHandle);
				report.setHandleRen(handleRen);
				reports.add(report);
			}
			return reports;
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
	public List<Report> findRepoterByUserIdAndType(int userId, int type,
			int page) {
		// ��ȡ�û������µľٱ���Ϣ
		reports.clear();
		int totlePage = getTotlePage("WHERE UserId=" + userId + " AND Fk_type="
				+ type);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Report WHERE UserId="
							+ userId + " AND Fk_type=" + type + ") A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				String body = res.getString("bodys"); // bodys
				int fkId = res.getInt("Fk_Id"); // Fk_Id
				String insertDate = res.getString("InsertDate"); // InsertDate
				int isHandle = res.getInt("Ishandle"); // Ishandle
				String handleRemark = res.getString("handleRemabrk"); // handleRemabrk
				String handleDate = res.getString("handleDate"); // handleDate
				String handleRen = res.getString("handleRen"); // handleRen
				Report report = new Report();
				report.setBodys(body);
				report.setType(type);
				report.setFk_id(fkId);
				report.setId(id);
				report.setTotlePage(totlePage);
				report.setPage(page);
				report.setInsertDate(insertDate);
				report.setHandleRemabrk(handleRemark);
				report.setHandleDate(handleDate);
				report.setUserId(userId);
				report.setIshandle(isHandle);
				report.setHandleRen(handleRen);
				reports.add(report);
			}
			return reports;
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
	public int addRepoter(Report report) {
		// ��Ӿٱ���Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			System.out.println("INSERT INTO JCP_Report(bodys,Fk_type,Fk_Id,UserId,InsertDate,IP,Ishandle,handleRemabrk,handleDate,handleRen) VALUES('"
							+ report.getBodys()
							+ "',"
							+ report.getType()
							+ ","
							+ report.getFk_id()
							+ ","
							+ report.getUserId()
							+ ",'"
							+ report.getInsertDate()
							+ "','"
							+ report.getIp()
							+ "',"
							+ report.getIshandle()
							+ ",'"
							+ report.getHandleRemabrk()
							+ "','"
							+ report.getHandleDate()
							+ "','"
							+ report.getHandleRen() + "')");
			return sta
					.executeUpdate("INSERT INTO JCP_Report(bodys,Fk_type,Fk_Id,UserId,InsertDate,IP,Ishandle,handleRemabrk,handleDate,handleRen) VALUES('"
							+ report.getBodys()
							+ "',"
							+ report.getType()
							+ ","
							+ report.getFk_id()
							+ ","
							+ report.getUserId()
							+ ",'"
							+ report.getInsertDate()
							+ "','"
							+ report.getIp()
							+ "',"
							+ report.getIshandle()
							+ ",'"
							+ report.getHandleRemabrk()
							+ "','"
							+ report.getHandleDate()
							+ "','"
							+ report.getHandleRen() + "')");
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

}
