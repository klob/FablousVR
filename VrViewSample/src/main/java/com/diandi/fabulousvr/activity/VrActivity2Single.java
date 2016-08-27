package com.diandi.fabulousvr.activity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.diandi.fabulousvr.R;
import com.diandi.klob.sdk.photo.BitmapDecoder;
import com.diandi.klob.sdk.util.FileUtils;
import com.diandi.klob.sdk.util.photo.ScreenUtils;
import com.diandi.klob.vrview.VrRender;
import com.diandi.klob.vrview.VrSurfaceView;

/**
 * *******************************************************************************
 * *********    Author : klob(kloblic@gmail.com) .
 * *********    Date : 2016-06-16  .
 * *********    Time : 19:28 .
 * *********    Version : 1.0
 * *********    Copyright © 2016, klob, All Rights Reserved
 * *******************************************************************************
 */
public class VrActivity2Single extends BaseActivity {

    VrSurfaceView mGlSurfaceView;
    VrRender mVrRender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setClearContentView(R.layout.activity_vr2);
        mGlSurfaceView = (VrSurfaceView) findViewById(R.id.glsurfaceview);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if ("drawable".equals(bundle.getString("type"))) {
                int id = bundle.getInt("src");
                mVrRender = new VrRender(this, id);
            } else if ("uri".equals(bundle.getString("type"))) {
                String uri = FileUtils.getPath(mContext, (Uri) bundle.getParcelable("src"));
                Bitmap bitmap = BitmapDecoder.decodeSampledBitmapFromFile(uri, ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight());
                if (bitmap == null) {
                    if ((bundle.getParcelable("src")) != null) {
                        bitmap = BitmapDecoder.decodeSampledBitmapFromFile(((Uri) bundle.getParcelable("src")).getPath(), ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight());
                    }
                }
                if (bitmap == null) {
                    ShowToast("ERROR");
                    finish();
                }
                mVrRender = new VrRender(this, bitmap);
            }
        }
        mGlSurfaceView.setVrRender(this,mVrRender);
        ShowToast("Single VrSurfaceView");
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (null != mGlSurfaceView) {
            mGlSurfaceView.onResume();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (null != mGlSurfaceView) {
            mGlSurfaceView.onPause();
        }
    }

}
