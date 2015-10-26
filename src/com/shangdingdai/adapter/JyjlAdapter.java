package com.shangdingdai.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shangdingdai.bean.JyjlBean;
import com.shangdingdai.utils.StringUtils;
import com.shangdingdai.view.R;

public class JyjlAdapter extends BaseListAdapter<JyjlBean> {
	private List<JyjlBean> list;

	public JyjlAdapter(List<JyjlBean> list, Context context) {
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
			convertView = mInflater.inflate(R.layout.layout_item_jlcx, null);
			holder.tv_type = (TextView) convertView.findViewById(R.id.tv_type);
			holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
			holder.tv_money = (TextView) convertView
					.findViewById(R.id.tv_money);
			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		JyjlBean bean = list.get(position);
		int n = StringUtils.showType(bean.getTypeid());
		switch (n) {
		case 1:
			holder.tv_type.setText(JyjlBean.JYJL_CZ);
			break;
		case 2:
			holder.tv_type.setText(JyjlBean.JYJL_TB);
			break;
		case 3:
			holder.tv_type.setText(JyjlBean.JYJL_TX);
			break;
		case 4:
			holder.tv_type.setText(JyjlBean.JYJL_JK);
			break;
		case 5:
			holder.tv_type.setText(JyjlBean.JYJL_HK);
			break;
		case 6:
			holder.tv_type.setText(JyjlBean.JYJL_ZR);
			break;
		case 7:
			holder.tv_type.setText(JyjlBean.JYJL_SY);
			break;
		}
		holder.tv_time.setText(bean.getJiaoyitime());
		holder.tv_money.setText(bean.getJiaoyijine() + " 元");
		return convertView;
	}

	private class ViewHolder {
		private TextView tv_type;
		private TextView tv_time;
		private TextView tv_money;
	}

}
