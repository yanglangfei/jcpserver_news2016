package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.FaceTypeDao;
import com.jucaipen.model.ExpressionType;
import com.jucaipen.utils.JdbcUtil;

public class FaceTypeImp implements FaceTypeDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ExpressionType> eTypes = new ArrayList<ExpressionType>();

	public List<ExpressionType> findAllFace() {
		// ��ȡ���б������
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_FaceClass");
			eTypes = getExpressionType(res);
			return eTypes;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ExpressionType findFaceById(int id) {
		// ����id ��ȡ���������Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_FaceClass WHERE Id=" + id);
			eTypes = getExpressionType(res);
			if (eTypes.size() > 0) {
				return eTypes.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<ExpressionType> getExpressionType(ResultSet result) {
		// ��ȡ�����б�
		eTypes.clear();
		try {
			while (result.next()) {
				int id = result.getInt("Id");
				String typeName = result.getString("ClassName");
				int sortId = result.getInt("SortId");
				int isDel=result.getInt("IsDel");
				ExpressionType type = new ExpressionType();
				type.setClassName(typeName);
				type.setId(id);
				type.setSortId(sortId);
				type.setIsDel(isDel);
				eTypes.add(type);
			}
			return eTypes;
		} catch (Exception e) {
		}
		return null;
	}
}
