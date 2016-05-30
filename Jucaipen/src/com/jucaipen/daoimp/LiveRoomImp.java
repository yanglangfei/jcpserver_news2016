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
 *         直播间
 */
public class LiveRoomImp implements LiveRoomDao {
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private List<VideoLive> chatRooms = new ArrayList<VideoLive>();
	
	/**
	 * @return 查询直播室总页数
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_VideoLive "
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
	

	public List<VideoLive> getRoomList() {
		// 获取所有直播间名称
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
		// 根据id 获取指定直播间信息
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

	public List<VideoLive> getAllRoom(int page) {
		chatRooms.clear();
		int totlePage=getTotlePage("");
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP 15 * FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY StratDate desc) AS RowNumber,* FROM JCP_VideoLive"
					+ ") A " + "WHERE RowNumber > " + 15
					* (page - 1));
			while (res.next()) {
				int id=res.getInt("Id");
				String title=res.getString("Title");  //Title
				String keyWord=res.getString("Keyword");  //Keyword
				String desc=res.getString("Descirption");  //Descirption
				int classId=res.getInt("Fk_CalssId");  //Fk_CalssId
				String videoUrl=res.getString("Videourl");  //Videourl
				String videoImage=res.getString("VideoImg");  //VideoImg
				int teacherId=res.getInt("Fk_TeacherId");  //Fk_TeacherId
				int isEnd=res.getInt("IsEnd");  //IsEnd
				String startDate=res.getString("StratDate");  //StratDate
				String endDate=res.getString("EndDate");  //EndDate
				int renQi=res.getInt("RenQi");  //RenQi
				VideoLive live=new VideoLive();
				live.setPage(page);
				live.setTotlePage(totlePage);
				live.setId(id);
				live.setTitle(title);
				live.setKeyWord(keyWord);
				live.setDescript(desc);
				live.setClassId(classId);
				live.setVideoUrl(videoUrl);
				live.setVideoImage(videoImage);
				live.setTeacherId(teacherId);
				live.setIsEnd(isEnd);
				live.setStartDate(startDate);
				live.setEndDate(endDate);
				live.setRenQi(renQi);
				chatRooms.add(live);
			}
			return chatRooms;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public VideoLive getLiveUrl(int id) {
		// 根据id 查询直播室视频
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
