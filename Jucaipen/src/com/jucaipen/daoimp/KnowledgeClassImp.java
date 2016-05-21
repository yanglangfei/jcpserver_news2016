package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.jucaipen.dao.KnowledgeClassDao;
import com.jucaipen.model.KnowledgeClass;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         ֪ʶ������Ϣ
 */
public class KnowledgeClassImp implements KnowledgeClassDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<KnowledgeClass> classes = new ArrayList<KnowledgeClass>();

	@Override
	public KnowledgeClass findKnowledgeById(int id) {
		// ����id��ȡ֪ʶ������Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_BasicKnowledgeClass WHERE Id="
							+ id);
            while (res.next()) {
				String name=res.getString(2);  //ClassName
				String keyWord=res.getString(3); //KeyWord
				String desc=res.getString(4); //Description
				String linkUrl=res.getString(7); //LinkUrl
				KnowledgeClass knClass=new KnowledgeClass();
				knClass.setId(id);
				knClass.setKeyWord(keyWord);
				knClass.setClassName(name);
				knClass.setDesc(desc);
				knClass.setLinkUrl(linkUrl);
				return knClass;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<KnowledgeClass> findAllKnowledgeClass() {
		//��ȡ����֪ʶ������Ϣ
		classes.clear();
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_BasicKnowledgeClass");
            while (res.next()) {
            	int id=res.getInt(1);
				String name=res.getString(2);  //ClassName
				String keyWord=res.getString(3); //KeyWord
				String desc=res.getString(4); //Description
				String linkUrl=res.getString(7); //LinkUrl
				KnowledgeClass knClass=new KnowledgeClass();
				knClass.setId(id);
				knClass.setKeyWord(keyWord);
				knClass.setClassName(name);
				knClass.setDesc(desc);
				knClass.setLinkUrl(linkUrl);
				classes.add(knClass);
			}
            return classes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
