package com.jucaipen.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.XinGeUtil;
/**
 * @author Administrator
 * 
 * 
 *         ��ҳ������Ϣ
 * 
 *         all 1 ȫ���豸 2 ָ��TAG�豸 3 ָ��TOKEN�豸 msgType ���� ֱ�� ϵͳ֪ͨ �汾����
 */
public class WebPush extends HttpServlet {
	private static final long serialVersionUID = -7443274292656349638L;
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String msgType = request.getParameter("msgType");
		String all = request.getParameter("all");
		String title = request.getParameter("title");
		String message = request.getParameter("message");
		String tagName = request.getParameter("tagName");
		String tokenName = request.getParameter("tokenName");
		if ("1".equals(all)) {
			// ȫ���豸
		//	result = pushAllDevMsg(msgType, title, message);
		} else if ("2".equals(all)) {
			// ָ��TAG
			result = pushTagDevMsg(msgType, tagName, title, message);
		} else if ("3".equals(all)) {
			// ָ��TOKEN
			result = pushTokenDevMsg(msgType, tokenName, title, message);
		} else {
			result = "δ֪�쳣";
		}
		out.print("<html>");
		out.print("<head>");
		out.print("<head/>");
		out.print("<body>");
		out.print("<div style='margin-top: 20%;text-align: center;' >" + result
				+ "</div>");
		out.print("<body/>");
		out.print("</html>");
		out.flush();
		out.close();
	}

	private String pushTokenDevMsg(String msgType, String title,
			String tokenName, String message) {
		// ����ָ��Token�豸��Ϣ
		JSONObject res = XinGeUtil.getInstance(false).pushTokenDevMsg(
				tokenName, title, message);
		return res.toString();
	}

	private String pushTagDevMsg(String msgType, String tagName, String title,
			String message) {
		// ����ָ��Tag�豸��Ϣ
		JSONObject res = XinGeUtil.getInstance(false).pushTagDevMsg(tagName,
				title, message);
		return res.toString();
	}

	/*private String pushAllDevMsg(String msgType, String title, String message) {
		// ����ȫ���豸ָ����Ϣ
		JPushClient puch = JPushUtils.getJPush();
		PushPayload msg = JPushUtils.createNptify(message, "notiy", 1);
		PushResult res=JPushUtils.pushMsg(puch, msg);
		return res.toString();
	}*/

}
