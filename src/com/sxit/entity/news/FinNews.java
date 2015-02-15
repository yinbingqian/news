package com.sxit.entity.news;

import java.io.Serializable;

/**
 * 新闻分类
 * @author huanyu	
 * 类名称：News   
 * 创建时间:2014-11-13 下午6:53:45
 */
public class FinNews implements Serializable{
	private String Col;
	private String ColName;
	private String Content;
	private String Crtime;
	private String Ctime;
	private String Genid;
	private String Id;
	private String Important;
	private String IsRecommend;
	private String Orders;
	private String Picture;
	private String Thumbnail;
	private String Title;
	private String Type;
	public String getCol() {
		return Col;
	}
	public void setCol(String col) {
		Col = col;
	}
	public String getColName() {
		return ColName;
	}
	public void setColName(String colName) {
		ColName = colName;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getCrtime() {
		return Crtime;
	}
	public void setCrtime(String crtime) {
		Crtime = crtime;
	}
	public String getCtime() {
		return Ctime;
	}
	public void setCtime(String ctime) {
		Ctime = ctime;
	}
	public String getGenid() {
		return Genid;
	}
	public void setGenid(String genid) {
		Genid = genid;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getImportant() {
		return Important;
	}
	public void setImportant(String important) {
		Important = important;
	}
	public String getIsRecommend() {
		return IsRecommend;
	}
	public void setIsRecommend(String isRecommend) {
		IsRecommend = isRecommend;
	}
	public String getOrders() {
		return Orders;
	}
	public void setOrders(String orders) {
		Orders = orders;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	public String getThumbnail() {
		return Thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		Thumbnail = thumbnail;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
}
