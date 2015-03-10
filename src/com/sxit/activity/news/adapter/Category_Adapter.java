package com.sxit.activity.news.adapter;

import java.util.List;

import lnpdit.operate.news.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sxit.entity.category.FinCategory;


public class Category_Adapter extends BaseAdapter {
	private Context context;
	private List<FinCategory> list;

	public Category_Adapter(Context context, List<FinCategory> list) {
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
			convertView = LayoutInflater.from(context).inflate(R.layout.activity_categoryinformation_item, null);
			viewHolder = new ViewHolder();
//			viewHolder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
//			viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
//			viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
//			viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
//			viewHolder.tv_analyst = (TextView) convertView.findViewById(R.id.tv_analyst);
//			viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
			viewHolder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
			viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
			viewHolder.tv_ctime = (TextView) convertView.findViewById(R.id.tv_date);
			viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
//		Instance.imageLoader.displayImage(list.get(position).getPicture(), viewHolder.img_icon, Instance.new_s_options);
//		Instance.imageLoader.displayImage(list.get(position).getPicture(), viewHolder.img_icon, Instance.new_s_options);
		viewHolder.tv_ctime.setText(list.get(position).getCtime());
		viewHolder.tv_content.setText(list.get(position).getTitle());
		viewHolder.tv_name.setText(list.get(position).getUserName());
		return convertView;
	}

	static class ViewHolder {
		public ImageView img_icon;// icon
//		public TextView tv_title;// ����
//		public TextView tv_date;// ʱ��
//		public TextView tv_analyst;// ����ʦ
//		public TextView tv_content;// ����
//		public TextView tv_time;// ��ע����
		public TextView tv_ctime;
		public TextView tv_content;
		public TextView tv_name;
	}
}
