package com.jucaipen.timetask;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
/**
 * �������
 * @author admin_Hzw
 *
 */
public class TimerManager {
	private static final int HOUR=0;
	private static final int MINUTE=0;
	private static final int SECOND=0;
	//ʱ����(һ��)
	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
	public TimerManager() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, HOUR); //�賿1��
		calendar.set(Calendar.MINUTE, MINUTE);
		calendar.set(Calendar.SECOND, SECOND);
		Date date=calendar.getTime(); //��һ��ִ�ж�ʱ�����ʱ��
		//�����һ��ִ�ж�ʱ�����ʱ�� С�ڵ�ǰ��ʱ��
		//��ʱҪ�� ��һ��ִ�ж�ʱ�����ʱ���һ�죬�Ա���������¸�ʱ���ִ�С��������һ�죬���������ִ�С�
		if (date.before(new Date())) {
			date = this.addDay(date, 1);
		}
		Timer timer = new Timer();
		Task task = new Task();
		//����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�
		timer.schedule(task,date,PERIOD_DAY);  
	}
	// ���ӻ��������
	public Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}

}
