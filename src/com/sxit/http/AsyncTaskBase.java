package com.sxit.http;

import org.json.JSONArray;
import org.ksoap2.serialization.SoapObject;

import com.sxit.utils.Utils;

import android.os.AsyncTask;

/**
 * 寮傛璇锋眰绫�Base
 * 
 * @author huanyu 绫诲悕绉帮細AsyncTaskBase 鍒涘缓鏃堕棿:2014-11-4 涓嬪崍7:15:11
 */
public class AsyncTaskBase {
	public String[] property_nm;// key
	public Object[] property_va;// value
	public String method;
	public SoapObjectResult soapResult;
	/**
	 * 寮傛璇锋眰绫�
	 * @author huanyu	
	 * 绫诲悕绉帮細AsyncTaskCom   
	 * 鍒涘缓鏃堕棿:2014-11-4 涓嬪崍8:08:01
	 */
	class AsyncTaskCom extends AsyncTask<Object, Object, String> {


		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(Object... params) {
			Object res_obj = SoapGetService.data(method, property_nm, property_va);
			if (null != res_obj) {
				String so = (String) res_obj;
//				SoapObject so = (SoapObject) res_obj;
				return so;
			} else {
				return null;
			}

		}

		@Override
		protected void onPostExecute(String result) {
			Utils.removeProgressDialog();
			if (result == null) {
				soapResult.soapError();
			} else {
				soapResult.soapResult(result);
			}
			super.onPostExecute(result);
		}
	}

	/**
	 * this execute
	 */
	public void executeDo(SoapObjectResult soapResult) {
		this.soapResult = soapResult;
		new AsyncTaskCom().execute();
	}

	public void setProperty_nm(String[] property_nm) {
		this.property_nm = property_nm;
	}

	public void setProperty_va(Object[] property_va) {
		this.property_va = property_va;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setSoapResult(SoapObjectResult soapResult) {
		this.soapResult = soapResult;
	}

	/**
	 * soap鍥炶皟鎺ュ彛
	 * 
	 * @author huanyu 绫诲悕绉帮細SoapObjectResult 鍒涘缓鏃堕棿:2014-11-4 涓嬪崍7:39:05
	 */
	public interface SoapObjectResult {
		void soapResult(String obj);

		void soapError();
	}
}
