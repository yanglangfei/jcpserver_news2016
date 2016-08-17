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
import com.jucaipen.model.Contribute;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.IdeaSale;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.IdeaSaleServer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ������־�۵�
 */
@SuppressWarnings("serial")
public class PurchLogs extends HttpServlet {
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
			String logId = request.getParameter("logId");
			String bills = request.getParameter("bills");
			String ip = request.getRemoteAddr();
			if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(logId)
							&& StringUtil.isInteger(logId)) {
						int lId = Integer.parseInt(logId);
						if (StringUtil.isNotNull(bills)
								&& StringUtil.isInteger(bills)) {
							int b = Integer.parseInt(bills);
							result = purchLogs(uId, lId, b, ip);
						} else {
							result = JsonUtil.getRetMsg(4, "bills �����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(3, "logId �����쳣");
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

	private String purchLogs(int uId, int lId, int b, String ip) {
		Account acount = AccountSer.findAccountByUserId(uId);
		HotIdea idea = HotIdeaServ.findIdeaById(lId);
		int teacherId = idea.getTeacherId();
		User user = UserServer.findBaseInfoById(uId);
		FamousTeacher teacher = FamousTeacherSer.findTeacherBaseInfo(teacherId);
		if (acount == null || acount.getJucaiBills() < b) {
			return JsonUtil.getRetMsg(1, "���㣬���ȳ�ֵ");
		}
		IdeaSale sale = IdeaSaleServer.findTxtLiveSaleByUiDAndLiveId(uId, lId);
		if (sale != null) {
			return JsonUtil.getRetMsg(2, "��ʦ�۵��Ѿ�����");
		}

		IdeaSale ideaSale = new IdeaSale();
		ideaSale.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		ideaSale.setLogId(lId);
		ideaSale.setUserId(uId);
		ideaSale.setTeacherId(teacherId);
		ideaSale.setOrderCode("");

		AccountDetail accountDetail = new AccountDetail();
		accountDetail.setDetailMoney(b);
		accountDetail.setOrderCode("");
		// �������� 0���룬1����
		accountDetail.setDetailType(1);
		// 0�۲Ʊң�1����
		accountDetail.setState(0);
		accountDetail.setRemark("������" + teacher.getNickName() + "������־��"
				+ idea.getTitle() + "��");
		accountDetail.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		accountDetail.setIsDel(0);
		accountDetail.setUserId(uId);

		AccountDetail accountDetailIntegeral = new AccountDetail();
		accountDetailIntegeral.setDetailMoney(b);
		accountDetailIntegeral.setOrderCode("");
		// �������� 0���룬1����
		accountDetailIntegeral.setDetailType(0);
		// 0�۲Ʊң�1����
		accountDetailIntegeral.setState(1);
		accountDetailIntegeral.setRemark("������" + teacher.getNickName()
				+ "������־��" + idea.getTitle() + "������+" + b);
		accountDetailIntegeral.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		accountDetailIntegeral.setIsDel(0);
		accountDetailIntegeral.setUserId(uId);

		Contribute contribute = new Contribute();
		contribute.setAllJucaiBills(b);
		contribute.setComType(8);
		contribute.setFk_id(lId);
		contribute.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		contribute.setTeacherId(teacherId);
		contribute.setUserId(uId);
		SysAccount sysAccount = SysAccountSer.findAccountInfo();

		SysDetailAccount detailAccount = new SysDetailAccount();
		detailAccount.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detailAccount.setIp(ip);
		detailAccount.setIsDel(0);
		detailAccount.setOrderId(0);
		detailAccount.setPrice(b);
		detailAccount.setRecoderType(2);
		detailAccount.setRemark("������" + teacher.getNickName() + "������־��"
				+ idea.getTitle() + "��");
		detailAccount.setType(6);
		detailAccount.setUserId(uId);

		Rebate rebate = new Rebate();
		rebate.setTeacherId(teacherId);
		// �������ͣ�0��ʦ������¼��1ϵͳ�����¼��
		rebate.setType(0);
		rebate.setRebateMoney(b * teacher.getReturnRate());
		rebate.setFromId(uId);
		rebate.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		rebate.setRemark("�û�������־����");

		Rebate sysRebate = new Rebate();
		sysRebate.setTeacherId(teacherId);
		// �������ͣ�0��ʦ������¼��1ϵͳ�����¼��
		sysRebate.setType(1);
		sysRebate.setRebateMoney(b * (1 - teacher.getReturnRate()));
		sysRebate.setFromId(uId);
		sysRebate.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		sysRebate.setRemark("�û�������־����");
		int isSuccess = RollBackUtil.purchTeacherLogs(ideaSale, accountDetail,
				accountDetailIntegeral, acount, b, uId, user, contribute,
				sysAccount, detailAccount, rebate, sysRebate);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "�۵㹺��ɹ�") : JsonUtil
				.getRetMsg(1, "�۵㹺��ʧ��");
	}

}
