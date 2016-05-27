package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.service.AccountDetailSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *         ��ȡ�˵���ϸ��Ϣ type 0 ���� 1 ���� state 0 ��� 1 ���� 2 �۲Ʊ�
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
			String type = request.getParameter("type");
			String page = request.getParameter("page");
			String state = request.getParameter("state");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
							if (StringUtil.isNotNull(type)
									&& StringUtil.isInteger(type)) {
								int t = Integer.parseInt(type);
								if (StringUtil.isNotNull(state)
										&& StringUtil.isInteger(state)) {
									int s = Integer.parseInt(state);
									result = initAccountData(uId, t, p, s);
								} else {
									result = JsonUtil.getRetMsg(1, "state �����쳣");
								}
							} else {
								result = JsonUtil.getRetMsg(1, "type �����쳣");
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

	private String initAccountData(int userId, int type, int page, int state) {
		// ��ʼ���˻���Ϣ
		List<AccountDetail> details = AccountDetailSer
				.findDetailByUserIdAndStateAndType(state, type, userId, page);
		return JsonUtil.getAccountDetail(details);
	}

}
