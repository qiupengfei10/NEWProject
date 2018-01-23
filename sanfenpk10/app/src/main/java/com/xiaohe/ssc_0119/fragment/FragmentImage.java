package com.xiaohe.ssc_0119.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaohe.ssc_0119.BaseWebActivity;
import com.xiaohe.ssc_0119.R;

/**
 * Created by qiupengfei on 2017/7/17.
 */
public class FragmentImage extends Fragment {
    private int imageId;
    private String imageUrl;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.imageId = getArguments().getInt("imageId");
        this.imageUrl = getArguments().getString("imageUrl");
    }

    public static FragmentImage newInstance(int imageId) {
        Bundle bundle = new Bundle();
        FragmentImage fragment = new FragmentImage();
        bundle.putInt("imageId",imageId);
        fragment.setArguments(bundle);
        return fragment;
    }
    public static FragmentImage newInstance(String url) {
        Bundle bundle = new Bundle();
        FragmentImage fragment = new FragmentImage();
        bundle.putString("imageUrl",url);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_image,null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        if (imageUrl != null){
            Glide.with(this).load(imageUrl).into(iv);
            return view;
        }
        iv.setImageResource(imageId);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BaseWebActivity.class);
                intent.putExtra("url","https://apk-skyping.zz-app.com/link.html");
                startActivity(intent);
            }
        });
        return view;
    }
}
