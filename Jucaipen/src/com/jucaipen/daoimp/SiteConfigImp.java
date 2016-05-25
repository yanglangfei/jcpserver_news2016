package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jucaipen.dao.SiteConfigDao;
import com.jucaipen.model.SiteConfig;
import com.jucaipen.utils.JdbcUtil;

public class SiteConfigImp implements SiteConfigDao {
	
	private SiteConfig config;
	private Connection dbConn;
	private Statement state;
	private ResultSet res;

	public SiteConfig findSiteConfig() {
		//获取配置信息
		try {
			dbConn=JdbcUtil.connSqlServer();
			state=dbConn.createStatement();
			res=state.executeQuery("SELECT * FROM JCP_Config");
			while (res.next()) {
				int askNum=res.getInt("AskNum");
				config=new SiteConfig();
				config.setAskNum(askNum);
			}
			return config;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(state, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
