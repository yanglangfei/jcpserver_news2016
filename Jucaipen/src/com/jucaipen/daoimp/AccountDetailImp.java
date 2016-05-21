package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.AccountDetailDao;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.utils.JdbcUtil;

public class AccountDetailImp implements AccountDetailDao{
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<AccountDetail> accountDetails=new ArrayList<AccountDetail>();

	@Override
	public List<AccountDetail> findAccountDetailByuId(int uId) {
		//根据用户id获取账户详细信息
		accountDetails.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Account_Detail WHERE UserId="+uId);
			while (res.next()) {
				int id=res.getInt("Id");
				String orderCode=res.getString("OrderCode");
				double detailMoney=res.getDouble("DetailMoney");
				int detailType=res.getInt("DetailType");
				int state=res.getInt("State");
				String remark=res.getString("Remark");
				String insertDate=res.getString("InsertDate");
				int isDel=res.getInt("IsDel");
				AccountDetail detail=new AccountDetail(id, orderCode, detailMoney, detailType, state, remark, insertDate, isDel, uId);
				accountDetails.add(detail);
			}
			return accountDetails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccountDetail> findAccountDetailByUIdAndState(int uId, int state) {
		// 根据用户id和状态
		accountDetails.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Account_Detail WHERE UserId="+uId+" AND State="+state);
			while (res.next()) {
				int id=res.getInt("Id");
				String orderCode=res.getString("OrderCode");
				double detailMoney=res.getDouble("DetailMoney");
				int detailType=res.getInt("DetailType");
				String remark=res.getString("Remark");
				String insertDate=res.getString("InsertDate");
				int isDel=res.getInt("IsDel");
				AccountDetail detail=new AccountDetail(id, orderCode, detailMoney, detailType, state, remark, insertDate, isDel, uId);
				accountDetails.add(detail);
			}
			return accountDetails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccountDetail> findAccountDetailByUidAndType(int uId, int type) {
		//根据用户id和分类获取
		accountDetails.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Account_Detail WHERE UserId="+uId+" AND DetailType="+type);
			while (res.next()) {
				int id=res.getInt("Id");
				String orderCode=res.getString("OrderCode");
				double detailMoney=res.getDouble("DetailMoney");
				int detailType=res.getInt("DetailType");
				String remark=res.getString("Remark");
				String insertDate=res.getString("InsertDate");
				int isDel=res.getInt("IsDel");
				int state=res.getInt("State");
				AccountDetail detail=new AccountDetail(id, orderCode, detailMoney, detailType, state, remark, insertDate, isDel, uId);
				accountDetails.add(detail);
			}
			return accountDetails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
