package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Advertive;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.service.AdverSer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * ��ȡ���ҳ��
 * 
 * type ---1 ��ҳ 2 �Ĺ۵� 7 ��Ƶ 8 ѧԺ 9ѧԺ����
 */
@SuppressWarnings("serial")
public class QuerryAdvise extends HttpServlet {
	private List<Advertive> advertives;
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getHeader("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String typeId = request.getParameter("type");
			if (StringUtil.isNotNull(typeId)) {
				if (StringUtil.isInteger(typeId)) {
					int type = Integer.parseInt(typeId);
					initIndexPageData(type);
					result = JsonUtil.getObject(advertives);
				} else {
					result = JsonUtil.getRetMsg(1, "������Ͳ������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(4, "��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initIndexPageData(int type) {
		// ������ҳ���
		advertives = AdverSer.findAdverByPid(type);
	}

}
