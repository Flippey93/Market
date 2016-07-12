package com.flippey.market.holder;

import android.view.View;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/12 19:59
 */
public abstract class BasicHolder<T>{
    public View mView;

    public BasicHolder() {
        //获取convertview
        mView = CreateItemView();
        //绑定holder
        mView.setTag(this);
    }

    public abstract View CreateItemView();
    //绑定数据
    public abstract void bindData(T t);
}
