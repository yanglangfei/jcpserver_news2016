package com.jucaipen.main.purch;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.main.datautils.RollBackUtil;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.ChargeOrder;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.ChargeOrderSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author ���ʷ� ֧���ص��ӿ�
 */
public class RechargeResult extends HttpServlet {
	private static final long serialVersionUID = -7946065445513185182L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Log(request);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

	private void Log(HttpServletRequest request) throws ParseException {
		Enumeration<String> names = request.getParameterNames();
		System.out.println("============================================");
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + "=" + value);
		}
		String payResult = request.getParameter("payResult");
		String payAmount = request.getParameter("payAmount");
		String orderNo = request.getParameter("orderNo");
		String payDatetime = request.getParameter("payDatetime");
		String orderDatetime = request.getParameter("orderDatetime");
		int payRes = Integer.parseInt(payResult);
		int payamount = Integer.parseInt(payAmount);
		
		String payTime = TimeUtils.format(
				TimeUtils.parse(payDatetime, "yyyyMMddHHmmss"),
				"yyyy-MM-dd HH:mm:ss");//"20170315132535"
		String orderTime = TimeUtils.format(
				TimeUtils.parse(orderDatetime, "yyyyMMddHHmmss"),
				"yyyy-MM-dd HH:mm:ss");
		int state = 1;
		if (payRes == 1) {
			// ֧���ɹ� 1 δ֧�� 2 ��֧�� 3 ֧��ʧ��
			state = 2;
			initRecharge(payamount / 100, orderNo, payTime, state, 1, orderTime);
		} else if(payRes==0){
			// ֧��ʧ��
			state = 3;
			initRecharge(payamount / 100, orderNo, payTime, state, 1, orderTime);
		}
	}

	private String initRecharge(int bills, String orderCode, String payDate,
			int pState, int type, String prePayDate) {
		// �ж϶������Ƿ��Ѿ�����
		ChargeOrder order = ChargeOrderSer.findOrderByOrderCode(orderCode);
		if(order.getOrderState()==2){
			return "�Ѿ����³ɹ�";
		}
		int uId = order.getUserId();
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
		detailAccount.setIp("");
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
		int isSuccess = RollBackUtil
				.recharge(orderCode, pState, payDate, "", bills, a, uId,
						detail, account, detailAccount, type, prePayDate);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "�˵����³ɹ�") : JsonUtil
				.getRetMsg(1, "�˵�����ʧ��");
	}

}
