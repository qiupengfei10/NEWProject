package com.c256.xinyun28.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.c256.xinyun28.BaseActivity;
import com.c256.xinyun28.R;

public class ImageActivity extends BaseActivity {
    private ImageView ivContent;
    private int imageId;

    private TextView tvTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ivContent = (ImageView) findViewById(R.id.iv_content);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        imageId = getIntent().getIntExtra("imageId",-1);
        tvTitle.setText(getIntent().getStringExtra("title"));

        ivContent.setImageResource(imageId);
    }
}
