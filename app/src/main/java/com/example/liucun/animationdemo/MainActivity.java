package com.example.liucun.animationdemo;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.img_dog);
    }

    public void methodXml(View view) {
        imageView.setImageResource(R.drawable.dog_anim);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.setOneShot(false);// 设置是否只循环一次，默认为false，表示无限循环
        animationDrawable.start();
        frameAnimationFinishListener(animationDrawable);
    }

    public void methodJavaCode(View view) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        int[] anims = new int[] {R.mipmap.dog_0, R.mipmap.dog_1, R.mipmap.dog_2, R.mipmap.dog_3,
                R.mipmap.dog_4, R.mipmap.dog_5, R.mipmap.dog_0};
        for (int i = 0; i < anims.length; i++) {
            Drawable drawable = ContextCompat.getDrawable(this, anims[i]);
            animationDrawable.addFrame(drawable, 200);
        }
        animationDrawable.setOneShot(true);//只运行一次
        imageView.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();


        frameAnimationFinishListener(animationDrawable);
    }

    private void frameAnimationFinishListener(AnimationDrawable animationDrawable) {
        // 监听帧动画运行完成
        long duration = 0;
        for (int i = 0; i < animationDrawable.getNumberOfFrames(); i++) {
            duration += animationDrawable.getDuration(i);
        }
        final long finalDuration = duration;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "动画运行完成" + finalDuration + "毫秒",
                        Toast.LENGTH_SHORT).show();
            }
        }, duration);
    }
}
