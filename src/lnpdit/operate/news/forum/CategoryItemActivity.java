package lnpdit.operate.news.forum;

import lnpdit.operate.news.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CategoryItemActivity extends Activity{
	Context context;
	TextView ht_title;
	String Title;
	String Id;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categoryitem);
		context = this;
//
		Intent intent = this.getIntent();
		Title = intent.getStringExtra("Title");
		Id = intent.getStringExtra("Id");

		initView();
	}
	private void initView() {
		ht_title = (TextView) findViewById(R.id.ht_title);
		ht_title.setText(Title);
		Toast.makeText(context, Id, Toast.LENGTH_LONG).show();
	}
}
