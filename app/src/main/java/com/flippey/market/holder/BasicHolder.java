package com.flippey.market.holder;

import android.view.View;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/12 19:59
 */
public abstract class BasicHolder<T>{
    View convertView;

    public BasicHolder() {
        convertView = creatConvertView();
        convertView.setTag(this);
    }

    public View getConvertView() {
        return convertView;
    }

    public abstract View creatConvertView();
    public abstract void bindData(T t);
}
