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

import com.sxit.entity.news.FinNewsList;
import com.sxit.instance.Instance;

/**
 * info
 * 
 * @author huanyu 类名称：Information_Adapter 创建时间:2014-10-27 上午12:00:38
 */
public class NewsList_Adapter extends BaseAdapter {
	private Context context;
	private List<FinNewsList> list;

	public NewsList_Adapter(Context context, List<FinNewsList> list) {
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
			convertView = LayoutInflater.from(context).inflate(R.layout.activity_newlist_item, null);
			viewHolder = new ViewHolder();
			viewHolder.news_img = (ImageView) convertView.findViewById(R.id.news_img);
			viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			viewHolder.tv_crtimr = (TextView) convertView.findViewById(R.id.tv_crtimr);
			viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

//		 Instance.imageLoader.displayImage(list.get(position).getThumbnail(), viewHolder.news_img, Instance.new_s_options);
		Instance.imageLoader.displayImage(list.get(position).getPicture(), viewHolder.news_img, Instance.new_s_options);
		viewHolder.tv_title.setText(list.get(position).getTitle());
		viewHolder.tv_title.setTextColor(context.getResources().getColor(R.color.text_color));
		viewHolder.tv_crtimr.setText(list.get(position).getCrtime());
		viewHolder.tv_content.setText(list.get(position).getContent());
		return convertView;
	}

	static class ViewHolder {
		public TextView tv_title;
		public TextView tv_crtimr;
		public ImageView news_img;
		public TextView tv_content;
	}
}
