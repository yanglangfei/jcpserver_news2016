package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.MyPresentDao;
import com.jucaipen.model.MyPresent;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         ��ӵ�е���Ʒ
 */
public class MyPresentImp implements MyPresentDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<MyPresent> presents = new ArrayList<MyPresent>();

	/**
	 * @return ��ѯӵ����Ʒ��ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_MyPresent "
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
	public List<MyPresent> findPresentByUserId(int uId, int page) {
		// ��ȡ�û���ǰӵ�е���Ʒ
		presents.clear();
		int totlePage = getTotlePage("WHERE FK_UserId=" + uId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY Id desc) AS RowNumber,* FROM JCP_MyPresent WHERE FK_UserId="
							+ uId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt("Id");
				int presentNum = res.getInt("PresentNum"); // PresentNum
				int presentId = res.getInt("FK_LiPinId"); // FK_LiPinId
				MyPresent present = new MyPresent();
				present.setTotlePage(totlePage);
				present.setPage(page);
				present.setId(id);
				present.setPresentNum(presentNum);
				present.setPresentId(presentId);
				presents.add(present);
			}
			return presents;
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
	public MyPresent findPresentById(int id) {
		// ����id��ȡ��Ʒ��Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_MyPresent WHERE Id=" + id);
			while (res.next()) {
				int userId = res.getInt("FK_UserId"); // FK_UserId
				int presentNum = res.getInt("PresentNum"); // PresentNum
				int presentId = res.getInt("FK_LiPinId"); // FK_LiPinId
				MyPresent present = new MyPresent();
				present.setUserId(userId);
				present.setPresentNum(presentNum);
				present.setPresentId(presentId);
				return present;
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
	public int addPresent(MyPresent present) {
		// �����Ʒ��Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta
					.executeUpdate("INSERT INTO JCP_MyPresent (FK_UserId,PresentNum,FK_LiPinId) VALUES("
							+ present.getUserId()
							+ ","
							+ present.getPresentNum()
							+ ","
							+ present.getPresentId() + ")");
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
	public int sendPresent(MyPresent present) {
		// �޸���Ʒ��Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta.executeUpdate("UPDATE JCP_MyPresent SET PresentNum="
					+ present.getPresentNum() + " WHERE FK_UserId="
					+ present.getUserId() + " AND FK_LiPinId="
					+ present.getPresentId());
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
	public MyPresent findParentByUid(int uId, int pId) {
		// ��ȡ�û�ӵ��ĳ����Ʒ����
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_MyPresent WHERE FK_UserId="+uId+" AND FK_LiPinId="+pId);
			res.next();
			int presentNum=res.getInt("PresentNum");
			int id=res.getInt("Id");
			MyPresent parent=new MyPresent();
			parent.setId(id);
			parent.setPresentNum(presentNum);
			return parent;
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
	public int sendPresent(int id, int num) {
		// �޸���Ʒ��Ϣ
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			return sta.executeUpdate("UPDATE JCP_MyPresent SET PresentNum="+num+" WHERE Id="+id);
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

}
