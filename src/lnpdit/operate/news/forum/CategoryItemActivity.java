package lnpdit.operate.news.forum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.sxit.activity.news.adapter.CategoryList_Adapter;
import com.sxit.activity.news.adapter.Category_Adapter;
import com.sxit.activity.news.adapter.News_Adapter;
import com.sxit.entity.category.FinCategory;
import com.sxit.entity.category.FinCategoryList;
import com.sxit.entity.news.FinNews;
import com.sxit.http.SoapRes;
import com.sxit.utils.SOAP_UTILS;

import lnpdit.operate.news.R;
import lnpdit.operate.news.activity.news.NewsInfo_Activity;
import lnpdit.operate.news.activity.news.News_Activity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.sxit.activity.base.BaseActivity;

public class CategoryItemActivity extends BaseActivity{
	Context context;
	TextView ht_title;
	String Title;
	String Id;
	
//	private TextView tv_title;
//	private ImageView img_back;
	private PullToRefreshListView listView_category;
	private ListView listView;
	private Category_Adapter adapter;
	private List<FinCategory> list;
	private int pageIndex = 1;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categoryitem);
		context = this;
		
		this.isParentActivity = false;
		
		Intent intent = this.getIntent();
		Title = intent.getStringExtra("Title");
		Id = intent.getStringExtra("Id");
		
		initView();
		setListeners();
		String[] property_va = new String[] { Id, "10", pageIndex + "" };
		soapService.getCategoryTitle(property_va, false);
	}
	private void initView() {
		ht_title = (TextView) findViewById(R.id.ht_title);
		ht_title.setText(Title);
		
		listView_category = (PullToRefreshListView) findViewById(R.id.listView_category);
		listView = listView_category.getRefreshableView();
	}
	private void setListeners() {
//		img_back.setOnClickListener(this);
		listView_category.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Bundle bundle = new Bundle();
//				bundle.putSerializable("finnews", list.get(position - 1));
//				intent.putExtras(bundle);
//				intent.setClass(News_Activity.this, NewsList_Activity.class);
//				startActivity(intent);
				
				Bundle bundle = new Bundle();
				bundle.putSerializable("fincategorylist", list.get(position - 1));
				intent.putExtras(bundle);
				intent.setClass(CategoryItemActivity.this, CategoryInfo_Activity.class);
				startActivity(intent);
			}
		});
		listView_category.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				new GetDataTask().execute();
			}
		});
		// end of list
		listView_category.setOnLastItemVisibleListener(new OnLastItemVisibleListener() {

			@Override
			public void onLastItemVisible() {
//				String[] property_va = new String[] { "10", ++pageIndex + "", getLoginUser().getUserid() };
//				soapService.getCategoryTitle(property_va, true);
			}
		});
	}

	/**
	 * 列表刷新
	 * 
	 * @author why
	 * 
	 */
	private class GetDataTask extends AsyncTask<Void, Void, String> {

		@Override
		protected String doInBackground(Void... params) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			}
			return "";
		}

		@Override
		protected void onPostExecute(String result) {
			pageIndex = 1;
			String[] property_va = new String[] { Id, "10", pageIndex + "" };
			soapService.getCategoryTitle(property_va, false);
			super.onPostExecute(result);
		}
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
			if (obj.isPage()) {
				for (FinCategory bean : (List<FinCategory>) obj.getObj()) {
					list.add(bean);
				}
				adapter.notifyDataSetChanged();
			} else {
				list = (List<FinCategory>) obj.getObj();
				if (list != null) {
					if (list.size() != 0) {
						adapter = new Category_Adapter(this, list);
						listView.setAdapter(adapter);
					}
				}
			}
			listView_category.onRefreshComplete();
		}
	}

	@Override
	public void onEventMainThread(String method) {
		if (method.equals(SOAP_UTILS.METHOD.COMMUNICATION)) {
			String[] property_va = new String[] { Id, "10", pageIndex + "" };
			soapService.getCategoryTitle(property_va, false);
		}
	}

}
