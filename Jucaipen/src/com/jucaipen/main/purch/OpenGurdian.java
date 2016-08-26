package com.jucaipen.main.purch;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
import com.jucaipen.model.Guardian;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ��ͨ�ػ�
 */
@SuppressWarnings("serial")
public class OpenGurdian extends HttpServlet {
	private String result;
	private String ip;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ip = request.getRemoteAddr();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String days = request.getParameter("days");
			String userId = request.getParameter("userId");
			String teacherId = request.getParameter("teacherId");
			String bills = request.getParameter("bills");
			if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(teacherId)
							&& StringUtil.isInteger(teacherId)) {
						int tId = Integer.parseInt(teacherId);
						if (StringUtil.isNotNull(days)
								&& StringUtil.isInteger(days)) {
							int d = Integer.parseInt(days);
							if (StringUtil.isNotNull(bills)
									&& StringUtil.isInteger(bills)) {
								int b = Integer.parseInt(bills);
								result = openGurdian(uId, tId, d, b);
							} else {
								result = JsonUtil.getRetMsg(3, "bill �����쳣");
							}

						} else {
							result = JsonUtil.getRetMsg(1, "days �����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(2, "teacherId �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "�û���¼ʧ��");
				}

			} else {
				result = JsonUtil.getRetMsg(4, "userId �����쳣");
			}

		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String openGurdian(int uId, int tId, int d, int b) {
		// �۲Ʊ��Ƿ��㹻
		int gurdianId = 0;
		Account account = AccountSer.findAccountByUserId(uId);
		if(b<=0){
			return JsonUtil.getRetMsg(6, "�ݲ�֧�ֿ�ͨ");
		}
		
		if (account == null||account.getJucaiBills() < b) {
			return JsonUtil.getRetMsg(3, "�˻��۲ƱҲ��㣬���ֵ");
		}
		// �Ƿ�ͨ�ػ�
		String startDate;
		String endDate = null;
		Guardian guardianM = GuardianSer.findIsGuardian(tId, uId);
		if (guardianM != null) {
			// ��Լ
			gurdianId = guardianM.getId();
			startDate = guardianM.getStartDate();
			try {
				Date endD = TimeUtils.parse(guardianM.getEndDate(),
						"yyyy-MM-dd HH:mm:ss");
				endDate = TimeUtils.format(TimeUtils.addBaseDay(endD, d),
						"yyyy-MM-dd HH:mm:ss");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			startDate = TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
			endDate = TimeUtils.format(TimeUtils.addBaseDay(new Date(), d),
					"yyyy-MM-dd HH:mm:ss");
		}

		FamousTeacher teacher = FamousTeacherSer.findTeacherBaseInfo(tId);
		User user = UserServer.querryIntegeralByUid(uId);

		Guardian guardian = new Guardian();
		guardian.setIp(ip);
		guardian.setTeacherId(tId);
		guardian.setUserId(uId);
		guardian.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		guardian.setStartDate(startDate);
		guardian.setEndDate(endDate);
		guardian.setState(0);

		// ��ʦ����
		Rebate rebate = new Rebate();
		rebate.setRebateMoney((b * teacher.getReturnRate()));
		rebate.setFromId(uId);
		rebate.setTeacherId(tId);
		rebate.setRemark("�û���ͨ�ػ�����");
		rebate.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		rebate.setType(0);

		// ϵͳ����
		Rebate sysRebate = new Rebate();
		sysRebate.setRebateMoney(b * (1 - teacher.getReturnRate()));
		sysRebate.setFromId(uId);
		sysRebate.setTeacherId(tId);
		sysRebate.setRemark("�û���ͨ�ػ�����");
		sysRebate.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		sysRebate.setType(1);

		AccountDetail detailJ = new AccountDetail();
		detailJ.setDetailMoney(b);
		detailJ.setRemark("��Ϊ��" + teacher.getNickName() + "�����ػ��ߡ�" + d + "����");
		detailJ.setDetailType(1);
		detailJ.setState(0);
		detailJ.setOrderCode("");
		detailJ.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detailJ.setIsDel(0);
		detailJ.setUserId(uId);

		AccountDetail detailIntegeral = new AccountDetail();
		detailIntegeral.setDetailMoney(b);
		detailIntegeral.setRemark("��Ϊ��" + teacher.getNickName() + "�����ػ��ߡ�" + d
				+ "���죬�˻�����+" + b);
		detailIntegeral.setDetailType(0);
		detailIntegeral.setState(1);
		detailIntegeral.setOrderCode("");
		detailIntegeral.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detailIntegeral.setIsDel(0);
		detailIntegeral.setUserId(uId);

		SysAccount account2 = SysAccountSer.findAccountInfo();

		SysDetailAccount detailAccount = new SysDetailAccount();
		detailAccount.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detailAccount.setIsDel(0);
		detailAccount.setOrderId(0);
		detailAccount.setPrice(b);
		detailAccount.setRecoderType(2);
		detailAccount.setType(8);
		detailAccount.setIp(ip);
		detailAccount.setRemark("��Ϊ��" + teacher.getNickName() + "�����ػ��ߡ�" + d
				+ "����");
		detailAccount.setUserId(uId);

		Contribute contribute = new Contribute();
		contribute.setAllJucaiBills(b);
		contribute.setComType(3);
		contribute.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		contribute.setTeacherId(tId);
		contribute.setUserId(uId);
		contribute.setFk_id(0);

		int isSuccess = RollBackUtil.synchrGuardian(guardian, rebate, account,
				b, detailJ, detailIntegeral, uId, user, account2,
				detailAccount, contribute, teacher, sysRebate, gurdianId);
		return isSuccess == 1 ? JsonUtil.getOpenGurdianSuccess(guardian)
				: JsonUtil.getRetMsg(1, "��ͨ�ػ�ʧ��");
	}

}
