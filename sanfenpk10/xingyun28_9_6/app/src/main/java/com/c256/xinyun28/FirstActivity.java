package com.c256.xinyun28;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.c256.xinyun28.activity.Login1Activity;
import com.c256.xinyun28.activity.LoopActivity;
import com.c256.xinyun28.activity.Main2Activity;
import com.c256.xinyun28.fragment.Been2;
import com.c256.xinyun28.fragment.Been369;
import com.c256.xinyun28.fragment.Been6769;
import com.google.gson.Gson;

import org.json.JSONObject;

public class FirstActivity extends BaseActivity {

//    private String url = "http://app.412988.com/Lottery_server/check_and_get_url.php?type=android&appid=2017110326";
    private String url = "http://pjhnbo.net/api/app?appkey=WKRZaxVhcrdvEfm9uJndWedHvAAx32c2&appid=100101";
    private Been2.Root been;
    private String index;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        index = ShareUtils.getPerferences(FirstActivity.this);
        initData();
    }

    private void initData() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("qpf","请求结果 ： " + response);
                Gson gson = new Gson();
                been = gson.fromJson(response.toString(),Been2.Root.class);

//                if ("1".equals(been.getData().getShow_url())){  //展示
                if ("1".equals(been.getData().getIswap())){  //展示
                    if (been.getData().getWapurl() == null || been.getData().getWapurl().trim().equals("")){
                         intent = new Intent(FirstActivity.this, LoopActivity.class);
//                        intent.putExtra("url","https://apk-skyping.zz-app.com/link.html");
                    }else {
                        intent = new Intent(FirstActivity.this,BaseWebActivity.class);
                        url = been.getData().getWapurl();
                        intent.putExtra("url",url);
                    }

                }else {  //不展示
                    intent = new Intent(FirstActivity.this,Login1Activity.class);
                    url = "http://m.500.com/chart/ssq/yilou.html?_t=417";
                    intent.putExtra("title","pk10资讯");
                    intent.putExtra("url",url);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        finish();
                    }
                },500);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        intent = new Intent(FirstActivity.this,Login1Activity.class);
                        url = "http://m.500.com/chart/ssq/yilou.html?_t=417";
                        intent.putExtra("title","pk10资讯");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        finish();
                    }
                },1000);
            }
        });
        Volley.newRequestQueue(this).add(request);
    }

}
