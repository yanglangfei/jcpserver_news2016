package com.jucaipen.main.video;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.MySpecial;
import com.jucaipen.model.MyVideo;
import com.jucaipen.model.Special;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.Video;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.MySpecialSer;
import com.jucaipen.service.MyVideoSer;
import com.jucaipen.service.SpecialSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator
 * 
 *         ��Ƶ����
 */
public class VideoSearch extends HttpServlet {
	private static final long serialVersionUID = 7968778839097857905L;
	private String result;
	private int isPurch;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key;
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String keyWord = request.getParameter("keyWord");
		String page = request.getParameter("page");
		String userId = request.getParameter("userId");
		String type = request.getParameter("type");
		if (StringUtil.isNotNull(keyWord)) {
			// war ȥ������ת��
			String adr = request.getLocalAddr();
			if (adr.equals("121.40.227.121")) {
				key = keyWord;
			} else {
				key = new String(keyWord.getBytes("ISO-8859-1"), "utf-8");
			}
			if (StringUtil.isNotNull(page) && StringUtil.isInteger(page)
					&& StringUtil.isNotNull(type) && StringUtil.isInteger(type)) {
				int p = Integer.parseInt(page);
				int typeId = Integer.parseInt(type);
				if (typeId == 1) {
					// ������Ƶ
					if (StringUtil.isNotNull(userId)
							&& StringUtil.isInteger(userId)) {
						int uId = Integer.parseInt(userId);
						result = searchVideo(key, uId, p);
					} else {
						result = JsonUtil.getRetMsg(3, "userId �����쳣");
					}
				} else {
					// ������ʦ
					result = searchTeacher(key);
				}
			} else {
				result = JsonUtil.getRetMsg(2, "page �����쳣");
			}

		} else {
			result = JsonUtil.getRetMsg(1, "�ؼ��ֲ���Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	/**
	 * @param key
	 * @return   ������ʦ
	 */
	private String searchTeacher(String key) {
		List<FamousTeacher> teachers = FamousTeacherSer.findTeacherByKeyWord(key);
		if(teachers!=null){
			for(FamousTeacher teacher : teachers){
				int tId=teacher.getId();
				List<TextLive> txt = TxtLiveSer.findTxtLiveByTeacherIdAndLast(tId, 1);
				if(txt!=null&&txt.size()>0){
					teacher.setLiveIsEnd(txt.get(0).getIsEnd());
				}
			}
		}
		return JsonUtil.getAllFamousTeacherList(teachers);
	}

	/**
	 * @param keyWord
	 * @param uId
	 * @param p
	 * @return  ������Ƶ
	 */
	private String searchVideo(String keyWord, int uId, int p) {
		if (uId <= 0) {
			isPurch = 1;
		}
		List<Video> videos = VideoServer.findVideoByKeyWord(keyWord, p);
		if (videos != null) {
			for (Video video : videos) {
				// �Ƿ�Ϊ������Ƶ 0Ϊ�����Ƶ��1Ϊ������Ƶ
				createVideo(video, uId);
			}
		}
		return JsonUtil.getVideoList(videos);
	}

	public void createVideo(Video video, int uId) {
		// �Ƿ�Ϊ������Ƶ 0Ϊ�����Ƶ��1Ϊ������Ƶ
		int specialId = video.getPecialId();
		int videoType = video.getVideoType();
		video.setCharge(videoType == 1);
		// 0 �ѹ��� 1 δ���� 2 �ѹ���
		if (uId > 0 && specialId > 0) {
			MySpecial mySpecial = MySpecialSer.getIsMySpecial(uId, specialId);
			if (mySpecial != null) {
				if (TimeUtils.isLive(mySpecial.getStartDate(),
						mySpecial.getEndDate())) {
					isPurch = 0;
				} else {
					isPurch = 2;
				}
			} else {
				isPurch = 1;
			}

		}

		if (uId > 0 && specialId <= 0) {
			MyVideo myVideo = MyVideoSer.findIsMyVideo(uId, video.getId());
			if (myVideo != null) {
				if (TimeUtils.isLive(myVideo.getStartDate(),
						myVideo.getEndDate())) {
					isPurch = 0;
				} else {
					isPurch = 2;
				}
			} else {
				isPurch = 1;
			}
		}
		if (specialId > 0) {
			Special special = SpecialSer.findSpecialById(specialId);
			video.setCharge(special.getIsFree() == 2);
		}
		video.setIsPurch(isPurch);
	}

}
