package com.sxit.activity.th.item.bean;

import java.io.Serializable;

import com.sxit.entity.anwser.Anwser;

/**
 * 提问 bean
 * 
 * @author huanyu 类名称：AskQuestion_ListBean 创建时间:2014-10-27 下午8:38:17
 */
public class AskQuestion_ListBean implements Serializable {
	// private int imgUrl;
	// private String name;
	// private String answerState;// 问题状态 0：提问中 1：已解答
	// private String startTime;// 提问时间
	// private String endTime;// 结束时间
	// private String content;// 内容
	// private String money;// 赏金
	// private String answerNum;// 回答次数
	private String id;//  问答id
	private String title;//  问答标题
	private String content;//  问答内容
	private String crtime;//  提问时间
	private String mark;//  悬赏红心值
	private String aging;//  问题关闭时间
	private String status;//  问题状态 1是已关闭 0是进行中
	private String imgUrl;//图片
	private String count;//  回答数
	private String bestAnswer;

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

	public String getBestAnswer() {
		return bestAnswer;
	}

	public void setBestAnswer(String bestAnswer) {
		this.bestAnswer = bestAnswer;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
