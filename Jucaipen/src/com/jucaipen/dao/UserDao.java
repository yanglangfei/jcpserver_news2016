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
	 * @param id
	 * @return  ͨ��id�޸��ֻ��ź���ʵ����
	 */
	public int updateUserTrueNameAndTelById(String telPhone,User u);
	
	public int updateLoginNum(int num,int uId,String ip);
	
	
	/**
	 * @param userId
	 * @return   ��ȡ�û��ֻ�  ������֤״̬
	 */
	public User findUserIsCheck(int userId);
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
	
	public User findUserChatInfo(int uId);
	
	/**
	 * @return ���������û�
	 */
	public List<User> findUser(int page);
	
	/**
	 * @param investCode
	 * @return �����������ȡ�û���Ϣ
	 */
	public User findUserByInvestCode(String investCode);
	
	/**
	 * @param id
	 * @return ͨ��id��ѯ�û���Ϣ
	 */
	public User findUserById(int id);
	
	
	public User findBaseInfoById(int id);
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
	 * @param email
	 * @return ��ѯ���˺��û���Ϣ
	 */
	public User findUserByAccount(String email);
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
	 * account
	 * @return �����ֻ��Ż�Email��ѯ�û�
	 */
	public User findUserByOther(String account);
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
	 * @param id
	 * @return  ��ȡ�û�ͷ����Ϣ
	 */
	public String querryFaceImage(int id);
	/**
	 * @param integeral
	 * @return  �޸��û�������Ϣ
	 */
	public int updateIntegeral(int integeral,int uId);
	
	/**
	 * @param uId
	 * @param leavel
	 * @return  �޸��û��ȼ���Ϣ
	 */
	public int updateUserLeavel(int uId,int leavel);
	/**
	 * @param uId
	 * @return  ��ȡ�û����ֵȼ���Ϣ
	 */
	public User querryIntegeralByUid(int uId);

}
