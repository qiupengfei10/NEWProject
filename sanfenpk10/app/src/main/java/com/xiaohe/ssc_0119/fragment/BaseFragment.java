package com.xiaohe.ssc_0119.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.xiaohe.ssc_0119.R;

/**
 * Created by qiupengfei on 2017/8/11.
 */
public class BaseFragment extends Fragment implements View.OnClickListener{


    private ConnectivityManager manager;
    private View view;
    private static AlertDialog alertDialog;

    public void showToast(String text) {
        Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
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
        manager = (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        //去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        return flag;
    }

    public void showLoading() {
        if (alertDialog == null){
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            view = LayoutInflater.from(getActivity()).inflate(R.layout.loading_layout,null);
            builder.setView(view);
            builder.setCancelable(false);
            alertDialog = builder.show();
        }
    }

    public void dismissLoading() {
        if (alertDialog != null){
            alertDialog.dismiss();
            alertDialog = null;
        }
    }
}
