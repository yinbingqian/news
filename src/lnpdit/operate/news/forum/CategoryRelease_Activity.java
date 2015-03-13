package lnpdit.operate.news.forum;

import org.json.JSONException;
import org.json.JSONObject;

import com.sxit.http.SoapPostService;
import com.sxit.utils.SOAP_UTILS;

import lnpdit.operate.news.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CategoryRelease_Activity extends Activity {
	Context context;
	private ImageView img_back;
	
	EditText catogery_title;
	EditText catogery_content;
	TextView title_num;
	TextView content_num;
	Button release_bt;
	
	String catogery_title_et;
	String catogery_content_et;
	int num = 10;
	String Id;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_releasecategory);
		context = this;
		initView();
		setListeners();
	}
	private void initView(){
		img_back = (ImageView) findViewById(R.id.img_back);
		catogery_title = (EditText) findViewById(R.id.catogery_title);
		content_num = (TextView) findViewById(R.id.content_num);
		title_num = (TextView) findViewById(R.id.title_num);
//		content_num.setText("20");
//		title_num.setText("20");
		catogery_content = (EditText) findViewById(R.id.catogery_content);
		release_bt = (Button) findViewById(R.id.release_bt);
		
		
		
		}
	private void setListeners() {
		release_bt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				categorySend();
			}
		});
       img_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	private void categorySend() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					httpPost();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.e("Release Error:", e.toString());
				}
			}
		});
		thread.start();

	}

	public String httpPost() throws Exception {
		// sp ---userid
		SharedPreferences sp = getSharedPreferences("SP", MODE_PRIVATE);
		String id = sp.getString("id", "");
		// sysid
		Intent intent = this.getIntent();
		Id = intent.getStringExtra("Id");
		// edittext.gettext----content
		String title = catogery_title.getText().toString();
		String content = catogery_content.getText().toString();
		
		String[] nm = new String[4];
		String[] va = new String[4];

		nm[0] = "userid";
		nm[1] = "sysid";
		nm[2] = "title";
		nm[3] = "content";

		va[0] = id;
		va[1] = Id;
		va[2] = title;
		va[3] = content;
		Object res_obj = SoapPostService.data(SOAP_UTILS.METHOD.ADDCOMMUNICATION,nm, va);

		Message msg = new Message();
		msg.arg1 = 0;
		msg.obj = res_obj.toString();
		threadMessageHandler.sendMessage(msg);

		return res_obj.toString();
	}

	Handler threadMessageHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.arg1 == 0) {

				String res_is = (String) msg.obj;
				try {
					JSONObject json_all = new JSONObject(res_is);
					String check = json_all.getString("AddCommunicationResult");
					if(check.equals("true") ){
						finish();
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				Toast.makeText(context, res_is, Toast.LENGTH_SHORT).show();
			}
		}
	};

}
