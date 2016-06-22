package com.jucaipen.main.index.famous;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.TextLive;
import com.jucaipen.model.TxtLiveDetails;
import com.jucaipen.service.TxtLiveDetaileSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *         ��ȡ����ֱ����ϸ��Ϣ
 */
@SuppressWarnings("serial")
public class TxtDetails extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String txtId = request.getParameter("txtId");
		if (StringUtil.isNotNull(txtId)) {
			if (StringUtil.isInteger(txtId)) {
				int tId = Integer.parseInt(txtId);
				result = initTxtDetails(tId);
			} else {
				result = JsonUtil.getRetMsg(2, "txtId �������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "txtId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initTxtDetails(int tId) {
		// ��ʼ������ֱ����ϸ��Ϣ
		TextLive live = TxtLiveSer.findTextLiveById(tId);
		if(live==null){
			return JsonUtil.getRetMsg(6,"ֱ����Ϣ������");
		}
		List<TxtLiveDetails> txtDetails = TxtLiveDetaileSer
				.findTextDetaileByLiveId(tId,0);
		return JsonUtil.getTxtDetails(txtDetails);
	}

}
