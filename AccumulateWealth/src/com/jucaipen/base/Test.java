package com.jucaipen.base;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.utils.ImgUtils;

/**
 * @author Administrator
 */
@SuppressWarnings("serial")
public class Test extends HttpServlet {
	private String rootPath="http://img.jucaipen.com/jucaipenStudy/2016/4/20/2016420163158.jpg";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		
		
	}
	
	public static void main(String[] args) {
		try {
			String baseUrl=ImgUtils.encodeImgageToBase64(new URL("http://img.jucaipen.com/jucaipenStudy/2016/4/20/2016420163158.jpg"));
		     System.out.println("baseUrl:"+baseUrl);
		     ImgUtils.decodeBase64ToImage(baseUrl, "D:\\ÏîÄ¿\\", "my.png");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
