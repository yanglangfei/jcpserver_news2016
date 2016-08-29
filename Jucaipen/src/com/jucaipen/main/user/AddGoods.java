package com.jucaipen.main.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.HotIdea;
import com.jucaipen.model.JcpNews;
import com.jucaipen.model.Knowledge;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.Video;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.JcpNewsSer;
import com.jucaipen.service.KnowledgetSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ���µ�����
 * 
 *         1 �۵������ 2 ֪ʶ������ 3 ����ֱ�������� 4 ��Ѷ������ 5 ��Ƶ������ 6 ��Ƶ���۵���
 * 
 */
public class AddGoods extends HttpServlet {
	private static final long serialVersionUID = -9204248834484763251L;
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String typeId = request.getParameter("typeId");
		String fkId = request.getParameter("fkId");
		String parentId = request.getParameter("parentId");
		if (StringUtil.isNotNull(typeId) && StringUtil.isInteger(typeId)) {
			int type = Integer.parseInt(typeId);
			if (StringUtil.isNotNull(fkId) && StringUtil.isInteger(fkId)) {
				int fId = Integer.parseInt(fkId);
				result = initGoods(type, fId, parentId);
			} else {
				result = JsonUtil.getRetMsg(2, "fkId �����쳣");
			}

		} else {
			result = JsonUtil.getRetMsg(1, "typeId �����쳣");
		}

		out.println(result);
		out.flush();
		out.close();
	}

	private String initGoods(int type, int fId, String parentId) {
		int isSuccess = 0;
		if (type == 1) {
			// �۵�
			HotIdea idea = HotIdeaServ.findGoodAndHitAndComm(fId);
			isSuccess = HotIdeaServ.addGood(fId, idea.getGoods() + 1);
		} else if (type == 2) {
			// ֪ʶ
			Knowledge knowledge = KnowledgetSer.findHitAndGoods(fId);
			isSuccess = KnowledgetSer.addGoods(fId, knowledge.getGoods() + 1);
		} else if (type == 3) {
			// ����ֱ��
			TextLive live = TxtLiveSer.findHitsAndGoods(fId);
			isSuccess = TxtLiveSer.addGoods(fId, live.getGoods() + 1);
		} else if (type == 4) {
			// ��Ѷ
			JcpNews news = JcpNewsSer.findHitsAndGoods(fId);
			isSuccess = JcpNewsSer.addGoods(fId, news.getZan() + 1);
		} else if (type == 5) {
			// ��Ƶ
			Video video=VideoServer.findHitsAndGoods(fId);
            isSuccess=VideoServer.updateGoods(fId, video.getGoods()+1);
		}
		return isSuccess == 1 ? JsonUtil.getRetMsg(0, "���޳ɹ�") : JsonUtil
				.getRetMsg(1, "����ʧ��");
	}

}
