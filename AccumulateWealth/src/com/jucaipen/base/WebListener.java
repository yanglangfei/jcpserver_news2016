package com.jucaipen.base;

import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.jucaipen.timetask.MyTask;

/**
 * @author ���ʷ� 2016��11��4�� ����4:11:47
 * 
 *         ����web ����������
 */
public class WebListener implements ServletContextListener {

	private Timer timer;

	@Override
	public void contextInitialized(ServletContextEvent config) {
		// new TimerManager();
		//timer=new Timer();
		//timer.scheduleAtFixedRate(new MyTask(), new Date(), 1000*60*2);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//timer.cancel();
		//timer=null;

	}

}
