package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.Certification;

/**
 * @author Administrator
 *
 *  ֤����Ϣ
 */
public interface CertificationDao {
	
	/**
	 * @return  ��ȡ����֤����Ϣ
	 */
	public List<Certification> findAllCertification();
	
	/**
	 * @param id
	 * @return ����id��ȡ֤����Ϣ
	 */
	public Certification findCertificationById(int id);

}
