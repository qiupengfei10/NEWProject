package com.c256.xinyun28;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by qiupengfei on 2017/7/17.
 */
public class ShareUtils {

    public static void save(Context context,String index) {
        //获得SharedPreferences对象
        SharedPreferences preferences = context.getSharedPreferences("qpf", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("index", index);
        editor.commit();
    }

    public static String getPerferences(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("qpf", Context.MODE_PRIVATE);
        return preferences.getString("index", "");
    }

    public static void saveUser(Context context,String userName,String passWord) {
        //获得SharedPreferences对象
        SharedPreferences preferences = context.getSharedPreferences("qpf", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userName", userName);
        editor.putString("passWord", passWord);
        editor.commit();
    }

    public static String getPerferencesUserName(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("qpf", Context.MODE_PRIVATE);
        return preferences.getString("userName", "");
    }

    public static String getPerferencesPassWord(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("qpf", Context.MODE_PRIVATE);
        return preferences.getString("passWord", "");
    }

}
