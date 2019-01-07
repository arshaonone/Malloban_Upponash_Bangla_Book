package com.mallobanupponash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread mainThread = new Thread(){

            @Override
            public void run() {

                try {
                    sleep(2000);

                    Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };
        mainThread.start();


    }
}
