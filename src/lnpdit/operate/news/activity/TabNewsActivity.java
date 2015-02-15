package lnpdit.operate.news.activity;

import lnpdit.operate.news.R;
import lnpdit.operate.news.activity.news.News_Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TabNewsActivity extends Activity{
	Button btn;
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_news_temp);
		super.onCreate(savedInstanceState);
//		initView();
//		setListeners();

		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(TabNewsActivity.this, News_Activity.class);
				startActivity(intent);
			}
		});
	}

}
