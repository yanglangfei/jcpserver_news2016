package com.jucaipen.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.Bank;
import com.jucaipen.service.BankSer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.MsgCode;

/**
 * @author Administrator
 * 
 *         ��ȡ���п��б�
 */
@SuppressWarnings("serial")
public class QuerryBankList extends HttpServlet {
	private String result;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		result = initBankList();
		out.println(result);
		out.flush();
		out.close();
	}

	private String initBankList() {
		// ��ʼ�����п��б�
		List<Bank> banks = BankSer.findAllBank();
		return MsgCode.CURRENT_VERSION == MsgCode.HISTORY_VISION_1 ? JsonUtil
				.getBankList(banks) : JsonUtil.getBankListV2(banks,
				MsgCode.RET_SUCCESS_CODE, MsgCode.RET_SUCCESS);
	}

}
