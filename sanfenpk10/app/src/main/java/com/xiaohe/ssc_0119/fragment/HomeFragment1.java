package com.xiaohe.ssc_0119.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oragee.banners.BannerView;
import com.xiaohe.ssc_0119.BallView;
import com.xiaohe.ssc_0119.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiupengfei on 2018/1/22.
 */
public class HomeFragment1 extends BaseFragment{

    private View view;
    private BannerView bannerView;
    private List<View> viewList;
    private List<String> imageUrl = new ArrayList<>();
    private LinearLayout mLlParent;
    private List<String> integers = new ArrayList<>();
    private TextView mTvNews;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home2,null);
        bannerView = (BannerView)view.findViewById(R.id.banner_view);
        mLlParent = (LinearLayout)view.findViewById(R.id.ll_parent);
        mTvNews = (TextView)view.findViewById(R.id.tv_news);
        mTvNews.setSelected(true);

        viewList = new ArrayList<>();
        addBannerContext();
        bannerView.setViewList(viewList);
        bannerView.startLoop(true);
        bannerView.setTransformAnim(true);

        new BallView(getActivity(), new String[]{"01","30","08","10","05","32","32","54"}, mLlParent, new BallView.CallBack() {
            @Override
            public void setColor(List<TextView> textView) {
                for (int i=0;i<textView.size();i++){
                    textView.get(i).setBackgroundResource(R.drawable.shape_ball_red);
                    if (i >= textView.size()-2){
                        textView.get(i).setBackgroundResource(R.drawable.shape_ball_bule);
                    }
                }
            }
        });
        return view;
    }

    private void addBannerContext() {
        imageUrl.add("https://www.jia16.com/static/dam/jcr:043ef18c-26d9-4849-a81b-445a20a9a6e9/20171229APP.3.jpg");
        imageUrl.add("https://www.jia16.com/static/dam/jcr:1af776ca-df2e-48f8-b712-4df8d24d1c08/20171213D.jpg");
        imageUrl.add("https://www.jia16.com/static/dam/jcr:eeb3b236-c486-4c3e-afee-6c9c47c6b795/20171213A.jpg");
        imageUrl.add("https://www.jia16.com/static/dam/jcr:717a83ac-894d-4673-ab81-6f2e32db494a/20171213F.jpg");
        for (String url:imageUrl) {
            ImageView imageView = new ImageView(getActivity());
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            Glide.with(getActivity()).load(url).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(params);
            viewList.add(imageView);
        }
    }
}
