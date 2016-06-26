package com.jucaipen.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 *
 *   ���ݿ�һ���Բ���
 */
public class DBtest {
	private static Connection dbConn;
	private static Statement sta;
	
	public static void main(String[] args) {
		dbConn=JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta=dbConn.createStatement();
			 sta.executeUpdate("INSERT INTO test1(id,name) VALUES(3,'����')");
			sta.executeUpdate("INSERT INTO test2(id,name) VALUES (6,'����')");
			dbConn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				dbConn.setAutoCommit(true);
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
