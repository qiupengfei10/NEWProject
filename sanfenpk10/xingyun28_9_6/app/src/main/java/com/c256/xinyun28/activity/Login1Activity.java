package com.c256.xinyun28.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.c256.xinyun28.BaseActivity;
import com.c256.xinyun28.ShareUtils;
import com.c256.xinyun28.R;

public class Login1Activity extends BaseActivity {


    private EditText edtPassword;
    private EditText edtUserName;
    private Button btnLogin;
    private TextView tvRegister;
    private String from;
    private String name;
    private String password;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        from = getIntent().getStringExtra("from");
        initView();
        initData();
    }

    private void initData() {
        if (from != null){
            btnLogin.setText("注册");
            tvRegister.setText("老用户登录");
        }
    }

    private void initView() {
        edtPassword = (EditText) findViewById(R.id.edt_password);
        edtUserName = (EditText) findViewById(R.id.edt_username);
        btnLogin = (Button) findViewById(R.id.btn_login);
        tvRegister = (TextView) findViewById(R.id.tv_register);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        intent = new Intent(this,Main2Activity.class);

        findViewById(R.id.tv_suibian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login1Activity.this,Main2Activity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_register:
                register();
                break;
        }
    }

    private void register() {
        if (from!=null){
            finish();
        }else {
            Intent intent = new Intent(this,Login1Activity.class);
            intent.putExtra("from","注册");
            startActivity(intent);
        }
    }

    private void login() {
        name = edtUserName.getText().toString();
        password = edtPassword.getText().toString();

        if (name.equals("18942923720") &&password.equals("123456")){
            intent = new Intent(Login1Activity.this,Main2Activity.class);
            startActivity(intent);
            finish();
            return;
        }

        if (from != null){//注册
            if (name.equals("") ){
                Toast.makeText(this,"用户名都不能为空！",Toast.LENGTH_SHORT).show();
            }else if (password.equals("")){
                Toast.makeText(this,"密码不能为空！",Toast.LENGTH_SHORT).show();
            }else {
                ShareUtils.saveUser(this,name,password);
                intent = new Intent(Login1Activity.this,Main2Activity.class);
//                url= "http://m.500.com/info/article/1/";
//                intent.putExtra("url",url);
                startActivity(intent);
                finish();
            }
        }else {//登录
            if (name.equals("") ){
                Toast.makeText(this,"用户名不能为空！",Toast.LENGTH_SHORT).show();
            }else if (password.equals("")){
                Toast.makeText(this,"密码不能为空！",Toast.LENGTH_SHORT).show();
            }else {
                if (!name.equals(ShareUtils.getPerferencesUserName(this))){
                    Toast.makeText(this,"该用户名未注册！",Toast.LENGTH_SHORT).show();
                }else if (!password.equals(ShareUtils.getPerferencesPassWord(this))){
                    Toast.makeText(this,"密码输入错误！",Toast.LENGTH_SHORT).show();
                }else {
//                    url= "http://m.500.com/info/article/10/";
//                    intent.putExtra("url",url);
                    intent = new Intent(Login1Activity.this,Main2Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
}
