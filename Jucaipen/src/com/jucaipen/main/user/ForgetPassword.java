package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.MobileMessage;
import com.jucaipen.model.User;
import com.jucaipen.service.MobileMessageSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.MD5Util;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 *      ��������
 */
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = -7692139877775498357L;
	private String result;
	private Map<String, String> param = new HashMap<String, String>();
	// �����ֻ��� ����
	private String encrypePath = "http://www.jcplicai.com/ashx/AndroidUser.ashx?action=GetEncryptMobileNum";
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String telPhone = request.getParameter("telPhone");
		String actionCode = request.getParameter("actionCode");
		String newPwd = request.getParameter("newPwd");
		String repetPwd = request.getParameter("repetPwd");
		if (StringUtil.isNotNull(telPhone)
				&& StringUtil.isMobileNumber(telPhone)) {
			if (StringUtil.isNotNull(actionCode)) {
				if (StringUtil.isNotNull(newPwd)
						&& StringUtil.isPassword(newPwd)) {
					if (StringUtil.isNotNull(repetPwd)
							&& StringUtil.isPassword(repetPwd)) {
						if (newPwd.equals(repetPwd)) {
							String md5Tel=getPhone(telPhone);
							int uId = checkIsExit(md5Tel);
							if (uId > 0) {
								int isCheck = checkActionCode(md5Tel,
										actionCode);
								if (isCheck==0) {
									result = changePwd(uId, newPwd);
								} else if(isCheck==1){
									result = JsonUtil.getRetMsg(1, "��֤�볬ʱ");
								}else{
									result = JsonUtil.getRetMsg(1, "��֤�����");
								}
							} else {
								result = JsonUtil.getRetMsg(7, "�û�������");
							}

						} else {
							result = JsonUtil.getRetMsg(2, "�������벻һ��");
						}

					} else {
						result = JsonUtil.getRetMsg(3, "ȷ�����볤�Ȳ���ȷ");
					}

				} else {
					result = JsonUtil.getRetMsg(4, "�����볤�Ȳ���ȷ");
				}

			} else {
				result = JsonUtil.getRetMsg(5, "��֤�벻��Ϊ��");
			}
		} else {
			result = JsonUtil.getRetMsg(6, "�ֻ��ų��Ȳ���ȷ");
		}
		out.println(result);
		out.flush();
		out.close();
	}
	
	
	
	public String getPhone(String tel){
		param.put("mobilenum", tel);
		String resJson = LoginUtil.sendHttpPost(encrypePath, param);
		org.json.JSONObject object = new org.json.JSONObject(resJson);
		boolean isRes = object.getBoolean("Result");
		if (isRes) {
			String telPhone = object.getString("MobileNum");
			return telPhone;
		}
		return tel;
	}

	private int checkIsExit(String telPhone) {
			User user = UserServer.findUserByTelPhone(telPhone);
			if (user != null) {
				return user.getId();
			}
		   return -1;
	}

	private String changePwd(int uId, String newPwd) {
		String pwd = MD5Util.MD5(newPwd);
		int isSuccess = UserServer.updatePassword(uId, pwd);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "�������óɹ�") : JsonUtil
				.getRetMsg(1, "��������ʧ��");
	}

	private int checkActionCode(String telPhone, String actionCode) {
		try {
			// ��֤�ֻ���֤���Ƿ�Ϸ�
			MobileMessage mobileList=MobileMessageSer.findIsRegin(telPhone, actionCode);
			if (mobileList != null) {
				String checkCode = mobileList.getActionCode();
				String sendDate = mobileList.getSendDate();
				String msgId = mobileList.getMsgid();
				long sendTime = sdf.parse(sendDate).getTime();
				long currrentTime = System.currentTimeMillis();
				if (actionCode.equals(checkCode)) {
					if((currrentTime - sendTime) <= (3 * 60 * 1000)){
						insertCheckInfo(telPhone, sdf.format(new Date()), msgId,
								true);
						return 0;
					}else{
						return 1;
					}
				} else {
					return 2;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 2;
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

}
