package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.ApplyTeacher;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.MobileMessage;
import com.jucaipen.model.User;
import com.jucaipen.service.ApplyTeacherSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.MobileMessageSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;
/**
 * @author Administrator
 * 
 *         �ύ���� ���뽲ʦ
 */
public class SendApply extends HttpServlet {
	private static final long serialVersionUID = -5458834439702229711L;
	private String result;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// �����ֻ��� ����
	private String encrypePath = "http://www.jcplicai.com/ashx/AndroidUser.ashx?action=GetEncryptMobileNum";
	private Map<String, String> param = new HashMap<String, String>();

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
					} else {
						result = JsonUtil.getRetMsg(4, "�������ݲ���Ϊ��");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "stepType �����쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "�û���û��¼");
			}

		} else {
			result = JsonUtil.getRetMsg(2, "userId �����쳣");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String getPhoneNum(String telPhone) {
		param.put("mobilenum", telPhone);
		String resJson = LoginUtil.sendHttpPost(encrypePath, param);
		org.json.JSONObject object = new org.json.JSONObject(resJson);
		boolean isRes = object.getBoolean("Result");
		if (isRes) {
			String tel = object.getString("MobileNum");
			return tel;
		} else {
			return null;
		}
	}

	private String createTeacher(int uId, int step, String applyMsg) {
		// 1 �Ƿ���ֻ���
		User user = UserServer.findUserIsCheck(uId);
		int isCheckMobile = user.getIsChechMobile();
		if (isCheckMobile != 1) {
			return JsonUtil.getRetMsg(1, "���Ȱ��ֻ���");
		}
		// 2 �Ƿ�ʦ
		FamousTeacher teacher = FamousTeacherSer.findFamousTeacherByUserId(uId);
		if (teacher != null) {
			return JsonUtil.getRetMsg(2, "���Ѿ��ǽ�ʦ�ˣ������ظ�����");
		}

		if (step == 1) {
			// �����һ������
			return addFirstStepMsg(applyMsg, uId);
		}

		ApplyTeacher apply = ApplyTeacherSer.findLastApplyByUid(uId, 1);
		int applyId = apply.getId();

		if (step == 2) {
			// ����ڶ�������
			return addSecondStepMsg(applyMsg, applyId, uId);
		}

		if (step == 3) {
			// �������������
			return addThirdStepMsg(applyMsg, applyId);
		}

		return null;
	}

	/**
	 * @param applyMsg
	 * @param uId
	 * @param id
	 * @return �ύ���������
	 */
	private String addThirdStepMsg(String applyMsg, int id) {
		ApplyTeacher apply = JsonUtil.parseThirdStepApply(applyMsg);
		String parentAccount = apply.getParentAccount();
		if (StringUtil.isNotNull(parentAccount)) {
			User user = UserServer.findUserByUserNameOrMobile(parentAccount);
			if (user != null) {
				apply.setFk_ParentUserId(user.getId());
			}
		}

		String mobileNum = apply.getMobileNum();
		if (!StringUtil.isNotNull(mobileNum)) {
			return JsonUtil.getRetMsg(2, "�������ֻ���");
		}

		String tel = getPhoneNum(mobileNum);
		if (tel == null) {
			return JsonUtil.getRetMsg(12, "�ֻ��Ž����쳣");
		}

		String email = apply.getEmail();

		if (StringUtil.isNotNull(email) && !StringUtil.isMail(email)) {
			return JsonUtil.getRetMsg(9, "�����ʽ����");
		}

		String actionCode = apply.getActionCode();
		if (!StringUtil.isNotNull(actionCode)) {
			return JsonUtil.getRetMsg(5, "�������ֻ���֤��");
		}

		/*if (!checkCheckCode(tel, actionCode)) {
			return JsonUtil.getRetMsg(6, "�ֻ���֤�����");
		}*/

		int isTxtLive = apply.getIsTxtLive();
		int isVideoLive = apply.getIsVideoLive();
		if (isTxtLive == -1 && isVideoLive == -1) {
			return JsonUtil.getRetMsg(7, "��ѡ��ͨ��Ŀ");
		}
        apply.setId(id);
		int isSuccess = ApplyTeacherSer.addApply(apply, 3);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "�ύ�ɹ�") : JsonUtil
				.getRetMsg(1, "�ύʧ��");
	}

	/**
	 * @param mobileNum
	 * @param actionCode
	 * @return �ж���֤���Ƿ���ȷ
	 */
	private boolean checkCheckCode(String mobileNum, String actionCode) {
		try {
			// ��֤���ֻ���֤���Ƿ���ȷ
			List<MobileMessage> messages = MobileMessageSer
					.findMobileMessageByMobileNumLast(1, mobileNum);
			if (messages.size() > 0) {
				String code = messages.get(0).getActionCode();
				String sendDate = messages.get(0).getSendDate();
				String msgId = messages.get(0).getMsgid();
				long newSendTime = sdf.parse(sendDate).getTime();
				long currrentTime = System.currentTimeMillis();
				if ((code.equals(actionCode))
						&& ((currrentTime - newSendTime) <= (3 * 60 * 1000))) {
					// ��֤���ֻ����Ƿ��ѱ�ʹ��
					User user = UserServer.findUserByTelPhone(mobileNum);
					insertCheckInfo(mobileNum, sdf.format(new Date()), msgId,
							true);
					return user == null;
				} else {
					insertCheckInfo(mobileNum, sdf.format(new Date()), msgId,
							false);
					return false;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;

	}

	private void insertCheckInfo(String mobileNum, String checkDate,
			String msgId, boolean isPassed) {
		// �޸Ķ��ż���״̬
		MobileMessage mobileMessage = new MobileMessage();
		if (isPassed) {
			mobileMessage.setMsgType(2);
			mobileMessage.setCheckDate(checkDate);
		} else {
			mobileMessage.setMsgType(3);
		}
		MobileMessageSer.upDateMessageType(msgId, mobileMessage);
	}

	/**
	 * @param applyMsg
	 * @param uId
	 * @param id
	 * @return �ύ����ڶ���
	 */
	private String addSecondStepMsg(String applyMsg, int id, int uId) {
		ApplyTeacher apply = JsonUtil.parseSecondStepApply(applyMsg);
		int fk_certificationId = apply.getFk_certificationId();
		if (fk_certificationId == -1) {
			return JsonUtil.getRetMsg(2, "��ѡ���ʸ�֤������");
		}
		int fk_PositionId = apply.getFk_PositionId();
		if (fk_PositionId == -1) {
			return JsonUtil.getRetMsg(3, "��ѡ���λ");
		}

		int fk_ProvinceId = apply.getFk_ProvinceId();
		if (fk_ProvinceId == -1) {
			apply.setFk_ProvinceId(0);
			return JsonUtil.getRetMsg(4, "��ѡ������ʡ��");
		}

		int fk_CityId = apply.getFk_CityId();
		if (fk_CityId == -1) {
			apply.setFk_CityId(0);
			return JsonUtil.getRetMsg(5, "��ѡ�����ڳ���");
		}

		String certificationNum = apply.getCertificationNum();
		if (!StringUtil.isNotNull(certificationNum)) {
			return JsonUtil.getRetMsg(6, "�������ʸ�֤���");
		}

		String companyName = apply.getCompanyName();
		if (!StringUtil.isNotNull(companyName)) {
			return JsonUtil.getRetMsg(7, "���������ڹ�˾����");
		}

		int fk_BankId = apply.getFk_BankId();
		if (fk_BankId == -1) {
			return JsonUtil.getRetMsg(9, "��ѡ������");
		}
		String bankAccount = apply.getBankAccount();
		if (!StringUtil.isNotNull(bankAccount)) {
			return JsonUtil.getRetMsg(10, "���������п���");
		}

		if (!StringUtil.isBankCard(bankAccount)) {
			return JsonUtil.getRetMsg(11, "���п��쳣");
		}

		String shanChang = apply.getShanChang();
		if (!StringUtil.isNotNull(shanChang)) {
			return JsonUtil.getRetMsg(8, "�������ó�����");
		}
		apply.setId(id);
		int isSuccess = ApplyTeacherSer.addApply(apply, 2);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "�ύ�ɹ�") : JsonUtil
				.getRetMsg(1, "�ύʧ��");
	}

	/**
	 * @param applyMsg
	 * @param uId
	 * @param applyId
	 * @return �ύ�����һ��
	 */
	private String addFirstStepMsg(String applyMsg, int uId) {
		ApplyTeacher apply = JsonUtil.parseFirstStepApply(applyMsg);
		String name = apply.getTrueName();
		if (!StringUtil.isNotNull(name)) {
			return JsonUtil.getRetMsg(3, "��ʵ��������Ϊ��");
		}

		String idCard = apply.getIdCard();

		if (!StringUtil.isNotNull(idCard)) {
			return JsonUtil.getRetMsg(4, "���֤�Ų���Ϊ��");
		}

		if (!StringUtil.isIdCard(idCard)) {
			return JsonUtil.getRetMsg(7, "���֤��������");
		}

		int sex = apply.getSex();
		if (sex == -1) {
			return JsonUtil.getRetMsg(5, "�Ա����ѡ��");
		}

		String cardImage1 = apply.getCardImage1();
		if (!StringUtil.isNotNull(cardImage1)) {
			return JsonUtil.getRetMsg(6, "���ϴ����֤������");
		}
		apply.setFk_UserId(uId);
		apply.setInsertDate(TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		int isSuccess = ApplyTeacherSer.addApply(apply, 1);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "�ύ�ɹ�") : JsonUtil
				.getRetMsg(1, "�ύʧ��");
	}

}
