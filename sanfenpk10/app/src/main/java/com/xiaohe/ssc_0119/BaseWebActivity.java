package com.xiaohe.ssc_0119;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class BaseWebActivity extends BaseActivity {

    private WebView webView;
    private String url;
    private String title;
    private boolean isRun = true;
    private long startTime = System.currentTimeMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_web);
        initTitleView();
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        initView();
        initData();
        if (url.contains("http://m.aicai.com/zst")){
            //走势图
            findViewById(R.id.tv_bottom).setVisibility(View.VISIBLE);

            findViewById(R.id.tv_bottom).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    url = "http://m.500.com/info/index.php?c=zhongjiang&a=ssq&0_uc_uctj";
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("url",url);
                    intent.putExtra("title","模拟投注");
                    startActivity(intent);
                    finish();
                }
            });
        }
    }

    private void initView() {
        webView = (WebView)findViewById(R.id.webView);


        //声明WebSettings子类
        WebSettings webSettings = webView.getSettings();

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setDomStorageEnabled(true);
    }


    private void initData() {
        findViewById(R.id.ll).setVisibility(View.GONE);
        if (title != null && !title.equals("")){
            findViewById(R.id.ll).setVisibility(View.VISIBLE);
        }
        mTvTitle.setText(title);
//        mTvTitle.setVisibility(View.GONE);

        if (!checkNetworkState()){
            webView.setVisibility(View.GONE);
            showToast("当前无网络，请连接网络重试！");
        }else if (url != null && url.contains("6769")){
            findViewById(R.id.tv_title).setVisibility(View.GONE);
        }else{
            findViewById(R.id.tv_title).setVisibility(View.VISIBLE);
        }
        //方式1. 加载一个网页：
        webView.loadUrl(url);
        //步骤3. 复写shouldOverrideUrlLoading()方法，使得打开网页时不调用系统浏览器， 而是在本WebView中显示
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //开始加载
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("qpf","url ========= [ " +url+ "]");
                //不让其登录
               if (url.contains("weixin://wap/pay?")
                        ||url.contains("mqqapi://forward/url?url_prefix")
                        ||url.contains("alipays://platformapi/startapp?")){ // 打开微信支付
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }else if (url.contains("newInfo/newsDetail")){
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("title","资讯详情");
                    intent.putExtra("url",url);
                    startActivity(intent);
                    return true;
                }else if (url.contains("http://m.aicai.com/m/login.do?agentId=1&vt=5")){
                    url = "http://m.500.com/info/index.php?c=zhongjiang&a=ssq&0_uc_uctj";
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("url",url);
                    intent.putExtra("title","模拟投注");
                    startActivity(intent);
                    finish();
                    return true;
                }else if (url.contains("m.aicai.com") || url.contains("http://m.ttyingqiu.com/static/jcob/html/index_app.html?agentId=2335038")){
                    return true;
                }else if (url.contains("http://crazybet.choopaoo.com/crazyland/crazyapp.html?from=touch-zst")){
                    return super.shouldOverrideUrlLoading(view, url);
                }else if (url.contains("m.159cai.com")){
                    if (url.contains("http://m.159cai.com/jczq/jchh.html")){
                        url = "http://m.500.com/info/index.php?c=zhongjiang&a=ssq&0_uc_uctj";
                        Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                        intent.putExtra("url",url);
                        intent.putExtra("title","模拟投注");
                        startActivity(intent);
                        finish();
                        return true;
                    }else {
                        Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                        url = "http://m.500.com/lottery/help/pls_help.html";
                        intent.putExtra("url",url);
                        intent.putExtra("title","介绍");
                        startActivity(intent);
                        return true;
                    }
                }else if (url.contains("article/detail")){
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("title","详情");
                    intent.putExtra("url",url);
                    startActivity(intent);
                    return true;
                }else if (url.contains("http://m.500.com/info/kaijiang/moreexpect/pls/?from=more")){
                    url = "http://m.500.com/info/kaijiang/moreexpect/pls/?from=more";
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("title","更多期次");
                    intent.putExtra("url",url);
                    startActivity(intent);
                    return true;
                }else if (url.contains("http://m.500.com/datachart/pls/?from=kaijiang")){
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("title","走势图");
                    intent.putExtra("url",url);
                    startActivity(intent);
                    return true;
                }else if (url.contains("http://m.500.com/helpcenter/submituserproblem/")){
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("url",url);
                    intent.putExtra("title","反馈中心");
                    startActivity(intent);
                    return true;
                }else if (url.contains("http://m.500.com/user/index.php?c=home&a=login&backurl=http%3A%2F%2Fm.500.com%2Finfo")){
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    url = "http://m.500.com/helpcenter/submituserproblem/";
                    intent.putExtra("url",url);
                    intent.putExtra("title","反馈中心");
                    startActivity(intent);
                    return true;
                }else if (url.contains("http://m.500.com/helpcenter/userproblem/")){
                    Toast.makeText(BaseWebActivity.this,"暂无反馈意见！",Toast.LENGTH_SHORT).show();
                    return true;
                }else if (url.contains("http://m.500.com/user/index.php?c=home&a=login&backurl=http%3A%2F%2Fm.500.com%2Fhelpcenter%2Fsubmituserproblem%2F")){
                    Toast.makeText(BaseWebActivity.this,"您的反馈内容已提交，感谢您的支持！",Toast.LENGTH_SHORT).show();
                    finish();
                }else if (url.contains("http://m.500.com/lottery/help/pls_help.html")){
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("url",url);
                    intent.putExtra("title","玩法介绍");
                    startActivity(intent);
                    return true;
                }else if (url.contains("author.baidu.com/home/")){
                    url = "http://m.500.com/info/kaijiang/moreexpect/pls/?from=more";
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("title","更多期次");
                    intent.putExtra("url",url);
                    startActivity(intent);
                    return true;
                }else if (url.contains("openplatform/#/")){
                    url = "http://m.500.com/info/article/luantan-633.shtml";
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("url",url);
                    intent.putExtra("title","吐槽详情");
                    startActivity(intent);
                    finish();
                    return true;
                }else if(url.contains("500") && url.contains("login")){
                    url = "http://m.500.com/info/kaijiang/moreexpect/pls/?from=more";
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("title","更多期次");
                    intent.putExtra("url",url);
                    startActivity(intent);
                    return true;
                }else if (url.contains("http://m.500.com/info/article/")){
                    url = "http://m.500.com/info/kaijiang/pls/";
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("title","更多期次");
                    intent.putExtra("url",url);
                    startActivity(intent);
                    return true;
                }else if (url.contains("crazybet.choopaoo.com")||url.contains(".apk")) {
//                    Intent intent = new Intent();
//                    intent.setAction("android.intent.action.VIEW");
//                    Uri content_url = Uri.parse(url);
//                    intent.setData(content_url);
//                    startActivity(intent);
                    return true;
                }else if ("http://m.500.com/info/index.php?c=zhongjiang&a=ssq&0_uc_uctj".contains(url) || url.contains("http://m.500.com/info/index.php?c=zhongjiang&a=dlt&0_uc_uctj")){
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("url",url);
                    intent.putExtra("title","模拟投注");
                    startActivity(intent);
                    finish();
                    return true;
                }else if (url.contains("http://m.500.com/datachart/")){
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    intent.putExtra("url",url);
                    intent.putExtra("title","走势图");
                    startActivity(intent);
                    return true;
                }else if (url.contains("baidu") || url.contains("500.com")){
                    Intent intent = new Intent(BaseWebActivity.this,BaseWebActivity.class);
                    url = "http://m.500.com/lottery/help/pls_help.html";
                    intent.putExtra("url",url);
                    intent.putExtra("title","玩法介绍");
                    startActivity(intent);
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        showLoading();
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO 自动生成的方法存根
                if (newProgress == 100){
                    dismissLoading();
                }

            }
        });
    }

    //设置返回键动作（防止按返回键直接退出程序)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO 自动生成的方法存根
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            if(webView.canGoBack()) {//当webview不是处于第一页面时，返回上一个页面
                webView.goBack();
                return true;
            }
            else {//当webview处于第一页面时,直接退出程序
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
