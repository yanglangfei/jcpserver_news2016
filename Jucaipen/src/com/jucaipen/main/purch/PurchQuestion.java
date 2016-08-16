package com.jucaipen.main.purch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.main.datautils.RollBackUtil;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.Answer;
import com.jucaipen.model.AnswerSale;
import com.jucaipen.model.Ask;
import com.jucaipen.model.Contribute;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.AnswerSer;
import com.jucaipen.service.AskSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         �����ʴ�
 */
@SuppressWarnings("serial")
public class PurchQuestion extends HttpServlet {
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
		String askId = request.getParameter("askId");
		String bills = request.getParameter("bills");
		if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isNotNull(askId) && StringUtil.isInteger(askId)) {
					int aId = Integer.parseInt(askId);
					if (StringUtil.isNotNull(bills)
							&& StringUtil.isInteger(bills)) {
						int bs = Integer.parseInt(bills);
						result = purchAnswer(aId, uId, bs);

					} else {
						result = JsonUtil.getRetMsg(4, "bills �����쳣");
					}

				} else {
					result = JsonUtil.getRetMsg(3, "askId �����쳣");
				}

			} else {
				result = JsonUtil.getRetMsg(2, "���л�û��¼");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "userId �����쳣");
		}

		out.println(result);
		out.flush();
		out.close();
	}

	private String purchAnswer(int aId, int uId, int bs) {
		boolean catchAnswer = false;
		User user = UserServer.findBaseInfoById(uId);
		Account a = AccountSer.findAccountByUserId(uId);
		Ask ask = AskSer.findAskById(aId);
		int teacherId = ask.getTeacherId();
		List<Answer> answers = AnswerSer.findAnswerByAskId(aId);
		if (answers != null) {
			for (Answer answer : answers) {
				int isCatch = answer.getIsCatch();
				if (isCatch == 1) {
					catchAnswer = true;
				}
			}
		}
		if (!catchAnswer) {
			return JsonUtil.getRetMsg(2, "�ش�û�б����ɣ����ܽ��й���");
		}
		if (a == null || a.getJucaiBills() < bs) {
			return JsonUtil.getRetMsg(1, "�۲Ʊ�����");
		}

		AnswerSale sale = new AnswerSale();
		sale.setUserId(uId);
		sale.setTeacherId(teacherId);
		sale.setOrderCode("");
		sale.setAskId(aId);
		sale.setInsetDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

		AccountDetail detail = new AccountDetail();
		detail.setDetailMoney(bs);
		detail.setDetailType(1);
		detail.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detail.setIsDel(0);
		detail.setOrderCode("");
		detail.setRemark("��" + user.getNickName() + "���������⡶" + ask.getAskBody()
				+ "��,�����ţ�" + aId);
		detail.setState(0);
		detail.setUserId(uId);

		AccountDetail detailInteger = new AccountDetail();
		detailInteger.setDetailMoney(bs);
		detailInteger.setDetailType(0);
		detailInteger.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detailInteger.setIsDel(0);
		detailInteger.setOrderCode("");
		detailInteger.setRemark("��" + user.getNickName() + "���������⡶"
				+ ask.getAskBody() + "��,������:" + aId + ",�˻�����+" + bs);
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
		sysDetailAccount.setType(7);
		sysDetailAccount.setUserId(uId);
		sysDetailAccount.setRemark("��" + user.getNickName() + "���������⡶"
				+ ask.getAskBody() + "��,������:" + aId);

		Contribute contribute = new Contribute();
		contribute.setAllJucaiBills(bs);
		contribute.setFk_id(ask.getId());
		contribute.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		contribute.setTeacherId(teacherId);
		contribute.setUserId(uId);

		Rebate rebate = new Rebate();
		rebate.setTeacherId(teacherId);
		// �������ͣ�0��ʦ������¼��1ϵͳ�����¼��
		rebate.setType(0);
		rebate.setRebateMoney(bs);
		rebate.setFromId(uId);
		rebate.setRemark("�û������ʴ���");
		rebate.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

		int isSuccess = RollBackUtil.purchQuestion(a, uId, user, sysAccount,
				bs, detail, detailInteger, sysDetailAccount, sale, rebate);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "����ɹ�") : JsonUtil
				.getRetMsg(1, "����ʧ��");
	}

}
