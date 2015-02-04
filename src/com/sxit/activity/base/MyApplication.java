package com.sxit.activity.base;

import java.util.LinkedList;
import java.util.List;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.sxit.activity.adviser.th.AMainTabHostActivity;
import com.sxit.activity.th.MainTabHostActivity;
//import com.sxit.db.DBHelper;
//import com.sxit.entity.LoginUser;

import android.app.Activity;
import android.app.Application;

public class MyApplication extends Application {
	/** 鍏ㄥ眬甯搁噺 **/
//	public static LoginUser loginUser;
	//
	public String sender_id;
	public static final String TAG = MyApplication.class.getSimpleName();
	public MainTabHostActivity mainTabHostActivity;
	public AMainTabHostActivity aMainTabHostActivity;
	private static MyApplication instance = null;
//	private DBHelper dbh;

	public synchronized static MyApplication getInstance() {
		if (null == instance) {
			instance = new MyApplication();
		}
		return instance;
	}

	// 杩愮敤list鏉ヤ繚瀛樹滑姣忎竴涓猘ctivity鏄叧閿�
	private List<Activity> mList = new LinkedList<Activity>();

	// add Activity
	public void addActivity(Activity activity) {
		mList.add(activity);
	}

	// 鍏抽棴姣忎竴涓猯ist鍐呯殑activity
	public void exit() {
		try {
			for (Activity activity : mList) {
				if (activity != null)
					activity.finish();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// finally {
		// System.exit(0);
		// }
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = getInstance();
		ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
		ImageLoader.getInstance().init(configuration);
//		dbh = new DBHelper(this);
	}

	public void exitApp() {
		if (mainTabHostActivity != null) {
			mainTabHostActivity.finish();
		}
		if (aMainTabHostActivity != null) {
			aMainTabHostActivity.finish();
		}
	}

//	public LoginUser getLoginUser() {
//		return dbh.queryLoginUserInfo();
//	}

//	public void setLoginUser(LoginUser loginUser) {
//		dbh.insLoginUserInfo(loginUser);
//		// this.loginUser = loginUser;
//	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

}
