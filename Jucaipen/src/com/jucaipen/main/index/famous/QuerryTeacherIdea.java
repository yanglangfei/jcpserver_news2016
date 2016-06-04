package com.jucaipen.main.index.famous;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Ask;
import com.jucaipen.model.HotIdea;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.User;
import com.jucaipen.model.VideoLive;
import com.jucaipen.service.AskSer;
import com.jucaipen.service.HotIdeaServ;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.service.UserServer;
import com.jucaipen.service.VideoLiveServer;
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
		if(type==0){
			//���Ź۵�
			List<HotIdea> ideas = HotIdeaServ.findIdeaByTeacherId(tId, p);
			return JsonUtil.getIdeaList(ideas);
		}else if(type==1){
			//�ʴ�
			 List<Ask> asks = AskSer.findAskByTeacherId(tId, p);
			 List<User> users=new ArrayList<User>();
			 for(Ask ask : asks){
				 int uId=ask.getUserId();
				 User user=UserServer.findUserById(uId);
				 if(user==null){
					 user=new User();
				 }
				 users.add(user);
			 }
			 return JsonUtil.getAskList(asks, users);
		}else if(type==2){
			//����ֱ��
			List<TextLive> txts = TxtLiveSer.findTextLiveByTeacherId(tId,p);
			return JsonUtil.getTxtLiveByTeacherId(txts);
		}else{
			//ֱ��
			List<VideoLive> lives = VideoLiveServer.findLiveBytId(tId);
			return JsonUtil.getLive(lives);
			
		}
		
		
	}

}
