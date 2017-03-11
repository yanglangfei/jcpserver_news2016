package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.LiveRecoderDao;
import com.jucaipen.model.LiveRecoder;
import com.jucaipen.utils.JdbcUtil;

public class LiveRecoderImp implements LiveRecoderDao {
	private Connection conn;
	private Statement sta;
	private ResultSet res;
	private List<LiveRecoder> recoders = new ArrayList<LiveRecoder>();

	@Override
	public LiveRecoder getRecoderByRect() {
		//��ȡ������е�ֱ��
		try {
			conn = JdbcUtil.connSqlServer();
			sta = conn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 1 * FROM JCP_VideoLive_Record ORDER BY LiveStartDate DESC");
			while (res.next()) {
				int id = res.getInt(1);
				int liveId = res.getInt(2);
				String liveNo = res.getString(3);
				int teacherId = res.getInt(4);
				String startDate = res.getString(5);
				int liveState = res.getInt(6);
				String endDate = res.getString(7);
				String remark = res.getString(8);
				LiveRecoder recoder = new LiveRecoder(id, liveId, teacherId,
						liveNo, startDate, liveState, endDate, remark);
				return recoder;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LiveRecoder getRecoderByLiveId(int liveId) {
		//����ֱ��id��ȡֱ����¼��Ϣ
		try {
			conn = JdbcUtil.connSqlServer();
			sta = conn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 1 * FROM JCP_VideoLive_Record WHERE VideoLiveId="+liveId);
			while (res.next()) {
				int id = res.getInt(1);
				String liveNo = res.getString(3);
				int teacherId = res.getInt(4);
				String startDate = res.getString(5);
				int liveState = res.getInt(6);
				String endDate = res.getString(7);
				String remark = res.getString(8);
				LiveRecoder recoder = new LiveRecoder(id, liveId, teacherId,
						liveNo, startDate, liveState, endDate, remark);
				return recoder;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
