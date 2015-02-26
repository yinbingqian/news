package lnpdit.operate.news.forum;

import lnpdit.operate.news.R;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CategoryActivity extends Activity {
	Context context;
	RelativeLayout personal_layout1;
	RelativeLayout personal_layout2;
	RelativeLayout personal_layout3;
	RelativeLayout personal_layout4;
	RelativeLayout personal_layout5;
	RelativeLayout recommended_layout1;
	RelativeLayout recommended_layout2;
	RelativeLayout recommended_layout3;
	RelativeLayout recommended_layout4;
	RelativeLayout recommended_layout5;
	TextView txt1;
	TextView txt2;
	TextView txt3;
	TextView txt4;
	TextView txt5;
	TextView txt11;
	TextView txt12;
	TextView txt13;
	TextView txt14;
	TextView txt15;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		context = this;
		initView();
		getrecommended();
	}
	
	private void getrecommended(){
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// Log.d("news", "clicked");
				// HttpClient client = new DefaultHttpClient();
				// // 鍒涘缓涓�釜GET璇锋眰
				// HttpGet httpGet = new HttpGet(
				// "http://200.20.30.142:8027/lnpdit/loginbysim/18940052640");
				// // HttpGet httpGet=new
				// // HttpGet("http://200.20.30.201:8027/lnpdit");
				// // 鍚戞湇鍔″櫒鍙戦�璇锋眰骞惰幏鍙栨湇鍔″櫒杩斿洖鐨勭粨鏋�
				// HttpResponse response;
				// try {
				// response = client.execute(httpGet);
				// HttpEntity entity = response.getEntity();
				// // 杩斿洖鐨勭粨鏋滃彲鑳芥斁鍒癐nputStream锛宧ttp Header涓瓑銆�
				//
				// // 璁块棶REST鏈嶅姟绾跨▼锛屽皢缁撴灉浼犻�缁檋andler
				// Message msg = new Message();
				// msg.arg1 = 0;
				// msg.obj = EntityUtils.toString(entity);
				// threadMessageHandler.sendMessage(msg);
				// Log.d("news", "sended");
				// } catch (ClientProtocolException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// } catch (IOException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }
				try {
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.e("Login Error:", e.toString());
				}
			}
		});
		thread.start();
	}

	private void initView() {
		personal_layout1 = (RelativeLayout) findViewById(R.id.personal_layout1);
		personal_layout2 = (RelativeLayout) findViewById(R.id.personal_layout2);
		personal_layout3 = (RelativeLayout) findViewById(R.id.personal_layout3);
		personal_layout4 = (RelativeLayout) findViewById(R.id.personal_layout4);
		personal_layout5 = (RelativeLayout) findViewById(R.id.personal_layout5);
		recommended_layout1 = (RelativeLayout) findViewById(R.id.recommended_layout1);
		recommended_layout2 = (RelativeLayout) findViewById(R.id.recommended_layout2);
		recommended_layout3 = (RelativeLayout) findViewById(R.id.recommended_layout3);
		recommended_layout4 = (RelativeLayout) findViewById(R.id.recommended_layout4);
		recommended_layout5 = (RelativeLayout) findViewById(R.id.recommended_layout5);

		txt1 = (TextView) findViewById(R.id.txt1);
		txt2 = (TextView) findViewById(R.id.txt2);
		txt3 = (TextView) findViewById(R.id.txt3);
		txt4 = (TextView) findViewById(R.id.txt4);
		txt5 = (TextView) findViewById(R.id.txt5);
		txt11 = (TextView) findViewById(R.id.txt11);
		txt12 = (TextView) findViewById(R.id.txt12);
		txt13 = (TextView) findViewById(R.id.txt13);
		txt14 = (TextView) findViewById(R.id.txt14);
		txt15 = (TextView) findViewById(R.id.txt15);

		personal_layout1.setClickable(true);
		personal_layout2.setClickable(true);
		personal_layout3.setClickable(true);
		personal_layout4.setClickable(true);
		personal_layout5.setClickable(true);
		personal_layout1.setVisibility(8);
		personal_layout2.setVisibility(8);
		personal_layout3.setVisibility(8);
		personal_layout4.setVisibility(8);
		personal_layout5.setVisibility(8);
		recommended_layout1.setClickable(true);
		recommended_layout2.setClickable(true);
		recommended_layout3.setClickable(true);
		recommended_layout4.setClickable(true);
		recommended_layout5.setClickable(true);

		recommended_layout1.setOnClickListener(listener);
		recommended_layout2.setOnClickListener(listener);
		recommended_layout3.setOnClickListener(listener);
		recommended_layout4.setOnClickListener(listener);
		recommended_layout5.setOnClickListener(listener);
		personal_layout1.setOnClickListener(listener);
		personal_layout2.setOnClickListener(listener);
		personal_layout3.setOnClickListener(listener);
		personal_layout4.setOnClickListener(listener);
		personal_layout5.setOnClickListener(listener);

		// sp
		SharedPreferences sharedPreferences = getSharedPreferences("category",
				Context.MODE_PRIVATE); // 私有数据
		String mycategory = sharedPreferences.getString("mycategory", "");
		if (!mycategory.equals("")) {
			String[] category_arrayshow = mycategory.split(",");
			int i = category_arrayshow.length;
			if (i > 0) {
				personal_layout1.setVisibility(1);
				txt1.setText(category_arrayshow[0]);
				if (i > 1) {
					personal_layout2.setVisibility(1);
					txt2.setText(category_arrayshow[1]);
					if (i > 2) {
						personal_layout3.setVisibility(1);
						txt3.setText(category_arrayshow[2]);
						if (i > 3) {
							personal_layout4.setVisibility(1);
							txt4.setText(category_arrayshow[3]);
							if (i > 4) {
								personal_layout5.setVisibility(1);
								txt5.setText(category_arrayshow[4]);
							}
						}
					}
				}
			}

//			Toast.makeText(context, mycategory, Toast.LENGTH_SHORT).show();
		}
	}

	private void recommendedClick(String name) {
		SharedPreferences sp = getSharedPreferences("category",
				Context.MODE_PRIVATE); // 私有数据
		String mycategory = sp.getString("mycategory", "");

		String[] category_array = mycategory.split(",");
		String category_new = name;
		for (int i = 0; i < category_array.length; i++) {
			if (!category_array[i].equals(name)) {
				category_new = category_new + "," + category_array[i];
			}
		}
		Editor editor = sp.edit();// 获取编辑器
		editor.putString("mycategory", category_new);
		editor.commit();
	}

	private android.view.View.OnClickListener listener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.personal_layout1:
				Toast.makeText(context, "personal_layout1", Toast.LENGTH_LONG)
						.show();
				break;
			case R.id.personal_layout2:
				Toast.makeText(context, "personal_layout2", Toast.LENGTH_LONG)
						.show();
				break;
			case R.id.personal_layout3:
				Toast.makeText(context, "personal_layout3", Toast.LENGTH_LONG)
						.show();
				break;
			case R.id.personal_layout4:
				Toast.makeText(context, "personal_layout4", Toast.LENGTH_LONG)
						.show();
				break;
			case R.id.personal_layout5:
				Toast.makeText(context, "personal_layout5", Toast.LENGTH_LONG)
						.show();
				break;
			case R.id.recommended_layout1:
				recommendedClick(txt11.getText().toString());
				break;
			case R.id.recommended_layout2:
				recommendedClick(txt12.getText().toString());
				break;
			case R.id.recommended_layout3:
				recommendedClick(txt13.getText().toString());
				break;
			case R.id.recommended_layout4:
				recommendedClick(txt14.getText().toString());
				break;
			case R.id.recommended_layout5:
				recommendedClick(txt15.getText().toString());
				break;
			default:
				break;

			}
		}
	};

}
