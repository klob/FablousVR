package com.diandi.fabulousvr.activity;

/**
 * *******************************************************************************
 * *********    Author : klob(kloblic@gmail.com) .
 * *********    Date : 2016-06-17  .
 * *********    Time : 11:52 .
 * *********    Version : 1.0
 * *********    Copyright © 2016, klob, All Rights Reserved
 * *******************************************************************************
 */

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.diandi.fabulousvr.R;
import com.diandi.klob.sdk.photo.BitmapDecoder;
import com.diandi.klob.sdk.util.FileUtils;
import com.diandi.klob.sdk.util.photo.ScreenUtils;
import com.diandi.klob.vrview.VrLayout;
import com.diandi.klob.vrview.VrRender;


/**
 * *******************************************************************************
 * *********    Author : klob(kloblic@gmail.com) .
 * *********    Date : 2016-06-16  .
 * *********    Time : 19:28 .
 * *********    Version : 1.0
 * *********    Copyright © 2016, klob, All Rights Reserved
 * *******************************************************************************
 */
public class VrActivity3VrLayout extends BaseActivity {

    VrLayout mGlSurfaceView;
    VrRender mVrRender;
    VrRender mVrRender2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setClearContentView(R.layout.activity_vr3);
        mGlSurfaceView = (VrLayout) findViewById(R.id.layout_vr);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if ("drawable".equals(bundle.getString("type"))) {
                int id = bundle.getInt("src");
                mVrRender = new VrRender(this, id);
                mVrRender2 = new VrRender(this, id);
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
                mVrRender2 = new VrRender(this, bitmap);
            }
        }
        mGlSurfaceView.setRender(mVrRender,mVrRender2);
        ShowToast("Using VrLayout");
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

