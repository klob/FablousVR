package com.diandi.fabulousvr;

import android.app.Application;

import com.diandi.klob.sdk.XApplication;
import com.diandi.klob.sdk.photo.ImageLoadTool;
import com.diandi.klob.sdk.util.L;



/**
 * *******************************************************************************
 * *********    Author : klob(kloblic@gmail.com) .
 * *********    Date : 2015-12-08  .
 * *********    Time : 15:51 .
 * *********    Version : 1.0
 * *********    Copyright © 2015, klob, All Rights Reserved
 * *******************************************************************************
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XApplication.init(this,BuildConfig.DEBUG);
        ImageLoadTool.setsDefaultLoadingId(R.drawable.loading);
        ImageLoadTool.setsAvatarLoadingId(R.drawable.ic_launcher);

    }
}
