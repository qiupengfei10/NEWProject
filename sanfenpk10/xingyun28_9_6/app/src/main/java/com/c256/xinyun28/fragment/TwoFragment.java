package com.c256.xinyun28.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.c256.xinyun28.BaseWebActivity;
import com.c256.xinyun28.R;

/**
 * Created by qiupengfei on 2017/8/11.
 */
@SuppressLint("ValidFragment")
public class TwoFragment extends BaseFragment{
    private View view;
    private WebView webView;
    private String url;

    public TwoFragment(String url){
        this.url = url;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_webview,null);
        webView = (WebView) view.findViewById(R.id.webView);
        initData();
        return view;
    }

    private void initData() {
        Log.w("qpf","url  == " + url);


        //声明WebSettings子类
        WebSettings webSettings = webView.getSettings();

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setDomStorageEnabled(true);

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
                Log.e("qpf","url  ===  " + url);
                //不让其登录
                if(url.contains("500")){
                    if (url.contains("http://m.500.com/info/kaijiang/moreexpect/pls/?from=more")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","更多期次");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("http://m.500.com/info/kaijiang/pls/")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","最新开奖");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("http://m.500.com/datachart/pls/?from=kaijiang")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","走势图");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("mczhuanti") || url.contains("openplatform")){
                        //最新开奖 Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","资讯详情");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if(url.contains("http://m.500.com/index.php?c=article&a=shahao&sid=28")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","专家杀号");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if(url.contains("login")){
                        return true;
                    }else if (url.contains("http://m.500.com/info/article/")){
                        if (url.contains("631-17.shtml")){
                            url = "http://m.500.com/info/article/luantan-639.shtml";
                        }
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("url",url);
                        intent.putExtra("title","吐槽详情");
                        startActivity(intent);
                        return true;
                    }else if((url.contains("http://m.500.com/datachart/"))){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","走势图");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("http://m.500.com/mczhuanti/n_zaobao/index.shtml")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("url",url);
                        intent.putExtra("title","彩票日报");
                        startActivity(intent);
                    }else {
                        return true;
                    }
                } if(url.contains("500") && (!url.contains("http://m.500.com/datachart/"))){
                    return true;
                }else if (url.contains(".apk")) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    Uri content_url = Uri.parse(url);
                    intent.setData(content_url);
                    startActivity(intent);
                    return false;
                }else if (url.contains("baidu") || url.contains("500.com")){
                    Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                    url = "http://m.500.com/lottery/help/pls_help.html";
                    intent.putExtra("url",url);
                    intent.putExtra("title","玩法介绍");
                    startActivity(intent);
                    return true;
                }else {
                    Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                    return true;
                }
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
}
