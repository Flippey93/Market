package com.flippey.market.adapter;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;

import com.flippey.market.holder.BasicHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/13 19:05
 */
public abstract class BasicAdapter<T> extends BaseAdapter{

    private List<T> mData = new ArrayList<>();

    public BasicAdapter(List<T> data) {
        this.mData = data;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BasicHolder holder;
        if (convertView == null) {
            //创建viewholder
            holder = creatViewholder(position);
        } else {
            holder = (BasicHolder) convertView.getTag();
        }
        holder.bindData(mData.get(position));
        //添加动画
        View view = holder.getConvertView();
        view.setScaleX(.6f);
        view.setY(.6f);
        //使用动画，将view样式恢复
        ViewCompat.animate(view).scaleY(1.0f).scaleX(1.0f).setDuration(1000).setInterpolator(new
                OvershootInterpolator()).start();
        return view;
    }

    abstract BasicHolder creatViewholder(int position);
}
