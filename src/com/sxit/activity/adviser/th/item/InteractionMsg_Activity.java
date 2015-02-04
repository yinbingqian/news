package com.sxit.activity.adviser.th.item;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.sxit.activity.base.BaseActivity;
import com.sxit.activity.chatmsg.Chat_Activity;
import com.sxit.activity.news.News_Activity;
import com.sxit.activity.th.item.Information_Activity;
import com.sxit.activity.th.item.adapter.Information_Adapter;
import com.sxit.activity.th.item.bean.Information_ListBean;
//import com.sxit.db.DBHelper;
//import com.sxit.entity.eb.ChatMessageEB;
import com.sxit.utils.EventCache;

import lnpdit.operate.news.R;

public class InteractionMsg_Activity extends BaseActivity {
	private PullToRefreshListView listView_info;
	private ListView listView;
	private Information_Adapter information_Adapter;
	private List<Information_ListBean> list;
//	private DBHelper dbh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_interactionmsg);
		EventCache.msgNotiEvent.register(this);
		list = new ArrayList<Information_ListBean>();
//		dbh = new DBHelper(this);
		initView();
	}

	public void initView() {
		listView_info = (PullToRefreshListView) findViewById(R.id.listView_info);
		listView = listView_info.getRefreshableView();
		listView.setOnItemClickListener(oc);
//		intiDate();
	}

	private void intiDate() {
//		System.out.println("$$$  InteractionMsg_Activity initData" );
//		list = dbh.getRecentAMsgList(dbh.queryLoginUserInfo());
//		information_Adapter = new Information_Adapter(this, list);
//		listView.setAdapter(information_Adapter);
	}

	private OnItemClickListener oc = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
			// System.out.println(">>>>"+ list.get(position-1).getTitle()+">>"+position);
			Intent i = new Intent();
			switch (list.get(position - 1).getNotifType()) {
			case 0:
				i.setClass(InteractionMsg_Activity.this, Chat_Activity.class);
				startActivity(i);
				break;
			case 1:
				i.setClass(InteractionMsg_Activity.this, News_Activity.class);
				startActivity(i);
				break;
			case 2:
				Bundle bundle = new Bundle();
				bundle.putSerializable("userInfo", list.get(position - 1).getUserinfo());
				i.putExtras(bundle);
				i.setClass(InteractionMsg_Activity.this, com.sxit.activity.adviser.chatmsg.Chat_Activity.class);
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

	protected void onResume() {
		super.onResume();
		intiDate();
	};
//	
//	public void onEventMainThread(ChatMessageEB cmeb) {
//		intiDate();
//	}

}
