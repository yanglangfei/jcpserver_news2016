package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.ChargeOrder;
import com.jucaipen.service.AccountDetailSer;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.ChargeOrderSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ��ֵ payType 1 ͨ�� 2 ֧���� 5 �㸶�� payState 1 δ֧�� 2 ��֧�� 3 ֧��ʧ��
 */
@SuppressWarnings("serial")
public class Recharge extends HttpServlet {
	private String result;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String payType = request.getParameter("payType");
		String jucaiBills = request.getParameter("jucaiBills");
		String orderCode = request.getParameter("orderCode");
		String payState = request.getParameter("payState");
		String payDate = request.getParameter("payDate");
		String ip = request.getRemoteAddr();
		if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isNotNull(jucaiBills)
						&& StringUtil.isInteger(jucaiBills)) {
					int bills = Integer.parseInt(jucaiBills);
					if (StringUtil.isNotNull(payType)
							&& StringUtil.isInteger(payType)) {
						int pType = Integer.parseInt(payType);
						if (StringUtil.isNotNull(orderCode)) {
							if (StringUtil.isNotNull(payState)
									&& StringUtil.isInteger(payState)) {
								int pState = Integer.parseInt(payState);
								if (pState == 2) {
									if (StringUtil.isNotNull(payDate)) {
										result = initRecharge(uId, bills, ip,
												pType, orderCode, payDate,
												pState);
									} else {
										result = JsonUtil.getRetMsg(5,
												"֧��ʱ�䲻��Ϊ��");
									}
								}
								result = initRecharge(uId, bills, ip, pType,
										orderCode, payDate, pState);
							} else {
								result = JsonUtil.getRetMsg(6, "֧��״̬�쳣");
							}

						} else {
							result = JsonUtil.getRetMsg(4, "�����Ų���Ϊ��");
						}
					} else {
						result = JsonUtil.getRetMsg(2, "payType �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "jucaiBills �����쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "�û���û��¼");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "userId �����쳣");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initRecharge(int uId, int bills, String ip, int pType,
			String orderCode, String payDate, int pState) {
		ChargeOrder order = new ChargeOrder();
		order.setUserId(uId);
		order.setChargeMoney(bills);
		order.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		order.setIp(ip);
		order.setIsDel(0);
		order.setOrderCode(orderCode);
		order.setOrderState(pState);
		if (pState == 2) {
			order.setPayDate(payDate);
		}
		order.setPayType(pType);
		int isSuccess = ChargeOrderSer.addOrder(order);
		if (isSuccess == 1) {
			// ���¾۲Ʊ���Ϣ�˵� �� �˵���ϸ����Ϣ
			Account a = AccountSer.findAccountByUserId(uId);
			int isAdd;
			int isA = 0;
			if (a == null) {
				Account account = new Account();
				account.setIntegeral(0);
				account.setJucaiBills(bills);
				account.setUserId(uId);
				isAdd = AccountSer.addAccount(account);
			} else {
				isAdd = AccountSer.updateBills(uId, bills + a.getJucaiBills());
			}
			if (isAdd == 1) {
				AccountDetail detail = new AccountDetail();
				detail.setDetailMoney(bills);
				detail.setDetailType(0);
				detail.setInsertDate(TimeUtils.format(new Date(),
						"yyyy-MM-dd HH:mm:ss"));
				detail.setIsDel(0);
				detail.setOrderCode(orderCode);
				detail.setRemark("��ֵ�۲Ʊ�");
				detail.setState(0);
				detail.setUserId(uId);
				isA = AccountDetailSer.addDetails(detail);
			}
			return isA == 1 ? JsonUtil.getRetMsg(0, "�˵����³ɹ�") : JsonUtil
					.getRetMsg(1, "�˵�����ʧ��");

		}
		return JsonUtil.getRetMsg(1, "�˵�����ʧ��");
	}
}
