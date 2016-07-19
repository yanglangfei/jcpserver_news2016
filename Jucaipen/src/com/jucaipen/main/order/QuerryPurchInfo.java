package com.jucaipen.main.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Account;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Guardian;
import com.jucaipen.model.Special;
import com.jucaipen.model.User;
import com.jucaipen.model.Video;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.MySpecialSer;
import com.jucaipen.service.MyVideoSer;
import com.jucaipen.service.SpecialSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取支付信息
 * 
 *         typeId 0 视频 1 专辑 2 守护
 */
@SuppressWarnings("serial")
public class QuerryPurchInfo extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId = request.getParameter("typeId");
		String fkId = request.getParameter("fkId");
		String userId = request.getParameter("userId");
		if (StringUtil.isNotNull(typeId) && StringUtil.isInteger(typeId)) {
			int type = Integer.parseInt(typeId);
			if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(fkId)
							&& StringUtil.isInteger(fkId)) {
						int fId = Integer.parseInt(fkId);
						result = initPurchInfo(type, fId, uId);
					} else {
						result = JsonUtil.getRetMsg(2, "fkId 参数异常");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "用户还没登录");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "userId 参数异常");
			}

		} else {
			result = JsonUtil.getRetMsg(1, "typeId 参数异常");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initPurchInfo(int type, int fId, int uId) {
		int ownJucaiBills;
		Account account = AccountSer.findAccountByUserId(uId);
		if (account != null) {
			ownJucaiBills = account.getJucaiBills();
		} else {
			ownJucaiBills = 0;
		}
		if (type == 0) {
			// 视频
			Video video = VideoServer.findVideoById(fId);
			int sallNum = MyVideoSer.getPurchVideoNum(fId);
			return JsonUtil.getVideoPurchInfo(video, ownJucaiBills, sallNum);
		} else if (type == 1) {
			// 专辑
			Special special = SpecialSer.findSpecialById(fId);
			int sallNum = MySpecialSer.getSpecialSallNum(fId);
			return JsonUtil
					.getSpecialPurchInfo(special, ownJucaiBills, sallNum);
		} else if (type == 2) {
			// 守护信息
			User user = UserServer.findBaseInfoById(uId);
			FamousTeacher teacher = FamousTeacherSer.findPurchInfo(fId);
			Guardian guardian=GuardianSer.findIsGuardian(fId, uId);
			return JsonUtil.getGuardianPurchInfo(user, teacher,ownJucaiBills,guardian);
		}
		return null;    
	}

}
