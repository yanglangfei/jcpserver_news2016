package com.jucaipen.main.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jucaipen.model.ClientOsInfo;
import com.jucaipen.service.UserServer;
import com.jucaipen.utils.HeaderUtil;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
import com.jucaipen.utils.UpLoadFileUtils;

/**
 * @author ylf
 * 
 *         �ļ��ϴ�(�û�ͷ��)
 * 
 */
@SuppressWarnings("serial")
public class UploadUserLogo extends HttpServlet {
	private Map<String, String> map;
	private String fileName;
	private String userId;
	private String resultMsg;
	private String savePath;
	private String loadPath;
	private int isSuccess;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		savePath = "D:/apkInfo/userLogo";
		loadPath = "http://121.40.227.121:8080/AccumulateWealth/jucaipen/downUserLogo?filename=";
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String userAgent = request.getParameter("User-Agent");
		ClientOsInfo os = HeaderUtil.getMobilOS(userAgent);
		int isDevice = HeaderUtil.isVaildDevice(os, userAgent);
		if (isDevice == HeaderUtil.PHONE_APP) {
			// �õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
			// �ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
			String tempPath = this.getServletContext().getRealPath(
					"/WEB-INF/temp");
			File tmpFile = new File(tempPath);
			if (!tmpFile.exists()) {
				// ������ʱĿ¼
				tmpFile.mkdir();
			}
			map = new UpLoadFileUtils().upLoad(request, tmpFile, savePath,
					loadPath);
			for (String key : map.keySet()) {
				if (key.equals("-1") || key.equals("-2")) {
					resultMsg = JsonUtil.getRetMsg(3, "�ϴ��ļ�̫���������ϴ�");
					out.print(resultMsg);
					System.out.println(resultMsg);
				} else {
					userId = key;
					fileName = map.get(key);
					System.out.println(" key=" + key + " values=" + fileName);
				}

			}
			if (map.size() > 0) {
				System.out.println("  " + userId);
				if ((!StringUtil.isInteger(userId) || Integer.parseInt(userId) < 0)) {
					resultMsg = JsonUtil.getRetMsg(1, "��ǰ�û�id�쳣");
					out.print(resultMsg);
					System.out.println(resultMsg);
				} else {
					int uId = Integer.parseInt(userId);
					String faceImage = loadPath + fileName;
					isSuccess = UserServer.updateUserLogo(uId, faceImage);
					if (isSuccess == 1) {
						resultMsg = JsonUtil.getRetMsg(0, "�û�ͷ�񱣴�ɹ�");
						out.print(resultMsg);
						System.out.println(resultMsg);
					} else {
						resultMsg = JsonUtil.getRetMsg(2, "�û�ͷ�񱣴�ʧ��");
						out.print(resultMsg);
						System.out.println(resultMsg);
					}
				}
			}

		} else {
			resultMsg = StringUtil.isVaild;
			out.print(resultMsg);
		}
		
		out.flush();
		out.close();

	}

}