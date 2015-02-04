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
//		textview.setText("��Ѷ");
		}
	
	 // ����������˵�����ʾ��ʽ  
    OnClickListener popClick = new OnClickListener() {  
        @Override  
        public void onClick(View v) {  
            // TODO Auto-generated method stub  
            getPopupWindow();  
            // ������λ����ʾ��ʽ,����Ļ�����  
            popupWindow.showAtLocation(v, Gravity.LEFT, 0, 0);  
        }  
    };  
  
    /** 
     * ����PopupWindow 
     */  
    protected void initPopuptWindow() {  
        // TODO Auto-generated method stub  
        // ��ȡ�Զ��岼���ļ�activity_popupwindow_left.xml����ͼ  
        View popupWindow_view = getLayoutInflater().inflate(R.layout.activity_popupwindow_left, null,  
                false);  
        // ����PopupWindowʵ��,200,LayoutParams.MATCH_PARENT�ֱ��ǿ�Ⱥ͸߶�  
        popupWindow = new PopupWindow(popupWindow_view, 200, LayoutParams.MATCH_PARENT, true);  
        // ���ö���Ч��  
        popupWindow.setAnimationStyle(R.style.AnimationFade);  
        
        
        // ��������ط���ʧ  
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
     * ��ȡPopupWindowʵ�� 
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
