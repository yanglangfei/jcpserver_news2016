package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.ApplyTeacherDao;
import com.jucaipen.model.ApplyTeacher;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 * 
 *         申请名师信息
 */
public class ApplyTeacherImp implements ApplyTeacherDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ApplyTeacher> applys = new ArrayList<ApplyTeacher>();
	private int isSuccess;

	@Override
	public ApplyTeacher findApplyByUid(int uId) {
		// 根据用户id获取申请信息
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT Id,State,InsertDate FROM JCP_Apply WHERE FK_UserId="
							+ uId);
			while (res.next()) {
				int id = res.getInt(1);
				int state = res.getInt(2);
				String insertDate = res.getString(3);
				ApplyTeacher apply = new ApplyTeacher();
				apply.setId(id);
				apply.setState(state);
				apply.setInsertDate(insertDate);
				return apply;
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

	@Override
	public List<ApplyTeacher> findApplyByRecommId(int recommId) {
		//根据推荐人获取申请信息
		applys.clear();
		return null;
	}

	@Override
	public int addApply(ApplyTeacher apply) {
		// 添加申请信息
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCP_Apply"
							+ "(TrueName,IDCard,Sex,CardImg_1,CardImg_2,CardImg_3,FK_CertificationId,"
							+ "FK_PositionId,CertificationNum,FK_ProvinceId,FK_CityId,CompanyName,"
							+ "ShanChang,UserInformation,FK_ParentUserId,MobileNum,Email,FK_UserId,"
							+ "State,InsertDate,IsTxtLive,IsVideoLive,FK_BankId,BankAccount) VALUES"
							+ "('"
							+ apply.getTrueName()
							+ "','"
							+ apply.getIdCard()
							+ "',"
							+ apply.getSex()
							+ ",'"
							+ apply.getCardImage1()
							+ "','"
							+ apply.getCardImage2()
							+ "','"
							+ apply.getCardImage3()
							+ "',"
							+ apply.getFk_certificationId()
							+ ","
							+ apply.getFk_PositionId()
							+ ",'"
							+ apply.getCertificationNum()
							+ "',"
							+ apply.getFk_ProvinceId()
							+ ","
							+ apply.getFk_CityId()
							+ ",'"
							+ apply.getCompanyName()
							+ "','"
							+ apply.getShanChang()
							+ "','"
							+ apply.getUserInformation()
							+ "',"
							+ apply.getFk_ParentUserId()
							+ ",'"
							+ apply.getMobileNum()
							+ "','"
							+ apply.getEmail()
							+ "',"
							+ apply.getFk_UserId()
							+ ","
							+ apply.getState()
							+ ",'"
							+ apply.getInsertDate()
							+ "',"
							+ apply.getIsTxtLive()
							+ ","
							+ apply.getIsVideoLive()
							+ ","
							+ apply.getFk_BankId()
							+ ",'"
							+ apply.getBankAccount() + "')");
			return isSuccess;
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

}
