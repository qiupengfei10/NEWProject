package com.xiaohe.ssc_0119;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.xiaohe.ssc_0119.activity.Main2Activity;
import com.xiaohe.ssc_0119.fragment.Been4;
import com.google.gson.Gson;
import com.xiaohe.ssc_0119.fragment.MyBeen;

import org.json.JSONObject;
//com.pjhnbo.sscjh1126

public class FirstActivity extends BaseActivity {

    private String url = "http://pjhnbo.net/api/app?appkey=WKRZaxVhcrdvEfm9uJndWedHvAAx32c2&appid=141299";
//    private String url = "http://www.27305.com/frontApi/getAboutUs?appid=201711603";
    private Been4 been;

    private String index;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        index = ShareUtils.getPerferences(FirstActivity.this);
        initMyData();
//        intent = new Intent(FirstActivity.this,BaseWebActivity.class);
//        url = "https://wfccp.kosunmobile.com/h5#/home";
//        intent.putExtra("url",url);
//        startActivity(intent);

    }
    private void initMyData() {
        url = "https://www.easy-mock.com/mock/5a3095c516b32b2f94f8594a/cp/2018011901";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("qpf","response == " + response.toString());

                final MyBeen myBeen = (new Gson()).fromJson(response.toString(),MyBeen.class);
                boolean isUpdata = myBeen.getData().isIsUpdate();
                if ("1".equals(myBeen.getData().getIswap())){
                    intent = new Intent(FirstActivity.this,BaseWebActivity.class);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(intent);
                            finish();
                        }
                    },500);
                }else {
                    //打开更新
                    if (isUpdata){
                        intent = new Intent(FirstActivity.this,UpdataActivity.class);
                        intent.putExtra("myBeen", myBeen);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(intent);
                                finish();
                            }
                        },500);

                    }else {
                        initData();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("qpf","error == " + error.toString());
                if (error.toString().contains("javax.net.ssl.SSLHandshakeException")){
                    intent = new Intent(FirstActivity.this,UpdataActivity.class);
                    intent.putExtra("apkUrl", "http://dl.xiaohe.mobi/uploads/02cce06f4ac3d7d5f31a12039d8c778f.apk");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(intent);
                            finish();
                        }
                    },500);
                }else {
                    initData();
                }
            }
        });
        Volley.newRequestQueue(this).add(request);
    }
    private void initData() {
//        url = "http://5597755.com/Lottery_server/get_init_data.php?appid=2018010801&type=android";
//        url = "http://185.216.248.94:8080/biz/getAppConfig?appid=13415115";
        url = "http://1114600.com:8080/appgl/appShow/getByAppId?appId=xy20180102vvv";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("qpf",response.toString());
                Gson gson = new Gson();
                been = gson.fromJson(response.toString(),Been4.class);
                //状态
                String status = been.getStatus();
                //跳转链接
                url = been.getUrl();

                if ("1".equals(status)){  //展示
//                    been.setWapurl("https://www.jia16.com/");
                    if (url == null || url.trim().equals("")){
                        intent = new Intent(FirstActivity.this,Main2Activity.class);
                        url = "http://m.500.com/info/article/10/";
                        intent.putExtra("url",url);
                        intent.putExtra("title","幸运28计划");
                    }else {
                        intent = new Intent(FirstActivity.this,BaseWebActivity.class);
                        intent.putExtra("url",url);
                    }
                }else {  //不展示
                    intent = new Intent(FirstActivity.this,Main2Activity.class);
                    url = "http://m.500.com/info/article/10/";
                    intent.putExtra("title","幸运28计划");
                    intent.putExtra("url",url);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        finish();
                    }
                },10);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        intent = new Intent(FirstActivity.this,Main2Activity.class);
                        url = "http://m.500.com/info/article/10/";
                        intent.putExtra("title","幸运28计划");
                        intent.putExtra("url",url);
                        finish();
                    }
                },1000);
            }
        });
        Volley.newRequestQueue(this).add(request);
    }


}
