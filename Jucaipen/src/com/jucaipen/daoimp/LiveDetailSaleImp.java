package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.LiveDetailSaleDao;
import com.jucaipen.model.LiveDetailSale;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         ����ֱ���۵���Ϣ JCP_LiveDetailSale
 */
public class LiveDetailSaleImp implements LiveDetailSaleDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<LiveDetailSale> sales = new ArrayList<LiveDetailSale>();

	/**
	 * @return ��ѯֱ���۵㹺����ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_LiveDetailSale "
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
	public LiveDetailSale findSaleById(int id) {
		// ����id��ȡ������Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_LiveDetailSale WHERE Id="
					+ id);
			while (res.next()) {
				int userId = res.getInt(2); // FK_UserId
				int teacherId = res.getInt(3); // FK_TearchId
				String orderCode = res.getString(4); // OrderCode
				int liveDetailId = res.getInt(5); // FK_LiveDetailId
				String insertDate = res.getString(6); // InsertDate
				LiveDetailSale sale = new LiveDetailSale();
				sale.setUserId(userId);
				sale.setTeacherId(teacherId);
				sale.setOrderCode(orderCode);
				sale.setLiveDetailId(liveDetailId);
				sale.setInsertDate(insertDate);
				return sale;
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
	public List<LiveDetailSale> findSaleByUid(int uId, int page) {
		// �����û�id��ȡ������Ϣ
		sales.clear();
		int totlePage = getTotlePage("WHERE FK_UserId=" + uId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_LiveDetailSale WHERE FK_UserId="
							+ uId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				int teacherId = res.getInt("FK_TearchId"); // FK_TearchId
				String orderCode = res.getString("OrderCode"); // OrderCode
				int liveDetailId = res.getInt("FK_LiveDetailId"); // FK_LiveDetailId
				String insertDate = res.getString("InsertDate"); // InsertDate
				LiveDetailSale sale = new LiveDetailSale();
				sale.setUserId(uId);
				sale.setId(id);
				sale.setTotlePage(totlePage);
				sale.setPage(page);
				sale.setTeacherId(teacherId);
				sale.setOrderCode(orderCode);
				sale.setLiveDetailId(liveDetailId);
				sale.setInsertDate(insertDate);
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
	public int addSale(LiveDetailSale sale) {
		// ��ӹ�����Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta
					.executeUpdate("INSERT INTO JCP_LiveDetailSale (FK_UserId,FK_TearchId,OrderCode,FK_LiveDetailId,InsertDate) VALUES ("
							+ sale.getUserId()
							+ ","
							+ sale.getTeacherId()
							+ ",'"
							+ sale.getOrderCode()
							+ "',"
							+ sale.getLiveDetailId()
							+ ",'"
							+ sale.getInsertDate() + "')");
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
