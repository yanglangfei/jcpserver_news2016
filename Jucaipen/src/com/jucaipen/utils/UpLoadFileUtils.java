package com.jucaipen.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author ylf �ļ�������
 * 
 */
public class UpLoadFileUtils {
	private Map<String, String> map;
	private String userId;
	private String value;
	private List<String> params = new ArrayList<String>();

	/**
	 * @param request
	 *            ��������
	 * @param tmpFile
	 *            �����ļ���
	 * @param savePath
	 *            �����ļ�URL
	 * @return �ϴ��ļ� ���� �û�id ·��
	 */
	public Map<String, String> upLoad(HttpServletRequest request, File tmpFile,
			String savePath, String loadPath) {
		map = new HashMap<String, String>();
		// ��Ϣ��ʾ
		String message = "";
		try {
			// ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
			// 1������һ��DiskFileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// ���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼���С�
			factory.setSizeThreshold(1024 * 100);//���û������Ĵ�СΪ100KB�������ָ������ô�������Ĵ�СĬ����10KB
			// �����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
			factory.setRepository(tmpFile);
			// 2������һ���ļ��ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			// �����ļ��ϴ�����
			upload.setProgressListener(new ProgressListener() {
				public void update(long pBytesRead, long pContentLength,
						int arg2) {
					System.out.println("�ļ���СΪ��" + pContentLength + ",��ǰ�Ѵ���"
							+ pBytesRead);
				}
			});
			// ����ϴ��ļ�������������
			upload.setHeaderEncoding("UTF-8");
			// 3���ж��ύ�����������Ƿ����ϴ���������
			if (!ServletFileUpload.isMultipartContent(request)) {
				// ���մ�ͳ��ʽ��ȡ����
				return map;
			}

			// �����ϴ������ļ��Ĵ�С�����ֵ��Ŀǰ������Ϊ1024*1024�ֽڣ�Ҳ����1MB
			upload.setFileSizeMax(1024 * 1024 * 2);
			// �����ϴ��ļ����������ֵ�����ֵ=ͬʱ�ϴ��Ķ���ļ��Ĵ�С�����ֵ�ĺͣ�Ŀǰ����Ϊ10MB
			upload.setSizeMax(1024 * 1024 * 5);
			// 4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// ���fileitem�з�װ������ͨ�����������
				if (item.isFormField()) {
				//	String name = item.getFieldName();
					// �����ͨ����������ݵ�������������
					value = item.getString("UTF-8");
					userId = value;
					params.add(userId);
					// value = new String(value.getBytes("iso8859-1"),"UTF-8");
				} else {// ���fileitem�з�װ�����ϴ��ļ�
						// �õ��ϴ����ļ����ƣ�
					String filename = item.getName();
					System.out.println("�ļ�����" + filename);
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					// ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺
					// c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
					// �����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
					/*
					 * filename = filename .substring(filename.lastIndexOf("\\")
					 * + 1);
					 */
					// �õ��ϴ��ļ�����չ��
					String fileExtName = filename.substring(filename
							.lastIndexOf(".") + 1);
					
					//if(fileExtName.equals(""))
					
					// �����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
					System.out.println("�ϴ����ļ�����չ���ǣ�" + fileExtName);
					System.out.println("�ϴ��ļ���С��" + item.getSize());
					// ��ȡitem�е��ϴ��ļ���������
					InputStream in = item.getInputStream();
					
					
					// �õ��ļ����������
					String saveFilename = makeFileName(filename);
					// �õ��ļ��ı���Ŀ¼
					String realSavePath = makePath(saveFilename, savePath);
					// ����һ���ļ������
					FileOutputStream out = new FileOutputStream(realSavePath
							+ "\\" + saveFilename);
					System.out.println("�ļ�����·����" + realSavePath + ">>>"
							+ saveFilename);
					// ����һ��������
					byte buffer[] = new byte[1024 * 3];
					// �ж��������е������Ƿ��Ѿ�����ı�ʶ
					int len = 0;
					// ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
					while ((len = in.read(buffer)) > 0) {
						// ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\"
						// + filename)����
						out.write(buffer, 0, len);
					}
					// �ر�������
					in.close();
					// �ر������
					out.close();
					// ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					// item.delete();
					message = saveFilename;
					map.put(params.get(0), saveFilename);
					return map;
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			message = "�����ļ��������ֵ����";
			map.put("-1", message);
			return map;
		} catch (FileUploadBase.SizeLimitExceededException e) {
			e.printStackTrace();
			message = "�ϴ��ļ����ܵĴ�С�������Ƶ����ֵ������";
			map.put("-2", message);
			return map;
		} catch (Exception e) {
			message = "�ļ��ϴ�ʧ�ܣ�";
			System.out.println(message);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Method: makeFileName
	 * @Description: �����ϴ��ļ����ļ������ļ����ԣ�uuid+"_"+�ļ���ԭʼ����
	 * @Anthor:ylf
	 * @param filename
	 *            �ļ���ԭʼ����
	 * @return uuid+"_"+�ļ���ԭʼ����
	 */
	private String makeFileName(String filename) { // 2.jpg
		// Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
		return UUID.randomUUID().toString() + "_" + filename;
	}

	/**
	 * Ϊ��ֹһ��Ŀ¼�������̫���ļ���Ҫʹ��hash�㷨��ɢ�洢
	 * 
	 * @Method: makePath
	 * @Description:
	 * @Anthor:ylf
	 * 
	 * @param filename
	 *            �ļ�����Ҫ�����ļ������ɴ洢Ŀ¼
	 * @param savePath
	 *            �ļ��洢·��
	 * @return �µĴ洢Ŀ¼
	 */
	private String makePath(String filename, String savePath) {
		// �õ��ļ�����hashCode��ֵ���õ��ľ���filename����ַ����������ڴ��еĵ�ַ
		int hashcode = filename.hashCode();
		int dir1 = hashcode & 0xf; // 0--15
		int dir2 = (hashcode & 0xf0) >> 4; // 0-15
		// �����µı���Ŀ¼
		String dir = savePath + "\\" + dir1 + "\\" + dir2; // upload\2\3

		// File�ȿ��Դ����ļ�Ҳ���Դ���Ŀ¼
		File file = new File(dir);
		// ���Ŀ¼������
		if (!file.exists()) {
			// ����Ŀ¼
			file.mkdirs();
		}
		return dir;
	}

	/**
	 * @param fileName
	 *            �ļ���
	 * @param fileSaveRootPath
	 *            ����ĸ�Ŀ¼
	 * @param response
	 *            ���ͻ�����Ӧ����
	 * @return �����ļ�
	 */
	public Integer downFile(String fileName, String fileSaveRootPath,
			HttpServletResponse response) {
		// ͨ���ļ����ҳ��ļ�������Ŀ¼
		String array[] = fileName.split("=");
		if (array.length > 1) {
			String filename = fileName.split("=")[1];
			String path = makePath(filename, fileSaveRootPath);
			// �õ�Ҫ���ص��ļ�
			File file = new File(path + "\\" + filename);
			// ����ļ�������
			if (!file.exists()) {
				System.out.println("�����ļ�������");
				return 1;
			}
			ImageUtils.scale(path + "\\" + filename, "D:/apkInfo/scaleLogo/"
					+ filename, 4, false);
			File f = new File("D:/apkInfo/scaleLogo/" + filename);
			try {
				// �����ļ���
				String realname = fileName.substring(fileName.indexOf("_") + 1);
				// ������Ӧͷ��������������ظ��ļ�
				response.setHeader(
						"content-disposition",
						"attachment;filename="
								+ URLEncoder.encode(realname, "UTF-8"));
				// ��ȡҪ���ص��ļ������浽�ļ�������
				FileInputStream in = new FileInputStream(
						"D:/apkInfo/scaleLogo/" + filename);
				// ���������
				OutputStream out = response.getOutputStream();
				// ����������
				byte buffer[] = new byte[1024];
				int len = 0;
				// ѭ�����������е����ݶ�ȡ������������
				while ((len = in.read(buffer)) > 0) {
					// ��������������ݵ��������ʵ���ļ�����
					out.write(buffer, 0, len);
				}
				// �ر��ļ�������
				in.close();
				// �ر������
				out.close();
				return 0;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return 2;
		}
		return null;

	}

}
