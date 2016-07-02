package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.VideoDao;
import com.jucaipen.model.Video;
import com.jucaipen.utils.JdbcUtil;
import com.jucaipen.utils.SqlUtil;

public class VideoImp implements VideoDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<Video> videos = new ArrayList<Video>();

	/**
	 * @return ��ѯ��Ƶ��ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Video "
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

	public List<Video> findAll(int page) {
		// ��ȡ������Ƶ��Ϣ
		videos.clear();
		int totlePage = getTotlePage("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 Id,Title,ImagesUrl,Description,VideoPageUrl,FK_ClassId,FK_Pecial,VideoDate FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video"
							+ ") A " + "WHERE RowNumber > " + 15 * (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc = res.getString("Description");
				String pageUrl = res.getString("VideoPageUrl");
				int classId = res.getInt("FK_ClassId");
				int pecialId = res.getInt("FK_Pecial");
				String videoDate = res.getString("VideoDate");
				Video video = new Video(id, title);
				video.setTotlePage(totlePage);
				video.setPage(page);
				video.setDescript(desc);
				video.setClassId(classId);
				video.setVideoDate(videoDate);
				video.setPecialId(pecialId);
				video.setHtmlUrl(pageUrl);
				video.setImages(Images);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Video> findVideoByClassId(String classId, int page) {
		// ���ݷ����ȡ��Ƶ�б� FK_Pecial ����ר��
		int totlePage = getTotlePage("WHERE FK_ClassId IN (" + classId + ")");
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 FK_ClassId,Id,Title,ImagesUrl,Description,IsMySite,VideoPageUrl,FK_Pecial,VideoType,PlayCount FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_ClassId IN ("
							+ classId
							+ ")  ) A "
							+ "WHERE RowNumber > "
							+ 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc = res.getString("Description");
				int isMySiteVideo = res.getInt("IsMySite");
				String pageUrl = res.getString("VideoPageUrl");
				int cId = res.getInt("FK_ClassId");
				int pecialId = res.getInt("FK_Pecial");
				int hits=res.getInt("PlayCount");
				int videoType=res.getInt("VideoType");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setDescript(desc);
				video.setClassId(cId);
				video.setVideoType(videoType);
				video.setHitCount(hits);
				video.setPecialId(pecialId);
				video.setHtmlUrl(pageUrl);
				video.setTotlePage(totlePage);
				video.setPage(page);
				video.setIsMySiteVideo(isMySiteVideo);
				videos.add(video);
			}
			return videos;
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
	public List<Video> findVideoByClassId(int classId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT FK_ClassId,Id,Title,ImagesUrl,Description,IsMySite,VideoUrl,PlayCount,VideoDate,FK_Pecial,VideoType FROM JCP_Video WHERE FK_ClassId="
							+ classId);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc = res.getString("Description");
				int isMySiteVideo = res.getInt("IsMySite");
				String videoUrl = res.getString("VideoUrl");
				int cId = res.getInt("FK_ClassId");
				int playCount = res.getInt("PlayCount");
				String videoDate = res.getString("VideoDate");
				int specialId=res.getInt("FK_Pecial");
				int videoType=res.getInt("VideoType");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setDescript(desc);
				video.setClassId(cId);
				video.setVideoType(videoType);
				video.setPecialId(specialId);
				video.setHitCount(playCount);
				video.setVideoDate(videoDate);
				video.setVideoUrl(videoUrl);
				video.setIsMySiteVideo(isMySiteVideo);
				videos.add(video);
			}
			return videos;
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
	public List<Video> findVideoByTeacherId(int teacherId, int page) {
		int totlePage = getTotlePage("WHERE TearcherId=" + teacherId);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 Id,Title,ImagesUrl,Description,InsertDate,PlayCount,VideoType,FK_Pecial,VideoPageUrl,FK_ClassId FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE TearcherId="
							+ teacherId
							+ ") A "
							+ "WHERE RowNumber > "
							+ 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc = res.getString("Description");
				String insertDate = res.getString("InsertDate");
				int hits = res.getInt("PlayCount");
				int videoType = res.getInt("VideoType");
				int specialId=res.getInt("FK_Pecial");
				String pageUrl=res.getString("VideoPageUrl");
				int classId=res.getInt("FK_ClassId");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setHitCount(hits);
				video.setClassId(classId);
				video.setVideoType(videoType);
				video.setPecialId(specialId);
				video.setInsertDate(insertDate);
				video.setTotlePage(totlePage);
				video.setHtmlUrl(pageUrl);
				video.setDescript(desc);
				video.setVideoType(videoType);
				video.setPage(page);
				videos.add(video);
			}
			return videos;
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
	public List<Video> findVideoByType(int typeId, int page) {
		int totlePage = getTotlePage("WHERE FK_TypeId=" + typeId);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 Id,Title,ImagesUrl,Description FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_TypeId="
							+ typeId
							+ ") A "
							+ "WHERE RowNumber > "
							+ 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc = res.getString("Description");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setDescript(desc);
				video.setTotlePage(totlePage);
				video.setPage(page);
				videos.add(video);
			}
			return videos;
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
	public List<Video> findVideoByTeacherIdAndType(int teacherId, int type,
			int page) {
		int totlePage = getTotlePage("WHERE FK_TypeId=" + type
				+ " AND TearcherId=" + teacherId);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 Id,Title,ImagesUrl,Description,VideoUrl FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_TypeId="
							+ type
							+ " AND TearcherId="
							+ teacherId
							+ ") A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc = res.getString("Description");
				String videoUrl = res.getString("VideoUrl");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setDescript(desc);
				video.setTotlePage(totlePage);
				video.setVideoUrl(videoUrl);
				video.setPage(page);
				videos.add(video);
			}
			return videos;
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
	public List<Video> findVideoByTeacherIdAndClassId(int teacherId,
			String classId, int page) {
		int totlePage = getTotlePage("WHERE FK_ClassId  IN (" + classId
				+ ") AND TearcherId=" + teacherId);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 FK_ClassId,Id,Title,ImagesUrl,Description,VideoPageUrl,FK_Pecial,VideoType,PlayCount FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_ClassId IN ("
							+ classId
							+ ") AND TearcherId="
							+ teacherId
							+ ") A " + "WHERE RowNumber > " + 15 * (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc = res.getString("Description");
				String pageUrl = res.getString("VideoPageUrl");
				int cId = res.getInt("FK_ClassId");
				int specialId=res.getInt("FK_Pecial");
				int videoType=res.getInt("VideoType");
				int hits=res.getInt("PlayCount");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setDescript(desc);
				video.setHitCount(hits);
				video.setVideoType(videoType);
				video.setPecialId(specialId);
				video.setTotlePage(totlePage);
				video.setClassId(cId);
				video.setHtmlUrl(pageUrl);
				video.setPage(page);
				videos.add(video);
			}
			return videos;
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
	public List<Video> findVideoByTypeAndClassId(int type, String classId,
			int page) {
		int totlePage = getTotlePage("WHERE FK_ClassId IN (" + classId
				+ ") AND FK_TypeId=" + type);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 FK_ClassId,Id,Title,ImagesUrl,VideoPageUrl,FK_Pecial,VideoType,PlayCount FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_ClassId IN ("
							+ classId
							+ ") AND FK_TypeId="
							+ type
							+ ") A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String pageUrl = res.getString("VideoPageUrl");
				int cId = res.getInt("FK_ClassId");
				int specialId=res.getInt("FK_Pecial");
				int videoType=res.getInt("VideoType");
				int hits=res.getInt("PlayCount");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setTotlePage(totlePage);
				video.setHtmlUrl(pageUrl);
				video.setClassId(cId);
				video.setHitCount(hits);
				video.setVideoType(videoType);
				video.setPecialId(specialId);
				video.setPage(page);
				videos.add(video);
			}
			return videos;
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
	public List<Video> findVideoByTypeAndClassIdAndTeacherId(int type,
			String classId, int teacherId, int page) {
		int totlePage = getTotlePage("WHERE FK_ClassId IN (" + classId
				+ ") AND FK_TypeId=" + type + " AND TearcherId=" + teacherId);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 FK_ClassId,Id,Title,ImagesUrl,VideoPageUrl,PlayCount,FK_Pecial,VideoType FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_ClassId IN ("
							+ classId
							+ ") AND FK_TypeId="
							+ type
							+ " AND TearcherId="
							+ teacherId
							+ ") A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String pageUrl = res.getString("VideoPageUrl");
				int cId = res.getInt("FK_ClassId");
				int videoType=res.getInt("VideoType");
				int hits=res.getInt("PlayCount");
				int specialId=res.getInt("FK_Pecial");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setHtmlUrl(pageUrl);
				video.setHitCount(hits);
				video.setPecialId(specialId);
				video.setVideoType(videoType);
				video.setTotlePage(totlePage);
				video.setClassId(cId);
				video.setPage(page);
				videos.add(video);
			}
			return videos;
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

	public Video findVideoById(int id) {
		// ����id ��ȡ��Ƶ��ϸ��Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select Id,Title,KeyWords,PlayCount,InsertDate,Description,ImagesUrl from JCP_Video where Id="
							+ id);
			while (res.next()) {
				int vId = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String keyWord = res.getString(SqlUtil.VIDEO_KEYWORD);
				String insertDate = res.getString(SqlUtil.VIDEO_INSERTDATE);
				int hitCount = res.getInt(SqlUtil.VIDEO_HITCOUNT);
				String Description = res.getString(SqlUtil.VIDEO_DESC);
				String imageUrl=res.getString("ImagesUrl");
				Video video = new Video(vId, title);
				video.setKeyWords(keyWord);
				video.setImages(imageUrl);
				video.setInsertDate(insertDate);
				video.setHitCount(hitCount);
				video.setDescript(Description);
				return video;
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

	public Video findVideoRecouresById(int id) {
		// ����id ��ȡ��Ƶ��Դ��Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select Id,Title,VideoUrl from JCP_Video where Id="
							+ id);

			while (res.next()) {
				int Vid = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String videoUrl = res.getString(SqlUtil.VIDEO_URL);
				Video video = new Video(Vid, title);
				video.setVideoUrl(videoUrl);
				return video;
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

	public List<Video> findVideoByIsIndex(int isIndex) {
		// ��ȡ��ҳ��Ƶ
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_Video where IsIndex="
					+ isIndex + " order by InsertDate desc");
			while (res.next()) {
				int vId = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String images = res.getString(SqlUtil.VIDEO_IMAGES);
				Video video = new Video(vId, title);
				video.setImages(images);
				videos.add(video);
			}
			return videos;
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

	public List<Video> findVideoByIsReComm(int isRecomm) {
		videos.clear();
		// ��ȡ�Ƽ���Ƶ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_Video where IsTuijian="
					+ isRecomm);
			while (res.next()) {
				int vId = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String images = res.getString(SqlUtil.VIDEO_IMAGES);
				Video video = new Video(vId, title);
				video.setImages(images);
				videos.add(video);
			}
			return videos;
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

	public List<Video> findVideoByIsTop(int isTop) {
		// ��ѯ�ö�����
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_Video where IsTop="
					+ isTop);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setDescript(descript);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
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

	public List<Video> findVideoByIsMySite(int isMySite) {
		// ��ѯ��վ��Ƶ
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_Video where IsMySite="
					+ isMySite);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setDescript(descript);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public List<Video> findVideoByIndexId(int top, int classId) {
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select Top "
							+ top
							+ " Id,Title,ImagesUrl,VideoUrl,Description from JCP_Video where FK_ClassId="
							+ classId + " order by Id desc");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String videoUrl = res.getString(SqlUtil.VIDEO_URL);
				String desc = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setVideoUrl(videoUrl);
				video.setDescript(desc);
				videos.add(video);
			}
			return videos;
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

	public List<Video> findVideoByIsRecommId(int isRecomm, int classId) {
		// ��ѯ�Ƽ��µķ�����Ϣ
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_Video where IsTuijian="
					+ isRecomm + " FK_ClassId=" + classId);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setDescript(descript);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Video> findVideoByIsTopId(int isTop, int classId) {
		// ��ѯ�ö��ķ�����Ϣ
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_Video WHERE IsTop="
					+ isTop + " AND  FK_ClassId=" + classId);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setDescript(descript);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
		} finally {
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Video> findVideoByMySitId(int isMySit, int classId) {
		// ��ѯ�����µı�վ��Ƶ
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("select * from JCP_Video where IsMySite="
					+ isMySit + " FK_ClassId=" + classId);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setDescript(descript);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
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
	 * ���ݷ���id��ȡǰ������Ƶ��Ϣ
	 * 
	 * �°� Id,Title,Description,ImagesThumb,VideoUrl ��� HitCount CommCount ������
	 */
	public List<Video> findVideoByClassIdLast(int count, int classId) {
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select TOP "
							+ count
							+ " FK_Pecial,FK_ClassId,Id,Title,Description,ImagesUrl,PlayCount,VideoDate,VideoPageUrl,VideoType from JCP_Video"
							+ " WHERE FK_ClassId=" + classId
							+ " ORDER BY InsertDate DESC");

			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				String images = res.getString("ImagesUrl");
				int playCount = res.getInt("PlayCount");
				String videoDate = res.getString("VideoDate");
				String pageUrl = res.getString("VideoPageUrl");
				int cId = res.getInt("FK_ClassId");
				int specialId = res.getInt("FK_Pecial");
				int videoType=res.getInt("VideoType");
				Video video = new Video(id, title);
				video.setDescript(descript);
				video.setImages(images);
				video.setVideoType(videoType);
				video.setHtmlUrl(pageUrl);
				video.setHitCount(playCount);
				video.setVideoDate(videoDate);
				video.setPecialId(specialId);
				video.setClassId(cId);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
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
	public List<Video> findVideoByLast(int count) {
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select TOP "
							+ count
							+ " FK_Pecial,FK_ClassId,Id,Title,Description,ImagesUrl,PlayCount,VideoDate,VideoPageUrl from JCP_Video"
							+ " ORDER BY InsertDate DESC");

			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				String images = res.getString("ImagesUrl");
				int playCount = res.getInt("PlayCount");
				String videoDate = res.getString("VideoDate");
				String videoPageUrl = res.getString("VideoPageUrl");
				int cId = res.getInt("FK_ClassId");
				int specialId = res.getInt("FK_Pecial");
				Video video = new Video(id, title);
				video.setDescript(descript);
				video.setImages(images);
				video.setHtmlUrl(videoPageUrl);
				video.setHitCount(playCount);
				video.setVideoDate(videoDate);
				video.setPecialId(specialId);
				video.setClassId(cId);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
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
	public List<Video> findLastVideoByCommId(int commId, int count) {
		videos.clear();
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP "
							+ count
							+ " Id,ImagesUrl,Title,PlayCount,VideoDate,VideoType,VideoPageUrl,FK_Pecial,FK_ClassId FROM JCP_Video WHERE ColumnId="
							+ commId);
			while (res.next()) {
				int id=res.getInt(1);
				String imageUrl=res.getString(2);
				String title=res.getString(3);
				int playCount=res.getInt(4);
				String videoDate=res.getString(5);
				int videoType=res.getInt(6);
				String  pageUrl=res.getString(7);
				int specialId=res.getInt(8);
				int classId=res.getInt(9);
				Video video=new Video();
				video.setId(id);
				video.setTitle(title);
				video.setPecialId(specialId);
				video.setImages(imageUrl);
				video.setHtmlUrl(pageUrl);
				video.setClassId(classId);
				video.setHitCount(playCount);
				video.setVideoDate(videoDate);
				video.setVideoType(videoType);
				videos.add(video);
			}
			return videos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Video> findAllVideoByCommId(int commId, int page) {
		int totlePage = getTotlePage("WHERE ColumnId  =" + commId);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 Id,ImagesUrl,Title,PlayCount,VideoDate,VideoType,VideoPageUrl,FK_Pecial FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE ColumnId = "
							+ commId+") A "
							+ "WHERE RowNumber > " + 15 * (page - 1));
			while (res.next()) {
				int id=res.getInt("Id");
				String imageUrl=res.getString("ImagesUrl");
				String title=res.getString("Title");
				int playCount=res.getInt("PlayCount");
				String videoDate=res.getString("VideoDate");
				int videoType=res.getInt("VideoType");
				String  pageUrl=res.getString("VideoPageUrl");
				int specialId=res.getInt("FK_Pecial");
				Video video=new Video();
				video.setId(id);
				video.setTotlePage(totlePage);
				video.setPage(page);
				video.setTitle(title);
				video.setPecialId(specialId);
				video.setImages(imageUrl);
				video.setHtmlUrl(pageUrl);
				video.setHitCount(playCount);
				video.setVideoDate(videoDate);
				video.setVideoType(videoType);
				videos.add(video);
			}
			return videos;
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

}
