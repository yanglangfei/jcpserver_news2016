package com.jucaipen.base;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author ���ʷ� 2016��11��4�� ����4:11:47
 * 
 *         ����web ����������
 */
public class WebListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent config) {
		// new TimerManager();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
