package com.jucaipen.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParseHtml {

	public static void main(String[] args) {
		Document doc = null;
		try {
			doc = Jsoup.connect(
					"http://epg.tvsou.com/programys/TV_1/Channel_1/W5.htm")
					.get();
			Elements content = doc.getElementsByClass("tvgenre");
			for (int i = 0; i < content.size(); i++) {
				Elements times = content.get(i).getElementsByTag("span");
				Elements pm1 = content.get(i).getElementsByTag("a");
				for (int j = 0; j < times.size(); j++) {
					System.out.println("time:" + times.get(j).html() + "  programys:"
							+ pm1.get(j).html());
				}
			}
		} catch (Exception e) {
		}
	}

}
