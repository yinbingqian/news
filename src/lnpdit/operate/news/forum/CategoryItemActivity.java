package lnpdit.operate.news.forum;

import lnpdit.operate.news.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CategoryItemActivity extends Activity{
	Context context;
	TextView ht_title;
	String Title;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categoryitem);
//
		Intent intent = this.getIntent();
		Title = intent.getStringExtra("Title");
		initView();
	}
	private void initView() {
		ht_title = (TextView) findViewById(R.id.ht_title);
		ht_title.setText(Title);
	}
}
