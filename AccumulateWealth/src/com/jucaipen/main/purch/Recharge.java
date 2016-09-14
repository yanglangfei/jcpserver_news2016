package com.jucaipen.main.purch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.main.datautils.RollBackUtil;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 * 
 *         payState 1 δ֧�� 2 ��֧�� 3 ֧��ʧ�� payType 1�������У�ͨ���� 2֧���� 3΢��֧��4�����֧��
 *         5��������(�㸶��)
 */
public class Recharge extends HttpServlet {
	private static final long serialVersionUID = 4058444946640167655L;
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String userId = request.getParameter("userId");
			String jucaiBills = request.getParameter("jucaiBills");
			String orderCode = request.getParameter("orderCode");
			String payState = request.getParameter("payState");
			String payDate = request.getParameter("payDate");
			String payType = request.getParameter("payType");
			String ip = request.getRemoteAddr();
			if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(jucaiBills)
							&& StringUtil.isInteger(jucaiBills)) {
						int bills = Integer.parseInt(jucaiBills);
						if (StringUtil.isNotNull(orderCode)) {
							if (StringUtil.isNotNull(payState)
									&& StringUtil.isInteger(payState)) {
								int pState = Integer.parseInt(payState);
								if (StringUtil.isNotNull(payType)
										&& StringUtil.isInteger(payType)) {
									int type = Integer.parseInt(payType);
									if (pState == 2) {
										if (StringUtil.isNotNull(payDate)) {
											result = initRecharge(uId, bills,
													ip, orderCode, payDate,
													pState, type);
										} else {
											result = JsonUtil.getRetMsg(5,
													"֧��ʱ�䲻��Ϊ��");
										}
									} else {
										result = initRecharge(uId, bills, ip,
												orderCode, payDate, pState,
												type);
									}
								} else {
									result = JsonUtil.getRetMsg(1,
											"payType �����쳣");
								}
							} else {
								result = JsonUtil.getRetMsg(6, "֧��״̬�쳣");
							}

						} else {
							result = JsonUtil.getRetMsg(4, "�����Ų���Ϊ��");
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
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initRecharge(int uId, int bills, String ip,
			String orderCode, String payDate, int pState, int type) {
		Account a = AccountSer.findAccountByUserId(uId);
		AccountDetail detail = new AccountDetail();
		SysAccount account = SysAccountSer.findAccountInfo();
		detail.setDetailMoney(bills);
		detail.setDetailType(0);
		detail.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detail.setIsDel(0);
		detail.setOrderCode(orderCode);
		detail.setRemark("��ֵ�۲Ʊ�");
		detail.setState(0);
		detail.setUserId(uId);

		SysDetailAccount detailAccount = new SysDetailAccount();
		detailAccount.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detailAccount.setIsDel(0);
		detailAccount.setOrderId(0);
		detailAccount.setPrice(bills);
		detailAccount.setRecoderType(1);
		detailAccount.setType(1);
		detailAccount.setIp(ip);
		// 1�������У�ͨ���� 2֧���� 3΢��֧��4�����֧�� 5��������(�㸶��)
		if (type == 1) {
			detailAccount.setRemark("�û�ͨ����ֵ�۲Ʊ�");
		} else if (type == 2) {
			detailAccount.setRemark("�û�֧������ֵ�۲Ʊ�");
		} else if (type == 3) {
			detailAccount.setRemark("�û�΢�ų�ֵ�۲Ʊ�");
		} else if (type == 4) {
			detailAccount.setRemark("�û�����ֵ�۲Ʊ�");
		} else {
			detailAccount.setRemark("�û��㸶����ֵ�۲Ʊ�");
		}
		detailAccount.setUserId(uId);
		int isSuccess = RollBackUtil.recharge(orderCode, pState, payDate, ip,
				bills, a, uId, detail, account, detailAccount, type);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "�˵����³ɹ�") : JsonUtil
				.getRetMsg(1, "�˵�����ʧ��");
	}
}
