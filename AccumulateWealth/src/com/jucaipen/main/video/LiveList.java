package com.jucaipen.main.video;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Account;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.Guardian;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.TxtLiveSale;
import com.jucaipen.model.VideoLive;
import com.jucaipen.model.VideoLiveSale;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.TxtLiveSaleSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.service.VideoLiveSaleSer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         直播 liveType 0 文字直播 返回参数： id image title joinNums isAttention
 * 
 *         1 视频直播 返回参数：id image title joinNums isLive
 * 
 */
public class LiveList extends HttpServlet {
	private static final long serialVersionUID = -3535325712984870701L;
	private String result;
	private List<FamousTeacher> teachers = new ArrayList<FamousTeacher>();

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
			String liveType = request.getParameter("liveType");
			String page = request.getParameter("page");
			String userId = request.getParameter("userId");
			if (StringUtil.isNotNull(liveType)) {
				if (StringUtil.isInteger(liveType)) {
					int type = Integer.parseInt(liveType);
					if (StringUtil.isNotNull(page)
							&& StringUtil.isInteger(page)) {
						int p = Integer.parseInt(page);
						if (StringUtil.isNotNull(userId)
								&& StringUtil.isInteger(userId)) {
							int uId = Integer.parseInt(userId);
							if (type == 0) {
								// 文字直播
								result = initTxtLive(p, uId);
							} else {
								// 视频直播
								result = initLive(p, uId);
							}
						} else {
							result = JsonUtil.getRetMsg(4, "userId 参数异常");
						}
					} else {
						result = JsonUtil.getRetMsg(3, "page 参数异常");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "liveType 参数数字格式异常");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "liveType 参数不能为空");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initLive(int p, int uId) {
		// 初始化视频直播 ----正在直播的视频
		int isPurch = 1;
		int ownJucaiBills = 0;
		if (uId <= 0) {
			isPurch = 1;
		}

		teachers.clear();
		List<VideoLive> videos = VideoLiveServer.findLiveByIsEnd(2);
		if (videos != null) {
			for (VideoLive live : videos) {
				int tId = live.getTeacherId();
				FamousTeacher teacher = FamousTeacherSer
						.findFamousTeacherById(tId);
				if (teacher == null) {
					teacher = new FamousTeacher();
				}
				live.setLiveVideo(teacher.getIsUserLiveUrl() == 1);
				live.setCharge(teacher.getLiveFree()==1);
				live.setLivePrice(teacher.getLivePrice());
				live.setVideoUrl(teacher.getVideoLiveUrl());
				live.setTeacherName(teacher.getNickName());
				if (uId > 0) {
					Account account = AccountSer.findAccountByUserId(uId);
					VideoLiveSale sale = VideoLiveSaleSer
							.findSaleByUidAndLiveId(uId, live.getId());
					if (sale != null) {
						isPurch = 0;
					} else {
						isPurch = 1;
					}
					if (account != null) {
						ownJucaiBills = account.getJucaiBills();
					}
				}
				live.setOwnJucaiBills(ownJucaiBills);
				live.setIsPurch(isPurch);
				teachers.add(teacher);
			}
		}
		return JsonUtil.getLiveList(videos, teachers);
	}

	private String initTxtLive(int p, int uId) {
		// 初始化文字直播 ---获取正在直播的文字直播
		int isPurch = 1;
		int ownJucaiBills = 0;
		teachers.clear();
		List<TextLive> txtLives = TxtLiveSer.findTextLiveByIsEnd(2);
		for (TextLive txt : txtLives) {
			int tId = txt.getTeacherId();
			Guardian guardian=GuardianSer.findIsGuardian(tId, uId);
			txt.setGuardian(guardian!=null);
			FamousTeacher teacher = FamousTeacherSer.findFamousTeacherById(tId);
			if (teacher == null) {
				teacher = new FamousTeacher();
			}
			if(uId>0){
				Account account = AccountSer.findAccountByUserId(uId);
				TxtLiveSale sale = TxtLiveSaleSer.findSaleByUidAndTxtId(uId,
						txt.getId());
				if (sale != null) {
					isPurch = 0;
				} else {
					isPurch = 1;
				}
				if (account != null) {
					ownJucaiBills = account.getJucaiBills();
				}
			}
			txt.setOwnJucaiBills(ownJucaiBills);
			txt.setIsPurch(isPurch);
			teachers.add(teacher);
		}
		return JsonUtil.getTxtLiveList(txtLives, teachers);
	}
}
