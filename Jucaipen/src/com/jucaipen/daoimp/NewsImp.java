package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.NewsDao;
import com.jucaipen.model.News;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

/**
 * @author YLF
 * 
 *         ���Ų���ʵ����
 * 
 */
public class NewsImp implements NewsDao {
	private Statement sta;
	private ResultSet res;
	private Connection dbConn;

	private List<News> news = new ArrayList<News>();
	private int isSuccess;

	/**
	 * @return ��ѯ������ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_News "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	/*
	 * ��ѯ��������
	 */
	public List<News> findAll(int pager) {
		int totlePager = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			if (dbConn != null) {
				sta = dbConn.createStatement();
				res = sta
						.executeQuery("SELECT TOP 15 * FROM "
								+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc,Id desc) AS RowNumber,* FROM JCP_News) A "
								+ "WHERE RowNumber > " + 15 * (pager - 1));
				news = getNews(res, pager, totlePager);
				return news;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ͨ�������ѯ����
	 */
	public List<News> findNewsBybigId(int classId, int pager) {
		int totlePager = findTotlePager("Where FK_ClassId=" + classId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 Id,Title,ImageUrl,ZhaiYao,PageUrl FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc ,id desc) AS RowNumber,* FROM JCP_News"
							+ " WHERE FK_ClassId="
							+ classId
							+ ") A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			news = getNewsList(res, pager, totlePager);
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	/*
	 * ��ѯ��ҳ��ʾ����
	 */
	public List<News> findNewsByIndex(int isIndex, int pager) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select  * from JCP_News where IsIndex="
					+ isIndex + " order by InsertDate desc");
			news = getNews(res, pager, -1);
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	/*
	 * ��ѯ��ѡ������
	 */
	public List<News> findNewsByBest(int isBest, int pager) {
		int totlePager = findTotlePager("where IsJingXuan=" + isBest);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc,id desc) AS RowNumber,* FROM JCP_News"
							+ " where IsJingXuan=" + isBest + ") A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			news = getNews(res, pager, totlePager);
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ��ѯ�Ƿ��ö�������
	 */
	public List<News> findNewsByTop(int isTop, int pager) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select  * from JCP_News where IsTop="
					+ isTop + " order by InsertDate desc");
			news = getNews(res, pager, -1);
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * ��ѯ������ϸ��Ϣ
	 */
	public News findNews(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_News where Id=" + id);
			news = getNews(res, -1, -1);
			if(news!=null&&news.size()>0){
				return news.get(0);
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	/*
	 * ��ҳ����---����
	 */
	public List<News> findNewsIndex(int classId, int isIndex) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_News where FK_ClassId=" + classId
					+ " and IsIndex=" + isIndex + " order by InsertDate desc");
			news = getNews(res, -1, -1);
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int upDateHits(int hits, int id) {
		// �޸ĵ����
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCP_News SET HitCount=" + hits
					+ " WHERE Id=" + id);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int upDateComments(int Commens,int id) {
		// �޸�������
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCP_News SET CommonCount=" + Commens
					+ " WHERE Id=" + id);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*
	 * ��ҳ��ʾ����
	 *    ȫ����������ͼƬ��
	 */
	public List<News> findIndexShow(int classId,int top) {
		news.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select top "+top+" Id,Title,ImageUrl,ZhaiYao from JCP_News where  FK_ClassId="
							+ classId + "  order by InsertDate desc,Id desc");
			while (res.next()) {
				String title = res.getString(SqlUtil.NEWS_TITLE);
				int id = res.getInt(SqlUtil.NEWS_ID);
				String images = res.getString(SqlUtil.NEW_IMAGE);
				String descript = res.getString(SqlUtil.NEWS_DES);
				News n = new News(id);
				n.setTitle(title);
				n.setDescript(descript);
				n.setImageUrl(images);
				news.add(n);
			}
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * @param res
	 * @param pager
	 * @return ��ȡ�����б�
	 */
	public List<News> getNewsList(ResultSet res, int pager, int totlePager) {
		news.clear();
		try {
			while (res.next()) {
				String title = res.getString(SqlUtil.NEWS_TITLE);
				String descript = res.getString(SqlUtil.NEWS_DES);
				int id = res.getInt(SqlUtil.NEWS_ID);
				String imageUrl = res.getString(SqlUtil.NEW_IMAGE);
				int from=res.getInt(SqlUtil.NEWS_COMEFROM);
				String insertDate=res.getString(SqlUtil.NEWS_INSERT);
				int comms=res.getInt(SqlUtil.NEWS_COMMS);
				News n = new News(id);
				n.setPager(pager);
				n.setTotlePager(totlePager);
				n.setTitle(title);
				n.setDescript(descript);
				n.setId(id);
				n.setComeFrom(from);
				n.setPublishDate(insertDate);
				n.setComments(comms);
				n.setImageUrl(imageUrl);
				news.add(n);
			}
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @param res
	 * @param pager
	 * @return ��ȡ������Ϣ
	 */
	public List<News> getNews(ResultSet res, int pager, int totlePager) {
		news.clear();
		try {
			while (res.next()) {
				int classId = res.getInt("FK_ClassId");
				String title = res.getString(SqlUtil.NEWS_TITLE);
				String descript = res.getString(SqlUtil.NEWS_DES);
				int id = res.getInt(SqlUtil.NEWS_ID);
				int comeFrom=res.getInt(SqlUtil.NEWS_COMEFROM);
				String keyWord = res.getString(SqlUtil.NEWS_KEYWORD);
				String reporter = res.getString(SqlUtil.NEWS_REPOTER);
				String bodys = res.getString(SqlUtil.NEWS_BODYS);
				String imageUrl = res.getString(SqlUtil.NEW_IMAGE);
				String date = res.getString(SqlUtil.NEWS_INSERT);
				String htmlPath = res.getString(SqlUtil.NEWS_HTMLPATH);
				News n = new News(id);
				n.setImageUrl(imageUrl);
				n.setBodys(bodys);
				n.setTitle(title);
				n.setComeFrom(comeFrom);
				n.setDescript(descript);
				n.setReporter(reporter);
				n.setKeyWord(keyWord);
				n.setBigId(classId);
				n.setHtmlPath(htmlPath);
				n.setPager(pager);
				n.setTotlePager(totlePager);
				n.setPublishDate(date);
				news.add(n);
			}
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<News> findRelatedNewsById(int id) {
		// ����ָ������id ��ѯ�������
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT Title FROM JCP_News WHERE Id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<News> findLastNewsByNewsNum(int count) {
		// ��ȡ���µ�count������
		news.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP "
							+ count
							+ " Id,Title,ImageUrl,InsertDate,CommonCount,FK_FromId FROM JCP_News ORDER BY InsertDate DESC,Id DESC");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.NEWS_TITLE);
				String image=res.getString(SqlUtil.NEW_IMAGE);
				String insertDate=res.getString(SqlUtil.NEWS_INSERT);
				int comments=res.getInt(SqlUtil.NEWS_COMMS);
				int from=res.getInt(SqlUtil.NEWS_COMEFROM);
				News n = new News(id);
				n.setTitle(title);
				n.setComeFrom(from);
				n.setImageUrl(image);
				n.setPublishDate(insertDate);
				n.setComments(comments);
				news.add(n);
			}
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
