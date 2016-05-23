package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.TxtMsgDao;
import com.jucaipen.model.LiveMsg;
import com.jucaipen.utils.JdbcUtil;

public class LiveMsgImp implements TxtMsgDao {
	private List<LiveMsg> lInteractives = new ArrayList<LiveMsg>();
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;

	/**
	 * @return 查询新闻总页数
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_TxtLive_Msg "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	public int insertLiveInteractive(LiveMsg interactive) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCP_TxtLive_Msg "
							+ "(Fk_TxtLiveId,UserId,InsertDate,MessBody,shenhe,IP,ReceiverId)"
							+ "VALUES (" + interactive.getLiveId() + ","
							+ interactive.getUserId() + ","
							+ interactive.getInsertDate() + "','"
							+ interactive.getMsgBodys() + "',"
							+ interactive.getCheck() + ",'"
							+ interactive.getIp() + "',"
							+ interactive.getReceiverId() + ")");
			return isSuccess;
		} catch (Exception e) {
		}
		return -1;
	}

	public List<LiveMsg> findAll() {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_TxtLive_Msg ORDER BY InsertDate DESC");
			lInteractives = getLiveInteractive(res, 1, 1);
			return lInteractives;
		} catch (Exception e) {
		}
		return null;
	}

	public List<LiveMsg> findByUserId(int userId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_TxtLive_Msg WHERE UserId="
							+ userId + " ORDER BY InsertDate DESC");
			lInteractives = getLiveInteractive(res, 1, 1);
			return lInteractives;
		} catch (Exception e) {
		}
		return null;
	}

	public List<LiveMsg> findByLiveId(int liveId, int page) {
		int totlePage = findTotlePager(" WHERE Fk_TxtLiveId=" + liveId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_TxtLive_Msg WHERE Fk_TxtLiveId="
							+ liveId + " ORDER BY InsertDate DESC");
			lInteractives = getLiveInteractive(res, page, totlePage);
			return lInteractives;
		} catch (Exception e) {
		}
		return null;
	}

	public List<LiveMsg> findByUidAndLiveId(int uId, int liveId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_TxtLive_Msg WHERE UserId="
							+ uId + "AND Fk_TxtLiveId=" + liveId
							+ " ORDER BY InsertDate DESC");
			lInteractives = getLiveInteractive(res, 1, 1);
			return lInteractives;
		} catch (Exception e) {
		}
		return null;
	}

	public LiveMsg findById(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_TxtLive_Msg");
			lInteractives = getLiveInteractive(res, 1, 1);
			if (lInteractives.size() > 0) {
				return lInteractives.get(0);
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<LiveMsg> getLiveInteractive(ResultSet result, int page,
			int totlePage) {
		lInteractives.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int liveId = result.getInt("Fk_TxtLiveId");
				int userId = result.getInt("UserId");
				String insertDate = result.getString("InsertDate");
				String bodys = result.getString("MessBody");
				int check = result.getInt("shenhe");
				String ip = result.getString("IP");
				int receiverId = result.getInt("ReceiverId");
				int isSysAdmin = result.getInt("");
				int isRoomAdmin = result.getInt("");
				LiveMsg liInteractive = new LiveMsg(id, userId,
						bodys, check, liveId, insertDate, receiverId,
						isSysAdmin, isRoomAdmin, ip);
				liInteractive.setTotlePage(totlePage);
				liInteractive.setPage(page);
				lInteractives.add(liInteractive);
			}
			return lInteractives;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
