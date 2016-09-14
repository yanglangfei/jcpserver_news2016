package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TxtLiveDetailsDao;
import com.jucaipen.daoimp.TxtLiveDetaileImp;
import com.jucaipen.model.TxtLiveDetails;

public class TxtLiveDetaileSer{
	
	
	/**
	 * @param details
	 * @return  �������ֱ����ϸ����
	 */
	public static int insertTextDetaile(TxtLiveDetails details){
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.insertTextDetaile(details);
	}

	/**
	 * @param id
	 * @return   ����id��ȡ����ֱ����ϸ����
	 */
	public static TxtLiveDetails findTextDetaileById(int id) {
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findTextDetaileById(id);
	}
	
	/**
	 * @param liveId
	 * @return  ����ֱ��id��ȡ����ֱ����ϸ����
	 */
	public static List<TxtLiveDetails> findTextDetaileByLiveId(int liveId,int type){
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findTextDetaileByLiveId(liveId,type);
	}
	
	/**
	 * @param liveId
	 * @param maxId
	 * @return  ��ȡʵʱ���µĽ��չ۵�
	 */
	public static List<TxtLiveDetails> findPullTextDetaileByLiveId(int liveId,int maxId){
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findPullTextDetaileByLiveId(liveId, maxId);
	}
	
	public static List<TxtLiveDetails> findLaseDetaileByLiveId(int liveId,int count,int type){
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findLaseDetaileByLiveId(liveId,count,type);
	}
	
	
	/**
	 * @param titleId
	 * @return  ���ݱ���id��ȡ����ֱ����ϸ����
	 */
	public static List<TxtLiveDetails> findTextDetaileByTitleId(int titleId){
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findTextDetaileByTitleId(titleId);
	}

	/**
	 * @param type
	 * @return  ����״̬��ȡ����ֱ����ϸ����
	 */
	public static List<TxtLiveDetails> findTextDetaileByType(int type) {
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findTextDetaileByType(type);
	}

	/**
	 * @return  ��ȡ���е�����ֱ����ϸ��Ϣ
	 */
	public static List<TxtLiveDetails> findAllTextDetaile() {
		TxtLiveDetailsDao dao=new TxtLiveDetaileImp();
		return dao.findAllTextDetaile();
	}

}
