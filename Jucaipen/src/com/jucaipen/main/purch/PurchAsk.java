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
import com.jucaipen.model.Ask;
import com.jucaipen.model.Contribute;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         购买提问
 */
@SuppressWarnings("serial")
public class PurchAsk extends HttpServlet {
	private String result;
	private String ip;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ip = request.getRemoteAddr();
		String userId = request.getParameter("userId");
		String teacherId = request.getParameter("teacherId");
		String bills = request.getParameter("bills");
		if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isNotNull(teacherId)
						&& StringUtil.isInteger(teacherId)) {
					int tId = Integer.parseInt(teacherId);
					if (StringUtil.isNotNull(bills)
							&& StringUtil.isInteger(bills)) {
						int bs = Integer.parseInt(bills);
						result = purchAnswer(tId, uId, bs);

					}

				}

			}
		} else {
			result = JsonUtil.getRetMsg(1, "userId 参数异常");
		}

		out.println(result);
		out.flush();
		out.close();
	}

	private String purchAnswer(int tId, int uId, int bs) {
		User user = UserServer.findBaseInfoById(uId);
		Account a = AccountSer.findAccountByUserId(uId);
		if (a == null || a.getJucaiBills() < bs) {
			return JsonUtil.getRetMsg(1, "聚财币余额不足");
		}

		Ask ask = new Ask();
		ask.setAskBody("");
		ask.setAskDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		ask.setIp(ip);
		ask.setXnHits(0);
		ask.setUserId(uId);
		ask.setTeacherId(tId);
		

		AccountDetail detail = new AccountDetail();
		detail.setDetailMoney(bs);
		detail.setDetailType(1);
		detail.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detail.setIsDel(0);
		detail.setOrderCode("");
		detail.setRemark("购买提问【" + ask.getAskBody() + "】");
		detail.setState(0);
		detail.setUserId(uId);

		AccountDetail detailInteger = new AccountDetail();
		detailInteger.setDetailMoney(bs);
		detailInteger.setDetailType(0);
		detailInteger.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detailInteger.setIsDel(0);
		detailInteger.setOrderCode("");
		detailInteger.setRemark("购买提问【" + ask.getAskBody() + "】，账户积分+" + bs);
		detailInteger.setState(1);
		detailInteger.setUserId(uId);

		SysAccount sysAccount = SysAccountSer.findAccountInfo();

		SysDetailAccount sysDetailAccount = new SysDetailAccount();
		sysDetailAccount.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		sysDetailAccount.setIp(ip);
		sysDetailAccount.setIsDel(0);
		sysDetailAccount.setOrderId(0);
		sysDetailAccount.setPrice(bs);
		sysDetailAccount.setRecoderType(2);
		sysDetailAccount.setType(10);
		sysDetailAccount.setUserId(uId);
		sysDetailAccount.setRemark("购买提问【" + ask.getAskBody() + "】");

		Contribute contribute = new Contribute();
		contribute.setAllJucaiBills(bs);
		contribute.setFk_id(ask.getId());
		contribute.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		contribute.setTeacherId(tId);
		contribute.setUserId(uId);

		int isSuccess = RollBackUtil.purchAnswer(a, uId, user, sysAccount, bs,
				detail, detailInteger, sysDetailAccount);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "购买成功") : JsonUtil
				.getRetMsg(1, "购买失败");
	}

}
