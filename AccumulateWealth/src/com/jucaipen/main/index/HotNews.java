package com.jucaipen.main.index;
import javax.servlet.http.HttpServlet;
/**
 * @author Administrator
 *         ��ȡ�����ȵ� isIndex 
 *         0 ��ҳ   ��ҳ   ��ѡ
 *         1 ȫ������
 *      
 */
@SuppressWarnings("serial")
public class HotNews extends HttpServlet {/*
	private String result;
	private List<JcpNews> news;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");  
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			String isIndex = request.getParameter("isIndex");
			if (StringUtil.isNotNull(isIndex)) {
				if (StringUtil.isInteger(isIndex)) {
					int index = Integer.parseInt(isIndex);
					if (index == 0) {
						// ��ҳ�����ȵ�
						result=initIndexData();
					} else {
						// ��ȡ���н����ȵ�
						String page = request.getParameter("page");
						if (StringUtil.isNotNull(page)
								&& StringUtil.isInteger(page)) {
							int p = Integer.parseInt(page);
							result=initAllData(p);
						} else {
							result = JsonUtil.getRetMsg(3, "page��������");
						}
					}
				} else {
					result = JsonUtil.getRetMsg(2, "isIndex�������ָ�ʽ���쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(1, "isIndex��������Ϊ��");
			}
		} else {
			result = StringUtil.isVaild;
		}
		out.println(result);
		out.flush();
		out.close();
	}

	private String initAllData(int page) {
		// ��ȡȫ�������ȵ���Ϣ
		news = JcpNewsSer.findAll(page);
		for (JcpNews n : news) {
			int fromId = n.getComeFrom();
			String from = ResourceFromServer.getRSources(fromId);
			n.setFrom(from);
		}
		return JsonUtil.getNewsList(news);
	}

	private String initIndexData() {
		// ��ȡ��ҳ�����ȵ���Ϣ
		news = JcpNewsSer.findLastNewsByNewsNum(3);
		for (JcpNews n : news) {
			int fromId = n.getComeFrom();
			String from = ResourceFromServer.getRSources(fromId);
			n.setFrom(from);
		}
		return JsonUtil.getNewsList(news);
	}

*/}
