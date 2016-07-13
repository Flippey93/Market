package com.flippey.market.adapter;

import com.flippey.market.bean.HomeBean;
import com.flippey.market.holder.BasicHolder;
import com.flippey.market.holder.HomeHolder;

import java.util.List;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/13 20:32
 */
public class HomeAdapter extends BasicAdapter<HomeBean.AppInfo> {
    public HomeAdapter(List<HomeBean.AppInfo> data) {
        super(data);
    }

    @Override
    BasicHolder creatViewholder() {
        return new HomeHolder();
    }
}
