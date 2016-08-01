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
	static StringBuffer  cIdArray=new StringBuffer();
	
	public static void main(String[] args) {
		List<VideoClass> vcs = VideoClassSer.findClassByPid(2);
		StringBuffer vs = getVideoClass(vcs);
		System.out.println(vs.toString());
		
	}
	
	
	
	public static StringBuffer getVideoClass(List<VideoClass> vcs){
		if (vcs != null) {
			for (VideoClass vc : vcs) {
				cIdArray.append(vc.getId());
				cIdArray.append(",");
				List<VideoClass> vs = VideoClassSer.findClassByPid(vc.getId());
				if (vs != null) {
					getVideoClass(vs);
				}
			}
		}
		return cIdArray;
	}

}
