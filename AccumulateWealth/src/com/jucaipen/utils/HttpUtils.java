package com.jucaipen.utils;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpUtils {
	private static String sendChatPath = "http://chat.jucaipen.com/ashx/chat_msg.ashx?action=add";
	private static String getTopCount = "http://chat.jucaipen.com/ashx/chat_msg.ashx?action=getTopId";

	/**
	 * @param path
	 * @param id
	 *            topId roomId userId
	 * 
	 *            ��ȡ�����¼
	 */
	public static String sendHttpPost(String path, int... id) {
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Proxy-Connection", "Keep-Alive");
			conn.setRequestProperty("accept", "*/");
			conn.setReadTimeout(1000 * 5);
			conn.setConnectTimeout(1000 * 5);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			PrintWriter out = new PrintWriter(conn.getOutputStream());
			out.print("topId=" + id[0] + "&roomid=" + id[1] + "&userId="
					+ id[2] + "&isServer=" + id[3]);
			out.flush();
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
			InputStream is = conn.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			byte bs[] = new byte[dis.available()];
			dis.read(bs);
			String data = new String(bs, "UTF-8");
			return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @param msgcontent
	 *            ������Ϣ
	 * @param sendusername
	 *            �����û��ǳ�
	 * @param SendUserId
	 *            �����û�id
	 * @param roomid
	 *            ֱ����id
	 * @return ����������Ϣ
	 * 
	 * 
	 * 
	 *         /*������Ϣ�ӿڣ�http://chat.jucaipen.com/ashx/chat_msg.ashx?action=add
	 * 
	 *         ��Ҫ���ݲ�����msgcontent����Ϣ���ݣ���sendusername���������ǳƣ���fasongface��������ͷ�񣩡�
	 *         SendUserId��������ID����roomid������ID����
	 *         jieshouname���������ǳƣ���jieshouid��������ID
	 *         ����ReceiverNameId���������û�������sendusernameid���������û�������
	 *         userLevel���û���ƷID��
	 *         ��ReceiveLevel�����ղ�ƷID����ReceiveManger�������û��Ƿ�Ϊ����Ա����SendManager
	 *         ���������Ƿ�Ϊ�� ��Ա��1Ϊ����Ա0Ϊ��ͨ�û�����
	 *         ReceiveServiceId��������Ϣ�ķ���ID����SendServiceId
	 *         ��������Ϣ�ķ���ID����MessType����Ϣ���ͣ�0ΪȺ�ģ�1Ϊ˽�ţ���
	 * 
	 * 
	 * 
	 *         �����¼�ӿڣ�http://chat.jucaipen.com/ashx/chat_msg.ashx?action=getlist
	 * 
	 *         ��Ҫ���ݲ�����topId����ʾ����ʮ����Ϣ����roomid������ID����userId���û�ID���ο��û�IDΪ0����
	 *         isServer��0Ϊ��ͨ�û����οͣ�1Ϊ����Ա��� ����
	 * 
	 * 
	 * 
	 *         ����topId�ӿ�:http://chat.jucaipen.com/ashx/chat_msg.ashx?action=
	 *         getTopId
	 * 
	 *         ��Ҫ���ݲ�����userType(�û��Ƿ�Ϊ����Ա)��topCount����ʾ��������roomId������id����
	 *         isServer���Ƿ�Ϊ�ͷ�����
	 * 
	 * 
	 *         �����б�ӿڣ�http://chat.jucaipen.com/ashx/addface.ashx
	 */
	public static String sendChatMessage(String msgcontent,
			String sendusername, int SendUserId, int roomid) {
		try {
			URL url = new URL(sendChatPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			PrintWriter out = new PrintWriter(conn.getOutputStream());
			String content = URLEncoder.encode(msgcontent, "UTF-8");
			String userName = URLEncoder.encode(sendusername, "UTF-8");
			String param = "msgcontent=" + content + "&sendusername="
					+ userName + "&SendUserId=" + SendUserId + "&roomid="
					+ roomid;
			out.print(param);
			out.flush();
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
			InputStream is = conn.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			byte bs[] = new byte[dis.available()];
			dis.read(bs);
			String data = new String(bs, "UTF-8");
			return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @param isManager
	 * @param roomId
	 * @param isServer
	 * @return ��ȡTopId
	 * 
	 */
	public static String getChatTopCount(int isManager, int roomId, int isServer) {
		try {
			URL url = new URL(getTopCount);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded; charset=UTF-8");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			PrintWriter out = new PrintWriter(conn.getOutputStream());
			String param = "userType=" + isManager + "&topCount=8&roomId="
					+ roomId + "&isServer=" + isServer;
			out.print(param);
			out.flush();
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
			InputStream is = conn.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			byte bs[] = new byte[dis.available()];
			dis.read(bs);
			String data = new String(bs, "UTF-8");
			return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @param url
	 * @return ���� get ����
	 */
	public static String sendHttpGet(String url) {
		try {
			URL path = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) path.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Proxy-Connection", "Keep-Alive");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				byte bs[] = new byte[dis.available()];
				dis.read(bs);
				String data = new String(bs, "UTF-8");
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
