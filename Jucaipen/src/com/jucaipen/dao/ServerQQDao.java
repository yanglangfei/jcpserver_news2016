package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.ServerQQ;

/**
 * @author Administrator
 *
 *  ���߿ͷ�
 * 
 */
public interface ServerQQDao {
	
	/**
	 * @return  ��ȡ���пͷ�
	 */
	public List<ServerQQ> findAllServer();
	/**
	 * @param id
	 * @return  ����id��ѯ�ͷ���Ϣ
	 */
	public ServerQQ findServerById(int id);
	
	/**
	 * @param roomId
	 * @return   ���ݷ���id��ѯ�ͷ�
	 */
	public List<ServerQQ> findServerByRoomId(int roomId);

}
