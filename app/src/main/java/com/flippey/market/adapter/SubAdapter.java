package com.flippey.market.adapter;

import com.flippey.market.holder.BasicHolder;
import com.flippey.market.holder.SubHolder;

import java.util.List;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/13 21:34
 */
public class SubAdapter extends BasicAdapter{

    public SubAdapter(List data) {
        super(data);
    }

    @Override
    BasicHolder creatViewholder() {
        return new SubHolder();
    }
}
