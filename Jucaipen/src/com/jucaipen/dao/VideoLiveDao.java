package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.VideoLive;
/**
 * @author YLF
 * 
 *   ֱ����
 *
 */
public interface VideoLiveDao {
	
	/**
	 * @return   ��ȡ���з�������
	 */
	public List<VideoLive> getRoomList();
	
	/**
	 * @param id
	 * @param renQi
	 * @return  ����������Ϣ
	 */
	public int updateRenQi(int id,int renQi);
	/**
	 * @param id
	 * @return  ����id ��ȡ������ϸ��Ϣ
	 */
	public VideoLive getRoomInfo(int id);
	
	/**
	 * @param id
	 * @return  ����id ��ȡ��Ƶ����URL
	 */
	public VideoLive  getLiveUrl(int id);
	
	/**
	 * @return   ��ȡ���з�����Ϣ
	 */
	public List<VideoLive> getAllRoom(int page);
	
	/**
	 * @param tId
	 * @return  ��ȡ��ʦ�µ���Ƶֱ��
	 */
	public List<VideoLive>  findLiveBytId(int tId);
	
	
	/**
	 * @param isEnd
	 * @return   ��ȡ����ֱ������Ƶֱ��
	 */
	public List<VideoLive>  findLiveByIsEnd(int isEnd);

}
