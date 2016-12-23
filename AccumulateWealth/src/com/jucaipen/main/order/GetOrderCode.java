package com.jucaipen.main.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author ���ʷ�
 *2016��12��23��  ����4:32:39
 * ��ȡ������
 */
public class GetOrderCode extends HttpServlet {
	private static final long serialVersionUID = 2954422422781866755L;
	private static final String ORDER_PATH = "http://www.jucaipen.com/ashx/AndroidUser.ashx?action=PayOrder";
	private Map<String, String> param = new HashMap<String, String>();
	private String result;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String paymoney = req.getParameter("paymoney");
		String type = req.getParameter("type");
		String userid = req.getParameter("userid");
		PrintWriter writer = resp.getWriter();
		if (StringUtil.isInteger(userid)) {
			int uId = Integer.parseInt(userid);
			if (uId > 0) {
				if (StringUtil.isInteger(type)) {
					int payType = Integer.parseInt(type);
					if (StringUtil.isInteger(paymoney)) {
						int money = Integer.parseInt(paymoney);
						result = getOrderCode(uId, payType, money);
					} else {
						result = JsonUtil.getRetMsg(3, "paymoney ���ָ�ʽ���쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "type ���ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "�û���û��¼");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "userid ���ָ�ʽ���쳣");
		}
		writer.print(result);
		writer.flush();
		writer.close();
	}

	private String getOrderCode(int uId, int payType, int money) {
		param.put("paymoney", money + "");
		param.put("userid", uId + "");
		param.put("type", payType + "");
		return LoginUtil.sendHttpPost(ORDER_PATH, param);
	}

}
