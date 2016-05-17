package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.ServerQQDao;
import com.jucaipen.model.ServerQQ;
import com.jucaipen.utils.JdbcUtil;

public class ServerQQImp implements ServerQQDao {

	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ServerQQ> servers = new ArrayList<ServerQQ>();

	public List<ServerQQ> findAllServer() {
		// ��ȡ���еı�����Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM Chat_ServerQQ");
			servers = getServerQQInfo(res);
			return servers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ServerQQ findServerById(int id) {
		// ��ȡ���еı�����Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM Chat_ServerQQ WHERE Id=" + id);
			servers = getServerQQInfo(res);
			if (servers != null && servers.size() > 0) {
				return servers.get(0);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ServerQQ> findServerByRoomId(int roomId) {
		// ��ȡ���еı�����Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM Chat_ServerQQ WHERE RoomId="
					+ roomId);
			servers = getServerQQInfo(res);
			return servers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<ServerQQ> getServerQQInfo(ResultSet result) {
		// ��ȡ������Ϣ
		servers.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				String title = result.getString("Title");
				int RoomId = result.getInt("RoomId");
				String QQ = result.getString("QQ");
				int pxId = result.getInt("PxId");
				ServerQQ qqs = new ServerQQ();
				qqs.setId(id);
				qqs.setTitle(title);
				qqs.setQqCode(QQ);
				qqs.setPxId(pxId);
				qqs.setRoomId(RoomId);
				servers.add(qqs);
			}
			return servers;
		} catch (Exception e) {
		}
		return null;
	}

}
