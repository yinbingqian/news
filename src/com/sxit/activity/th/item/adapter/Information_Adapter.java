package com.sxit.activity.th.item.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sxit.activity.th.item.bean.Information_ListBean;
import com.sxit.instance.Instance;
import com.sxit.utils.SOAP_UTILS;

import lnpdit.operate.news.R;

/**
 * info
 * 
 * @author huanyu 类名称：Information_Adapter 创建时间:2014-10-27 上午12:00:38
 */
public class Information_Adapter extends BaseAdapter {
	private Context context;
	private List<Information_ListBean> list;

	public Information_Adapter(Context context, List<Information_ListBean> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.activity_information_item, null);
			viewHolder = new ViewHolder();
			viewHolder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
			viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
			viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
			viewHolder.tv_analyst = (TextView) convertView.findViewById(R.id.tv_analyst);
			viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Instance.imageLoader.displayImage(SOAP_UTILS.HEADER_URL + list.get(position).getImgUrl(), viewHolder.img_icon, Instance.user_options);
		// viewHolder.img_icon.setImageResource(list.get(position).getImgUrl());

		viewHolder.tv_analyst.setText(list.get(position).getAnalyst());
		viewHolder.tv_title.setText(list.get(position).getTitle());
		if (list.get(position).getNotifType() == 1) {
			viewHolder.tv_title.setTextColor(context.getResources().getColor(R.color.text_color));
			viewHolder.tv_analyst.setVisibility(View.INVISIBLE);
		} else if (list.get(position).getNotifType() == 2) {
			viewHolder.tv_title.setTextColor(context.getResources().getColor(R.color.welcome_textColor));
			viewHolder.tv_analyst.setVisibility(View.GONE);
		} else {
			viewHolder.tv_title.setTextColor(context.getResources().getColor(R.color.text_color));
			viewHolder.tv_analyst.setVisibility(View.GONE);
		}
		viewHolder.tv_date.setText(list.get(position).getDate());
		viewHolder.tv_content.setText(list.get(position).getContent());
		if(list.get(position).getTime().equals("0")){
			viewHolder.tv_time.setVisibility(View.INVISIBLE);
		}else{
			viewHolder.tv_time.setText(list.get(position).getTime());	
		}
	
		return convertView;
	}

	static class ViewHolder {
		public ImageView img_icon;// icon
		public TextView tv_title;// 名称
		public TextView tv_date;// 时间
		public TextView tv_analyst;// 分析师
		public TextView tv_content;// 内容
		public TextView tv_time;// 关注次数
	}
}
