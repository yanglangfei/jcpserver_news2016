package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.TacticsDao;
import com.jucaipen.model.Tactics;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 *
 *  ս��
 */
public class TacticsImp implements TacticsDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Tactics> tacticsArray=new ArrayList<Tactics>();
	/**
	 * @return ��ѯս����ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Tactics "
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
	public List<Tactics> findAll(int page) {
		//��ȡ����ս����Ϣ
		tacticsArray.clear();
		int totlePage=getTotlePage("");
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP 15 * FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Tactics"
					+ ") A " + "WHERE RowNumber > " + 15
					* (page - 1));
			while (res.next()) {
				int id=res.getInt("Id");
				String title=res.getString("Title");  //Title
				String desc=res.getString("description");  //description
				int orderNum=res.getInt("PeoPleNum");  //PeoPleNum
				String imageUrl=res.getString("Imagesurl");  //Imagesurl
				int teacherId=res.getInt("TeacherId");  //TeacherId
				String insertDate=res.getString("InsertDate");  //InsertDate
				int halfYearsMoney=res.getInt("halfYearsMoney"); //halfYearsMoney
				int threeMonthmoney=res.getInt("threeMonthmoney");  //threeMonthmoney
				int yearMoney=res.getInt("YearsMoney");  //YearsMoney
				int mothMoney=res.getInt("MonthMoney");  //MonthMoney
				int isDel=res.getInt("IsDel");
				Tactics tactics=new Tactics();
				tactics.setId(id);
				tactics.setTitle(title);
				tactics.setDesc(desc);
				tactics.setPage(page);
				tactics.setTotlePage(totlePage);
				tactics.setOrderNum(orderNum);
				tactics.setImageUrl(imageUrl);
				tactics.setTeacherId(teacherId);
				tactics.setInsertDate(insertDate);
				tactics.setHalfYearsMoney(halfYearsMoney);
				tactics.setThreeMonthmoney(threeMonthmoney);
				tactics.setYearsMoney(yearMoney);
				tactics.setMothMoney(mothMoney);
				tactics.setIsDel(isDel);
				tacticsArray.add(tactics);
			}
			return tacticsArray;
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
	public Tactics findTacticsById(int id) {
		//����id��ȡս����Ϣ
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Tactics WHERE Id="+id);
			while (res.next()) {
				String title=res.getString("Title");  //Title
				String desc=res.getString("description");  //description
				int orderNum=res.getInt("PeoPleNum");  //PeoPleNum
				String imageUrl=res.getString("Imagesurl");  //Imagesurl
				int teacherId=res.getInt("TeacherId");  //TeacherId
				String insertDate=res.getString("InsertDate");  //InsertDate
				int halfYearsMoney=res.getInt("halfYearsMoney"); //halfYearsMoney
				int threeMonthmoney=res.getInt("threeMonthmoney");  //threeMonthmoney
				int yearMoney=res.getInt("YearsMoney");  //YearsMoney
				int mothMoney=res.getInt("MonthMoney");  //MonthMoney
				int isDel=res.getInt("IsDel");
				Tactics tactics=new Tactics();
				tactics.setId(id);
				tactics.setTitle(title);
				tactics.setDesc(desc);
				tactics.setOrderNum(orderNum);
				tactics.setImageUrl(imageUrl);
				tactics.setTeacherId(teacherId);
				tactics.setInsertDate(insertDate);
				tactics.setHalfYearsMoney(halfYearsMoney);
				tactics.setThreeMonthmoney(threeMonthmoney);
				tactics.setYearsMoney(yearMoney);
				tactics.setMothMoney(mothMoney);
				tactics.setIsDel(isDel);
				return tactics;
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
	public List<Tactics> findTacticsByTeacherId(int tId, int page) {
		//���ݽ�ʦ��ȡս����Ϣ
		tacticsArray.clear();
		int totlePage=getTotlePage("WHERE TeacherId="+tId);
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP 15 * FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Tactics"
					+ " WHERE TeacherId="+tId+") A " + "WHERE RowNumber > " + 15
					* (page - 1));
			while (res.next()) {
				int id=res.getInt("Id");
				String title=res.getString("Title");  //Title
				String desc=res.getString("description");  //description
				int orderNum=res.getInt("PeoPleNum");  //PeoPleNum
				String imageUrl=res.getString("Imagesurl");  //Imagesurl
				int teacherId=res.getInt("TeacherId");  //TeacherId
				String insertDate=res.getString("InsertDate");  //InsertDate
				int halfYearsMoney=res.getInt("halfYearsMoney"); //halfYearsMoney
				int threeMonthmoney=res.getInt("threeMonthmoney");  //threeMonthmoney
				int yearMoney=res.getInt("YearsMoney");  //YearsMoney
				int mothMoney=res.getInt("MonthMoney");  //MonthMoney
				int isDel=res.getInt("IsDel");
				Tactics tactics=new Tactics();
				tactics.setId(id);
				tactics.setTitle(title);
				tactics.setDesc(desc);
				tactics.setPage(page);
				tactics.setTotlePage(totlePage);
				tactics.setOrderNum(orderNum);
				tactics.setImageUrl(imageUrl);
				tactics.setTeacherId(teacherId);
				tactics.setInsertDate(insertDate);
				tactics.setHalfYearsMoney(halfYearsMoney);
				tactics.setThreeMonthmoney(threeMonthmoney);
				tactics.setYearsMoney(yearMoney);
				tactics.setMothMoney(mothMoney);
				tactics.setIsDel(isDel);
				tacticsArray.add(tactics);
			}
			return tacticsArray;
			
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
	public List<Tactics> findTacticsByTeacherId(int tId) {
		// ���ݽ�ʦ��ȡս����Ϣ
		tacticsArray.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Tactics WHERE TeacherId="+tId);
			while (res.next()) {
				int id=res.getInt("Id");
				String title=res.getString("Title");  //Title
				String desc=res.getString("description");  //description
				int orderNum=res.getInt("PeoPleNum");  //PeoPleNum
				String imageUrl=res.getString("Imagesurl");  //Imagesurl
				int teacherId=res.getInt("TeacherId");  //TeacherId
				String insertDate=res.getString("InsertDate");  //InsertDate
				int halfYearsMoney=res.getInt("halfYearsMoney"); //halfYearsMoney
				int threeMonthmoney=res.getInt("threeMonthmoney");  //threeMonthmoney
				int yearMoney=res.getInt("YearsMoney");  //YearsMoney
				int mothMoney=res.getInt("MonthMoney");  //MonthMoney
				int isDel=res.getInt("IsDel");
				Tactics tactics=new Tactics();
				tactics.setId(id);
				tactics.setTitle(title);
				tactics.setDesc(desc);
				tactics.setOrderNum(orderNum);
				tactics.setImageUrl(imageUrl);
				tactics.setTeacherId(teacherId);
				tactics.setInsertDate(insertDate);
				tactics.setHalfYearsMoney(halfYearsMoney);
				tactics.setThreeMonthmoney(threeMonthmoney);
				tactics.setYearsMoney(yearMoney);
				tactics.setMothMoney(mothMoney);
				tactics.setIsDel(isDel);
				tacticsArray.add(tactics);
			}
			return tacticsArray;
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
