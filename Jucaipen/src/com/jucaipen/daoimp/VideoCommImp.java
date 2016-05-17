package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.VideoCommDao;
import com.jucaipen.model.VideoComm;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

public class VideoCommImp implements VideoCommDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<VideoComm> vList = new ArrayList<VideoComm>();

	public List<VideoComm> findAll() {
		// ��ѯ���е���Ƶ����
		vList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from VideoCommen");
			vList = getVideoComm(res);
			return vList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<VideoComm> findVideoCommByUid(int uId) {
		// �����û�id��ѯ��Ƶ����
		vList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from VideoCommen where UserId="
					+ uId);
			vList = getVideoComm(res);
			return vList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<VideoComm> findVideoCommByVid(int videoId) {
		// ������Ƶid ��ѯ��ǰ��Ƶ�µ���������
		vList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from VideoCommen where VideoId="
					+ videoId);
			vList = getVideoComm(res);
			return vList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public VideoComm findVideoCommById(int id) {
		// ����id��ѯ��Ƶ������ϸ����
		vList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from VideoCommen where Id=" + id);
			vList = getVideoComm(res);
			return vList.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<VideoComm> findVideoCommByIsShow(int isShow) {
		// ��ѯ�Ƿ���ʾ����Ƶ����
		vList.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from VideoCommen where IsShow="
					+ isShow);
			vList = getVideoComm(res);
			return vList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<VideoComm> getVideoComm(ResultSet result) {
		// ��ȡ������Ϣ
		vList.clear();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.VIDEOCOMM_ID);
				int videoId = result.getInt(SqlUtil.VIDEOCOMM_VIDEOID);
				int userId = result.getInt(SqlUtil.VIDEOCOMM_USERID);
				String bodys = result.getString(SqlUtil.VIDEOCOMM_BODYS);
				int goodCount = result.getInt(SqlUtil.VIDEOCOMM_GOODCOUNT);
				int replyCount = result.getInt(SqlUtil.VIDEOCOMM_REPLYCOUNT);
				String insertDate = result
						.getString(SqlUtil.VIDEOCOMM_INSERTDATE);
				String ip = result.getString(SqlUtil.VIDEOCOMM_IP);
				int isShow = result.getInt(SqlUtil.VIDEOCOMM_ISSHOW);
				VideoComm videoComm = new VideoComm(id, videoId, userId, bodys);
				videoComm.setGoodCount(goodCount);
				videoComm.setReplyCount(replyCount);
				videoComm.setIsShow(isShow);
				videoComm.setIp(ip);
				videoComm.setInsertDate(insertDate);
				vList.add(videoComm);
			}
			return vList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
