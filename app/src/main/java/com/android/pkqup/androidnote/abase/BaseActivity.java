package com.android.pkqup.androidnote.abase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by LiuCun on 2017/11/7.<br>
 * Describe
 */

public class BaseActivity extends AppCompatActivity {

    public static String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        //注入要在setContentView()方法之后调用
        ButterKnife.bind(this);
    }
}