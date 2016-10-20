package com.jucaipen.main.purch;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.derby.tools.sysinfo;

import com.jucaipen.main.datautils.RollBackUtil;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Contribute;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Guardian;
import com.jucaipen.model.LiveDetailSale;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.SaleRecoder;
import com.jucaipen.model.SiteConfig;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.TxtLiveDetails;
import com.jucaipen.model.User;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.LiveDetailSaleSer;
import com.jucaipen.service.SaleRecoderSer;
import com.jucaipen.service.SiteConfigSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.TxtLiveDetaileSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;
/**
 * @author Administrator
 * 
 *         ��������ֱ�� ������Ϣ
 */
public class PurchTxtDetails extends HttpServlet {
	private static final long serialVersionUID = 6893212497317566219L;
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
			String txtDetailId = request.getParameter("txtDetailId");
			String bills = request.getParameter("bills");
			if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(txtDetailId)
							&& StringUtil.isInteger(txtDetailId)) {
						int detailId = Integer.parseInt(txtDetailId);
						if (StringUtil.isNotNull(bills)
								&& StringUtil.isInteger(bills)) {
							int b = Integer.parseInt(bills);
							result = purchTxtDetails(ip, uId, b, detailId);
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
		out.print(result);
		out.flush();
		out.close();
	}

	private String purchTxtDetails(String ip, int uId, int b, int detailId) {
		Account account = AccountSer.findAccountByUserId(uId);
		TxtLiveDetails liveDetail = TxtLiveDetaileSer
				.findTextDetaileById(detailId);
		User user = UserServer.findBaseInfoById(uId);
		int liveId = liveDetail.getFk_liveId();
		TextLive textLive = TxtLiveSer.findTextLiveById(liveId);
		int teacherId = textLive.getTeacherId();
		FamousTeacher teacher = FamousTeacherSer
				.findFamousTeacherById(teacherId);
		LiveDetailSale detailSale = LiveDetailSaleSer
				.findSaleByUserIdAndTxtIdAndDetailId(uId, detailId);
		
		
		Guardian gurdian = GuardianSer.findIsGuardian(teacherId, uId);
		if(gurdian!=null){
			return JsonUtil.getRetMsg(8, "�Ѿ���Ϊ��ʦ�ػ��ߣ�����Ҫ����");
		}
		
		if (detailSale != null) {
			return JsonUtil.getRetMsg(6, "ֱ����ϸ�Ѿ����򣬲����ظ�����");
		}
		
		if(b<=0){
			return JsonUtil.getRetMsg(6,"�ݲ�֧�ֹ���");
		}
		
		SiteConfig config = SiteConfigSer.findSiteConfig();
		int count=config.getLiveDetailCount();
		int num=SaleRecoderSer.findSaleCountByRecoder(uId);
		if(num>=count){
			return JsonUtil.getRetMsg(10,"�Կ��������꣬��Ҫ��ͨ�ػ��鿴����");
		}
		
		if (account == null || account.getJucaiBills() < b) {
			return JsonUtil.getRetMsg(5, "���㣬���ȳ�ֵ");
		}

		AccountDetail accountDetail = new AccountDetail();
		accountDetail.setDetailMoney(b);
		// �������� 0���룬1����
		accountDetail.setDetailType(1);
		// 0�۲Ʊң�1����
		accountDetail.setState(0);
		accountDetail.setOrderCode("");
		accountDetail.setRemark("����" + teacher.getNickName() + "����ֱ����"
				+ liveDetail.getBodys() + "���Ĺ۵�");
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
				+ "����ֱ����" + liveDetail.getBodys() + "���Ĺ۵�,����+" + b);
		accountDetailIntegeral.setIsDel(0);
		accountDetailIntegeral.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		accountDetailIntegeral.setUserId(uId);

		LiveDetailSale sale = new LiveDetailSale();
		sale.setUserId(uId);
		sale.setTeacherId(teacherId);
		sale.setOrderCode("");
		sale.setLiveDetailId(detailId);
		sale.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

		Contribute contribute = new Contribute();
		contribute.setAllJucaiBills(b);
		contribute.setComType(8);
		contribute.setFk_id(detailId);
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

		detailAccount.setRemark("����" + teacher.getNickName() + "����ֱ����"
				+ liveDetail.getBodys() + "���Ĺ۵�");
		detailAccount.setUserId(uId);
		detailAccount.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		
		
		SaleRecoder recoder=new SaleRecoder();
		recoder.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		recoder.setGuandianId(detailId);
		recoder.setIsDel(0);
		recoder.setLiveId(0);
		recoder.setReadCount(1);
		recoder.setUserId(uId);
		recoder.setType(0);
		recoder.setRemark("�û��Կ�ֱ��");

		Rebate rebate = new Rebate();
		rebate.setTeacherId(teacherId);
		// �������ͣ�0��ʦ������¼��1ϵͳ�����¼��
		rebate.setType(0);
		rebate.setRebateMoney(b * teacher.getReturnRate());
		rebate.setFromId(uId);
		rebate.setRemark("�û�����ֱ���۵㷵��");
		rebate.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

		Rebate sysRebate = new Rebate();
		sysRebate.setTeacherId(teacherId);
		// �������ͣ�0��ʦ������¼��1ϵͳ�����¼��
		sysRebate.setType(1);
		sysRebate.setRebateMoney(b * (1 - teacher.getReturnRate()));
		sysRebate.setFromId(uId);
		sysRebate.setRemark("�û�����ֱ���۵㷵��");
		sysRebate.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));

		int isSuccess = RollBackUtil.purchTxtDetail(user, b, sysAccount,
				rebate, sysRebate, sale, account, accountDetail,
				accountDetailIntegeral, uId, detailAccount, contribute,recoder);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "����ֱ���۵�ɹ�") : JsonUtil
				.getRetMsg(1, "����ֱ���۵�ʧ��");
	}

}
