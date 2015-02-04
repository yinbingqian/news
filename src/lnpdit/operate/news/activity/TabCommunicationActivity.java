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

public class TabCommunicationActivity extends TabActivity{
	Context context;
//	TextView textview;
	
	private PopupWindow popupWindow;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_communication);
		
		context = this;
		
		RelativeLayout pop = (RelativeLayout) this.findViewById(R.id.popBtn);
		pop.setClickable(true);
		pop.setOnClickListener(popClick);
		
//		textview = (TextView) this.findViewById(R.id.textview);
//		textview.setText("资讯");
		}
	
	 // 点击弹出左侧菜单的显示方式  
    OnClickListener popClick = new OnClickListener() {  
        @Override  
        public void onClick(View v) {  
            // TODO Auto-generated method stub  
            getPopupWindow();  
            // 这里是位置显示方式,在屏幕的左侧  
            popupWindow.showAtLocation(v, Gravity.LEFT, 0, 0);  
        }  
    };  
  
    /** 
     * 创建PopupWindow 
     */  
    protected void initPopuptWindow() {  
        // TODO Auto-generated method stub  
        // 获取自定义布局文件activity_popupwindow_left.xml的视图  
        View popupWindow_view = getLayoutInflater().inflate(R.layout.activity_popupwindow_left, null,  
                false);  
        // 创建PopupWindow实例,200,LayoutParams.MATCH_PARENT分别是宽度和高度  
        popupWindow = new PopupWindow(popupWindow_view, 200, LayoutParams.MATCH_PARENT, true);  
        // 设置动画效果  
        popupWindow.setAnimationStyle(R.style.AnimationFade);  
        
        
        // 点击其他地方消失  
        popupWindow_view.setOnTouchListener(new OnTouchListener() {  
            public boolean onTouch(View v, MotionEvent event) {  
                // TODO Auto-generated method stub  
                if (popupWindow != null && popupWindow.isShowing()) {  
                    popupWindow.dismiss();  
                    popupWindow = null;  
                }  
                return false;  
            }  
        });  
        
    }  
    
	/*** 
     * 获取PopupWindow实例 
     */  
    private void getPopupWindow() {  
        if (null != popupWindow) {  
            popupWindow.dismiss();  
            return;  
        } else {  
            initPopuptWindow();  
        }  
    } 
    
}  
