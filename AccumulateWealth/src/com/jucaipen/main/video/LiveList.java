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
import com.jucaipen.model.LiveRecoder;
import com.jucaipen.model.LiveRecoderSale;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.TxtLiveSale;
import com.jucaipen.model.VideoLive;
import com.jucaipen.service.AccountSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.GuardianSer;
import com.jucaipen.service.LiveRecoderSaleSer;
import com.jucaipen.service.LiveRecoderSer;
import com.jucaipen.service.TxtLiveSaleSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.service.VideoLiveServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LiveUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;
/**
 * @author Administrator
 * 
 *         ֱ�� liveType 0 ����ֱ�� ���ز����� id image title joinNums isAttention
 * 
 *         1 ��Ƶֱ�� ���ز�����id image title joinNums isLive
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
								// ����ֱ��
								result = initTxtLive(p, uId);
							} else {
								// ��Ƶֱ��
								result = initLive(p, uId);
							}
						} else {
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

	private String initLive(int p, int uId) {
		// ��ʼ����Ƶֱ�� ----����ֱ������Ƶ
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
				// ��ʦ�Ƿ�ֱͨ������ 0 �� 1 ��
				live.setLiveVideo(teacher.getIsUserLiveUrl() == 1);
				// �Ƿ��շ� 0 �� 1 ��
				live.setCharge(teacher.getLiveFree() == 1);
				// ����ֱ���۸�
				live.setLivePrice(teacher.getLivePrice());
				// ����url
				live.setVideoUrl(teacher.getMobileLiveUrl());
				live.setTeacherName(teacher.getNickName());
				// Ĭ��δ��ͨ�ػ�
				live.setGradian(false);
				if (live.isCharge()) {
					if (uId > 0) {
						// �Ƿ�ͨ�ػ�
						Account account = AccountSer.findAccountByUserId(uId);
						live.setGradian(LiveUtil.isGradian(tId, uId));
						LiveRecoder resoder = LiveRecoderSer
						.getRecoderByLiveId(live.getId());
						if(resoder!=null){
							LiveRecoderSale sale = LiveRecoderSaleSer
									.getLiveSaleByUidAndLiveId(uId,resoder.getId());
							if(sale!=null){
								isPurch = 0;
							}else{
								isPurch = 1;
							}
						}else{
							isPurch = 1;
						}
						if (account != null) {
							ownJucaiBills = account.getJucaiBills();
						}
					} else {
						isPurch = 1;
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
		// ��ʼ������ֱ�� ---��ȡ����ֱ��������ֱ��
		int isPurch = 1;
		int ownJucaiBills = 0;
		teachers.clear();
		List<TextLive> txtLives = TxtLiveSer.findTextLiveByIsEnd(2);
		if (txtLives.size() <= 0) {
			// ��ȡǰһ�������ֱ����Ϣ
			String time = TimeUtils.getLastDate(-1);
			txtLives = TxtLiveSer.findLastLive(time);
		}
		if (txtLives.size() <= 0) {
			String time = TimeUtils.getLastDate(-2);
			txtLives = TxtLiveSer.findLastLive(time);
		}
		for (TextLive txt : txtLives) {
			int tId = txt.getTeacherId();
			Guardian guardian = GuardianSer.findIsGuardian(tId, uId);
			FamousTeacher teacher = FamousTeacherSer.findFamousTeacherById(tId);
			if (teacher == null) {
				teacher = new FamousTeacher();
			}
			if (uId > 0) {
				Account account = AccountSer.findAccountByUserId(uId);
				List<TxtLiveSale> sale = TxtLiveSaleSer.findSaleByUserIdAndTiD(
						uId, tId);
				if (sale != null && sale.size() > 0) {
					for (TxtLiveSale sa : sale) {
						if (TimeUtils
								.isLive(sa.getStartDate(), sa.getEndDate())) {
							isPurch = 0;
							break;
						} else {
							isPurch = 1;
						}
					}
				} else {
					isPurch = 1;
				}

				if (account != null) {
					ownJucaiBills = account.getJucaiBills();
				}
			}
			txt.setOwnJucaiBills(ownJucaiBills);
			teachers.add(teacher);
			txt.setGuardian(guardian != null);
			txt.setIsPurch(guardian != null ? 0 : isPurch);
		}
		return JsonUtil.getTxtLiveList(txtLives, teachers);
	}
}
