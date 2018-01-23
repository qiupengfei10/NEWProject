package com.xiaohe.ssc_0119.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaohe.ssc_0119.R;

/**
 * Created by qiupengfei on 2017/12/6.
 */
public class MyFragment extends Fragment {
    private View view;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home1,null);
        return view;
    }
}
