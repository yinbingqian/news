package lnpdit.operate.news.activity;

import lnpdit.operate.news.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TabInformationActivity extends Activity{
	Context context;
	TextView textview;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_information);
		
		context = this;
		textview = (TextView) this.findViewById(R.id.textview);
		textview.setText("��Ѷ");
		}
}