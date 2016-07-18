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
 *        
 *         payState 1 未支付 2 已支付 3 支付失败
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
					if (StringUtil.isNotNull(orderCode)) {
						if (StringUtil.isNotNull(payState)
								&& StringUtil.isInteger(payState)) {
							int pState = Integer.parseInt(payState);
							if (pState == 2) {
								if (StringUtil.isNotNull(payDate)) {
									result = initRecharge(uId, bills, ip,
											orderCode, payDate, pState);
								} else {
									result = JsonUtil.getRetMsg(5, "支付时间不能为空");
								}
							} else {
								result = initRecharge(uId, bills, ip,
										orderCode, payDate, pState);
							}
						} else {
							result = JsonUtil.getRetMsg(6, "支付状态异常");
						}

					} else {
						result = JsonUtil.getRetMsg(4, "订单号不能为空");
					}

				} else {
					result = JsonUtil.getRetMsg(1, "jucaiBills 参数异常");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "用户还没登录");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "userId 参数异常");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initRecharge(int uId, int bills, String ip,
			String orderCode, String payDate, int pState) {
		int isSuccess = ChargeOrderSer.updatePayState(orderCode, pState,
				payDate, ip);
		if (isSuccess == 1) {
			// 更新聚财币信息账单 和 账单详细表信息
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
				detail.setRemark("充值聚财币");
				detail.setState(0);
				detail.setUserId(uId);
				isA = AccountDetailSer.addDetails(detail);
			}
			return isA == 1 ? JsonUtil.getRetMsg(0, "账单更新成功") : JsonUtil
					.getRetMsg(1, "账单更新失败");

		}
		return JsonUtil.getRetMsg(1, "账单更新失败");
	}
}
