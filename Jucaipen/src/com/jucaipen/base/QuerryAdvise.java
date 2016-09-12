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
import com.jucaipen.utils.MsgCode;
import com.jucaipen.utils.StringUtil;

/**
 * ��ȡ���ҳ��
 * 
 * type ---10 ��ҳ 8 ѧԺ
 */
public class QuerryAdvise extends HttpServlet {
	private static final long serialVersionUID = 6773256897253049118L;
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
					result=initIndexPageData(type);
				} else {
					result = MsgCode.CURRENT_VERSION==MsgCode.HISTORY_VISION_1?JsonUtil.getRetMsg(1, "������Ͳ������ָ�ʽ���쳣"): JsonUtil.getAdvertive(null, MsgCode.RET_FAIL_PARAMERROR_CODE, MsgCode.RET_FAIL_PARAMERROR);
				}
			} else {
				result = MsgCode.CURRENT_VERSION==MsgCode.HISTORY_VISION_1 ?JsonUtil.getRetMsg(4, "��������Ϊ��") :JsonUtil.getAdvertive(null, MsgCode.RET_FAIL_PARAMERROR_CODE, MsgCode.RET_FAIL_PARAMERROR);
			}
		} else {
			result = MsgCode.CURRENT_VERSION==MsgCode.HISTORY_VISION_1?StringUtil.isVaild : JsonUtil.getAdvertive(null,MsgCode.RET_FAIL_DEVERROR_CODE, MsgCode.RET_FAIL_DEVERROR);
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String initIndexPageData(int type) {
		List<Advertive> advertives;
		// ������ҳ���
		if (type == 10) {
			advertives = AdverSer.findAdverByPid(12);
		} else {
			advertives = AdverSer.findAdverByPid(13);
		}
		return MsgCode.CURRENT_VERSION==MsgCode.HISTORY_VISION_1 ? JsonUtil.getObject(advertives) : JsonUtil.getAdvertive(advertives,MsgCode.RET_SUCCESS_CODE,MsgCode.RET_SUCCESS);
	}
}
