package com.jucaipen.service;

import java.util.List;

import com.jucaipen.dao.EquityDao;
import com.jucaipen.daoimp.EquityImp;
import com.jucaipen.model.Equity;

/**
 * @author ylf
 * 
 *         ��Ȩ������
 */
public class EquityServer {
	/**
	 * @return  ��ȡ���й�Ȩ��Ϣ
	 */
	public static List<Equity> findAll(int pager) {
		EquityDao dao = new EquityImp();
		return dao.findAll(pager);
	}
	/**
	 * @return  ��ȡ��ҳ��Ȩ��Ϣ
	 */
	public static List<Equity> findIndex(){
		EquityDao dao=new EquityImp();
		return dao.findIndexEquity();
	}
	/**
	 * @param id
	 * @return  ����id��ȡָ���Ĺ�Ȩ��Ϣ
	 */
	public static Equity findEquity(int id){
		EquityDao dao=new EquityImp();
		return dao.findEquity(id);
	}
	/**
	 * @param istop
	 * @return  ��ȡ�ö���Ȩ��Ϣ
	 */
	public static List<Equity> findTopEquity(int istop){
		EquityDao dao=new EquityImp();
		return dao.findByTop(istop);
	}
	/**
	 * @param isRecom
	 * @return  ��ȡ�Ƽ��Ĺ�Ȩ��Ϣ
	 */
	public static List<Equity> findRecommenEquity(int isRecom,int pager){
		EquityDao dao=new EquityImp();
		return dao.frindByRecomment(isRecom,pager);
	}

}
