package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.FaceInfoDao;
import com.jucaipen.daoimp.FaceInfoImp;
import com.jucaipen.model.ExpressionInfo;

/**
 * @author YLF
 * 
 *         ������Ϣ
 * 
 */
public class FaceServer {

	/**
	 * @return ��ȡ���б�����Ϣ
	 */
	public static List<ExpressionInfo> findAllFaceInfo() {
		FaceInfoDao dao = new FaceInfoImp();
		return dao.findAllFaceInfo();
	}

	/**
	 * @param typeId
	 * @return ���ݷ���id��ȡ��Ӧ�ı����
	 */
	public static List<ExpressionInfo> findFaceInfoByTypeId(int typeId) {
		FaceInfoDao dao = new FaceInfoImp();
		return dao.findFaceInfoByTypeId(typeId);
	}

	/**
	 * @param id
	 * @return ����id��ȡ��Ӧ������Ϣ
	 */
	public static ExpressionInfo findFaceInfoById(int id) {
		FaceInfoDao dao = new FaceInfoImp();
		return dao.findFaceInfoById(id);
	}

}
