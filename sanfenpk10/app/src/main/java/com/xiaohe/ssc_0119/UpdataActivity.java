package com.xiaohe.ssc_0119;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xiaohe.ssc_0119.fragment.MyBeen;

/**
 * Created by qiupengfei on 2018/1/16.
 */
public class UpdataActivity extends Activity{

    private ImageView image;
    private UpdateAppManager manager;
    private MyBeen myBeen;
    private String apkUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);
        image = (ImageView)findViewById(R.id.image);
        myBeen = (MyBeen) getIntent().getSerializableExtra("myBeen");
        apkUrl = getIntent().getStringExtra("apkUrl");
        if (myBeen != null && myBeen.getData().getBackground() != null && !myBeen.getData().getBackground().trim().equals("")){
            Glide.with(this).load(myBeen.getData().getBackground()).into(image);
        }
        manager=new UpdateAppManager(this);
        if (apkUrl == null)
        apkUrl = myBeen.getData().getUpdateUrl();

        Log.e("qpf","apkUrl == "+apkUrl );
        manager.showDownloadDialog(apkUrl);//检查更新
    }

}
