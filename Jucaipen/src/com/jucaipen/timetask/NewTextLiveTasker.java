package com.jucaipen.timetask;

import java.util.List;
import java.util.TimerTask;

import org.json.JSONObject;
import com.jucaipen.model.FamousTeacher;
import com.jucaipen.model.TextLive;
import com.jucaipen.service.FamousTeacherSer;
import com.jucaipen.service.TxtLiveSer;
import com.jucaipen.utils.TimeUtils;
import com.jucaipen.utils.XinGeUtil;

public class NewTextLiveTasker extends TimerTask {

	private List<TextLive> textLives;
 
	@Override
	public void run() {        
		//ͨ��liveId ��ȡ���µ�ֱ����Ϣ
		textLives=TxtLiveSer.findLastPushLive(1);
		//��������ֱ����Ϣ���ͻ���
		if(textLives.size()>0){
			for(TextLive textLive :textLives){
				String title=textLive.getTitle();
				String startDate=textLive.getStartDate();
				int id=textLive.getId();             
				boolean isPush=TimeUtils.compareDate(startDate);               
				if(isPush){
					int teacherId=textLive.getTeacherId();   
					FamousTeacher teacher=FamousTeacherSer.findFamousTeacherById(teacherId);
					String nickName=teacher.getNickName();
				   // JSONObject res=XinGeUtil.getInstance(false).pushAllDevice(id,nickName+"����ֱ��", title);
				    //GePushUtils.getInstance().pushAllDev(nick Name+"����ֱ��", title);
				   // System.out.println(res.toString());
				}
			}
		}
	
		
	}

}
