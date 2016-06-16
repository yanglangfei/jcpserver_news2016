package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.User;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator �޸ĸ�������
 */
@SuppressWarnings("serial")
public class CompleteInfo extends HttpServlet {
	private String result;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String userId = request.getParameter("userId");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
						result = initUserInfo(uId, request);
					} else {
						result = JsonUtil.getRetMsg(3, "�û���û��¼");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "userId �������ָ�ʽ���쳣");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initUserInfo(int uId, HttpServletRequest request) {
		// ��ʼ���û���Ϣ
		String nickName = request.getParameter("nickName");
		String trueName = request.getParameter("trueName");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String provinceId=request.getParameter("provinceId");
		String areaId=request.getParameter("areaId");
		String cityId = request.getParameter("cityId");
		String investId = request.getParameter("investId");
		String plain = request.getParameter("plain");
		if (!StringUtil.isNotNull(nickName)) {
			return JsonUtil.getRetMsg(1, "�ǳƲ���Ϊ��");
		}
		User user = new User();
		user.setNickName(nickName);
		if (StringUtil.isNotNull(trueName)) {
			user.setTrueName(trueName);
		}

		if (StringUtil.isNotNull(sex)) {
			user.setSex(sex);
		}

		if (StringUtil.isNotNull(birth)) {
			user.setBirthday(birth);
		}
		
		if(StringUtil.isNotNull(provinceId)&&StringUtil.isInteger(provinceId)){
			int pId=Integer.parseInt(provinceId);
			user.setProvinceId(pId);
		}
		

		if (StringUtil.isNotNull(cityId) && StringUtil.isInteger(cityId)) {
			int cId = Integer.parseInt(cityId);
			user.setCityId(cId);
		}
		
		if(StringUtil.isNotNull(areaId)&&StringUtil.isInteger(areaId)){
			int aId=Integer.parseInt(areaId);
			user.setAreaId(aId);
		}

		if (StringUtil.isNotNull(investId) && StringUtil.isInteger(investId)) {
			int inveId = Integer.parseInt(investId);
			user.setInvestId(inveId);
		}

		if (StringUtil.isNotNull(plain)) {
			user.setDescript(plain);
		}
		int isSuccess = UserServer.updateUser(uId, user);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "���������ύ�ɹ�") : JsonUtil
				.getRetMsg(1, "���������ύʧ��");
	}

}
