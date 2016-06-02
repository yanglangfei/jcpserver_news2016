package com.jucaipen.main.index.famous;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Answer;
import com.jucaipen.model.Ask;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.User;
import com.jucaipen.service.AnswerSer;
import com.jucaipen.service.AskSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ȡ�ʴ���ϸ��Ϣ
 */
@SuppressWarnings("serial")
public class AnswerDetails extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String askId = request.getParameter("askId");
		if (StringUtil.isNotNull(askId)) {
			if (StringUtil.isInteger(askId)) {
				int id = Integer.parseInt(askId);
				result = initAskData(id);
			} else {
				result = JsonUtil.getRetMsg(2, "askId �������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "askId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initAskData(int id) {
		// ��ʼ���ʴ���ϸ��Ϣ
		Ask ask = AskSer.findAskById(id);
		int isReply = ask.getAskState();
		int uId = ask.getUserId();
		User user = UserServer.findUserById(uId);
		if (isReply == 2) {
			Answer answer = AnswerSer.findAnswerByAskId(id);
			int tId = answer.getTeacherId();
			FamousTeacher teacher = FamousTeacherSer.findFamousTeacherById(tId);
			return JsonUtil.getAnswerDetails(ask, answer, teacher, user);
		} else {
			return JsonUtil.getAskDetails(ask, user);
		}

	}

}
