package com.jucaipen.base;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.model.ExpressionInfo;
import com.jucaipen.service.FaceServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author YLF
 * 
 *         ���ݱ����id��ȡ��Ӧ�ı�����Ϣ
 */
@SuppressWarnings("serial")
public class QuerryExpressInfo extends HttpServlet {
	private String result;
	private List<ExpressionInfo> infos;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent=request.getParameter("User-Agent");
		ClientOsInfo os=HeaderUtil.getMobilOS(userAgent);
		int isDevice=HeaderUtil.isVaildDevice(os, userAgent);
		if(isDevice==HeaderUtil.PHONE_APP){
			String packageId = request.getParameter("packageId");
			if (StringUtil.isInteger(packageId)) {
				int typeId = Integer.parseInt(packageId);
				initExpressionInfo(typeId);
				result = JsonUtil.getExpressionInfo(infos);
			} else {
				result = JsonUtil.getRetMsg(1, "�����id�������ָ�ʽ���쳣");
			}
		}else{
			result=StringUtil.isVaild;
		}
		out.print(result);
		out.flush();
		out.close();
	}

	private void initExpressionInfo(int typeId) {
		// ���ݱ������ȡ��Ӧ�ı�����Ϣ
		infos = FaceServer.findFaceInfoByTypeId(typeId);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
