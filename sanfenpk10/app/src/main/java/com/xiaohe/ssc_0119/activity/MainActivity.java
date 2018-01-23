package com.xiaohe.ssc_0119.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xiaohe.ssc_0119.BaseWebActivity;
import com.xiaohe.ssc_0119.R;

public class MainActivity extends Activity {


    private SwipeRefreshLayout srl;
    private ImageView iv;

    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

        Glide.with(this).load("http://www.pceggs.com/IndexMainStatic/homepage/images/index/newindex_1/game_ggw_l311.jpg").into(iv);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        srl.setRefreshing(false);
                    }
                }, 3000);
            }
        });}

    private void initData() {
        tv1.setText("最近喜欢上玩PC蛋蛋了，各种游戏任务，新手任务多多，其…");
        Glide.with(this).load("http://www.pceggs.com/IndexMainStatic/homepage/images/index/newindex_4/wjzt_img116.jpg").into(iv1);
        tv2.setText("玩蛋蛋也有两三年了，中间因为上学什么的，一直断断续续的…");
        Glide.with(this).load("http://www.pceggs.com/IndexMainStatic/homepage/images/index/newindex_4/wjzt_img316.jpg").into(iv2);
        tv3.setText("马上就要搬新家了，正好缺厨具呢，正好蛋蛋足够换一个压…");
        Glide.with(this).load("http://www.pceggs.com/IndexMainStatic/homepage/images/index/newindex_4/wjzt_img216.jpg").into(iv3);
        tv4.setText("收到蛋蛋的榨汁机真的好高兴，是要榨果汁给孩子喝的，现在给…");
        Glide.with(this).load(
                "http://www.pceggs.com/IndexMainStatic/homepage/images/index/newindex_4/wjzt_img416.jpg").into(iv4);
    }

    private void initView() {
        srl = (SwipeRefreshLayout) findViewById(R.id.srl);
        iv = (ImageView) findViewById(R.id.iv_banner);

        iv1 = (ImageView) findViewById(R.id.item1);
        iv2 = (ImageView) findViewById(R.id.item2);
        iv3 = (ImageView) findViewById(R.id.item3);
        iv4 = (ImageView) findViewById(R.id.item4);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);

    }

    public void click(View view){
        Intent intent = new Intent(MainActivity.this,BaseWebActivity.class);

        switch (view.getId()){
            case R.id.btn1:
                intent = new Intent(MainActivity.this,ImageActivity.class);
                intent.putExtra("imageId",R.mipmap.shishikaijiang);
                intent.putExtra("title","实时开奖");
                intent.putExtra("url","http://m.500.com/info/article/10/");
                break;
//            case R.id.iv_banner:
//                intent.putExtra("url", "http://m.500.com/info/article/19/");
//                break;
            case R.id.btn2:
                intent = new Intent(MainActivity.this,ImageActivity.class);
                intent.putExtra("imageId",R.mipmap.zoushitu);
                intent.putExtra("title","走势图");
                intent.putExtra("url", "http://m.500.com/info/article/9/");
                break;
            case R.id.btn3:
                intent = new Intent(MainActivity.this,ImageActivity.class);
                intent.putExtra("imageId",R.mipmap.kaijiangyuce);
                intent.putExtra("title","开奖预测");
                intent.putExtra("url", "http://m.500.com/info/article/detail-144729.shtml");
                break;
            case R.id.item11:
                intent.putExtra("url", "http://m.500.com/info/article/detail-144718.shtml");
                break;
            case R.id.item21:
                intent.putExtra("url", "http://m.500.com/info/article/detail-144700.shtml");
                break;
            case R.id.item31:
                intent.putExtra("url", "http://m.500.com/info/article/detail-144698.shtml");
                break;
            case R.id.item41:
                intent.putExtra("url", "http://m.500.com/info/article/detail-144697.shtml");
                break;
//            case R.id.tv_loading:
//                intent.putExtra("url", "http://m.500.com/info/article/24/#index");
//                break;
        }
        startActivity(intent);
    }
}
