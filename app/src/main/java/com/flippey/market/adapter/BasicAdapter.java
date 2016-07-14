package com.flippey.market.adapter;

import android.view.View;
import android.view.ViewGroup;
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
        return holder.getConvertView();
    }

    abstract BasicHolder creatViewholder(int position);
}
