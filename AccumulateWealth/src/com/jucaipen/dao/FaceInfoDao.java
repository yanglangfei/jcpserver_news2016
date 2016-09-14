package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.ExpressionInfo;

/**
 * @author YLF
 * 
 *     ������ϸ��Ϣ
 *
 */
public interface FaceInfoDao {
	
	/**
	 * @return   ��ȡ���б�����Ϣ
	 */
	public List<ExpressionInfo> findAllFaceInfo();
	
	/**
	 * @param typeId
	 * @return   ��ȡ��ǰ�����µ����б�����Ϣ
	 */
	public List<ExpressionInfo>  findFaceInfoByTypeId(int typeId);
	
	/**
	 * @param id
	 * @return  ����id��ȡ������Ϣ
	 */
	public ExpressionInfo findFaceInfoById(int id);

}
