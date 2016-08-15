package com.jucaipen.main.my;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Answer;
import com.jucaipen.model.AnswerSale;
import com.jucaipen.model.Ask;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.IdeaSale;
import com.jucaipen.model.LiveDetailSale;
import com.jucaipen.model.MySpecial;
import com.jucaipen.model.MyVideo;
import com.jucaipen.model.Special;
import com.jucaipen.model.Tactics;
import com.jucaipen.model.TacticsSale;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.TxtLiveDetails;
import com.jucaipen.model.TxtLiveSale;
import com.jucaipen.model.Video;
import com.jucaipen.service.AnswerSaleSer;
import com.jucaipen.service.AnswerSer;
import com.jucaipen.service.AskSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.IdeaSaleServer;
import com.jucaipen.service.LiveDetailSaleSer;
import com.jucaipen.service.MySpecialSer;
import com.jucaipen.service.MyVideoSer;
import com.jucaipen.service.SpecialSer;
import com.jucaipen.service.TacticsSaleSer;
import com.jucaipen.service.TacticsSer;
import com.jucaipen.service.TxtLiveDetaileSer;
import com.jucaipen.service.TxtLiveSaleSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.TimeUtils;

/**
 * @author Administrator ��ȡ�ѹ������Ϣ
 * 
 *         typeId 0 ��Ƶ 1 ר�� 2 ��־�۵� 3 ����ֱ�� ����������ֱ���� 4 �ʴ� 5 ս�� 6 ֱ���۵� ����������ֱ����
 */
@SuppressWarnings("serial")
public class QuerryMySale extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId = request.getParameter("typeId");
		String userId = request.getParameter("userId");
		String page = request.getParameter("page");
		if (StringUtil.isNotNull(userId)) {
			if (StringUtil.isInteger(userId)) {
				int uId = Integer.parseInt(userId);
				if (uId > 0) {
					if (StringUtil.isNotNull(typeId)
							&& StringUtil.isInteger(typeId)) {
						int type = Integer.parseInt(typeId);
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
							result = initMySaleInfo(uId, type, p);
						} else {
							result = JsonUtil.getRetMsg(1, "page �����쳣");
						}
					} else {
						result = JsonUtil.getRetMsg(1, "typeId �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(1, "�û���û��¼");
				}

			} else {
				result = JsonUtil.getRetMsg(1, "userId ���ָ�ʽ�쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "userId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initMySaleInfo(int uId, int type, int p) {
		if (type == 0) {
			// 0 ��Ƶ    ---�Ƿ����
			List<MyVideo> myVideos = MyVideoSer.findMyVideoByUserId(uId, p);
			for (MyVideo vd : myVideos) {
				int vId = vd.getVideoId();
				Video video = VideoServer.findVideoById(vId);
				if (video == null) {
					video = new Video();
				}
				if(TimeUtils.isLive(vd.getStartDate(), vd.getEndDate())){
					vd.setIsPurch(0);
				}else{
					vd.setIsPurch(2);
				}
				vd.setXnHits(video.getXnHitCount());
				vd.setFk_specialId(video.getPecialId());
				vd.setClassId(video.getClassId());
				vd.setVideoUrl(video.getHtmlUrl());
				vd.setVideoImag(video.getImages());
				vd.setVideoTitle(video.getTitle());
			}
			return JsonUtil.getMyVideoList(myVideos);
		} else if (type == 1) {
			// 1 ר��   ---�Ƿ����
			List<MySpecial> mySpecials = MySpecialSer.findSpecialByUid(uId, p);
			for (MySpecial mySpecial : mySpecials) {
				int sId = mySpecial.getSpecialId();
				Special special = SpecialSer.findSpecialById(sId);
				if (special == null) {
					special = new Special();
				}
				if(TimeUtils.isLive(mySpecial.getStartDate(), mySpecial.getEndDate())){
					mySpecial.setIsPurch(0);
				}else{
					mySpecial.setIsPurch(2);
				}
				List<Video> video = VideoServer.findSpecialByLast(1, sId);
				if (video != null && video.size() > 0) {
					FamousTeacher teacher = FamousTeacherSer
							.findFamousTeacherById(video.get(0).getTeacherId());
					if (teacher != null) {
						mySpecial.setTeacherName(teacher.getNickName());
					}
				}
				mySpecial.setSpecialDesc(special.getDescription());
				mySpecial.setSpecialTitle(special.getName());
			}
			return JsonUtil.getMySpecialList(mySpecials);
		} else if (type == 2) {
			// 2 ��־�۵�
			List<IdeaSale> ideaSales = IdeaSaleServer.findTxtLiveSaleByUid(uId,
					p);
			for (IdeaSale ideaSale : ideaSales) {
				int logId = ideaSale.getLogId();
				int teacherId = ideaSale.getTeacherId();
				HotIdea idea = HotIdeaServ.findIdeaById(logId);
				FamousTeacher teacher = FamousTeacherSer
						.findFamousTeacherById(teacherId);
				ideaSale.setTeacherFace(teacher.getHeadFace());
				ideaSale.setTeacherNickName(teacher.getNickName());
				ideaSale.setTeacherIsV(teacher.getIsV());
				ideaSale.setTeacherLeavel(teacher.getLevel());
				ideaSale.setLogTitle(idea.getTitle());
				ideaSale.setLogBody(idea.getBodys());
			}
			return JsonUtil.getMyIdeaList(ideaSales);
		} else if (type == 3) {
			// 3 ����ֱ�� ����
			List<TxtLiveSale> txtSales = TxtLiveSaleSer
					.findSaleByUserId(uId, p);
			if (txtSales != null) {
				for (TxtLiveSale sale : txtSales) {
					int txtId = sale.getFk_txtId();
					int tId = sale.getTeacherId();
					TextLive txt = TxtLiveSer.findTextLiveById(txtId);
					FamousTeacher teacher = FamousTeacherSer
							.findFamousTeacherById(tId);
					sale.setTeacherName(teacher.getNickName());
					sale.setFk_title(txt.getTitle());
				}
			}
			return JsonUtil.getMyTxtList(txtSales);

		} else if (type == 4) {
			// 4 �ʴ�
			List<AnswerSale> answerSales = AnswerSaleSer.findSaleByUid(uId, p);
			for (AnswerSale answerSale : answerSales) {
				Ask ask = AskSer.findAskById(answerSale.getAskId());
				List<Answer> answer = AnswerSer.findAnswerByAskId(ask.getId());
				FamousTeacher teacher = FamousTeacherSer
						.findFamousTeacherById(answerSale.getTeacherId());
				answerSale.setAskBody(ask.getAskBody());
				answerSale.setAnswerBody(answer.get(0).getAnswerBody());
				answerSale.setAnswerTeacherName(teacher.getNickName());
			}
			return JsonUtil.getMyQusestionList(answerSales);
		} else if (type == 5) {
			// 5 ս��   ----�Ƿ����
			List<TacticsSale> tacticsSales = TacticsSaleSer.findSaleByUserId(
					uId, p);
			if (tacticsSales != null) {
				for (TacticsSale tacticsSale : tacticsSales) {
					int tacticeId = tacticsSale.getTacticsId();
					Tactics tactics = TacticsSer.findTacticsById(tacticeId);
					int tId = tactics.getTeacherId();
					FamousTeacher teacher = FamousTeacherSer
							.findFamousTeacherById(tId);
					if(TimeUtils.isLive(tacticsSale.getStartDate(), tacticsSale.getEndDate())){
						tacticsSale.setIsOrder(0);
					}else{
						tacticsSale.setIsOrder(2);
					}
					tacticsSale.setTacticeImage(tactics.getImageUrl());
					tacticsSale.setTacticsTitle(tactics.getTitle());
					tacticsSale.setTeacherName(teacher.getNickName());
				}
			}
			return JsonUtil.getMyTacticsList(tacticsSales);
		} else {
			// 6 ֱ���۵� ����
			List<LiveDetailSale> txtSales = LiveDetailSaleSer.findSaleByUid(
					uId, p);
			if (txtSales != null) {
				for (LiveDetailSale detailSale : txtSales) {
					int detailId = detailSale.getLiveDetailId();
					int tId = detailSale.getTeacherId();
					TxtLiveDetails details = TxtLiveDetaileSer
							.findTextDetaileById(detailId);
					FamousTeacher teacher = FamousTeacherSer
							.findFamousTeacherById(tId);
					detailSale.setDetailBody(details.getBodys());
					detailSale.setOwnTeacher(teacher.getNickName());
				}
			}
			return JsonUtil.getMyTxtDetailList(txtSales);
		}
	}

}
