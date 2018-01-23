package com.xiaohe.ssc_0119.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaohe.ssc_0119.R;
import com.xiaohe.ssc_0119.ScratchTextView;

public class TestActivity extends AppCompatActivity {


    private ScratchTextView scratchTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        scratchTv = (ScratchTextView) findViewById(R.id.tv1);

        scratchTv = (ScratchTextView) findViewById(R.id.tv1);
        scratchTv.beginRubbler(40,
                1f , "100元");
    }
}
