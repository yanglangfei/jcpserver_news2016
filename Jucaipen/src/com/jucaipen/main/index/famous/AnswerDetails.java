package com.jucaipen.main.index.famous;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.jucaipen.model.Answer;
import com.jucaipen.model.Ask;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.service.AnswerSer;
import com.jucaipen.service.AskSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         获取主问答   ---主问答
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
				result = JsonUtil.getRetMsg(2, "askId 参数数字格式化异常");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "askId 参数不能为空");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initAskData(int id) {
		// 初始化问答详细信息
		Ask ask = AskSer.findAskById(id);
		int isReply = ask.getIsReply();
		if (isReply == 2) {           
			List<Answer> answer = AnswerSer.findAnswerByAskId(id);
			if(answer!=null){
				for(Answer ans : answer){
					int teacherId=ans.getTeacherId();
					FamousTeacher teacher = FamousTeacherSer.findFamousTeacherById(teacherId);
					if(teacher==null){
						teacher=new FamousTeacher();
					}
					ans.setTeacherFace(teacher.getHeadFace());
					ans.setTeacherName(teacher.getNickName());
					ans.setTeacherLeavel(teacher.getLevel());
				}
			}
			return JsonUtil.getAnswerDetails( answer);
		}
		return new JsonArray().toString();
	}
}
