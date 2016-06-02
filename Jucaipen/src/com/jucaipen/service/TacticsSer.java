package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.TacticsDao;
import com.jucaipen.daoimp.TacticsImp;
import com.jucaipen.model.Tactics;

/**
 * @author Administrator
 *
 *  ս��
 */
public class TacticsSer{

	/**
	 * @param page
	 * @return ��ȡȫ��ս����Ϣ
	 */
	public static List<Tactics> findAll(int page) {
		TacticsDao dao=new TacticsImp();
		return dao.findAll(page);
	}

	/**
	 * @param id
	 * @return ����id��ȡս����Ϣ
	 */
	public static Tactics findTacticsById(int id) {
		TacticsDao dao=new TacticsImp();
		return dao.findTacticsById(id);
	}

	/**
	 * @param tId
	 * @param page
	 * @return ���ݽ�ʦid��ȡս����Ϣ
	 */
	public static List<Tactics> findTacticsByTeacherId(int tId, int page) {
		TacticsDao dao=new TacticsImp();
		return dao.findTacticsByTeacherId(tId, page);
	}

}
