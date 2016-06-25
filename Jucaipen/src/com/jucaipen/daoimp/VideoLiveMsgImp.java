package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.VideoLiveMsgDao;
import com.jucaipen.model.VideoLiveMsg;
import com.jucaipen.utils.JdbcUtil;

public class VideoLiveMsgImp implements VideoLiveMsgDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<VideoLiveMsg> msgs=new ArrayList<VideoLiveMsg>();

	@Override
	public List<VideoLiveMsg> findLastLiveMsg(int count, int liveId,boolean isChek) {
		dbConn=JdbcUtil.connSqlServer();
		msgs.clear();
		try {
			sta=dbConn.createStatement();
			if(isChek){
				//��ȡ��˵�������Ϣ
				res=sta.executeQuery("SELECT TOP "+count+" * FROM JCP_VideoLive_Msg WHERE Fk_VideoLiveId="+liveId+" AND shenhe>0 ORDER BY SendDate ASC");
			}else{
				//��ȡȫ����������Ϣ
				res=sta.executeQuery("SELECT TOP "+count+" * FROM JCP_VideoLive_Msg WHERE Fk_VideoLiveId="+liveId+" ORDER BY SendDate ASC");
			}
			while (res.next()) {
				int id=res.getInt(1); 
				int senderId=res.getInt(2);  //SendUserId
				String senderName=res.getString(3);  //SendName
				String msg=res.getString(4);  //Msg
				int shenhe=res.getInt(5);  //shenhe
				int receiverId=res.getInt(6);  //ReceiverId
				String receiverName=res.getString(7);  //ReceiverName
				int isSysAdmin=res.getInt(10);  //IsSysAdmin
				int isRoomAdmin=res.getInt(11);  //IsRoomAdmin
				int isTeacher=res.getInt(12);  //Isteacher
				int isShouhu=res.getInt(13);  //IsShouhuzhe
				int isChatAdmin=res.getInt(14);  //IsChatAdmin
				int userLevel=res.getInt(15);  //UserLevel
				int isSeverId=res.getInt(16);  //IsSeverId
				String sendDate=res.getString(17);  //SendDate
				VideoLiveMsg liveMsg=new VideoLiveMsg();
				liveMsg.setSendUserId(senderId);
				liveMsg.setSendName(senderName);
				liveMsg.setMsg(msg);
				liveMsg.setId(id);
				liveMsg.setShenhe(shenhe);
				liveMsg.setReceiverId(receiverId);
				liveMsg.setReceiverName(receiverName);
				liveMsg.setIsSysAdmin(isSysAdmin);
				liveMsg.setIsRoomAdmin(isRoomAdmin);
				liveMsg.setIsTeacher(isTeacher);
				liveMsg.setIsShouhu(isShouhu);
				liveMsg.setIsChatAdmin(isChatAdmin);
				liveMsg.setUserLeavel(userLevel);
				liveMsg.setIsServer(isSeverId);
				liveMsg.setSendDate(sendDate);
				msgs.add(liveMsg);
			}
			return msgs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<VideoLiveMsg> findLiveMsgByMaxId(int maxId, int liveId,
			boolean isCheck) {
		dbConn=JdbcUtil.connSqlServer();
		msgs.clear();
		try {
			sta=dbConn.createStatement();
			if(isCheck){
				//��ȡ��˵�������Ϣ
				res=sta.executeQuery("SELECT  * FROM JCP_VideoLive_Msg WHERE Fk_VideoLiveId="+liveId+" AND shenhe>0  AND Id>"+maxId+" ORDER BY SendDate DESC");
			}else{
				//��ȡȫ����������Ϣ
				res=sta.executeQuery("SELECT TOP  * FROM JCP_VideoLive_Msg WHERE Fk_VideoLiveId="+liveId+" ADN Id>"+maxId+" ORDER BY SendDate DESC");
			}
			while (res.next()) {
				int senderId=res.getInt(2);  //SendUserId
				String senderName=res.getString(3);  //SendName
				String msg=res.getString(4);  //Msg
				int shenhe=res.getInt(5);  //shenhe
				int receiverId=res.getInt(6);  //ReceiverId
				String receiverName=res.getString(7);  //ReceiverName
				int isSysAdmin=res.getInt(10);  //IsSysAdmin
				int isRoomAdmin=res.getInt(11);  //IsRoomAdmin
				int isTeacher=res.getInt(12);  //Isteacher
				int isShouhu=res.getInt(13);  //IsShouhuzhe
				int isChatAdmin=res.getInt(14);  //IsChatAdmin
				int userLevel=res.getInt(15);  //UserLevel
				int isSeverId=res.getInt(16);  //IsSeverId
				String sendDate=res.getString(17);  //SendDate
				VideoLiveMsg liveMsg=new VideoLiveMsg();
				liveMsg.setSendUserId(senderId);
				liveMsg.setSendName(senderName);
				liveMsg.setMsg(msg);
				liveMsg.setShenhe(shenhe);
				liveMsg.setReceiverId(receiverId);
				liveMsg.setReceiverName(receiverName);
				liveMsg.setIsSysAdmin(isSysAdmin);
				liveMsg.setIsRoomAdmin(isRoomAdmin);
				liveMsg.setIsTeacher(isTeacher);
				liveMsg.setIsShouhu(isShouhu);
				liveMsg.setIsChatAdmin(isChatAdmin);
				liveMsg.setUserLeavel(userLevel);
				liveMsg.setIsServer(isSeverId);
				liveMsg.setSendDate(sendDate);
				msgs.add(liveMsg);
			}
			return msgs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public int addMsg(VideoLiveMsg msg) {
		dbConn=JdbcUtil.connSqlServer();
		try {
			sta=dbConn.createStatement();
			return sta.executeUpdate("INSERT INTO JCP_VideoLive_Msg"
					+ "(SendUserId,SendName,Msg,shenhe,ReceiverId,"
					+ "Fk_VideoLiveId,BuyProductId,IsSysAdmin,IsRoomAdmin,Isteacher,"
					+ "IsShouhuzhe,IsChatAdmin,UserLevel,IsSeverId,SendDate,IP) VALUES ("
					+msg.getSendUserId()+",'"+msg.getSendName()+"','"+msg.getMsg()+"',"+msg.getShenhe()
					+","+msg.getReceiverId()+","
					+msg.getVideoLiveId()+","+msg.getBuyProductId()+","+msg.getIsSysAdmin()
					+","+msg.getIsRoomAdmin()+","+msg.getIsTeacher()+","+msg.getIsShouhu()
					+","+msg.getIsChatAdmin()+","+msg.getUserLeavel()+","+msg.getIsServer()
					+",'"+msg.getSendDate()+"','"+msg.getIp()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


}
