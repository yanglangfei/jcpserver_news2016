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
 *         ������ʦ��Ϣ
 */
public class ApplyTeacherImp implements ApplyTeacherDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ApplyTeacher> applys = new ArrayList<ApplyTeacher>();
	private int isSuccess;

	@Override
	public ApplyTeacher findApplyByUid(int uId) {
		// �����û�id��ȡ������Ϣ
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
	public List<ApplyTeacher> findApplyByRecommId(int recommId) {
		// �����Ƽ��˻�ȡ������Ϣ
		applys.clear();
		return null;
	}

	/*
	 */
	@Override
	public int addApply(ApplyTeacher apply, int step) {
		// ���������Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			if (step == 1) {
				// ��ӵ�һ������
				isSuccess = sta.executeUpdate("INSERT INTO JCP_Apply"
						+ "(TrueName,IDCard,Sex,CardImg_1"
						+ ",State,InsertDate,FK_UserId) VALUES" + "('"
						+ apply.getTrueName() + "','" + apply.getIdCard()
						+ "'," + apply.getSex() + ",'" + apply.getCardImage1()
						+ "'," + 0 + ",'" + apply.getInsertDate() + "',"
						+ apply.getFk_UserId() + ")");
			} else if (step == 2) {
				// ���µڶ�������
				isSuccess = sta
						.executeUpdate("UPDATE JCP_Apply SET FK_CertificationId="
								+ apply.getFk_certificationId()
								+ ",FK_PositionId="
								+ apply.getFk_PositionId()
								+ ",CertificationNum='"
								+ apply.getCertificationNum()
								+ "',FK_ProvinceId="
								+ apply.getFk_ProvinceId()
								+ ",FK_BankId="
								+ apply.getFk_BankId()
								+ ",BankAccount='"
								+ apply.getBankAccount()
								+ "',FK_CityId="
								+ apply.getFk_CityId()
								+ ",CompanyName='"
								+ apply.getCompanyName()
								+ "',ShanChang='"
								+ apply.getShanChang()
								+ "',UserInformation='"
								+ apply.getUserInformation()
								+ "' WHERE Id="
								+ apply.getId());
			} else {
				// ���µ���������
				isSuccess = sta
						.executeUpdate("UPDATE JCP_Apply SET FK_ParentUserId="
								+ apply.getFk_ParentUserId() + ",MobileNum='"
								+ apply.getMobileNum() + "',Email='"
								+ apply.getEmail() + "',IsTxtLive="
								+ apply.getIsTxtLive() + ",IsVideoLive="
								+ apply.getIsVideoLive() + " WHERE Id="
								+ apply.getId());
			}
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

	@Override
	public ApplyTeacher findLastApplyByUid(int uId, int count) {
		// �����û�id��ȡ������Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP " + count
					+ " Id FROM JCP_Apply WHERE FK_UserId=" + uId);
			while (res.next()) {
				int id = res.getInt(1);
				ApplyTeacher apply = new ApplyTeacher();
				apply.setId(id);
				return apply;
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

	@Override
	public int updateApplyInfo(int id, ApplyTeacher apply) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			return sta.executeUpdate("UPDATE JCP_Apply SET TrueName='"
					+ apply.getTrueName() + "',IDCard='" + apply.getIdCard()
					+ "',Sex=" + apply.getSex() + ",CardImg_1='"
					+ apply.getCardImage1() + "' WHERE Id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ApplyTeacher findLastApplyByUidWithStep(int uId, int count, int step) {
		// �����û�id��ȡ������Ϣ
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT TOP " + count
					+ " * FROM JCP_Apply WHERE FK_UserId=" + uId);
			while (res.next()) {
				int id = res.getInt(1);
				String trueName = res.getString(2);
				String idCard = res.getString(3);
				int sex = res.getInt(4);
				String cardImage = res.getString(5);
				int certificationId = res.getInt(8);
				int positionId = res.getInt(9);
				String certificationNum = res.getString(10);
				int provinceId = res.getInt(11);
				int cityId = res.getInt(12);
				String companyName = res.getString(13);
				String shanChang = res.getString(14);
				String plain = res.getString(15);
				int parentUserId = res.getInt(16);
				String mobile = res.getString(17);
				String email = res.getString(18);
				int state = res.getInt(20);
				int isTxtLive = res.getInt(22);
				int isVideoLive = res.getInt(23);
				int bankId = res.getInt(24);
				String bankAccount = res.getString(25);
				ApplyTeacher apply = new ApplyTeacher();
				apply.setTrueName(trueName);
				apply.setSex(sex);
				apply.setCardImage1(cardImage);
				apply.setCertificationNum(certificationNum);
				apply.setFk_BankId(bankId);
				apply.setIdCard(idCard);
				apply.setFk_certificationId(certificationId);
				apply.setFk_PositionId(positionId);
				apply.setFk_ProvinceId(provinceId);
				apply.setFk_CityId(cityId);
				apply.setCompanyName(companyName);
				apply.setShanChang(shanChang);
				apply.setUserInformation(plain);
				apply.setState(state);
				apply.setFk_ParentUserId(parentUserId);
				apply.setMobileNum(mobile);
				apply.setEmail(email);
				apply.setIsTxtLive(isTxtLive);
				apply.setIsVideoLive(isVideoLive);
				apply.setBankAccount(bankAccount);
				apply.setId(id);
				return apply;
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

}
