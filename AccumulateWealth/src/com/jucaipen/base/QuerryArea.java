package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.Area;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.service.AreaServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.MsgCode;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ����Ϣ
 * 
 */
@SuppressWarnings("serial")
public class QuerryArea extends HttpServlet {
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
			String cityId = request.getParameter("cityId");
			if (StringUtil.isInteger(cityId)) {
				int cId = Integer.parseInt(cityId);
				result = initAreaData(cId);
			} else {
				result = MsgCode.CURRENT_VERSION == MsgCode.HISTORY_VISION_1 ? JsonUtil
						.getRetMsg(1, "����id�������ָ�ʽ���쳣") : JsonUtil.getAreaV2(
						null, MsgCode.RET_FAIL_PARAMERROR_CODE,
						MsgCode.RET_FAIL_PARAMERROR);
			}
		} else {
			result = MsgCode.CURRENT_VERSION == MsgCode.HISTORY_VISION_1 ? StringUtil.isVaild
					: JsonUtil.getAreaV2(null, MsgCode.RET_FAIL_DEVERROR_CODE,
							MsgCode.RET_FAIL_DEVERROR);
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String initAreaData(int cId) {
		// ��ʼ������Ϣ
		List<Area> areas = AreaServer.getAreas(0, cId);
		return MsgCode.CURRENT_VERSION == MsgCode.HISTORY_VISION_1 ? JsonUtil
				.getObject(areas) : JsonUtil.getAreaV2(areas,
				MsgCode.RET_SUCCESS_CODE, MsgCode.RET_SUCCESS);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
