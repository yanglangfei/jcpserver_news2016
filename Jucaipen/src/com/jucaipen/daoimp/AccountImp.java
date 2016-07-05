package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.AccountDao;
import com.jucaipen.model.Account;
import com.jucaipen.utils.JdbcUtil;

public class AccountImp implements AccountDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Account> accounts = new ArrayList<Account>();

	@Override
	public List<Account> findAllAccount() {
		// ��ȡ�����˻���Ϣ
		accounts.clear();
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_Account");
			while (res.next()) {
				int id = res.getInt(1);
				int uId = res.getInt(2);
				int integeral = res.getInt(3);
				int jucaiBills = res.getInt(4);
				Account account = new Account();
				account.setId(id);
				account.setUserId(uId);
				account.setIntegeral(integeral);
				account.setJucaiBills(jucaiBills);
				accounts.add(account);
			}
			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Account findAccountById(int id) {
		// ����id��ȡ�˻���Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_Account WHERE Id=" + id);
			while (res.next()) {
				int uId = res.getInt(2);
				int integeral = res.getInt(3);
				int jucaiBills = res.getInt(4);
				Account account = new Account();
				account.setId(id);
				account.setUserId(uId);
				account.setIntegeral(integeral);
				account.setJucaiBills(jucaiBills);
				return account;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Account findAccountByUserId(int uId) {
		// �����û�id��ȡ�˻���Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT * FROM JCP_Account WHERE UserId="
					+ uId);
			while (res.next()) {
				int id = res.getInt(1);
				int integeral = res.getInt(3);
				int jucaiBills = res.getInt(4);
				Account account = new Account();
				account.setId(id);
				account.setUserId(uId);
				account.setIntegeral(integeral);
				account.setJucaiBills(jucaiBills);
				return account;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public int updateBills(int uId, int newBills) {
		// �޸��˻��۲Ʊ�����
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta.executeUpdate("UPDATE JCP_Account SET JucaiBi="
					+ newBills + " WHERE UserId=" + uId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateIntegeral(int uId, int integeral) {
		// �޸��û�������Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta.executeUpdate("UPDATE JCP_Account SET Integral="
					+ integeral + " WHERE UserId=" + uId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int addAccount(Account account) {
		// ����˻���Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta
					.executeUpdate("INSERT INTO JCP_Account(UserId,Integral,JucaiBi) VALUES("
							+ account.getUserId()
							+ ","
							+ account.getIntegeral()
							+ ","
							+ account.getJucaiBills() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
