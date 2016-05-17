package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.LiveRoomDao;
import com.jucaipen.model.ChatRoom;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

/**
 * @author Administrator
 * 
 * 
 *         ֱ����
 */
public class LiveRoomImp implements LiveRoomDao {
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private List<ChatRoom> chatRooms = new ArrayList<ChatRoom>();

	public List<ChatRoom> getRoomList() {
		// ��ȡ����ֱ��������
		chatRooms.clear();
		try {
			dbConn = JdbcUtil.connVideoSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT UserLevel,RoomFace,ShiTingDay,RoomType,IsStopYouke,Id,RoomName,LiveUrl FROM Chat_Room");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String roomName = res.getString("RoomName");
				int IsStopYouke=res.getInt("IsStopYouke");
				int ShiTingDay=res.getInt("ShiTingDay");
				String roomFace=res.getString("RoomFace");
				String UserLevel=res.getString("UserLevel");
				String liveUrl=res.getString("LiveUrl");
				int roomType=res.getInt("RoomType");
				if(roomType==0){
					ChatRoom room = new ChatRoom();
					room.setId(id);
					room.setRoomType(roomType);
					room.setLiveUrl(liveUrl);
					room.setUserLevel(UserLevel);
					room.setRoomFace(roomFace);
					room.setIsStopYouke(IsStopYouke);
					room.setRoomName(roomName);
					room.setShiTingDay(ShiTingDay);
					chatRooms.add(room);
				}
			}
			return chatRooms;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ChatRoom getRoomInfo(int id) {
		// ����id ��ȡָ��ֱ������Ϣ
		try {
			dbConn = JdbcUtil.connVideoSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM Chat_Room WHERE Id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ChatRoom> getAllRoom() {
		return null;
	}

	public ChatRoom getLiveUrl(int id) {
		// ����id ��ѯֱ������Ƶ
		try {
			dbConn = JdbcUtil.connVideoSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT LiveUrl FROM Chat_Room WHERE Id="
					+ id);
			while (res.next()) {
				String liveUrl = res.getString("LiveUrl");
				ChatRoom room = new ChatRoom();
				room.setLiveUrl(liveUrl);
				return room;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
