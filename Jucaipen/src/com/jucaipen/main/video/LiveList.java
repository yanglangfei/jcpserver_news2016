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
import com.jucaipen.model.TextLive;
import com.jucaipen.model.TxtLiveSale;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLive;
import com.jucaipen.model.VideoLiveSale;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.TxtLiveSaleSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveSaleSer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ֱ�� liveType 0 ����ֱ�� ���ز����� id image title joinNums isAttention
 * 
 *         1 ��Ƶֱ�� ���ز�����id image title joinNums isLive
 * 
 */
@SuppressWarnings("serial")
public class LiveList extends HttpServlet {
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
			String userId=request.getParameter("userId");
			if (StringUtil.isNotNull(liveType)) {
				if (StringUtil.isInteger(liveType)) {
					int type = Integer.parseInt(liveType);
					if (StringUtil.isNotNull(page)
							&& StringUtil.isInteger(page)) {
						int p = Integer.parseInt(page);
						if(StringUtil.isNotNull(userId)&&StringUtil.isInteger(userId)){
							int uId=Integer.parseInt(userId);
							if (type == 0) {
								// ����ֱ��
								result = initTxtLive(p,uId);
							} else {
								// ��Ƶֱ��
								result = initLive(p,uId);
							}
						}else{
							result = JsonUtil.getRetMsg(4, "userId �����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(3, "page �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(2, "liveType �������ָ�ʽ�쳣");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "liveType ��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initLive(int page,int uId) {
		// ��ʼ����Ƶֱ��    ----����ֱ������Ƶ
		int isPurch=1;
		if(uId<=0){
			isPurch=1;
		}
		
		teachers.clear();
		List<VideoLive> videos = VideoLiveServer.findLiveByIsEnd(2);
		if(videos!=null){
			for (VideoLive live : videos) {
				int tId = live.getTeacherId();
				FamousTeacher teacher = FamousTeacherSer.findFamousTeacherById(tId);
				if (teacher == null) {
					teacher = new FamousTeacher();
				}
				live.setLiveVideo(teacher.getIsUserLiveUrl()==1);
				live.setCharge(teacher.getLiveFree()==1);
				live.setLivePrice(teacher.getLivePrice());
				live.setVideoUrl(teacher.getVideoLiveUrl());
				if(uId>0){
					VideoLiveSale sale=VideoLiveSaleSer.findSaleByUidAndLiveId(uId, live.getId());
				    if(sale!=null){
				    	isPurch=0;
				    }else{
				    	isPurch=1;
				    }
				}
				live.setIsPurch(isPurch);
				teachers.add(teacher);
			}
		}
		return JsonUtil.getLiveList(videos, teachers);

	}

	private String initTxtLive(int page,int uId) {
		// ��ʼ������ֱ��   ---��ȡ����ֱ��������ֱ��
		int isPurch=1;
		int ownJucaiBills=0;
		if(uId<=0){
			isPurch=1;
		}
		teachers.clear();
		List<TextLive> txtLives = TxtLiveSer.findTextLiveByIsEnd(2);
		for (TextLive txt : txtLives) {
			int tId = txt.getTeacherId();
			FamousTeacher teacher = FamousTeacherSer.findFamousTeacherById(tId);
			if (teacher == null) {
				teacher = new FamousTeacher();
			}
			if(uId>0){
				Account account=AccountSer.findAccountByUserId(uId);
				TxtLiveSale sale=TxtLiveSaleSer.findSaleByUidAndTxtId(uId, txt.getId());
			    if(sale!=null){
			    	isPurch=0;
			    }else{
			    	isPurch=1;
			    }
			    if(account!=null){
			    	 ownJucaiBills=account.getJucaiBills();
			    }
			}
			txt.setOwnJucaiBills(ownJucaiBills);
			txt.setIsPurch(isPurch);
			teachers.add(teacher);
		}
		return JsonUtil.getTxtLiveList(txtLives, teachers);
	}

}
