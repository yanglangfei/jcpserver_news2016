package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Gifts;

/**
 * @author Administrator
 *
 *   ��Ʒ
 */
public interface GiftsDao {
	
	/**
	 * @return  ��ȡ������Ʒ
	 */
	public List<Gifts>  findAllGift(int page);
	
	/**
	 * @param page
	 * @return ���ݷ���id��ȡ��Ʒ��Ϣ
	 */
	public List<Gifts> findGiftByClassId(int page,int classId);
	
	/**
	 * @param id
	 * @return ����id��ȡ��Ʒ��Ϣ
	 */
	public Gifts findGiftById(int id);
	

}
