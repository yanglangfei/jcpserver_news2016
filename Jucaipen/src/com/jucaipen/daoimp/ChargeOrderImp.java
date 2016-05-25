package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.jucaipen.dao.ChargeOrderDao;
import com.jucaipen.model.ChargeOrder;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         ��ֵ����
 */
public class ChargeOrderImp implements ChargeOrderDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ChargeOrder> orders = new ArrayList<ChargeOrder>();

	/**
	 * @return ��ѯ��ֵ������Ϣ��ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_AddOrder "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}

	@Override
	public ChargeOrder findOrderById(int id) {
		// ����id��ȡ��ֵ����
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_AddOrder WHERE Id=" + id);
			while (res.next()) {
				int userId = res.getInt(2); // UserId
				String orderCode = res.getString(3); // OrderCode
				double payMoney = res.getDouble(4); // Pay_money
				String insertDate = res.getString(5); // InsertDate
				String payDate = res.getString(6); // PaymentDate
				int payType = res.getInt(9); // PaymentMethod
				String alipayAccount = res.getString(10); // AlipayAccount
				int orderState = res.getInt(12); // OrderState
				ChargeOrder order = new ChargeOrder();
				order.setUserId(userId);
				order.setOrderCode(orderCode);
				order.setChargeMoney(payMoney);
				order.setInsertDate(insertDate);
				order.setPayDate(payDate);
				order.setPayType(payType);
				order.setAlipayAccount(alipayAccount);
				order.setOrderState(orderState);
				return order;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<ChargeOrder> findOrderByUid(int userId, int page) {
		// �����û�id��ȡ������Ϣ
		orders.clear();
		int totlePage = getTotlePage(" WHERE UserId=" + userId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_AddOrder WHERE UserId="
							+ userId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				String orderCode = res.getString("OrderCode");
				double payMoney = res.getDouble("Pay_money");
				String insertDate = res.getString("InsertDate");
				String payDate = res.getString("PaymentDate");
				int payType = res.getInt("PaymentMethod");
				String alipayAccount = res.getString("AlipayAccount");
				int orderState = res.getInt("OrderState");
				ChargeOrder order = new ChargeOrder();
				order.setTotlePage(totlePage);
				order.setPage(page);
				order.setOrderCode(orderCode);
				order.setChargeMoney(payMoney);
				order.setInsertDate(insertDate);
				order.setPayDate(payDate);
				order.setPayType(payType);
				order.setAlipayAccount(alipayAccount);
				order.setOrderState(orderState);
				orders.add(order);
			}
			return orders;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int addOrder(ChargeOrder order) {
		// ��Ӷ���
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta.executeUpdate("INSERT INTO JCP_AddOrder(UserId,"
					+ "OrderCode,Pay_money,InsertDate,PaymentDate,"
					+ "IsDel,IP,PaymentMethod,AlipayAccount,BankChannel,"
					+ "OrderState) VALUES(" + order.getUserId() + ",'"
					+ order.getOrderCode() + "','" + order.getChargeMoney()
					+ "','" + order.getInsertDate() + "','"
					+ order.getPayDate() + "'," + order.getIsDel() + ",'"
					+ order.getPayType() + ",'" + order.getAlipayAccount()
					+ "','" + order.getBankChannel() + "',"
					+ order.getOrderState() + ")");
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
