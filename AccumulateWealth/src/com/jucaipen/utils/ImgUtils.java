package com.jucaipen.utils;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;
public class ImgUtils {
	/**
	 * ������ͼƬ����Base64λ����
	 * @param imgUrl  ͼƬURL
	 * @param format  ͼƬ��ʽ
	 * @return  Base64ͼƬ�ַ�����Ϣ
	 */
	public static String encodeImgageToBase64(URL imageUrl,String format) {
		ByteArrayOutputStream outputStream = null;
		try {
			BufferedImage bufferedImage = ImageIO.read(imageUrl);
			outputStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, format, outputStream);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(outputStream.toByteArray());
	}

	/**
	 * ������ͼƬ����Base64λ����
	 * 
	 * @param imgUrl   ����ͼƬURL
	 * @param format ͼƬ��ʽ
	 * @return  Base64ͼƬ�ַ�����Ϣ
	 */
	public static String encodeImgageToBase64(File imageFile,String format) {
		ByteArrayOutputStream outputStream = null;
		try {
			BufferedImage bufferedImage = ImageIO.read(imageFile);
			outputStream = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, format, outputStream);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(outputStream.toByteArray());
	}

	/**
	 * ��Base64λ�����ͼƬ���н��룬�����浽ָ��Ŀ¼
	 * @param base64  ͼƬbase64������Ϣ
	 */
	public static void decodeBase64ToImage(String base64, String path,
			String imgName) {
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			FileOutputStream write = new FileOutputStream(new File(path
					+ imgName));
			byte[] decoderBytes = decoder.decodeBuffer(base64);
			write.write(decoderBytes);
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
