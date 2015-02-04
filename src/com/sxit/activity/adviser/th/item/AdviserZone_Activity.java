package com.sxit.activity.adviser.th.item;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.sxit.activity.base.BaseActivity;
//import com.sxit.activity.login.Login_Activity;
//import com.sxit.activity.register.Register_Activity;

import lnpdit.operate.news.R;

/**
 * 鎴戠殑绌洪棿
 * 
 * @author huanyu 绫诲悕绉帮細MyZone_Activity 鍒涘缓鏃堕棿:2014-10-26 涓嬪崍8:30:59
 */
public class AdviserZone_Activity extends BaseActivity {
	private Button bt_login, bt_register, bt_analyst;// 鐧诲綍銆佹敞鍐屻�椤鹃棶鐧诲綍
	private ScrollView ic_register, ic_unlogin;
	private LinearLayout ic_login, ic_analyst;
	private int curUI;// 0锛氭湭鐧诲綍 1锛氭姇璧勮�鐧诲綍 2锛氭敞鍐�3:椤鹃棶鐧诲綍
	private ImageView img_back;// back
	private TextView tv_register;//娉ㄥ唽

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_adviserzone);
//		initView();
//		setListeners();
	}

//	private void initView() {
//		// title
//		img_back = (ImageView) findViewById(R.id.img_back);
//		tv_register = (TextView) findViewById(R.id.tv_register);
//		// scroll
////		ic_login = (LinearLayout) findViewById(R.id.ic_login);
////		ic_register = (ScrollView) findViewById(R.id.ic_register);
//		ic_unlogin = (ScrollView) findViewById(R.id.ic_unlogin);
////		ic_analyst = (LinearLayout) findViewById(R.id.ic_analyst);
//		// button
//		bt_login = (Button) findViewById(R.id.bt_login);
//		bt_register = (Button) findViewById(R.id.bt_register);
////		bt_analyst = (Button) findViewById(R.id.bt_analyst);
//	}
//
//	private void setListeners() {
//		bt_login.setOnClickListener(this);
//		bt_register.setOnClickListener(this);
////		bt_analyst.setOnClickListener(this);
//		img_back.setOnClickListener(this);
//		tv_register.setOnClickListener(this);
//	}
//
//	@Override
//	public void onClick(View v) {
//		Intent intent = new Intent();
//		switch (v.getId()) {
//		case R.id.bt_register:
//			curUI = 1;
////			changLoginState();
//			intent.setClass(this, Register_Activity.class);
//			this.startActivity(intent);
//			break;
//		case R.id.bt_login:
//			curUI = 2;
//			
//			intent.setClass(this, Login_Activity.class);
//			this.startActivity(intent);
////			changLoginState();
//			break;
////		case R.id.bt_analyst:
////			curUI = 3;
////			changLoginState();
////			break;
//		case R.id.tv_register:
//
//			break;
//		case R.id.img_back:
//			if (curUI == 0) {
//
//			} else {
//				curUI = 0;
//				changLoginState();
//			}
//			break;
//		default:
//			break;
//		}
//	}
//
//	/**
//	 * 鍒囨崲UI鐘舵�
//	 */
//	private void changLoginState() {
//		switch (curUI) {
//		case 0:
//			ic_login.setVisibility(View.GONE);
//			ic_register.setVisibility(View.GONE);
//			ic_unlogin.setVisibility(View.VISIBLE);
//			ic_analyst.setVisibility(View.GONE);
//			tv_register.setVisibility(View.GONE);
//			break;
//		case 1:
//			ic_login.setVisibility(View.VISIBLE);
//			ic_register.setVisibility(View.GONE);
//			ic_unlogin.setVisibility(View.GONE);
//			ic_analyst.setVisibility(View.GONE);
//			tv_register.setVisibility(View.VISIBLE);
//			break;
//		case 2:
//			ic_login.setVisibility(View.GONE);
//			ic_register.setVisibility(View.VISIBLE);
//			ic_unlogin.setVisibility(View.GONE);
//			ic_analyst.setVisibility(View.GONE);
//			tv_register.setVisibility(View.VISIBLE);
//			break;
//		case 3:
//			ic_login.setVisibility(View.GONE);
//			ic_register.setVisibility(View.GONE);
//			ic_unlogin.setVisibility(View.GONE);
//			ic_analyst.setVisibility(View.VISIBLE);
//			tv_register.setVisibility(View.VISIBLE);
//			break;
//		default:
//			break;
//		}
//	}
//
//	@Override
//	protected void onResume() {
//		super.onResume();
//	}
//
//	@Override
//	protected void onPause() {
//		super.onPause();
//	}
//
//	@Override
//	protected void onDestroy() {
//		super.onDestroy();
//	}
}
