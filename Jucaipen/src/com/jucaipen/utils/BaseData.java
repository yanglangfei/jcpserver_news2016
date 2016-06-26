package com.jucaipen.utils;

/**
 * @author Administrator
 *
 *  �û��ȼ���Ϣ�����
 */
public class BaseData {
	
	//����ֵС��2000�ģ��ȼ�Ϊ�ݸ�����
	//  >=0    <2000
	public static final String ONE_LEAVEL="�ݸ�����";
	
	//����ֵ���ڵ���2000�ģ��ȼ�Ϊ���д���
	//  >=2000      <5000   
	public static final String TWO_LEAVEL="���д���";
	//����ֵ���ڵ���5000�ģ��ȼ�Ϊ����ţ��
	//  >=5000      <10000
	public static final String THREE_LEAVEL="����ţ��";
	//����ֵ���ڵ���10000�ģ��ȼ�Ϊ���д���
	//  >=10000
	public static final String FOUR_LEAVEL="���д���";
	
	public static final int ONE_MIN=0;
	
	public static final int ONE_MAX=2000;
	
	
	public static final int TWO_MAX=5000;
	
	public static final int THREE_MAX=10000;
	public static final String ONE_LEAVEL_RULE="1������ֵС��2000�ģ��ȼ�Ϊ�ݸ�����";
	public static final String TWO_LEAVEL_RULE="2������ֵ���ڵ���2000�ģ��ȼ�Ϊ���д���";
	public static final String THREE_LEAVEL_RULE="3������ֵ���ڵ���5000�ģ��ȼ�Ϊ����ţ��";
	public static final String FOUR_LEAVEL_RULE="4������ֵ���ڵ���10000�ģ��ȼ�Ϊ���д���";
	
	
	/**
	 * @param integeral
	 * @return  ���صȼ��ƺ�
	 */
	public static String getLeavelStr(int integeral){
		if(integeral>=ONE_MIN&&integeral<ONE_MAX){
			return ONE_LEAVEL;
		}else if(integeral>=ONE_MAX&&integeral<TWO_MAX){
			return TWO_LEAVEL;
		}else if(integeral>=TWO_MAX&&integeral<THREE_MAX){
			return THREE_LEAVEL;
		}else{
			return FOUR_LEAVEL;
		}
	}
	
	
	
	/**
	 * @param integeral
	 * @return  ���صȼ��ƺ�
	 */
	public static int getLeavel(int integeral){
		if(integeral>=ONE_MIN&&integeral<ONE_MAX){
			return 1;
		}else if(integeral>=ONE_MAX&&integeral<TWO_MAX){
			return 2;
		}else if(integeral>=TWO_MAX&&integeral<THREE_MAX){
			return 3;
		}else{
			return 4;
		}
	}
	
	
	public static String getLeavelRule(){
		return ONE_LEAVEL_RULE+"\n"+TWO_LEAVEL_RULE+"\n"+THREE_LEAVEL_RULE+"\n"+FOUR_LEAVEL_RULE;
	}
	
}
