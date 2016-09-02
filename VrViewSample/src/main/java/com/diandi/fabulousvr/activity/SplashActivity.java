package com.diandi.fabulousvr.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.diandi.fabulousvr.R;


/**
 * *******************************************************************************
 * *********    Author : klob(kloblic@gmail.com) .
 * *********    Date : 2015-12-15  .
 * *********    Time : 21:24 .
 * *********    Version : 1.0
 * *********    Copyright © 2015, klob, All Rights Reserved
 * *******************************************************************************
 */
public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setClearContentView(R.layout.activity_splash);
        Handler mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    startAnimActivity(new Intent(mContext,PhotoActivity.class));
                     finish();
                }
            }
        };
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }
}
