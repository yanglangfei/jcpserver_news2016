package com.jucaipen.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jucaipen.dao.ChatFaceDao;
import com.jucaipen.model.ChatFace;
import com.jucaipen.utils.JdbcUtil;

public class ChatFaceImp implements ChatFaceDao {
	private Connection dbConn;
	private Statement sta;
	private ResultSet res;
	private List<ChatFace> chatFaces=new ArrayList<ChatFace>();

	public List<ChatFace> findAll() {
		//��ȡ�����������
		try {
			dbConn=JdbcUtil.connVideoSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM Chat_Face");
			chatFaces=getChatFace(res);
			return chatFaces;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	public ChatFace findFaceById(int id) {
		//����id��ȡ�������
		try {
			dbConn=JdbcUtil.connVideoSqlServer();
			sta=dbConn.createStatement();
			res=sta.executeQuery("SELECT * FROM Chat_Face");
			chatFaces=getChatFace(res);
			if(chatFaces!=null&&chatFaces.size()>0){
				return chatFaces.get(0);
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
  
	
	private List<ChatFace> getChatFace(ResultSet result) {
		//��ȡ����������
		chatFaces.clear();
		try {
			while (result.next()) {
				int Id=result.getInt("Id");
				String FaceUrl=result.getString("FaceUrl");
				String FaceTitle=result.getString("FaceTitle");
				int PxId=result.getInt("PxId");
				ChatFace face=new ChatFace();
				face.setId(Id);
				face.setPxId(PxId);
				face.setFaceUrl(FaceUrl);
				face.setTitle(FaceTitle);
				chatFaces.add(face);
			}
			return chatFaces;
		} catch (Exception e) {
		}
		return null;
	}
}
