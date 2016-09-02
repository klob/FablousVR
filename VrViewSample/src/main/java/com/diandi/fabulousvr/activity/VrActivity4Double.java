package com.diandi.fabulousvr.activity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.diandi.fabulousvr.R;
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
public class VrActivity4Double extends BaseActivity {

    VrSurfaceView mGlSurfaceView;
    VrSurfaceView mGlSurfaceView2;
    VrRender mVrRender;
    VrRender mVrRender2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setClearContentView(R.layout.activity_vr4);


        mGlSurfaceView = (VrSurfaceView) findViewById(R.id.VR1);
        mGlSurfaceView2 = (VrSurfaceView) findViewById(R.id.VR2);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if ("drawable".equals(bundle.getString("type"))) {
                int id = bundle.getInt("src");
                mVrRender = new VrRender(this, id);
                mVrRender2 = new VrRender(this, id);
            } else if ("uri".equals(bundle.getString("type"))) {
                Bitmap bitmap =  getBitmapFromUri((Uri) bundle.getParcelable("src"));
                Bitmap bitmap2 =   getBitmapFromUri((Uri) bundle.getParcelable("src"));
                mVrRender = new VrRender(this, bitmap);
                mVrRender2 = new VrRender(this, bitmap2);
            }
        }
        mGlSurfaceView.setVrRender(mContext, mVrRender);
        mGlSurfaceView2.setVrRender(mContext, mVrRender2);
        ShowToast("Double VrSurfaceView");
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (null != mGlSurfaceView) {
            mGlSurfaceView.onResume();
            mGlSurfaceView2.onResume();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (null != mGlSurfaceView) {
            mGlSurfaceView.onPause();
            mGlSurfaceView2.onPause();
        }
    }
}
