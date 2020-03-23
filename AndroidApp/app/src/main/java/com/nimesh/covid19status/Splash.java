package com.nimesh.covid19status;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private TextView tv,tv2,tv3;
    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv = (TextView) findViewById(R.id.splashAppIntro);
        tv2 = (TextView) findViewById(R.id.splashAppIntro2);
        tv3 = (TextView) findViewById(R.id.devBy);
        iv = (ImageView) findViewById(R.id.splashLogo);
        Animation splashAnim = AnimationUtils.loadAnimation(this,R.anim.splashtransition);
        tv.startAnimation(splashAnim);
        tv2.startAnimation(splashAnim);
        tv3.startAnimation(splashAnim);
        iv.startAnimation(splashAnim);
        final Intent in = new Intent(this, MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(in);
                    finish();
                }
            }
        };
        timer.start();
    }
}
