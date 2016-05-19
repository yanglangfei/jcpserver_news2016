package com.jucaipen.main.vide;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.TextLive;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *    ֱ��      liveType    0  ����ֱ��  ���ز����� id image title joinNums isAttention
 *                        
 *                      1  ��Ƶֱ��  ���ز�����id image title joinNums isLive
 *                      
 */
@SuppressWarnings("serial")
public class LiveList extends HttpServlet {

	private String result;
	private List<TextLive> txtLives;
	private List<FamousTeacher> teachers=new ArrayList<FamousTeacher>();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String liveType=request.getParameter("liveType");
		String page=request.getParameter("page");
		if(StringUtil.isNotNull(liveType)){
			if(StringUtil.isInteger(liveType)){
				int type=Integer.parseInt(liveType);
				if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
					int p=Integer.parseInt(page);
					if(type==0){
						//����ֱ��
						initTxtLive(p);
						result=JsonUtil.getTxtLiveList(txtLives,teachers);
					}else{
						//��Ƶֱ��
						initLive(p);
					}
				}else{
					result=JsonUtil.getRetMsg(3,"page �����쳣");
				}
				
			}else{
				result=JsonUtil.getRetMsg(2,"liveType �������ָ�ʽ�쳣");
			}
			
		}else{
			result=JsonUtil.getRetMsg(1,"liveType ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private void initLive(int page) {
		//��ʼ����Ƶֱ��
		
		
	}

	private void initTxtLive(int page) {
		//��ʼ������ֱ��
		teachers.clear();
		txtLives=TxtLiveSer.findAllTextLive(page);
		for(TextLive txt : txtLives){
			int tId=txt.getTeacherId();
			FamousTeacher teacher = FamousTeacherSer.findFamousTeacherById(tId);
			if(teacher==null){
				teacher=new FamousTeacher();
			}
			teachers.add(teacher);
		}
	}

}
