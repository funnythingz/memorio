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

        final int color = randomColor();
        mImageView = (ImageView)findViewById(R.id.logoImageView);
        mImageView.getRootView().setBackgroundColor(color);

        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (!isFinishing()) {
                            startMainActivity(color);
                            finish();
                        }
                    }
                }, 1000);
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

    private void startMainActivity(int color) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("color", color);
        startActivity(intent);
    }
}
