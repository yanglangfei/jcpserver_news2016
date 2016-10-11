package com.jucaipen.test;

import java.util.ArrayList;
import java.util.Collection;

import com.jucaipen.utils.JPushUtils;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

public class PushTest {

	public static void main(String[] args) {
		Collection<String> p=new ArrayList<String>();
		p.add("6750");
		JPushClient client = JPushUtils.getJPush();
		PushPayload msg = JPushUtils.createNptifyForAliase("msg", "key", 1, "id", 4, p);
		PushResult res = JPushUtils.pushMsg(client, msg);
		System.out.println(res.toString());
	}
}
