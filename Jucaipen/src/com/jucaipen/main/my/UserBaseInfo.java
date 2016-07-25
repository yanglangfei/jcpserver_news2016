package com.jucaipen.main.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.User;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 *
 *  获取用户中心基本信息
 **/
@SuppressWarnings("serial")
public class UserBaseInfo extends HttpServlet {
	private String result;
	/**
	 *   解密手机号
	 */
	private String parsePhoneNum = "http://user.jucaipen.com/ashx/AndroidUser.ashx?action=GetDecryptMobileNum";
	private Map<String, String> param=new HashMap<String, String>();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId=request.getParameter("userId");
		if(StringUtil.isNotNull(userId)){
			if(StringUtil.isInteger(userId)){
				int uId=Integer.parseInt(userId);
				if(uId>0){
					result=initBaseInfo(uId);
				}else{
					result=JsonUtil.getRetMsg(1,"用户还没登录");
				}
			}else{
				result=JsonUtil.getRetMsg(1,"userId 参数数字格式化异常");
			}
			
		}else{
			result=JsonUtil.getRetMsg(1,"userId 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initBaseInfo(int uId) {
		User user=UserServer.findBaseInfoById(uId);
		param.put("mobilenum", user.getMobileNum());
		String resJson=LoginUtil.sendHttpPost(parsePhoneNum, param);
		org.json.JSONObject object = new org.json.JSONObject(resJson);
		boolean isParse = object.getBoolean("Result");
		if (isParse) {
			String mobile = object.getString("MobileNum");
			user.setMobileNum(mobile);
		}
		return JsonUtil.getBaseInfo(user);
	}

}
