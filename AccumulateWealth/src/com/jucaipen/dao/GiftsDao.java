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
	 * @return  ��ȡ������Ʒ   ��ҳ
	 */
	public List<Gifts>  findAllGift(int page);
	
	/**
	 * @return  ��ȡ������Ʒ
	 */
	public List<Gifts>  findAllGifts();
	
	/**
	 * @param page
	 * @return ���ݷ���id��ȡ��Ʒ��Ϣ
	 */
	public List<Gifts> findGiftByClassId(int classId);
	
	/**
	 * @param id
	 * @return ����id��ȡ��Ʒ��Ϣ
	 */
	public Gifts findGiftById(int id);
	
	public List<Gifts> findIsTuijian(int IsTuiJian,int page);

	
	public List<Gifts> findIsTuijian(int IsTuiJian);
	

}
