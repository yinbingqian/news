package com.sxit.activity.adviser.th.item;

import java.util.List;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
//import com.sxit.activity.adviser.answer.AAnswerQusestion_Activity;
import com.sxit.activity.adviser.th.item.adapter.Question_Adapter;
import com.sxit.activity.adviser.th.item.bean.Question_ListBean;
//import com.sxit.activity.askingquest.AnswerQuestion_Activity;
import com.sxit.activity.base.BaseActivity;
import com.sxit.activity.chatmsg.Chat_Activity;
import com.sxit.activity.th.item.Information_Activity;
import com.sxit.http.SoapRes;
import com.sxit.utils.SOAP_UTILS;

import lnpdit.operate.news.R;

/**
 *	问题列表
 * 
 * @author huanyu 类名称：QuestionList_Activity 创建时间:2014-11-12 下午2:45:22
 */
public class QuestionList_Activity extends BaseActivity {
	/** ListView **/
	private PullToRefreshListView listView_askquestion;
	private ListView listView;
	private Question_Adapter adapter;
	private List<Question_ListBean> list;
	private int pageIndex = 1;
	private int onClickPosition;// 点击位置

	@Override
	protected void onCreate(Bundle savedInstanceState) {
//		setContentView(R.layout.activity_questionlist_layout);
		super.onCreate(savedInstanceState);
		initView();
//		setListeners();
//		String[] property_va = new String[] { "10", pageIndex + "", getLoginUser().getUserid() };
//		soapService.getCommunicationAllUser(property_va, false);
	}

	private void initView() {
//		listView_askquestion = (PullToRefreshListView) findViewById(R.id.listView_askquestion);
//		listView = listView_askquestion.getRefreshableView();
	}
/**
 * 

	private void setListeners() {
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				onClickPosition = position - 1;
				if (list.get(position - 1).getStatus().equals("0")) {
					Bundle bundle = new Bundle();
					bundle.putSerializable("question", list.get(position - 1));
					intent.putExtras(bundle);
					intent.setClass(QuestionList_Activity.this, AAnswerQusestion_Activity.class);
					startActivity(intent);
				} else {
					Utils.showTextToast(QuestionList_Activity.this, getString(R.string.questionover));
				}
			}
		});
		listView_askquestion.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				new GetDataTask().execute();
			}
		});
		// end of list
		listView_askquestion.setOnLastItemVisibleListener(new OnLastItemVisibleListener() {

			@Override
			public void onLastItemVisible() {
				String[] property_va = new String[] { "10", ++pageIndex + "", getLoginUser().getUserid() };
				soapService.getCommunicationAllUser(property_va, true);
			}
		});
	}

	/**
	 * 列表刷新
	 * 
	 * @author why
	 * 
	 */
	
	
	/**
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
			String[] property_va = new String[] { "10", pageIndex + "", getLoginUser().getUserid() };
			soapService.getCommunicationAllUser(property_va, false);
			super.onPostExecute(result);
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

	public void onEvent(String... str) {
		for (String name : str) {
			if (name.equals(AAnswerQusestion_Activity.class.getName())) {// 解答返回
				list.get(onClickPosition).setStatus(str[1]);
				adapter.notifyDataSetChanged();
			}
		}
	}

	public void onEvent(SoapRes obj) {
		super.onEvent(obj);
		if (obj.getCode().equals(SOAP_UTILS.METHOD.GETCOMMUNICATIONALLUSER)) {
			if (obj.isPage()) {// 分页
				if (obj.getObj() != null) {
					for (Question_ListBean bean : (List<Question_ListBean>) obj.getObj()) {
						list.add(bean);
					}
					adapter.notifyDataSetChanged();
				} else {
					Utils.showTextToast(this, getString(R.string.error));
				}
			} else {// 刷新
				if (obj.getObj() != null) {
					list = (List<Question_ListBean>) obj.getObj();
					if (list.size() != 0) {
						adapter = new Question_Adapter(this, list);
						listView.setAdapter(adapter);
					}
				} else {
					Utils.showTextToast(this, getString(R.string.error));
				}
			}
			listView_askquestion.onRefreshComplete();
		}
	}

	@Override
	public void onEventMainThread(String method) {
		if (method.equals(SOAP_UTILS.METHOD.GETCOMMUNICATIONALLUSER)) {
			String[] property_va = new String[] { "10", pageIndex + "", getLoginUser().getUserid() };
			soapService.getCommunicationAllUser(property_va, false);
		}
	}
	
	*/
}
