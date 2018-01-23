package com.xiaohe.ssc_0119.fragment;

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
import android.widget.Toast;

import com.xiaohe.ssc_0119.BaseWebActivity;
import com.xiaohe.ssc_0119.R;

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
        Log.e("qpf","url ============ " + url);
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
                if (url.contains("http://www.159cai.com/user/reg.html")){
                    showToast("活动已过期！");
                    return true;
                }else if (url.contains("http://m.159cai.com/kj1/")){
                    Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                    intent.putExtra("title","开奖走势图");
                    intent.putExtra("url",url);
                    startActivity(intent);
                    return true;
                }else if (url.contains("http://m.159cai.com/gd/gdxq.html?hid=")){
                    return true;
                }else if (url.contains("http://m.cpz666.com/index?agentId=100335")){
                    Toast.makeText(getActivity(),"红包已领取，请关闭该窗口后再进行后续操作！",Toast.LENGTH_SHORT).show();
                    return true;
                }else if (url.contains("m.aicai.com/zst")){
                    //走势图
                    Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                    intent.putExtra("title","走势图");
                    intent.putExtra("url",url);
                    startActivity(intent);
                    return true;
                }else if (url.contains("/f/filterCode.do?")){
                    //
                    Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                    url = "http://m.500.com/index.php?c=article&a=shahao&sid=28";
                    intent.putExtra("title","专家杀号");
                    intent.putExtra("url",url);
                    startActivity(intent);
                    return true;
                }else if (url.contains("m.aicai.com")){
                    Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                    intent.putExtra("url",url);
                    if (url.contains("newInfo") || url.contains("newDetail")){
                        intent.putExtra("title","资讯详情");
                    }else if (url.contains("kaijiang")){
                        intent.putExtra("title","更多期次");
                    }
                    startActivity(intent);
                    return true;
                }else if (url.contains("jjdwc_10655_1110") || url.contains(".apk")){
                    return true;
                }else if (url.contains("m.159cai.com")){
                    if (url.contains("huodong")){
                        url = "http://mapi.159cai.com/discovery/notice/2017/0906/29790.html";
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","平台公告");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("fzb.html")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","比分直播");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("kjxx/")){
                        url = "http://m.500.com/info/kaijiang/moreexpect/pls/?from=more";
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","开奖信息");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("3d")
                            ||url.contains("dlt")
                            ||url.contains("dlt")
                            ||url.contains("ssq")
                            ||url.contains("zc")
                            ||url.contains("bd")
                            ||url.contains("jclq")
                            ||url.contains("jczq")
                            ||url.contains("k3")
                            ||url.contains("ssc")
                            ||url.contains("11x5")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        url = "http://m.500.com/datachart/ssq/jb.html";
                        intent.putExtra("title","走势图");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("http://m.159cai.com/gong/index.html")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","公告");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("http://m.159cai.com/gong/news.html")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","新闻资讯");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("http://m.159cai.com/gong/dailycontest.html")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        intent.putExtra("title","每日竞猜");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("gid=70&iupload=1&type=1") || url.contains("originator") || url.contains("ttp://m.159cai.com/gd/gdfd.html")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        url = "http://m.500.com/index.php?c=article&a=shahao&sid=28";
                        intent.putExtra("title","复制跟单");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;
                    }else if (url.contains("http://m.159cai.com/log/login.html")){
                        Intent intent = new Intent(getActivity(),BaseWebActivity.class);
                        url = "http://m.500.com/datachart/";
                        intent.putExtra("title","我的");
                        intent.putExtra("url",url);
                        startActivity(intent);
                        return true;

                    }

                }else if(url.contains("500")){
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
