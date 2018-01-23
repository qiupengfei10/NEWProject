package com.c256.xinyun28.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.c256.xinyun28.BaseActivity;
import com.c256.xinyun28.R;
import com.c256.xinyun28.fragment.TwoFragment;

public class Main2Activity extends BaseActivity {
    private Fragment[] fragments = new Fragment[3];
    private RadioGroup rgButton;
    private RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savedInstanceState = null;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rgButton = (RadioGroup) findViewById(R.id.rg_bottom);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        rb = (RadioButton)findViewById(R.id.rb1);

        rb.setChecked(true);
        showFragment(0);
        mTvTitle.setText("幸运开奖");
        rgButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        showFragment(0);
                        mTvTitle.setText("幸运开奖");
                        break;
                    case R.id.rb2:
                        showFragment(1);
                        mTvTitle.setText("pk走势");
                        break;
                    case R.id.rb3:
                        showFragment(2);
                        mTvTitle.setText("开心吐糟");
                        break;
                }
            }
        });
    }

    private void showFragment(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //将所有的fragment隐藏
        for (Fragment fragment:fragments) {
            if (fragment != null){
                transaction.hide(fragment);
            }
        }


//   http://m.500.com/info/article/10/  研究院
//   http://m.500.com/info/article/17/  评论
//   http://m.500.com/info/article/19/  行业日报
        if (fragments[index] == null){
            String url;
            switch (index){
                case 0:
//                    url = "http://m.500.com/info/article/10/";
//                    fragments[index] = new TwoFragment(url);
                    url = "http://m.500.com/info/kaijiang/moreexpect/ssq/?0_uc_uctj";
                    fragments[index] = new TwoFragment(url);
                    break;
                case 1://图表
                    url = "http://m.500.com/datachart/";
                    fragments[index] = new TwoFragment(url);
                    break;
                case 2:
                    url = "http://m.500.com/info/article/17/";
                    fragments[index] = new TwoFragment(url);
                    break;
            }
            transaction.add(R.id.fragment,fragments[index]);
        }else {
            transaction.show(fragments[index]);
        }
        //提交业务
        transaction.commit();
    }
}
