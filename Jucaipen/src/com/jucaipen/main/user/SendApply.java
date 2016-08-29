package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ApplyTeacher;
import com.jucaipen.model.User;
import com.jucaipen.service.ApplyTeacherSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         �ύ���� ���뽲ʦ
 */
public class SendApply extends HttpServlet {
	private static final long serialVersionUID = -5458834439702229711L;
	private String result;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String stepType = request.getParameter("stepType");
		String applyMsg = request.getParameter("applyMsg");
		if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isNotNull(stepType)
						&& StringUtil.isInteger(stepType)) {
					int step = Integer.parseInt(stepType);
					if (StringUtil.isNotNull(applyMsg)) {
						result = createTeacher(uId, step, applyMsg);
					}
				}

			}

		}

		out.println(result);
		out.flush();
		out.close();
	}

	private String createTeacher(int uId, int step, String applyMsg) {
		// 1 �Ƿ���ֻ���
		User user = UserServer.findUserIsCheck(uId);
		int isCheckMobile = user.getIsChechMobile();
		if (isCheckMobile != 1) {
			return JsonUtil.getRetMsg(1, "���Ȱ��ֻ���");
		}
		// 2 �Ƿ�ʦ
		int isTeaher = user.getIsTeacher();
		if (isTeaher == 1) {
			return JsonUtil.getRetMsg(2, "���Ѿ��ǽ�ʦ�ˣ������ظ�����");
		}

		if (step == 1) {
			// �����һ������
			return addFirstStepMsg(applyMsg);
		}

		if (step == 2) {
			// ����ڶ�������
			return addSecondStepMsg(applyMsg);
		}

		if (step == 3) {
			// �������������
			return addThirdStepMsg(applyMsg);
		}

		return null;
	}

	private String addThirdStepMsg(String applyMsg) {
		ApplyTeacher apply = JsonUtil.parseThirdStepApply(applyMsg);
		String parentAccount = apply.getParentAccount();
		if (StringUtil.isNotNull(parentAccount)) {

		}

		String mobileNum = apply.getMobileNum();
		if (!StringUtil.isNotNull(mobileNum)) {

		}

		String email = apply.getEmail();
		if (!StringUtil.isNotNull(email)) {

		}

		/*
		 * String parentAccount = object.optString("parentAccount", ""); String
		 * mobileNum = object.optString("mobileNum", ""); String email =
		 * object.optString("email", ""); String actionCode =
		 * object.optString("actionCode", ""); int isTxtLive =
		 * object.optInt("isTxtLive", -1); int isVideoLive =
		 * object.optInt("isVideoLive", -1); int fk_BankId =
		 * object.optInt("fk_BankId", -1); String bankAccount =
		 * object.optString("bankAccount", "");
		 */
		int isSuccess = ApplyTeacherSer.addApply(apply, 3);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "�ύ�ɹ�") : JsonUtil
				.getRetMsg(1, "�ύʧ��");
	}

	private String addSecondStepMsg(String applyMsg) {
		ApplyTeacher apply = JsonUtil.parseSecondStepApply(applyMsg);
		int fk_certificationId = apply.getFk_certificationId();
		if (fk_certificationId == -1) {

		}
		int fk_PositionId = apply.getFk_PositionId();
		if (fk_PositionId == -1) {

		}

		int fk_ProvinceId = apply.getFk_ProvinceId();
		if (fk_ProvinceId == -1) {

		}

		int fk_CityId = apply.getFk_CityId();
		if (fk_CityId == -1) {

		}

		String certificationNum = apply.getCertificationNum();
		if (!StringUtil.isNotNull(certificationNum)) {

		}

		String companyName = apply.getCompanyName();
		if (!StringUtil.isNotNull(companyName)) {

		}

		String shanChang = apply.getShanChang();
		if (!StringUtil.isNotNull(shanChang)) {

		}

		String userInformation = apply.getUserInformation();
		if (!StringUtil.isNotNull(userInformation)) {

		}
		int isSuccess = ApplyTeacherSer.addApply(apply, 1);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "�ύ�ɹ�") : JsonUtil
				.getRetMsg(1, "�ύʧ��");
	}

	private String addFirstStepMsg(String applyMsg) {
		ApplyTeacher apply = JsonUtil.parseFirstStepApply(applyMsg);
		String name = apply.getTrueName();
		if (!StringUtil.isNotNull(name)) {
			return JsonUtil.getRetMsg(3, "��ʵ��������Ϊ��");
		}

		String idCard = apply.getIdCard();

		if (!StringUtil.isNotNull(idCard)) {
			return JsonUtil.getRetMsg(4, "���֤�Ų���Ϊ��");
		}
		int sex = apply.getSex();

		if (sex == -1) {
			return JsonUtil.getRetMsg(5, "�Ա����ѡ��");
		}

		String cardImage1 = apply.getCardImage1();

		if (!StringUtil.isNotNull(cardImage1)) {
			return JsonUtil.getRetMsg(6, "���ϴ����֤������");
		}
		int isSuccess = ApplyTeacherSer.addApply(apply, 1);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "�ύ�ɹ�") : JsonUtil
				.getRetMsg(1, "�ύʧ��");
	}

}
