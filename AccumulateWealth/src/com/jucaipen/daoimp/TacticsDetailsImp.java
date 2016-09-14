package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	private List<TacticsDetails> detailsArray=new ArrayList<TacticsDetails>();
	
	
	/**
	 * @return ��ѯս����ϸ��ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Tacticsdetails "
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
	public TacticsDetails findDetailsById(int id) {
		// ����id��ȡս����ϸ��Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FRM JCP_Tacticsdetails WHERE IsDel=0");
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
	public List<TacticsDetails> findDetailsByFkId(int fkId,int page) {
		// ����ս��id��ȡս����ϸ��Ϣ
		detailsArray.clear();
		int totlePage=findTotlePager(" WHERE TacticsId="+fkId+" AND IsDel=0");
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER ( ORDER BY InsertDate DESC) AS RowNumber,* FROM JCP_Tacticsdetails"
							+" WHERE TacticsId="+fkId+" AND IsDel=0) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				String title = res.getString("title"); // title
				String body = res.getString("Bodys"); // Bodys
				String insertDate = res.getString("InsertDate"); // InsertDate
				int isDel = res.getInt("IsDel"); // IsDel
				TacticsDetails details = new TacticsDetails();
				details.setPage(page);
				details.setTotlePage(totlePage);
				details.setTitle(title);
				details.setId(id);
				details.setBody(body);
				details.setFkId(fkId);
				details.setInsertDate(insertDate);
				details.setIsDel(isDel);
				detailsArray.add(details);
			}
			return detailsArray;
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

}
