package com.sxit.utils;

public class SOAP_UTILS {
	public class METHOD {
		// 登录方法
		public static final String METHOD_LOGIN = "login";
		// 通过新闻栏目返回新闻方法
		public static final String GETCOLUMNSTONEWS = "columnstonews";
		public static final String GETNEWSTITLE = "GetNewsTitle";
		// 根据新闻id号，返回具体新闻内容方法
		public static final String GETNEWSCONTENT = "news";
		// 栏目关联话题
		public static final String COMMUNICATIONLIST = "communicationlist";
		// 话题列表
		public static final String COMMUNICATION = "communication";
		// 话题关联回复
		public static final String COMMUNREPLY = "communReply";
		// 回复话题
		public static final String ADDCOMMUNREPLY = "AddCommunReply";
		// 手机端创建话题
		public static final String ADDCOMMUNICATION = "AddCommunication";
		// 闂瓟鍥炲鍒楄〃
		public static final String GETCOMMUNREPLY = "GetCommunReply";
		// 鍒嗘瀽甯堝洖澶嶅垪琛�
		public static final String GETCOMMUNREPLYANA = "GetCommunReplyAna";
		// 鏍规嵁鍥炲ID杩斿洖璇︾粏淇℃伅
		public static final String GETCOMMUNREPLYBYID = "GetCommunReplyByID";
		// 闂瓟鍒嗙被鏄剧ず
		public static final String GETCOMMUNICATION = "GetCommunication";
		// 鐢ㄦ埛涓汉鍏ㄩ儴闂瓟鍒楄〃
		public static final String GETCOMMUNICATIONALL = "GetCommunicationALL";
		// 鐢ㄦ埛鍏ㄩ儴闂瓟鍒楄〃
		public static final String GETCOMMUNICATIONALLUSER = "GetCommunicationAllUser";
		// 鏈В鍐抽棶棰�
		public static final String GETCOMMUNICATIONANA = "GetCommunicationAna";
	
		// 鎺ユ敹娑堟伅棣栭〉淇℃伅 TOUSER锛氭帴鏀剁鐢ㄦ埛ID
		public static final String INTERACTIONHOMEPAGE = "InteractionHomepage";
		// 鎺ユ敹鐢ㄦ埛鑾峰彇鎺ㄩ�淇℃伅 TOUSER锛氱敤鎴稩D,HISTORYTIME锛氬巻鍙叉椂闂�
		public static final String INTERACTIONMESSAGE = "InteractionMessage";
		// 鎺ユ敹鐢ㄦ埛鑾峰彇鎺ㄩ�淇℃伅 TOUSER锛氱敤鎴稩D,HISTORYTIME锛氬巻鍙叉椂闂�
		public static final String INTERACTIONMESSAGEANA = "InteractionMessageAna";
		// 鎺ユ敹鐢ㄦ埛鑾峰彇鎺ㄩ�淇℃伅 ID锛氭秷鎭疘D,INFOTYPE:1娑堟伅/2鐮旀姤锛宨nfoDirection:1鐢ㄦ埛-鍒嗘瀽甯�2鍒嗘瀽甯�鐢ㄦ埛
		public static final String INTERACTIONMESSAGEBYID = "InteractionMessageByID";
		// 浜掑姩鍐呭鎻愪氦锛孌EVTYPE:1Android/2iPhone锛宨nfoType:1娑堟伅/2鐮旀姤锛宨nfoDirection:1鐢ㄦ埛-鍒嗘瀽甯�2鍒嗘瀽甯�鐢ㄦ埛
		public static final String INTERACTIONSUBMIT = "InteractionSubmit";
		// 鏍规嵁鍥炲ID閫夋嫨鏈�匠绛旀
		public static final String UPDATABESTANSWER = "UpdataBestAnswer";
		// 鐢ㄦ埛鐧婚檰淇℃伅--鐢ㄦ埛鍚峾瀵嗙爜
		public static final String USERINFOLOGIN = "UserInfoLogin";
		// 鐢ㄦ埛鍏呭�
		public static final String USERPAYMENT = "UserPayment";
		// 鐢ㄦ埛娉ㄥ唽
		public static final String USERREGISTERED = "UserRegistered";
		//瀵嗙爜閲嶇疆
		public static final String USERPASSWORDRESET  = "UserPasswordReset ";
		//鐢ㄦ埛鍚嶆牎楠岋細杩斿洖true鍙敤|false涓嶅彲鐢�
		public static final String USERNAMECHECK = "UserNameCheck ";
		//缂栬緫淇℃伅options:1鏄电О;2鎬у埆;3鑲￠緞;4鎶曡祫椋庢牸;
		public static final String USEREDITOR = "UserEditor";
		//缂栬緫鍩庡競淇℃伅
		public static final String USEREDITOR_CITY = "UserEditor_city";
		//缂栬緫澶村儚锛屽叾涓璱mages锛氬浘鐗囩殑BASE64杞爜
		public static final String USEREDITOR_HEAD = "UserEditor_head";
		//鐮旀姤鍒楄〃
		public static final String GETREPORTLIST = "GetReportList";
		//鐮旀姤鎻愪氦锛宺eportType:鐮旀姤鍒嗙被
		public static final String REPORTSUBMIT = "ReportSubmit";
		//杩斿洖鐮旀姤鍐呭
		public static final String GETREPORTCONTENT = "GetReportContent";
	}

	public class ERROR {
		public static final String ERR0000 = "ERR 000";
		public static final String ERR0001 = "ERR 001";
		public static final String ERR0002 = "ERR 002";
		public static final String ERR0003 = "ERR 003";
		public static final String ERR0004 = "ERR 004";
		public static final String ERR0005 = "ERR 005 XML瑙ｆ瀽閿欒";
		public static final String ERR0006 = "ERR 006 鏈湴閿欒";

	}

	public static final String NAMESPACE = "MobileNewspaper";
	// public static final String IP = "http://219.148.199.62/licai";
	// public static final String IP = "http://219.148.199.62/licai";
//	public static final String IP = "http://200.20.30.212:8027/lnpdit";
//	public static final String IP = "http://219.148.199.62:8027/lnpdit";
	public static final String IP = "http://200.20.31.62:8027/lnpdit";//wz的
//	public static final String IP = "http://218.60.13.9:8027/lnpdit";//服务器
	public static final String HEADER_URL = "http://218.60.13.9:8002/upload/headpic/";
	public static final String URL = IP + "/phoneinvoke.asmx";
	public static final String URL_WITHOUT_WSDL = IP + "/phoneinvoke.asmx";
	public static final String PIC_FILE = IP + "/manage/pic/";
	public static final String PIC_JOURNAL = IP + "/manage/magpic/";
	public static final String PIC_PUSH = IP + "/upload/";
	public static final String PIC_YANBAO = IP + "/manage/pic/";
	public static final String URL_SERVER = IP + "/apksource/version.xml";
	public static final String VIDEO_PATH = IP + "/manage/videofile/";
	public static final String AUDIO_PATH = IP + "/audio/";
	public static final String COL_PATH = IP + "/columns.xml";
	public static final String HEAD_PIC_PATH = IP + "/upload/headpic/";
	public static final String COLUMN_PIC_PATH = IP + "/upload/column/";
	// login type
	public static final int ADMIN = 0;// 椤鹃棶
	public static final int USER = 1;// 鎶曡祫鑰�
	// definitions xmlns:s="http://www.w3.org/2001/XMLSchema"
	// xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/"
	// xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/"
	// xmlns:tns="MobileNewspaper"
	// xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
	// xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/"
	// xmlns:http="http://schemas.xmlsoap.org/wsdl/http/"
	// xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/"
	// xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
	// targetNamespace="MobileNewspaper"

}
