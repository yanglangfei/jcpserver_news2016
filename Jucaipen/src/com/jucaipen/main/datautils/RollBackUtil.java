package com.jucaipen.main.datautils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.Contribute;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Guardian;
import com.jucaipen.model.Marker;
import com.jucaipen.model.MyGifts;
import com.jucaipen.model.MyPresent;
import com.jucaipen.model.MySpecial;
import com.jucaipen.model.MyVideo;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.RebateIntegeralDetail;
import com.jucaipen.model.Sign;
import com.jucaipen.model.SignDetail;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.TacticsSale;
import com.jucaipen.model.User;
import com.jucaipen.utils.BaseData;
import com.jucaipen.utils.JdbcUtil;

public class RollBackUtil {
	private static Connection dbConn;
	private static Statement sta;

	/**
	 * ��ͨ�ػ�
	 * 
	 * @param guardian
	 * @param rebate
	 * @param account
	 * @param b
	 * @param detail
	 * @param detailIntegeral
	 * @param uId
	 * @param user
	 * @param account2
	 * @param detailAccount
	 * @param contribute
	 * @param teacher
	 * @param sysRebate
	 * @param gurdianId
	 *            ��ͨ�ػ�
	 */
	public static int synchrGuardian(Guardian guardian, Rebate rebate,
			Account account, int b, AccountDetail detail,
			AccountDetail detailIntegeral, int uId, User user,
			SysAccount account2, SysDetailAccount detailAccount,
			Contribute contribute, FamousTeacher teacher, Rebate sysRebate,
			int gurdianId) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta = dbConn.createStatement();
			// 1 �����ػ� JCP_ShouHuZhe
			if (gurdianId > 0) {
				// ��Լ
				sta.executeUpdate("UPDATE JCP_ShouHuZhe SET EndDate='"
						+ guardian.getEndDate() + "',State=0 WHERE Id="
						+ gurdianId);
			} else {
				// ǩԼ
				sta.executeUpdate("INSERT INTO JCP_ShouHuZhe(FK_UserId,FK_TearchId,InsertDate,Ip,StartDate,EndDate,State) VALUES ("
						+ guardian.getUserId()
						+ ","
						+ guardian.getTeacherId()
						+ ",'"
						+ guardian.getInsertDate()
						+ "','"
						+ guardian.getIp()
						+ "','"
						+ guardian.getStartDate()
						+ "','"
						+ guardian.getEndDate()
						+ "',"
						+ guardian.getState() + ")");
			}
			// 2�� ���� ���� JCP_Rebate ��ʦ����
			sta.executeUpdate("INSERT INTO JCP_Rebate(FK_TearchId,RebateType,RebateMoney,FK_FromUserId,InsertDate,Ramerk) VALUES("
					+ rebate.getTeacherId()
					+ ","
					+ rebate.getType()
					+ ",'"
					+ rebate.getRebateMoney()
					+ "',"
					+ rebate.getFromId()
					+ ",'"
					+ rebate.getInsertDate()
					+ "','"
					+ rebate.getRemark() + "')");
			// ϵͳ����
			sta.executeUpdate("INSERT INTO JCP_Rebate(FK_TearchId,RebateType,RebateMoney,FK_FromUserId,InsertDate,Ramerk) VALUES("
					+ sysRebate.getTeacherId()
					+ ","
					+ sysRebate.getType()
					+ ",'"
					+ sysRebate.getRebateMoney()
					+ "',"
					+ sysRebate.getFromId()
					+ ",'"
					+ sysRebate.getInsertDate()
					+ "','" + sysRebate.getRemark() + "')");

			// 3 �����˻� �۲ƱҼ��� JCP_Account ��������
			sta.executeUpdate("UPDATE JCP_Account SET Integral="
					+ (account.getIntegeral() + b) + ",JucaiBi="
					+ (account.getJucaiBills() - b) + " WHERE UserId=" + uId);
			// 4�� �˻���ϸ �۲Ʊұ仯 JCP_Account_Detail
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detail.getOrderCode() + "','" + detail.getDetailMoney()
					+ "'," + detail.getDetailType() + "," + detail.getState()
					+ ",'" + detail.getRemark() + "','"
					+ detail.getInsertDate() + "'," + 0 + ","
					+ detail.getUserId() + ")");

			// ����
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detailIntegeral.getOrderCode() + "','"
					+ detailIntegeral.getDetailMoney() + "',"
					+ detailIntegeral.getDetailType() + ","
					+ detailIntegeral.getState() + ",'"
					+ detailIntegeral.getRemark() + "','"
					+ detailIntegeral.getInsertDate() + "'," + 0 + ","
					+ detailIntegeral.getUserId() + ")");
			// 5�� �û��� ���� JCP_User
			sta.executeUpdate("UPDATE JCP_User SET AllIntegral="
					+ (user.getAllIntegral() + b) + " WHERE Id=" + uId);

			// �����û��ȼ�
			int currentLeavel = user.getUserLeval();
			int newLeavel = BaseData.getLeavel(user.getAllIntegral() + b);
			if (currentLeavel != newLeavel) {
				sta.executeUpdate("UPDATE JCP_User SET UserLevel=" + newLeavel
						+ " WHERE Id=" + uId);
			}
			// 6��ϵͳ�˻� JCP_SysAccount
			sta.executeUpdate("UPDATE JCP_SysAccount SET SysChildAccount="
					+ (account2.getSysChildAccount() + b) + ",UserAccount="
					+ (account2.getUserAccount() - b) + ",OpenShAccount="
					+ (account2.getOpenGurdianAccount() + b));
			// 7�� ϵͳ�˻���ϸ JCP_SysAccountDateil
			sta.executeUpdate("INSERT INTO JCP_SysAccountDateil"
					+ "(UserId,AccType,RecordType,OrderId,Price,InsertDate,Remark,IP,IsDel)"
					+ " VALUES(" + detailAccount.getUserId() + ","
					+ detailAccount.getType() + ","
					+ detailAccount.getRecoderType() + ","
					+ detailAccount.getOrderId() + ","
					+ detailAccount.getPrice() + ",'"
					+ detailAccount.getInsertDate() + "','"
					+ detailAccount.getRemark() + "','" + detailAccount.getIp()
					+ "'," + detailAccount.getIsDel() + ")");
			// 8 ������ JCP_Contribute
			sta.executeUpdate("INSERT INTO JCP_Contribute"
					+ "(FK_UserId,FK_TearchId,FK_Id,InsertDate,AllJucaibi,ComType) VALUES ("
					+ contribute.getUserId() + "," + contribute.getTeacherId()
					+ "," + contribute.getFk_id() + ",'"
					+ contribute.getInsertDate() + "',"
					+ contribute.getAllJucaiBills() + ","
					+ contribute.getComType() + ")");
			// 9����ʦ ǩԼ����
			sta.executeUpdate("UPDATE JCP_Tearcher SET QianYueCount="
					+ (teacher.getSignCount() + 1) + " WHERE Id="
					+ teacher.getId());
			dbConn.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				dbConn.setAutoCommit(true);
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * @param ip
	 * @param payDate
	 * @param pState
	 * @param orderCode
	 * @param bills
	 * @param a
	 * @param uId
	 * @param detail
	 * @param account2
	 * @param detailAccount
	 * @return ��ֵ --------------------NO
	 */
	public static int recharge(String orderCode, int pState, String payDate,
			String ip, int bills, Account a, int uId, AccountDetail detail,
			SysAccount account2, SysDetailAccount detailAccount) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta = dbConn.createStatement();
			// 1 ��ֵ JCP_AddOrder
			if (pState == 2) {
				sta.executeUpdate("UPDATE JCP_AddOrder SET OrderState="
						+ pState + ",PaymentDate='" + payDate + "',IP='" + ip
						+ "' WHERE OrderCode='" + orderCode + "'");
			} else {
				sta.executeUpdate("UPDATE JCP_AddOrder SET OrderState="
						+ pState + ",IP='" + ip + "' WHERE OrderCode='"
						+ orderCode + "'");
			}
			if (pState == 2) {
				// 2 �����˻� �۲ƱҼ��� JCP_Account
				if (a != null) {
					sta.executeUpdate("UPDATE JCP_Account SET JucaiBi="
							+ (a.getJucaiBills() + bills) + " WHERE UserId="
							+ uId);
				} else {
					Account account = new Account();
					account.setIntegeral(0);
					account.setJucaiBills(bills);
					account.setUserId(uId);
					sta.executeUpdate("INSERT INTO JCP_Account(UserId,Integral,JucaiBi) VALUES("
							+ account.getUserId()
							+ ","
							+ account.getIntegeral()
							+ ","
							+ account.getJucaiBills() + ")");
				}
				// 3�� �˻���ϸ �۲Ʊұ仯 JCP_Account_Detail
				sta.executeUpdate("INSERT INTO JCP_Account_Detail"
						+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
						+ "InsertDate,IsDel,UserId) VALUES ('"
						+ detail.getOrderCode() + "','"
						+ detail.getDetailMoney() + "',"
						+ detail.getDetailType() + "," + detail.getState()
						+ ",'" + detail.getRemark() + "','"
						+ detail.getInsertDate() + "'," + 0 + ","
						+ detail.getUserId() + ")");
				// 4��ϵͳ�˻� JCP_SysAccount
				sta.executeUpdate("UPDATE JCP_SysAccount SET SysAccount="
						+ (account2.getSysAccount() + bills)
						+ ",SysChildAccount="
						+ (account2.getSysChildAccount())
						+ ",UserAccount="
						+ (account2.getSysAccount() + bills - account2
								.getSysChildAccount()));
				// 5�� ϵͳ�˻���ϸ JCP_SysAccountDateil
				sta.executeUpdate("INSERT INTO JCP_SysAccountDateil"
						+ "(UserId,AccType,RecordType,OrderId,Price,InsertDate,Remark,IP,IsDel)"
						+ " VALUES(" + detailAccount.getUserId() + ","
						+ detailAccount.getType() + ","
						+ detailAccount.getRecoderType() + ","
						+ detailAccount.getOrderId() + ","
						+ detailAccount.getPrice() + ",'"
						+ detailAccount.getInsertDate() + "','"
						+ detailAccount.getRemark() + "','"
						+ detailAccount.getIp() + "',"
						+ detailAccount.getIsDel() + ")");
			}
			dbConn.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				dbConn.setAutoCommit(true);
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * @param marker
	 * @param detail
	 * @param uId
	 * @param jucaiBills
	 * @param markerMoney
	 * @param integeral
	 * @param contribute
	 * @param sysAccount
	 * @param sysDetail
	 * @param user
	 * @param sysRebate
	 * @param rebate
	 * @param detailIntegeral
	 * @return ����
	 */
	public static int addReward(Marker marker, AccountDetail detail,
			int integeral, int markerMoney, int jucaiBills, int uId,
			Contribute contribute, SysAccount sysAccount,
			SysDetailAccount sysDetail, User user, Rebate rebate,
			Rebate sysRebate, AccountDetail detailIntegeral) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta = dbConn.createStatement();
			// 1����Ӵ�����Ϣ JCP_MarkerWord_Dateil
			sta.executeUpdate("INSERT INTO JCP_MarkerWord_Dateil(MarkerType,FK_UserId,FK_LogId,MaekerCount,InsertDate,IP) VALUES("
					+ marker.getType()
					+ ","
					+ marker.getUserId()
					+ ","
					+ marker.getIdeaId()
					+ ","
					+ marker.getMarkerCount()
					+ ",'"
					+ marker.getInsertDate() + "','" + marker.getIp() + "')");
			// 2�����˻���Ϣ ���־۲Ʊ� JCP_Account
			sta.executeUpdate("UPDATE JCP_Account SET Integral="
					+ (integeral + markerMoney) + ",JucaiBi="
					+ (jucaiBills - markerMoney) + " WHERE UserId=" + uId);
			// 3���˻���ϸ��Ϣ JCP_Account_Detail �۲ƱҼ���
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detail.getOrderCode() + "','" + detail.getDetailMoney()
					+ "'," + detail.getDetailType() + "," + detail.getState()
					+ ",'" + detail.getRemark() + "','"
					+ detail.getInsertDate() + "'," + 0 + ","
					+ detail.getUserId() + ")");
			// ��������
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detailIntegeral.getOrderCode() + "','"
					+ detailIntegeral.getDetailMoney() + "',"
					+ detailIntegeral.getDetailType() + ","
					+ detailIntegeral.getState() + ",'"
					+ detailIntegeral.getRemark() + "','"
					+ detailIntegeral.getInsertDate() + "'," + 0 + ","
					+ detailIntegeral.getUserId() + ")");

			// 4������ JCP_Rebate ϵͳ����
			sta.executeUpdate("INSERT INTO JCP_Rebate(FK_TearchId,RebateType,RebateMoney,FK_FromUserId,InsertDate,Ramerk) VALUES("
					+ rebate.getTeacherId()
					+ ","
					+ rebate.getType()
					+ ",'"
					+ rebate.getRebateMoney()
					+ "',"
					+ rebate.getFromId()
					+ ",'"
					+ rebate.getInsertDate()
					+ "','"
					+ rebate.getRemark() + "')");
			// ��ʦ����
			sta.executeUpdate("INSERT INTO JCP_Rebate(FK_TearchId,RebateType,RebateMoney,FK_FromUserId,InsertDate,Ramerk) VALUES("
					+ sysRebate.getTeacherId()
					+ ","
					+ sysRebate.getType()
					+ ",'"
					+ sysRebate.getRebateMoney()
					+ "',"
					+ sysRebate.getFromId()
					+ ",'"
					+ sysRebate.getInsertDate()
					+ "','" + sysRebate.getRemark() + "')");

			// 5������ JCP_Contribute
			sta.executeUpdate("INSERT INTO JCP_Contribute"
					+ "(FK_UserId,FK_TearchId,FK_Id,InsertDate,AllJucaibi,ComType) VALUES ("
					+ contribute.getUserId() + "," + contribute.getTeacherId()
					+ "," + contribute.getFk_id() + ",'"
					+ contribute.getInsertDate() + "',"
					+ contribute.getAllJucaiBills() + ","
					+ contribute.getComType() + ")");
			// 6��ϵͳ�ܱ� JCP_SysAccount
			sta.executeUpdate("UPDATE JCP_SysAccount SET SysChildAccount="
					+ (sysAccount.getSysChildAccount() + markerMoney)
					+ ",UserAccount="
					+ (sysAccount.getUserAccount() - markerMoney)
					+ ",DaShangAccount="
					+ (sysAccount.getDaShangAccount() + markerMoney));

			// 7��ϵͳ��ϸ�� JCP_SysAccountDateil
			sta.executeUpdate("INSERT INTO JCP_SysAccountDateil"
					+ "(UserId,AccType,RecordType,OrderId,Price,InsertDate,Remark,IP,IsDel)"
					+ " VALUES(" + detail.getUserId() + ","
					+ sysDetail.getType() + "," + sysDetail.getRecoderType()
					+ "," + sysDetail.getOrderId() + "," + sysDetail.getPrice()
					+ ",'" + sysDetail.getInsertDate() + "','"
					+ sysDetail.getRemark() + "','" + sysDetail.getIp() + "',"
					+ sysDetail.getIsDel() + ")");

			// 8���û��� ���� JCP_User
			sta.executeUpdate("UPDATE JCP_User SET AllIntegral="
					+ (integeral + markerMoney) + " WHERE Id=" + uId);

			// �����û��ȼ�
			int currentLeavel = user.getUserLeval();
			int newLeavel = BaseData.getLeavel(integeral + markerMoney);
			if (currentLeavel != newLeavel) {
				sta.executeUpdate("UPDATE JCP_User SET UserLevel=" + newLeavel
						+ " WHERE Id=" + uId);
			}
			dbConn.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				dbConn.setAutoCommit(true);
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * @param sale
	 * @param account
	 * @param uId
	 * @param bills
	 * @param detailInteger
	 * @param detail
	 * @param sysRebate
	 * @param teacherRebate
	 * @param contribute
	 * @param sysAccount
	 * @param sysDetailAccount
	 * @param user
	 * @param saleId
	 * @return ����ս��
	 */
	public static int orderTactisc(TacticsSale sale, Account account,
			int bills, int uId, AccountDetail detail,
			AccountDetail detailInteger, Rebate teacherRebate,
			Rebate sysRebate, Contribute contribute, SysAccount sysAccount,
			SysDetailAccount sysDetailAccount, User user) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta = dbConn.createStatement();
			// 1�����ս��������Ϣ JCP_TacticsSale
			sta.executeUpdate("INSERT INTO  JCP_TacticsSale(UserId,"
					+ "TacticsId,MobileNum,InsetDate,StratDate,EndDate,IsStop,IP,Remarks) VALUES("
					+ sale.getUserId() + "," + sale.getTacticsId() + ",'"
					+ sale.getTelPhone() + "','" + sale.getInsertDate() + "','"
					+ sale.getStartDate() + "','" + sale.getEndDate() + "',"
					+ sale.getIsStop() + ",'" + sale.getIp() + "','"
					+ sale.getRemark() + "')");
			// 2�����˻���Ϣ ���־۲Ʊ� JCP_Account
			sta.executeUpdate("UPDATE JCP_Account SET Integral="
					+ (account.getIntegeral() + bills) + ",JucaiBi="
					+ (account.getJucaiBills() - bills) + " WHERE UserId="
					+ uId);
			// 3���˻���ϸ��Ϣ JCP_Account_Detail �۲ƱҼ���
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detail.getOrderCode() + "','" + detail.getDetailMoney()
					+ "'," + detail.getDetailType() + "," + detail.getState()
					+ ",'" + detail.getRemark() + "','"
					+ detail.getInsertDate() + "'," + 0 + ","
					+ detail.getUserId() + ")");
			// ��������
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detailInteger.getOrderCode() + "','"
					+ detailInteger.getDetailMoney() + "',"
					+ detailInteger.getDetailType() + ","
					+ detailInteger.getState() + ",'"
					+ detailInteger.getRemark() + "','"
					+ detailInteger.getInsertDate() + "'," + 0 + ","
					+ detailInteger.getUserId() + ")");

			// 4������ JCP_Rebate ϵͳ����
			sta.executeUpdate("INSERT INTO JCP_Rebate(FK_TearchId,RebateType,RebateMoney,FK_FromUserId,InsertDate,Ramerk) VALUES("
					+ sysRebate.getTeacherId()
					+ ","
					+ sysRebate.getType()
					+ ",'"
					+ sysRebate.getRebateMoney()
					+ "',"
					+ sysRebate.getFromId()
					+ ",'"
					+ sysRebate.getInsertDate()
					+ "','" + sysRebate.getRemark() + "')");
			// ��ʦ����
			sta.executeUpdate("INSERT INTO JCP_Rebate(FK_TearchId,RebateType,RebateMoney,FK_FromUserId,InsertDate,Ramerk) VALUES("
					+ teacherRebate.getTeacherId()
					+ ","
					+ teacherRebate.getType()
					+ ",'"
					+ teacherRebate.getRebateMoney()
					+ "',"
					+ teacherRebate.getFromId()
					+ ",'"
					+ teacherRebate.getInsertDate()
					+ "','"
					+ teacherRebate.getRemark() + "')");

			// 5������ JCP_Contribute
			sta.executeUpdate("INSERT INTO JCP_Contribute"
					+ "(FK_UserId,FK_TearchId,FK_Id,InsertDate,AllJucaibi,ComType) VALUES ("
					+ contribute.getUserId() + "," + contribute.getTeacherId()
					+ "," + contribute.getFk_id() + ",'"
					+ contribute.getInsertDate() + "',"
					+ contribute.getAllJucaiBills() + ","
					+ contribute.getComType() + ")");
			// 6��ϵͳ�ܱ� JCP_SysAccount
			sta.executeUpdate("UPDATE JCP_SysAccount SET SysChildAccount="
					+ (sysAccount.getSysChildAccount() + bills)
					+ ",UserAccount=" + (sysAccount.getUserAccount() - bills)
					+ ",TacticsAccount="
					+ (sysAccount.getTactivsAccount() + bills));

			// 7��ϵͳ��ϸ�� JCP_SysAccountDateil
			sta.executeUpdate("INSERT INTO JCP_SysAccountDateil"
					+ "(UserId,AccType,RecordType,OrderId,Price,InsertDate,Remark,IP,IsDel)"
					+ " VALUES(" + detail.getUserId() + ","
					+ sysDetailAccount.getType() + ","
					+ sysDetailAccount.getRecoderType() + ","
					+ sysDetailAccount.getOrderId() + ","
					+ sysDetailAccount.getPrice() + ",'"
					+ sysDetailAccount.getInsertDate() + "','"
					+ sysDetailAccount.getRemark() + "','"
					+ sysDetailAccount.getIp() + "',"
					+ sysDetailAccount.getIsDel() + ")");

			// 8���û��� ���� JCP_User
			sta.executeUpdate("UPDATE JCP_User SET AllIntegral="
					+ (account.getIntegeral() + bills) + " WHERE Id=" + uId);

			// �����û��ȼ�
			int currentLeavel = user.getUserLeval();
			int newLeavel = BaseData.getLeavel(account.getIntegeral() + bills);
			if (currentLeavel != newLeavel) {
				sta.executeUpdate("UPDATE JCP_User SET UserLevel=" + newLeavel
						+ " WHERE Id=" + uId);
			}
			dbConn.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				dbConn.setAutoCommit(true);
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * @param myVideo
	 * @param a
	 * @param uId
	 * @param b
	 * @param detail
	 * @param detailInteger
	 * @param sysAccount
	 * @param sysDetailAccount
	 * @param user
	 * @param contribute
	 * @return ������Ƶ
	 */
	public static int purchVideo(MyVideo myVideo, Account a, int uId, int b,
			AccountDetail detail, AccountDetail detailInteger,
			SysAccount sysAccount, SysDetailAccount sysDetailAccount, User user) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta = dbConn.createStatement();
			// 1���������ҵ���Ƶ��Ϣ JCP_MyVideo
			sta.executeUpdate("INSERT INTO JCP_MyVideo"
					+ "(FK_UserId,FK_VideoId,InsertDate,Remark,IsDel,IsStop,StartDate,EndDate)"
					+ " VALUES(" + uId + "," + myVideo.getVideoId() + ",'"
					+ myVideo.getInsertDate() + "','" + myVideo.getRemark()
					+ "'," + myVideo.getIsDel() + "," + myVideo.getIsStop()
					+ ",'" + myVideo.getStartDate() + "','"
					+ myVideo.getEndDate() + "')");

			// 2�����˻���Ϣ ���־۲Ʊ� JCP_Account
			sta.executeUpdate("UPDATE JCP_Account SET Integral="
					+ (a.getIntegeral() + b) + ",JucaiBi="
					+ (a.getJucaiBills() - b) + " WHERE UserId=" + uId);
			// 3���˻���ϸ��Ϣ JCP_Account_Detail �۲ƱҼ���
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detail.getOrderCode() + "','" + detail.getDetailMoney()
					+ "'," + detail.getDetailType() + "," + detail.getState()
					+ ",'" + detail.getRemark() + "','"
					+ detail.getInsertDate() + "'," + 0 + ","
					+ detail.getUserId() + ")");
			// ��������
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detailInteger.getOrderCode() + "','"
					+ detailInteger.getDetailMoney() + "',"
					+ detailInteger.getDetailType() + ","
					+ detailInteger.getState() + ",'"
					+ detailInteger.getRemark() + "','"
					+ detailInteger.getInsertDate() + "'," + 0 + ","
					+ detailInteger.getUserId() + ")");

			// 4��ϵͳ�ܱ� JCP_SysAccount
			sta.executeUpdate("UPDATE JCP_SysAccount SET SysChildAccount="
					+ (sysAccount.getSysChildAccount() + b) + ",UserAccount="
					+ (sysAccount.getUserAccount() - b) + ",TacticsAccount="
					+ (sysAccount.getPayVideoAccount() + b));

			// 5��ϵͳ��ϸ�� JCP_SysAccountDateil
			sta.executeUpdate("INSERT INTO JCP_SysAccountDateil"
					+ "(UserId,AccType,RecordType,OrderId,Price,InsertDate,Remark,IP,IsDel)"
					+ " VALUES(" + detail.getUserId() + ","
					+ sysDetailAccount.getType() + ","
					+ sysDetailAccount.getRecoderType() + ","
					+ sysDetailAccount.getOrderId() + ","
					+ sysDetailAccount.getPrice() + ",'"
					+ sysDetailAccount.getInsertDate() + "','"
					+ sysDetailAccount.getRemark() + "','"
					+ sysDetailAccount.getIp() + "',"
					+ sysDetailAccount.getIsDel() + ")");

			// 6���û��� ���� JCP_User
			sta.executeUpdate("UPDATE JCP_User SET AllIntegral="
					+ (a.getIntegeral() + b) + " WHERE Id=" + uId);

			// �����û��ȼ�
			int currentLeavel = user.getUserLeval();
			int newLeavel = BaseData.getLeavel(a.getIntegeral() + b);
			if (currentLeavel != newLeavel) {
				sta.executeUpdate("UPDATE JCP_User SET UserLevel=" + newLeavel
						+ " WHERE Id=" + uId);
			}
			dbConn.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				dbConn.setAutoCommit(true);
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * @param present
	 * @param b
	 * @param a
	 * @param uId
	 * @param detail
	 * @param detailInteger
	 * @param contribute
	 * @param user
	 * @param sysAccount
	 * @param sysDetailAccount
	 * @return ������Ʒ
	 */
	public static int purchGifts(MyPresent presentExit, MyPresent present,
			Account a, int b, int uId, AccountDetail detail,
			AccountDetail detailInteger, User user, SysAccount sysAccount,
			SysDetailAccount sysDetailAccount) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta = dbConn.createStatement();
			// 1����������Ʒ��Ϣ JCP_MyPresent
			if (presentExit == null) {
				sta.executeUpdate("INSERT INTO JCP_MyPresent (FK_UserId,PresentNum,FK_LiPinId) VALUES("
						+ present.getUserId()
						+ ","
						+ present.getPresentNum()
						+ "," + present.getPresentId() + ")");
			} else {
				sta.executeUpdate("UPDATE JCP_MyPresent SET PresentNum="
						+ (presentExit.getPresentNum() + present
								.getPresentNum()) + " WHERE FK_LiPinId="
						+ presentExit.getPresentId());
			}
			// 2�����˻���Ϣ ���־۲Ʊ� JCP_Account
			sta.executeUpdate("UPDATE JCP_Account SET Integral="
					+ (a.getIntegeral() + b) + ",JucaiBi="
					+ (a.getJucaiBills() - b) + " WHERE UserId=" + uId);
			// 3���˻���ϸ��Ϣ JCP_Account_Detail �۲ƱҼ���
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detail.getOrderCode() + "','" + detail.getDetailMoney()
					+ "'," + detail.getDetailType() + "," + detail.getState()
					+ ",'" + detail.getRemark() + "','"
					+ detail.getInsertDate() + "'," + 0 + ","
					+ detail.getUserId() + ")");
			// ��������
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detailInteger.getOrderCode() + "','"
					+ detailInteger.getDetailMoney() + "',"
					+ detailInteger.getDetailType() + ","
					+ detailInteger.getState() + ",'"
					+ detailInteger.getRemark() + "','"
					+ detailInteger.getInsertDate() + "'," + 0 + ","
					+ detailInteger.getUserId() + ")");

			// 4��ϵͳ�ܱ� JCP_SysAccount
			sta.executeUpdate("UPDATE JCP_SysAccount SET SysChildAccount="
					+ (sysAccount.getSysChildAccount() + b) + ",UserAccount="
					+ (sysAccount.getUserAccount() - b) + ",GiftAccount="
					+ (sysAccount.getGiftAccount() + b));

			// 5��ϵͳ��ϸ�� JCP_SysAccountDateil
			sta.executeUpdate("INSERT INTO JCP_SysAccountDateil"
					+ "(UserId,AccType,RecordType,OrderId,Price,InsertDate,Remark,IP,IsDel)"
					+ " VALUES(" + detail.getUserId() + ","
					+ sysDetailAccount.getType() + ","
					+ sysDetailAccount.getRecoderType() + ","
					+ sysDetailAccount.getOrderId() + ","
					+ sysDetailAccount.getPrice() + ",'"
					+ sysDetailAccount.getInsertDate() + "','"
					+ sysDetailAccount.getRemark() + "','"
					+ sysDetailAccount.getIp() + "',"
					+ sysDetailAccount.getIsDel() + ")");

			// 6���û��� ���� JCP_User
			sta.executeUpdate("UPDATE JCP_User SET AllIntegral="
					+ (a.getIntegeral() + b) + " WHERE Id=" + uId);

			// �����û��ȼ�
			int currentLeavel = user.getUserLeval();
			int newLeavel = BaseData.getLeavel(a.getIntegeral() + b);
			if (currentLeavel != newLeavel) {
				sta.executeUpdate("UPDATE JCP_User SET UserLevel=" + newLeavel
						+ " WHERE Id=" + uId);
			}
			dbConn.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				dbConn.setAutoCommit(true);
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * @param a
	 * @param uId
	 * @param user
	 * @param sysAccount
	 * @param bs
	 * @param detail
	 * @param detailInteger
	 * @param sysDetailAccount
	 * @return �����ʴ� -------------------------------NO
	 */
	public static int purchAnswer(Account a, int uId, User user,
			SysAccount sysAccount, int bs, AccountDetail detail,
			AccountDetail detailInteger, SysDetailAccount sysDetailAccount) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta = dbConn.createStatement();
			// 1�������ӻش���Ϣ JCP_Ask

			// 2�����˻���Ϣ ���־۲Ʊ� JCP_Account
			sta.executeUpdate("UPDATE JCP_Account SET Integral="
					+ (a.getIntegeral() + bs) + ",JucaiBi="
					+ (a.getJucaiBills() - bs) + " WHERE UserId=" + uId);
			// 3���˻���ϸ��Ϣ JCP_Account_Detail �۲ƱҼ���
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detail.getOrderCode() + "','" + detail.getDetailMoney()
					+ "'," + detail.getDetailType() + "," + detail.getState()
					+ ",'" + detail.getRemark() + "','"
					+ detail.getInsertDate() + "'," + 0 + ","
					+ detail.getUserId() + ")");
			// ��������
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detailInteger.getOrderCode() + "','"
					+ detailInteger.getDetailMoney() + "',"
					+ detailInteger.getDetailType() + ","
					+ detailInteger.getState() + ",'"
					+ detailInteger.getRemark() + "','"
					+ detailInteger.getInsertDate() + "'," + 0 + "," + uId
					+ ")");

			// 6��ϵͳ�ܱ� JCP_SysAccount
			sta.executeUpdate("UPDATE JCP_SysAccount SET SysChildAccount="
					+ (sysAccount.getSysChildAccount() + bs) + ",UserAccount="
					+ (sysAccount.getUserAccount() - bs) + ",TacticsAccount="
					+ (sysAccount.getTactivsAccount() + bs));

			// 7��ϵͳ��ϸ�� JCP_SysAccountDateil
			sta.executeUpdate("INSERT INTO JCP_SysAccountDateil"
					+ "(UserId,AccType,RecordType,OrderId,Price,InsertDate,Remark,IP,IsDel)"
					+ " VALUES(" + uId + "," + sysDetailAccount.getType() + ","
					+ sysDetailAccount.getRecoderType() + ","
					+ sysDetailAccount.getOrderId() + ","
					+ sysDetailAccount.getPrice() + ",'"
					+ sysDetailAccount.getInsertDate() + "','"
					+ sysDetailAccount.getRemark() + "','"
					+ sysDetailAccount.getIp() + "',"
					+ sysDetailAccount.getIsDel() + ")");

			// 8���û��� ���� JCP_User
			sta.executeUpdate("UPDATE JCP_User SET AllIntegral="
					+ (a.getIntegeral() + bs) + " WHERE Id=" + uId);

			// �����û��ȼ�
			int currentLeavel = user.getUserLeval();
			int newLeavel = BaseData.getLeavel(a.getIntegeral() + bs);
			if (currentLeavel != newLeavel) {
				sta.executeUpdate("UPDATE JCP_User SET UserLevel=" + newLeavel
						+ " WHERE Id=" + uId);
			}
			dbConn.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				dbConn.setAutoCommit(true);
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * @param num
	 * @param present
	 * @param account
	 * @param bill
	 * @param uId
	 * @param sysAccount
	 * @param rebate
	 * @param sysRebate
	 * @param contribute
	 * @param gifts
	 * @return ������Ʒ
	 */
	public static int sendGifts(MyPresent present, int num, int bill, int uId,
			SysAccount sysAccount, Rebate sysRebate, Rebate rebate,
			Contribute contribute, MyGifts gifts) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta = dbConn.createStatement();
			// 1��������Ʒ���� JCP_MyPresent
			sta.executeUpdate("UPDATE JCP_MyPresent SET PresentNum="
					+ (present.getPresentNum() - num) + " WHERE FK_UserId="
					+ uId + " AND FK_LiPinId=" + present.getPresentId());

			// 2��ϵͳ�ܱ� JCP_SysAccount
			sta.executeUpdate("UPDATE JCP_SysAccount SET TeacherAccount="
					+ (sysAccount.getTeacherRebateAccount() + bill)
					+ ",SysRebateAccount="
					+ (sysAccount.getSysRebateAccount() + bill));

			// 3 ������
			// ϵͳ����
			sta.executeUpdate("INSERT INTO JCP_Rebate(FK_TearchId,RebateType,RebateMoney,FK_FromUserId,InsertDate,Ramerk) VALUES("
					+ sysRebate.getTeacherId()
					+ ","
					+ sysRebate.getType()
					+ ",'"
					+ sysRebate.getRebateMoney()
					+ "',"
					+ sysRebate.getFromId()
					+ ",'"
					+ sysRebate.getInsertDate()
					+ "','" + sysRebate.getRemark() + "')");

			// ��ʦ����

			sta.executeUpdate("INSERT INTO JCP_Rebate(FK_TearchId,RebateType,RebateMoney,FK_FromUserId,InsertDate,Ramerk) VALUES("
					+ rebate.getTeacherId()
					+ ","
					+ rebate.getType()
					+ ",'"
					+ rebate.getRebateMoney()
					+ "',"
					+ rebate.getFromId()
					+ ",'"
					+ rebate.getInsertDate()
					+ "','"
					+ rebate.getRemark() + "')");

			// 4���ױ�
			sta.executeUpdate("INSERT INTO JCP_Contribute"
					+ "(FK_UserId,FK_TearchId,FK_Id,InsertDate,AllJucaibi,ComType) VALUES("
					+ uId + "," + contribute.getTeacherId() + ","
					+ contribute.getFk_id() + ",'" + contribute.getInsertDate()
					+ "'," + contribute.getAllJucaiBills() + ","
					+ contribute.getComType() + ")");

			// 5 �ͳ���Ʒ��¼
			sta.executeUpdate("INSERT INTO JCP_MyLiPin (FK_SendUserId,FK_ReceiveUserId,FK_LiPinId,InsertDate,SortId,LiPinNum,ReMark) VALUES ("
					+ gifts.getSenderId()
					+ ","
					+ gifts.getReceiverId()
					+ ","
					+ gifts.getGiftId()
					+ ",'"
					+ gifts.getInsertDate()
					+ "',"
					+ gifts.getSortId()
					+ ","
					+ gifts.getGiftNum()
					+ ",'"
					+ gifts.getRemark() + "')");

			dbConn.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				dbConn.setAutoCommit(true);
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * @param mySpecial
	 * @param a
	 * @param uId
	 * @param b
	 * @param detail
	 * @param detailInteger
	 * @param sysAccount
	 * @param sysDetailAccount
	 * @param user
	 * @return ����ר��
	 */
	public static int purchSpecial(MySpecial mySpecial, Account a, int uId,
			int b, AccountDetail detail, AccountDetail detailInteger,
			SysAccount sysAccount, SysDetailAccount sysDetailAccount, User user) {

		dbConn = JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta = dbConn.createStatement();
			// 1���������ҵ�ר����Ϣ JCP_MySpecial
			sta.executeUpdate("INSERT INTO JCP_MySpecial"
					+ "(FK_UserId,FK_SpecialId,InsertDate,Remark,IsDel"
					+ ",IsStop,StartDate,EndDate)" + " VALUES("
					+ mySpecial.getUserId() + "," + mySpecial.getSpecialId()
					+ ",'" + mySpecial.getInsertDate() + "','"
					+ mySpecial.getRemark() + "'," + mySpecial.getIsDel() + ","
					+ mySpecial.getIsStop() + ",'" + mySpecial.getStartDate()
					+ "','" + mySpecial.getEndDate() + "')");

			// 2�����˻���Ϣ ���־۲Ʊ� JCP_Account
			sta.executeUpdate("UPDATE JCP_Account SET Integral="
					+ (a.getIntegeral() + b) + ",JucaiBi="
					+ (a.getJucaiBills() - b) + " WHERE UserId=" + uId);
			// 3���˻���ϸ��Ϣ JCP_Account_Detail �۲ƱҼ���
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detail.getOrderCode() + "','" + detail.getDetailMoney()
					+ "'," + detail.getDetailType() + "," + detail.getState()
					+ ",'" + detail.getRemark() + "','"
					+ detail.getInsertDate() + "'," + 0 + ","
					+ detail.getUserId() + ")");
			// ��������
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ detailInteger.getOrderCode() + "','"
					+ detailInteger.getDetailMoney() + "',"
					+ detailInteger.getDetailType() + ","
					+ detailInteger.getState() + ",'"
					+ detailInteger.getRemark() + "','"
					+ detailInteger.getInsertDate() + "'," + 0 + ","
					+ detailInteger.getUserId() + ")");

			// 4��ϵͳ�ܱ� JCP_SysAccount
			sta.executeUpdate("UPDATE JCP_SysAccount SET SysChildAccount="
					+ (sysAccount.getSysChildAccount() + b) + ",UserAccount="
					+ (sysAccount.getUserAccount() - b) + ",TacticsAccount="
					+ (sysAccount.getPaySpecialAccount() + b));

			// 5��ϵͳ��ϸ�� JCP_SysAccountDateil
			sta.executeUpdate("INSERT INTO JCP_SysAccountDateil"
					+ "(UserId,AccType,RecordType,OrderId,Price,InsertDate,Remark,IP,IsDel)"
					+ " VALUES(" + detail.getUserId() + ","
					+ sysDetailAccount.getType() + ","
					+ sysDetailAccount.getRecoderType() + ","
					+ sysDetailAccount.getOrderId() + ","
					+ sysDetailAccount.getPrice() + ",'"
					+ sysDetailAccount.getInsertDate() + "','"
					+ sysDetailAccount.getRemark() + "','"
					+ sysDetailAccount.getIp() + "',"
					+ sysDetailAccount.getIsDel() + ")");

			// 6���û��� ���� JCP_User
			sta.executeUpdate("UPDATE JCP_User SET AllIntegral="
					+ (a.getIntegeral() + b) + " WHERE Id=" + uId);

			// �����û��ȼ�
			int currentLeavel = user.getUserLeval();
			int newLeavel = BaseData.getLeavel(a.getIntegeral() + b);
			if (currentLeavel != newLeavel) {
				sta.executeUpdate("UPDATE JCP_User SET UserLevel=" + newLeavel
						+ " WHERE Id=" + uId);
			}
			dbConn.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				dbConn.setAutoCommit(true);
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * @param sign
	 * @param detail
	 * @param inDetail
	 * @param accountDetail
	 * @param a
	 * @param signIntegeral
	 * @param uId
	 * @param user
	 * @return ǩ��
	 */
	public static int signIn(SignDetail detail, Sign sign,
			RebateIntegeralDetail inDetail, AccountDetail accountDetail,
			Account a, int uId, int signIntegeral, User user) {
		dbConn = JdbcUtil.connSqlServer();
		try {
			dbConn.setAutoCommit(false);
			sta = dbConn.createStatement();
			// 1��������ǩ����ϸ�� JCP_QianDao_Detail
			sta.executeUpdate("INSERT INTO JCP_QianDao_Detail(UserId,InsertDate,Ip,Remark) VALUES("
					+ detail.getUserId()
					+ ",'"
					+ detail.getInsertDate()
					+ "','"
					+ detail.getIp()
					+ "','"
					+ detail.getRemark()
					+ "')");

			// 2������ǩ���ܱ� JCP_QianDao
			sta.executeUpdate("UPDATE JCP_QianDao SET LastDate='"
					+ sign.getLastDate() + "',Ip='" + sign.getIp()
					+ "',QDCount=" + sign.getSignNum() + " WHERE UserId="
					+ sign.getUserId());
			// 3���������� JCP_RebateIntegral_Detail
			sta.executeUpdate("INSERT INTO JCP_RebateIntegral_Detail(FK_UserId,IntegralNum,InsertDate,ReMark,Type,FK_FromId) VALUES("
					+ inDetail.getUserId()
					+ ","
					+ inDetail.getIntegralNum()
					+ ",'"
					+ inDetail.getInsertDate()
					+ "','"
					+ inDetail.getRemark()
					+ "',"
					+ inDetail.getType()
					+ ","
					+ inDetail.getFromId() + ")");
			// �����˻���ϸ�� JCP_Account_Detail
			sta.executeUpdate("INSERT INTO JCP_Account_Detail"
					+ "(OrderCode,DetailMoney,DetailType,State,Remark,"
					+ "InsertDate,IsDel,UserId) VALUES ('"
					+ accountDetail.getOrderCode() + "','"
					+ accountDetail.getDetailMoney() + "',"
					+ accountDetail.getDetailType() + ","
					+ accountDetail.getState() + ",'"
					+ accountDetail.getRemark() + "','"
					+ accountDetail.getInsertDate() + "'," + 0 + ","
					+ accountDetail.getUserId() + ")");

			// 4���˻��ܱ� JCP_Account
			if (a != null) {
				int newIntegeral = signIntegeral + a.getIntegeral();
				sta.executeUpdate("UPDATE JCP_Account SET Integral="
						+ newIntegeral + " WHERE UserId=" + uId);
			} else {
				a = new Account();
				a.setIntegeral(signIntegeral);
				a.setJucaiBills(0);
				a.setUserId(uId);
				sta.executeUpdate("INSERT INTO JCP_Account(UserId,Integral,JucaiBi) VALUES("
						+ a.getUserId()
						+ ","
						+ a.getIntegeral()
						+ ","
						+ a.getJucaiBills() + ")");
			}

			// 5���û������ JCP_User
			int newIntegeral = user.getAllIntegral() + signIntegeral;
			sta.executeUpdate("UPDATE JCP_User SET AllIntegral=" + newIntegeral
					+ " WHERE Id=" + uId);

			// �����û��ȼ�
			int currentLeavel = user.getUserLeval();
			int newLeavel = BaseData.getLeavel(newIntegeral);
			if (currentLeavel != newLeavel) {
				sta.executeUpdate("UPDATE JCP_User SET UserLevel=" + newLeavel
						+ " WHERE Id=" + uId);
			}
			dbConn.commit();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbConn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				dbConn.setAutoCommit(true);
				dbConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

}
