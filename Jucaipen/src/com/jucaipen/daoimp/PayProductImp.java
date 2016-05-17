package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.PayProductDao;
import com.jucaipen.model.PayProduct;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 * 
 *         "SELECT TOP 15 * FROM " +
 *         "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product"
 *         + " ) A " + "WHERE RowNumber > " + 15 * (pager - 1)
 * 
 * 
 *         ������ϸ��Ϣ
 */
public class PayProductImp implements PayProductDao {
	private List<PayProduct> payProducts = new ArrayList<PayProduct>();
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
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from Pay_Order_Item "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<PayProduct> findAllPayProductList(int page) {
		// ��ȡȫ��������ϸ��Ϣ
		int totlePage = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM Pay_Order_Item"
							+ " ) A " + "WHERE RowNumber > " + 15 * (page - 1));
			payProducts = getPayProducts(res, page, totlePage);
			return payProducts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<PayProduct> findPayProductByUid(int uId, int page) {
		// �����û�ID��ȡ������ϸ��Ϣ
		int totlePage = findTotlePager("WHERE UserId=" + uId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM Pay_Order_Item WHERE UserId="
							+ uId + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			payProducts = getPayProducts(res, page, totlePage);
			return payProducts;
		} catch (Exception e) {
		}
		return null;
	}

	public List<PayProduct> findPayProductByProductId(int productId, int page) {
		// ������Ʒ��Ϣ��ȡ������Ϣ
		int totlePage = findTotlePager("WHERE FK_ProductId=" + productId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM Pay_Order_Item WHERE FK_ProductId="
							+ productId + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			payProducts = getPayProducts(res, page, totlePage);
			return payProducts;
		} catch (Exception e) {
		}
		return null;
	}

	public PayProduct findPayProductByOrderId(String orderId) {
		// ���ݶ���ID��ȡ������ϸ��Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM Pay_Order_Item WHERE OrderCode='"
							+ orderId + "'");
			payProducts = getPayProducts(res, 1, 1);
			if (payProducts.size() > 0) {
				return payProducts.get(0);
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<PayProduct> findPayProductByIsDeleted(int isDeleted, int page) {
		// ������Ʒ״̬��ȡ������ϸ��Ϣ
		int totlePage = findTotlePager("WHERE IsDelete=" + isDeleted);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM Pay_Order_Item WHERE IsDelete="
							+ isDeleted + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			payProducts = getPayProducts(res, page, totlePage);
			return payProducts;
		} catch (Exception e) {
		}
		return null;
	}

	public List<PayProduct> findPayProductByProductType(int productType,
			int page) {
		// ������Ʒ���ͻ�ȡ������ϸ��Ϣ
		int totlePage = findTotlePager("WHERE ProductType=" + productType);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM Pay_Order_Item WHERE ProductType="
							+ productType + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			return getPayProducts(res, page, totlePage);
		} catch (Exception e) {
		}
		return null;
	}

	public PayProduct findPayProductById(int id) {
		// ����ID��ȡ������ϸ��Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM Pay_Order_Item WHERE ID="
					+ id);
			payProducts = getPayProducts(res, 1, 1);
			if (payProducts.size() > 0) {
				return payProducts.get(0);
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<PayProduct> findLastPayProduct(int lastCount) {
		// ��ȡ�������������ϸ��Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP " + lastCount
					+ " * FROM Pay_Order_Item ORDER BY ID");
			return getPayProducts(res, 1, 1);
		} catch (Exception e) {
		}
		return null;
	}

	public int addPayProductInfo(PayProduct payProduct) {
		// ��Ӷ�����ϸ��Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO Pay_Order_Item"
							+ "(OrderCode,FK_ProductId,Price,NowPrice,BuyCount,AllMoney,ProductTitle,"
							+ "XuYueYear,XuYueMonth,XuYueDay,IsDelete,ProductType,UserId) VALUES ('"
							+ payProduct.getOrderId()
							+ "',"
							+ payProduct.getProductId()
							+ ",'"
							+ payProduct.getPrice()
							+ "','"
							+ payProduct.getNowPrice()
							+ "',"
							+ payProduct.getBuyCount()
							+ ",'"
							+ payProduct.getAllMoney()
							+ "','"
							+ payProduct.getProductTitle()
							+ "',"
							+ payProduct.getXuYueYear()
							+ ","
							+ payProduct.getXuYueMonth()
							+ ","
							+ payProduct.getXuYueDay()
							+ ","
							+ payProduct.getIsDelete()
							+ ","
							+ payProduct.getUserId() + ")");
			return isSuccess;
		} catch (Exception e) {
		}
		return -1;
	}

	public List<PayProduct> getPayProducts(ResultSet result, int page,
			int totlePage) {
		payProducts.clear();
		try {
			while (result.next()) {
				int id = result.getInt("ID");
				String orderCode = result.getString("OrderCode");
				int productId = result.getInt("FK_ProductId");
				String price = result.getString("Price");
				String nowPrice = result.getString("NowPrice");
				int buyCount = result.getInt("BuyCount");
				String allMoney = result.getString("AllMoney");
				String productTitle = result.getString("ProductTitle");
				int xuYueYear = result.getInt("XuYueYear");
				int xuYueMonth = result.getInt("XuYueMonth");
				int xuYueDay = result.getInt("XuYueDay");
				int isDelete = result.getInt("IsDelete");
				int productType = result.getInt("ProductType");
				int userId = result.getInt("UserId");
				PayProduct payProduct = new PayProduct();
				payProduct.setId(id);
				payProduct.setPage(page);
				payProduct.setTotlePage(totlePage);
				payProduct.setOrderId(orderCode);
				payProduct.setProductId(productId);
				payProduct.setPrice(price);
				payProduct.setNowPrice(nowPrice);
				payProduct.setBuyCount(buyCount);
				payProduct.setAllMoney(allMoney);
				payProduct.setProductTitle(productTitle);
				payProduct.setXuYueYear(xuYueYear);
				payProduct.setXuYueMonth(xuYueMonth);
				payProduct.setXuYueDay(xuYueDay);
				payProduct.setIsDelete(isDelete);
				payProduct.setProductType(productType);
				payProduct.setUserId(userId);
				payProduct.setTotlePage(totlePage);
				payProduct.setPage(page);
				payProducts.add(payProduct);
			}
			return payProducts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
