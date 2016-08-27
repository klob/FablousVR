package com.diandi.fabulousvr.activity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.diandi.fabulousvr.R;
import com.diandi.klob.sdk.ui.common.KActivity;


/**
 * *******************************************************************************
 * *********    Author : klob(kloblic@gmail.com) .
 * *********    Date : 2015-06-18  .
 * *********    Time : 18:51 .
 * *********    Version : 1.0
 * *********    Copyright © 2015, klob, All Rights Reserved
 * *******************************************************************************
 */

/**
 * 基础Activity类
 * */
public class BaseActivity extends KActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    /** 初始化View*/
    @Override
    public void initViews() {

    }
    /** 初始化数据*/
    @Override
    public void init() {

    }
    /** 绑定事件*/
    @Override
    public void bindEvent() {

    }

    @Override
    protected void initTheme() {
        setTheme(R.style.BlueTheme);
    }

    @Override
    public int getColor() {
        return getColorPrimary();
    }
}
