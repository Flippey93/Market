package com.flippey.market.holder;

import android.view.View;

import com.flippey.market.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import butterknife.ButterKnife;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/12 19:59
 */
public abstract class BasicHolder<T>{
    View convertView;
    DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.ic_launcher)
            .showImageForEmptyUri(R.mipmap.ic_launcher)
            .showImageOnFail(R.mipmap.ic_launcher)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .considerExifParams(true) //识别图片方向
            //.displayer(new RoundedBitmapDisplayer(60)).build(); //图片显示
            .displayer(new FadeInBitmapDisplayer(1000)).build(); //显示效果淡入淡出
    public BasicHolder() {
        convertView = creatConvertView();
        ButterKnife.bind(this, convertView);
        convertView.setTag(this);
    }

    public View getConvertView() {
        return convertView;
    }

    public abstract View creatConvertView();
    public abstract void bindData(T t);
}
