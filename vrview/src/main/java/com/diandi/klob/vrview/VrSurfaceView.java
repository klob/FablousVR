package com.diandi.klob.vrview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/**
 * *******************************************************************************
 * *********    Author : klob(kloblic@gmail.com) .
 * *********    Date : 2016-06-16  .
 * *********    Time : 19:05 .
 * *********    Version : 1.0
 * *********    Copyright © 2016, klob, All Rights Reserved
 * *******************************************************************************
 */
public class VrSurfaceView extends GLSurfaceView {
    Context mContext;

    public VrSurfaceView(Context context) {
        super(context);
    }

    public VrSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private VrHelper mVrHelper;


    public void setVrRender(Context context,VrRender render) {
        setEGLContextClientVersion(2);
        setRenderer(render);
        mVrHelper = new VrHelper(context, render);

    }
    public void onResume() {
        if (mVrHelper != null) {
            mVrHelper.onResume();
        }
    }

    public void onPause() {
        if (mVrHelper != null) {
            mVrHelper.onPause();
        }
    }


}
