package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.service.AdverSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * ��ȡ���ҳ��
 * 
 * type ---1 ��ҳ��� ----3 ��ƱƵ����ҳ --- 5������õ�Ƭ
 */
@SuppressWarnings("serial")
public class QuerryAdvise extends HttpServlet {

	private Object advertives;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId = request.getParameter("type");
		if (StringUtil.isNotNull(typeId)) {
			if (StringUtil.isInteger(typeId)) {
				int type = Integer.parseInt(typeId);
				if (type == 1) {
					// ��ҳ���õ�Ƭ
					initIndexPageData();
					result = JsonUtil.getObject(advertives);
				} else if (type == 3) {
					// ��ƱƵ����ҳ�õ�Ƭ
					result = JsonUtil.getRetMsg(2, "������Ͳ������ָ�ʽ���쳣");
				} else if (type == 5) {
					// �����ɻõ�Ƭ
					result = JsonUtil.getRetMsg(3, "������Ͳ������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "������Ͳ������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(4, "��������Ϊ��");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initIndexPageData() {
		// ������ҳ���
		advertives = AdverSer.findAdverByPid(6);
	}

}
