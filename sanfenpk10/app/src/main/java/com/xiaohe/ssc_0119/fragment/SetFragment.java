package com.xiaohe.ssc_0119.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaohe.ssc_0119.BaseWebActivity;
import com.xiaohe.ssc_0119.R;

/**
 * Created by qiupengfei on 2017/12/7.
 *
 * 设置
 */
public class SetFragment extends Fragment implements View.OnClickListener{
    private View view;
    private View table1;
    private View table2;
    private View table3;
    private View table4;
    private View table5;
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_set,null);
        initView();
        return view;

    }

    private void initView() {
        table1 = view.findViewById(R.id.table1);
        table2 = view.findViewById(R.id.table2);
        table3 = view.findViewById(R.id.table3);
        table4 = view.findViewById(R.id.table4);
        table5 = view.findViewById(R.id.table5);

        tv = (TextView) view.findViewById(R.id.tv);

        table1.setOnClickListener(this);
        table2.setOnClickListener(this);
        table3.setOnClickListener(this);
        table4.setOnClickListener(this);
        table5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.table1:
                break;
            case R.id.table2:
                Toast.makeText(getActivity(),"已清除！",Toast.LENGTH_SHORT).show();
                tv.setText("0 M");
                break;
            case R.id.table3:
                intent = new Intent(getActivity(), BaseWebActivity.class);
                intent.putExtra("title","客服");
                intent.putExtra("url","https://webpage.qidian.qq.com/2/chat/h5/index.html?linkType=1&env=ol&kfuin=2852151227&kfext=2852151227&fid=99&key=213c684e2be9f12a0ab3f218d5f5d310&cate=7&type=10&ftype=1&roleKey=roleIM&roleValue=0&roleName=&roleData=2852369558&roleUin=2852369558&_type=wpa");
                getActivity().startActivity(intent);
                break;
            case R.id.table4:
                intent = new Intent(getActivity(), BaseWebActivity.class);
                intent.putExtra("title","意见反馈");
                intent.putExtra("url","http://m.500.com/helpcenter/submituserproblem/");
                getActivity().startActivity(intent);
                break;
            case R.id.table5:
                System.exit(0);
                break;
        }
    }
}
