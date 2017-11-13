package com.android.pkqup.androidnote.service_test;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.pkqup.androidnote.R;
import com.android.pkqup.androidnote.abase.BaseActivity;

/**
 * Created by LiuCun on 2017/11/13.<br>
 * Describe
 */

public class ServiceTestOneActivity extends BaseActivity {

    private TextView textViewOne;
    private TextView textViewTwo;

    private MyService myService;
    private MyService.MyBinder myBinder;

    private MyReceiver myReceiver;
    private ServiceConnection connection = new ServiceConnection() {

        public static final String TAG = "ServiceConnection";

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // 服务断开连接
            Log.e(TAG, "onServiceDisconnected() executed");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 服务连接成功，可得到IBinder对象,也可以通过IBinder得到Service实例
            Log.e(TAG, "onServiceConnected() executed");
            myBinder = (MyService.MyBinder) service;
            myService = myBinder.getService();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);

        textViewOne = findViewById(R.id.tv_one);
        textViewTwo = findViewById(R.id.tv_two);

        Log.e("ServiceTestOneActivity",
                "ServiceTestOneActivity thread id is " + Thread.currentThread().getId());
        initBroadcast();

        findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(ServiceTestOneActivity.this, MyService.class);
                startService(startIntent);
            }
        });

        findViewById(R.id.bt_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopIntent = new Intent(ServiceTestOneActivity.this, MyService.class);
                stopService(stopIntent);
            }
        });

        findViewById(R.id.bt_bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 这里传入BIND_AUTO_CREATE表示在Activity和Service建立关联后自动创建Service，
                // 这会使得MyService中的onCreate()方法得到执行，但onStartCommand()方法不会执行。
                Intent bindIntent = new Intent(ServiceTestOneActivity.this, MyService.class);
                bindService(bindIntent, connection, Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.bt_unbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkServiceIsBind();
            }
        });

        findViewById(R.id.bt_do_work).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != myService && null != myBinder) {
                    myService.doSomeThing();
                    myBinder.doWork();
                }
            }
        });

        findViewById(R.id.bt_intent_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceTestOneActivity.this, MyIntentService.class);
                intent.setAction(MyIntentService.ACTION_ONE);
                startService(intent);
            }
        });
        findViewById(R.id.bt_intent_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceTestOneActivity.this, MyIntentService.class);
                intent.setAction(MyIntentService.ACTION_TWO);
                startService(intent);
            }
        });


    }

    // 注册普通广播
    private void initBroadcast() {
        myReceiver = new MyReceiver();
        registerReceiver(myReceiver, new IntentFilter(MyIntentService.ACTION_BROADCAST));
    }

    private void checkServiceIsBind() {
        if (null != myService && myService.isServiceBind) {
            myService = null;
            myBinder = null;
            unbindService(connection);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        checkServiceIsBind();
    }


    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                case MyIntentService.ACTION_BROADCAST:
                    if (intent.getIntExtra("type", 0) == 0) {
                        textViewOne.setText(intent.getIntExtra("progress", 0) + "");
                    } else {
                        textViewTwo.setText(intent.getIntExtra("progress", 0) + "");
                    }
                    break;
            }
        }
    }

}
