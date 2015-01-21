package lnpdit.operate.news.activity;

import lnpdit.operate.news.R;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends TabActivity {

	Context context;
	RadioGroup radioGroup;
	TabHost tabHost;
	TabHost.TabSpec tabSpec;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		context = this;
		tabHost = getTabHost();
		tabHost.addTab(tabHost.newTabSpec("information").setIndicator("Information")
				.setContent(new Intent(this, TabInformationActivity.class)));
//		tabHost.addTab(tabHost.newTabSpec("topic").setIndicator("Topic")
//				.setContent(new Intent(this, TabQuestionActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("communication").setIndicator("Communication")
				.setContent(new Intent(this, TabCommunicationActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("business").setIndicator("Business")
				.setContent(new Intent(this, TabBusinessActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("personal").setIndicator("Personal")
				.setContent(new Intent(this, TabPersonalActivity.class)));
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
		radioGroup.setOnCheckedChangeListener(checkedChangeListener);
	}
	
	private OnCheckedChangeListener checkedChangeListener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			DisplayMetrics metrics = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(metrics);
			int x = metrics.widthPixels / 4;
			switch (checkedId) {
			case R.id.radio_information:
				tabHost.setCurrentTabByTag("information");
//				MoveBg.moveFrontBg(img, startLeft, 0, 0, 0);
//				startLeft = 0;
				break;
			case R.id.radio_communication:
				tabHost.setCurrentTabByTag("communication");
//				MoveBg.moveFrontBg(img, startLeft, img.getWidth(), 0, 0);
//				startLeft = img.getWidth();
//				MoveBg.moveFrontBg(img, startLeft, x, 0, 0);
//				startLeft = x;
				break;
			case R.id.radio_business:
				tabHost.setCurrentTabByTag("business");
//				MoveBg.moveFrontBg(img, startLeft, img.getWidth() * 2, 0, 0);
//				startLeft = img.getWidth() * 2;
//				MoveBg.moveFrontBg(img, startLeft, x * 2, 0, 0);.
//				startLeft = x * 2;
				break;
			case R.id.radio_personal:
				tabHost.setCurrentTabByTag("personal");
//				MoveBg.moveFrontBg(img, startLeft, img.getWidth() * 3, 0, 0);
//				startLeft = img.getWidth() * 3;
//				MoveBg.moveFrontBg(img, startLeft, x * 3, 0, 0);
//				startLeft = x * 3;
				break;

			default:
				break;
			}
		}
	};
	
}
