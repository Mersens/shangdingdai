package com.shangdingdai.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shangdingdai.bean.ShouYiBean;
import com.shangdingdai.utils.StringUtils;
import com.shangdingdai.view.R;

public class HzcxAdapter extends BaseListAdapter<ShouYiBean> {
	private List<ShouYiBean> list;

	public HzcxAdapter(List<ShouYiBean> list, Context context) {
		super(list, context);
		// TODO Auto-generated constructor stub
		this.list = list;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getContentView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.layout_item_hzcx, null);
			holder.tv_shouyiid = (TextView) convertView
					.findViewById(R.id.tv_shouyiid);
			holder.tv_jine = (TextView) convertView.findViewById(R.id.tv_jine);
			holder.tv_yinghuanshijian = (TextView) convertView
					.findViewById(R.id.tv_yinghuanshijian);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		ShouYiBean bean = list.get(position);

		holder.tv_shouyiid.setText(bean.getShouyiid());
		holder.tv_jine.setText(bean.getJine() + " 元");
		String time = StringUtils.getFormatDate(bean.getYinghuanshijian());
		holder.tv_yinghuanshijian.setText(time);
		return convertView;
	}

	private class ViewHolder {
		private TextView tv_shouyiid;
		private TextView tv_jine;
		private TextView tv_yinghuanshijian;
	}

}
