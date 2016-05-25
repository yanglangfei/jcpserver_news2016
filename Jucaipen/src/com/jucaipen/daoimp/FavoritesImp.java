package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.FavoritesDao;
import com.jucaipen.model.Favorites;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

public class FavoritesImp implements FavoritesDao {
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private List<Favorites> favorites;
	private int isSuccess;

	/**
	 * @return ��ѯ�ղ���ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Favorites "
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

	/*
	 * �ղ���Ϣ
	 */
	public int insertFavorites(int uId, Favorites newsFavorites) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("insert into JCP_Favorites ("
					+ SqlUtil.NEWSCOMM_UID + "," + SqlUtil.FAVORITES_NID + ","
					+ SqlUtil.NEWS_INSERT + ") values("
					+ newsFavorites.getuId() + "," + newsFavorites.getFk_Id()
					+ ",'" + newsFavorites.getDate() + "')");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	/*
	 * ȡ���ղ���Ϣ
	 */
	public int cancelFavorites(int uId, int nId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("delete from JCP_Favorites where FK_UserId="
							+ uId + " and FK_Id=" + nId);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	/*
	 * 
	 * ��ѯ�Ƿ��ղ�
	 */
	public Favorites findFavouritesByUidAndNid(int uId, int nId) {
		Favorites newsFavorites = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select Id from JCP_Favorites where FK_UserId="
							+ uId + " and FK_Id=" + nId);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				newsFavorites = new Favorites();
				newsFavorites.setId(id);
			}
			return newsFavorites;
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
	public List<Favorites> findFavourateByUidAndType(int uId, int type, int page) {
		int totlePager = findTotlePager("Where FK_UserId=" + uId + " AND Type="
				+ type);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC,InsertDate DESC) AS RowNumber,* FROM JCP_Favorites"
							+ " where FK_UserId=" + uId + " AND Type=" + type
							+ ") A " + "WHERE RowNumber > " + 15 * (page - 1));
			favorites = getFavorites(res, page, totlePager);
			return favorites;
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

	/*
	 * ��ѯ���û��ղص�����������Ѷ��Ϣ
	 */
	public List<Favorites> findFavorites(int uId, int pager) {
		int totlePager = findTotlePager("Where FK_UserId=" + uId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id DESC,InsertDate DESC) AS RowNumber,* FROM JCP_Favorites"
							+ " where FK_UserId=" + uId + ") A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			favorites = getFavorites(res, pager, totlePager);
			return favorites;
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

	/**
	 * @param result
	 * @return ��ȡ�ղص�������Ϣ
	 */
	public List<Favorites> getFavorites(ResultSet result, int pager,
			int totlePager) {
		favorites = new ArrayList<Favorites>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.NEWS_ID);
				int uId = result.getInt(SqlUtil.NEWSCOMM_UID);
				int nId = result.getInt(SqlUtil.FAVORITES_NID);
				String insertDate = result
						.getString(SqlUtil.EQUITYFAVORITES_DATE);
				Favorites nf = new Favorites();
				nf.setTotlePager(totlePager);
				nf.setPager(pager);
				nf.setId(id);
				nf.setuId(uId);
				nf.setFk_Id(nId);
				nf.setDate(insertDate);
				favorites.add(nf);
			}
			return favorites;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return favorites;

	}

}
