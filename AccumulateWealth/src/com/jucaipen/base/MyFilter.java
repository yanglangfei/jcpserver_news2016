package com.jucaipen.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MyFilter implements Filter {

	private String charset;

	@Override
	public void destroy() {
		//销毁

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		/*//过滤逻辑
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String methd=req.getMethod();
		if(charset==null||"".equals(charset)){
			charset="UTF-8";
		}
		if(methd.toLowerCase().equals("get")){
			req.setCharacterEncoding(charset);
			resp.setCharacterEncoding(charset);
		}
		String url = req.getRequestURI();
		System.out.println("url:"+url);*/
		/*else{
			
		}
		
		if(url.equals("login")){
			
			
		}*/
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//初始化
		charset=config.getInitParameter("charset");
	}

}
