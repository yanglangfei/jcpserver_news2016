package com.jucaipen.main.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *   ��ȡ��ʦ��Ϣ     isIndex   0   ��ҳ�Ƽ���ʦ     ���ز�����id image nickname isV notice attentions leavl isAttention 
 *                            [{"id":1,"nickName":"Դ��","headFace":"","level":"����Ͷ����",
 *                            "isV":0,"notice":"0","fans":17}
 *                         1   ȫ����ʦ�б�  ���ز�����
 *                            [{"page":1,"totlePage":1,"id":1,
 *                            "nickName":"Դ��","headFace":"","level":"����Ͷ����",
 *                            "isV":0,"notice":"0","fans":17}
 */
@SuppressWarnings("serial")
public class QuerryTeacher extends HttpServlet {
	private String result;
	private List<com.jucaipen.model.FamousTeacher> teachers;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    String isIndex=request.getParameter("isIndex");
	    if(StringUtil.isNotNull(isIndex)){
	    	if(StringUtil.isInteger(isIndex)){
	    		int index=Integer.parseInt(isIndex);
	    		if(index==0){
	    			//��ҳ�Ƽ���ʦ
	    			initIndexData();
	    			result=JsonUtil.getFamousTeacherList(teachers);
	    		}else{
	    			//ȫ����ʦ�б�
	    			String page=request.getParameter("page");
	    			if(StringUtil.isNotNull(page)&&StringUtil.isInteger(page)){
	    				int p=Integer.parseInt(page);
	    				initAllData(p);
	    				result=JsonUtil.getFamousTeacherList(teachers);
	    			}else{
	    				result=JsonUtil.getRetMsg(3, "page��������");
	    			}
	    		}
	    	}else{
	    		result=JsonUtil.getRetMsg(2,"isIndex�������ָ�ʽ���쳣");
	    	}
	    }else{
	    	result=JsonUtil.getRetMsg(1,"isIndex��������Ϊ��");
	    }
		out.println(result);
		out.flush();
		out.close();
	}

	private void initAllData(int page) {
		//��ʼ��ȫ����ʦ��Ϣ
		teachers=FamousTeacherSer.findAllFamousTeacher(page);
	}

	private void initIndexData() {
		//��ʼ����ҳ��ʦ�Ƽ��б���Ϣ
		teachers=FamousTeacherSer.findFamousTeacherByIndex(3);
	}

}
