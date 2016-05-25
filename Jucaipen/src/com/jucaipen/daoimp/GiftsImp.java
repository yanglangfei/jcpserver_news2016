package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.GiftsDao;
import com.jucaipen.model.Gifts;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         ��Ʒ
 */
public class GiftsImp implements GiftsDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Gifts> gifts = new ArrayList<Gifts>();

	/**
	 * @return ��ѯ��Ʒ��ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_LiPin "
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
	public List<Gifts> findAllGift(int page) {
		// ��ȡ������Ʒ
		gifts.clear();
		int totlePage = getTotlePage("");
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY Id desc) AS RowNumber,* FROM JCP_LiPin) A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				String title = res.getString("Title");
				double price = res.getDouble("Price");
				String thumbnail = res.getString("Thumbnail");
				Gifts gift = new Gifts();
				gift.setId(id);
				gift.setTitle(title);
				gift.setPrice(price);
				gift.setTotlePage(totlePage);
				gift.setPage(page);
				gift.setThumbnail(thumbnail);
				gifts.add(gift);
			}
			return gifts;
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
	public List<Gifts> findGiftByClassId(int page, int classId) {
		// ���ݷ����ȡ��Ʒ
		gifts.clear();
		int totlePage = getTotlePage("WHERE ClassId="+classId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY Id desc) AS RowNumber,* FROM JCP_LiPin WHERE  ClassId="
							+ classId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				String title = res.getString("Title");
				double price = res.getDouble("Price");
				String thumbnail = res.getString("Thumbnail");
				Gifts gift = new Gifts();
				gift.setId(id);
				gift.setTitle(title);
				gift.setPrice(price);
				gift.setTotlePage(totlePage);
				gift.setPage(page);
				gift.setThumbnail(thumbnail);
				gifts.add(gift);
			}
			return gifts;
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
	public Gifts findGiftById(int id) {
		// ����id��ȡ��Ʒ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_LiPin WHERE Id="+id);
			while (res.next()) {
				String title = res.getString("Title");
				double price = res.getDouble("Price");
				String thumbnail = res.getString("Thumbnail");
				Gifts gift = new Gifts();
				gift.setId(id);
				gift.setTitle(title);
				gift.setPrice(price);
				gift.setThumbnail(thumbnail);
				return gift;
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

}
