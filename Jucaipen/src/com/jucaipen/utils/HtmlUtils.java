package com.jucaipen.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author YLF
 * 
 *         ������ҳ��ǩ��������ҳ��ǩ
 * 
 */
public class HtmlUtils {

	/**
	 * @return ����ֱ����ƵURL
	 */
	public static String parseWeb(String videoUrl) {
		if (videoUrl != null) {
			if (videoUrl.contains("iframe")&&videoUrl.contains("src")) {
				Document document = Jsoup.parse(videoUrl);
				Element ec = document.select("iframe").first();
				return ec.attr("src");
			} else if (videoUrl.contains("object")&&videoUrl.contains("data")) {
				Document document = Jsoup.parse(videoUrl);
				Element ec = document.select("object").first();
				return ec.attr("data");
			}

		}
		return null;

	}

	/**
	 * @return ������ҳsrc��ǩͼƬ
	 */
	public static String createImageWeb(String imagePath) {
		String webImage = "<img src='" + imagePath + "'>";
		return webImage;
	}

	/**
	 * @return ������ҳsrc ��ǩ
	 */
	public static String parseWebImage(String imagePath) {
		String image = imagePath.replace("<img src=", "").replace(">", "");
		return image;
	}
}
