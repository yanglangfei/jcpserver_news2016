package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TxtLiveDao;
import com.jucaipen.daoimp.TextLiveImp;
import com.jucaipen.model.TextLive;

public class TxtLiveSer{
	
	/**
	 * @param textLive
	 * @return  �������ֱ��
	 */
	public static int insertTextLive(TextLive textLive){
		TxtLiveDao dao=new TextLiveImp();
		return dao.insertTxtLive(textLive);
	}
	
	public static TextLive findHitsAndGoods(int id){
		TxtLiveDao dao=new TextLiveImp();
		return dao.findHitsAndGoods(id);
	}
	
	
	public static List<TextLive> findLastLive(String date){
		TxtLiveDao dao=new TextLiveImp();
		return dao.findLastDateLive(date);
	}
	
	public static int addGoods(int id, int goods){
		TxtLiveDao dao=new TextLiveImp();
		return dao.addGoods(id, goods);
	}
	
	/**
	 * @param lastId
	 * @param page
	 * @return    �����ϴε�����ֱ��id��ȡ���������ֱ����Ϣ
	 */
	public static List<TextLive> findNewLiveByLastId(int lastId){
		TxtLiveDao dao=new TextLiveImp();
		return dao.findNewLiveByLastId(lastId);
	}

	/**
	 * @param id
	 * @return  ����id��ȡ����ֱ����ϸ����
	 */
	public static TextLive findTextLiveById(int id) {
		TxtLiveDao dao=new TextLiveImp();
		return dao.findTextLiveById(id);
	}

	/**
	 * @return  ��ȡ���е��ı�ֱ��
	 */
	public static List<TextLive> findAllTextLive(int page) {
		TxtLiveDao dao=new TextLiveImp();
		return dao.findAllTextLive(page);
	}

	/**
	 * @param teacherId
	 * @return  ���ݽ�ʦ��ȡ����ֱ��
	 */
	public static List<TextLive> findTextLiveByTeacherId(int teacherId,int page) {
		TxtLiveDao dao=new TextLiveImp();
		return dao.findTextLiveByTeacherId(teacherId,page);
	}
	

	/**
	 * @param isEnd
	 * @return   ��������ֱ��״̬��ȡ����ֱ������
	 */
	public static List<TextLive> findTextLiveByIsEnd(int isEnd) {
		TxtLiveDao dao=new TextLiveImp();
		return dao.findTextLiveByIsEnd(isEnd);
	}
	
	/**
	 * @param teacherId
	 * @param count
	 * @return  ��ȡ��ʦ����ļ���ֱ����Ϣ
	 */
	public static List<TextLive> findTxtLiveByTeacherIdAndLast(int teacherId,int count){
		TxtLiveDao dao=new TextLiveImp();
		return dao.findTxtLiveByTeacherIdAndLast(teacherId, count);
	}
	
	/**
	 * @return  ��ȡ������Ҫ���͵�����ֱ����Ϣ
	 */
	public static List<TextLive> findAllNewTextLivesByPush(){
		TxtLiveDao dao=new TextLiveImp();
		return dao.findAllNewTextLivesByPush();
	}
	
	/**
	 * @param count
	 * @return  ��ȡ���������Ҫ���͵�ֱ����Ϣ
	 */
	public static List<TextLive> findLastPushLive(int count){
		TxtLiveDao dao=new TextLiveImp();
		return dao.findLastPushLive(count);
	}
	
	/**
	 * @param hits
	 * @param id
	 * @return  ���µ����
	 */
	public static int addHits(int hits,int id,int xnHits){
		TxtLiveDao dao=new TextLiveImp();
		return dao.addHits(hits, id,xnHits);
	}

}
