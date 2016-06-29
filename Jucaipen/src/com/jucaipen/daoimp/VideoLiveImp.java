package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.VideoLiveDao;
import com.jucaipen.model.VideoLive;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

/**
 * @author Administrator
 * 
 *         ֱ����
 */
public class VideoLiveImp implements VideoLiveDao {
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private List<VideoLive> chatRooms = new ArrayList<VideoLive>();
	
	/**
	 * @return ��ѯֱ������ҳ��
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
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_VideoLive WHERE Id=" + id);
			while (res.next()) {
				String title=res.getString(2);  //Title
				String keyWord=res.getString(3);  //Keyword
				String desc=res.getString(4);  //Descirption
				int classId=res.getInt(5);  //Fk_CalssId
				String videoUrl=res.getString(6);  //Videourl
				String videoImage=res.getString(7);  //VideoImg
				int teacherId=res.getInt(8);  //Fk_TeacherId
				int isEnd=res.getInt(9);  //IsEnd
				String startDate=res.getString(10);  //StratDate
				String endDate=res.getString(11);  //EndDate
				int renQi=res.getInt(12);  //RenQi
				VideoLive live=new VideoLive();
				live.setClassId(classId);
				live.setDescript(desc);
				live.setEndDate(endDate);
				live.setIsEnd(isEnd);
				live.setKeyWord(keyWord);
				live.setRenQi(renQi);
				live.setStartDate(startDate);
				live.setTeacherId(teacherId);
				live.setTitle(title);
				live.setVideoImage(videoImage);
				live.setVideoUrl(videoUrl);
				return live;
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


	@Override
	public List<VideoLive> findLiveBytId(int tId) {
		// ��ȡ��ʦ�µ�ֱ����Ƶ��Ϣ
		chatRooms.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_VideoLive WHERE Fk_TeacherId="+tId);
			while (res.next()) {
				int id=res.getInt("Id");
				String title=res.getString("Title");  //Title
				String keyWord=res.getString("Keyword");  //Keyword
				String desc=res.getString("Descirption");  //Descirption
				int classId=res.getInt("Fk_CalssId");  //Fk_CalssId
				String videoUrl=res.getString("Videourl");  //Videourl
				String videoImage=res.getString("VideoImg");  //VideoImg
				int isEnd=res.getInt("IsEnd");  //IsEnd
				String startDate=res.getString("StratDate");  //StratDate
				String endDate=res.getString("EndDate");  //EndDate
				int renQi=res.getInt("RenQi");  //RenQi
				VideoLive live=new VideoLive();
				live.setId(id);
				live.setTitle(title);
				live.setKeyWord(keyWord);
				live.setDescript(desc);
				live.setClassId(classId);
				live.setVideoUrl(videoUrl);
				live.setVideoImage(videoImage);
				live.setTeacherId(tId);
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


	@Override
	public List<VideoLive> findLiveByIsEnd(int isEnd) {
		chatRooms.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_VideoLive WHERE IsEnd="+isEnd);
			while (res.next()) {
				int id=res.getInt("Id");
				String title=res.getString("Title");  //Title
				String keyWord=res.getString("Keyword");  //Keyword
				String desc=res.getString("Descirption");  //Descirption
				int classId=res.getInt("Fk_CalssId");  //Fk_CalssId
				String videoUrl=res.getString("Videourl");  //Videourl
				String videoImage=res.getString("VideoImg");  //VideoImg
				String startDate=res.getString("StratDate");  //StratDate
				String endDate=res.getString("EndDate");  //EndDate
				int renQi=res.getInt("RenQi");  //RenQi
				int teacherId=res.getInt("Fk_TeacherId");
				VideoLive live=new VideoLive();
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

}
