package com.shangdingdai.fragment;

import com.shangdingdai.view.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GuideFragment1 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_guide1, container, false);
		ImageView mImageView=(ImageView) v.findViewById(R.id.imageView);
		mImageView.setImageResource(R.drawable.icon_guide_one);
		return v;
	}

}
