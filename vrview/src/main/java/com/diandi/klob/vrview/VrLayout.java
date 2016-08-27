package com.diandi.klob.vrview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * *******************************************************************************
 * *********    Author : klob(kloblic@gmail.com) .
 * *********    Date : 2016-06-17  .
 * *********    Time : 11:27 .
 * *********    Version : 1.0
 * *********    Copyright © 2016, klob, All Rights Reserved
 * *******************************************************************************
 */
public class VrLayout extends LinearLayout {
    private final static String TAG = "VrLayout";
    VrSurfaceView mVrSurfaceView1;
    VrSurfaceView mVrSurfaceView2;
    Context mContext;

    public VrLayout(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public VrLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public VrLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
        Log.e(TAG, "3");
    }

    private void init() {
        View view = inflate(mContext, R.layout.layout_vr, null);

        mVrSurfaceView1 = (VrSurfaceView) view.findViewById(R.id.VrSurfaceView1);
        mVrSurfaceView2 = (VrSurfaceView) view.findViewById(R.id.VrSurfaceView2);
        addView(view, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void setRender(VrRender vrRender,VrRender vrRender2) {
        mVrSurfaceView1.setVrRender(mContext,vrRender);
        mVrSurfaceView2.setVrRender(mContext,vrRender2);
    }

    public void onResume() {
        if (mVrSurfaceView1 != null) {
            mVrSurfaceView1.onResume();
        }
        if (mVrSurfaceView2 != null) {
            mVrSurfaceView2.onResume();
        }
    }

    public void onPause() {
        if (mVrSurfaceView1 != null) {
            mVrSurfaceView1.onPause();
        }
        if (mVrSurfaceView2 != null) {
            mVrSurfaceView2.onPause();
        }
    }

}
