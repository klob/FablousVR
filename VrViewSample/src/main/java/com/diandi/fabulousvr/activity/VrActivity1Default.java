package com.diandi.fabulousvr.activity;

import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import com.diandi.fabulousvr.R;
import com.diandi.klob.sdk.photo.BitmapDecoder;
import com.diandi.klob.sdk.util.FileUtils;
import com.diandi.klob.sdk.util.photo.ScreenUtils;
import com.diandi.klob.vrview.VrRender;


public class VrActivity1Default extends BaseActivity {

    GLSurfaceView mGlSurfaceView;
    GLSurfaceView mGlSurfaceView2;
    VrRender mVrRender;
    VrRender mVrRender2;


    private float mPreviousY;
    private float mPreviousX;
    private SensorManager sensorManager;
    private Sensor sensor;


    private float X1 = 0;
    private float Y1 = 0;
    private float Z1 = 0;


    private float zero_limit = 0.05f;
    private float v_limit = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setClearContentView(R.layout.activity_vr);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);

        mGlSurfaceView = (GLSurfaceView) findViewById(R.id.glsurfaceview);
        mGlSurfaceView2 = (GLSurfaceView) findViewById(R.id.glsurfaceview2);
        mGlSurfaceView.setEGLContextClientVersion(2);
        mGlSurfaceView2.setEGLContextClientVersion(2);
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
                    if (((Uri) bundle.getParcelable("src")) != null) {
                        bitmap = BitmapDecoder.decodeSampledBitmapFromFile(((Uri) bundle.getParcelable("src")).getPath(), ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight());
                    }
                }
                if (bitmap == null) {
                    ShowToast("ERROR");
                    finish();
                }
                //  Drawable drawable =new BitmapDrawable(bitmap);
                mVrRender = new VrRender(this, bitmap);
                mVrRender2 = new VrRender(this, bitmap);
            }
        }
        mGlSurfaceView.setRenderer(mVrRender);
        mGlSurfaceView2.setRenderer(mVrRender2);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShowToast("Using GLSurfaceView");
    }


    private SensorEventListener sensorEventListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            // 传感器信息改变时执行该方法
            float[] values = event.values;
            float x = values[0]; // x轴方向的重力加速度，向右为正
            float y = values[1]; // y轴方向的重力加速度，向前为正
            float z = values[2];// z轴方向的重力加速度，向上为正

            X1 = x;
            Y1 = y;
            Z1 = z;


//

            mVrRender.yAngle = mVrRender.yAngle + X1 / 4;
            mVrRender.xAngle = mVrRender.xAngle - Y1 / 4;
            mVrRender2.yAngle = mVrRender2.yAngle + X1 / 4;
            mVrRender2.xAngle = mVrRender2.xAngle - Y1 / 4;

            //显示移动后的图像

            //更新速度


            //System.out.println("X  : "+X+"     Y:   "+Y+"    Z  :"+ Z);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float y = e.getY();
        float x = e.getX();
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dy = y - mPreviousY;// 计算触控笔Y位移
                float dx = x - mPreviousX;// 计算触控笔X位移
                mVrRender.yAngle += dx * 0.3f;// 设置填充椭圆绕y轴旋转的角度
                mVrRender.xAngle += dy * 0.3f;// 设置填充椭圆绕x轴旋转的角度
                mVrRender2.yAngle += dx * 0.3f;// 设置填充椭圆绕y轴旋转的角度
                mVrRender2.xAngle += dy * 0.3f;// 设置填充椭圆绕x轴旋转的角度
        }
        mPreviousY = y;// 记录触控笔位置
        mPreviousX = x;// 记录触控笔位置

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (null != mGlSurfaceView) {
            mGlSurfaceView.onResume();
        }
        if (sensorManager != null) {// 注册监听器
            sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_FASTEST);
            // 第一个参数是Listener，第二个参数是所得传感器类型，第三个参数值获取传感器信息的频率
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (null != mGlSurfaceView) {
            mGlSurfaceView.onPause();
        }
        if (sensorManager != null) {// 取消监听器
            sensorManager.unregisterListener(sensorEventListener);
        }
    }

}
