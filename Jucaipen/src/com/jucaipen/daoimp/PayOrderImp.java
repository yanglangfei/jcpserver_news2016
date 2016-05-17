package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.PayOrderDao;
import com.jucaipen.model.PayOrder;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator ������Ϣ
 * 
 * 
 *         "SELECT TOP 15 * FROM " +
 *         "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product"
 *         + " ) A " + "WHERE RowNumber > " + 15 * (pager - 1)
 */
public class PayOrderImp implements PayOrderDao {
	private List<PayOrder> payOrders = new ArrayList<PayOrder>();
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;

	/**
	 * @return ��ѯ��Ʒ��ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from Pay_order "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<PayOrder> findAllPayOrderList(int page) {
		// ��ȡȫ���Ķ�����Ϣ
		int totlePage = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order"
							+ " ) A " + "WHERE RowNumber > " + 15 * (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
		} catch (Exception e) {
		}
		return null;
	}

	public List<PayOrder> findPayOrderByUid(int uId, int page) {
		// �����û�ID��ȡ������Ϣ
		int totlePage = findTotlePager("WHERE UserId=" + uId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order WHERE UserId="
							+ uId + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
		} catch (Exception e) {
		}
		return null;
	}

	public List<PayOrder> findPayOrderByPayState(int payState, int page) {
		// ����֧��״̬��ȡ������Ϣ
		int totlePage = findTotlePager("WHERE PayType=" + payState);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order WHERE PayType="
							+ payState + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
		} catch (Exception e) {
		}
		return null;
	}

	public List<PayOrder> findPayOrderByOrderState(int orderState, int page) {
		// ���ݶ���״̬��ȡ������Ϣ
		int totlePage = findTotlePager("WHERE OrderType=" + orderState);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order WHERE OrderType="
							+ orderState + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
		} catch (Exception e) {
		}
		return null;
	}

	public List<PayOrder> findPayOrderByTeacherId(int teacherId, int page) {
		// ���ݽ�ʦID��ȡ������Ϣ
		int totlePage = findTotlePager("WHERE FromTearchId=" + teacherId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order WHERE FromTearchId="
							+ teacherId + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
		} catch (Exception e) {
		}
		return null;
	}

	public List<PayOrder> findPayOrderByProductState(int productState, int page) {
		// ������Ʒ��Ϣ��ȡ������Ϣ
		int totlePage = findTotlePager("WHERE IsDelete=" + productState);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM Pay_order WHERE IsDelete="
							+ productState + " ) A " + "WHERE RowNumber > "
							+ 15 * (page - 1));
			payOrders = getPayOrder(res, page, totlePage);
			return payOrders;
		} catch (Exception e) {
		}
		return null;
	}

	public List<PayOrder> findLastPayOrder(int lastCount) {
		// ��ȡ����ļ�������
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP " + lastCount
					+ " * FROM Pay_order ORDER BY InsertDate DESC");
			payOrders = getPayOrder(res, 1, 1);
			return payOrders;
		} catch (Exception e) {
		}
		return null;
	}

	public PayOrder findPayOrderById(int id) {
		// ����ID��ȡ������Ϣ
		PayOrder order = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT  * FROM Pay_order WHERE Id=" + id);
			payOrders = getPayOrder(res, 1, 1);
			if (payOrders.size() > 0) {
				order = payOrders.get(0);
				return order;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public int changePayState(int payType, String payDate, String orderCode) {
		// ����֧��״̬
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE Pay_order SET PayType="
					+ payType + ",PayDate='" + payDate + "' WHERE OrderCode='"
					+ orderCode + "'");
			return isSuccess;
		} catch (Exception e) {
		}
		return -1;
	}

	public int addPayOrder(PayOrder payOrder) {
		// ��Ӷ�����Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO Pay_order "
							+ "(UserId,Title,OrderCode,AllMoney,PayMoney,InsertDate,PayModel,"
							+ "PayType,FromTearchId,IsDelete) VALUES ("
							+ payOrder.getUserId()+",'"+payOrder.getTitle()+"','"+payOrder.getOrderCode()
							+"','"+payOrder.getAllMoney()+"','"+payOrder.getPayMoney()+"','"+payOrder.getInsertDate()
							+"',"+payOrder.getPayModel()+","+payOrder.getPayState()+","+
							payOrder.getFromTeacherId()+","+payOrder.getIsDelete()+")");
			return isSuccess;
		} catch (Exception e) {
		}
		return -1;
	}

	public List<PayOrder> getPayOrder(ResultSet result, int page, int totlePage) {
		payOrders.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int userId = result.getInt("UserId");
				String trueName = result.getString("TrueName");
				String mobileNum = result.getString("MobileNum");
				int provinceId = result.getInt("FK_ProId");
				int cityId = result.getInt("FK_CityId");
				int areaId = result.getInt("FK_AareId");
				String address = result.getString("Address");
				String title = result.getString("Title");
				String orderCode = result.getString("OrderCode");
				String allMoney = result.getString("AllMoney");
				String payMoney = result.getString("PayMoney");
				String insertDate = result.getString("InsertDate");
				int payModel = result.getInt("PayModel");
				int payState = result.getInt("PayType");
				String payDate = result.getString("PayDate");
				int orderState = result.getInt("OrderType");
				int fromTeacherId = result.getInt("FromTearchId");
				int productState = result.getInt("IsDelete");
				PayOrder payOrder = new PayOrder();
				payOrder.setId(id);
				payOrder.setUserId(userId);
				payOrder.setTrueName(trueName);
				payOrder.setMobileNum(mobileNum);
				payOrder.setProvinceId(provinceId);
				payOrder.setCityId(cityId);
				payOrder.setAreaId(areaId);
				payOrder.setAddress(address);
				payOrder.setTitle(title);
				payOrder.setOrderCode(orderCode);
				payOrder.setAllMoney(allMoney);
				payOrder.setPayMoney(payMoney);
				payOrder.setInsertDate(insertDate);
				payOrder.setPayModel(payModel);
				payOrder.setPayState(payState);
				payOrder.setPayDate(payDate);
				payOrder.setOrderState(orderState);
				payOrder.setFromTeacherId(fromTeacherId);
				payOrder.setIsDelete(productState);
				payOrder.setTotlePage(totlePage);
				payOrder.setPage(page);
				payOrders.add(payOrder);
			}
			return payOrders;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
