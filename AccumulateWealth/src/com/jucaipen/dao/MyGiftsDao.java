package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.MyGifts;

/**
 * @author Administrator
 *
 *  �ҵ���Ʒ ���յ�   �ͳ���Ʒ��¼��
 */
public interface MyGiftsDao {
	/**
	 * @param senderId
	 * @return  ��ȡ���ͳ�����Ʒ
	 */
	public List<MyGifts> findMyGiftBySenderId(int senderId,int page);
	
	/**
	 * @param senderId
	 * @return  ��ȡ���ͳ�����Ʒ
	 */
	public List<MyGifts> findMyGiftDetailBySenderId(int senderId,int giftId,int page);
	
	/**
	 * @param receiverId
	 * @param page
	 * @return ��ȡ�յ�����Ʒ
	 */
	public List<MyGifts> findMyGiftByReceiverId(int receiverId,int page);
	
	/**
	 * @param receiverId
	 * @param page
	 * @return ��ȡ�յ�����Ʒ
	 */
	public List<MyGifts> findMyGiftDetailByReceiverId(int receiverId,int giftId,int page);
	
	/**
	 * @param gifts
	 * @return �����Ʒ��¼
	 */
	public int addGifts(MyGifts gifts);

}
