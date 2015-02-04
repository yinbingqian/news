package com.sxit.activity.adviser.th.item.bean;

import java.io.Serializable;

/**
 * 提问 bean
 * 
 * @author huanyu 类名称：AskQuestion_ListBean 创建时间:2014-10-27 下午8:38:17
 */
public class Question_ListBean implements Serializable{
	private String id;//问题id
	private String title;//标题
	private String content;//内容
	private String crtime;//发布时间
	private String mark;//红心值
	private String aging;//结束时间
	private String status;//状态0	进行中，1完结
	private String count;//回复条数
	private String userName;//用户名
	private String headpic;//头像
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCrtime() {
		return crtime;
	}
	public void setCrtime(String crtime) {
		this.crtime = crtime;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getAging() {
		return aging;
	}
	public void setAging(String aging) {
		this.aging = aging;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHeadpic() {
		return headpic;
	}
	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}
	
	
	


}
