package com.flippey.market.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 19:47
 */
public class MyAppliocation extends Application {
    public static Context sContext;
    public static Handler sHanlder;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        sHanlder = new Handler();
        //初始化图片加载框架
        ImageLoader.getInstance().init( ImageLoaderConfiguration.createDefault(this));
    }
}
