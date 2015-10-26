package com.shangdingdai.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shangdingdai.applcation.Constants;
import com.shangdingdai.bean.XmtzBean;
import com.shangdingdai.utils.ImageLoadOptions;
import com.shangdingdai.utils.StringUtils;
import com.shangdingdai.view.R;

public class TzglAdapter extends BaseListAdapter<XmtzBean> {
	private List<XmtzBean> list;

	public TzglAdapter(List<XmtzBean> list, Context context) {
		super(list, context);
		// TODO Auto-generated constructor stub
		this.list = list;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getContentView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.layout_item_tzgl, null);
			holder.tv_title = (TextView) convertView
					.findViewById(R.id.tv_title);
			holder.tv_static = (TextView) convertView
					.findViewById(R.id.tv_static);
			holder.tv_je_msg = (TextView) convertView
					.findViewById(R.id.tv_je_msg);
			holder.tv_nlv_msg = (TextView) convertView
					.findViewById(R.id.tv_nlv_msg);
			holder.tv_qx_msg = (TextView) convertView
					.findViewById(R.id.tv_qx_msg);
			holder.tv_qq_msg = (TextView) convertView
					.findViewById(R.id.tv_qq_msg);
			holder.icon_title = (ImageView) convertView
					.findViewById(R.id.icon_title);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		XmtzBean bean = list.get(position);
		ImageLoader.getInstance().displayImage(
				Constants.IC_USER_URL + bean.getImgsrc(), holder.icon_title,
				ImageLoadOptions.getOptions());
		holder.tv_title.setText(bean.getTitle());
		holder.tv_je_msg.setText(bean.getJine() + "元");
		holder.tv_nlv_msg.setText(bean.getLilv() + "%");
		holder.tv_qx_msg.setText(bean.getYujishouyi() + "元");
		holder.tv_qq_msg.setText(bean.getDkqy() + "月");
		int i = StringUtils.showIcon(bean.getDatastatic());
		switch (i) {
		case StringUtils.ICON_HKZ:
			holder.tv_static.setText("还款中");
			break;
		case StringUtils.ICON_SHZ:
			holder.tv_static.setText("审核中");
			break;
		case StringUtils.ICON_YJJ:
			holder.tv_static.setText("已拒绝");
			break;
		case StringUtils.ICON_YJS:
			holder.tv_static.setText("已结束");
			break;
		case StringUtils.ICON_YMB:
			holder.tv_static.setText("已满标");
		case StringUtils.ICON_TBZ:
			holder.tv_static.setText("已结束");
			break;
		}
		return convertView;
	}

	private class ViewHolder {
		private TextView tv_title;
		private TextView tv_static;
		private TextView tv_je_msg;
		private TextView tv_nlv_msg;
		private TextView tv_qx_msg;
		private TextView tv_qq_msg;
		private ImageView icon_title;

	}

}
