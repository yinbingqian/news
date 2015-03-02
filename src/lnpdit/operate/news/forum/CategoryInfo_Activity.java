package lnpdit.operate.news.forum;

import lnpdit.operate.news.R;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.sxit.activity.base.BaseActivity;
import com.sxit.customview.FocusedtrueTV;
import com.sxit.entity.category.FinCategory;
import com.sxit.entity.category.FinCategoryInfo;
import com.sxit.entity.news.FinNews;
import com.sxit.entity.news.FinNewsInfo;
import com.sxit.http.SoapRes;
import com.sxit.utils.SOAP_UTILS;

public class CategoryInfo_Activity extends BaseActivity {
	private ImageView img_back;
	private FocusedtrueTV tv_title;
	private WebView webView;
	private FinCategory categoryList;
	private FinCategoryInfo categoryInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_categoryinfo);
		super.onCreate(savedInstanceState);
		this.isParentActivity = false;
		intent = getIntent();
		categoryList = (FinCategory) intent.getSerializableExtra("finnewslist");
		initView();
		setListeners();
		String[] property_va = new String[] { categoryList.getId() };
		soapService.getNewsContent(property_va);
	}

	private void initView() {
		img_back = (ImageView) findViewById(R.id.img_back);
		webView = (WebView) findViewById(R.id.webView);
		tv_title = (FocusedtrueTV) findViewById(R.id.tv_title);
		tv_title.setText(categoryList.getTitle());
	}

	private void setListeners() {
		img_back.setOnClickListener(this);
	}

	public void setUI() {
		webView.loadDataWithBaseURL(null, categoryInfo.getContent(), "text/html", "utf-8", null);
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
		if (obj.getCode().equals(SOAP_UTILS.METHOD.COMMUNICATION)) {
			categoryInfo = (FinCategoryInfo) obj.getObj();
			if(categoryInfo != null){
				setUI();
			}
		}
	}

	@Override
	public void onEventMainThread(String method) {
		if (method.equals(SOAP_UTILS.METHOD.COMMUNICATION)) {
			String[] property_va = new String[] { categoryList.getId() };
			soapService.getNewsContent(property_va);
		}
	}
}
