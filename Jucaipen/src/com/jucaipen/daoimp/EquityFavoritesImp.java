package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.EquityFavoritesDao;
import com.jucaipen.model.EquityFavorites;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

public class EquityFavoritesImp implements EquityFavoritesDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<EquityFavorites> equityFavorites;
	private int isSuccess;

	/**
	 * @return ��ѯ�ղع�Ȩ��ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPGuquanItem_Favorites "
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
	 * �ղع�Ȩ
	 */
	public int insertFavoritesEquity(int uId, EquityFavorites equityFavorites) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("insert into JCPGuquanItem_Favorites " + "("
							+ SqlUtil.EQUITYFAVORITES_UID + ","
							+ SqlUtil.EQUITYFAVORITES_EID + ","
							+ SqlUtil.EQUITYFAVORITES_DATE + ") VALUES ("
							+ equityFavorites.getuId() + ","
							+ equityFavorites.geteId() + ",'"
							+ equityFavorites.getDate() + "')");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * ȡ���ղع�Ȩ
	 */
	public int cancelFavoritesEquity(int uId, int eId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("delete from JCPGuquanItem_Favorites where UserId="
							+ uId + " and ProductId=" + eId);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * ��ȡ��ǰ�û��������ղصĹ�Ȩ
	 */
	public List<EquityFavorites> findFavoritesEquity(int uId, int pager) {
		int totlePager = findTotlePager("where UserId=" + uId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY Id DESC,InsertDate DESC) AS RowNumber,* FROM JCPGuquanItem_Favorites"
							+ " where UserId=" + uId + " ) A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			equityFavorites = getEquityFavorites(res, pager, totlePager);
			return equityFavorites;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * ����id��ѯ��ǰ�ղصĹ�Ȩ
	 */
	public EquityFavorites findEquityFavById(int id) {
		EquityFavorites ef = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select * from JCPGuquanItem_Favorites where Id="
							+ id);
			equityFavorites = getEquityFavorites(res, -1, -1);
			if (equityFavorites != null && equityFavorites.size() > 0) {
				ef = equityFavorites.get(0);
			}
			return ef;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    /*
     * 
     * ��ѯ��Ȩ�Ƿ��ղ�
     */
	public EquityFavorites findEquityIsCollect(int uId, int eId) {
		EquityFavorites ef = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select Id from JCPGuquanItem_Favorites where UserId="
							+ uId+" and ProductId="+eId);
			while (res.next()) {
				int id=res.getInt(SqlUtil.NEWS_ID);
				ef=new EquityFavorites();
				ef.setId(id);
			}
			return ef;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param result
	 * @return ��ȡ�ղصĹ�Ȩ��Ϣ
	 */
	public List<EquityFavorites> getEquityFavorites(ResultSet result,
			int pager, int totlePager) {
		equityFavorites = new ArrayList<EquityFavorites>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.EQUITYFAVORITES_ID);
				int uId = result.getInt(SqlUtil.EQUITYFAVORITES_UID);
				int eId = result.getInt(SqlUtil.EQUITYFAVORITES_EID);
				String insertDate = result
						.getString(SqlUtil.EQUITYFAVORITES_DATE);
				EquityFavorites ef = new EquityFavorites();
				ef.seteId(eId);
				ef.setId(id);
				ef.setuId(uId);
				ef.setDate(insertDate);
				ef.setTotlePager(totlePager);
				ef.setPager(pager);
				equityFavorites.add(ef);
			}
			return equityFavorites;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
