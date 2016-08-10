package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.TxtLiveSaleDao;
import com.jucaipen.model.TxtLiveSale;
import com.jucaipen.utils.JdbcUtil;

public class TxtLiveSaleImp implements TxtLiveSaleDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<TxtLiveSale> sales = new ArrayList<TxtLiveSale>();

	@Override
	public TxtLiveSale findSaleByUidAndTxtId(int uId, int txtId) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_TxtLiveSale WHERE FK_UserId="
							+ uId + " AND FK_TxtLiveId=" + txtId);
			while (res.next()) {
				int id = res.getInt(1);
				String insertDate = res.getString(6);
				TxtLiveSale sale = new TxtLiveSale();
				sale.setId(id);
				sale.setInsertDate(insertDate);
				return sale;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<TxtLiveSale> findSaleByUserId(int userId) {
		sales.clear();
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_TxtLiveSale WHERE FK_UserId="
							+ userId);
			while (res.next()) {
				int id = res.getInt(1);
				String insertDate = res.getString(6);
				int teacherId = res.getInt(3);
				TxtLiveSale sale = new TxtLiveSale();
				sale.setId(id);
				sale.setInsertDate(insertDate);
				sale.setTeacherId(teacherId);
				sales.add(sale);
			}
			return sales;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int addSale(TxtLiveSale sale) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta
					.executeUpdate("INSERT INTO JCP_TxtLiveSale"
							+ "(FK_UserId,FK_TearchId,OrderCode,FK_TxtLiveId,InsertDate) VALUES ("
							+ sale.getUserId() + "," + sale.getTeacherId()
							+ ",'" + sale.getOrderCode() + "',"
							+ sale.getFk_txtId() + ",'" + sale.getInsertDate()
							+ "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
