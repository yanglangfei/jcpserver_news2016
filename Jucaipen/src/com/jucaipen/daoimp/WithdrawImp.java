package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.WithdrawDao;
import com.jucaipen.model.Withdraw;
import com.jucaipen.utils.JdbcUtil;

public class WithdrawImp implements WithdrawDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Withdraw> withdraws = new ArrayList<Withdraw>();

	/**
	 * @return ��ѯ���ּ�¼��ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_TiXian "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public Withdraw findWithDrawById(int id) {
		// ����id��ȡ������Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_TiXian WHERE Id="+id);
			while (res.next()) {
				String orderCode=res.getString(2);  //OrderCode
				int userId=res.getInt(3);  //UserId
				String bankCode=res.getString(4);  //BankCode
				int bankType=res.getInt(5);  //BankType
				String trueName=res.getString(6);  //BankUserTrueName
				String bankName=res.getString(7);  //BankName
				double outMoney=res.getDouble(8);  //OutMoney
				String insertDate=res.getString(9);  //InsertDate
				int type=res.getInt(10);  //Type
				String shenheDate=res.getString(11);  //ShenHeDate
				int isPay=res.getInt(12);  //IsPay
				String remark=res.getString(14);  //Remark
				Withdraw withdraw=new Withdraw();
				withdraw.setOrderCode(orderCode);
				withdraw.setUserId(userId);
				withdraw.setBankCode(bankCode);
				withdraw.setBankType(bankType);
				withdraw.setBankUserTrueName(trueName);
				withdraw.setBankName(bankName);
				withdraw.setOutMoney(outMoney);
				withdraw.setInsertDate(insertDate);
				withdraw.setType(type);
				withdraw.setCheckDate(shenheDate);
				withdraw.setIsPay(isPay);
				withdraw.setRemark(remark);
				return withdraw;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Withdraw> findWithDrawByUserId(int userId, int page) {
		//�����û�id��ȡ���е�������Ϣ
		withdraws.clear();
		int totlePage = getTotlePage(" WHERE UserId=" + userId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_TiXian WHERE UserId="
							+ userId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id=res.getInt("Id");
				String orderCode=res.getString("OrderCode");  //OrderCode
				String bankCode=res.getString("BankCode");  //BankCode
				int bankType=res.getInt("BankType");  //BankType
				String trueName=res.getString("BankUserTrueName");  //BankUserTrueName
				String bankName=res.getString("BankName");  //BankName
				double outMoney=res.getDouble("OutMoney");  //OutMoney
				String insertDate=res.getString("InsertDate");  //InsertDate
				int type=res.getInt("Type");  //Type
				String shenheDate=res.getString("ShenHeDate");  //ShenHeDate
				int isPay=res.getInt("IsPay");  //IsPay
				String remark=res.getString("Remark");  //Remark
				Withdraw withdraw=new Withdraw();
				withdraw.setOrderCode(orderCode);
				withdraw.setUserId(userId);
				withdraw.setBankCode(bankCode);
				withdraw.setId(id);
				withdraw.setTotlePage(totlePage);
				withdraw.setPage(page);
				withdraw.setBankType(bankType);
				withdraw.setBankUserTrueName(trueName);
				withdraw.setBankName(bankName);
				withdraw.setOutMoney(outMoney);
				withdraw.setInsertDate(insertDate);
				withdraw.setType(type);
				withdraw.setCheckDate(shenheDate);
				withdraw.setIsPay(isPay);
				withdraw.setRemark(remark);
				withdraws.add(withdraw);
			}
			return withdraws;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addWithDraw(Withdraw withdraw) {
		//������ּ�¼
		
		return 0;
	}

}
