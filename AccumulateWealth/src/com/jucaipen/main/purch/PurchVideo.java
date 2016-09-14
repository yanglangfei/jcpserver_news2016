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
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.MyVideo;
import com.jucaipen.model.SysAccount;
import com.jucaipen.model.SysDetailAccount;
import com.jucaipen.model.User;
import com.jucaipen.model.Video;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.MyVideoSer;
import com.jucaipen.service.SysAccountSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ������Ƶ
 */
public class PurchVideo extends HttpServlet {
	private static final long serialVersionUID = 5603892025072935802L;
	private String result;
	private String ip;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ip = request.getRemoteAddr();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String userId = request.getParameter("userId");
			String videoId = request.getParameter("videoId");
			String bills = request.getParameter("bills");
			String days = request.getParameter("days");
			if (StringUtil.isNotNull(userId) && StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(videoId)
							&& StringUtil.isInteger(videoId)) {
						int vId = Integer.parseInt(videoId);
						if (StringUtil.isNotNull(bills)
								&& StringUtil.isInteger(bills)) {
							int b = Integer.parseInt(bills);
							if (StringUtil.isNotNull(days)
									&& StringUtil.isInteger(days)) {
								int d = Integer.parseInt(days);
								result = purchVideo(uId, vId, b, d);
							} else {
								result = JsonUtil.getRetMsg(5, "days �����쳣");
							}
						} else {
							result = JsonUtil.getRetMsg(4, "bills �����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(3, "videoId �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "�û���û��¼");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "userId �����쳣");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String purchVideo(int uId, int vId, int b, int days) {
		// 1���鿴�۲Ʊ��Ƿ��㹻
		String startDate;
		String endDate = null;
		User user = UserServer.findBaseInfoById(uId);
		Account a = AccountSer.findAccountByUserId(uId);
		if(b<=0){
			return JsonUtil.getRetMsg(6, "�ݲ�֧�ֹ���");
		}
		
		if (a == null || a.getJucaiBills() < b) {
			return JsonUtil.getRetMsg(1, "�۲Ʊ�����");
		}

		// �Ƿ��Ѿ�����
		MyVideo mVideo = MyVideoSer.findIsMyVideo(uId, vId);
		if (mVideo != null
				&& TimeUtils.isLive(mVideo.getStartDate(), mVideo.getEndDate())) {
			// ����
			return JsonUtil.getRetMsg(5, "��ǰ�û��ڶ���ʱ��Σ����ܼ�������");
		} else {
			startDate = TimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
			endDate = TimeUtils.format(TimeUtils.addBaseDay(new Date(), days),
					"yyyy-MM-dd HH:mm:ss");
		}

		Video video = VideoServer.findVideoById(vId);

		MyVideo myVideo = new MyVideo();
		myVideo.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		myVideo.setIsDel(0);
		myVideo.setIsStop(0);
		myVideo.setVideoId(vId);
		myVideo.setUserId(uId);
		myVideo.setEndDate(endDate);
		myVideo.setStartDate(startDate);
		myVideo.setRemark("������Ƶ��" + video.getTitle() + "��");

		AccountDetail detail = new AccountDetail();
		detail.setDetailMoney(b);
		detail.setDetailType(1);
		detail.setInsertDate(TimeUtils
				.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		detail.setIsDel(0);
		detail.setOrderCode("");
		detail.setRemark("������Ƶ��" + video.getTitle() + "��");
		detail.setState(0);
		detail.setUserId(uId);

		AccountDetail detailInteger = new AccountDetail();
		detailInteger.setDetailMoney(b);
		detailInteger.setDetailType(0);
		detailInteger.setInsertDate(TimeUtils.format(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		detailInteger.setIsDel(0);
		detailInteger.setOrderCode("");
		detailInteger.setRemark("������Ƶ��" + video.getTitle() + "�����˻�����+" + b);
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
		sysDetailAccount.setRemark("������Ƶ��" + video.getTitle() + "��");

		int isSuccess = RollBackUtil.purchVideo(myVideo, a, uId, b, detail,
				detailInteger, sysAccount, sysDetailAccount, user);
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "������Ƶ�ɹ�") : JsonUtil
				.getRetMsg(1, "������Ƶʧ��");
	}

}
