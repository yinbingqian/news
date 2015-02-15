package com.sxit.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;

import com.sxit.customview.LoadingPage;
import com.sxit.customview.LoadingPage.ILoadingDo;
import com.sxit.http.ISoapService;
import com.sxit.http.SoapRes;
import com.sxit.http.SoapService;
import com.sxit.utils.EventCache;
import com.umeng.analytics.MobclickAgent;
//import com.sxit.db.DBHelper;
//import com.sxit.entity.LoginUser;
//import com.sxit.http.ISoapService;
//import com.sxit.http.SoapService;

/**
 * sub Acy
 * 
 * @author huanyu 绫诲悕绉帮細BaseActivity 鍒涘缓鏃堕棿:2014-10-26 涓嬪崍7:38:53
 */
public class BaseActivity extends Activity implements OnClickListener {
	/** soapService **/
	public ISoapService soapService = new SoapService();
	/** loading **/
	private LoadingPage loading;
	private long exitTime;
	public MyApplication myApplication;
	public Intent intent = new Intent();// 椤甸潰璺宠浆
	private static final String TAG = "SU-JPush";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addLoading();
		myApplication = MyApplication.getInstance();
		//这个工程在所有父类中注册了eventbus 所有子类也会得到该值
		EventCache.commandActivity.unregister(this);
		EventCache.commandActivity.register(this);
		EventCache.errorHttp.unregister(this);
		EventCache.errorHttp.register(this);
		Log.d(TAG, "[ExampleApplication] onCreate");
	}


	/**
	 * 娣诲姞loading
	 */
	public void addLoading() {
		loading = new LoadingPage(this, new ILoadingDo() {

			@Override
			public void soapFail(String methodName) {
				EventCache.errorHttp.post(methodName);
			}

		});
		addContentView(loading, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}

	/**
	 * 绉婚櫎 loading
	 */
	public void removeLoading() {
		if (loading != null) {
			ViewGroup parent = (ViewGroup) loading.ll_bg.getParent();
			parent.removeView(loading.ll_bg);
			loading = null;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
		JPushInterface.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
		JPushInterface.onPause(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventCache.commandActivity.unregister(this);
		EventCache.errorHttp.unregister(this);
	}

	protected boolean isParentActivity = true;

	public boolean isParentActivity() {
		return isParentActivity;
	}

	public void setParentActivity(boolean isParentActivity) {
		this.isParentActivity = isParentActivity;
	}

	/** 鐩戝惉杩斿洖閿�*/
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (isParentActivity == true) {
			if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
				if ((System.currentTimeMillis() - exitTime) > 2000) {
					Toast.makeText(getApplicationContext(), "鍐嶆寜涓�閫�嚭绋嬪簭", Toast.LENGTH_SHORT).show();
					exitTime = System.currentTimeMillis();
				} else {
					finish();
					System.exit(0);
				}
				return true;
			}
		} else {
			return super.onKeyDown(keyCode, event);
		}

		return super.onKeyDown(keyCode, event);
	}

	/**
	 * 鐧诲綍鐢ㄦ埛
	 * 
	 * @return
	 */
//	public LoginUser getLoginUser() {
//		DBHelper dbh = new DBHelper(this);
//		return dbh.queryLoginUserInfo();
//	}
//
//	public void setLoginUser(LoginUser loginUser) {
//		DBHelper dbh = new DBHelper(this);
//		dbh.insLoginUserInfo(loginUser);
////		myApplication.loginUser = loginUser;
//	}

	@Override
	public void onClick(View v) {

	}
	/**
	 * http鍥炶皟SoapObject
	 * @param obj	
	 */
	public void onEvent(Object obj) {
		SoapRes res = (SoapRes) obj;
		if (res.getObj() == null && loading != null) {
			loading.setState(1,res.getCode());
		}else{
			removeLoading();
		}
	}
	/**
	 * http error鍥炶皟
	 * @param method	鏂规硶鏄庡悕
	 */
	public void onEventMainThread(String method) {
		
	}
}
