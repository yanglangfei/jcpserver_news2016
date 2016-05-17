package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.MailMessageDao;
import com.jucaipen.model.MailMessage;
import com.jucaipen.utils.JdbcUtil;

public class MailMessageImp implements MailMessageDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;
	private List<MailMessage> maList = new ArrayList<MailMessage>();

	public List<MailMessage> findMailMessageByEmail(String email) {
		// ���������ȡ�ʼ���Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT  * FROM JCP_MailMess WHERE Email="
					+ email+" ORDER BY SendDate DESC");
			maList = getMailMessage(res);
			return maList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MailMessage> findMailMessageByUserId(int uId) {
		// ��ȡ�û������е��ʼ���Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT   * FROM JCP_MailMess WHERE UserId="
					+ uId+" ORDER BY SendDate DESC");
			maList = getMailMessage(res);
			return maList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insertMessage(MailMessage mailMessage) {
		// �����ʼ�
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCP_MailMess "
							+ "(Email,ActionCode,MessContent,MessType,SendDate,userId) VALUES ('"
							+ mailMessage.getEmailAddress() + "','"
							+ mailMessage.getActionCode() + "','"
							+ mailMessage.getMessageContent() + "',"
							+ mailMessage.getMsgType() + ",'"
							+ mailMessage.getSendDate() + "',"
							+ mailMessage.getUserId() + ")");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int upDateMessageType(int id, MailMessage msg) {
		// �޸��ʼ�״̬
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCP_MailMess SET MessType="
					+ msg.getMsgType() + ",CheckDate=" + msg.getCheckDate()
					+" WHERE Id="+id);
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<MailMessage> findMailMessageByLastCount(int uId, int count) {
		// ��ȡ�û�����յ��ļ����ʼ�
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT  TOP " + count
					+ " * FROM JCP_MailMess WHERE UserId=" + uId+" ORDER BY SendDate DESC");
			maList = getMailMessage(res);
			return maList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MailMessage> getMailMessage(ResultSet result) {
		try {
			maList.clear();
			while (result.next()) {
				int id = result.getInt("Id");
				String email = result.getString("Email");
				String actionCode = result.getString("ActionCode");
				String messageContent = result.getString("MessContent");
				int msgType = result.getInt("MessType");
				String sendDate = result.getString("SendDate");
				String checkDate = result.getString("CheckDate");
				int userId = result.getInt("userId");
				MailMessage mail = new MailMessage();
				mail.setId(id);
				mail.setEmailAddress(email);
				mail.setActionCode(actionCode);
				mail.setMessageContent(messageContent);
				mail.setMsgType(msgType);
				mail.setSendDate(sendDate);
				mail.setCheckDate(checkDate);
				mail.setUserId(userId);
				maList.add(mail);
			}
			return maList;
		} catch (Exception e) {
		}
		return null;
	}

}
