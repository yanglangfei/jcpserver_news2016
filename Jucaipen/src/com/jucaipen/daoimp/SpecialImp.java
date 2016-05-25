package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.SpecialDao;
import com.jucaipen.model.Special;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 *
 * ר��
 */
public class SpecialImp implements SpecialDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Special> specials=new ArrayList<Special>();
	
	/**
	 * @return ��ѯר����ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Special "
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
	public Special findSpecialById(int id) {
		// ����id��ȡר����Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Special WHERE Id="+id);
			while (res.next()) {
				String name=res.getString(2);  //SpecialName
				String insertDate=res.getString(3);  //InsertDate
				String description=res.getString(4);  //Description
				int sortId=res.getInt(5);  //SortId
				int isFree=res.getInt(7);  //IsFree
				double amountMoney=res.getDouble(8);  //AmountMoney
				double payMoney=res.getDouble(9);  //ShiFuMoney
				Special special=new Special();
				special.setName(name);
				special.setInsertDate(insertDate);
				special.setDescription(description);
				special.setSortId(sortId);
				special.setIsFree(isFree);
				special.setAllMoney(amountMoney);
				special.setPayMoney(payMoney);
				return special;
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
	public List<Special> findAll(int page) {
		// ��ȡ���е�ר����Ϣ
		specials.clear();
		int totlePage = getTotlePage("");
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Special"
							+") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id=res.getInt("Id");
				String name=res.getString("SpecialName");  //SpecialName
				String insertDate=res.getString("InsertDate");  //InsertDate
				String description=res.getString("Description");  //Description
				int sortId=res.getInt("SortId");  //SortId
				int isFree=res.getInt("IsFree");  //IsFree
				double amountMoney=res.getDouble("AmountMoney");  //AmountMoney
				double payMoney=res.getDouble("ShiFuMoney");  //ShiFuMoney
				Special special=new Special();
				special.setName(name);
				special.setId(id);
				special.setTotlePage(totlePage);
				special.setPage(page);
				special.setInsertDate(insertDate);
				special.setDescription(description);
				special.setSortId(sortId);
				special.setIsFree(isFree);
				special.setAllMoney(amountMoney);
				special.setPayMoney(payMoney);
				specials.add(special);
			}
			return specials;
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

}
