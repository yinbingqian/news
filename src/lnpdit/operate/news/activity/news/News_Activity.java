package lnpdit.operate.news.activity.news;

import java.util.List;

import lnpdit.operate.news.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.sxit.activity.base.BaseActivity;
import com.sxit.activity.news.adapter.News_Adapter;
import com.sxit.entity.news.FinNews;
import com.sxit.http.SoapRes;
import com.sxit.utils.SOAP_UTILS;

//import lnpdit.lntv.tradingtime.R;

/**
 * 财经要文
 * 
 * @author huanyu 类名称：News_Activity 创建时间:2014-10-28 下午9:32:44
 */
public class News_Activity extends BaseActivity {
	private ImageView img_back;
	private PullToRefreshListView listView_news;
	private ListView listView;
	private News_Adapter adapter;
	private List<FinNews> list;
	private int pageIndex = 1;
//	private DBHelper dbh;
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_news);
		super.onCreate(savedInstanceState);
		this.isParentActivity = false;
		initView();
		setListeners();
		String[] property_va = new String[] { "5", "10", pageIndex + "" };
		soapService.getColumns(property_va, false);
//		dbh = new DBHelper(this);
//		dbh.setMsgReaded(dbh.queryLoginUserInfo().getUserid(), "-1");
	}

	private void initView() {
		listView_news = (PullToRefreshListView) findViewById(R.id.listView_news);
		listView = listView_news.getRefreshableView();
		img_back = (ImageView) findViewById(R.id.img_back);
	}

	private void setListeners() {
		img_back.setOnClickListener(this);
		listView_news.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Bundle bundle = new Bundle();
//				bundle.putSerializable("finnews", list.get(position - 1));
//				intent.putExtras(bundle);
//				intent.setClass(News_Activity.this, NewsList_Activity.class);
//				startActivity(intent);
				
				Bundle bundle = new Bundle();
				bundle.putSerializable("finnewslist", list.get(position - 1));
				intent.putExtras(bundle);
				intent.setClass(News_Activity.this, NewsInfo_Activity.class);
				startActivity(intent);
			}
		});
		listView_news.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				new GetDataTask().execute();
			}
		});
		// end of list
		listView_news.setOnLastItemVisibleListener(new OnLastItemVisibleListener() {

			@Override
			public void onLastItemVisible() {
//				String[] property_va = new String[] { "10", ++pageIndex + "", getLoginUser().getUserid() };
//				soapService.getColumns(property_va, true);
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
			String[] property_va = new String[] { "5", "10", "" + pageIndex };
			soapService.getColumns(property_va, false);
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
		if (obj.getCode().equals(SOAP_UTILS.METHOD.GETCOLUMNSTONEWS)) {
			if (obj.isPage()) {
				for (FinNews bean : (List<FinNews>) obj.getObj()) {
					list.add(bean);
				}
				adapter.notifyDataSetChanged();
			} else {
				list = (List<FinNews>) obj.getObj();
				if (list != null) {
					if (list.size() != 0) {
						adapter = new News_Adapter(this, list);
						listView.setAdapter(adapter);
					}
				}
			}
			listView_news.onRefreshComplete();
		}
	}

	@Override
	public void onEventMainThread(String method) {
		if (method.equals(SOAP_UTILS.METHOD.GETCOLUMNSTONEWS)) {
			String[] property_va = new String[] { "5", "10", pageIndex + "" };
			soapService.getColumns(property_va, false);
		}
	}

}
