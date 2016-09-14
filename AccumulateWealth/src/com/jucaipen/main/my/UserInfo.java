package com.jucaipen.main.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Area;
import com.jucaipen.model.City;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.InvestmentType;
import com.jucaipen.model.Province;
import com.jucaipen.model.User;
import com.jucaipen.service.AreaServer;
import com.jucaipen.service.CityServer;
import com.jucaipen.service.InvestmentTypeSer;
import com.jucaipen.service.ProvinceServer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *         ��ȡ�û���Ϣ
 */
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = -6681194960664229841L;
	private User user;
	private String result;
	private String localProvince;
	private String localCity;
	private String localArea;
	// �����ֻ���
	private String parsePhoneNum = "http://user.jucaipen.com/ashx/AndroidUser.ashx?action=GetDecryptMobileNum";
	private Map<String, String> param = new HashMap<String, String>();

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
			String userId = request.getParameter("userId");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int id = Integer.parseInt(userId);
					if (id > 0) {
						initUserData(id);
						if (user != null) {
							createUser();
							result = JsonUtil.getUserInfo(user, localProvince,
									localCity, localArea);
						} else {
							result = JsonUtil.getRetMsg(1, "�û���Ϣ������");
						}
					} else {
						result = JsonUtil.getRetMsg(3, "�û�û�е�¼");
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

	private void initUserData(int id) {
		user = UserServer.findUserById(id);
	}

	private void createUser() {
		String tel = user.getMobileNum();
		String birth = user.getBirthday();
		int investId=user.getInvestId();
		InvestmentType type=InvestmentTypeSer.findTypeById(investId);
		if(type!=null){
			String typeName=type.getTypeName();
			user.setInvestStr(typeName);
		}
		if (tel != null) {
			// ����
			param.put("mobilenum", tel);
			String resJson = LoginUtil.sendHttpPost(parsePhoneNum, param);
			org.json.JSONObject object = new org.json.JSONObject(resJson);
			boolean isParse = object.getBoolean("Result");
			if (isParse) {
				String mobile = object.getString("MobileNum");
				user.setMobileNum(mobile);
			}
		}
		if (birth != null) {
			user.setBirthday(birth);
		}
		int provinceId = user.getProvinceId();
		int cityId = user.getCityId();
		int areaId = user.getAreaId();
		if (provinceId != 0) {
			// ��ȡ����ʡ����Ϣ
			initProvinceInfo(provinceId);
		} else {
			localProvince = "";
		}
		if (cityId != 0) {
			// ��ȡ���ڳ�����Ϣ
			initCityInfo(cityId);
		} else {
			localCity = "";
		}
		if (areaId != 0) {
			// ��ȡ����������Ϣ
			initAreaInfo(areaId);
		} else {
			localArea = "";
		}
	}

	private void initAreaInfo(int areaId) {
		Area area = AreaServer.getArea(areaId);
		localArea = area.getName();

	}

	private void initCityInfo(int cityId) {
		City city = CityServer.getCity(cityId);
		localCity = city.getName();

	}

	private void initProvinceInfo(int provinceId) {
		Province province = ProvinceServer.getProvince(provinceId);
		localProvince = province.getName();
	}

}
