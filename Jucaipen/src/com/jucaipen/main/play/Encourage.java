package com.jucaipen.main.play;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.service.StudioSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;

/**
 * @author Administrator
 *
 *   �ݲ���   ��Ŀ����
 */
@SuppressWarnings("serial")
public class Encourage extends HttpServlet {
	private String result;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String liveId=request.getParameter("liveId");
		if(StringUtil.isNotNull(liveId)&&StringUtil.isInteger(liveId)){
			int lId=Integer.parseInt(liveId);
			result=addEncourage(lId);
		}else{
			result=JsonUtil.getRetMsg(2,"liveId �������ָ�ʽ���쳣");
		}
		out.println(result);
		out.flush();
		out.close();
	}
	
	
	private String addEncourage(int liveId) {
		int renQi=StudioSer.findStudioRenQiById(liveId);
		int isSuccess=StudioSer.updateStudioRenQiById(liveId, renQi+1);
		return isSuccess==1 ? JsonUtil.getRetMsg(0, "�����ɹ�") : JsonUtil.getRetMsg(1,"����ʧ��");
	}

}
