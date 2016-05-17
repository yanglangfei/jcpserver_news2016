package com.jucaipen.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

/**
 * @author Administrator
 *   ����
 */
public class GePushUtils {
	private static final  String appKey="7ZpsKKg0TT6fqcZDLfE066";
	private static final String masterSecret="Ty1d91F73470oBqx0ozpB9";
	private static final String appId="fcsfpKg6TT63rs47CRxG42";
	private static GePushUtils utiles=new GePushUtils();
	private static IGtPush push;
	private GePushUtils(){
		
	}
	/**
	 * @return  ʵ��������
	 */
	public static GePushUtils getInstance(){
		init();
		return utiles;
	}
	
	
	/**
	 *   ��ʼ������
	 */
	public static  void init(){
		try {
			if(push==null){
				push = new IGtPush(appKey, masterSecret);
			}
			push.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 *   �����豸����֪ͨ
	 */
	public void pushAllDev(String title,String text){
		AppMessage appMessage=new AppMessage();
		NotificationTemplate template=new NotificationTemplate();
		template.setAppId(appId);
		template.setAppkey(appKey);
		template.setTitle(title);
		template.setText(text);
		appMessage.setData(template);
		appMessage.setOffline(true);
		appMessage.setOfflineExpireTime(1000*600);
		IPushResult res=push.pushMessageToApp(appMessage);
		System.out.println("res:"+res.getResponse().toString());
	}
	
	
	/**
	 * @param msg   ��������͸����Ϣ
	 */
	public void sendMsg(String msg,String clientId){
		SingleMessage message=new SingleMessage();
		TransmissionTemplate template=new TransmissionTemplate();
		template.setAppId(appId);
		template.setAppkey(appKey);
		Target tag=new Target();
		tag.setAppId(appId);
		tag.setClientId(clientId);
		template.setTransmissionContent(msg);
		List<String> appIds=new ArrayList<String>();
		appIds.add(appId);  
		message.setData(template);
		message.setOffline(true);
		message.setOfflineExpireTime(1000*600);
		IPushResult res=push.pushMessageToSingle(message, tag);
		System.out.println("res:"+res.getResponse().toString());
	}
	
	public static void main(String[] args) {
		init();
	}
	
	/**
	 * @param msgType    ��ʼ��������Ϣ����
	 */
	public void initMessage(int msgType){
		if(msgType==0){
			//ָ��Ӧ��Ⱥ����
		//	AppMessage appMessage=new AppMessage();
		}else if(msgType==1){
			//�б�������Ϣ
		//	ListMessage listMessage=new ListMessage();
		}else{
			//������Ϣ
			//SingleMessage singleMessage=new SingleMessage();
		}
	}
	
	/**
	 * @param tempType   ��ʼ������ģ��
	 */
	public void initTemp(int tempType){
		if(tempType==0){
			//���֪ͨ��Appģ��
		 //   NotificationTemplate notificationTemplate=new NotificationTemplate();	
		}else if(tempType==1){
			//���֪ͨ������ģ��
			//LinkTemplate linkTemplate=new LinkTemplate();
		}else if(tempType==2){
			//͸��ģ��
		//	TransmissionTemplate transmissionTemplate=new TransmissionTemplate();
		}else{
			//֪ͨ����������ģ��
		//	NotyPopLoadTemplate notyPopLoadTemplate=new NotyPopLoadTemplate();
		}
		
	}
	

}
