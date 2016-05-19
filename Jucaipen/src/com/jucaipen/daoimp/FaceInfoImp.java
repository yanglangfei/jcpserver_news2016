package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.FaceInfoDao;
import com.jucaipen.model.ExpressionInfo;
import com.jucaipen.utils.JdbcUtil;

public class FaceInfoImp implements FaceInfoDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ExpressionInfo> eInfos = new ArrayList<ExpressionInfo>();

	public List<ExpressionInfo> findAllFaceInfo() {
		// ��ȡ���еı�����Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_Face");
			eInfos = getExpressionInfo(res);
			return eInfos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ExpressionInfo> findFaceInfoByTypeId(int typeId) {
		// ���ݷ���id��ȡ��Ӧ������Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_Face WHERE FK_FaceClassId="
					+ typeId);
			eInfos = getExpressionInfo(res);
			return eInfos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ExpressionInfo findFaceInfoById(int id) {
		//����id��ȡ����������Ϣ
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Face WHERE Id="+id);
			eInfos=getExpressionInfo(res);
			if(eInfos.size()>0){
				return eInfos.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<ExpressionInfo> getExpressionInfo(ResultSet result) {
		// ��ȡ������Ϣ
		eInfos.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				int typeId = result.getInt("FK_FaceClassId");
				String title = result.getString("FaceName");
				String faceurl = result.getString("FaceUrl");
				int pxId = result.getInt("SortId");
				ExpressionInfo info = new ExpressionInfo();
				info.setId(id);
				info.setName(title);
				info.setClassId(typeId);
				info.setFaceurl(faceurl);
				info.setSortId(pxId);
				eInfos.add(info);
			}
			return eInfos;
		} catch (Exception e) {
		}
		return null;
	}

}
