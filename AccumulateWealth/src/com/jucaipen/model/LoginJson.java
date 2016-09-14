package com.jucaipen.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 *
 *    ��¼ʵ����
 */
@SuppressWarnings("serial")
public class LoginJson implements Serializable{
	//{"IsLogin":false,"ActionId":0,"Result":false,"Msg":"�������"}
	/**
	 *   �Ƿ��¼��ע��ɹ�
	 */
	private boolean IsLogin;
	/**
	 * �û�ID
	 */
	private int ActionId;
	/**
	 * �Ƿ�ɹ�
	 */
	private boolean Result;
	/**
	 * ��ע��Ϣ
	 */
	private String Msg;
	public LoginJson(boolean isLogin, int actionId, boolean result, String msg) {
		super();
		IsLogin = isLogin;
		ActionId = actionId;
		Result = result;
		Msg = msg;
	}
	public boolean isIsLogin() {
		return IsLogin;
	}
	public void setIsLogin(boolean isLogin) {
		IsLogin = isLogin;
	}
	public int getActionId() {
		return ActionId;
	}
	public void setActionId(int actionId) {
		ActionId = actionId;
	}
	public boolean isResult() {
		return Result;
	}
	public void setResult(boolean result) {
		Result = result;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	
	
	

}
