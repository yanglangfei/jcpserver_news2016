package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.MyGiftsDao;
import com.jucaipen.model.MyGifts;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         我的礼品
 */
public class MyGiftsImp implements MyGiftsDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<MyGifts> gifts = new ArrayList<MyGifts>();

	/**
	 * @return 查询礼品记录总页数
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_MyLiPin "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public List<MyGifts> findMyGiftBySenderId(int senderId, int page) {
		// 获取我送出的礼品
		gifts.clear();
		int totlePage = getTotlePage("WHERE FK_SendUserId=" + senderId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_MyLiPin WHERE FK_SendUserId="
							+ senderId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				int receiverId = res.getInt("FK_ReceiveUserId"); // FK_ReceiveUserId
				int giftId = res.getInt("FK_LiPinId"); // FK_LiPinId
				String insertDate = res.getString("InsertDate"); // InsertDate
				int sortId = res.getInt("SortId");
				int giftNum = res.getInt("LiPinNum");
				String remark = res.getString("ReMark");
				MyGifts g = new MyGifts();
				g.setId(id);
				g.setReceiverId(receiverId);
				g.setGiftId(giftId);
				g.setInsertDate(insertDate);
				g.setSortId(sortId);
				g.setGiftNum(giftNum);
				g.setRemark(remark);
				g.setPage(page);
				g.setTotlePage(totlePage);
				gifts.add(g);
			}
			return gifts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MyGifts> findMyGiftByReceiverId(int receiverId, int page) {
		// 获取我收到的礼品
		gifts.clear();
		int totlePage = getTotlePage("WHERE FK_ReceiveUserId=" + receiverId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_MyLiPin WHERE FK_ReceiveUserId="
							+ receiverId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				int sendId = res.getInt("FK_SendUserId"); // FK_SendUserId
				int giftId = res.getInt("FK_LiPinId"); // FK_LiPinId
				String insertDate = res.getString("InsertDate"); // InsertDate
				int sortId = res.getInt("SortId");
				int giftNum = res.getInt("LiPinNum");
				String remark = res.getString("ReMark");
				MyGifts g = new MyGifts();
				g.setId(id);
				g.setReceiverId(receiverId);
				g.setGiftId(giftId);
				g.setSenderId(sendId);
				g.setInsertDate(insertDate);
				g.setSortId(sortId);
				g.setGiftNum(giftNum);
				g.setRemark(remark);
				g.setPage(page);
				g.setTotlePage(totlePage);
				gifts.add(g);
			}
			return gifts;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int addGifts(MyGifts gifts) {
		// 添加礼品信息
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta
					.executeUpdate("INSERT INTO JCP_MyLiPin (FK_SendUserId,FK_ReceiveUserId,FK_LiPinId,InsertDate,SortId,LiPinNum,ReMark) VALUES ("
							+ gifts.getSenderId()
							+ ","
							+ gifts.getReceiverId()
							+ ","
							+ gifts.getGiftId()
							+ ",'"
							+ gifts.getInsertDate()
							+ "',"
							+ gifts.getSortId()
							+ ","
							+ gifts.getGiftNum()
							+ ",'"
							+ gifts.getRemark() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
