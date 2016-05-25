package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.ResourceFromDao;
import com.jucaipen.model.ResourceSources;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

public class ResourceFromImp implements ResourceFromDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ResourceSources> resourceSources;

	/**
	 * @return ��ѯ��Ѷ��Դ��ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_From "
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

	/*
	 * ��ѯ���е���Ѷ��Դ��Ϣ
	 */
	public List<ResourceSources> findAll(int pager) {
		int totlePager=findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP 15 * FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY id) AS RowNumber,* FROM JCP_From"
					+ " ) A " + "WHERE RowNumber > " + 15 * (pager - 1));
			resourceSources = getResourceSources(res,pager,totlePager);
			return resourceSources;
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

	/*
	 * ����id��ѯ��Ѷ��Դ��Ϣ
	 */
	public ResourceSources findResourceSources(int id) {
		ResourceSources rs = null;
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_From where Id=" + id);
			resourceSources = getResourceSources(res,-1,-1);
			if (resourceSources != null && resourceSources.size() > 0) {
				rs = resourceSources.get(0);
			}
			return rs;
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

	/**
	 * @param result
	 * @return ��ȡ��Ѷ��Դ��Ϣ
	 */
	public List<ResourceSources> getResourceSources(ResultSet result,int pager,int totlePager) {
		resourceSources = new ArrayList<ResourceSources>();
		try {
			while (result.next()) {
				int id = result.getInt(SqlUtil.READINFO_ID);
				String fromName = result.getString(SqlUtil.RESOURCEFOM_NAME);
				String fromHtml = result.getString(SqlUtil.RESOURCEFROM_HTML);
				int sortId = result.getInt(SqlUtil.RESOURCEFROM_SORTID);
				ResourceSources reSources = new ResourceSources(id, fromName,
						fromHtml, sortId);
				reSources.setTotlePager(totlePager);
				reSources.setPager(pager);
				resourceSources.add(reSources);
			}
			return resourceSources;
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
