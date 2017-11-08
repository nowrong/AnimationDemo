package com.android.pkqup.androidnote.touch_event_test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by LiuCun on 2017/11/8.<br>
 * Describe
 */

public class MyLinearLayout extends LinearLayout {
    public MyLinearLayout(Context context) {
        this(context, null);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("MyLinearLayout", "dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("MyLinearLayout", "onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("MyLinearLayout", "onTouchEvent");
        return super.onTouchEvent(event);
    }
}
