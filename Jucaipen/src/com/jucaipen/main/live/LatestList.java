package com.jucaipen.main.live;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Rebate;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLive;
import com.jucaipen.service.RebateSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *         获取最新榜单信息 type 0 日榜单 1 月榜单
 */
@SuppressWarnings("serial")
public class LatestList extends HttpServlet {
	private String result;

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
			String type = request.getParameter("type");
			String liveId = request.getParameter("liveId");
			if (!StringUtil.isNotNull(type)) {
				result = JsonUtil.getRetMsg(1, "type 参数不能为空");
			} else {
				if (StringUtil.isInteger(type)) {
					int t = Integer.parseInt(type);
					if (StringUtil.isNotNull(liveId)
							&& StringUtil.isInteger(liveId)) {
						int lId = Integer.parseInt(liveId);
						result = initlist(t, lId);
					} else {
						result = JsonUtil.getRetMsg(3, "liveId 参数异常");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "type 参数数字格式化异常");
				}
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	public String initlist(int t, int lId) {
		// 初始化榜单信息
		VideoLive live = VideoLiveServer.getRoomInfo(lId);
		int tId = live.getTeacherId();
		if (t == 0) {
			// 日榜单
			// SELECT SUM(RebateMoney),FK_FromUserId from JCP_Rebate WHERE
			// FK_TearchId=1 AND DATEDIFF(day, InsertDate, GETDATE())=0 GROUP
			// BY FK_FromUserId;
			List<Rebate> rebateArray=RebateSer.findDayRebateByTeacher(tId);
			
			for (Rebate rebate : rebateArray) {
				int userId = rebate.getFromId();
				User user = UserServer.findUserById(userId);
				rebate.setFromName(user.getNickName());
				rebate.setFromFace(user.getFaceImage());
			}
			return JsonUtil.getLateList(rebateArray);
		} else {
			// 月榜单
			// SELECT SUM(RebateMoney),FK_FromUserId from JCP_Rebate WHERE
			// FK_TearchId=1 AND DATEDIFF(month, InsertDate, GETDATE())=0 GROUP
			// BY FK_FromUserId;
			List<Rebate> rebateArray=RebateSer.findMothRebateByTeacher(tId);
			for (Rebate rebate : rebateArray) {
				int userId = rebate.getFromId();
				User user = UserServer.findUserById(userId);
				rebate.setFromName(user.getNickName());
				rebate.setFromFace(user.getFaceImage());
			}
			return JsonUtil.getLateList(rebateArray);
		}

	}

}
