package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Video;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ��Ƶ�б� ��ֱ�� isIndex 0 ��ҳ�Ƽ���Ƶ ���ز�����id title desc image
 *         {"id":94,"title":"111","imageUrl":"","comms":0,"hits":5,"desc":"1"} 1
 *         ȫ��
 */
@SuppressWarnings("serial")
public class VideoList extends HttpServlet {
	private String result;
	private List<Video> videos;

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
			String isIndex = request.getParameter("isIndex");
			if (StringUtil.isNotNull(isIndex)) {
				if (StringUtil.isInteger(isIndex)) {
					int index = Integer.parseInt(isIndex);
					if (index == 0) {
						// ��ҳ�Ƽ���Ƶ
						initIndexData();
						result = JsonUtil.getVideoList(videos);
					} else {
						// ȫ����Ƶ
						String page = request.getParameter("page");
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							initAllData();
							result = JsonUtil.getVideoList(videos);
						} else {
							result = JsonUtil.getRetMsg(2, "page�����쳣");
						}
					}
				} else {
					result = JsonUtil.getRetMsg(2, "isIndex�������ָ�ʽ���쳣");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "isIndex��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initAllData() {
		// ��ʼ��ȫ������
		videos = VideoServer.findVideoByClassId(1);
	}

	private void initIndexData() {
		// ��ʼ����ҳ����
		videos = VideoServer.findVideoByClassIdLast(2, 1);
	}

}
