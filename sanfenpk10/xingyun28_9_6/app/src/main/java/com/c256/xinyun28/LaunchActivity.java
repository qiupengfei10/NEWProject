package com.c256.xinyun28;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.c256.xinyun28.activity.Main2Activity;
import com.c256.xinyun28.fragment.FragmentImage;

/***
 * 启动页
 */
public class LaunchActivity extends FragmentActivity {
    private ViewPager vpContent;

    private Fragment[] fragments;
    private String url;

    private Button btn;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        url = getIntent().getStringExtra("url");
        initView();
        initData();
        setClick();
    }

    private void initData() {

        fragments = new Fragment[]{
                FragmentImage.newInstance(R.mipmap.start1),
                FragmentImage.newInstance(R.mipmap.start2),
                FragmentImage.newInstance(R.mipmap.start3)
        };

        vpContent.setCurrentItem(0);

        vpContent.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        });
    }

    private void setClick() {
        vpContent.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //显示到最后一页出现开关
                if (position == fragments.length-1)
                btn.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        vpContent = (ViewPager) findViewById(R.id.vp_content);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareUtils.save(LaunchActivity.this,"1");
                if (url != null){
                    intent = new Intent(LaunchActivity.this,BaseWebActivity.class);
                    intent.putExtra("url",url);
                }else {
                    intent = new Intent(LaunchActivity.this,Main2Activity.class);
//                    url = "http://m.500.com/info/kaijiang/dlt/17093.shtml";
//                    intent.putExtra("title","六合开奖");
//                    intent.putExtra("url",url);
//                    startActivity(intent);
                }
                finish();
                startActivity(intent);
            }
        });
    }
}
