package com.flippey.market.adapter;

import com.flippey.market.holder.BasicHolder;
import com.flippey.market.holder.ContentViewHolder;
import com.flippey.market.holder.TitleViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/14 20:11
 */
public class CategoryAdapter extends BasicAdapter {
    private List<Object> mData = new ArrayList<>();
    //定义类型值
    public static final int title = 0;//这个是系统定的
    public static final int content = 1;
    public CategoryAdapter(List<Object> data) {
        super(data);
        this.mData = data;
    }

    @Override
    BasicHolder creatViewholder(int postion) {
        //判断当前的类型,去拿不同的viewholder
        int itemViewType = getItemViewType(postion);
        if (itemViewType == title) {
            //返回标题的viewHolder
            return new TitleViewHolder();
        } else {
            return new ContentViewHolder();
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = mData.get(position);
        if (obj instanceof String) {
            return title;
        } else{
            return content;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
