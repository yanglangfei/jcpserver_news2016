package com.jucaipen.utils;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class LoginUtil {
	private static StringBuilder builder;

	/**
	 * @param param
	 * @return post��������
	 * 
	 */
	public static String sendHttpPost(String path, Map<String, String> param) {
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Proxy-Connection", "Keep-Alive");
			conn.setRequestProperty("accept", "*/");
			conn.setReadTimeout(1000 * 10);
			conn.setConnectTimeout(1000 * 10);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			PrintWriter out = new PrintWriter(conn.getOutputStream());
			builder = new StringBuilder();
			if (param != null && param.size() > 0) {
				for (Map.Entry<String, String> p : param.entrySet()) {
					builder.append(p.getKey());
					builder.append("=");
					builder.append(p.getValue());
					builder.append("&");
				}
				builder.replace(builder.length() - 1, builder.length(), "");
			}
			out.print(builder.toString());
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

	/*
	 * @param url
	 * 
	 * @return ���� get ����
	 */
	public static String sendHttpGet(String url, Map<String, String> param) {
		try {
			builder = new StringBuilder(url);
			if (param != null && param.size() > 0) {
				for (Map.Entry<String, String> p : param.entrySet()) {
					builder.append("&");
					builder.append(p.getKey());
					builder.append("=");
					builder.append(p.getValue());
					builder.append("?");
				}
				builder.replace(builder.length() - 1, builder.length(), "");
			}
			URL path = new URL(builder.toString());
			HttpURLConnection conn = (HttpURLConnection) path.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Proxy-Connection", "Keep-Alive");
			conn.setReadTimeout(1000 * 10);
			conn.setConnectTimeout(1000 * 10);
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
		return JsonUtil.getRetMsg(10, "ϵͳ��æ�����Ժ�����");
	}

}
