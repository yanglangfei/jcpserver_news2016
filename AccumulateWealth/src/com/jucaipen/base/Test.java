package com.jucaipen.base;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.utils.LoginUtil;

/**
 * @author Administrator
 */
@SuppressWarnings("serial")
public class Test extends HttpServlet {
	private String rootPath="http://img.jucaipen.com/jucaipenStudy/2016/4/20/2016420162321.jpg";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		byte[] str = LoginUtil.sendTest(rootPath, null);
		OutputStream os = response.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		dos.write(str);
		dos.flush();
		os.flush();
		dos.close();
		os.close();
	}

}
