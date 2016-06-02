package com.jucaipen.main.index.famous;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.Ask;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.TextLive;
import com.jucaipen.service.AskSer;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *     type    (0   �۵�)   (1   �ʴ�)   (2   ����ֱ��)   (3  ��Ƶֱ��)
 */
@SuppressWarnings("serial")
public class QuerryTeacherIdea extends HttpServlet {
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String teacherId=request.getParameter("teacherId");
		String typeId=request.getParameter("typeId");
		String page=request.getParameter("page");
		if(StringUtil.isNotNull(teacherId)){
			if(StringUtil.isInteger(teacherId)){
				int tId=Integer.parseInt(teacherId);
				if(StringUtil.isNotNull(typeId)&&StringUtil.isInteger(typeId)){
					int type=Integer.parseInt(typeId);
					if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
						int p=Integer.parseInt(page);
						result=initTeacherIdeaData(tId,type,p);
					}else{
						result=JsonUtil.getRetMsg(4,"page �����쳣");
					}
				}else{
					result=JsonUtil.getRetMsg(3,"typeId �����쳣");
				}
			}else{
				result=JsonUtil.getRetMsg(2,"teacherId �������ָ�ʽ���쳣");
			}
		}else{
			result=JsonUtil.getRetMsg(1,"teacherId ��������Ϊ��");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private String initTeacherIdeaData(int tId, int type, int p) {
		// ��ʼ����ʦ���Ź۵�   �ʴ�   ����ֱ��   ֱ����Ϣ
		List<HotIdea> ideas;
		List<Ask> asks;
		List<TextLive> txts;
		if(type==0){
			//���Ź۵�
			ideas = HotIdeaServ.findIdeaByTeacherId(tId, p);
			return null;
		}else if(type==1){
			//�ʴ�
			 asks = AskSer.findAskByTeacherId(tId, p);
			 return null;
		}else if(type==2){
			//����ֱ��
			txts = TxtLiveSer.findTextLiveByTeacherId(tId,p);
			FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(tId);
			return JsonUtil.getTxtLiveByTeacherId(txts,teacher);
		}else{
			//ֱ��
			return null;
			
		}
		
		
	}

}
