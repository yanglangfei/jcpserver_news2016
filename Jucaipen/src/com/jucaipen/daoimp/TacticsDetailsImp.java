package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.jucaipen.dao.TacticsDetailsDao;
import com.jucaipen.model.TacticsDetails;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         ս����ϸ��Ϣ
 */
public class TacticsDetailsImp implements TacticsDetailsDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;

	@Override
	public TacticsDetails findDetailsById(int id) {
		// ����id��ȡս����ϸ��Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FRM JCP_Tacticsdetails");
			while (res.next()) {
				String title = res.getString("title"); // title
				String body = res.getString("Bodys"); // Bodys
				int fkId = res.getInt("TacticsId"); // TacticsId
				String insertDate = res.getString("InsertDate"); // InsertDate
				int isDel = res.getInt("IsDel"); // IsDel
				TacticsDetails details = new TacticsDetails();
				details.setTitle(title);
				details.setBody(body);
				details.setFkId(fkId);
				details.setInsertDate(insertDate);
				details.setIsDel(isDel);
				return details;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TacticsDetails findDetailsByFkId(int fkId) {
		// ����ս��id��ȡս����ϸ��Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_Tacticsdetails WHERE TacticsId="
							+ fkId);
			while (res.next()) {
				int id = res.getInt("Id");
				String title = res.getString("title"); // title
				String body = res.getString("Bodys"); // Bodys
				String insertDate = res.getString("InsertDate"); // InsertDate
				int isDel = res.getInt("IsDel"); // IsDel
				TacticsDetails details = new TacticsDetails();
				details.setTitle(title);
				details.setId(id);
				details.setBody(body);
				details.setFkId(fkId);
				details.setInsertDate(insertDate);
				details.setIsDel(isDel);
				return details;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
