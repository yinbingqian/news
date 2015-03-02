package lnpdit.operate.news.forum;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sxit.utils.SOAP_UTILS;

import lnpdit.operate.news.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
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

	private void getrecommended() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// Log.d("news", "clicked");
				HttpClient client = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(SOAP_UTILS.IP + "/"
						+ SOAP_UTILS.METHOD.COMMUNICATIONLIST + "/" + 0);
				HttpResponse response;
				try {
					response = client.execute(httpGet);
					HttpEntity entity = response.getEntity();
					Message msg = new Message();
					msg.arg1 = 0;
					msg.obj = EntityUtils.toString(entity);
					threadMessageHandler.sendMessage(msg);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

		recommended_layout1.setVisibility(8);
		recommended_layout2.setVisibility(8);
		recommended_layout3.setVisibility(8);
		recommended_layout4.setVisibility(8);
		recommended_layout5.setVisibility(8);

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

		topicsort();
	}

	private void recommendedClick(String name, String id) {
		SharedPreferences sp = getSharedPreferences("category",
				Context.MODE_PRIVATE); // 私有数据
		String mycategory = sp.getString("mycategory", "");
		String mycategoryid = sp.getString("mycategoryid", "");

		String[] category_array = mycategory.split(",");
		String[] categoryid_array = mycategoryid.split(",");
		String category_new = name;
		String categoryid_new = id;
		for (int i = 0; i < category_array.length; i++) {
			if (!category_array[i].equals(name)) {
				category_new = category_new + "," + category_array[i];
			}
			if (!categoryid_array[i].equals(id)) {
				categoryid_new = categoryid_new + "," + categoryid_array[i];
			}
			
		}
		Editor editor = sp.edit();// 获取编辑器
		editor.putString("mycategory", category_new);
		editor.putString("mycategoryid", categoryid_new);
		editor.commit();

		Intent intent = new Intent();
		intent.putExtra("Title", name);
		intent.putExtra("Id", id);
		intent.setClass(CategoryActivity.this, CategoryItemActivity.class);
		startActivity(intent);
	}

	private void topicsort() {
		// sp
		SharedPreferences sharedPreferences = getSharedPreferences("category",
				Context.MODE_PRIVATE); // 私有数据
		String mycategory = sharedPreferences.getString("mycategory", "");
		String mycategoryid = sharedPreferences.getString("mycategoryid", "");
		if (!mycategory.equals("")) {
			String[] category_arrayshow = mycategory.split(",");
			String[] categoryid_arrayshow = mycategoryid.split(",");
			int i = category_arrayshow.length;
			if (i > 0) {
				personal_layout1.setVisibility(1);
				txt1.setText(category_arrayshow[0]);
				txt1.setTag(categoryid_arrayshow[0]);
				if (i > 1) {
					personal_layout2.setVisibility(1);
					txt2.setText(category_arrayshow[1]);
					txt2.setTag(categoryid_arrayshow[1]);
					if (i > 2) {
						personal_layout3.setVisibility(1);
						txt3.setText(category_arrayshow[2]);
						txt3.setTag(categoryid_arrayshow[2]);
						if (i > 3) {
							personal_layout4.setVisibility(1);
							txt4.setText(category_arrayshow[3]);
							txt4.setTag(categoryid_arrayshow[3]);
							if (i > 4) {
								personal_layout5.setVisibility(1);
								txt5.setText(category_arrayshow[4]);
								txt5.setTag(categoryid_arrayshow[4]);
							}
						}
					}
				}
			}
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		topicsort();
	}

	private android.view.View.OnClickListener listener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.personal_layout1:
				recommendedClick(txt1.getText().toString(), txt1.getTag().toString());
				break;
			case R.id.personal_layout2:
				recommendedClick(txt2.getText().toString(), txt2.getTag().toString());
				break;
			case R.id.personal_layout3:
				recommendedClick(txt3.getText().toString(), txt3.getTag().toString());
				break;
			case R.id.personal_layout4:
				recommendedClick(txt4.getText().toString(), txt4.getTag().toString());
				break;
			case R.id.personal_layout5:
				recommendedClick(txt5.getText().toString(), txt5.getTag().toString());
				break;
			case R.id.recommended_layout1:
				recommendedClick(txt11.getText().toString(), txt11.getTag().toString());
				break;
			case R.id.recommended_layout2:
				recommendedClick(txt12.getText().toString(), txt12.getTag().toString());
				break;
			case R.id.recommended_layout3:
				recommendedClick(txt13.getText().toString(), txt13.getTag().toString());
				break;
			case R.id.recommended_layout4:
				recommendedClick(txt14.getText().toString(), txt14.getTag().toString());
				break;
			case R.id.recommended_layout5:
				recommendedClick(txt15.getText().toString(), txt15.getTag().toString());
				break;
			default:
				break;

			}
		}
	};
	Handler threadMessageHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.arg1 == 0) {

				// Log.d("news", "recieved");
				String res_is = (String) msg.obj;

				try {
					JSONArray json_array = new JSONArray(res_is);
					if (json_array.length() != 0) {
						for (int i = 0; i < json_array.length(); i++) {
							JSONObject json_all = json_array.getJSONObject(i);
							// {"Id":25,"Orders":0,"ParentId":0,"Remark":"","Template":"","Title":"地方话题","Value":"4"},
							String Id = json_all.getString("Id");
							String Orders = json_all.getString("Orders");
							String ParentId = json_all.getString("ParentId");
							String Remark = json_all.getString("Remark");
							String Template = json_all.getString("Template");
							String Title = json_all.getString("Title");
							String Value = json_all.getString("Value");

							// shared
							Context ctx = CategoryActivity.this;
							SharedPreferences sp = ctx.getSharedPreferences(
									"SP", MODE_PRIVATE);
							Editor editor = sp.edit();
							editor.putString("Id", Id);
							editor.putString("Orders", Orders);
							editor.putString("ParentId", ParentId);
							editor.putString("Remark", Remark);
							editor.putString("Template", Template);
							editor.putString("Title", Title);
							editor.putString("Value", Value);
							editor.commit();

							int j = json_array.length();
							if (j > 0) {
								recommended_layout1.setVisibility(1);
								txt11.setText(json_array.getJSONObject(0)
										.getString("Title"));
								txt11.setTag(json_array.getJSONObject(0)
										.getString("Id"));
								if (j > 1) {
									recommended_layout2.setVisibility(1);
									txt12.setText(json_array.getJSONObject(1)
											.getString("Title"));
									txt12.setTag(json_array.getJSONObject(1)
											.getString("Id"));
									if (j > 2) {
										recommended_layout3.setVisibility(1);
										txt13.setText(json_array.getJSONObject(
												2).getString("Title"));
										txt13.setTag(json_array.getJSONObject(
												2).getString("Id"));
										if (j > 3) {
											recommended_layout4.setVisibility(1);
											txt14.setText(json_array.getJSONObject(3)
													.getString("Title"));
											txt14.setTag(json_array.getJSONObject(3)
													.getString("Id"));
											if (j > 4) {
												recommended_layout5.setVisibility(1);
												txt15.setText(json_array.getJSONObject(4)
														.getString("Title"));
												txt15.setTag(json_array.getJSONObject(4)
														.getString("Id"));
											}
										}
									}
								}
							}

							// Toast.makeText(ctx, Id,
							// Toast.LENGTH_LONG).show();
						}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	};
}
