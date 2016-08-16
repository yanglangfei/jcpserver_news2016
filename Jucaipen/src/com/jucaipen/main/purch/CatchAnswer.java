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
import com.jucaipen.model.Answer;
import com.jucaipen.model.Ask;
import com.jucaipen.model.Contribute;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.AnswerSer;
import com.jucaipen.service.AskSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ���ɻش�
 */
@SuppressWarnings("serial")
public class CatchAnswer extends HttpServlet {
	private String result;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String answerId = request.getParameter("answerId");
		String grade = request.getParameter("grade");
		String ip = request.getRemoteAddr();
		if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isNotNull(answerId)
						&& StringUtil.isInteger(answerId)) {
					int aId = Integer.parseInt(answerId);
					if (StringUtil.isNotNull(grade)
							&& StringUtil.isInteger(grade)) {
						int g = Integer.parseInt(grade);
						result = catchAnswer(aId, uId, g, ip);
					} else {
						result = JsonUtil.getRetMsg(4, "grade �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "answerId �����쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "���л�û��¼");
			}

		} else {
			result = JsonUtil.getRetMsg(1, "userId �����쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String catchAnswer(int aId, int uId, int g, String ip) {
		Answer answer = AnswerSer.findAnswerById(aId);
		int askId = answer.getAskId();
		User user = UserServer.findBaseInfoById(uId);
		Ask ask = AskSer.findAskById(askId);
		int bills = ask.getJucaiBills();
		int teacherId = ask.getTeacherId();
		Account account = AccountSer.findAccountByUserId(uId);
		FamousTeacher teacher = FamousTeacherSer
				.findFamousTeacherById(teacherId);

		AccountDetail accountDetail = new AccountDetail();
		accountDetail.setDetailMoney(bills);
		accountDetail.setDetailType(0);
		accountDetail.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		accountDetail.setIsDel(0);
		accountDetail.setOrderCode("");
		accountDetail.setRemark("���ɡ�" + teacher.getNickName() + "���Ļش�:"
				+ answer.getAnswerBody());
		accountDetail.setState(1);
		accountDetail.setUserId(uId);

		SysAccount sysAccount = SysAccountSer.findAccountInfo();

		Contribute contribute = new Contribute();
		contribute.setAllJucaiBills(bills);
		contribute.setComType(4);
		contribute.setFk_id(aId);
		contribute.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		contribute.setTeacherId(teacherId);
		contribute.setUserId(uId);

		Rebate rebate = new Rebate();
		rebate.setTeacherId(teacherId);
		// �������ͣ�0��ʦ������¼��1ϵͳ�����¼��
		rebate.setType(0);
		rebate.setRebateMoney(bills * teacher.getReturnRate());
		rebate.setFromId(uId);
		rebate.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		rebate.setRemark("�û����ɽ�ʦ�ش���");

		Rebate sysRebate = new Rebate();
		sysRebate.setTeacherId(teacherId);
		// �������ͣ�0��ʦ������¼��1ϵͳ�����¼��
		sysRebate.setType(1);
		sysRebate.setRebateMoney(bills * (1 - teacher.getReturnRate()));
		sysRebate.setFromId(uId);
		sysRebate.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		sysRebate.setRemark("�û����ɽ�ʦ�ش���");

		int isSuccess = RollBackUtil.catchAnswers(account, accountDetail,
				rebate, sysAccount, sysRebate, uId, user, aId, g, bills,
				contribute);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "���ɻش�ɹ�") : JsonUtil
				.getRetMsg(1, "����ʧ��");
	}

}
