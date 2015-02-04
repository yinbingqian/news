package lnpdit.operate.news.activity;

import lnpdit.operate.news.R;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class TabBusinessActivity extends TabActivity{
	Context context;
//	TextView textview;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_business);
		
		context = this;
		
//		textview = (TextView) this.findViewById(R.id.textview);
//		textview.setText("资讯");
		}
	
	 // 点击弹出左侧菜单的显示方式  

}  
