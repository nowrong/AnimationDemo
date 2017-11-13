package com.android.pkqup.androidnote.service_test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by LiuCun on 2017/11/13.<br>
 * Describe
 */

public class MyTestService extends Service {

    public static final String TAG = "MyService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate() executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand() executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy() executed");
    }

    //返回具体的IBind对象
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
