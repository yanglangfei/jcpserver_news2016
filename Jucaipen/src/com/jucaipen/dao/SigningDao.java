package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Signing;

public interface SigningDao {
	
	/**
	 * @param signing
	 * @return  ���ǩԼ
	 */
	public int insertSigin(Signing signing);
	/**
	 * @param id
	 * @return  ����id��ȡǩԼ��ϸ��Ϣ
	 */
	public Signing findSignById(int id);
	/**
	 * @return ��ȡ����ǩԼ��Ϣ
	 */
	public List<Signing> findAllSigin();
	/**
	 * @param userId
	 * @return  �����û�id��ȡǩԼ��Ϣ
	 */
	public List<Signing> findSignByUserId(int userId);
	/**
	 * @param teacherId
	 * @return  ���ݽ�ʦid��ȡǩԼ��Ϣ
	 */
	public List<Signing> findSiginByTeacherId(int teacherId);
	/**
	 * @param type
	 * @return  ����ǩԼ���ͻ�ȡǩԼ��Ϣ
	 */
	public List<Signing> findSiginByType(int type);

}
