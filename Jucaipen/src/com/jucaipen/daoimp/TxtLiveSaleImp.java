package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.TxtLiveSaleDao;
import com.jucaipen.model.TxtLiveSale;
import com.jucaipen.utils.JdbcUtil;

public class TxtLiveSaleImp implements TxtLiveSaleDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<TxtLiveSale> slList=new ArrayList<TxtLiveSale>();
	

	public List<TxtLiveSale> findAllTxtLiveSale() {
		// ��ȡ���е�������Ϣ
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale ORDER BY InsertDate DESC");
			slList=getTexLiveSales(res);
			return slList;
		} catch (Exception e) {
		}
		return null;
	}

	public List<TxtLiveSale> findTxtLiveSaleByUid(int userId) {
		//�����û�id��ȡֱ��������Ϣ
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE UserId="+userId+" ORDER BY InsertDate DESC");
			slList=getTexLiveSales(res);
			return slList;
		} catch (Exception e) {
		}
		return null;
	}

	public List<TxtLiveSale> findTxtLiveSaleByTeacherId(int teacherId) {
		//���ݽ�ʦid��ȡ������Ϣ
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE TearchId="+teacherId+" ORDER BY InsertDate DESC");
			slList=getTexLiveSales(res);
			return slList;
		} catch (Exception e) {
		}
		return null;
	}

	public List<TxtLiveSale> findTxtLiveSaleByLiveId(int liveId) {
		//����ֱ��id��ȡ������Ϣ
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE LiveId="+liveId+" ORDER BY InsertDate DESC");
			slList=getTexLiveSales(res);
			return slList;
		} catch (Exception e) {
		}
		return null;
	}

	public TxtLiveSale findTxtLiveSaleByUiDAndLiveId(int uId, int liveId) {
		// ����ֱ��id���û�id��ȡ������Ϣ
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE LiveId="+liveId+" AND UserId="+uId);
		    slList=getTexLiveSales(res);
			if(slList.size()>0){
				return slList.get(0);
			}
		} catch (Exception e) {
		}
		return null;
	}

	public TxtLiveSale findTxtLiveSaleById(int id) {
		//����id��ȡ������Ϣ
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE Id="+id+"");
		    slList=getTexLiveSales(res);
			if(slList.size()>0){
				return slList.get(0);
			}
		} catch (Exception e) {
		}
		return null;
	}

	public TxtLiveSale findTxtLiveSaleByOrderCode(String orderCode) {
		//���ݶ����Ż�ȡ������Ϣ
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCPTearch_TxtLive_Sale WHERE OrderCode="+orderCode+" ");
		    slList=getTexLiveSales(res);
			if(slList.size()>0){
				return slList.get(0);
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<TxtLiveSale> findTxtLiveSaleByUserLastCount(int uId, int count) {
		// ��ȡ�û����������Ϣ
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP "+count +" FROM JCPTearch_TxtLive_Sale WHERE UserId="+uId+" ORDER BY InsertDate DESC");
		    slList=getTexLiveSales(res);
			return slList;
		} catch (Exception e) {
		}
		return null;
	}
	
	public List<TxtLiveSale> getTexLiveSales(ResultSet result){
		slList.clear();
		try {
			while (result.next()) {
				int id=result.getInt("Id");
				int userId=result.getInt("UserId");
				int teacherId=result.getInt("TearchId");
				String orderCode=result.getString("OrderCode");
				int liveId=result.getInt("LiveId");
				String insertDate=result.getString("InsertDate");
				TxtLiveSale sale=new TxtLiveSale(id, userId, teacherId, orderCode, liveId, insertDate);
				slList.add(sale);
			}
			return slList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
