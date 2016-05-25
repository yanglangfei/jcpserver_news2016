package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.IdeaSaleDao;
import com.jucaipen.model.IdeaSale;
import com.jucaipen.utils.JdbcUtil;

public class IdeaSaleImp implements IdeaSaleDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<IdeaSale> slList=new ArrayList<IdeaSale>();
	

	public List<IdeaSale> findAllTxtLiveSale() {
		// 获取所有的销售信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_TeacherlogSale ORDER BY InsertDate DESC");
			slList=getIdeaSales(res);
			return slList;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<IdeaSale> findTxtLiveSaleByUid(int userId) {
		//根据用户id获取直播销售信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_TeacherlogSale WHERE FK_UserId="+userId+" ORDER BY InsertDate DESC");
			slList=getIdeaSales(res);
			return slList;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<IdeaSale> findTxtLiveSaleByTeacherId(int teacherId) {
		//根据讲师id获取购买信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_TeacherlogSale WHERE FK_TearchId="+teacherId+" ORDER BY InsertDate DESC");
			slList=getIdeaSales(res);
			return slList;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<IdeaSale> findTxtLiveSaleByLiveId(int liveId) {
		//根据直播id获取购买信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_TeacherlogSale WHERE FK_LogId="+liveId+" ORDER BY InsertDate DESC");
			slList=getIdeaSales(res);
			return slList;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public IdeaSale findTxtLiveSaleByUiDAndLiveId(int uId, int liveId) {
		// 根据直播id和用户id获取购买信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_TeacherlogSale WHERE FK_LogId="+liveId+" AND FK_UserId="+uId);
		    slList=getIdeaSales(res);
			if(slList.size()>0){
				return slList.get(0);
			}
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public IdeaSale findTxtLiveSaleById(int id) {
		//根据id获取购买信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_TeacherlogSale WHERE Id="+id+"");
		    slList=getIdeaSales(res);
			if(slList.size()>0){
				return slList.get(0);
			}
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public IdeaSale findTxtLiveSaleByOrderCode(String orderCode) {
		//根据订单号获取购买信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_TeacherlogSale WHERE OrderCode="+orderCode+" ");
		    slList=getIdeaSales(res);
			if(slList.size()>0){
				return slList.get(0);
			}
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<IdeaSale> findTxtLiveSaleByUserLastCount(int uId, int count) {
		// 获取用户最近几条信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP "+count +" FROM JCP_TeacherlogSale WHERE FK_UserId="+uId+" ORDER BY InsertDate DESC");
		    slList=getIdeaSales(res);
			return slList;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<IdeaSale> getIdeaSales(ResultSet result){
		slList.clear();
		try {
			while (result.next()) {
				int id=result.getInt("Id");
				int userId=result.getInt("FK_UserId");
				int teacherId=result.getInt("FK_TearchId");
				String orderCode=result.getString("OrderCode");
				int liveId=result.getInt("FK_LogId");
				String insertDate=result.getString("InsertDate");
				IdeaSale sale=new IdeaSale(id, userId, teacherId, orderCode, liveId, insertDate);
				slList.add(sale);
			}
			return slList;
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
