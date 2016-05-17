package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.ExpressionType;

public interface FaceTypeDao {
	
	/**
	 * @return   ��ȡ���б���
	 */
	public List<ExpressionType> findAllFace();
	
	/**
	 * @param id
	 * @return   ͨ������id��ȡ������Ϣ
	 */
	public ExpressionType findFaceById(int id);

}
