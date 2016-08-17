package com.jucaipen.main.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.Favorites;
import com.jucaipen.model.Knowledge;
import com.jucaipen.model.MyVideo;
import com.jucaipen.model.Special;
import com.jucaipen.model.Video;
import com.jucaipen.service.FavoritesSer;
import com.jucaipen.service.KnowledgetSer;
import com.jucaipen.service.MyVideoSer;
import com.jucaipen.service.SpecialSer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ��ȡ�ҵ��ղ� type 0 ��Ƶ  1 ֪ʶ
 */
@SuppressWarnings("serial")
public class QuerryMyCollect extends HttpServlet {
	private String result;
	private List<Video> videos = new ArrayList<Video>();
	private List<Knowledge> knowledges = new ArrayList<Knowledge>();

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
			String userId = request.getParameter("userId");
			String page = request.getParameter("page");
			String type = request.getParameter("type");
			if (StringUtil.isNotNull(userId)) {
				if (StringUtil.isInteger(userId)) {
					int uId = Integer.parseInt(userId);
					if (uId > 0) {
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
							if (StringUtil.isNotNull(type)
									&& StringUtil.isInteger(type)) {
								int t = Integer.parseInt(type);
								result = initMyCollect(t, p, uId);
							} else {
								result = JsonUtil.getRetMsg(1, "type �����쳣");
							}

						} else {
							result = JsonUtil.getRetMsg(1, "page �����쳣");
						}

					} else {
						result = JsonUtil.getRetMsg(1, "���û���û��¼");
					}

				} else {
					result = JsonUtil.getRetMsg(1, "userId ���ָ�ʽ���쳣");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initMyCollect(int t, int p, int uId) {
		// ��ʼ���ҵ��ղ�
		videos.clear();
		knowledges.clear();
		int isPurch=1;
		List<Favorites> favourates;
		if (t == 0) {
			// ��Ƶ
			favourates = FavoritesSer.findFavourateByUidAndType(uId, 1, p);
		} else {
			// ֪ʶf
			favourates = FavoritesSer.findFavourateByUidAndType(uId, 2, p);
		}
		for (Favorites fa : favourates) {
			int fkId = fa.getFk_Id();
			if (t == 0) {
				Video video = VideoServer.findVideoById(fkId);
				MyVideo myVideo=MyVideoSer.findIsMyVideo(uId, fkId);
				if(myVideo!=null){
					if(TimeUtils.isLive(myVideo.getStartDate(), myVideo.getEndDate())){
						isPurch=0;
					}else{
						isPurch=2;
					}
				}
				fa.setIsPurch(isPurch);
				if(video!=null){
					int specialId=video.getPecialId();
					int isFree=video.getVideoType();
					fa.setCharge(isFree==1);
					Special special = SpecialSer.findSpecialById(specialId);
					fa.setSpecial(special!=null);
					videos.add(video);
				}
			} else {
				Knowledge knowledge = KnowledgetSer.findKnowledgeById(fkId);
				if(knowledge!=null){
					knowledges.add(knowledge);
				}
			}
		}
		if (t == 0) {
			return JsonUtil.getFavourateVideos(favourates, videos);
		} else {
			return JsonUtil.getFavourateKnowledge(favourates, knowledges);
		}
	}

}
