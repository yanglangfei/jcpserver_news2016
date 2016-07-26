package com.jucaipen.main.video;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jucaipen.model.Special;
import com.jucaipen.model.Video;
import com.jucaipen.model.VideoClass;
import com.jucaipen.service.SpecialSer;
import com.jucaipen.service.VideoClassSer;
import com.jucaipen.service.VideoServer;
import com.jucaipen.utils.JsonUtil;
import com.jucaipen.utils.StringUtil;
/**
 * @author Administrator
 *       ��ȡ��Ƶ�б���Ϣ
 */
@SuppressWarnings("serial")
public class QuerryVideoList extends HttpServlet {
	private String result;
	private StringBuffer cIdArray;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String classId = request.getParameter("classId");
		String typeId = request.getParameter("typeId");
		String teacherId = request.getParameter("teacherId");
		String page = request.getParameter("page");
		System.out.println("classId>>:"+classId+"  tId:"+typeId+"   t:"+teacherId);
		if (StringUtil.isNotNull(classId) && StringUtil.isInteger(classId)) {
			int cId = Integer.parseInt(classId);
			if (StringUtil.isNotNull(typeId) && StringUtil.isInteger(typeId)) {
				int type = Integer.parseInt(typeId);
				if (StringUtil.isNotNull(teacherId)
						&& StringUtil.isInteger(teacherId)) {
					int tId = Integer.parseInt(teacherId);
					if (StringUtil.isNotNull(page)
							&& StringUtil.isInteger(page)) {
						int p = Integer.parseInt(page);
						result = initVideoList(type, tId, cId, p);
					} else {
						result = JsonUtil.getRetMsg(4, "page �����쳣");
					}
				} else {
					result = JsonUtil.getRetMsg(3, "teacherId �����쳣");
				}
			} else {
				result = JsonUtil.getRetMsg(2, "typeId �����쳣");
			}
		} else {
			result = JsonUtil.getRetMsg(1, "classId �����쳣");
		}
		out.println(result);
		out.flush();
		out.close();
	}
	

	private  String initVideoList(int type, int tId, int cId, int p) {
		// cId ��ѯʱ������� ����0
		//List<VideoClass> las;
		if (cId < 0) {
			return JsonUtil.getRetMsg(1, "����id�������0");
		}
		if (type >= 0 && tId >= 0 && cId >= 0) {
			// ���ַ��� ��ȫ��
			cIdArray=new StringBuffer();
			List<VideoClass> vcs = VideoClassSer.findClassByPid(cId);
			StringBuffer vs = getVideoClass(vcs);  
			if(vs!=null&&vs.toString().endsWith(",")){
				vs.replace(vs.length()-1, vs.length(),"");
			}
			List<Video> videos = VideoServer.findVideoByTypeAndClassIdAndTeacherId(type, vs.toString(), tId, p);
			if(videos!=null){
				for(Video video : videos){
					//�Ƿ�Ϊ������Ƶ  0Ϊ�����Ƶ��1Ϊ������Ƶ
					int specialId=video.getPecialId();
					int videoType=video.getVideoType();
					video.setCharge(videoType==1);
					
					if(specialId>0){
						Special special = SpecialSer.findSpecialById(specialId);
						video.setCharge(special.getIsFree()==2);
					}
				}
			}
			return JsonUtil.getVideoList(videos);
		}
		// cId>0
		if (cId >= 0 && type < 0 && tId < 0) {
			cIdArray=new StringBuffer();
			List<VideoClass> vcs = VideoClassSer.findClassByPid(cId);
			StringBuffer vs = getVideoClass(vcs);
			if(vs!=null&&vs.toString().endsWith(",")){
				vs.replace(vs.length()-1, vs.length(),"");
			}
			List<Video> videos = VideoServer.findVideoByClassId(vs.toString(), p);
			if(videos!=null){
				for(Video video : videos){
					//�Ƿ�Ϊ������Ƶ  0Ϊ�����Ƶ��1Ϊ������Ƶ
					int specialId=video.getPecialId();
					int videoType=video.getVideoType();
					video.setCharge(videoType==1);
					if(specialId>0){
						Special special = SpecialSer.findSpecialById(specialId);
						video.setCharge(special.getIsFree()==2);
					}
				}
			}
			
			return JsonUtil.getVideoList(videos);
		}
		
		if (cId >= 0 && type >= 0 && tId < 0) {
			cIdArray=new StringBuffer();
			List<VideoClass> vcs = VideoClassSer.findClassByPid(cId);
			StringBuffer vs = getVideoClass(vcs);
			if(vs!=null&&vs.toString().endsWith(",")){
				vs.replace(vs.length()-1, vs.length(),"");
			}
			List<Video> videos = VideoServer.findVideoByTypeAndClassId(type,
					vs.toString(), p);
			if(videos!=null){
				for(Video video : videos){
					//�Ƿ�Ϊ������Ƶ  0Ϊ�����Ƶ��1Ϊ������Ƶ
					int specialId=video.getPecialId();
					int videoType=video.getVideoType();
					video.setCharge(videoType==1);
					if(specialId>0){
						Special special = SpecialSer.findSpecialById(specialId);
						video.setCharge(special.getIsFree()==2);
					}
				}
			}
			
			return JsonUtil.getVideoList(videos);
		}

		
		if (cId >= 0 && type < 0 && tId >= 0) {
			cIdArray=new StringBuffer();
			List<VideoClass> vcs = VideoClassSer.findClassByPid(cId);
			StringBuffer vs = getVideoClass(vcs);
			if(vs!=null&&vs.toString().endsWith(",")){
				vs.replace(vs.length()-1, vs.length(),"");
			}
			List<Video> videos = VideoServer.findVideoByTeacherIdAndClassId(
					tId, vs.toString(), p);
			if(videos!=null){
				for(Video video : videos){
					//�Ƿ�Ϊ������Ƶ  0Ϊ�����Ƶ��1Ϊ������Ƶ
					int specialId=video.getPecialId();
					int videoType=video.getVideoType();
					video.setCharge(videoType==1);
					
					if(specialId>0){
						Special special = SpecialSer.findSpecialById(specialId);
						video.setCharge(special.getIsFree()==2);
					}
					
				}
			}
			return JsonUtil.getVideoList(videos);
		}
		return null;
	}
	
	public  StringBuffer getVideoClass(List<VideoClass> vcs){
		for(VideoClass vc : vcs){
			cIdArray.append(vc.getId());
			cIdArray.append(",");
			List<VideoClass> vs = VideoClassSer.findClassByPid(vc.getId());
			if(vs!=null){
				getVideoClass(vs);
			}
		}
		System.out.println("cIdArray:"+cIdArray);
		return cIdArray;
	}

}
