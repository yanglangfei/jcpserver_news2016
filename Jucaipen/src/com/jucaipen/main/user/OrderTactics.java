package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *         ����ս����Ϣ
 */
@SuppressWarnings("serial")
public class OrderTactics extends HttpServlet {
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String tacticeId = request.getParameter("tacticsId");
		if (StringUtil.isNotNull(userId)) {
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(tacticeId)) {
						if (StringUtil.isInteger(tacticeId)) {
							int tId = Integer.parseInt(tacticeId);
							result = orderTactics(uId, tId);
						}else{
							result=JsonUtil.getRetMsg(5,"tacticeId �������ָ�ʽ���쳣��");
						}
					} else {
						result = JsonUtil.getRetMsg(4, "tacticeId ��������Ϊ��");
					}
				} else {
					result = JsonUtil.getRetMsg(3, " �û���û��¼");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "userId �������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String orderTactics(int uId, int tId) {
		// ����ս����Ϣ
		return null;
	}

}
