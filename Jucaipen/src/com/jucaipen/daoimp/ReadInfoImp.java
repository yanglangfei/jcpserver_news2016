package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jucaipen.dao.ReadInfoDao;
import com.jucaipen.model.ReadInfo;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

public class ReadInfoImp implements ReadInfoDao {
	private Connection dbConn;
	private ResultSet res;
	private Statement sta;
	private List<ReadInfo> readInfos;

	/**
	 * @return ��ѯ��ȡ��Ϣ��ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPUser_Message_Read "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * ��ȡ��ȡ��������Ϣ
	 */
	public List<ReadInfo> findAll(int pager) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPUser_Message_Read"
							+ " ) A " + "WHERE RowNumber > " + 15 * (pager - 1));
			readInfos = getReadInfo(res,-1,-1);
			return readInfos;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * ����id��ѯ��ȡ��Ϣ����ϸ����
	 */
	public ReadInfo findReadInfo(int id) {
		ReadInfo info = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select * from JCPUser_Message_Read where MessId="
							+ id);
			readInfos = getReadInfo(res,-1,-1);
			if (readInfos != null && readInfos.size() > 0) {
				info = readInfos.get(0);
			}
			return info;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ��ȡָ���û������ж�ȡ����Ϣ
	 */
	public List<ReadInfo> findReadInfoByUser(int userId, int pager) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPUser_Message_Read"
							+ "where "+" ) A " + "WHERE RowNumber > " + 15 * (pager - 1));
			readInfos = getReadInfo(res,-1,-1);
			return readInfos;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * ���ݶ�ȡʱ���ȡ��ȡ����Ϣ
	 */
	public List<ReadInfo> findReadInfoByReadDate(String readDate, int pager) {
		int totlePager = findTotlePager("where ReadDate=" + readDate);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCPUser_Message_Read"
							+ "where ReadDate=" + readDate + " ) A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			readInfos = getReadInfo(res,pager,totlePager);
			return readInfos;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @param result
	 * @return ��ȡ��ȡ����Ϣ
	 */
	public List<ReadInfo> getReadInfo(ResultSet result,int pager,int totlePager) {
		readInfos = new ArrayList<ReadInfo>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.READINFO_ID);
				int uId = result.getInt(SqlUtil.READINFO_USERID);
				int messageId = result.getInt(SqlUtil.READINFO_MESSID);
				Date readDate = result.getDate(SqlUtil.READINFO_READDATE);
				ReadInfo readInfo = new ReadInfo(id, uId, messageId, readDate);
				readInfo.setTotlePager(totlePager);
				readInfo.setPager(pager);
				readInfos.add(readInfo);
			}
			return readInfos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
