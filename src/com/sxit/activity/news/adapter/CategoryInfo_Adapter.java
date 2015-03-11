package com.sxit.activity.news.adapter;

import java.util.List;

import com.sxit.entity.category.FinCategoryInfo;
import com.sxit.instance.Instance;

import lnpdit.operate.news.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class CategoryInfo_Adapter extends BaseAdapter {
	private Context context;
	private List<FinCategoryInfo> list;

	public CategoryInfo_Adapter(Context context, List<FinCategoryInfo> list) {
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
			convertView = LayoutInflater.from(context).inflate(R.layout.activity_categoryreply_item, null);
			viewHolder = new ViewHolder();
			viewHolder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
//			viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
			viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
			viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
//			viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Instance.imageLoader.displayImage(list.get(position).getUserHeader(), viewHolder.img_icon, Instance.new_s_options);
//		Instance.imageLoader.displayImage(list.get(position).getPicture(), viewHolder.img_icon, Instance.new_s_options);
//		viewHolder.tv_title.setText(list.get(position).getTitle());
//		viewHolder.tv_title.setTextColor(context.getResources().getColor(R.color.text_color));
		viewHolder.tv_date.setText(list.get(position).getCrtime());
		viewHolder.tv_content.setText(list.get(position).getContent());
		viewHolder.tv_name.setText(list.get(position).getRealName());
		return convertView;
	}

	static class ViewHolder {
		public ImageView img_icon;// icon
//		public TextView tv_title;// 名称
		public TextView tv_date;// 时间
		public TextView tv_name;//发布人
		public TextView tv_content;// 内容
//		public TextView tv_time;// 关注次数
	}
}
