package com.jucaipen.test;

import java.util.ArrayList;
import java.util.List;

import com.jucaipen.model.VideoClass;
import com.jucaipen.service.VideoClassSer;

/**
 * @author Administrator
 *  µ›πÈ≤‚ ‘
 */
public class RecycleQuerry {
	
	public static void main(String[] args) {
		StringBuffer buffer=new StringBuffer();
		List<VideoClass> vcs = VideoClassSer.findClassByPid(0);
		List<List<VideoClass>> vs = getVideoClass(vcs);
			for(List<VideoClass> c : vs){
				for(VideoClass s : c){
					buffer.append(s.getId());
					buffer.append(",");
				}
		}
			buffer.delete(buffer.length()-1,buffer.length());
			System.out.println(buffer.toString());
		
	}
	
	
	
	public static List<List<VideoClass>> getVideoClass(List<VideoClass> vcs){
		List<List<VideoClass>> vArray=new ArrayList<List<VideoClass>>();
		for(VideoClass vc : vcs){
			List<VideoClass> vs = VideoClassSer.findClassByPid(vc.getId());
			if(vs!=null){
				getVideoClass(vs);
			}
			vArray.add(vs);
		}
		return vArray;
	}

}
