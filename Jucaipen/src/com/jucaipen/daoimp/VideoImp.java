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
		}finally{
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
		int totlePage=getTotlePage("");
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 Id,Title,ImagesUrl,Description,VideoUrl,FK_ClassId FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video"
							+ ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc=res.getString("Description");
				String videoUrl=res.getString("VideoUrl");
				int classId=res.getInt("FK_ClassId");
				Video video = new Video(id, title);
				video.setTotlePage(totlePage);
				video.setPage(page);
				video.setDescript(desc);
				video.setClassId(classId);
				video.setVideoUrl(videoUrl);
				video.setImages(Images);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Video> findVideoByClassId(String classId,int page) {
		// ���ݷ����ȡ��Ƶ�б�
		int totlePage=getTotlePage("WHERE FK_ClassId IN ("+classId+")");
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP 15 FK_ClassId,Id,Title,ImagesUrl,Description,IsMySite,VideoUrl FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_ClassId IN ("+classId
					+ ")  ) A " + "WHERE RowNumber > " + 15
					* (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc=res.getString("Description");
				int isMySiteVideo = res.getInt("IsMySite");
				String videoUrl=res.getString("VideoUrl");
				int cId=res.getInt("FK_ClassId");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setDescript(desc);
				video.setClassId(cId);
				video.setVideoUrl(videoUrl);
				video.setTotlePage(totlePage);
				video.setPage(page);
				video.setIsMySiteVideo(isMySiteVideo);
				videos.add(video);
			}
			return videos;
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
	
	
	
	@Override
	public List<Video> findVideoByClassId(int classId) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT FK_ClassId,Id,Title,ImagesUrl,Description,IsMySite,VideoUrl FROM JCP_Video WHERE FK_ClassId="+classId);
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc=res.getString("Description");
				int isMySiteVideo = res.getInt("IsMySite");
				String videoUrl=res.getString("VideoUrl");
				int cId=res.getInt("FK_ClassId");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setDescript(desc);
				video.setClassId(cId);
				video.setVideoUrl(videoUrl);
				video.setIsMySiteVideo(isMySiteVideo);
				videos.add(video);
			}
			return videos;
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
	

	@Override
	public List<Video> findVideoByTeacherId(int teacherId, int page) {
		int totlePage=getTotlePage("WHERE TearcherId="+teacherId);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP 15 Id,Title,ImagesUrl,Description FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE TearcherId="+teacherId
					+ ") A " + "WHERE RowNumber > " + 15
					* (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc=res.getString("Description");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setTotlePage(totlePage);
				video.setDescript(desc);
				video.setPage(page);
				videos.add(video);
			}
			return videos;
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

	@Override
	public List<Video> findVideoByType(int typeId, int page) {
		int totlePage=getTotlePage("WHERE FK_TypeId="+typeId);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP 15 Id,Title,ImagesUrl,Description FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_TypeId="+typeId
					+ ") A " + "WHERE RowNumber > " + 15
					* (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc=res.getString("Description");
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
		}finally{
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
		int totlePage=getTotlePage("WHERE FK_TypeId="+type+" AND TearcherId="+teacherId);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP 15 Id,Title,ImagesUrl,Description,VideoUrl FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_TypeId="+type
					+ " AND TearcherId="+teacherId+") A " + "WHERE RowNumber > " + 15
					* (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc=res.getString("Description");
				String videoUrl=res.getString("VideoUrl");
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
		}finally{
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
		int totlePage=getTotlePage("WHERE FK_ClassId  IN ("+classId+") AND TearcherId="+teacherId);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP 15 FK_ClassId,Id,Title,ImagesUrl,Description,VideoUrl FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_ClassId IN ("+classId
					+ ") AND TearcherId="+teacherId+") A " + "WHERE RowNumber > " + 15
					* (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String desc=res.getString("Description");
				String videoUrl=res.getString("VideoUrl");
				int cId=res.getInt("FK_ClassId");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setDescript(desc);
				video.setTotlePage(totlePage);
				video.setClassId(cId);
				video.setVideoUrl(videoUrl);
				video.setPage(page);
				videos.add(video);
			}
			return videos;
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

	@Override
	public List<Video> findVideoByTypeAndClassId(int type, String classId, int page) {
		int totlePage=getTotlePage("WHERE FK_ClassId IN ("+classId+") AND FK_TypeId="+type);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP 15 FK_ClassId,Id,Title,ImagesUrl,VideoUrl FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_ClassId IN ("+classId
					+ ") AND FK_TypeId="+type+") A " + "WHERE RowNumber > " + 15
					* (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String videoUrl=res.getString("VideoUrl");
				int cId=res.getInt("FK_ClassId");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setTotlePage(totlePage);
				video.setVideoUrl(videoUrl);
				video.setClassId(cId);
				video.setPage(page);
				videos.add(video);
			}
			return videos;
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

	@Override
	public List<Video> findVideoByTypeAndClassIdAndTeacherId(int type,
			String classId, int teacherId, int page) {
		int totlePage=getTotlePage("WHERE FK_ClassId IN ("+classId+") AND FK_TypeId="+type+" AND TearcherId="+teacherId);
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP 15 FK_ClassId,Id,Title,ImagesUrl,VideoUrl FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Video WHERE FK_ClassId IN ("+classId
					+ ") AND FK_TypeId="+type+" AND TearcherId="+teacherId+") A " + "WHERE RowNumber > " + 15
					* (page - 1));
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String videoUrl=res.getString("VideoUrl");
				int cId=res.getInt("FK_ClassId");
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setVideoUrl(videoUrl);
				video.setTotlePage(totlePage);
				video.setClassId(cId);
				video.setPage(page);
				videos.add(video);
			}
			return videos;
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
	

	public Video findVideoById(int id) {
		// ����id ��ȡ��Ƶ��ϸ��Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select Id,Title,KeyWords,PlayCount,InsertDate,Description from JCP_Video where Id="
							+ id);
			while (res.next()) {
				int vId = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String keyWord = res.getString(SqlUtil.VIDEO_KEYWORD);
				String insertDate = res.getString(SqlUtil.VIDEO_INSERTDATE);
				int hitCount = res.getInt(SqlUtil.VIDEO_HITCOUNT);
				String Description = res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(vId, title);
				video.setKeyWords(keyWord);
				video.setInsertDate(insertDate);
				video.setHitCount(hitCount);
				video.setDescript(Description);
				return video;
			}
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
		}finally{
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
		}finally{
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
		}finally{
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
		}finally{
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
			res = sta
					.executeQuery("select * from JCP_Video where IsMySite="
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
		}finally{
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
						.executeQuery("select Top "+top+" Id,Title,ImagesUrl,VideoUrl,Description from JCP_Video where FK_ClassId="
								+ classId+" order by Id desc");
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String Images = res.getString(SqlUtil.VIDEO_IMAGES);
				String videoUrl=res.getString(SqlUtil.VIDEO_URL);
				String desc=res.getString(SqlUtil.VIDEO_DESC);
				Video video = new Video(id, title);
				video.setImages(Images);
				video.setVideoUrl(videoUrl);
				video.setDescript(desc);
				videos.add(video);
			}
			return videos;
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
		}finally{
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
			res = sta.executeQuery("select * from JCP_Video WHERE IsTop=" + isTop + " AND  FK_ClassId="
					+ classId);
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
		}finally{
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
			res = sta
					.executeQuery("select * from JCP_Video where IsMySite="
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
	 *   ���ݷ���id��ȡǰ������Ƶ��Ϣ
	 *   
	 *     �°�    Id,Title,Description,ImagesThumb,VideoUrl    ���  HitCount   CommCount    ������
	 */
	public List<Video> findVideoByClassIdLast(int count, int classId) {
		videos.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("select TOP "+count+" Id,Title,Description,ImagesUrl,PlayCount,VideoDate,VideoUrl from JCP_Video"
							+" WHERE FK_ClassId="+classId+" ORDER BY InsertDate DESC");
			
			while (res.next()) {
				int id = res.getInt(SqlUtil.NEWS_ID);
				String title = res.getString(SqlUtil.VIDEO_TITLE);
				String descript = res.getString(SqlUtil.VIDEO_DESC);
				String images=res.getString("ImagesUrl");
				int playCount=res.getInt("PlayCount");
				String videoDate=res.getString("VideoDate");
				String videoUrl=res.getString("VideoUrl");
				Video video = new Video(id, title);
				video.setDescript(descript);
				video.setImages(images);
				video.setVideoUrl(videoUrl);
				video.setHitCount(playCount);
				video.setVideoDate(videoDate);
				videos.add(video);
			}
			return videos;
		} catch (Exception e) {
		}finally{
			try {
				JdbcUtil.closeConn(sta, dbConn, res);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;}

}
