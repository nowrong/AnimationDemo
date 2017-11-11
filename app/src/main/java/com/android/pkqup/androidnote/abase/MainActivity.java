package com.android.pkqup.androidnote.abase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.View;

import com.android.pkqup.androidnote.R;
import com.android.pkqup.androidnote.animation_test.FrameActivity;
import com.android.pkqup.androidnote.animation_test.PhysicsBasedAnimationActivity;
import com.android.pkqup.androidnote.animation_test.PropertyActivity;
import com.android.pkqup.androidnote.animation_test.TweenActivity;
import com.android.pkqup.androidnote.fragment_test.FragmentTestActivity;
import com.android.pkqup.androidnote.touch_event_test.TouchTestActivity;

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
        findViewById(R.id.bt_touch_dispatch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TouchTestActivity.class));

            }
        });
 findViewById(R.id.bt_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TouchTestActivity.class));

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
