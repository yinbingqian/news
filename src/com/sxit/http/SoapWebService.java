package com.sxit.http;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import android.os.Message;
import android.util.Log;

import com.sxit.utils.SOAP_UTILS;

public class SoapWebService {
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
			HttpClient client = new DefaultHttpClient();
			// 鍒涘缓涓�釜GET璇锋眰
			String url = "";
			url = SOAP_UTILS.IP + "/" + method;
			for (int i = 0; i < property_va.length; i++) {
				url = url + "/" + property_va[i];
			}
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response;
			response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			Message msg = new Message();
			msg.arg1 = 0;
			msg.obj = EntityUtils.toString(entity);

			return msg.obj;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
