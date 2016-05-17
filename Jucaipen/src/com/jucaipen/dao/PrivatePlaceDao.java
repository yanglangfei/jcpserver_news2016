package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.PrivatePlace;

public interface PrivatePlaceDao {
	/**
	 * @return   ��ȡ���е�˽ļ��Ϣ
	 */
	public List<PrivatePlace> findAll(int pager);
	/**
	 * @param id
	 * @return   ����id��ѯ˽ļ��ϸ��Ϣ
	 */
	public PrivatePlace findPrivatePlaceById(int id);
	/**
	 * @param isIndex
	 * @return   ��ѯ�Ƿ���ҳ��ʾ��˽ļ��Ϣ
	 */
	public List<PrivatePlace>  findPrivatePlaceByIsIndex(int isIndex);
	/**
	 * @param isTop
	 * @return   ��ѯ�ö���˽ļ��Ϣ
	 */
	public List<PrivatePlace> findPrivatePlaceByIsTop(int isTop);
	/**
	 * @param IsTuijian
	 * @return  ��ѯ�Ƿ��Ƽ���˽ļ��Ϣ
	 */
	public List<PrivatePlace> findPrivatePlaceByIsTuijian(int IsTuijian);

}
