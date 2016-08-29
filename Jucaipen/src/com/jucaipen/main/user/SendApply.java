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
 *         提交审批 申请讲师
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
		// 1 是否绑定手机号
		User user = UserServer.findUserIsCheck(uId);
		int isCheckMobile = user.getIsChechMobile();
		if (isCheckMobile != 1) {
			return JsonUtil.getRetMsg(1, "请先绑定手机号");
		}
		// 2 是否讲师
		int isTeaher = user.getIsTeacher();
		if (isTeaher == 1) {
			return JsonUtil.getRetMsg(2, "您已经是讲师了，不能重复申请");
		}

		if (step == 1) {
			// 处理第一步数据
			return addFirstStepMsg(applyMsg);
		}

		if (step == 2) {
			// 处理第二步数据
			return addSecondStepMsg(applyMsg);
		}

		if (step == 3) {
			// 处理第三步数据
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
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "提交成功") : JsonUtil
				.getRetMsg(1, "提交失败");
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
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "提交成功") : JsonUtil
				.getRetMsg(1, "提交失败");
	}

	private String addFirstStepMsg(String applyMsg) {
		ApplyTeacher apply = JsonUtil.parseFirstStepApply(applyMsg);
		String name = apply.getTrueName();
		if (!StringUtil.isNotNull(name)) {
			return JsonUtil.getRetMsg(3, "真实姓名不能为空");
		}

		String idCard = apply.getIdCard();

		if (!StringUtil.isNotNull(idCard)) {
			return JsonUtil.getRetMsg(4, "身份证号不能为空");
		}
		int sex = apply.getSex();

		if (sex == -1) {
			return JsonUtil.getRetMsg(5, "性别必须选择");
		}

		String cardImage1 = apply.getCardImage1();

		if (!StringUtil.isNotNull(cardImage1)) {
			return JsonUtil.getRetMsg(6, "请上传身份证正面照");
		}
		int isSuccess = ApplyTeacherSer.addApply(apply, 1);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "提交成功") : JsonUtil
				.getRetMsg(1, "提交失败");
	}

}
