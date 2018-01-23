package com.xiaohe.ssc_0119.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaohe.ssc_0119.R;

/**
 * Created by qiupengfei on 2017/8/11.
 */
public class ThreeFragment extends Fragment {
    private View view;
    private ImageView ivBanner;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home1,null);
        ivBanner = (ImageView) view.findViewById(R.id.iv_banner);
        Glide.with(getActivity()).load("http://img.500.com/upimages/wap/img/20171206104648157.jpg?!960.jpg").into(ivBanner);
        return view;
    }
}
