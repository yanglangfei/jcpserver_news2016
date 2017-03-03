package com.jucaipen.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Administrator
 *
 *  �����ʼ�
 */
public class EmailUtils {
	private static String HOST = "smtp.163.com";
	private static String PROTOCOL = "smtp";
	private static int PORT = 25;
	private static String FROM="13****1375@163.com";
	private static String PWD="******";

	/**
	 * @param email
	 * @param content
	 * @return  ��ȡsession
	 */
	public static Session getsession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", HOST);// ���÷�������ַ
		props.put("mail.store.protocol", PROTOCOL);// ����Э��
		props.put("mail.smtp.port", PORT);// ���ö˿�
		props.put("mail.smtp.auth", "true");
		Authenticator authenticator = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM, PWD);
			}
		};
		return Session.getDefaultInstance(props, authenticator);
	}
	
	/**
	 * @param toEmail
	 * @param content
	 *     �����ʼ�
	 */
	public static String send(String toEmail,String content,String subject){
		//��ȡsession
		Session session=getsession();
		try {
			Message msg=new MimeMessage(session);
			//���÷�����ַ
			msg.setFrom(new InternetAddress(FROM));
			//�����ռ���ַ
			InternetAddress address[]={new InternetAddress(toEmail)};
			msg.setRecipients(Message.RecipientType.TO, address);
			//�����ʼ�����
			msg.setSubject(subject);
			//�����ʼ�����ʱ��
			msg.setSentDate(new Date());
			//�����ʼ�����
			msg.setContent(content, "text/html;charset=utf-8");
			//�����ʼ�
			Transport.send(msg);
			return JsonUtil.getRetMsg(0,"�ʼ����ͳɹ�����ע�����");
		} catch (AddressException e) {
			e.printStackTrace();
			return JsonUtil.getRetMsg(1,"�ʼ���ַ����");
		} catch (MessagingException e) {
			e.printStackTrace();
			return JsonUtil.getRetMsg(2, "����ʧ��");
		}
		
	}

}
