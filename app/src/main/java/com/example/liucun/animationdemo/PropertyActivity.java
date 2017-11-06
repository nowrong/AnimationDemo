package com.example.liucun.animationdemo;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LiuCun on 2017/11/1.<br>
 * Describe
 */

public class PropertyActivity extends AppCompatActivity {

    @BindView(R.id.bt_alpha)
    Button bt_alpha;
    @BindView(R.id.bt_scale)
    Button bt_scale;
    @BindView(R.id.bt_rotate)
    Button bt_rotate;
    @BindView(R.id.bt_translate)
    Button bt_translate;
    @BindView(R.id.tv_anim)
    TextView anim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_alpha)
    void alphaAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1, 0.5f);
        valueAnimator.setDuration(1000);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                anim.setAlpha((Float) animation.getAnimatedValue());
                Log.e("----", "onAnimationUpdate: " + animation.getAnimatedValue());
            }
        });
    }
}
