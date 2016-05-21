package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.ContributeDao;
import com.jucaipen.model.Contribute;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 *
 *  ���װ�
 */
public class ContributeImp implements ContributeDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Contribute> contributes=new ArrayList<Contribute>();

	@Override
	public Contribute findContributeById(int id) {
		//����id��ȡ���װ���Ϣ
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Contribute WHERE Id="+id);
			while (res.next()) {
				int userId=res.getInt(2); //FK_UserId
				int teacherId=res.getInt(3); //FK_TearchId
				int fk_id=res.getInt(4); //FK_Id
				String insertDate=res.getString(5);  //InsertDate
				int allJucaiBills=res.getInt(6); //AllJucaibi
				int comeType=res.getInt(7); //ComType
				Contribute contribute=new Contribute();
				contribute.setUserId(userId);
				contribute.setTeacherId(teacherId);
				contribute.setFk_id(fk_id);
				contribute.setInsertDate(insertDate);
				contribute.setAllJucaiBills(allJucaiBills);
				contribute.setComType(comeType);
				return contribute;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Contribute> findContributeByUid(int uId) {
		//��ȡ�û������й�����Ϣ
		contributes.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Contribute WHERE FK_UserId="+uId);
			while (res.next()) {
				int id=res.getInt(1); 
				int teacherId=res.getInt(3); //FK_TearchId
				int fk_id=res.getInt(4); //FK_Id
				String insertDate=res.getString(5);  //InsertDate
				int allJucaiBills=res.getInt(6); //AllJucaibi
				int comeType=res.getInt(7); //ComType
				Contribute contribute=new Contribute();
				contribute.setId(id);
				contribute.setUserId(uId);
				contribute.setTeacherId(teacherId);
				contribute.setFk_id(fk_id);
				contribute.setInsertDate(insertDate);
				contribute.setAllJucaiBills(allJucaiBills);
				contribute.setComType(comeType);
				contributes.add(contribute);
			}
			return contributes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Contribute> findContributeByUidAndTid(int uId, int tId) {
		// ��ȡ�û���ĳ����ʦ�Ĺ���
		contributes.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Contribute WHERE FK_UserId="+uId+" AND FK_TearchId="+tId);
			while (res.next()) {
				int id=res.getInt(1); 
				int fk_id=res.getInt(4); //FK_Id
				String insertDate=res.getString(5);  //InsertDate
				int allJucaiBills=res.getInt(6); //AllJucaibi
				int comeType=res.getInt(7); //ComType
				Contribute contribute=new Contribute();
				contribute.setId(id);
				contribute.setUserId(uId);
				contribute.setTeacherId(tId);
				contribute.setFk_id(fk_id);
				contribute.setInsertDate(insertDate);
				contribute.setAllJucaiBills(allJucaiBills);
				contribute.setComType(comeType);
				contributes.add(contribute);
			}
			return contributes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Contribute> findContributeByUidAndFkId(int uId, int fkId) {
		// ��ȡ�û��Թ���id �Ĺ���
		contributes.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Contribute WHERE FK_UserId="+uId+" AND FK_Id="+fkId);
			while (res.next()) {
				int id=res.getInt(1); 
				int tId=res.getInt(3);
				String insertDate=res.getString(5);  //InsertDate
				int allJucaiBills=res.getInt(6); //AllJucaibi
				int comeType=res.getInt(7); //ComType
				Contribute contribute=new Contribute();
				contribute.setId(id);
				contribute.setUserId(uId);
				contribute.setTeacherId(tId);
				contribute.setFk_id(fkId);
				contribute.setInsertDate(insertDate);
				contribute.setAllJucaiBills(allJucaiBills);
				contribute.setComType(comeType);
				contributes.add(contribute);
			}
			return contributes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Contribute> findAllContribute() {
		// ��ȡ���й���
		contributes.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Contribute");
			while (res.next()) {
				int id=res.getInt(1);
				int uId=res.getInt(2);
				int tId=res.getInt(3);
				int fkId=res.getInt(4);
				String insertDate=res.getString(5);  //InsertDate
				int allJucaiBills=res.getInt(6); //AllJucaibi
				int comeType=res.getInt(7); //ComType
				Contribute contribute=new Contribute();
				contribute.setId(id);
				contribute.setUserId(uId);
				contribute.setTeacherId(tId);
				contribute.setFk_id(fkId);
				contribute.setInsertDate(insertDate);
				contribute.setAllJucaiBills(allJucaiBills);
				contribute.setComType(comeType);
				contributes.add(contribute);
			}
			return contributes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
