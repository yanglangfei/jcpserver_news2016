package com.jucaipen.base;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.jucaipen.timetask.TimerManager;

/**
 * @author 杨朗飞
 *2016年11月4日  下午4:11:47
 *
 *  监听web 容器的启动
 */
public class WebListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent config) {
		new TimerManager();
		System.out.println("启动   web  ");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
	

}
