package com.sxit.activity.news;

import lnpdit.operate.news.R;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.sxit.activity.base.BaseActivity;
import com.sxit.customview.FocusedtrueTV;
import com.sxit.entity.news.FinNewsInfo;
import com.sxit.entity.news.FinNewsList;
import com.sxit.http.SoapRes;
import com.sxit.utils.SOAP_UTILS;

/**
 * 新闻详情
 * 
 * @author huanyu 类名称：NewsInfo_Activity 创建时间:2014-10-29 下午3:18:47
 */
public class NewsInfo_Activity extends BaseActivity {
	private ImageView img_back;
	private FocusedtrueTV tv_title;
	private WebView webView;
	private FinNewsList newsList;
	private FinNewsInfo newsInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_newsinfo);
		super.onCreate(savedInstanceState);
		this.isParentActivity = false;
		intent = getIntent();
		newsList = (FinNewsList) intent.getSerializableExtra("finnewslist");
		initView();
		setListeners();
		String[] property_va = new String[] { newsList.getId() };
//		soapService.getNewsContent(property_va);
	}

	private void initView() {
		img_back = (ImageView) findViewById(R.id.img_back);
		webView = (WebView) findViewById(R.id.webView);
		tv_title = (FocusedtrueTV) findViewById(R.id.tv_title);
		tv_title.setText(newsList.getTitle());
	}

	private void setListeners() {
		img_back.setOnClickListener(this);
	}

	public void setUI() {
		webView.loadDataWithBaseURL(null, newsInfo.getContent(), "text/html", "utf-8", null);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img_back:
			finish();
			break;
		default:
			break;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	public void onEvent(SoapRes obj) {
		super.onEvent(obj);
		if (obj.getCode().equals(SOAP_UTILS.METHOD.GETNEWSCONTENT)) {
			newsInfo = (FinNewsInfo) obj.getObj();
			if(newsInfo != null){
				setUI();
			}
		}
	}

	@Override
	public void onEventMainThread(String method) {
		if (method.equals(SOAP_UTILS.METHOD.GETNEWSCONTENT)) {
			String[] property_va = new String[] { newsList.getId() };
//			soapService.getNewsContent(property_va);
		}
	}
}
