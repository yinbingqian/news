package lnpdit.operate.news.forum;

import lnpdit.operate.news.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CategoryRelease_Activity extends Activity {
	Context context;
	private ImageView img_back;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_releasecategory);
		context = this;
		initView();
	}
	private void initView(){
		img_back = (ImageView) findViewById(R.id.img_back);
		img_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		}
	
}
