package com.jucaipen.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author YLF
 *   数据库工具类
 * 
 */
public class JdbcUtil {
	/*
	 * SqlServer 测试数据库 new 192.168.1.127 old 192.168.1.233 JcpStudyPlatformData
	 * 198 128 JCPData
	 */
	private static final String SQLSERVER_DRIVER_TEST = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String SQLSERVER_URL_TEST = "jdbc:sqlserver://192.168.1.198; DatabaseName=JcpStudyPlatformData";
	private static final String SQLSERVER_UNAME_TEST = "sa";
	private static final String SQLSERVER_UPWD_TEST = "111111";

	private static boolean isTest = false;

	/**
	 * 新数据库 正式
	 */
	private static final String SQLSERVER_DRIVER_N = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String SQLSERVER_URL_N = "jdbc:sqlserver://121.41.46.228; DatabaseName=JcpStudyPlatformData";
	private static final String SQLSERVER_UNAME_N = "jcpstudy";
	private static final String SQLSERVER_UPWD_N = "jcp@)!^168";

	/**
	 * SqlServer 视频数据库
	 */
	private static final String SQLSERVER_DRIVER_VIDEO = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String SQLSERVER_URL_VIDEO = "jdbc:sqlserver://121.41.46.228; DatabaseName=ChatRoom";
	private static final String SQLSERVER_UNAME_VIDEO = "chat";
	private static final String SQLSERVER_UPWD_VIDEO = "cHat2013";

	/*
	 * SqlServer 正式数据库
	 */
	private static final String SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String SQLSERVER_URL = "jdbc:sqlserver://121.41.46.228; DatabaseName=JCPData";
	private static final String SQLSERVER_UNAME = "jcp";
	private static final String SQLSERVER_UPWD = "jCp#)2016";

	/*
	 * 本地MySql 数据库
	 */
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_URL = "jdbc:mysql://121.40.227.121:3306/jucaipen";
	private static final String MYSQL_UNAME = "jucaipen";
	private static final String MYSQL_UPWD = "jucaipen168";
	private static final String MYSQL_ENCODING = "useUnicode=true&characterEncoding=UTF8";
	private static Connection dbConn;
	private static boolean isNormal;

	/*
	 * 本地MySql 数据库 test
	 */
	private static final String MYSQL_DRIVER_TEST = "com.mysql.jdbc.Driver";
	private static final String MYSQL_URL_TEST = "jdbc:mysql://localhost:3306/test_main";
	private static final String MYSQL_UNAME_TEST = "root";
	private static final String MYSQL_UPWD_TEST = "111111";
	@SuppressWarnings("unused")
	private static final String MYSQL_ENCODING_TEST = "useUnicode=true&characterEncoding=UTF8";
	private static Connection dbConn_test;
	private static boolean isNormal_test;

	/**
	 * Derby 数据库配置信息
	 */
	private static final String DERBY_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String DERBY_URL = "jdbc:derby://121.40.227.121:1521/APP;create=true";
	private static final String DERBY_UNAME = "jucaipen168";
	private static final String DERBY_PWD = "jucaipen168";

	/**
	 * @return 连接sqlServer 正式数据库
	 */
	public static Connection connSqlServer() {
		try {

			if (isTest) {
				Class.forName(SQLSERVER_DRIVER_TEST);
				dbConn = DriverManager.getConnection(SQLSERVER_URL_TEST,
						SQLSERVER_UNAME_TEST, SQLSERVER_UPWD_TEST);
			} else {
				Class.forName(SQLSERVER_DRIVER_N);
				dbConn = DriverManager.getConnection(SQLSERVER_URL_N,
						SQLSERVER_UNAME_N, SQLSERVER_UPWD_N);
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
	 * @return 连接sqlServer 测试数据库
	 */
	public static Connection connTestSqlServer() {
		try {
			Class.forName(SQLSERVER_DRIVER_TEST);
			dbConn = DriverManager.getConnection(SQLSERVER_URL_TEST,
					SQLSERVER_UNAME_TEST, SQLSERVER_UPWD_TEST);
			return dbConn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @return 连接sqlServer Video数据库
	 */
	public static Connection connVideoSqlServer() {
		try {
			Class.forName(SQLSERVER_DRIVER_VIDEO);
			dbConn = DriverManager.getConnection(SQLSERVER_URL_VIDEO,
					SQLSERVER_UNAME_VIDEO, SQLSERVER_UPWD_VIDEO);
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
			Class.forName(DERBY_DRIVER);
			dbConn = DriverManager.getConnection(DERBY_URL, DERBY_UNAME,
					DERBY_PWD);
			return dbConn;
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * @return 连接mySql 数据库
	 */
	public static Connection connMySql() {
		try {
			try {
				Class.forName(MYSQL_DRIVER);
				dbConn = DriverManager.getConnection(MYSQL_URL, MYSQL_UNAME,
						MYSQL_UPWD);
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
	 * @return 连接mySql_TEST 数据库
	 */
	public static Connection connMySqlTest() {
		try {
			try {
				Class.forName(MYSQL_DRIVER_TEST);
				dbConn = DriverManager.getConnection(MYSQL_URL_TEST,
						MYSQL_UNAME_TEST, MYSQL_UPWD_TEST);
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
	 *             关闭数据库
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
