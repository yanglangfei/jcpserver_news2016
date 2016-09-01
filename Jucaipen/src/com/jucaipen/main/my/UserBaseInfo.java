package com.jucaipen.main.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ApplyDetails;
import com.jucaipen.model.ApplyTeacher;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.User;
import com.jucaipen.service.ApplyDetailsSer;
import com.jucaipen.service.ApplyTeacherSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ�û����Ļ�����Ϣ
 **/
public class UserBaseInfo extends HttpServlet {
	private static final long serialVersionUID = 1318609607746929659L;
	private String result;
	/**
	 * �����ֻ���
	 */
	private String parsePhoneNum = "http://user.jucaipen.com/ashx/AndroidUser.ashx?action=GetDecryptMobileNum";
	private Map<String, String> param = new HashMap<String, String>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		if (StringUtil.isNotNull(userId)) {
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					result = initBaseInfo(uId);
				} else {
					result = JsonUtil.getRetMsg(1, "�û���û��¼");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "userId �������ָ�ʽ���쳣");
			}

		} else {
			result = JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initBaseInfo(int uId) {
		// �Ƿ��ǽ�ʦ
		FamousTeacher teacher = FamousTeacherSer.findFamousTeacherByUserId(uId);
		// �����Ƿ�ɹ�
		ApplyTeacher apply = ApplyTeacherSer.findLastApplyByUid(uId, 1);
		
		User user = UserServer.findBaseInfoById(uId);
		param.put("mobilenum", user.getMobileNum());
		String resJson = LoginUtil.sendHttpPost(parsePhoneNum, param);
		org.json.JSONObject object = new org.json.JSONObject(resJson);
		boolean isParse = object.getBoolean("Result");
		if (isParse) {
			String mobile = object.getString("MobileNum");
			user.setMobileNum(mobile);
		}
		user.setIsTeacher(teacher != null ? 1 : 0);
		if(apply!=null&&apply.getState()==3){
			//���ʧ��
			ApplyDetails details = ApplyDetailsSer.findDetailsByApplyId(apply.getId());
			if(details!=null){
				user.setApplyFailReason(details.getCause());
			}
		}
		
		user.setApplyState(apply!=null ?apply.getState() : -1);
		return JsonUtil.getBaseInfo(user);
	}

}
