package com.jucaipen.service;
import java.util.List;
import com.jucaipen.dao.ChargeOrderDao;
import com.jucaipen.daoimp.ChargeOrderImp;
import com.jucaipen.model.ChargeOrder;
/**
 * @author Administrator
 * ��ֵ��¼
 */
public class ChargeOrderSer {

	/**
	 * @param id
	 * @return  ����id��ȡ��ֵ��Ϣ
	 */
	public static ChargeOrder findOrderById(int id) {
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.findOrderById(id);
	}

	/**
	 * @param userId
	 * @param page
	 * @return �����û�id��ȡ��ֵ��¼
	 */
	public static List<ChargeOrder> findOrderByUid(int userId, int page) {
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.findOrderByUid(userId, page);
	}
	
	public static List<ChargeOrder> findOrderByUidAndState(int uId,int state,int page){
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.findOrderByUidAndState(uId, state, page);
	}
	
	public static int deleteOrder(int id){
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.deleteOrder(id);
	}

	/**
	 * @param order
	 * @return ��ӳ�ֵ��¼
	 */
	public static int addOrder(ChargeOrder order) {
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.addOrder(order);
	}
	
	/**
	 * @param orderCode
	 * @param state
	 * @param payDate
	 * @param ip
	 * @return  �޸ĳ�ֵ����״̬
	 */
	public static int updatePayState(String orderCode,int state,String payDate,String ip){
		ChargeOrderDao dao=new ChargeOrderImp();
		return dao.updatePayState(orderCode, state, payDate, ip);
	}

}
