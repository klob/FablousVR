package com.diandi.fabulousvr.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.diandi.fabulousvr.R;
import com.diandi.fabulousvr.tool.PhotoProvider;

/**
 * *******************************************************************************
 * *********    Author : klob(kloblic@gmail.com) .
 * *********    Date : 2016-06-06  .
 * *********    Time : 10:36 .
 * *********    Version : 1.0
 * *********    Copyright © 2016, klob, All Rights Reserved
 * *******************************************************************************
 */
public class PhotoActivity extends BaseActivity implements View.OnClickListener {
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        initTopBarForOnlyTitle(getString(R.string.select_photo));
        img1 = (ImageView) findViewById(R.id.img_p1);
        img2 = (ImageView) findViewById(R.id.img_p2);
        img3 = (ImageView) findViewById(R.id.img_p3);
        img4 = (ImageView) findViewById(R.id.img_p4);
        img5 = (ImageView) findViewById(R.id.img_p5);
        mPhotoProvider = new PhotoProvider(this, new PhotoProvider.CameraCallBack() {
            @Override
            public void cameraFinish(String filePath) {
            }

            @Override
            public void locationFinish(Uri uri) {
                Intent intent = new Intent(mContext, VrActivity1Default.class);
                intent.putExtra("src", uri);
                intent.putExtra("type", "uri");
                startAnimActivity(intent);
            }

            @Override
            public void cropFinish(Bitmap bitmap, String cropPath) {

            }
        });

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
    }

    PhotoProvider mPhotoProvider;

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.img_p1:
                Intent intent = new Intent(this, VrActivity1Default.class);
                intent.putExtra("src", R.drawable.p1);
                intent.putExtra("type", "drawable");
                startAnimActivity(intent);
                break;

            case R.id.img_p2:
                Intent intent2 = new Intent(this, VrActivity2Single.class);
                intent2.putExtra("src", R.drawable.p1);
                intent2.putExtra("type", "drawable");
                startAnimActivity(intent2);
                break;
            case R.id.img_p3:
                Intent intent3 = new Intent(this, VrActivity3VrLayout.class);
                intent3.putExtra("src", R.drawable.p1);
                intent3.putExtra("type", "drawable");
                startAnimActivity(intent3);
                break;
            case R.id.img_p4:
                Intent intent5 = new Intent(this, VrActivity4Double.class);
                intent5.putExtra("src", R.drawable.p1);
                intent5.putExtra("type", "drawable");
                startAnimActivity(intent5);
                break;
            case R.id.img_p6:
                mPhotoProvider.startLocation();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mPhotoProvider != null) {
            mPhotoProvider.onActivityResult(requestCode, resultCode, data);
        }
    }

}
