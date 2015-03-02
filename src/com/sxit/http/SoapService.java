package com.sxit.http;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.SoapObject;

import android.util.Log;

import com.sxit.entity.category.FinCategory;
import com.sxit.entity.news.FinNews;
import com.sxit.entity.news.FinNewsInfo;
import com.sxit.http.AsyncTaskBase.SoapObjectResult;
import com.sxit.utils.EventCache;
import com.sxit.utils.SOAP_UTILS;

public class SoapService implements ISoapService {
	private AsyncTaskBase asynTaskBase = new AsyncTaskBase();
	private SoapRes soapRes = new SoapRes();

	@Override
	public void getColumns(Object[] property_va, final boolean isPage) {
		String[] property_nm = { "pagesize", "pageindex" };
		asynTaskBase.setMethod(SOAP_UTILS.METHOD.GETCOLUMNSTONEWS);
		asynTaskBase.setProperty_nm(property_nm);
		asynTaskBase.setProperty_va(property_va);
		asynTaskBase.executeDo(new SoapObjectResult() {

			@Override
			public void soapResult(String obj) {
				System.out.println("-----getColumns =" + obj);
				String res_is = obj;

				try {
					JSONArray json_array = new JSONArray(res_is);
					
					List<FinNews> list = new ArrayList<FinNews>();
					if (json_array.length() != 0) {
						for (int i = 0; i < json_array.length(); i++) {

							JSONObject json_all = json_array.getJSONObject(i);

							String Col = json_all.getString("Col");
							String ColName = json_all.getString("ColName");
							String Content = json_all.getString("Content");
							String Crtime = json_all.getString("Crtime");
							String Ctime = json_all.getString("Ctime");
							String Genid = json_all.getString("Genid");
							String Id = json_all.getString("Id");
							String Important = json_all.getString("Important");
							String IsRecommend = json_all.getString("IsRecommend");
							String Orders = json_all.getString("Orders");
							String Picture = json_all.getString("Picture");
							String Thumbnail = json_all.getString("Thumbnail");
							String Title = json_all.getString("Title");
							String Type = json_all.getString("Type");
							
							FinNews bean = new FinNews();
							bean.setId(Id);
							bean.setCol(Col);
							bean.setColName(ColName);
							bean.setContent(Content);
							bean.setCrtime(Crtime);
							bean.setCtime(Ctime);
							bean.setGenid(Genid);
							bean.setImportant(Important);
							bean.setIsRecommend(IsRecommend);
							bean.setOrders(Orders);
							bean.setPicture(Picture);
							bean.setThumbnail(Thumbnail);
							bean.setTitle(Title);
							bean.setType(Type);
							list.add(bean);
						}
					}
					soapRes.setObj(list);
					soapRes.setPage(isPage);
					soapRes.setCode(SOAP_UTILS.METHOD.GETCOLUMNSTONEWS);
					EventCache.commandActivity.post(soapRes);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

			@Override
			public void soapError() {
				soapRes.setObj(null);
				soapRes.setPage(isPage);
				soapRes.setCode(SOAP_UTILS.METHOD.GETCOLUMNSTONEWS);
				EventCache.commandActivity.post(soapRes);
			}
		});
	}

	@Override
	public void adminLogin(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void communReplyAdd(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void communicationAdd(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAdmin(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCommunReplyAna(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCommunReplyByID(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCommunication(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCommunicationALL(Object[] property_va, boolean isPage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCommunicationAllUser(Object[] property_va, boolean isPage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCommunicationAna(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getNewsContent(Object[] property_va) {
		// TODO Auto-generated method stub
		String[] property_nm = { "id" };
		asynTaskBase.setMethod(SOAP_UTILS.METHOD.GETNEWSCONTENT);
		asynTaskBase.setProperty_nm(property_nm);
		asynTaskBase.setProperty_va(property_va);
		asynTaskBase.executeDo(new SoapObjectResult() {

			@Override
			public void soapResult(String obj) {
				String res_is = obj;

					try {
						JSONObject json_news = new JSONObject(res_is);
						
						String Col = json_news.getString("Col");
						String ColName = json_news.getString("ColName");
						String Content = json_news.getString("Content");
						String Crtime = json_news.getString("Crtime");
						String Ctime = json_news.getString("Ctime");
						String Genid = json_news.getString("Genid");
						String Id = json_news.getString("Id");
						String Important = json_news.getString("Important");
						String IsRecommend = json_news.getString("IsRecommend");
						String Orders = json_news.getString("Orders");
						String Picture = json_news.getString("Picture");
						String Thumbnail = json_news.getString("Thumbnail");
						String Title = json_news.getString("Title");
						String Type = json_news.getString("Type");
						
						FinNewsInfo bean = new FinNewsInfo();
						bean.setId(Id);
						bean.setCol(Col);
						bean.setColName(ColName);
						bean.setContent(Content);
						bean.setCrtime(Crtime);
						bean.setCtime(Ctime);
						bean.setGenid(Genid);
						bean.setImportant(Important);
						bean.setIsRecommend(IsRecommend);
						bean.setOrders(Orders);
						bean.setPicture(Picture);
						bean.setThumbnail(Thumbnail);
						bean.setTitle(Title);
						bean.setType(Type);
						
						soapRes.setObj(bean);
//						soapRes.setPage(isPage);
						soapRes.setCode(SOAP_UTILS.METHOD.GETNEWSCONTENT);
						EventCache.commandActivity.post(soapRes);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

			@Override
			public void soapError() {
				soapRes.setObj(null);
				soapRes.setCode(SOAP_UTILS.METHOD.GETNEWSCONTENT);
				EventCache.commandActivity.post(soapRes);
			}
		});
	}

	@Override
	public void getNewsTitle(Object[] property_va, boolean isPage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interactionHomepage(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interactionMessage(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interactionMessageAna(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interactionMessageByID(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interactionSubmit(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updataBestAnswer(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userInfoLogin(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userPayment(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userRegistered(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userPasswordReset(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userNameCheck(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userEditor(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userEditor_city(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void userEditor_head(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReportList(Object[] property_va, boolean isPage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportSubmit(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getReportContent(Object[] property_va) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCategoryTitle(Object[] property_va, final boolean isPage) {
		// TODO Auto-generated method stub
		String[] property_nm = { "pagesize", "pageindex" };
		asynTaskBase.setMethod(SOAP_UTILS.METHOD.COMMUNICATION);
		asynTaskBase.setProperty_nm(property_nm);
		asynTaskBase.setProperty_va(property_va);
		asynTaskBase.executeDo(new SoapObjectResult() {

			@Override
			public void soapResult(String obj) {
				System.out.println("-----getColumns =" + obj);
				String res_is = obj;

				try {
					JSONArray json_array = new JSONArray(res_is);
					
					List<FinCategory> list = new ArrayList<FinCategory>();
					if (json_array.length() != 0) {
						for (int i = 0; i < json_array.length(); i++) {

							JSONObject json_all = json_array.getJSONObject(i);

							String Content = json_all.getString("Content");
							String Crtime = json_all.getString("Crtime");
							String Id = json_all.getString("Id");
							String Sys = json_all.getString("Sys");
							String SysName = json_all.getString("SysName");
							String Title = json_all.getString("Title");
							String Type = json_all.getString("Type");
							String Userid = json_all.getString("Userid");
							
							FinCategory bean = new FinCategory();
							bean.setId(Id);
							bean.setContent(Content);
							bean.setCrtime(Crtime);
							bean.setId(Id);
							bean.setCrtime(Crtime);
							bean.setSys(Sys);
							bean.setSysName(SysName);
							bean.setTitle(Title);
							bean.setType(Type);
							bean.setUserid(Userid);
							list.add(bean);
						}
					}
					soapRes.setObj(list);
					soapRes.setPage(isPage);
					soapRes.setCode(SOAP_UTILS.METHOD.COMMUNICATION);
					EventCache.commandActivity.post(soapRes);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

			@Override
			public void soapError() {
				soapRes.setObj(null);
				soapRes.setPage(isPage);
				soapRes.setCode(SOAP_UTILS.METHOD.COMMUNICATION);
				EventCache.commandActivity.post(soapRes);
			}
		});
	}
	
}
