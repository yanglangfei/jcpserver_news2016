package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.jucaipen.model.Marker;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 *
 *   处理数据库一致性
 */
public class TransactionImp {
	private static Connection dbConn;
	private static Statement sta;
	
	
	/**
	 * @param marker  打赏     -----确保用户的聚财币 与打赏数据一致
	 */
	public static boolean addMarker(Marker marker,int uId,int  newBills){
		dbConn=JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta=dbConn.createStatement();
			//添加打赏信息
			sta.executeUpdate("INSERT INTO JCP_MarkerWord_Dateil(MarkerType,FK_UserId,FK_LogId,MaekerCount,InsertDate,IP) VALUES("
					+ marker.getType()
					+ ","
					+ marker.getUserId()
					+ ","
					+ marker.getIdeaId()
					+ ","
					+ marker.getMarkerCount()
					+ ",'"
					+ marker.getInsertDate()
					+ "','"
					+ marker.getIp()
					+ "')");
			//更改用户聚财币数量
			sta.executeUpdate("UPDATE JCP_Account SET JucaiBi="+newBills+" WHERE UserId="+uId);
			dbConn.commit();
			dbConn.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
				dbConn.setAutoCommit(true);
				JdbcUtil.closeConn(sta, dbConn, null);
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
			
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
