package com.diandi.klob.vrview;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * *******************************************************************************
 * *********    Author : klob(kloblic@gmail.com) .
 * *********    Date : 2016-06-16  .
 * *********    Time : 19:16 .
 * *********    Version : 1.0
 * *********    Copyright © 2016, klob, All Rights Reserved
 * *******************************************************************************
 */
public class VrHelper {
    VrRender mVrRender;
    private float X1 = 0;
    private float Y1 = 0;

    public VrHelper(Context context, VrRender vrRender) {
        mVrRender = vrRender;
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    private SensorManager mSensorManager;
    private SensorEventListener mSensorEventListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            // 传感器信息改变时执行该方法
            float[] values = event.values;
            float x = values[0]; // x轴方向的重力加速度，向右为正
            float y = values[1]; // y轴方向的重力加速度，向前为正

            X1 = x;
            Y1 = y;
            if (mVrRender != null) {
                mVrRender.yAngle = mVrRender.yAngle + X1 / 4;
                mVrRender.xAngle = mVrRender.xAngle - Y1 / 4;
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    public void onResume() {
        if (mSensorManager != null) {// 注册监听器
            mSensorManager.registerListener(mSensorEventListener, mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_FASTEST);
            // 第一个参数是Listener，第二个参数是所得传感器类型，第三个参数值获取传感器信息的频率
        }
    }

    public void onPause() {
        if (mSensorManager != null) {// 取消监听器
            mSensorManager.unregisterListener(mSensorEventListener);
        }
    }
}
