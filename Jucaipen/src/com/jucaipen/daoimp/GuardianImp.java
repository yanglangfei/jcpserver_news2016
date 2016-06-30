package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.GuardianDao;
import com.jucaipen.model.Guardian;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         �ػ���
 */
public class GuardianImp implements GuardianDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Guardian> guardians = new ArrayList<Guardian>();

	/**
	 * @return ��ѯ�ػ���Ϣ��ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_ShouHuZhe "
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
	public Guardian findGuardianById(int id) {
		// ����id��ȡ�ػ���Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_ShouHuZhe WHERE Id=" + id);
			while (res.next()) {
				int userId = res.getInt(2); // FK_UserId
				int teacherId = res.getInt(3); // FK_TearchId
				String insertDate = res.getString(4); // InsertDate
				String startDate = res.getString(5); // StartDate
				String endDate = res.getString(6); // EndDate
				int state = res.getInt(7); // State
				Guardian guardian = new Guardian();
				guardian.setUserId(userId);
				guardian.setTeacherId(teacherId);
				guardian.setInsertDate(insertDate);
				guardian.setStartDate(startDate);
				guardian.setEndDate(endDate);
				guardian.setState(state);
				return guardian;
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
	public List<Guardian> findGurdianByUid(int userId, int page) {
		// �����û�id��ȡ���ػ���
		guardians.clear();
		int totlePage = getTotlePage("WHERE FK_UserId=" + userId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_ShouHuZhe WHERE FK_UserId="
							+ userId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				int teacherId = res.getInt("FK_TearchId"); // FK_TearchId
				String insertDate = res.getString("InsertDate"); // InsertDate
				String startDate = res.getString("StartDate"); // StartDate
				String endDate = res.getString("EndDate"); // EndDate
				int state = res.getInt("State"); // State
				Guardian guardian = new Guardian();
				guardian.setPage(page);
				guardian.setTotlePage(totlePage);
				guardian.setId(id);
				guardian.setUserId(userId);
				guardian.setTeacherId(teacherId);
				guardian.setInsertDate(insertDate);
				guardian.setStartDate(startDate);
				guardian.setEndDate(endDate);
				guardian.setState(state);
				guardians.add(guardian);
			}
			return guardians;
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
	public List<Guardian> findGuradianByTeacherId(int teacherId, int page) {
		// ���ݽ�ʦid��ȡ�ػ��ҵ�
		guardians.clear();
		int totlePage = getTotlePage("WHERE FK_TearchId=" + teacherId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_ShouHuZhe WHERE FK_TearchId="
							+ teacherId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				int userId = res.getInt("FK_UserId");
				String insertDate = res.getString("InsertDate"); // InsertDate
				String startDate = res.getString("StartDate"); // StartDate
				String endDate = res.getString("EndDate"); // EndDate
				int state = res.getInt("State"); // State
				Guardian guardian = new Guardian();
				guardian.setPage(page);
				guardian.setTotlePage(totlePage);
				guardian.setId(id);
				guardian.setUserId(userId);
				guardian.setTeacherId(teacherId);
				guardian.setInsertDate(insertDate);
				guardian.setStartDate(startDate);
				guardian.setEndDate(endDate);
				guardian.setState(state);
				guardians.add(guardian);
			}
			return guardians;
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
	public int addGuardian(Guardian guardian) {
		// ����ػ���Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta
					.executeUpdate("INSERT INTO JCP_ShouHuZhe(FK_UserId,FK_TearchId,InsertDate,Ip,StartDate,EndDate,State) VALUES ("
							+ guardian.getUserId()
							+ ","
							+ guardian.getTeacherId()
							+ ",'"
							+ guardian.getInsertDate()
							+ "','"
							+ guardian.getIp()
							+ "','"
							+ guardian.getStartDate()
							+ "','"
							+ guardian.getEndDate()
							+ "',"
							+ guardian.getState() + ")");
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
	public List<Guardian> findGuradianByTeacherId(int teacherId) {
		// ���ݽ�ʦid��ȡ�ػ���Ϣ
		guardians.clear();
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_ShouHuZhe WHERE FK_TearchId="+teacherId);
			while (res.next()) {
				int id = res.getInt("Id");
				int userId = res.getInt("FK_UserId");
				String insertDate = res.getString("InsertDate"); // InsertDate
				String startDate = res.getString("StartDate"); // StartDate
				String endDate = res.getString("EndDate"); // EndDate
				int state = res.getInt("State"); // State
				Guardian guardian = new Guardian();
				guardian.setId(id);
				guardian.setUserId(userId);
				guardian.setTeacherId(teacherId);
				guardian.setInsertDate(insertDate);
				guardian.setStartDate(startDate);
				guardian.setEndDate(endDate);
				guardian.setState(state);
				guardians.add(guardian);
			}
			return guardians;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Guardian findIsGuardian(int teacherId, int userId) {
	     dbConn=JdbcUtil.connSqlServer();
	     try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT Id FROM JCP_ShouHuZhe WHERE FK_UserId="+userId+" AND FK_TearchId="+teacherId+" AND State=0");
			while (res.next()) {
				int id=res.getInt(1);
				Guardian guardian=new Guardian();
				guardian.setId(id);
				return guardian;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
