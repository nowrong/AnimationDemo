package com.android.pkqup.androidnote.service_test;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by LiuCun on 2017/11/13.<br>
 * Describe
 */

public class MyIntentService extends IntentService {

    public static final String TAG = "MyIntentService";

    public MyIntentService() {
        // 线程的名称
        super("MyIntentService");
    }

    public MyIntentService(String name) {
        super(name);
    }

    public static final String ACTION_ONE = "action_one";
    public static final String ACTION_TWO = "action_two";
    public static final String ACTION_BROADCAST = "action_broad";
    private int progressOne, progressTwo;

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null)
            return;
        String action = intent.getAction();
        switch (action) {
            case ACTION_ONE:
                while (progressOne < 100) {
                    progressOne++;
                    sendBroadcast(getUpdateIntent(0, progressOne));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case ACTION_TWO:
                while (progressTwo < 100) {
                    progressTwo++;
                    sendBroadcast(getUpdateIntent(1, progressTwo));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy() executed");
    }

    private Intent getUpdateIntent(int i, int progress) {
        Intent intent = new Intent(ACTION_BROADCAST);
        intent.putExtra("type", i);
        intent.putExtra("progress", progress);
        return intent;
    }

}
