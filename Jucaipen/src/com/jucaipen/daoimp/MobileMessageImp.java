package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.MobileMessageDao;
import com.jucaipen.model.MobileMessage;
import com.jucaipen.utils.JdbcUtil;
public class MobileMessageImp implements MobileMessageDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private int isSuccess;
	private List<MobileMessage> mobList = new ArrayList<MobileMessage>();

	public int insertMessage(MobileMessage message) {
		// ���Ͷ���
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta
					.executeUpdate("INSERT INTO JCP_MobileMess"
							+ " (MobileNum,ActionCode,MessContent,SendDate,SendDev,MessType,Return_resptime,Return_respstatus,Return_msgid,SendIp) VALUES ('"
							+ message.getTelPhone()
							+ "','"
							+ message.getActionCode()
							+ "','"
							+ message.getMessageContent()
							+ "','"
							+ message.getSendDate()
							+ "',"
							+ message.getSendDev()
							+ ","
							+ message.getMsgType()
							+ ",'"
							+ message.getResptime()
							+ "',"
							+ message.getRespstatus()
							+ ",'"
							+ message.getMsgid()
							+ "','"
							+ message.getSendIp()
							+ "')");
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

	public int upDateMessageType(String msgId, MobileMessage message) {
		// �޸Ķ���״̬---�ɹ�
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCP_MobileMess SET MessType="
					+ message.getMsgType() + ",CheckDate='"
					+ message.getCheckDate() + 
					"',Remark='"+message.getRemark()+
					"' WHERE Return_msgid='" + msgId+"'");
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
	
	
	public int upDateMessageFailType(String msgId, MobileMessage message) {
		// �޸Ķ���״̬  --��֤��ʱ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			isSuccess = sta.executeUpdate("UPDATE JCP_MobileMess SET MessType="
					+ message.getMsgType()  +
					" WHERE Return_msgid='" + msgId+"'");
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

	public List<MobileMessage> findMobileMessgageByMobileNum(String telPhone) {
		// �����ֻ��Ż�ȡ������Ϣ
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT * FROM JCP_MobileMess WHERE MobileNum="
							+ telPhone + " ORDER BY SendDate DESC");
			mobList = getMobileMessage(res);
			return mobList;
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

	public List<MobileMessage> findMobileMessageByMobileNumLast(int count,
			String mobile) {
		// �����ֻ��Ų�ѯ�����������
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta.executeQuery("SELECT  TOP " + count
					+ " * FROM JCP_MobileMess WHERE MobileNum=" + mobile
					+ " ORDER BY SendDate DESC");
			mobList = getMobileMessage(res);
			return mobList;
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

	public List<MobileMessage> getMobileMessage(ResultSet result) {
		try {
			mobList.clear();
			while (result.next()) {
				int id = result.getInt("Id");
				String mobileNum = result.getString("MobileNum");
				String actionCode = result.getString("ActionCode");
				String messageContent = result.getString("MessContent");
				String sendDate = result.getString("SendDate");
				int sendDev = result.getInt("SendDev");
				int msgType = result.getInt("MessType");
				String checkDate = result.getString("CheckDate");
				String resptime = result.getString("Return_resptime");
				int respstatus = result.getInt("Return_respstatus");
				String msgid = result.getString("Return_msgid");
				String sendIp = result.getString("SendIp");
				String remark = result.getString("Remark");
				MobileMessage message = new MobileMessage();
				message.setId(id);
				message.setTelPhone(mobileNum);
				message.setActionCode(actionCode);
				message.setMessageContent(messageContent);
				message.setSendDate(sendDate);
				message.setSendDev(sendDev);
				message.setMsgType(msgType);
				message.setCheckDate(checkDate);
				message.setResptime(resptime);
				message.setRespstatus(respstatus);
				message.setMsgid(msgid);
				message.setRemark(remark);
				message.setSendIp(sendIp);
				mobList.add(message);
			}
			return mobList;
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

}
