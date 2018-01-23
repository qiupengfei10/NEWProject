package com.xiaohe.ssc_0119;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiupengfei on 2018/1/22.
 *
 * 球
 */
public class BallView {

    private List<TextView> textViews = new ArrayList<>();

    public BallView(Context mContext,String[] integers,LinearLayout llParent,CallBack callback) {
        for (String i:integers) {
            TextView textView = new TextView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(60, 60);
            params.rightMargin = 10;
            textView.setTextSize(12);
//            textView.setPadding(10,10,10,10);
            textView.setText(i);
            textView.setGravity(Gravity.CENTER);
            params.gravity = Gravity.CENTER;
            textView.setTextColor(mContext.getResources().getColor(R.color.bg_white));
            textViews.add(textView);
            textView.setLayoutParams(params);
            llParent.addView(textView);
        }
        callback.setColor(textViews);
    }

    public interface CallBack{
        void setColor(List<TextView> textView);
    }
}
