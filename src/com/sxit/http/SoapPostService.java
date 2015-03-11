package com.sxit.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Message;

import com.sxit.utils.SOAP_UTILS;

public class SoapPostService {
	/**
	 * 
	 * @param method
	 *            SOAP_UTILS
	 * @param property_nm
	 * @param property_va
	 * @return
	 */
	public static Object data(String method, String[] property_nm,
			Object[] property_va) {

		try {
			String url = "";
			url = SOAP_UTILS.IP + "/" + method;
			JSONObject json = new JSONObject();
			for (int i = 0; i < property_va.length; i++) {
				json.put(property_nm[i], property_va[i]);
			}
			String response = null;
			int timeoutConnection = 3000;
			int timeoutSocket = 5000;
			HttpParams httpParameters = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParameters,timeoutConnection);
			HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
			HttpClient httpClient = new DefaultHttpClient(httpParameters);
			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("Content-Type", "application/json");
			httpPost.addHeader("User-Agent", "imgfornote");
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

			return msg.obj;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
