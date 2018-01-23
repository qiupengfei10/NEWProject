package com.xiaohe.ssc_0119.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.xiaohe.ssc_0119.BaseActivity;
import com.xiaohe.ssc_0119.BaseWebActivity;
import com.xiaohe.ssc_0119.R;
import com.xiaohe.ssc_0119.fragment.TwoFragment;

public class Main3Activity extends BaseActivity {
    private Fragment[] fragments = new Fragment[5];
    private RadioGroup rgButton;
    private RadioButton rb;
    private TextView mTvTitle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savedInstanceState = null;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        rgButton = (RadioGroup) findViewById(R.id.rg_bottom);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTitle2 = (TextView) findViewById(R.id.tv_title3);
        rb = (RadioButton)findViewById(R.id.rb1);

        rb.setChecked(true);
        showFragment(0);
        mTvTitle.setText("首页");
        rgButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        showFragment(0);
                        mTvTitle.setText("资讯");
                        findViewById(R.id.tv_title3).setVisibility(View.GONE);
                        findViewById(R.id.tv_title2).setVisibility(View.GONE);
                        break;
                    case R.id.rb2:
                        showFragment(1);
                        mTvTitle.setText("开奖");
                        mTvTitle2.setText("开奖");
                        findViewById(R.id.tv_title3).setVisibility(View.GONE);
                        findViewById(R.id.tv_title2).setVisibility(View.GONE);
                        break;
                    case R.id.rb3:
                        showFragment(2);
                        mTvTitle.setText("比分");
                        mTvTitle2.setText("比分");
                        findViewById(R.id.tv_title2).setVisibility(View.GONE);
                        findViewById(R.id.tv_title3).setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb4:
                        showFragment(3);
                        mTvTitle.setText("走势");
                        mTvTitle2.setText("走势");
                        findViewById(R.id.tv_title3).setVisibility(View.GONE);
                        findViewById(R.id.tv_title2).setVisibility(View.GONE);
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
                case 0://资讯
                    url = "http://m.aicai.com/newInfo/index.do?agentId=1&vt=5";
                    fragments[index] = new TwoFragment(url);
                    break;
                case 1://开奖
                    url = "http://m.aicai.com/kjgg/index.do?agentId=1&vt=5";
                    fragments[index] = new TwoFragment(url);
                    break;
                case 2://比分
                    url = "http://m.aicai.com/league/zc/match/fbMatchListView?agentId=1&vt=5";
                    fragments[index] = new TwoFragment(url);
                    break;
                case 3://走势
                    url = "http://m.aicai.com/zst/index.do?agentId=1&vt=5";
                    fragments[index] = new TwoFragment(url);
                    break;
            }
            if (index == 0){
//                transaction.add(R.id.fragment,fragments[4]);
//                transaction.commit();
            }
            transaction.add(R.id.fragment,fragments[index]);
        }else {
            transaction.show(fragments[index]);
        }
        //提交业务
        transaction.commit();
    }

    public void click2(View view){
        Intent intent = new Intent(this, BaseWebActivity.class);
        switch (view.getId()){
            case R.id.tv1:
                intent.putExtra("title","看开奖");
                intent.putExtra("url","http://m.159cai.com/kj/?regfrom=133561");
                break;
            case R.id.tv2:
                intent.putExtra("title","看比分");
                intent.putExtra("url","http://m.159cai.com/live/bfzb.html");
                break;
            case R.id.tv3:
                intent.putExtra("title","看资讯");
                intent.putExtra("url","http://m.159cai.com/gong/news.html");
                break;
            case R.id.tv4:
                intent.putExtra("title","玩社区");
                intent.putExtra("url","http://m.500.com/info/kaijiang/pls/");
                break;
            case R.id.tv5:
                intent.putExtra("title","赛事分析");
                intent.putExtra("url","http://m.500.com/mczhuanti/n_mcliansai/449.shtml");
                break;
            case R.id.tv6:
                intent.putExtra("title","走势图");
                intent.putExtra("url","http://m.500.com/datachart/ssq/jb.html");
                break;
            case R.id.tv7:
                intent.putExtra("title","彩票资讯");
                intent.putExtra("url","http://m.aicai.com/newInfo/index.do?navId=2&agentId=1&vt=5");
                break;
            case R.id.tv8:
                intent.putExtra("title","精品杀码");
                intent.putExtra("url","http://m.500.com/index.php?c=article&a=shahao&sid=6");
                break;
            case R.id.tv9:
                intent.putExtra("title","公告");
                intent.putExtra("url","http://m.159cai.com/gong/index.html");
                break;
            case R.id.tv10:
                intent.putExtra("title","每日竞彩");
                intent.putExtra("url","http://m.159cai.com/gong/dailycontest.html");
                break;
            case R.id.tv11:
                intent.putExtra("title","新闻资讯");
                intent.putExtra("url","http://m.159cai.com/gong/news.html");
                break;
        }
        startActivity(intent);
    }
}
