package com.jucaipen.test;

public class Test {
	
	public static String changeHttps(String url){
		StringBuffer newUrl=new StringBuffer();
		if(url==null||"".equals(url)){
			return url;
		}
		if(url.startsWith("http")){
			String[] urlStr = url.split(":");
			for(int i=0;i<urlStr.length;i++){
				if(i==0){
					newUrl.append(urlStr[i]+"s");
				}else{
					newUrl.append(urlStr[i]);
				}
			}
		}
		return newUrl.toString();
		
	}
	
	
	public static void main(String[] args) {
		String url="http://www.baidu.com";
		String https=changeHttps(url);
		System.out.println("https:"+https);
		
	}
}
