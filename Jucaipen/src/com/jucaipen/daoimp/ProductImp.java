package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.ProductDao;
import com.jucaipen.model.Product;
import com.jucaipen.utils.JdbcUtil;

public class ProductImp implements ProductDao {
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private List<Product> products;

	/**
	 * @return ��ѯ��Ʒ��ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Product "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * ��ѯ���в�Ʒ��Ϣ
	 */
	public List<Product> findAll(int pager) {
		int totlePager = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product"
							+ " ) A " + "WHERE RowNumber > " + 15 * (pager - 1));
			products = getProducts(res, pager, totlePager);
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * ����id��ѯ��Ʒ��Ϣ
	 */
	public Product findProduct(int id) {
		Product product = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_Product where Id=" + id);
			products = getProducts(res, -1, -1);
			if (products != null && products.size() > 0) {
				product = products.get(0);
			}
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Product> findProductByTeacherId(int teacherId, int page) {
		// ���ݽ�ʦID��ȡ��Ʒ��Ϣ
		int totlePage = findTotlePager("WHERE TearchId=" + teacherId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product WHERE TearchId="
							+ teacherId + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			products = getProducts(res, page, totlePage);
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> findProductByTypes(int types, int page) {
		// ������Ʒ���ͻ�ȡ��Ʒ��Ϣ
		int totlePage = findTotlePager("WHERE Types=" + types);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product WHERE Types="
							+ types + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			products = getProducts(res, page, totlePage);
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> findProductBySaleState(int saleState, int page) {
		// ��������״̬��ȡ��Ʒ��Ϣ
		int totlePage = findTotlePager("WHERE SaleType=" + saleState);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product WHERE SaleType="
							+ saleState + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			products = getProducts(res, page, totlePage);
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> findProductByProductState(int isDeleted, int page) {
		// ������Ʒ״̬��ȡ��Ʒ��Ϣ
		int totlePage = findTotlePager("WHERE IsDelete=" + isDeleted);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS RowNumber,* FROM JCP_Product WHERE IsDelete="
							+ isDeleted + " ) A " + "WHERE RowNumber > " + 15
							* (page - 1));
			products = getProducts(res, page, totlePage);
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> findLastProduct(int lastCount) {
		// ��ȡ������ߵ���Ʒ��Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select TOP " + lastCount
					+ " * from JCP_Product order by Id DESC");
			products = getProducts(res, -1, -1);
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param result
	 * @return ��ȡ��Ʒ��Ϣ
	 */
	public List<Product> getProducts(ResultSet result, int pager, int totlePager) {
		products = new ArrayList<Product>();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				String name = result.getString("ProductTitle");
				String price = result.getString("Price");
				String nowPrice = result.getString("NowPrice");
				int tearchId = result.getInt("TearchId");
				int types = result.getInt("Types");
				int xuYueYear = result.getInt("XuYueYear");
				int xuYueMonth = result.getInt("XuYueMonth");
				int xuYueDay = result.getInt("XuYueDay");
				int saleType = result.getInt("SaleType");
				int isDelete = result.getInt("IsDelete");
				int pxId = result.getInt("PxId");
				Product p = new Product(pager, totlePager, id, name, price,
						nowPrice, tearchId, types, xuYueYear, xuYueMonth,
						xuYueDay, saleType, isDelete, pxId);
				p.setTotlePager(totlePager);
				p.setPager(pager);
				products.add(p);
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
