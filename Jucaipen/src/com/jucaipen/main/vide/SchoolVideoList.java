package com.jucaipen.main.vide;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.Video;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.JsonUtil;
/**
 * @author Administrator
 *
 *    ��ȡѧԺ��Ƶ�̳��б�
 */
@SuppressWarnings("serial")
public class SchoolVideoList extends HttpServlet {
	private List<Video> videos;
	private String result;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		initTeachList();
		result=JsonUtil.getTeachVideList(videos);
		out.println(result);
		out.flush();
		out.close();
	}

	private void initTeachList(){
		//��ʼ����Ƶ�̳�
		videos=VideoServer.findVideoByClassIdLast(4, 6);
	}

}
