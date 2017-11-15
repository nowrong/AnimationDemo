package com.android.pkqup.androidnote.abase;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.View;

import com.android.pkqup.androidnote.R;
import com.android.pkqup.androidnote.activity_test.ActivityTestActivity;
import com.android.pkqup.androidnote.animation_test.FrameActivity;
import com.android.pkqup.androidnote.animation_test.PhysicsBasedAnimationActivity;
import com.android.pkqup.androidnote.animation_test.PropertyActivity;
import com.android.pkqup.androidnote.animation_test.TweenActivity;
import com.android.pkqup.androidnote.broadcast_receiver_test.BroadcastReceiverActivity;
import com.android.pkqup.androidnote.content_provider_test.ContentProviderActivity;
import com.android.pkqup.androidnote.fragment_test.FragmentTestActivity;
import com.android.pkqup.androidnote.handler_test.HandlerThreadTestActivity;
import com.android.pkqup.androidnote.service_test.ServiceTestOneActivity;
import com.android.pkqup.androidnote.touch_event_test.TouchTestActivity;
import com.android.pkqup.androidnote.view_draw_test.ViewDrawTestActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_frame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FrameActivity.class));
            }
        });
        findViewById(R.id.bt_tween).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TweenActivity.class));
            }
        });
        findViewById(R.id.bt_property).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PropertyActivity.class));
            }
        });
        findViewById(R.id.bt_physics).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PhysicsBasedAnimationActivity.class));
            }
        });
        findViewById(R.id.bt_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FragmentTestActivity.class));
            }
        });
        findViewById(R.id.bt_handler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HandlerThreadTestActivity.class));
            }
        });
        findViewById(R.id.bt_touch_dispatch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TouchTestActivity.class));
            }
        });
        findViewById(R.id.bt_view_draw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewDrawTestActivity.class));
            }
        });
        findViewById(R.id.bt_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivityTestActivity.class));
            }
        });
        findViewById(R.id.bt_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BroadcastReceiverActivity.class));
            }
        });
        findViewById(R.id.bt_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ServiceTestOneActivity.class));
            }
        });
        findViewById(R.id.bt_content_provider).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContentProviderActivity.class));
            }
        });
    }


    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }

}
