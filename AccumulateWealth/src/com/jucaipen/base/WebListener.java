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
		//timer=new Timer();
		//timer.scheduleAtFixedRate(new MyTask(), new Date(), 1000*60*2);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//timer.cancel();
		//timer=null;

	}

}
