package com.jucaipen.base;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.jucaipen.timetask.TimerManager;

/**
 * @author ���ʷ�
 *2016��11��4��  ����4:11:47
 *
 *  ����web ����������
 */
public class WebListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent config) {
		new TimerManager();
		System.out.println("����   web  ");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
	

}
