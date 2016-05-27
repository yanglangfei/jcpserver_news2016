package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ������Ϣ commType �������� 0 �������� 1 ��Ƶ���� 2 �۵�����
 */
@SuppressWarnings("serial")
public class QuerryComments extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String commType = request.getParameter("commType");
			String id = request.getParameter("id");
			String page = request.getParameter("page");
			if (StringUtil.isNotNull(commType)) {
				if (StringUtil.isInteger(commType)) {
					int type = Integer.parseInt(commType);
					if (StringUtil.isNotNull(id) && StringUtil.isInteger(id)) {
						int index = Integer.parseInt(id);
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
							if (type == 0) {
								// ��������
								initNewsComms(index, p);
								// result=JsonUtil.getNewsCommList(nComments,
								// users);
							} else if (type == 1) {
								// ��Ƶ����
								initVideoComments(index, p);
								// result=JsonUtil.getNewsCommList(nComments,
								// users);
							} else {
								// �۵�����
								initIdeaComments(index, p);
								// result = JsonUtil.getIdeaCommList(logComms,
								// users);
							}
						} else {
							result = JsonUtil.getRetMsg(4, "page �����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(3, "id �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "commType �������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "commType ��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private void initIdeaComments(int index, int page) {
		// ��ʼ���۵�����

	}

	private void initVideoComments(int index, int page) {
		// ��ʼ����Ƶ��������

	}

	private void initNewsComms(int index, int page) {
		// ��ʼ����������

	}

}
