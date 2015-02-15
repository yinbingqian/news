package com.sxit.entity.anwser;

import java.io.Serializable;

/**
 * 解答
 * 
 * @author huanyu 类名称：Anwser 创建时间:2014-11-11 下午4:30:02
 */
public class Anwser implements Serializable{
	public static final int MESSAGE_O = 0;
	public static final int MESSAGE_T = 1;

	private int msg_direction;// 0 left(user)，1 right
	private String date;// 时间
	private String title;// 标题 & 摘要
	private String content;// 内容
	private String mark;// 悬赏红心
	private String crtime;// 发布时间
	private String aging;// 截止时间
	private String content_img;// 内容图片
	private String content_url;// 内容链接
	private String user_img;// 头像
	private String replyId;// 问题id
	private String analystId;// 回答者id
	private String userId;// 提问者id
	private String anwserId;// 回复id(用户查询解答详情)
	private String bestAnswer;// 是否被采纳
	private String nswerMark;// 获取悬红心值
	private String realName;// 昵称

	public int getMsg_direction() {
		return msg_direction;
	}

	public void setMsg_direction(int msg_direction) {
		this.msg_direction = msg_direction;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getCrtime() {
		return crtime;
	}

	public void setCrtime(String crtime) {
		this.crtime = crtime;
	}

	public String getAging() {
		return aging;
	}

	public void setAging(String aging) {
		this.aging = aging;
	}

	public String getContent_url() {
		return content_url;
	}

	public void setContent_url(String content_url) {
		this.content_url = content_url;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getAnalystId() {
		return analystId;
	}

	public void setAnalystId(String analystId) {
		this.analystId = analystId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAnwserId() {
		return anwserId;
	}

	public void setAnwserId(String anwserId) {
		this.anwserId = anwserId;
	}

	public String getContent_img() {
		return content_img;
	}

	public void setContent_img(String content_img) {
		this.content_img = content_img;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public String getBestAnswer() {
		return bestAnswer;
	}

	public void setBestAnswer(String bestAnswer) {
		this.bestAnswer = bestAnswer;
	}

	public String getNswerMark() {
		return nswerMark;
	}

	public void setNswerMark(String nswerMark) {
		this.nswerMark = nswerMark;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

}
