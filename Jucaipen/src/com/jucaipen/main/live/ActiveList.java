package com.jucaipen.main.live;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.PushPayload;
import com.jucaipen.utils.JPushUtils;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.LoginUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 * 
 *     �ֳ���� ---��ʦ�ػ���
 */
@SuppressWarnings("serial")
public class ActiveList extends HttpServlet {
	private String result;
	private Map<String, String> param = new HashMap<String, String>();
	private static final String GETUser = "http://www.jucaipen.com/TeacherLive/ashx/user.ashx?action=GetUserList";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String teacherId = request.getParameter("teacherId");
		if (StringUtil.isNotNull(teacherId)) {
			if (StringUtil.isInteger(teacherId)) {
				int lId = Integer.parseInt(teacherId);
				initBangList(lId);
			} else {
				result = JsonUtil.getRetMsg(2, "teacherId �������ָ�ʽ���쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "teacherId ��������Ϊ��");
		}
		out.println(result);
		out.flush();
		out.close();
	}

	public void initBangList(int tId) {
		Timer timer = new Timer();
		UpdateOnLine task = new UpdateOnLine(tId);
		timer.scheduleAtFixedRate(task, new Date(), 1000 * 60);
	}

	class UpdateOnLine extends TimerTask {
		private int tId;

		public UpdateOnLine(int tId) {
			this.tId = tId;
		}

		@Override
		public void run() {
			param.clear();
			param.put("tId", tId + "");
			String res = LoginUtil.sendHttpPost(GETUser, param);
			JSONArray array=JsonUtil.createOnLineArray(res);
			if(array.length()>0){
				JPushClient client = JPushUtils.getJPush();
				PushPayload msgObj = JPushUtils.createMsg("msg", "onLine", array.toString(),
						null);
				JPushUtils.pushMsg(client, msgObj);
			}
		}

	}

}
