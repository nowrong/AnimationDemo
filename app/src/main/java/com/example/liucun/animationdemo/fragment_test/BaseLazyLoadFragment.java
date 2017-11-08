package com.example.liucun.animationdemo.fragment_test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liucun.animationdemo.R;

/**
 * Created by LiuCun on 2017/11/7.<br>
 * Describe
 */

public class BaseLazyLoadFragment extends Fragment {

    private boolean mIsInited;//数据是否加载完成
    private boolean mIsPrepared;//UI是否准备完成

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fragment_first, container, false);
        mIsPrepared = true;
        lazyLoad();
        return mRootView;
    }

    public void lazyLoad() {
        if (getUserVisibleHint() && mIsPrepared && !mIsInited) {
            // 异步初始化，在初始化后显示正常UI
            loadData();
        }
    }

    private void loadData() {
        new Thread() {
            public void run() {
                // 1. 加载数据
                // 2. 更新UI
                // 3. mIsInited = true
                mIsInited = true;
            }
        }.start();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoad();
        }
    }

}
