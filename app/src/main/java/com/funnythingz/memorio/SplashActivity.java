package com.funnythingz.memorio;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    private ImageView mImageView;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        mImageView = (ImageView)findViewById(R.id.logoImageView);
        mImageView.getRootView().setBackgroundColor(randomColor());

        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (!isFinishing()) {
                            startMainActivity();
                            finish();
                        }
                    }
                }, 3000);
            }
        }).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private int randomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    private void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
