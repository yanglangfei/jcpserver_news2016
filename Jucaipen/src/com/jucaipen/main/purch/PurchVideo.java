package com.jucaipen.main.purch;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.main.datautils.RollBackUtil;
import com.jucaipen.model.Account;
import com.jucaipen.model.AccountDetail;
import com.jucaipen.model.MyVideo;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.User;
import com.jucaipen.model.Video;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ¹ºÂòÊÓÆµ ×¨¼­
 */
@SuppressWarnings("serial")
public class PurchVideo extends HttpServlet {
	private String result;
	private String ip;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ip = request.getRemoteAddr();
		String userId = request.getParameter("userId");
		String videoId = request.getParameter("videoId");
		String bills = request.getParameter("bills");
		if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
			int uId = Integer.parseInt(userId);
			if (uId > 0) {
				if (StringUtil.isNotNull(videoId)
						&& StringUtil.isInteger(videoId)) {
					int vId = Integer.parseInt(videoId);
					if (StringUtil.isNotNull(bills)
							&& StringUtil.isInteger(bills)) {
						int b = Integer.parseInt(bills);

						result = purchVideo(uId, vId, b);
					}
				}
			}

		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String purchVideo(int uId, int vId, int b) {
		// 1¡¢²é¿´¾Û²Æ±ÒÊÇ·ñ×ã¹»
		User user = UserServer.findBaseInfoById(uId);
		Account a = AccountSer.findAccountByUserId(uId);
		if (a == null || a.getJucaiBills() < b) {
			return JsonUtil.getRetMsg(1, "¾Û²Æ±ÒÓà¶î²»×ã");
		}

		Video video = VideoServer.findVideoById(vId);

		MyVideo myVideo = new MyVideo();
		myVideo.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		myVideo.setIsDel(0);
		myVideo.setIsStop(0);
		myVideo.setVideoId(vId);
		myVideo.setUserId(uId);
		myVideo.setRemark("¹ºÂòÊÓÆµ¡¾" + video.getTitle() + "¡¿");

		AccountDetail detail = new AccountDetail();
		detail.setDetailMoney(b);
		detail.setDetailType(1);
		detail.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detail.setIsDel(0);
		detail.setOrderCode("");
		detail.setRemark("¹ºÂòÊÓÆµ¡¾" + video.getTitle() + "¡¿");
		detail.setState(0);
		detail.setUserId(uId);

		AccountDetail detailInteger = new AccountDetail();
		detailInteger.setDetailMoney(b);
		detailInteger.setDetailType(0);
		detailInteger.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detailInteger.setIsDel(0);
		detailInteger.setOrderCode("");
		detailInteger.setRemark("¹ºÂòÊÓÆµ¡¾" + video.getTitle() + "¡¿£¬ÕË»§»ý·Ö+" + b);
		detailInteger.setState(1);
		detailInteger.setUserId(uId);

		SysAccount sysAccount = SysAccountSer.findAccountInfo();

		SysDetailAccount sysDetailAccount = new SysDetailAccount();
		sysDetailAccount.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		sysDetailAccount.setIp(ip);
		sysDetailAccount.setIsDel(0);
		sysDetailAccount.setOrderId(0);
		sysDetailAccount.setPrice(b);
		sysDetailAccount.setRecoderType(2);
		sysDetailAccount.setType(10);
		sysDetailAccount.setUserId(uId);
		sysDetailAccount.setRemark("¹ºÂòÊÓÆµ¡¾" + video.getTitle() + "¡¿");


		int isSuccess = RollBackUtil.purchVideo(myVideo, a, uId, b, detail,
				detailInteger, sysAccount, sysDetailAccount, user);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "¹ºÂòÊÓÆµ³É¹¦") : JsonUtil
				.getRetMsg(1, "¹ºÂòÊÓÆµÊ§°Ü");
	}

}
