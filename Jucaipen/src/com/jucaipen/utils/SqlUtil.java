package com.jucaipen.utils;

/**
 * @author Administrator
 *
 */
public class SqlUtil {
	/**
	 * ��Ȩ��Ŀ��
	 */
	public static final String EQITEM_TABLE = "JCPGuquanItem";
	/**
	 * ���ű�
	 */
	public static final String NEWS_TABLE = "JCPNews";
	/**
	 * �û���
	 */
	public static final String USER_TABLE = "JCPUser";
	/**
	 * ԤԼ��Ȩ��
	 */
	public static final String ORDER_TABLE = "JCPGuquanItem_yuyue";
	/**
	 * ���ű���
	 */
	public static final String NEWS_TITLE = "Title";
	/**
	 * ��������
	 */
	public static final String NEWS_DES = "ZhaiYao";
	/**
	 * ����id
	 */
	public static final String NEWS_ID = "Id";
	/**
	 * ���Źؼ���
	 */
	public static final String NEWS_KEYWORD = "KeyWord";
	/**
	 * ���ŷ�����
	 */
	public static final String NEWS_REPOTER = "FaBuRen";
	/**
	 * ��������
	 */
	public static final String NEWS_BODYS = "Bodys";
	/**
	 * ����ͼƬURL
	 */
	public static final String NEW_IMAGE = "ImageUrl";
	/**
	 * ����ͼƬ����ͼ
	 */
	public static final String NEWS_IMAGETHUMB = "ImagesThumb";
	/**
	 * ���Ų���ʱ��
	 */
	public static final String NEWS_INSERT = "InsertDate";
	/**
	 *  ����������
	 */
	public static final String NEWS_COMMS = "CommonCount";

	/**
	 * ������ϸ��ַ
	 */
	public static final String NEWS_HTMLPATH="PageUrl";
	/**
	 *  ������Դ
	 */
	public static final String NEWS_COMEFROM="FK_FromId";
	/**
	 * ��Ȩid
	 */
	public static final String EQUITY_ID = "Id";
	/**
	 * �ɷ�����
	 */
	public static final String EQUITY_NAME="gufenmingcheng";
	/**
	 * �ɷݼ��
	 */
	public static final String EQUITY_SIMPLENAME = "gufenjiancheng";
	/**
	 * ��Ȩ�Ƽ�����
	 */
	public static final String EQUITY_RECOMM = "tuijianjigou";
	/**
	 * ��Ȩ-������
	 */
	public static final String EQUITY_NETPROFIT = "jinglirun";
	/**
	 * �ɷݴ���
	 */
	public static final String EQUITY_CODE = "gufendaima";
	/**
	 * ��Ȩ-ÿ������
	 */
	public static final String EQUITY_BVPS = "meigujinzichan";
	/**
	 * ��Ȩ-Ͷ���ż�
	 */
	public static final String EQUITY_IT = "touzimenkan";
	/**
	 * ��Ȩ-����������
	 */
	public static final String EQUITY_RAT = "lirunzengzhanglv";
	/**
	 * ת�ù���
	 */
	public static final String EQUITY_TRANSNUM = "zhuanranggushu";
	/**
	 *   ��ת�ü۸�
	 */
	public static final String EQUITY_INTENDSTRANSFER="nizhuanrangjiage";
	/**
	 * ��ȨͼƬ
	 */
	public static final String EQUITY_IMAGE = "guquanimageurl";
	/**
	 * �û���¼����
	 */
	public static final String USER_PASSWORD = "PassWord";
	/**
	 * �û���
	 */
	public static final String USER_NAME = "UserName";
	/**
	 * �û���������
	 */
	public static final String USER_BIRTH = "Birthday";
	/**
	 * �û��Ա�
	 */
	public static final String USER_SEX = "Sex";
	/**
	 * �û���ʵ����
	 */
	public static final String USER_TRUENAME = "TrueName";
	/**
	 * �û��ǳ�
	 */
	public static final String USER_NICKNAME = "NickName";
	/**
	 * �û��ֻ���
	 */
	public static final String USER_MOBILE = "MobileNum";
	/**
	 * �û�ͷ��
	 */
	public static final String USRE_FACEIMAGE = "FaceImage";
	/**
	 * �û�Email
	 */
	public static final String USER_EMAIL = "Email";
	/**
	 * �û����
	 */
	public static final String USER_BODYS = "Bodys";
	/**
	 * �û�����ʡ��
	 */
	public static final String USER_LOCALPROVINCE = "LocaProvince";
	/**
	 * �û����ڳ���
	 */
	public static final String USER_LOCALCITY = "LocaCity";
	/**
	 * �û�������
	 */
	public static final String USER_LOCALAREA = "LocaEare";
	/**
	 * �û�����ʡ��
	 */
	public static final String USER_HOMEPROVINCE = "HomeProvince";
	/**
	 * �û��������
	 */
	public static final String USER_HOMECITY = "HomeCity";
	/**
	 * �û�������
	 */
	public static final String USER_HOMEAREA = "HomeEare";
	/**
	 * �û�ע��ip
	 */
	public static  final String USER_REGINIP="RegIp";
	/**
	 * ע��ʱ��
	 */
	public static final String USER_REGINDATE="RegDate";
	/**
	 * ע����Ϣ��Դ
	 */
	public static final String USER_REGFROM="RegFrom";
	/**
	 *   ΢��id
	 */
	public static final String USER_WEIXINID="WeiXinId";
	/**
	 *   ����΢��id
	 */
	public static final String USER_SINAID="WeiboId";
	/**
	 *   QQ id
	 */
	public static final String USER_QQID="QQOpenId";
	/**
	 *  ע��;����5 APP��
	 */
	public static final String USER_REGINFROM="RegFrom";

	/**
	 * ԤԼ��id
	 */
	public static final String ORDER_ID = "Id";
	/**
	 * ԤԼ��Ȩ�û�id
	 */
	public static final String ORDER_UID = "UserId";
	/**
	 * ԤԼ�û���ʵ����
	 */
	public static final String ORDER_UNAME = "TrueName";
	/**
	 * ԤԼ���ֻ�����
	 */
	public static final String ORDER_MOBILE = "MobileNum";
	/**
	 * ԤԼ��Ȩ����
	 */
	public static final String ORDER_REMARK = "Remark";
	/**
	 * ԤԼ��Ȩʱ��
	 */
	public static final String ORDER_DATE = "InsertDate";
	/**
	 * ��ȨͶ�ʽ��
	 */
	public static final String ORDER_TOUZI = "TouZiMoney";
	/**
	 * ԤԼ��Ȩid
	 */
	public static final String ORDER_EID = "ItemId";
	/**
	 * ԤԼ�û���¼�豸ip
	 */
	public static final String ORDER_UIP = "Ip";
	/**
	 * �����ղر�
	 */
	public static final String NEWSFAVORITES_TABLE = "JCPNews_Favorites";
	/**
	 * �������۱�
	 */
	public static final String NEWSCOMM_TABLE = "JCPNewsCommen";
	/**
	 * ���Ż�Ӧ��
	 */
	public static final String NEWSCOMMRES_TABLE = "JCPNewsCommenRes";
	/**
	 * ��Ȩ�ղر�
	 */
	public static final String EQUITYFAVORITES_TABLE = "JCPGuquanItem_Favorites";
	/**
	 * ��Ȩ�ղ�Id
	 */
	public static final String EQUITYFAVORITES_ID = "Id";
	/**
	 * ��Ȩ�ղ��û�id
	 */
	public static final String EQUITYFAVORITES_UID = "UserId";
	/**
	 * �ղع�Ȩ��id
	 */
	public static final String EQUITYFAVORITES_EID = "ProductId";
	/**
	 * �ղع�Ȩʱ��
	 */
	public static final String EQUITYFAVORITES_DATE = "InsertDate";
	/**
	 * ԤԼ����   1  Ͷ����ĿԤԼ      2  ˽ļ��ĿԤԼ
	 */
	public static final String EQUITYORDER_ORDERTYPE="yuyuetype";
	/**
	 * �ղ�����id
	 */
	public static final String NEWSFAVORITES_NID = "NewsId";
	/**
	 * ������۵��û�
	 */
	public static final String NEWSCOMM_UID="UserId";
	/**
	 * ����id
	 */
	public static final String NEWSCOMM_PARENTID="ParentId";
	/**
	 * ������������
	 */
	public static final String NEWSCOMM_BODYS = "Bodys";
	/**
	 * �������۵�������
	 */
	public static final String NEWSCOMM_GOODNUM = "Good";
	/**
	 * ���������Ƿ���ʾ
	 */
	public static final String NEWSCOMM_ISSHOW = "IsShow";
	/**
	 * �������ۻظ�����
	 */
	public static final String NEWSCOMM_REPNUM = "RepCount";
	/**
	 * ���Żظ�--�ظ����۵�id
	 */
	public static final String NEWSCOMMRES_COMMID = "CommId";
	/**
	 *   �������۷���
	 */
	public static final String NEWSCOMM_COMMTYPE="CommType";
	/**
	 * ʡ�ݱ�
	 */
	public static final String PROVINCE_TABLE = "JCP_Province";
	/**
	 * ʡ��id
	 */
	public static final String PROVINCE_ID = "ProvinceId";
	
	/**
	 *  ��id
	 */
	public static final String EARE_ID = "EareId";

	
	
	/**
	 *    ����id
	 */
	public static final String CITY_ID="CityId";
	/**
	 * ʡ������
	 */
	public static final String PROVINCE_Name = "ProvinceName";
	/**
	 * ����
	 */
	public static final String PROVINCE_SORT = "SortId";
	/**
	 * ʡ�ݱ�ע
	 */
	public static final String PROVINCE_REMARK="PRemark";
	/**
	 * ���б�
	 */
	public static final String CITY_TABLE = "JCPCity";
	/**
	 * ��������ʡ��id
	 */
	public static final String CITY_PID = "FK_ProId";
	/**
	 * ��������
	 */
	public static final String CITY_NAME = "CityName";
	/**
	 * ��������
	 */
	public static final String CITY_SORT="SortId";
	/**
	 * ����
	 */
	public static final String AREA_TABLE = "JCPEare";
	/**
	 * ����������id
	 */
	public static final String AREA_CID = "FK_CityId";
	/**
	 *   ��������ʡid
	 */
	public static final String AREA_PID="ProcinceID";
	/**
	 * ������
	 */
	public static final String AREA_NAME = "EareName";
	/**
	 * ��������
	 */
	public static final String AREA_SORT="SortId";
	/**
	 * ������
	 */
	public static final String ORAG_TABLE = "JCPJigou";
	/**
	 * ��������
	 */
	public static final String ORAG_NAME = "JgName";
	/**
	 * ����Ӣ������
	 */
	public static final String ORAG_NAMEEN = "JgNameEn";
	/**
	 * �������
	 */
	public static final String ORAG_SIMPLENAME = "JianCheng";
	/**
	 * ��������ʱ��
	 */
	public static final String ORAG_CREATEDATE = "CreateDate";
	/**
	 * ��������
	 */
	public static final String ORAG_TYPE = "Xingzhi";
	/**
	 * ����Ͷ������
	 */
	public static final String ORAG_AREA = "Touzilinyu";
	/**
	 * ����LOGO
	 */
	public static final String ORAG_LOGO = "JgLogo";
	/**
	 * �������
	 */
	public static final String ORAG_BODYS = "Bodys";
	/**
	 * �������ݲ���ʱ��
	 */
	public static final String ORAG_INSERTDATE = "InsertDate";
	/**
	 * ��ʦ��
	 */
	public static final String TEACHER_TABLE = "JCPTeacher";
	/**
	 * ��ʦ����
	 */
	public static final String TEACHER_NAME = "TearcherName";
	/**
	 * ��ʦͷ��
	 */
	public static final String TEACHER_PHOTO = "PhotoUrl";
	/**
	 * ��ʦ��Ҫ
	 */
	public static final String TEACHER_SUMM = "Gaiyao";
	/**
	 * ��ʦ���
	 */
	public static final String TEACHER_BODYS = "Bodys";
	/**
	 * ��ʦ����
	 */
	public static final String TEACHER_SORT = "Px";
	/**
	 * ��Ϣ��
	 */
	public static final String SYSINFO_TABLE = "JCPUser_Message";
	/**
	 * ������Ϣid
	 */
	public static final String SYSINFO_SENDID = "SendID";
	/**
	 * ������Ϣid
	 */
	public static final String SYSINFO_RECEIVEID = "ReceiveID";
	/**
	 * ��Ϣ����
	 */
	public static final String SYSINFO_TITLE = "Title";
	/**
	 * ��Ϣ����
	 */
	public static final String SYSINFO_BODYS = "Bodys";
	/**
	 * ������Ϣʱ��
	 */
	public static final String SYSINFO_SENDDATE = "SendDate";
	/**
	 * ��ȡ��Ϣʱ��
	 */
	public static final String SYSINFO_READDATE = "ReadDate";
	/**
	 * ��Ϣ����
	 */
	public static final String SYSINFO_TYPE = "Types";
	/**
	 * ��Ϣ��ȡ��¼��
	 */
	public static final String READINFO_TABLE = "JCPUser_Message_Read";
	/**
	 * ��Ϣ��ȡid
	 */
	public static final String READINFO_ID = "Id";
	/**
	 * ��Ϣ��ȡ�û�id
	 */
	public static final String READINFO_USERID = "UserId";
	/**
	 * ��Ϣid
	 */
	public static final String READINFO_MESSID = "MessId";
	/**
	 * ��Ϣ��ȡʱ��
	 */
	public static final String READINFO_READDATE = "ReadDate";
	/**
	 * ��Ϣ��Դ��
	 */
	public static final String RESOURCEFROM_TABLE = "JCPComeFrom";
	/**
	 * ��Ϣ��Դ����
	 */
	public static final String RESOURCEFOM_NAME = "FromName";
	/**
	 * ��Ϣ��Դ��ҳ
	 */
	public static final String RESOURCEFROM_HTML = "FromUrl";
	/**
	 * ��Ϣ��Դ����
	 */
	public static final String RESOURCEFROM_SORTID = "SortId";
	/**
	 * ��Ƶ��
	 */
	public static final String VIDEO_TABLE = "JCPVideo";
	/**
	 * ��Ƶ����
	 */
	public static final String VIDEO_TITLE = "Title";
	/**
	 * ��Ƶ�ؼ���
	 */
	public static final String VIDEO_KEYWORD = "KeyWords";
	/**
	 * ��Ƶ����
	 */
	public static final String VIDEO_DESC = "Description";
	/**
	 * ��Ƶ����id
	 */
	public static final String VIDEO_CLASSID = "ClassId";
	/**
	 * ��ƵͼƬ
	 */
	public static final String VIDEO_IMAGES = "ImagesUrl";
	/**
	 * ��Ƶ��Դ·��
	 */
	public static final String VIDEO_URL = "VideoUrl";
	/**
	 * ��Ƶ����
	 */
	public static final String VIDEO_DATE = "VideoDate";
	/**
	 * �Ƿ��Ǳ�վ��Ƶ��0---����  1---�ǣ�
	 */
	public static final String VIDEO_ISMYVIDEO="IsMySiteVideo";
	/**
	 * ��Ƶ�����
	 */
	public static final String VIDEO_HITCOUNT = "PlayCount";
	/**
	 * ��Ƶ����ʱ��
	 */
	public static final String VIDEO_INSERTDATE = "InsertDate";
	/**
	 * ��Ƶ��������
	 */
	public static final String VIDEO_BODYS = "Bodys";
	/**
	 * �ڿν�ʦid
	 */
	public static final String VIDEO_TEACHERID = "TearcherId";
	/**
	 * ��������
	 */
	public static final String VIDEO_COMMCOUNT = "CommCount";
	/**
	 * �Ƿ���ҳ��ʾ �� 1��ҳ��ʾ 0 ����ҳ��ʾ��
	 */
	public static final String VIDEO_ISINDEX = "IsIndex";
	/**
	 * �Ƿ��Ƽ� ��1 �Ƽ� 0 ���Ƽ���
	 */
	public static final String VIDEO_INRECOMM = "IsTuijian";
	/**
	 * �Ƿ��ö� �� 1 �ö� 0 ���ö���
	 */
	public static final String VIDEO_ISTOP = "IsTop";
	/**
	 * �Ƿ񹫿��Σ� 1 ������ 0 �ǹ����Σ�
	 */
	public static final String VIDEO_ISPUBLIC = "IsPublic";
	/**
	 * �Ƿ�վ��Ƶ �� 1 ��վ��Ƶ 0 �Ǳ�վ��Ƶ��
	 */
	public static final String VIDEO_ISMYSIT = "IsMySiteVideo";
	/**
	 * ��Ƶ�����
	 */
	public static final String VIDEOCLASS_TABLE = "JCPVideoClass";
	/**
	 * ��Ƶ����id
	 */
	public static final String VIDEOCLASS_ID = "ID";
	/**
	 * �ϼ�����id
	 */
	public static final String VIDEOCLASS_PARENTID = "ParentId";
	/**
	 * �ؼ���
	 */
	public static final String VIDEOCLASS_KEYWORD = "KeyWord";
	/**
	 * ����
	 */
	public static final String VIDEOCLASS_DESC = "Description";
	/**
	 * ��������
	 */
	public static final String VIDEOCLASS_CLASSNAME = "ClassName";
	/**
	 * ����
	 */
	public static final String VIDEOCLASS_SORTID = "PxId";
	/**
	 * �Ƿ�ɾ�� �� 1 ɾ�� 0 ������
	 */
	public static final String VIDEOCLASS_ISDELETE = "IsDelete";
	/*
	 * ���Ŷ��������
	 */
	public static final String NEWTWOCLASS_TABLE = "JCPNewsSmallClass";
	/**
	 * ����һ������
	 */
	public static final String NEWTWOCLASS_BIGID = "BigId";
	/**
	 * ������������
	 */
	public static final String NEWTWOCLASS_SMALLNAME = "SmallName";
	/**
	 * �ؼ���
	 */
	public static final String NEWTWOCLASS_KEYWORD = "KeyWord";
	/**
	 * ����
	 */
	public static final String NEWTWOCLASS_DESC = "Description";
	/**
	 * ģ������
	 */
	public static final String NEWTWOCLASS_MODELPATH = "TempleteName";
	/**
	 * �ļ�·��
	 */
	public static final String NEWTWOCLASS_FILEPATH = "FilePath";
	/**
	 * ���ӵ�ַ
	 */
	public static final String NEWTWOCLASS_LINKURL = "LinkUrl";
	/**
	 * ����
	 */
	public static final String NEWTWOCLASS_SORTID = "PxId";
	/**
	 * ����һ������
	 */
	public static final String NEWONECLASS_TABLE = "JCPNewsBigClass";
	/**
	 * һ����������
	 */
	public static final String NEWONECLASS_BIGNAME = "BigName";
	/**
	 * �ؼ���
	 */
	public static final String NEWONECLASS_KEYWORD = "KeyWord";
	/**
	 * ����
	 */
	public static final String NEWONECLASS_DESC = "Description";
	/**
	 * ģ��·������
	 */
	public static final String NEWONECLASS_MODELNAME = "TempleteName";
	/**
	 * �ļ�·��
	 */
	public static final String NEWONECLASS_FILEPATH = "FilePath";
	/**
	 * ���ӵ�ַ
	 */
	public static final String NEWONECLASS_LINKURL = "LinkUrl";
	/**
	 * ����id
	 */
	public static final String NEWONECLASS_SORTID = "PxId";
	/**
	 *   ��Ƶ���۱�
	 */
	public static final String VIDEOCOMM_TABLE = "VideoCommen";
	/**
	 *   ��Ƶ����id
	 */
	public static final String VIDEOCOMM_ID = "Id";
	/**
	 *   ���۵���Ƶid
	 */
	public static final String VIDEOCOMM_VIDEOID = "VideoId";
	/**
	 *   ������Ƶ���û�id
	 */
	public static final String VIDEOCOMM_USERID = "UserId";
	/**
	 *  ��Ƶ��������
	 */
	public static final String VIDEOCOMM_BODYS = "Bodys";
	/**
	 *  ��Ƶ���۵�����
	 */
	public static final String VIDEOCOMM_GOODCOUNT = "GoodCount";
	/**
	 *  ��Ƶ���ۻظ���
	 */
	public static final String VIDEOCOMM_REPLYCOUNT = "ReplyCount";
	/**
	 *  ��Ƶ����ʱ��
	 */
	public static final String VIDEOCOMM_INSERTDATE = "InsertDate";
	/**
	 *   ������Ƶ�û�id
	 */
	public static final String VIDEOCOMM_IP = "IP";
	/**
	 *  ��Ƶ�Ƿ���ʾ
	 */
	public static final String VIDEOCOMM_ISSHOW = "IsShow";
	/**
	 *   ˽ļ��
	 */
	public static final String PRIVATEPLACE_TABLE="JCPSiMu";
	/**
	 *   ˽ļid
	 */
	public static final String PRIVATEPLACE_ID="Id";
	/**
	 *  ˽ļ����
	 */
	public static final String PRIVATEPLACE_TITLE="Title"
;	/**
	 *   ˽ļ��������
	 */
	public static final String PRIVATEPLACE_MANAGERNAME="ManagerName";
	/**
	 *  ����ר���ַ
	 */
	public static final String PRIVATEPLACE_LINKURL="LinkPageUrl";
	/**
	 *   ˽ļ����ͼƬ
	 */
	public static final String PRIVATEPLACE_MANAGERIMAGE="ManagerImage";
	/**
	 *  ˽ļ-Ͷ���ż�
	 */
	public static final String PRIVATEPLACE_MENKAN="MenKan";
	/**
	 * �ܻ�����
	 */
	public static final String PRIVATEPLACE_GRADE="Pingji";
	/**
	 * ��������
	 */
	public static final String PRIVATEPLACE_THISPRFIT="ThisYearShouyi";
	/**
	 * ȥ������
	 */
	public static final String PRIVATEPLACE_LASTPRIFIT="LastYearShouyi";
	/**
	 * �Ƽ�����
	 */
	public static final String PRIVATEPLACE_MARKREASON="TuijianInfo";
	/**
	 * �Ƿ���ҳ
	 */
	public static final String PRIVATEPLACE_ISINDEX="IsIndex";
	/**
	 * �Ƿ��Ƽ�
	 */
	public static final String PRIVATEPLACE_ISTUIJIAN="IsTuijian";
	/**
	 * �Ƿ��ö�
	 */
	public static final String PRIVATEPLACE_ISTOP="IsTop";	
	/**
	 *  ��¼��־����
	 */
	public static final String LOGINLOG_TABLE="JCPUserLoginLog";
	/**
	 *  ��¼��־���û�id
	 */
	public static final String LOGINLOG_UID="UserId";
	/**
	 *  ��¼��־���û���
	 */
	public static final String LOGINLOG_UNAME="UserName";
	/**
	 *  ��¼��־���û�����
	 */
	public static final String LOGINLOG_PWD="PassWord";
	/**
	 *  ��¼��־--��¼ʱ��
	 */
	public static final String LOGINLOG_LOGINDATE="LoginDate";
	/**
	 * ��¼��־ --��¼���
	 */
	public static final String LOGINLOG_LOGINRES="LoginResult";
	/**
	 *  ��¼�û�ip
	 */
	public static final String LOGINLOG_IP="LoginIp";
	/**
	 * ��¼��־--��¼��Ϣ��ע
	 */
	public static final String LOGINLOG_REMARK="Remark";

}
