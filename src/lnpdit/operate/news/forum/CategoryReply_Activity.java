package lnpdit.operate.news.forum;

import java.util.List;

import lnpdit.operate.news.R;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.sxit.activity.base.BaseActivity;
import com.sxit.activity.news.adapter.CategoryInfo_Adapter;
import com.sxit.entity.category.FinCategory;
import com.sxit.entity.category.FinCategoryInfo;
import com.sxit.http.SoapPostService;
import com.sxit.http.SoapRes;
import com.sxit.utils.SOAP_UTILS;

public class CategoryReply_Activity extends BaseActivity {
	private ImageView img_back;
	// private TextView tv_title;
	// private WebView webView;
	private FinCategory categoryList;
	private FinCategoryInfo categoryInfo;
	private PullToRefreshListView listView_categoryInfo;
	private ListView listView;
	private List<FinCategoryInfo> list;
	private CategoryInfo_Adapter adapter;
	Context context;
	String Id;
	String title_title_string;
	String title_name_string;
	String title_crtime_string;
	String title_content_string;

	Button send_bt;
	EditText content_edit;

	private int pageIndex = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_categoryreply);
		super.onCreate(savedInstanceState);
		this.isParentActivity = false;
		context = this;
		intent = getIntent();
		categoryList = (FinCategory) intent.getSerializableExtra("finnewslist");
		initView();
		setListeners();

		// Toast.makeText(context, title_title_string,
		// Toast.LENGTH_LONG).show();
		String[] property_va = new String[] { Id, "10", pageIndex + "" };
		soapService.getCategoryContent(property_va);
	}

	private void initView() {
		img_back = (ImageView) findViewById(R.id.img_back);
		listView_categoryInfo = (PullToRefreshListView) findViewById(R.id.listView_category);
		listView = listView_categoryInfo.getRefreshableView();

		// bt edittext
		send_bt = (Button) findViewById(R.id.send_bt);
		content_edit = (EditText) findViewById(R.id.content_edit);
		View view = LayoutInflater.from(getApplicationContext()).inflate(
				R.layout.activity_categoryreplytitle, null);
		TextView title_title_tv = (TextView) view.findViewById(R.id.tv_title);
		TextView title_name_tv = (TextView) view.findViewById(R.id.tv_name);
		TextView title_crtime_tv = (TextView) view.findViewById(R.id.tv_crtime);
		TextView title_content_tv = (TextView) view.findViewById(R.id.category);

		Intent intent = this.getIntent();
		Id = intent.getStringExtra("Id");
		title_title_string = intent.getStringExtra("title_title_tv");
		title_name_string = intent.getStringExtra("title_name_tv");
		title_crtime_string = intent.getStringExtra("title_crtime_tv");
		title_content_string = intent.getStringExtra("title_content_tv");
		// Toast.makeText(context, Id, Toast.LENGTH_LONG).show();

		title_title_tv.setText(title_title_string);
		title_name_tv.setText(title_name_string);
		title_crtime_tv.setText(title_crtime_string);
		title_content_tv.setText(title_content_string);
		listView.addHeaderView(view);

	}

	private void setListeners() {
		img_back.setOnClickListener(this);

		send_bt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				replySend();
			}
		});

		listView_categoryInfo.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

			}
		});
		listView_categoryInfo
				.setOnRefreshListener(new OnRefreshListener<ListView>() {

					@Override
					public void onRefresh(
							PullToRefreshBase<ListView> refreshView) {
						new GetDataTask().execute();
					}
				});
		// end of list
		listView_categoryInfo
				.setOnLastItemVisibleListener(new OnLastItemVisibleListener() {

					@Override
					public void onLastItemVisible() {
						// String[] property_va = new String[] { "10",
						// ++pageIndex + "", getLoginUser().getUserid() };
						// soapService.getCategoryTitle(property_va, true);

						String[] property_va = new String[] { Id, "10",
								pageIndex + "" };
						soapService.getCategoryContent(property_va);
					}
				});
	}

	private void replySend() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					httpPost();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.e("Reply Error:", e.toString());
				}
			}
		});
		thread.start();

	}

	public String httpPost() throws Exception {
		// sp ---userid
		SharedPreferences sp = getSharedPreferences("SP", MODE_PRIVATE);
		String id = sp.getString("id", "");
		// replyid
		// edittext.gettext----content
		String content = content_edit.getText().toString();
//		Toast.makeText(this,"读取数据如下：" + "\n" + "id：" + id + "\n" + "replyid：" + Id + "\n"
//						+ "content_edit：" + content, Toast.LENGTH_LONG).show();
		String[] nm = new String[3];
		String[] va = new String[3];

		nm[0] = "userid";
		nm[1] = "replyid";
		nm[2] = "content";

		va[0] = id;
		va[1] = Id;
		va[2] = content;
		Object res_obj = SoapPostService.data(SOAP_UTILS.METHOD.ADDCOMMUNREPLY,nm, va);

		Message msg = new Message();
		msg.arg1 = 0;
		msg.obj = res_obj.toString();
		threadMessageHandler.sendMessage(msg);

		return res_obj.toString();
	}

	Handler threadMessageHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.arg1 == 0) {

				Log.d("news", "recieved");
				String res_is = (String) msg.obj;
				Toast.makeText(context, res_is, Toast.LENGTH_SHORT).show();
				String[] property_va = new String[] { Id, "10", pageIndex + "" };
				soapService.getCategoryContent(property_va);
			}
		}
	};

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
			soapService.getCategoryContent(property_va);
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
		if (obj.getCode().equals(SOAP_UTILS.METHOD.COMMUNREPLY)) {
			if (obj.isPage()) {
				for (FinCategoryInfo bean : (List<FinCategoryInfo>) obj
						.getObj()) {
					list.add(bean);
				}
				adapter.notifyDataSetChanged();
			} else {
				list = (List<FinCategoryInfo>) obj.getObj();
				if (list != null) {
//					if (list.size() != 0) {
						adapter = new CategoryInfo_Adapter(this, list);
						listView.setAdapter(adapter);
//					}
				}
			}
			listView_categoryInfo.onRefreshComplete();
		}
	}

	@Override
	public void onEventMainThread(String method) {
		if (method.equals(SOAP_UTILS.METHOD.COMMUNREPLY)) {
			String[] property_va = new String[] { Id, "10", pageIndex + "" };
			soapService.getCategoryContent(property_va);
		}
	}

}
