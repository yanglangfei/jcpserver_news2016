package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.TeacherAttention;
import com.jucaipen.service.TeacherAttentionSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 * 
 *         ��ע��ʦ   opType    0 ��ӹ�ע
 *                          1 ȡ����ע
 * 
 */
@SuppressWarnings("serial")
public class Attention extends HttpServlet {
	private String result;
	private int isSuccess;      
	private TeacherAttention attention;


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8")  ;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String opType=request.getParameter("opType");
		String userId = request.getParameter("userId");
		String teacherId = request.getParameter("teacherId");
		if(StringUtil.isInteger(opType)){
			int type=Integer.parseInt(opType);
			if (StringUtil.isInteger(userId)) {
				// �û�id���ָ�ʽ������
				int uId = Integer.parseInt(userId);
				if (StringUtil.isInteger(teacherId)) {
					int tId = Integer.parseInt(teacherId);
					if(type==0){
						//��ӹ�ע
						checkIsAttention(uId,tId);
						if(attention==null){
							insertAttention(uId, tId);
							if (isSuccess == 1) {
								result = JsonUtil.getRetMsg(0, "��ע��ʦ�ɹ�");
							} else {
								result = JsonUtil.getRetMsg(3, "��ע��ʦʧ��");
							}
						}else {
							result=JsonUtil.getRetMsg(6,"�Ѿ���ע�ý�ʦ");
						}
					}else if(type==1){
						checkIsAttention(uId,tId);
						if(attention!=null){
						   cancelAttention(uId, tId);
						   if (isSuccess == 1) {
								result = JsonUtil.getRetMsg(0, "ȡ����ע��ʦ�ɹ�");
							} else {
								result = JsonUtil.getRetMsg(3, "ȡ����ע��ʦʧ��");
							}
						}else {
							result=JsonUtil.getRetMsg(6,"��û��ע�ý�ʦ");
						}
						
					}else {
						result=JsonUtil.getRetMsg(5, "����id������Ҫ��");
					}
				
				} else {
					result = JsonUtil.getRetMsg(1, "��ʦid���ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "�û�id���ָ�ʽ���쳣");
			}
			
		}else {
			result=JsonUtil.getRetMsg(4,"����id���ָ�ʽ���쳣");
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void    cancelAttention(int uId, int tId) {
		// ȡ����ע
		isSuccess=TeacherAttentionSer.cancleAttention(tId, uId);
		
	}

	private void checkIsAttention(int uId, int tId) {
		//���֮ǰ�Ƿ��ע��
		attention = TeacherAttentionSer.findAttentionByUidAndTid(uId, tId);
		
	}

	private void insertAttention(int uId, int tId) {
		TeacherAttention attention = new TeacherAttention(
				0, uId, tId);
		isSuccess = TeacherAttentionSer.insertAttention(attention);

	}

}
