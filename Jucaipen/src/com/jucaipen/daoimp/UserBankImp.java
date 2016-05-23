package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.UserBankDao;
import com.jucaipen.model.UserBank;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 *
 * �û����п���Ϣ
 */
public class UserBankImp implements UserBankDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<UserBank> banks=new ArrayList<UserBank>();

	@Override
	public List<UserBank> findAllBankInfo(int userId) {
		//�����û�id��ȡ���п���Ϣ
		banks.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_User_Bank WHERE UserId="+userId);
			while (res.next()) {
				int id=res.getInt(1);
				String name=res.getString(2);  //BankName
				String bankCode=res.getString(3);  //BankCode
				String trueName=res.getString(4);  //BankUserTrueName
				String bankIdCard=res.getString(5); //BankIdCard
				String bankMobile=res.getString(6);  //BankMobile
				String insertDate=res.getString(7); //InsertDate
				String remark=res.getString(8); //Remark
				int isDel=res.getInt(9);  //IsDel
				int isDefault=res.getInt(10);  //IsDefault
				UserBank bank=new UserBank();
				bank.setId(id);
				bank.setBankName(name);
				bank.setBankCode(bankCode);
				bank.setBankUserTrueName(trueName);
				bank.setBankIdCard(bankIdCard);
				bank.setBankMobile(bankMobile);
				bank.setInsertDate(insertDate);
				bank.setRemark(remark);
				bank.setIsDefault(isDefault);
				banks.add(bank);
			}
			return banks;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int addUserBank(UserBank bank) {
		// ������п���Ϣ
		
		return 0;
	}

	@Override
	public int removeUserBank(int id) {
		//������п���Ϣ
		
		return 0;
	}

}
