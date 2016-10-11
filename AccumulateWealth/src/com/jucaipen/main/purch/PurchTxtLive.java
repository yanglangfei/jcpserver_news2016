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
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Contribute;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.TxtLiveSale;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.TxtLiveSaleSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ��������ֱ�� ����
 */
public class PurchTxtLive extends HttpServlet {
	private static final long serialVersionUID = 7355170506754734899L;
	private String result;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String ip = request.getRemoteAddr();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String userId = request.getParameter("userId");
			String txtLiveId = request.getParameter("txtLiveId");
			String bills = request.getParameter("bills");
			String days=request.getParameter("days");
			if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(txtLiveId)
							&& StringUtil.isInteger(txtLiveId)) {
						int txtId = Integer.parseInt(txtLiveId);
						if (StringUtil.isNotNull(bills)
								&& StringUtil.isInteger(bills)) {
							int b = Integer.parseInt(bills);
							if(StringUtil.isNotNull(days)&&StringUtil.isInteger(days)){
								int d=Integer.parseInt(days);
								result = purchTxtLive(ip, uId, b, txtId,d);
							}else{
								result = JsonUtil.getRetMsg(5, "days �����쳣");
							}
						} else {
							result = JsonUtil.getRetMsg(4, "bills �����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(3, "txtLiveId �����쳣");
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

	private String purchTxtLive(String ip, int uId, int b, int txtId, int d) {
		Account account = AccountSer.findAccountByUserId(uId);
		TextLive txtLive = TxtLiveSer.findTextLiveById(txtId);
		User user = UserServer.findBaseInfoById(uId);
		int teacherId = txtLive.getTeacherId();
		FamousTeacher teacher = FamousTeacherSer
				.findFamousTeacherById(teacherId);
		List<TxtLiveSale> saled = TxtLiveSaleSer.findSaleByUserIdAndTiD(uId, teacher.getId());
		if(b<=0){
			return JsonUtil.getRetMsg(6, "�ݲ�֧�ֹ���");
		}
		
		if(saled!=null){
			for(TxtLiveSale sale : saled){
				if(TimeUtils.isLive(sale.getStartDate(),sale.getEndDate())){
					return JsonUtil.getRetMsg(6, "����ֱ���Ѿ����򣬲����ظ�����");
				}
			}
		}
		if (account == null || account.getJucaiBills() < b) {
			return JsonUtil.getRetMsg(5, "���㣬���ȳ�ֵ");
		}
		
		
		String startDate = TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
		String endDate = TimeUtils.format(TimeUtils.addBaseDay(new Date(), d),
				"yyyy-MM-dd HH:mm:ss");

		AccountDetail accountDetail = new AccountDetail();
		accountDetail.setDetailMoney(b);
		// �������� 0���룬1����
		accountDetail.setDetailType(1);
		// 0�۲Ʊң�1����
		accountDetail.setState(0);
		accountDetail.setOrderCode("");
		accountDetail.setRemark("����" + teacher.getNickName() + "��������ֱ����"
				+ txtLive.getTitle() + "��");
		accountDetail.setIsDel(0);
		accountDetail.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		accountDetail.setUserId(uId);

		AccountDetail accountDetailIntegeral = new AccountDetail();
		accountDetailIntegeral.setDetailMoney(b);
		// �������� 0���룬1����
		accountDetailIntegeral.setDetailType(0);
		// 0�۲Ʊң�1����
		accountDetailIntegeral.setState(1);
		accountDetailIntegeral.setOrderCode("");
		accountDetailIntegeral.setRemark("����" + teacher.getNickName()
				+ "��������ֱ����" + txtLive.getTitle() + "��,����+" + b);
		accountDetailIntegeral.setIsDel(0);
		accountDetailIntegeral.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		accountDetailIntegeral.setUserId(uId);

		TxtLiveSale sale = new TxtLiveSale();
		sale.setUserId(uId);
		sale.setTeacherId(teacherId);
		sale.setOrderCode("");
		sale.setFk_txtId(txtId);
		sale.setStartDate(startDate);
		sale.setEndDate(endDate);
		sale.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

		Contribute contribute = new Contribute();
		contribute.setAllJucaiBills(b);
		contribute.setComType(12);
		contribute.setFk_id(txtId);
		contribute.setTeacherId(teacherId);
		contribute.setUserId(uId);
		contribute.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));

		SysAccount sysAccount = SysAccountSer.findAccountInfo();

		SysDetailAccount detailAccount = new SysDetailAccount();
		detailAccount.setIp(ip);
		detailAccount.setIsDel(0);
		detailAccount.setOrderId(0);
		detailAccount.setPrice(b);

		detailAccount.setRecoderType(2);
		detailAccount.setType(5);

		detailAccount.setRemark("����" + teacher.getNickName() + "��������ֱ����"
				+ txtLive.getTitle() + "��");
		detailAccount.setUserId(uId);
		detailAccount.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));

		Rebate rebate = new Rebate();
		rebate.setTeacherId(teacherId);
		// �������ͣ�0��ʦ������¼��1ϵͳ�����¼��
		rebate.setType(0);
		rebate.setRebateMoney(b * teacher.getReturnRate());
		rebate.setFromId(uId);
		rebate.setRemark("�û���������ֱ������");
		rebate.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

		Rebate sysRebate = new Rebate();
		sysRebate.setTeacherId(teacherId);
		// �������ͣ�0��ʦ������¼��1ϵͳ�����¼��
		sysRebate.setType(1);
		sysRebate.setRebateMoney(b * (1 - teacher.getReturnRate()));
		sysRebate.setFromId(uId);
		sysRebate.setRemark("�û���������ֱ������");
		sysRebate.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));

		int isSuccess = RollBackUtil.purchTxtLive(account, accountDetail,
				accountDetailIntegeral, uId, b, sale, contribute, sysAccount,
				detailAccount, user, rebate, sysRebate);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "��������ֱ���ɹ�") : JsonUtil
				.getRetMsg(1, "��������ֱ��ʧ��");
	}

}