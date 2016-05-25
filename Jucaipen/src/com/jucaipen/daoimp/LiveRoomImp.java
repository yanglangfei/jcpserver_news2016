package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.LiveRoomDao;
import com.jucaipen.model.VideoLive;
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
	private List<VideoLive> chatRooms = new ArrayList<VideoLive>();

	public List<VideoLive> getRoomList() {
		// ��ȡ����ֱ��������
		chatRooms.clear();
		try {
			dbConn = JdbcUtil.connVideoSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT VideoImg,Id,Title,Videourl FROM JCP_VideoLive");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String roomName = res.getString("Title");
				String roomFace = res.getString("VideoImg");
				String liveUrl = res.getString("Videourl");
				VideoLive room = new VideoLive();
				room.setId(id);
				room.setVideoUrl(liveUrl);
				room.setVideoImage(roomFace);
				room.setTitle(roomName);
				chatRooms.add(room);
			}
			return chatRooms;
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

	public VideoLive getRoomInfo(int id) {
		// ����id ��ȡָ��ֱ������Ϣ
		try {
			dbConn = JdbcUtil.connVideoSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_VideoLive WHERE Id=" + id);
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

	public List<VideoLive> getAllRoom() {
		return null;
	}

	public VideoLive getLiveUrl(int id) {
		// ����id ��ѯֱ������Ƶ
		try {
			dbConn = JdbcUtil.connVideoSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Videourl FROM JCP_VideoLive WHERE Id="
							+ id);
			while (res.next()) {
				String liveUrl = res.getString("Videourl");
				VideoLive room = new VideoLive();
				room.setVideoUrl(liveUrl);
				return room;
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
