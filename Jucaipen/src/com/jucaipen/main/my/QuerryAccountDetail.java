package com.jucaipen.main.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.service.AccountDetailSer;
import com.jucaipen.service.AccountSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *         ��ȡ�˵���ϸ��Ϣ  state 0 �۲Ʊ� 1 ���� 
 */
@SuppressWarnings("serial")
public class QuerryAccountDetail extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent=request.getParameter("User-Agent");
		ClientOsInfo os=HeaderUtil.getMobilOS(userAgent);
		int isDevice=HeaderUtil.isVaildDevice(os, userAgent);
		if(isDevice==HeaderUtil.PHONE_APP){
			String userId = request.getParameter("userId");
			String page = request.getParameter("page");
			String state = request.getParameter("state");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
								if (StringUtil.isNotNull(state)
										&& StringUtil.isInteger(state)) {
									int s = Integer.parseInt(state);
									result = initAccountData(uId, p, s);
								} else {
									result = JsonUtil.getRetMsg(1, "state �����쳣");
								}
						} else {
							result = JsonUtil.getRetMsg(1, "page �����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(1, "���û���û�е�¼");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "userId ���ָ�ʽ���쳣");
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

	private String initAccountData(int userId,  int page, int state) {
		// ��ʼ���˻���Ϣ
		List<AccountDetail> details = AccountDetailSer
				.findDetailByUserIdAndType(userId, state, page);
		Account account=AccountSer.findAccountByUserId(userId);
		return JsonUtil.getAccountDetail(details,account);
	}

}
