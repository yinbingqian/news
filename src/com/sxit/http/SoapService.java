package com.sxit.http;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.SoapObject;

import android.util.Log;

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
//				SoapObject soapchildsson = (SoapObject) obj.getProperty(0);
//				FinNewsInfo info = new FinNewsInfo();
//				info.setIsRecommend(soapchildsson.getProperty("IsRecommend").toString());
//				info.setId(soapchildsson.getProperty("Id").toString());
//				info.setCol(soapchildsson.getProperty("Col").toString());
//				info.setOrders(soapchildsson.getProperty("Orders").toString());
//				info.setTitle(soapchildsson.getProperty("Title").toString());
//				info.setThumbnail(SOAP_UTILS.PIC_YANBAO + soapchildsson.getProperty("Thumbnail").toString());
//				info.setSource(soapchildsson.getProperty("Source").toString());
//				info.setAuthor(soapchildsson.getProperty("Author").toString());
//				info.setPicture(SOAP_UTILS.PIC_YANBAO + soapchildsson.getProperty("Picture").toString());
//				info.setContent(soapchildsson.getProperty("Content").toString());
//				info.setAdminid(soapchildsson.getProperty("Adminid").toString());
//				info.setCrtime(soapchildsson.getProperty("Crtime").toString());
//				info.setImportant(soapchildsson.getProperty("Important").toString());
//				soapRes.setObj(info);
//				soapRes.setCode(SOAP_UTILS.METHOD.GETNEWSCONTENT);
//				EventCache.commandActivity.post(soapRes);
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

//	@Override
//	public void getNewsTitle(Object[] property_va, final boolean isPage) {
//		String[] property_nm = { "colid", "pagesize", "pageindex" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.GETNEWSTITLE);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				SoapObject soapchids = (SoapObject) obj.getProperty(0);
//				List<FinNewsList> list = new ArrayList<FinNewsList>();
//				if (soapchids.getPropertyCount() != 0) {
//					int item_count = soapchids.getPropertyCount();
//					for (int i = 0; i < item_count; i++) {
//						SoapObject soapchildsson = (SoapObject) soapchids.getProperty(i);
//						FinNewsList bean = new FinNewsList();
//						bean.setId(soapchildsson.getProperty("Id").toString());
//						bean.setCommentCount(soapchildsson.getProperty("CommentCount").toString());
//						bean.setIsRecommend(soapchildsson.getProperty("IsRecommend").toString());
//						bean.setCol(soapchildsson.getProperty("Col").toString());
//						bean.setOrders(soapchildsson.getProperty("Orders").toString());
//						bean.setTitle(soapchildsson.getProperty("Title").toString());
//						bean.setThumbnail(SOAP_UTILS.PIC_YANBAO + soapchildsson.getProperty("Thumbnail").toString());
//						bean.setSource(soapchildsson.getProperty("Source").toString());
//						bean.setAuthor(soapchildsson.getProperty("Author").toString());
//						bean.setPicture(SOAP_UTILS.PIC_YANBAO + soapchildsson.getProperty("Picture").toString());
//						bean.setContent(soapchildsson.getProperty("Content").toString());
//						bean.setAdminid(soapchildsson.getProperty("Adminid").toString());
//						bean.setCrtime(soapchildsson.getProperty("Crtime").toString());
//						bean.setImportant(soapchildsson.getProperty("Important").toString());
//						bean.setValue(soapchildsson.getProperty("Value").toString());
//						bean.setColTitle(soapchildsson.getProperty("ColTitle").toString());
//						list.add(bean);
//					}
//				}
//				soapRes.setObj(list);
//				soapRes.setPage(isPage);
//				soapRes.setCode(SOAP_UTILS.METHOD.GETNEWSTITLE);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//				soapRes.setObj(null);
//				soapRes.setPage(isPage);
//				soapRes.setCode(SOAP_UTILS.METHOD.GETNEWSTITLE);
//				EventCache.commandActivity.post(soapRes);
//			}
//		});
//	}
//
//	@Override
//	public void interactionHomepage(Object[] property_va) {
//		String[] property_nm = { "toUser" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.INTERACTIONHOMEPAGE);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj);
//				soapRes.setCode(SOAP_UTILS.METHOD.INTERACTIONHOMEPAGE);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//
//			}
//		});
//	}
//
//	@Override
//	public void interactionMessage(Object[] property_va) {
//		String[] property_nm = { "toUser", "historyTime" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.INTERACTIONMESSAGE);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj);
//				soapRes.setCode(SOAP_UTILS.METHOD.INTERACTIONMESSAGE);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//
//			}
//		});
//	}
//
//	@Override
//	public void interactionMessageAna(Object[] property_va) {
//		String[] property_nm = { "fromUser", "historyTime" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.INTERACTIONMESSAGEANA);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj);
//				soapRes.setCode(SOAP_UTILS.METHOD.INTERACTIONMESSAGEANA);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//
//			}
//		});
//	}
//
//	@Override
//	public void interactionMessageByID(Object[] property_va) {
//		String[] property_nm = { "ID" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.INTERACTIONMESSAGEBYID);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj);
//				soapRes.setCode(SOAP_UTILS.METHOD.INTERACTIONMESSAGEBYID);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//
//			}
//		});
//	}
//
//	@Override
//	public void interactionSubmit(Object[] property_va) {
//		String[] property_nm = { "fromUser", "toUser", "blogTitle", "blogAbstract", "content", "devType", "infoType", "infoDirection" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.INTERACTIONSUBMIT);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj);
//				soapRes.setCode(SOAP_UTILS.METHOD.INTERACTIONSUBMIT);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//
//			}
//		});
//	}
//
//	@Override
//	public void updataBestAnswer(Object[] property_va) {
//		String[] property_nm = { "id" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.UPDATABESTANSWER);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj.getProperty("UpdataBestAnswerResult"));
//				soapRes.setCode(SOAP_UTILS.METHOD.UPDATABESTANSWER);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//				soapRes.setObj(null);
//				soapRes.setCode(SOAP_UTILS.METHOD.UPDATABESTANSWER);
//				EventCache.commandActivity.post(soapRes);
//			}
//		});
//	}
//
//	@Override
//	public void userPayment(Object[] property_va) {
//		String[] property_nm = { "userid", "pay" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.USERPAYMENT);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj);
//				soapRes.setCode(SOAP_UTILS.METHOD.USERPAYMENT);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//
//			}
//		});
//	}
//
//	@Override
//	public void userRegistered(Object[] property_va) {
//		String[] property_nm = { "sim", "name", "password", "realName", "sex", "imei", "province", "city", "stockAge", "stockStyle" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.USERREGISTERED);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj.getProperty("UserRegisteredResult"));
//				soapRes.setCode(SOAP_UTILS.METHOD.USERREGISTERED);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//				soapRes.setObj(null);
//				soapRes.setCode(SOAP_UTILS.METHOD.USERREGISTERED);
//				EventCache.commandActivity.post(soapRes);
//			}
//		});
//	}
//
//	@Override
//	public void userPasswordReset(Object[] property_va) {
//		String[] property_nm = { "username", "pwd_old", "pwd_new" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.USERPASSWORDRESET);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj.getProperty("UserPasswordResetResult"));
//				soapRes.setCode(SOAP_UTILS.METHOD.USERPASSWORDRESET);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//				soapRes.setObj(null);
//				soapRes.setCode(SOAP_UTILS.METHOD.USERPASSWORDRESET);
//				EventCache.commandActivity.post(soapRes);
//			}
//		});
//	}
//
//	@Override
//	public void userNameCheck(Object[] property_va) {
//		String[] property_nm = { "name" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.USERNAMECHECK);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj.getProperty("UserNameCheckResult"));
//				soapRes.setCode(SOAP_UTILS.METHOD.USERNAMECHECK);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//				soapRes.setObj(null);
//				soapRes.setCode(SOAP_UTILS.METHOD.USERNAMECHECK);
//				EventCache.commandActivity.post(soapRes);
//			}
//		});
//	}
//
//	@Override
//	public void userEditor(Object[] property_va) {
//		String[] property_nm = { "id", "options", "newInfo" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.USEREDITOR);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj.getProperty("UserEditorResult"));
//				soapRes.setCode(SOAP_UTILS.METHOD.USEREDITOR);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//				soapRes.setObj(null);
//				soapRes.setCode(SOAP_UTILS.METHOD.USEREDITOR);
//				EventCache.commandActivity.post(soapRes);
//			}
//		});
//	}
//
//	@Override
//	public void userEditor_city(Object[] property_va) {
//		String[] property_nm = { "id", "province", "city" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.USEREDITOR_CITY);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj.getProperty("UserEditor_cityResult"));
//				soapRes.setCode(SOAP_UTILS.METHOD.USEREDITOR_CITY);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//				soapRes.setObj(null);
//				soapRes.setCode(SOAP_UTILS.METHOD.USEREDITOR_CITY);
//				EventCache.commandActivity.post(soapRes);
//			}
//		});
//	}
//
//	@Override
//	public void userEditor_head(Object[] property_va) {
//		String[] property_nm = { "id", "images" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.USEREDITOR_HEAD);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				soapRes.setObj(obj.getProperty("UserEditor_headResult"));
//				soapRes.setCode(SOAP_UTILS.METHOD.USEREDITOR_HEAD);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//				soapRes.setObj(null);
//				soapRes.setCode(SOAP_UTILS.METHOD.USEREDITOR_HEAD);
//				EventCache.commandActivity.post(soapRes);
//			}
//		});
//	}
//
//	@Override
//	public void getReportList(Object[] property_va,final boolean isPage) {
//		String[] property_nm = { "fromUser", "pagesize", "pageindex" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.GETREPORTLIST);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				System.out.println("------getReportList = "+obj);
//				SoapObject soapchids = (SoapObject) obj.getProperty(0);
//				List<PublishMessage> list = new ArrayList<PublishMessage>();
//				if (soapchids.getPropertyCount() != 0) {
//					int item_count = soapchids.getPropertyCount();
//					for (int i = 0; i < item_count; i++) {
//						SoapObject soapchildsson = (SoapObject) soapchids.getProperty(i);
//						PublishMessage bean = new PublishMessage();
//						bean.setId(soapchildsson.getProperty("Id").toString());
//						bean.setFromUser(soapchildsson.getProperty("FromUser").toString());
//						bean.setToUser(soapchildsson.getProperty("ToUser").toString());
//						bean.setPhoto(SOAP_UTILS.PIC_YANBAO + soapchildsson.getProperty("Photo").toString());
//						bean.setIsread(soapchildsson.getProperty("Isread").toString());
//						bean.setCrtime(soapchildsson.getProperty("Crtime").toString());
//						bean.setAudio(soapchildsson.getProperty("Audio").toString());
//						bean.setAudioLength(soapchildsson.getProperty("AudioLength").toString());
//						bean.setDevType(soapchildsson.getProperty("DevType").toString());
//						bean.setBlogTitle(soapchildsson.getProperty("BlogTitle").toString());
//						bean.setBlogAbstract(soapchildsson.getProperty("BlogAbstract").toString());
//						bean.setContent(soapchildsson.getProperty("Content").toString());
//						bean.setInfoType(soapchildsson.getProperty("InfoType").toString());
//						bean.setInfoDirection(soapchildsson.getProperty("InfoDirection").toString());
//						bean.setReportType(soapchildsson.getProperty("ReportType").toString());
//						bean.setInterTime(soapchildsson.getProperty("InterTime").toString());
//						list.add(bean);
//					}
//				}
//				soapRes.setObj(list);
//				soapRes.setPage(isPage);
//				soapRes.setCode(SOAP_UTILS.METHOD.GETREPORTLIST);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//				soapRes.setObj(null);
//				soapRes.setPage(isPage);
//				soapRes.setCode(SOAP_UTILS.METHOD.GETREPORTLIST);
//				EventCache.commandActivity.post(soapRes);
//			}
//		});
//	}
//
//	@Override
//	public void reportSubmit(Object[] property_va) {
//		String[] property_nm = { "fromUser", "blogTitle", "blogAbstract", "content", "devType", "reportType", "images" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.REPORTSUBMIT);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				System.out.println("-----------reportSubmit ="+obj);
//				soapRes.setObj(obj.getProperty("ReportSubmitResult"));
//				soapRes.setCode(SOAP_UTILS.METHOD.REPORTSUBMIT);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//				soapRes.setObj(null);
//				soapRes.setCode(SOAP_UTILS.METHOD.REPORTSUBMIT);
//				EventCache.commandActivity.post(soapRes);
//			}
//		});
//	}
//
//	@Override
//	public void getReportContent(Object[] property_va) {
//		String[] property_nm = { "id" };
//		asynTaskBase.setMethod(SOAP_UTILS.METHOD.GETREPORTCONTENT);
//		asynTaskBase.setProperty_nm(property_nm);
//		asynTaskBase.setProperty_va(property_va);
//		asynTaskBase.executeDo(new SoapObjectResult() {
//
//			@Override
//			public void soapResult(SoapObject obj) {
//				SoapObject soapchildsson = (SoapObject) obj.getProperty(0);
//				PublishMessageInfo info = new PublishMessageInfo();
//				info.setId(soapchildsson.getProperty("Id").toString());
//				info.setFromUser(soapchildsson.getProperty("FromUser").toString());
//				info.setToUser(soapchildsson.getProperty("ToUser").toString());
//				info.setPhoto(SOAP_UTILS.PIC_YANBAO + soapchildsson.getProperty("Photo").toString());
//				info.setIsread(soapchildsson.getProperty("Isread").toString());
//				info.setCrtime(soapchildsson.getProperty("Crtime").toString());
//				info.setAudio(soapchildsson.getProperty("Audio").toString());
//				info.setAudioLength(soapchildsson.getProperty("AudioLength").toString());
//				info.setDevType(soapchildsson.getProperty("DevType").toString());
//				info.setBlogTitle(soapchildsson.getProperty("BlogTitle").toString());
//				info.setBlogAbstract(soapchildsson.getProperty("BlogAbstract").toString());
//				info.setContent(soapchildsson.getProperty("Content").toString());
//				info.setInfoType(soapchildsson.getProperty("InfoType").toString());
//				info.setInfoDirection(soapchildsson.getProperty("InfoDirection").toString());
//				info.setReportType(soapchildsson.getProperty("ReportType").toString());
//				info.setInterTime(soapchildsson.getProperty("InterTime").toString());
//				soapRes.setObj(info);
//				soapRes.setCode(SOAP_UTILS.METHOD.GETREPORTCONTENT);
//				EventCache.commandActivity.post(soapRes);
//			}
//
//			@Override
//			public void soapError() {
//				soapRes.setObj(null);
//				soapRes.setCode(SOAP_UTILS.METHOD.GETREPORTCONTENT);
//				EventCache.commandActivity.post(soapRes);
//			}
//		});
//	}
//
//	@Override
//	public void adminLogin(Object[] property_va) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void userInfoLogin(Object[] property_va) {
//		// TODO Auto-generated method stub
//		
//	}

}
