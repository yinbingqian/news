package lnpdit.operate.news.activity;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import lnpdit.operate.news.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
	
//	private聽static聽final聽String聽JSON聽=聽"{" +"聽聽聽\"id\"聽:聽20,"聽+聽"聽聽聽\"Islock\"聽:聽false,"聽+聽聽
//				"\"Name\" : \"admin\," +
//				"\"Password\" : \"admin\"," +
//				"\"RealName\" : \"鐜嬪厓鐭砛","+
//				"\"Remark\" : \"\", +
//				"\"Sex\" :0, "+
//				"聽聽聽\"Sim\"聽:聽\"18940052640\","聽+聽
//				"聽聽聽\"Type\"聽:聽2,"聽+聽聽
//				"}";

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
						Log.d("news", "clicked");
						HttpClient client = new DefaultHttpClient();
						// 鍒涘缓涓�釜GET璇锋眰
						HttpGet httpGet = new HttpGet("http://200.20.30.142:8027/lnpdit/loginbysim/18940052640");
						// HttpGet httpGet=new HttpGet("http://200.20.30.201:8027/lnpdit");
						// 鍚戞湇鍔″櫒鍙戦�璇锋眰骞惰幏鍙栨湇鍔″櫒杩斿洖鐨勭粨鏋�
						HttpResponse response;
						try {
							response = client.execute(httpGet);
							HttpEntity entity = response.getEntity();
							// 杩斿洖鐨勭粨鏋滃彲鑳芥斁鍒癐nputStream锛宧ttp Header涓瓑銆�
							// 璁块棶REST鏈嶅姟绾跨▼锛屽皢缁撴灉浼犻�缁檋andler
							Message msg = new Message();
							msg.arg1 = 0;
							msg.obj = EntityUtils.toString(entity);
							threadMessageHandler.sendMessage(msg);
							Log.d("news", "sended");
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
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
	
	// 鎺ユ敹缃戠粶杩斿洖鍊硷紝瑙ｆ瀽锛岃烦杞琈ainActivity
	Handler threadMessageHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.arg1 == 0) {

				Log.d("news", "recieved");
				String res_is = (String) msg.obj;
				
				try {
					JSONObject person = new JSONObject(res_is);
					int Id = person.getInt("Id");
					Boolean Islock = person.getBoolean("Islock");
					String Name = person.getString("Name");
					String Password = person.getString("Password");
					String RealName = person.getString("RealName");
					String Remark = person.getString("Remark");
					String Sex = person.getString("Sex");
					String Sim = person.getString("Sim");
//					Toast.makeText(context, RealName, Toast.LENGTH_LONG).show();
					if(Id>0){
						Intent intent = new Intent();
						intent.setClass(LoginActivity.this, MainActivity.class);
						startActivity(intent);startService(intent);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
//				{"Id":20,"Islock":false,"Name":"admin","Password":"admin","RealName":"鐜嬪厓鐭�,
//				"Remark":"","Sex":"0","Sim":"18940052640","Type":"2"}
//				Toast.makeText(context, res_is, Toast.LENGTH_LONG).show();
				
				Log.d("news", res_is);
			}
		}
	};
}
