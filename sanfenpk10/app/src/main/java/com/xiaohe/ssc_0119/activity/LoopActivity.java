package com.xiaohe.ssc_0119.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.xiaohe.ssc_0119.BaseActivity;
import com.xiaohe.ssc_0119.BaseWebActivity;
import com.xiaohe.ssc_0119.R;
import com.xiaohe.ssc_0119.fragment.FragmentImage;

public class LoopActivity extends BaseActivity {


    private ImageView ib1;
    private ImageView ib2;
    private ImageView ib3;
    private ImageView ib4;
    private ViewPager vp;

    private FragmentImage[] fragmentImages = new FragmentImage[]{
            FragmentImage.newInstance(R.mipmap.ivi1),
            FragmentImage.newInstance(R.mipmap.ivi2),
            FragmentImage.newInstance(R.mipmap.ivi3),
            FragmentImage.newInstance(R.mipmap.ivi4)
    };
    private boolean isRun = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);
        initView();
        initData();
    }

    int i = 0;

    private void initData() {
        vp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentImages[position%fragmentImages.length];
            }

            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }
        });

        vp.setCurrentItem(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isRun){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            vp.setCurrentItem(i);
                        }
                    });
                    i++;
                }
            }
        }).start();

//        Glide.with(this).load("http://ee256.com/promotion/pictureIndex.html?sno=17081120111512").into(ib1);
//        Glide.with(this).load("http://ee256.com/promotion/pictureIndex.html?sno=170521182103632").into(ib2);
//        Glide.with(this).load("http://ee256.com/promotion/pictureIndex.html?sno=170521175808383").into(ib3);
//        Glide.with(this).load("http://ee256.com/promotion/pictureIndex.html?sno=170424232048129").into(ib4);
    }

    private void initView() {
        vp = (ViewPager)findViewById(R.id.vp_content);
        ib1 = (ImageView)findViewById(R.id.iv1);
        ib2 = (ImageView)findViewById(R.id.iv2);
        ib3 = (ImageView)findViewById(R.id.iv3);
        ib4 = (ImageView)findViewById(R.id.iv4);

        ib1.setImageResource(R.mipmap.ivi1);
        ib2.setImageResource(R.mipmap.ivi2);
        ib3.setImageResource(R.mipmap.ivi3);
        ib4.setImageResource(R.mipmap.ivi4);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.iv1:
            case R.id.iv2:
            case R.id.iv3:
            case R.id.iv4:
                Intent intent = new Intent(this, BaseWebActivity.class);
                intent.putExtra("url","https://apk-skyping.zz-app.com/link.html");
                startActivity(intent);
                break;
        }
    }
}
