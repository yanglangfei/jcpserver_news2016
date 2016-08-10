package com.jucaipen.test;

import com.jucaipen.utils.JPushUtils;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

public class PushTest {

	public static void main(String[] args) {
		JPushClient client = JPushUtils.getJPush();
		PushPayload msg = JPushUtils.createMsg("test", "title", "content", null);
		PushResult res = JPushUtils.pushMsg(client, msg);
		System.out.println(res.toString());
	}
}
