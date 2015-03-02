package com.sxit.http;

import java.util.List;

/**
 * webService璇锋眰鎺ュ彛
 * @author huanyu 绫诲悕绉帮細ISoapService 鍒涘缓鏃堕棿:2014-11-4 涓嬪崍7:08:50
 */
public interface ISoapService extends IASoapService{
	/**
	 * 鍒嗘瀽甯堢櫥闄嗕俊鎭�-鐢ㄦ埛鍚峾瀵嗙爜
	 * 
	 * @param property_va
	 */
	void adminLogin(Object[] property_va);

	/**
	 * 闂瓟鍥炲淇℃伅娣诲姞
	 * 
	 * @param property_va
	 */
	void communReplyAdd(Object[] property_va);

	/**
	 * 闂瓟淇℃伅娣诲姞
	 * 
	 * @param property_va
	 */
	void communicationAdd(Object[] property_va);

	/**
	 * 鍒嗘瀽甯堝垪琛�
	 * 
	 * @param property_va
	 */
	void getAdmin(Object[] property_va);

	/**
	 * 杩斿洖鏍忕洰淇℃伅
	 * 
	 * @param property_va
	 */
	void getColumns(Object[] property_va, boolean isPage);

	/**
	 * 鍒嗘瀽甯堝洖澶嶅垪琛�
	 * 
	 * @param property_va
	 */
	void getCommunReplyAna(Object[] property_va);

	/**
	 * 鏍规嵁鍥炲id杩斿洖璇︾粏淇℃伅
	 * 
	 * @param property_va
	 */
	void getCommunReplyByID(Object[] property_va);

	/**
	 * 闂瓟鍒嗙被鏄剧ず
	 * 
	 * @param property_va
	 */
	void getCommunication(Object[] property_va);

	/**
	 * 鐢ㄦ埛涓汉鍏ㄩ儴闂瓟鍒楄〃
	 * 
	 * @param property_va
	 * @param isPage
	 *            鏄惁鍋氬垎椤�
	 */
	void getCommunicationALL(Object[] property_va, boolean isPage);

	/**
	 * 鐢ㄦ埛鍏ㄩ儴闂瓟鍒楄〃
	 * 
	 * @param property_va
	 * @param isPage
	 */
	void getCommunicationAllUser(Object[] property_va, boolean isPage);

	/**
	 * 鏈В鍐抽棶棰�
	 * 
	 * @param property_va
	 */
	void getCommunicationAna(Object[] property_va);

	/**
	 * 杩斿洖鏂伴椈鍐呭
	 * 
	 * @param property_va
	 */
	void getNewsContent(Object[] property_va);

	/**
	 * 杩斿洖鏈�柊鏂伴椈鍒楄〃
	 * 
	 * @param property_va
	 */
	void getNewsTitle(Object[] property_va, boolean isPage);
	
	void getCategoryTitle(Object[] property_va, boolean isPage);

	/**
	 * 鎺ユ敹娑堟伅棣栭〉淇℃伅 toUser锛氭帴鏀剁鐢ㄦ埛id
	 * 
	 * @param property_va
	 */
	void interactionHomepage(Object[] property_va);

	/**
	 * 鎺ユ敹鐢ㄦ埛鑾峰彇鎺ㄩ�淇℃伅 toUser锛氱敤鎴穒d,historyTime锛氬巻鍙叉椂闂�
	 * 
	 * @param property_va
	 */
	void interactionMessage(Object[] property_va);

	/**
	 * 鎺ユ敹鐢ㄦ埛鑾峰彇鎺ㄩ�淇℃伅 toUser锛氱敤鎴穒d,historyTime锛氬巻鍙叉椂闂�Ana
	 * 
	 * @param property_va
	 */
	void interactionMessageAna(Object[] property_va);

	/**
	 * 鎺ユ敹鐢ㄦ埛鑾峰彇鎺ㄩ�淇℃伅 ID锛氭秷鎭痠d,infoType:1娑堟伅/2鐮旀姤锛宨nfoDirection:1鐢ㄦ埛-鍒嗘瀽甯�2鍒嗘瀽甯�鐢ㄦ埛
	 * 
	 * @param property_va
	 */
	void interactionMessageByID(Object[] property_va);

	/**
	 * 浜掑姩鍐呭鎻愪氦锛宒evType:1Android/2iPhone锛宨nfoType:1娑堟伅/2鐮旀姤锛宨nfoDirection:1鐢ㄦ埛-鍒嗘瀽甯�2
	 * 鍒嗘瀽甯�鐢ㄦ埛
	 * 
	 * @param property_va
	 */
	void interactionSubmit(Object[] property_va);

	/**
	 * 鏍规嵁鍥炲id閫夋嫨鏈�匠绛旀
	 * 
	 * @param property_va
	 */
	void updataBestAnswer(Object[] property_va);

	/**
	 * 鐢ㄦ埛鐧诲綍
	 * 
	 * @param property_va
	 */
	void userInfoLogin(Object[] property_va);

	/**
	 * 鏍规嵁鍥炲id閫夋嫨鏈�匠绛旀
	 * 
	 * @param property_va
	 */
	void userPayment(Object[] property_va);

	/**
	 * 鐢ㄦ埛娉ㄥ唽
	 * 
	 * @param property_va
	 */
	void userRegistered(Object[] property_va);

	/**
	 * 鍏呭�瀵嗙爜
	 * 
	 * @param property_va
	 */
	void userPasswordReset(Object[] property_va);

	/**
	 * 鐢ㄦ埛鍚嶆牎楠岋細杩斿洖true鍙敤|false涓嶅彲鐢�
	 * 
	 * @param property_va
	 */
	void userNameCheck(Object[] property_va);

	/**
	 * 缂栬緫淇℃伅options:1鏄电О;2鎬у埆;3鑲￠緞;4鎶曡祫椋庢牸;
	 * 
	 * @param property_va
	 */
	void userEditor(Object[] property_va);

	/**
	 * 缂栬緫鍩庡競淇℃伅
	 * 
	 * @param property_va
	 */
	void userEditor_city(Object[] property_va);

	/**
	 * 缂栬緫澶村儚锛屽叾涓璱mages锛氬浘鐗囩殑BASE64杞爜
	 * 
	 * @param property_va
	 */
	void userEditor_head(Object[] property_va);

	/**
	 * 鐮旀姤鍒楄〃
	 * 
	 * @param property_va
	 */
	void getReportList(Object[] property_va,boolean isPage);

	/**
	 * 鐮旀姤鎻愪氦锛宺eportType:鐮旀姤鍒嗙被
	 * 
	 * @param property_va
	 */
	void reportSubmit(Object[] property_va);

	/**
	 * 杩斿洖鐮旀姤鍐呭
	 * 
	 * @param property_va
	 */
	void getReportContent(Object[] property_va);

}
