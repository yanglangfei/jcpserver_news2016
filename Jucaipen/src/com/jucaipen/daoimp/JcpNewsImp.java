package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.jucaipen.dao.JcpNewsDao;
import com.jucaipen.model.JcpNews;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

/**
 * @author YLF
 * 
 *         ���Ų���ʵ����
 * 
 */
public class JcpNewsImp implements JcpNewsDao {
	private Statement sta;
	private ResultSet res;
	private Connection dbConn;

	private List<JcpNews> news = new ArrayList<JcpNews>();
	private int isSuccess;

	/**
	 * @return ��ѯ������ҳ��
	 */
	public int findTotlePager(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCPNews "
							+ condition);
			res.next();
			int totlePager = res.getInt("totlePager");
			return totlePager;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}

	/*
	 * ��ѯ��������
	 */
	public List<JcpNews> findAll(int pager) {
		int totlePager = findTotlePager("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			if (dbConn != null) {
				sta = dbConn.createStatement();
				//SELECT TOP 15 * FROM (select row_number() over(order by InsertDate DESC ) AS row_num , * from JCPNews ) a WHERE row_num>15
				res = sta
						.executeQuery("SELECT TOP 15 * FROM "
								+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate DESC) AS RowNumber,* FROM JCPNews) A "
								+ "WHERE RowNumber > " + 15 * (pager - 1));
				news = getNews(res, pager, totlePager);
				return news;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * ͨ�������ѯ����
	 */
	public List<JcpNews> findNewsBybigId(int bigId, int samllId, int pager) {
		int totlePager = findTotlePager(" Where BigId=" + bigId
				+ "  AND SmallId=" + samllId);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 Id,Title,ImageUrl,ZhaiYao,HtmlPath,ComeFrom,XnHits,Zan,InsertDate,Commens,Hits FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc ,id desc) AS RowNumber,* FROM JCPNews"
							+ " WHERE BigId="
							+ bigId
							+ " AND SmallId="
							+ samllId
							+ ") A "
							+ "WHERE RowNumber > "
							+ 15
							* (pager - 1));
			news = getNewsList(res, pager, totlePager);
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * ��ѯ��ҳ��ʾ����
	 */
	public List<JcpNews> findNewsByIndex(int isIndex, int pager) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select  * from JCPNews where IsIndex="
					+ isIndex + " order by InsertDate desc");
			news = getNews(res, pager, -1);
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * ��ѯ��ѡ������
	 */
	public List<JcpNews> findNewsByBest(int isBest, int pager) {
		int totlePager = findTotlePager("where IsBest=" + isBest);
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc,id desc) AS RowNumber,* FROM JCPNews"
							+ " where IsBest=" + isBest + ") A "
							+ "WHERE RowNumber > " + 15 * (pager - 1));
			news = getNews(res, pager, totlePager);
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * ��ѯ�Ƿ��ö�������
	 */
	public List<JcpNews> findNewsByTop(int isTop, int pager) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select  * from JCPNews where IsTop="
					+ isTop + " order by InsertDate desc");
			news = getNews(res, pager, -1);
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * ��ѯ������ϸ��Ϣ
	 */
	public JcpNews findNews(int id) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPNews where Id=" + id);
			news = getNews(res, -1, -1);
			if (news != null && news.size() > 0) {
				return news.get(0);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	/*
	 * ��ҳ����---����
	 */
	public List<JcpNews> findNewsIndex(int bigId, int smallId, int isIndex) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCPNews where BigId=" + bigId
					+ " and SmallId=" + smallId + " and IsIndex=" + isIndex
					+ " order by InsertDate desc");
			news = getNews(res, -1, -1);
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public int upDateHits(int xnHits, int hits, int id) {
		// �޸ĵ����
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCPNews SET Hits=" + hits
					+ ",XnHits=" + xnHits + " WHERE Id=" + id);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int upDateComments(int Commens, int id) {
		// �޸�������
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCPNews SET Commens="
					+ Commens + " WHERE Id=" + id);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/*
	 * ��ҳ��ʾ���� ȫ����������ͼƬ��
	 */
	public List<JcpNews> findIndexShow(int bigId, int smallId, int top) {
		news.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select top " + top
					+ " Id,Title,ImageUrl,ZhaiYao from JCPNews where  BigId="
					+ bigId + " AND SmallId=" + smallId
					+ "  order by InsertDate desc,Id desc");
			while (res.next()) {
				String title = res.getString(SqlUtil.NEWS_TITLE);
				int id = res.getInt(SqlUtil.NEWS_ID);
				String images = res.getString(SqlUtil.NEW_IMAGE);
				String descript = res.getString(SqlUtil.NEWS_DES);
				JcpNews n = new JcpNews();
				n.setId(id);
				n.setTitle(title);
				n.setDesc(descript);
				n.setImageUrl(images);
				news.add(n);
			}
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @param res
	 * @param pager
	 * @return ��ȡ�����б�
	 */
	public List<JcpNews> getNewsList(ResultSet res, int pager, int totlePager) {
		news.clear();
		try {
			while (res.next()) {
				String title = res.getString(SqlUtil.NEWS_TITLE);
				String summary = res.getString(SqlUtil.NEWS_DES);
				int id = res.getInt(SqlUtil.NEWS_ID);
				String imageUrl = res.getString(SqlUtil.NEW_IMAGE);
				int from = res.getInt("ComeFrom");
				String insertDate = res.getString(SqlUtil.NEWS_INSERT);
				int comms = res.getInt("Commens");
				int goods = res.getInt("Zan");
				int xnHits = res.getInt("XnHits");
				int hits=res.getInt("Hits");
				JcpNews n = new JcpNews();
				n.setId(id);
				n.setPage(pager);
				n.setTotlePage(totlePager);
				n.setTitle(title);
				n.setDesc(summary);
				n.setId(id);
				n.setXnHits(xnHits);
				n.setZan(goods);
				n.setComeFrom(from);
				n.setHits(hits);
				n.setInsertDate(insertDate);
				n.setComms(comms);
				n.setImageUrl(imageUrl);
				news.add(n);
			}
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	/**
	 * @param res
	 * @param pager
	 * @return ��ȡ������Ϣ
	 */
	public List<JcpNews> getNews(ResultSet res, int pager, int totlePager) {
		news.clear();
		try {
			while (res.next()) {
				int bigId = res.getInt("BigId");
				int smallId = res.getInt("SmallId");
				String title = res.getString(SqlUtil.NEWS_TITLE);
				String descript = res.getString(SqlUtil.NEWS_DES);
				int id = res.getInt(SqlUtil.NEWS_ID);
				int comeFrom = res.getInt("ComeFrom");
				String keyWord = res.getString(SqlUtil.NEWS_KEYWORD);
				String bodys = res.getString(SqlUtil.NEWS_BODYS);
				String imageUrl = res.getString(SqlUtil.NEW_IMAGE);
				String date = res.getString(SqlUtil.NEWS_INSERT);
				int xnHits = res.getInt("XnHits");
				int goods = res.getInt("Zan");
				int hits=res.getInt("Hits");
				JcpNews n = new JcpNews();
				n.setImageUrl(imageUrl);
				n.setBodys(bodys);
				n.setId(id);
				n.setHits(hits);
				n.setSmallId(smallId);
				n.setBigId(bigId);
				n.setTitle(title);
				n.setZan(goods);
				n.setXnHits(xnHits);
				n.setComeFrom(comeFrom);
				n.setDesc(descript);
				n.setKeyWord(keyWord);
				n.setBodys(bodys);
				n.setPage(pager);
				n.setTotlePage(totlePager);
				n.setInsertDate(date);
				news.add(n);
			}
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public List<JcpNews> findRelatedNewsById(int id) {
		// ����ָ������id ��ѯ�������
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT Title FROM JCPNews WHERE Id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<JcpNews> findLastNewsByNewsNum(int count) {
		// ��ȡ���µ�count������
		news.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP "
							+ count
							+ " Id,Title,ImageUrl,InsertDate,XnHits,ComeFrom FROM JCPNews WHERE IsImage=1 ORDER BY InsertDate DESC,Id DESC");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.NEWS_TITLE);
				String image = res.getString(SqlUtil.NEW_IMAGE);
				String insertDate = res.getString(SqlUtil.NEWS_INSERT);
				int xnHits = res.getInt("XnHits");
				int from = res.getInt("ComeFrom");
				JcpNews n = new JcpNews();
				n.setId(id);
				n.setTitle(title);
				n.setComeFrom(from);
				n.setImageUrl(image);
				n.setInsertDate(insertDate);
				n.setXnHits(xnHits);
				news.add(n);
			}
			return news;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public JcpNews findHitsAndGoods(int id) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Zan,Hits,XnHits FROM JCPNews WHERE Id="
							+ id);
			while (res.next()) {
				int goods = res.getInt(1);
				int hits = res.getInt(2);
				int xnHits = res.getInt(3);
				JcpNews news = new JcpNews();
				news.setZan(goods);
				news.setHits(hits);
				news.setXnHits(xnHits);
				return news;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addGoods(int id, int goods) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			return sta.executeUpdate("UPDATE JCPNews SET Zan=" + goods
					+ " WHERE Id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
