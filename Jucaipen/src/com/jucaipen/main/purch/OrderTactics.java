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
import com.jucaipen.model.Rebate;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.Tactics;
import com.jucaipen.model.TacticsSale;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.TacticsSaleSer;
import com.jucaipen.service.TacticsSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator ����ս����Ϣ
 */
@SuppressWarnings("serial")
public class OrderTactics extends HttpServlet {
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
		if(isDevice==HeaderUtil.PHONE_APP){
			String userId = request.getParameter("userId");
			String tacticeId = request.getParameter("tacticsId");
			String days = request.getParameter("days");
			String bills = request.getParameter("bills");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
						if (StringUtil.isNotNull(tacticeId)) {
							if (StringUtil.isInteger(tacticeId)) {
								int tId = Integer.parseInt(tacticeId);
									if (StringUtil.isNotNull(days)
											&& StringUtil.isInteger(days)) {
										int d = Integer.parseInt(days);
										if (StringUtil.isNotNull(bills)
												&& StringUtil.isInteger(bills)) {
											int b = Integer.parseInt(bills);
											result = orderTactics(uId, tId, d, b);
										} else {
											result = JsonUtil.getRetMsg(7,
													"bills �����쳣");
										}
									} else {
										result = JsonUtil.getRetMsg(6, "days �����쳣");
									}
							} else {
								result = JsonUtil.getRetMsg(5,
										"tacticeId �������ָ�ʽ���쳣��");
							}
						} else {
							result = JsonUtil.getRetMsg(4, "tacticeId ��������Ϊ��");
						}
					} else {
						result = JsonUtil.getRetMsg(3, "�û���û��¼");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "userId �������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
			}
		}else{
			result=StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String orderTactics(int uId, int tId, int days,
			int bills) {
		String startDate;
		String endDate = null;
		FamousTeacher teacher;
		User user = UserServer.findBaseInfoById(uId);
		Account account = AccountSer.findAccountByUserId(uId);
		if(bills<=0){
			return JsonUtil.getRetMsg(6,"�ݲ�֧�ֶ���");
		}
		
		if (account == null||account.getJucaiBills()<bills) {
			return JsonUtil.getRetMsg(3, "�˻��۲ƱҲ��㣬���ֵ");
		}
		
		// �Ƿ��Ѿ�����
		TacticsSale saleMain = TacticsSaleSer.findTacticsIsSale(uId, tId);
		if (saleMain != null&&TimeUtils.isLive(saleMain.getStartDate(), saleMain.getEndDate())) {
			// ����
			return JsonUtil.getRetMsg(5, "��ǰ�û��ڶ���ʱ��Σ����ܼ�������");
		} else {
			startDate = TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
			endDate = TimeUtils.format(TimeUtils.addBaseDay(new Date(), days),
					"yyyy-MM-dd HH:mm:ss");
		}

		Tactics tactics = TacticsSer.findTacticsById(tId);

		TacticsSale sale = new TacticsSale();
		sale.setUserId(uId);
		sale.setTacticsId(tId);
		sale.setIp(ip);
		sale.setStartDate(startDate);
		sale.setEndDate(endDate);
		sale.setTelPhone(user.getMobileNum());
		sale.setIsStop(0);
		sale.setRemark("���ĳɹ�");
		sale.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		// ����ս����Ϣ

		// �˻���ϸ �۲Ʊ�
		AccountDetail detail = new AccountDetail();
		// ����
		AccountDetail detailInteger = new AccountDetail();
		detail.setOrderCode("");
		detailInteger.setOrderCode("");
		detail.setDetailMoney(bills);
		detailInteger.setDetailMoney(bills);
		// �������� 0���룬1����
		detail.setDetailType(1);
		detailInteger.setDetailType(0);
		// 0�۲Ʊң�1����
		detail.setState(0);
		detailInteger.setState(1);
		detail.setRemark("����ս����" + tactics.getTitle() + "����ʱ�䣺"+(days/30)+"����");
		detailInteger.setRemark("����ս����" + tactics.getTitle() + "����ʱ�䣺"+(days/30)+"���£��˻�����+"
				+ bills);
		detail.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detailInteger.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detail.setIsDel(0);
		detailInteger.setIsDel(0);
		detail.setUserId(uId);
		detailInteger.setUserId(uId);

		teacher = FamousTeacherSer.findTeacherBaseInfo(tactics.getTeacherId());

		Rebate teacherRebate = new Rebate();
		teacherRebate.setType(0);
		teacherRebate.setTeacherId(tId);
		teacherRebate.setRebateMoney((teacher.getReturnRate() * bills));
		teacherRebate.setFromId(uId);
		teacherRebate.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		teacherRebate.setRemark("�û�����ս������");

		Rebate sysRebate = new Rebate();
		sysRebate.setType(1);
		sysRebate.setTeacherId(teacher.getId());
		sysRebate.setRebateMoney(((1 - teacher.getReturnRate()) * bills));
		sysRebate.setFromId(uId);
		sysRebate.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		sysRebate.setRemark("�û�����ս������");

		Contribute contribute = new Contribute();
		contribute.setAllJucaiBills(bills);
		contribute.setComType(10);
		contribute.setFk_id(tId);
		contribute.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		contribute.setUserId(uId);
		contribute.setTeacherId(teacher.getId());

		SysAccount sysAccount = SysAccountSer.findAccountInfo();

		SysDetailAccount sysDetailAccount = new SysDetailAccount();
		sysDetailAccount.setUserId(uId);
		// ��¼���ͣ�1�û���ֵ��2ϵͳ���ͣ�3���û����֣�4����Ʒ���ѣ�5��ֱ���۵㣬6������־��7�������ʴ�8����ͨ�ػ���9������ս����10��������Ƶ��11����ר����12��ϵͳ���Ͳ�Ʒ
		// 13,����
		sysDetailAccount.setType(9);
		sysDetailAccount.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		sysDetailAccount.setIsDel(0);
		sysDetailAccount.setIp(ip);
		sysDetailAccount.setOrderId(0);
		sysDetailAccount.setPrice(bills);
		// 1���룬2֧��
		sysDetailAccount.setRecoderType(2);
		sysDetailAccount.setRemark("����ս����" + tactics.getTitle() + "����ʱ�䣺"
				+ (days/30)+"����");


		int isSuccess = RollBackUtil.orderTactisc(sale, account, bills, uId,
				detail, detailInteger, teacherRebate, sysRebate, contribute,
				sysAccount, sysDetailAccount, user);

		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "���ĳɹ�") : JsonUtil
				.getRetMsg(1, "����ʧ��");
	}

}
