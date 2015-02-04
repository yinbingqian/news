package com.sxit.activity.th;

import android.app.TabActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;

import lnpdit.operate.news.R;

@SuppressWarnings("deprecation")
public abstract class TabHostAbstractActivity extends TabActivity {

	private TabHost mTabHost;
	private TabWidget mTabWidget;
	private LayoutInflater mLayoutflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
//			setTheme(R.style.Theme_Tabhost);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			setContentView(R.layout.activity_tabhost_main);

			mLayoutflater = getLayoutInflater();

			mTabHost = getTabHost();
			mTabWidget = getTabWidget();

			prepare();
			initTabSpec();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * tabHost涓璱tem鍒濆鍖�
	 */
	private void initTabSpec() {

		int count = getTabItemCount();
		System.out.println("count =" + count);
		for (int i = 0; i < count; i++) {
			// 鑾峰彇鑷畾涔夊竷灞�
			View tabItem = mLayoutflater.inflate(
					R.layout.activity_tabhost_item, null);
			//鍥剧墖
			ImageView imgTabItem = (ImageView) tabItem
					.findViewById(R.id.tab_item_img);
			//鏂囧瓧
			TextView tvTabItem = (TextView) tabItem
					.findViewById(R.id.tab_item_tv);
			//鑳屾櫙
			LinearLayout ll = (LinearLayout) tabItem
					.findViewById(R.id.tab_itme_ll);
			setTabItemTextView(tvTabItem, imgTabItem, ll, i);
			//璁剧疆ID
			String tabItemId = getTabItemId(i);
			// 娣诲姞锛岃缃畇pec
			TabSpec tabSpec = mTabHost.newTabSpec(tabItemId);
			tabSpec.setIndicator(tabItem);
			tabSpec.setContent(getTabItemIntent(i));
			mTabHost.addTab(tabSpec);
		}

	}

	protected void prepare() {
	}

	protected View getTop() {
		return null;
	}

	protected int getTabCount() {
		return mTabHost.getTabWidget().getTabCount();
	}

	abstract protected void setTabItemTextView(TextView textView,
			ImageView imgTabItem, LinearLayout ll, int position);

	abstract protected String getTabItemId(int position);

	abstract protected Intent getTabItemIntent(int position);

	abstract protected int getTabItemCount();

	protected void setCurrentTab(int index) {
		mTabHost.setCurrentTab(index);
	}

	protected void focusCurrentTab(int index) {
		mTabWidget.focusCurrentTab(index);
	}

}
