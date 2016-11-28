package com.jucaipen.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author YLF
 *   ���ݿ⹤����
 * 
 */
public class JdbcUtil {

	private static boolean isTest = false;
	private static Connection dbConn;
	private static boolean isNormal;

	private static Connection dbConn_test;
	private static boolean isNormal_test;

	/**
	 * @return ����sqlServer ��ʽ���ݿ�
	 */
	public static Connection connSqlServer() {
		try {

			if (isTest) {
				Class.forName(Constant.SQLSERVER_DRIVER_TEST);
				dbConn = DriverManager.getConnection(Constant.SQLSERVER_URL_TEST,
						Constant.SQLSERVER_UNAME_TEST, Constant.SQLSERVER_UPWD_TEST);
			} else {
				Class.forName(Constant.SQLSERVER_DRIVER_N);
				dbConn = DriverManager.getConnection(Constant.SQLSERVER_URL_N,
						Constant.SQLSERVER_UNAME_N,Constant.SQLSERVER_UPWD_N);
			}

			return dbConn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @return ����sqlServer �������ݿ�
	 */
	public static Connection connTestSqlServer() {
		try {
			Class.forName(Constant.SQLSERVER_DRIVER_TEST);
			dbConn = DriverManager.getConnection(Constant.SQLSERVER_URL_TEST,
					Constant.SQLSERVER_UNAME_TEST, Constant.SQLSERVER_UPWD_TEST);
			return dbConn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @return ����sqlServer Video���ݿ�
	 */
	public static Connection connVideoSqlServer() {
		try {
			Class.forName(Constant.SQLSERVER_DRIVER_VIDEO);
			dbConn = DriverManager.getConnection(Constant.SQLSERVER_URL_VIDEO,
					Constant.SQLSERVER_UNAME_VIDEO, Constant.SQLSERVER_UPWD_VIDEO);
			return dbConn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static Connection connDerby() {
		try {
			Class.forName(Constant.DERBY_DRIVER);
			dbConn = DriverManager.getConnection(Constant.DERBY_URL, Constant.DERBY_UNAME,
					Constant.DERBY_PWD);
			return dbConn;
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * @return ����mySql ���ݿ�
	 */
	public static Connection connMySql() {
		try {
			try {
				Class.forName(Constant.MYSQL_DRIVER);
				dbConn = DriverManager.getConnection(Constant.MYSQL_URL, Constant.MYSQL_UNAME,
						Constant.MYSQL_UPWD);
				return dbConn;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	

	/**
	 * @return ����mySql_TEST ���ݿ�
	 */
	public static Connection connMySqlTest() {
		try {
			try {
				Class.forName(Constant.MYSQL_DRIVER_TEST);
				dbConn = DriverManager.getConnection(Constant.MYSQL_URL_TEST,
						Constant.MYSQL_UNAME_TEST, Constant.MYSQL_UPWD_TEST);
				System.out.println("success...");
				return dbConn;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("e1...");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("e2...");
		}
		return null;

	}

	public static Connection isConnectNormalSql() {
		isNormal = true;
		if (isNormal) {
			return connSqlServer();
		} else {
			return connTestSqlServer();
		}
	}

	/**
	 * @param s
	 * @param conn
	 * @param r
	 * @throws SQLException
	 *             �ر����ݿ�
	 */
	public static void closeConn(Statement s, Connection conn, ResultSet r)
			throws SQLException {
		if (s != null) {
			s.close();
		}
		if (r != null) {
			r.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

}
