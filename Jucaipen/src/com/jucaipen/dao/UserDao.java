package com.jucaipen.dao;

import java.util.List;

import com.jucaipen.model.User;

/**
 * @author ylf
 * 
 *         �û�������
 */
public interface UserDao {
	
	/**
	 * @param isLive
	 * @return    ��ȡֱ��������
	 */
	public  List<User> findOnLiveUserByIsLive(int isLive,int page);
	/**
	 * @param id
	 * @return  ͨ��id�޸��ֻ��ź���ʵ����
	 */
	public int updateUserTrueNameAndTelById(String telPhone,User u);
	/**
	 * @param id
	 * @param tel
	 * @return   ͨ��ID�޸��û��ֻ���
	 */
	public int updatePhoneById(int id,String tel);
	/**
	 * @return �û�ע��
	 */
	public int reginUser(User user);

	/**
	 * @return ���������û�
	 */
	public List<User> findUser(int page);

	/**
	 * @param id
	 * @return ͨ��id��ѯ�û���Ϣ
	 */
	public User findUserById(int id);
	
	/**
	 * @param id
	 * @return  ��ȡ��¼�ɹ������Ϣ
	 */
	public User findLoginInfoById(int id);

	/**
	 * @param id
	 * @return ɾ���û���Ϣ
	 */
	public int deleteUserById(int id);

	/**
	 * @param id
	 * @return �޸��û���Ϣ
	 */
	public int updataUserById(int id, User user);
	
	
	/**
	 * @param id
	 * @param logoPath
	 * @return  �޸��û�ͷ��URL
	 */
	public int updateUserLogoById(int id ,String logoPath);

	/**
	 * @param account
	 * @return ��ѯ���˺��û���Ϣ
	 */
	public User findUserByAccount(String userName);

	/**
	 * @param telPhone
	 * @return ͨ���ֻ��Ų�ѯ�û���Ϣ
	 */
	public User findUserByTelPhone(String telPhone);
	
	
	/**
	 * @param qqId
	 * @return  ͨ��qqId ��ѯ�û���Ϣ
	 */
	public User findUserByQqopenId(String qqId);
	
	/**
	 * @param wenxinId
	 * @return  ͨ��΢��id ��ѯ�û���Ϣ
	 */
	public User findUserByWeixinId(String wenxinId);
	
	/**
	 * @param sinaId
	 * @return  ͨ������id ��ѯ�û���Ϣ
	 */
	public User findUserBySinaId(String sinaId);

	/**
	 * @param userName
	 * @param telPhone
	 * @return �����ֻ��Ż��û�����ѯ�û�
	 */
	public User findUserByOther(String userName);

	/**
	 * @param id
	 * @return ͨ��id��ѯ�û�����
	 */
	public User findPasswordById(int id);

	/**
	 * @param id
	 * @param pwd
	 * @return �޸�����
	 */
	public int updataPasswordById(int id, String pwd);

	/**
	 * @param id
	 * @return����id��ѯ�û��ǳ� --��������
	 */
	public User findUserInfoById(int id);

	/**
	 * @param accountId
	 * @return �޸ĵ������˺�id
	 */
	public int upDataAccountId(int id,int accountType,String accountId);
	/**
	 * @param accountId
	 * @return ͨ���˺�id ��¼ ����
	 */
	public User otherAccountLogin(int accountType,String accountId);
	
	/**
	 * @param id
	 * @return   �����û�id ��ѯ�������˺�
	 */
	public User querryOtherAccount(int id);
	
	/**
	 * @param isLiveRoom
	 * @return   �����û��Ƿ���ֱ����
	 */
	public int updateUserIsOnRoom(int isLiveRoom,int uId);
	
	
	/**
	 * @param uId
	 * @return  ��ȡ�û���¼token
	 */
	public String querryUserIsLogin(int uId);
	
	/**
	 * @param uId
	 * @param token
	 * @return  �����û�token��Ϣ
	 */
	public int updateUserLoginToken(int uId,String token);
	
	
	/**
	 * @param id
	 * @return  ��ȡ�û�ͷ����Ϣ
	 */
	public String querryFaceImage(int id);

}
