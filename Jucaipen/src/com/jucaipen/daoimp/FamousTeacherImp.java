package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.FamousTeacherDao;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 *
 *
 *  获取名师信息
 */
public class FamousTeacherImp implements FamousTeacherDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<FamousTeacher> teachers=new ArrayList<FamousTeacher>();
	
	
	/**
	 * @return 查询新闻总页数
	 */
	public int findTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Tearcher "
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
	
	public List<FamousTeacher> findIndexData() {
		teachers.clear();
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  Fans,HuiDaCount,ArticleCount from JCP_Tearcher");
			while (res.next()) {
				int fans=res.getInt(1);
				int answerCount=res.getInt(2);
				int articleCount=res.getInt(3);
				FamousTeacher teacher=new FamousTeacher();
				teacher.setFans(fans);
				teacher.setAnswerCount(answerCount);
				teacher.setArticleCount(articleCount);
				teachers.add(teacher);
			}
			return teachers;
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


	public List<FamousTeacher> findAllFamousTeacher(int page) {
		try {
			int totlePage=findTotlePage("");
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP 15 * FROM "
					+ "(SELECT ROW_NUMBER() OVER (ORDER BY Fans DESC) AS RowNumber,* FROM JCP_Tearcher) A "
					+ "WHERE RowNumber > " + 15 * (page - 1));
			teachers=getTeacher(res,page,totlePage);
			return teachers;
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
	 * 
	 *   
	 * 
	 */
	public List<FamousTeacher> findFamousTeacherByIndex(int count) {
		teachers.clear();
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT TOP "+count+" * FROM JCP_Tearcher ORDER BY Fans DESC");
			while (res.next()) {
				int id=res.getInt("Id");
				int isV=res.getInt("IsV");
				String nickName=res.getString("NickName");
				String headFace=res.getString("HeadFace");
				String touxian=res.getString("TouXian");
				String introduce=res.getString("Jianjie");
				String notice=res.getString("Notice");
				int fans=res.getInt("Fans");
				FamousTeacher famousTeacher=new FamousTeacher();
				famousTeacher.setId(id);
				famousTeacher.setIsV(isV);
				famousTeacher.setNickName(nickName);
				famousTeacher.setHeadFace(headFace);
				famousTeacher.setLevel(touxian);
				famousTeacher.setFans(fans);
				famousTeacher.setNotice(notice);
				famousTeacher.setIntroduce(introduce);
				teachers.add(famousTeacher);
			}
			return teachers;
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
	
	
	public FamousTeacher findFamousTeacherById(int id) {
		try {
			dbConn=JdbcUtil.connSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Tearcher WHERE Id="+id);
			teachers=getTeacher(res,0,0);
			if(teachers.size()>0){
				return teachers.get(0);
				
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
	
	public List<FamousTeacher> getTeacher(ResultSet result,int page,int totlePage){
		teachers.clear();
		try {
			while (result.next()) {
				int id=result.getInt("Id");
				String trueName=result.getString("TrueName");
				String nickName=result.getString("NickName");
				String headFace=result.getString("HeadFace");
				String touxian=result.getString("TouXian");
				int isV=result.getInt("IsV");
				int fans=result.getInt("Fans");
				int weekRenQi=result.getInt("WeekRenQi");
				int mothRenQi=result.getInt("MonthRenQi");
				int answerCount=result.getInt("HuiDaCount");
				int articleCount=result.getInt("ArticleCount");
				int articleReadCount=result.getInt("ArticleReadCount");
				int articleGood=result.getInt("ArticleGood");
				String notice=result.getString("Notice");
				String introduce=result.getString("Jianjie");
				String hoby=result.getString("ShanChang");
				String telPhone=result.getString("MobileNum");
				int serviceNum=result.getInt("QianYueCount");
				String joinDate=result.getString("JoinDate");
				int liveGbookIsPass=result.getInt("LiveGbookIsPass");
				float  yearPrice=result.getFloat("YearPrice");
				float motnPrice=result.getFloat("MonthPrice");
				float quarterPrice=result.getFloat("QuarterPrice");
				float dayPrice=result.getFloat("DayPrice");
				int renQi=result.getInt("LiveRenQi");
				int askNum=result.getInt("AskNum");
				FamousTeacher teacher=new FamousTeacher();
				teacher.setPage(page);
				teacher.setTotlePage(totlePage);
				teacher.setId(id);
				teacher.setAnswerCount(answerCount);
				teacher.setArticleCount(articleCount);
				teacher.setTrueName(trueName);
				teacher.setTelPhone(telPhone);
				teacher.setNickName(nickName);
				teacher.setHeadFace(headFace);
				teacher.setLevel(touxian);
				teacher.setIntroduce(introduce);
				teacher.setIsV(isV);
				teacher.setYaerPrice(yearPrice);
				teacher.setMothPrice(motnPrice);
				teacher.setQulaterPrice(quarterPrice);
				teacher.setDayPrice(dayPrice);
				teacher.setFans(fans);
				teacher.setLiveFans(renQi);
				teacher.setWeekRenQi(weekRenQi);
				teacher.setMothRenQi(mothRenQi);
				teacher.setHoby(hoby);
				teacher.setArticleReadCount(articleReadCount);
				teacher.setArticleGood(articleGood);
				teacher.setNotice(notice);
				teacher.setSignCount(serviceNum);
				teacher.setJoinDate(joinDate);
				teacher.setLiveGbookIsPass(liveGbookIsPass);
				teacher.setAskNum(askNum);
				teachers.add(teacher);
			}
			return teachers;
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
	public int findMaxAsk(int id) {
		// 获取讲师最大提问数
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT AskNum FROM JCP_Tearcher WHERE Id="+id);
			while (res.next()) {
				return res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<FamousTeacher> findAllTeacher() {
		// 获取所有讲师信息   不分页
		teachers.clear();
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT Id,NickName FROM JCP_Tearcher");
			while (res.next()) {
				int id=res.getInt(1);
				String nickName=res.getString(2);
				FamousTeacher teacher=new FamousTeacher();
				teacher.setId(id);
				teacher.setNickName(nickName);
				teachers.add(teacher);
			}
			return teachers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
