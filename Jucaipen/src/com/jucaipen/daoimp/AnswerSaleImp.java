package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.AnswerSaleDao;
import com.jucaipen.model.AnswerSale;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         �ش�������Ϣ
 * 
 * 
 */
public class AnswerSaleImp implements AnswerSaleDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<AnswerSale> sales = new ArrayList<AnswerSale>();

	/**
	 * @return ��ѯ�ش�������Ϣ��ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_AnswerSale "
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
	public AnswerSale findSaleById(int id) {
		// ����id��ȡ�ش�������Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_AnswerSale WHERE Id="
					+ id);
			while (res.next()) {
				int uId=res.getInt(2);
				int tId=res.getInt(3);  //FK_TearchId
				String orderCode=res.getString(4); //OrderCode
				int askId=res.getInt(5);  //FK_AskId
				String insertDate=res.getString(6); //InsertDate
				AnswerSale as=new AnswerSale();
				as.setId(id);
				as.setUserId(uId);
				as.setTeacherId(tId);
				as.setOrderCode(orderCode);
				as.setAskId(askId);
				as.setInsetDate(insertDate);
				sales.add(as);
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
	public List<AnswerSale> findSaleByUid(int userId, int page) {
		// �����û�id��ȡ������Ϣ
		sales.clear();
		int totlePage = getTotlePage(" WHERE FK_UserId=" + userId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_AnswerSale WHERE FK_UserId="
							+ userId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id=res.getInt(1);  
				int tId=res.getInt(3);  //FK_TearchId
				String orderCode=res.getString(4); //OrderCode
				int askId=res.getInt(5);  //FK_AskId
				String insertDate=res.getString(6); //InsertDate
				AnswerSale as=new AnswerSale();
				as.setPage(page);
				as.setTotlePage(totlePage);
				as.setId(id);
				as.setUserId(userId);
				as.setTeacherId(tId);
				as.setOrderCode(orderCode);
				as.setAskId(askId);
				as.setInsetDate(insertDate);
				sales.add(as);
			}
			return sales;
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
	public AnswerSale findSaleByOrderCode(String orderCode) {
		// ���ݶ�����Ż�ȡ������Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_AnswerSale WHERE OrderCode="
					+ orderCode);
			while (res.next()) {
				int id=res.getInt(1);  
				int uId=res.getInt(2);  //FK_UserId
				int tId=res.getInt(3);  //FK_TearchId
				int askId=res.getInt(5);  //FK_AskId
				String insertDate=res.getString(6); //InsertDate
				AnswerSale as=new AnswerSale();
				as.setId(id);
				as.setUserId(uId);
				as.setTeacherId(tId);
				as.setAskId(askId);
				as.setInsetDate(insertDate);
				return as;
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
	public List<AnswerSale> findSaleByTeacherAndUid(int teacherId, int userId) {
		//��ȡ�û�����ʦ�ظ�����Ϣ
		return null;
	}

	@Override
	public AnswerSale findSaleByUserIdAndAskId(int uId, int askId) {
		// ��ȡ�û�����ظ���Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res=sta.executeQuery("SELECT Id FROM   JCP_AnswerSale   WHERE FK_AskId="+askId+" AND FK_UserId="+uId);
		    while (res.next()) {
				int id=res.getInt(1);
				AnswerSale sale=new AnswerSale();
				sale.setId(id);
				return sale;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
