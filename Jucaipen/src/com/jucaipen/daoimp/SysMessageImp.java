package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.SysMessageDao;
import com.jucaipen.model.SysMessage;
import com.jucaipen.utils.JdbcUtil;

/**
 * @author Administrator
 *
 *  ϵͳ��Ϣ
 */
public class SysMessageImp implements SysMessageDao {
	
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<SysMessage> messages = new ArrayList<SysMessage>();

	/**
	 * @return ��ѯ�ش�������Ϣ��ҳ��
	 */
	public int getTotlePage(String condition) {
		try {
			dbConn = JdbcUtil.connSqlServer();
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT  CEILING(COUNT(*)/15.0) as totlePager from JCP_Mess "
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


	@Override
	public SysMessage findMessageById(int id) {
		//����id��ȡϵͳ��Ϣ
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM JCP_Mess WHERE Id="+id);
			while (res.next()) {
				String title=res.getString(2);  //Title
				String content=res.getString(3);  //MessContent
				int type=res.getInt(4);  //MessType
				int senderId=res.getInt(5);  //FK_SendUserId
				int receiverId=res.getInt(6);  //FK_ReceiveUserId
				String sendDate=res.getString(7);  //SendDate
				String receiverDate=res.getString(8);  //ReceiveDate
				int isRead=res.getInt(9);  //IsRead
				SysMessage message=new SysMessage();
				message.setTitle(title);
				message.setContent(content);
				message.setType(type);
				message.setSenderId(senderId);
				message.setReceiverId(receiverId);
				message.setSendDate(sendDate);
				message.setIsRead(isRead);
				message.setReceiveDate(receiverDate);
				return message;
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
	public List<SysMessage> findMessageBySenderId(int senderId,int page) {
		//��ȡ�ҷ��͵�ϵͳ��Ϣ
		messages.clear();
		int totlePage = getTotlePage(" WHERE FK_SendUserId=" + senderId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Mess WHERE FK_SendUserId="
							+ senderId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id=res.getInt("Id");
				String title=res.getString("Title");  //Title
				String content=res.getString("MessContent");  //MessContent
				int type=res.getInt("MessType");  //MessType
				int receiverId=res.getInt("FK_ReceiveUserId");  //FK_ReceiveUserId
				String sendDate=res.getString("SendDate");  //SendDate
				String receiverDate=res.getString("ReceiveDate");  //ReceiveDate
				int isRead=res.getInt("IsRead");  //IsRead
				SysMessage message=new SysMessage();
				message.setTitle(title);
				message.setContent(content);
				message.setType(type);
				message.setTotlePage(totlePage);
				message.setPage(page);
				message.setId(id);
				message.setSenderId(senderId);
				message.setReceiverId(receiverId);
				message.setSendDate(sendDate);
				message.setIsRead(isRead);
				message.setReceiveDate(receiverDate);
				messages.add(message);
			}
			return messages;
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
	public List<SysMessage> findMessageByReceiverId(int receiverId,int page) {
		//��ȡ�ҽ��յ���ϵͳ��Ϣ
		messages.clear();
		int totlePage = getTotlePage(" WHERE FK_ReceiveUserId=" + receiverId);
		dbConn = JdbcUtil.connSqlServer();
		try {
			sta = dbConn.createStatement();
			res = sta
					.executeQuery("SELECT TOP 15 * FROM "
							+ "(SELECT ROW_NUMBER() OVER (ORDER BY InsertDate desc) AS RowNumber,* FROM JCP_Mess WHERE FK_ReceiveUserId="
							+ receiverId + ") A " + "WHERE RowNumber > " + 15
							* (page - 1));
			while (res.next()) {
				int id=res.getInt("Id");
				String title=res.getString("Title");  //Title
				String content=res.getString("MessContent");  //MessContent
				int type=res.getInt("MessType");  //MessType
				int senderId=res.getInt("FK_SendUserId");  //FK_SendUserId
				String sendDate=res.getString("SendDate");  //SendDate
				String receiverDate=res.getString("ReceiveDate");  //ReceiveDate
				int isRead=res.getInt("IsRead");  //IsRead
				SysMessage message=new SysMessage();
				message.setTitle(title);
				message.setContent(content);
				message.setType(type);
				message.setTotlePage(totlePage);
				message.setPage(page);
				message.setId(id);
				message.setSenderId(senderId);
				message.setReceiverId(receiverId);
				message.setSendDate(sendDate);
				message.setIsRead(isRead);
				message.setReceiveDate(receiverDate);
				messages.add(message);
			}
			return messages;
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

}
