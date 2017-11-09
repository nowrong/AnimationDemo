package com.android.pkqup.androidnote.handler_test;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import com.android.pkqup.androidnote.R;
import com.android.pkqup.androidnote.abase.BaseActivity;

/**
 * Created by LiuCun on 2017/11/9.<br>
 * Describe
 */

public class HandlerThreadTestActivity extends BaseActivity {

    private HandlerThread handlerThread;//子线程
    private Handler childHandler;//与子线程关联的Handler
    private Handler.Callback callback = new Handler.Callback() {//子线程处理耗时操作的回调
        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread_test);
        initHandlerThread();
        getData();
    }

    private void initHandlerThread() {
        handlerThread = new HandlerThread("child_thread");  //构造参数为子线程的线程名
        handlerThread.start();//开启子线程
        childHandler = new Handler(handlerThread.getLooper(),callback);//初始化子线程的Handler
    }

    private void getData() {
        childHandler.sendEmptyMessage(0);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放资源
        handlerThread.quit() ;
    }
}