package com.xiaohe.ssc_0119;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BaseActivity extends FragmentActivity implements View.OnClickListener {
    protected TextView mTvTitle;
    private ConnectivityManager manager;
    private View view;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initTitleView();
    }

    protected void initTitleView(){
        mTvTitle = (TextView) findViewById(R.id.tv_title);
    }


    public void showToast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (checkNetworkState()){  //没有网络的情况
            showToast("当前网络不佳，移动手机位置后重新试一试！");
            return;
        }
    }

    /**
     * 检测网络是否连接
     * @return
     */
    protected boolean checkNetworkState() {
        boolean flag = false;
        //得到网络连接信息
        manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        return flag;
    }

    public void showLoading() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        view = LayoutInflater.from(this).inflate(R.layout.loading_layout,null);
        builder.setView(view);
        builder.setCancelable(false);
        alertDialog = builder.show();
    }

    public void dismissLoading() {
        if (alertDialog != null){
            alertDialog.dismiss();
            alertDialog = null;
        }
    }

    public void goneTitle(){
        findViewById(R.id.title).setVisibility(View.GONE);
    }
}
