package com.shangdingdai.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.shangdingdai.bean.MyRedPagerBean;
import com.shangdingdai.view.R;

public class MyRedPagerAdapter extends BaseListAdapter<MyRedPagerBean>{
	private List<MyRedPagerBean> list;

	public MyRedPagerAdapter(List<MyRedPagerBean> list, Context context) {
		super(list, context);
		// TODO Auto-generated constructor stub
		this.list=list;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getContentView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=mInflater.inflate(R.layout.layout_item_myredpager, null);
			holder.tv_hb_je=(TextView) convertView.findViewById(R.id.tv_hb_je);
			holder.tv_hb_title=(TextView) convertView.findViewById(R.id.tv_hb_title);
			holder.tv_hb_time=(TextView) convertView.findViewById(R.id.tv_hb_time);
			holder.icon_hb_static=(ImageView) convertView.findViewById(R.id.icon_hb_static);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}

		MyRedPagerBean bean=list.get(position);
		holder.tv_hb_je.setText(bean.getJine()+" 元");
		holder.tv_hb_title.setText("来源："+bean.getTitle());
		holder.tv_hb_time.setText(bean.getYouxiaoqi());
		String img_static=bean.getDatastatic();
		if("1".equals(img_static)){
			//已使用
			holder.icon_hb_static.setImageResource(R.drawable.icon_myredpager_ysy);
		}else if("2".equals(img_static)){
			//已过期
			holder.icon_hb_static.setImageResource(R.drawable.icon_myredpager_ygq);
		}
		return convertView;
	}
	
	private class ViewHolder{
		private TextView tv_hb_je;
		private TextView tv_hb_title;
		private TextView tv_hb_time;
		private ImageView icon_hb_static;
		
	}
}
