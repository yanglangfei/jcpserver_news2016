package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.MyVideoDao;
import com.jucaipen.model.MyVideo;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 *
 *  �ҵ���Ƶ
 */
public class MyVideoImp implements MyVideoDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<MyVideo> myVideos=new ArrayList<MyVideo>();
	
	/**
	 * @return ��ѯ�ҵ���Ƶ��ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_MyVideo "
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
	public MyVideo findVideoById(int id) {
		//����id��ȡ�ҵ���Ƶ
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_MyVideo WHERE Id="+id);
			while (res.next()) {
				int userId=res.getInt(2);  //FK_UserId
				int videoId=res.getInt(3);  //FK_VideoId
				String insertDate=res.getString(4);  //InsertDate
				String remark=res.getString(5);  //Remark
				int isStop=res.getInt(7);  //IsStop
				String startDate=res.getString(8);  //StartDate
				String endDate=res.getString(9);  //EndDate
				MyVideo video=new MyVideo();
				video.setUserId(userId);
				video.setVideoId(videoId);
				video.setInsertDate(insertDate);
				video.setRemark(remark);
				video.setIsStop(isStop);
				video.setStartDate(startDate);
				video.setEndDate(endDate);
				return video;
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
	public List<MyVideo> findMyVideoByUserId(int userId, int page) {
		//�����û�id��ȡ�ҵ���Ƶ
		myVideos.clear();
		int totlePage=getTotlePage("WHERE FK_UserId="+userId);
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP 15 * FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_MyVideo WHERE FK_UserId="
					+ userId + ") A " + "WHERE RowNumber > " + 15
					* (page - 1));
			while (res.next()) {
				int id=res.getInt("Id");  //FK_UserId
				int videoId=res.getInt("FK_VideoId");  //FK_VideoId
				String insertDate=res.getString("InsertDate");  //InsertDate
				String remark=res.getString("Remark");  //Remark
				int isStop=res.getInt("IsStop");  //IsStop
				String startDate=res.getString("StartDate");  //StartDate
				String endDate=res.getString("EndDate");  //EndDate
				MyVideo video=new MyVideo();
				video.setUserId(userId);
				video.setId(id);
				video.setTotlePage(totlePage);
				video.setPage(page);
				video.setVideoId(videoId);
				video.setInsertDate(insertDate);
				video.setRemark(remark);
				video.setIsStop(isStop);
				video.setStartDate(startDate);
				video.setEndDate(endDate);
				myVideos.add(video);
			}
			return myVideos;
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
	public int addMyVideo(MyVideo video) {
		//����ҵ���Ƶ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta
					.executeUpdate("INSERT INTO JCP_MyVideo (FK_UserId,FK_SpecialId,InsertDate,Remark,IsDel,IsStop,StartDate,EndDate) VALUES ("
							+ video.getUserId()
							+ ","
							+ video.getVideoId()
							+ ",'"
							+ video.getInsertDate()
							+ "','"
							+ video.getRemark()
							+ "',"
							+ video.getIsDel()
							+ ","
							+ video.getIsStop()
							+ ",'"
							+ video.getStartDate()
							+ "','"
							+ video.getEndDate() + "')");
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
	public int removeMyVideo(int id) {
		//ɾ���ҵ���Ƶ
		return 0;
	}

}
