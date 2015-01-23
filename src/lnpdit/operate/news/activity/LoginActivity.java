package lnpdit.operate.news.activity;

import java.util.ArrayList;
import java.util.List;

import lnpdit.operate.news.R;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

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
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity {

	Context context;

	Button login_bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		context = this;

		login_bt = (Button) this.findViewById(R.id.login_bt);
		login_bt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
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
							httpPost();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				thread.start();

			}
		});
	}

	// 璋冪敤绾跨▼璁块棶REST鏈嶅姟
	public String httpPost() throws Exception {
		String response = null;
		int timeoutConnection = 3000;
		int timeoutSocket = 5000;
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters,
				timeoutConnection);
		HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
		HttpClient httpClient = new DefaultHttpClient(httpParameters);
		HttpPost httpPost = new HttpPost(
				"http://200.20.30.142:8027/lnpdit/login");
		// 添加http头信息
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.addHeader("User-Agent", "imgfornote");
		// List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
		// nameValuePair.add(new BasicNameValuePair("name", "wys"));
		// nameValuePair.add(new BasicNameValuePair("password", "wys"));
		// nameValuePair.add(new BasicNameValuePair("phone", "67030"));
		// httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));

		JSONObject json = new JSONObject();
		json.put("name", "wys");
		json.put("password", "wys");
		json.put("phone", "67030");

		httpPost.setEntity(new StringEntity(json.toString(), "UTF-8"));
		HttpResponse httpResponse = httpClient.execute(httpPost);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		if (statusCode == HttpStatus.SC_OK) {
			response = EntityUtils.toString(httpResponse.getEntity());
		} else {
			response = String.valueOf(statusCode);
		}

		Message msg = new Message();
		msg.arg1 = 0;
		msg.obj = response.toString();
		threadMessageHandler.sendMessage(msg);
		Log.d("news", "sended");

		return response;
	}

	// 鎺ユ敹缃戠粶杩斿洖鍊硷紝瑙ｆ瀽锛岃烦杞琈ainActivity
	Handler threadMessageHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.arg1 == 0) {

				Log.d("news", "recieved");
				String res_is = (String) msg.obj;

				try {
					JSONObject json_all = new JSONObject(res_is);
					JSONObject person = json_all.getJSONObject("LoginResult");

					String Id = person.getString("Id");
					String Islock = person.getString("Islock");
					String Name = person.getString("Name");
					String Password = person.getString("Password");
					String RealName = person.getString("RealName");
					String Remark = person.getString("Remark");
					String Sex = person.getString("Sex");
					String Sim = person.getString("Sim");

					// shared
					Context ctx = LoginActivity.this;  
					SharedPreferences sp = ctx.getSharedPreferences("SP",
							MODE_PRIVATE);
					Editor editor = sp.edit();
					editor.putString("Id", Id);
					editor.putString("Islock", Islock);
					editor.putString("Name", Name);
					editor.putString("Password", Password);
					editor.putString("RealName", RealName);
					editor.putString("Remark", Remark);
					editor.putString("Sex", Sex);
					editor.putString("Sim", Sim);
					editor.commit();

					if (!Id.equals("0")) {
						Intent intent = new Intent();
						intent.setClass(LoginActivity.this, MainActivity.class);
						startActivity(intent);
						startService(intent);
					}
					Toast.makeText(ctx, Name, Toast.LENGTH_LONG).show();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// {"Id":20,"Islock":false,"Name":"admin","Password":"admin","RealName":"鐜嬪厓鐭�,
				// "Remark":"","Sex":"0","Sim":"18940052640","Type":"2"}
				// Toast.makeText(context, res_is, Toast.LENGTH_LONG).show();

				Log.d("news", res_is);
			}
		}
	};
}
