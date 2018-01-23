package com.c256.xinyun28;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiupengfei on 2017/8/21.
 */
public class MyTableView {
    private List<TextView> tv_names = new ArrayList<>();
    private List<TextView> tv_lines = new ArrayList<>();
    private Context context;

    public MyTableView(Context context) {
        this.context = context;
    }

    /**
     * 设置导航菜单的内容
     * @param ll_table 父控件
     * @param names 菜单名
     * @param callback 回调监听
     * @return 返回的是每个菜单项的TextView 集合
     */
    public void setTableViewContent(LinearLayout ll_table,List<String> names,OnItemClickListener callback) {
        //清除导航栏中所有内容
        ll_table.removeAllViews();
        for (int i = 0;i<names.size();i++){
            addTable(context,ll_table,names.get(i),i,callback);
        }
    }

    /**
     * 设置导航菜单的内容
     * @param ll_table 父控件
     * @param names 菜单名
     * @param callback 回调监听
     * @return 返回的是每个菜单项的TextView 集合
     */
    public void setTableViewContent(LinearLayout ll_table,String[] names,OnItemClickListener callback) {
        ll_table.removeAllViews();
        for (int i = 0;i<names.length;i++){
            addTable(context,ll_table,names[i],i,callback);
        }
    }

    /**
     * 向ll_table添加菜单
     * @param name 菜单名
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void addTable(final Context context, LinearLayout ll_table, String name, final int position, final OnItemClickListener callback){
        try{
//            ll_table.setElevation(2f);  //部分手机存在问题
        }catch (Exception e){
//            Log.e("qpf","[部分手机存在问题]");
        }
        RelativeLayout rl = new RelativeLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        rl.setLayoutParams(params);
        //导航栏文字
        final TextView tv_name = new TextView(context);
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params1.addRule(RelativeLayout.CENTER_IN_PARENT);
        tv_name.setText(name);
        tv_name.setLayoutParams(params1);
        if (position != 0){
            tv_name.setTextColor(context.getResources().getColor(R.color.black_text));
        }else {
            tv_name.setTextColor(context.getResources().getColor(R.color.main_color));
        }
        rl.addView(tv_name);
        tv_names.add(tv_name);
        //导航栏下划线
        final TextView tv_line = new TextView(context);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 5);
        params2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params2.leftMargin = 20;
        params2.rightMargin = 20;
        tv_line.setLayoutParams(params2);
        tv_line.setBackgroundColor(context.getResources().getColor(R.color.main_color));
        if (position != 0){
            tv_line.setVisibility(View.GONE);
        }
        rl.addView(tv_line);
        tv_lines.add(tv_line);
        ll_table.addView(rl);

        //设置监听
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将所有的置为默认转态
                resetDefault(context);
                tv_name.setTextColor(context.getResources().getColor(R.color.main_color));
                tv_line.setVisibility(View.VISIBLE);

                //业务逻辑
                callback.click(tv_name,position);
            }
        });
    }

    /**
     * 将所有的置为默认状态
     */
    private void resetDefault(Context context) {
        for (int i = 0;i < tv_names.size();i++){
            tv_names.get(i).setTextColor(context.getResources().getColor(R.color.black_text));
            tv_lines.get(i).setVisibility(View.GONE);
        }
    }

    /**
     * 点击监听
     */
    public interface OnItemClickListener {
        void click(TextView tv,int position);
    }

    /**
     * 手动选则某项被选中
     * 这里主要用于导航栏按钮悬浮
     */
    public void setPositonCheck(Context context,int position) {
        for (int i = 0;i < tv_names.size();i++){
            if (position == i) {
                tv_names.get(i).setTextColor(context.getResources().getColor(R.color.main_color));
                tv_lines.get(i).setVisibility(View.VISIBLE);
            }else {
                tv_names.get(i).setTextColor(context.getResources().getColor(R.color.black_text));
                tv_lines.get(i).setVisibility(View.GONE);
            }

        }
    }
}
