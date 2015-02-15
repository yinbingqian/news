package com.sxit.activity.th.item;

import java.util.ArrayList;
import java.util.List;

import lnpdit.operate.news.R;
import lnpdit.operate.news.activity.news.News_Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.sxit.activity.base.BaseActivity;
import com.sxit.activity.chatmsg.Chat_Activity;
import com.sxit.activity.th.item.adapter.Information_Adapter;
import com.sxit.activity.th.item.bean.Information_ListBean;
import com.sxit.utils.EventCache;
//import com.sxit.activity.analystteaminfo.AnalystTeamInfo_Activity;
//import com.sxit.db.DBHelper;
//import com.sxit.entity.eb.ChatMessageEB;

/**
 * 信息 Acy
 * 
 * @author huanyu 类名称：Information_Activity 创建时间:2014-10-26 下午8:15:32
 */
public class Information_Activity extends BaseActivity {
	private TextView tv_title;// title
	/** listView **/
	private PullToRefreshListView listView_info;
	private ListView listView;
	private Information_Adapter information_Adapter;
	private List<Information_ListBean> list;
//	private DBHelper dbh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information);
		EventCache.msgNotiEvent.register(this);
		list = new ArrayList<Information_ListBean>();
//		dbh = new DBHelper(this);
		initView();
		setListener();
	}

	public void initView() {
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setText(getString(R.string.app_name));
		listView_info = (PullToRefreshListView) findViewById(R.id.listView_info);
		listView = listView_info.getRefreshableView();
		listView.setOnItemClickListener(oc);
		// test();
		// intiDate();
	}

	private void intiDate() {
//		list = dbh.getRecentMsgListSuper(getLoginUser());
		information_Adapter = new Information_Adapter(this, list);
		listView.setAdapter(information_Adapter);
	}

	private OnItemClickListener oc = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
			// System.out.println(">>>>"+ list.get(position-1).getTitle()+">>"+position);
			Bundle bundle = new Bundle();
			Intent i = new Intent();
			switch (list.get(position - 1).getNotifType()) {
			case 0:
				bundle = new Bundle();
				bundle.putSerializable("analystInfo", list.get(position - 1).getAdviser());
				i.putExtras(bundle);
				i.setClass(Information_Activity.this, Chat_Activity.class);
				startActivity(i);
				break;
			case 1:
				i.setClass(Information_Activity.this, News_Activity.class);
				startActivity(i);
				break;
			case 2:
				bundle = new Bundle();
				bundle.putSerializable("analystInfo", list.get(position - 1).getAdviser());
				i.putExtras(bundle);
				i.setClass(Information_Activity.this, Chat_Activity.class);
				startActivity(i);
				break;

			default:
				break;
			}
			// if (list.get(position - 1).getNotifType() == 1) {
			// intent.setClass(Information_Activity.this, News_Activity.class);
			// startActivity(intent);
			// } else {
			// intent.setClass(Information_Activity.this, Chat_Activity.class);
			// startActivity(intent);
			// }
		}
	};

	private void setListener() {
	}

	@Override
	protected void onResume() {
		intiDate();
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

//	public void onEventMainThread(ChatMessageEB cmeb) {
//		intiDate();
//	}
}
