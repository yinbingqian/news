package com.sxit.activity.chatmsg;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.ksoap2.serialization.SoapObject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sxit.activity.adviser.th.AMainTabHostActivity;
import com.sxit.activity.base.BaseActivity;
//import com.sxit.activity.chatmsg.adapter.ChattingAdapter;
import com.sxit.activity.th.MainTabHostActivity;
//import com.sxit.activity.welcome.Welcome_Activity;
//import com.sxit.db.DBHelper;
import com.sxit.entity.Adviser;
//import com.sxit.entity.ChatMessage;
//import com.sxit.entity.LoginUser;
import com.sxit.entity.UserInfo;
//import com.sxit.entity.eb.ChatMessageEB;
//import com.sxit.http.SoapWebService;
import com.sxit.utils.EventCache;
import com.sxit.utils.SOAP_UTILS;
//import com.sxit.utils.Utils;

import lnpdit.operate.news.R;

// 1 鏄垜鍙戠殑 0 鏄帴鏀剁殑
public class Chat_Activity extends BaseActivity {
	private Button bt_send;
	private ListView chat_message_listview;
	private TextView tv_title;
//	private ChattingAdapter ca;
//	private List<ChatMessage> messages;
	private EditText chat_msg_input_et_single;
	private ImageView img_back, img_info;
	private Object NULL = null;
	private UserInfo ui;
//	private ChatMessage cm;
	private Adviser analystInfo;
//	private DBHelper dbh;
	private SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println(">>>>> Chat_Activity onCreate");
//		this.setContentView(R.layout.activity_chat_layout);
//		EventCache.msgNotiEvent.register(this);
//		this.isParentActivity = false;
//		dbh = new DBHelper(this);
//		intent = getIntent();
//		analystInfo = (Adviser) intent.getSerializableExtra("analystInfo");
//
//		System.out.println("@@@" + analystInfo.getHeadpic());
//		sp = this.getSharedPreferences("loginInfo", Context.MODE_WORLD_READABLE);
//		bt_send = (Button) findViewById(R.id.bt_send);
//		tv_title = (TextView) findViewById(R.id.tv_title);

//		chat_message_listview = (ListView) findViewById(R.id.chat_message_listview);
//
//		chat_msg_input_et_single = (EditText) findViewById(R.id.chat_msg_input_et_single);
//		ui = new UserInfo();
//		cm = new ChatMessage();
//		img_back = (ImageView) findViewById(R.id.img_back);
//		img_info = (ImageView) findViewById(R.id.img_info);
//		img_back.setOnClickListener(this);
//		img_info.setOnClickListener(this);
//		bt_send.setOnClickListener(this);
//		messages = new ArrayList<ChatMessage>();
//		// Intent intent = this.getIntent();
//		if (analystInfo == null) {
//			finish();
//			System.out.println("intent null");
//		} else {
//			tv_title.setText(analystInfo.getRealname());
//
//			// initTestData();
//			initMsgData();
//		}
//		chat_message_listview.setOnItemClickListener(oic);

	}

//	private OnItemClickListener oic = new OnItemClickListener() {
//
//		@Override
//		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//			switch (messages.get(arg2).getMsg_type()) {
//			case 0:
//
//				break;
//			case 1:
//
//				break;
//			case 2:
//
//				break;
//
//			default:
//				break;
//			}
//			;
//
//		}
//	};
//
//	@Override
//	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.bt_send:
//
//			if (Integer.parseInt(getLoginUser().getMark()) - 10 < 0) {
//				Utils.showRechargeDialog(Chat_Activity.this);
//			} else {
//				sendTextMsg(chat_msg_input_et_single.getText().toString().trim());
//			}
//
//			break;
//		case R.id.img_back:
//			goToMain();
//			break;
//		case R.id.img_info:
//
//			break;
//
//		default:
//			break;
//		}
//		super.onClick(v);
//	}
//
//	// private void initTestData() {
//	// ui.setUserheader(SOAP_UTILS.HEADER_URL + analystInfo.getHeadpic());
//	// ui.setUserid("122001");
//	// ui.setUsername("鐜嬪ぇ澹�);
//	// cm.setContent3_title("骞挎棩鑲′唤2014骞村墠涓夊鍑�25% 鏂伴」鐩�姝ュ彂鍔�);
//	// cm.setContent3_img("http://img1.money.126.net/chart/hs/kline/day/90/0600894.png");
//	// cm.setContent3_content("10鏈�8鏃ユ櫄闂达紝骞挎棩鑲′唤鍙戝竷2014骞翠笁瀛ｅ害涓氱哗鎶ュ憡銆傛姤鍛婃樉绀猴紝鎴2014骞�鏈�0鏃ワ紝鍏徃浠婂勾浠ユ潵瀹炵幇钀ヤ笟鏀跺叆33.66浜垮厓锛屼笌鍘诲勾鍚屾湡鐩告瘮澧為暱15.07%锛涘綊灞炰簬涓婂競鍏徃鑲′笢鐨勫噣鍒╂鼎5.05浜垮厓锛屽悓姣斿闀�5.02%锛涙瘡鑲℃敹鐩婁负0.62鍏冦�");
//	// cm.setContent3_url("http://money.163.com/14/1028/22/A9M6SIHB00253B0H.html");
//	// // cm.setContent3_url("http://m.money.163.com/news/14/1028/22/A9M6SIHB00253B0H.html#1a01");
//	// cm.setMsg_direction(0);
//	// cm.setMsg_send_date("2014-10-28");
//	// cm.setMsg_type(2);
//	// cm.setLogin_id("122001");
//	// cm.setStatus(1);
//	// cm.setSender_id("134221");
//	// cm.setUserinfo(ui);
//	// messages.add(cm);
//	// }
//
//	public void initMsgData() {
//		dbh.setMsgReaded(dbh.queryLoginUserInfo().getUserid(), analystInfo.getAdv_user_id());
//		messages = dbh.queryMsgData(analystInfo, getLoginUser());
//		ca = new ChattingAdapter(Chat_Activity.this, messages);
//		chat_message_listview.setAdapter(ca);
//	}
//
//	private void sendTextMsg(String content) {
//		if (content == null || content.equals("")) {
//			Toast.makeText(this, "涓嶈兘鍙戦�绌轰俊鎭�, Toast.LENGTH_SHORT).show();
//		} else {
//			// Toast.makeText(this, "淇℃伅鍙戦�鎴愬姛锛岃鑰愬績绛夊緟鍥炲", Toast.LENGTH_SHORT).show();
//			UserInfo ui = new UserInfo();
//			ui.setUserheader(getLoginUser().getHeadpic());
//			ui.setUserid(getLoginUser().getUserid());
//			ui.setUsername(getLoginUser().getRealname());
//			cm = new ChatMessage();
//			cm.setContent1(content);
//			cm.setMsg_direction(1);
//
//			cm.setMsg_send_date(Utils.getSystemDate());
//			cm.setMsg_type(0);
//			cm.setLogin_id(getLoginUser().getUserid());
//			cm.setStatus(1);
//			cm.setSender_id(analystInfo.getAdv_user_id());
//			cm.setUserinfo(ui);
//			messages.add(cm);
//			if (null == ca || ca.getCount() == 0) {
//				ca = new ChattingAdapter(Chat_Activity.this, messages);
//				chat_message_listview.setAdapter(ca);
//			} else {
//				ca.notifyDataSetChanged();
//			}
//			dbh.insMsgData(cm);
//			// new SendAT().execute(NULL);
//			String[] property_nm = { "fromUser", "toUser", "blogTitle", "blogAbstract", "content", "devType", "infoType", "infoDirection" };
//			Object[] property_va = { analystInfo.getAdv_user_id(), getLoginUser().getUserid(), content, content, content, 1, 1, 1 };
//			new SendAT().execute(property_nm, property_va);
//		}
//		chat_msg_input_et_single.setText("");
//		InputMethodManager imm = (InputMethodManager) getSystemService(Chat_Activity.INPUT_METHOD_SERVICE);
//		imm.hideSoftInputFromWindow(chat_msg_input_et_single.getWindowToken(), 0);
//		new RefreshListAT().execute(NULL);
//	}
//
//	private void FreshList() {
//		ca.notifyDataSetChanged();
//		chat_message_listview.setSelection(chat_message_listview.getCount() - 1);
//	}
//
//	class RefreshListAT extends AsyncTask<Object, Object, Object> {
//		@Override
//		protected void onPreExecute() {
//			FreshList();
//			super.onPreExecute();
//		}
//
//		@Override
//		protected Object doInBackground(Object... params) {
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return null;
//		}
//
//		@Override
//		protected void onPostExecute(Object result) {
//			FreshList();
//			super.onPostExecute(result);
//		}
//
//	}
//
//	class SendAT extends AsyncTask<Object, Object, Object> {
//		@Override
//		protected void onPreExecute() {
//			bt_send.setEnabled(false);
//			super.onPreExecute();
//		}
//
//		@Override
//		protected Object doInBackground(Object... params) {
//			System.out.println(">>>>>");
//		
//			Object res_obj = SoapWebService.data(SOAP_UTILS.METHOD.INTERACTIONSUBMIT, (String[]) params[0], (Object[]) params[1]);
//			SoapObject so = (SoapObject)res_obj;
//			String soapchilds =so.getProperty("InteractionSubmitResult").toString();
//			if(soapchilds.equals("true")){
//				payForChat();
//			}else{
//				
//			}
//			System.out.println("####" + res_obj);
//			return null;
//		}
//
//		@Override
//		protected void onPostExecute(Object result) {
//			bt_send.setEnabled(true);
//			super.onPostExecute(result);
//		}
//
//	}
//
//	private void payForChat() {
//		LoginUser lu = getLoginUser();
//		lu.setMark((Integer.parseInt(getLoginUser().getMark()) - 10) + "");
//		setLoginUser(lu);
//	}
//
//	public void onEvent(ChatMessageEB cmeb) {
//		if (!cmeb.getChatmessage().getSender_id().equals(analystInfo.getAdv_user_id()))
//			return;
//		// ChatMessage cm = cmeb.getChatmessage();
//		// UserInfo ui = cm.getUserinfo();
//		// ui.setUserheader(SOAP_UTILS.HEADER_URL + ui.getUserheader());
//		// cm.setUserinfo(ui);
//		// ChatMessage
//		ChatMessage cmevnet = new ChatMessage();
//		cmevnet = cmeb.getChatmessage();
//		// cmevnet.setContent1(content1)
//		ChatMessage cmevented = new ChatMessage();
//		if (cmevnet.getMsg_type() == 2) {
//			// TODO 鐮旀姤
//			cmevented.setContent3_content(cmevnet.getContent3_content());
//			cmevented.setContent3_img(cmevnet.getContent3_img());
//			cmevented.setContent3_title(cmevnet.getContent3_title());
//			cmevented.setContent3_url("http://m.money.163.com/news/14/1028/22/A9M6SIHB00253B0H.html#1a01");
//			cmevented.setMsg_type(2);
//		} else if (cmevnet.getMsg_type() == 1) {
//			// TODO 璇煶
//			// cm.setContent2(content2);
//			cmevented.setMsg_type(1);
//		} else if (cmevnet.getMsg_type() == 0) {
//			// TODO 鏂囨湰
//			cmevented.setContent1(cmevnet.getContent1());
//			cmevented.setMsg_type(0);
//		} else {
//			cm.setContent1("寮傚父娑堟伅");
//		}
//		cmevented.setLogin_id(dbh.queryLoginUserInfo().getUserid());
//		cmevented.setMsg_direction(0);
//		cmevented.setMsg_send_date(cmevnet.getMsg_send_date());
//		cmevented.setSender_id(cmevnet.getSender_id());
//		UserInfo ui = new UserInfo();
//		ui.setUserheader(analystInfo.getHeadpic());
//		ui.setUserid(analystInfo.getAdv_user_id());
//		ui.setUsername(analystInfo.getRealname());
//		cmevented.setUserinfo(ui);
//		messages.add(cmevented);
//		new RefreshListAT().execute(NULL);
//		if (myApplication.sender_id.equals(analystInfo.getAdv_user_id())) {
//			dbh.setMsgReaded(getLoginUser().getUserid(), analystInfo.getAdv_user_id());
//		}
//
//	}
//
//	@Override
//	protected void onResume() {
//		// TODO Auto-generated method stub
//		myApplication.sender_id = analystInfo.getAdv_user_id();
//		System.out.println("@@@ present chatting persion id 锛�" + myApplication.sender_id);
//		super.onResume();
//
//	}
//
//	@Override
//	protected void onStop() {
//		// TODO Auto-generated method stub
//		myApplication.sender_id = "";
//		System.out.println("@@@ reset present chatting persion id " + myApplication.sender_id);
//		super.onStop();
//
//	}
//
//	@Override
//	protected void onNewIntent(Intent intent) {
//		System.out.println("onNewIntent C ChatActivity");
//		this.isParentActivity = false;
//		dbh = new DBHelper(this);
//		analystInfo = (Adviser) intent.getSerializableExtra("analystInfo");
//
//		bt_send = (Button) findViewById(R.id.bt_send);
//		tv_title = (TextView) findViewById(R.id.tv_title);
//
//		chat_message_listview = (ListView) findViewById(R.id.chat_message_listview);
//		chat_msg_input_et_single = (EditText) findViewById(R.id.chat_msg_input_et_single);
//		ui = new UserInfo();
//		cm = new ChatMessage();
//		img_back = (ImageView) findViewById(R.id.img_back);
//		img_info = (ImageView) findViewById(R.id.img_info);
//		img_back.setOnClickListener(this);
//		img_info.setOnClickListener(this);
//		bt_send.setOnClickListener(this);
//		messages = new ArrayList<ChatMessage>();
//		// Intent intent = this.getIntent();
//		if (analystInfo == null) {
//			finish();
//		} else {
//			tv_title.setText(analystInfo.getRealname());
//			System.out.println("intent null");
//			// initTestData();
//			initMsgData();
//		}
//		super.onNewIntent(intent);
//	}
//
//	private void goToMain() {
//		Intent intent = new Intent();
//		intent.setClass(this, MainTabHostActivity.class);
//		startActivity(intent);
//		finish();
//	}
//
//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
//			goToMain();
//			return false;
//		} else {
//			return super.onKeyDown(keyCode, event);
//		}
//	}

}
