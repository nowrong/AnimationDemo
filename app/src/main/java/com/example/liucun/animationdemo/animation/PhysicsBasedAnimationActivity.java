package com.example.liucun.animationdemo.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.liucun.animationdemo.R;
import com.example.liucun.animationdemo.animation.fragment.BasePhysicsFragment;
import com.example.liucun.animationdemo.animation.fragment.ChainFragment;
import com.example.liucun.animationdemo.animation.fragment.TranslationFragment;

/**
 * Created by LiuCun on 2017/11/6.<br>
 * Describe
 */

public class PhysicsBasedAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);
        findViewById(R.id.bt_base).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, new BasePhysicsFragment())
                        .commit();
            }
        });
        findViewById(R.id.bt_translation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, new TranslationFragment())
                        .commit();
            }
        });
        findViewById(R.id.bt_chained).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, new ChainFragment())
                        .commit();
            }
        });
    }
}
