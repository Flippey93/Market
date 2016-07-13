package com.flippey.market.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.flippey.market.R;
import com.flippey.market.bean.HomeBean;
import com.flippey.market.global.MyAppliocation;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/12 19:43
 */
public class HomeHolder extends BasicHolder<HomeBean.AppInfo>{

    ImageView mHome_Icon;
    TextView mHome_Name;
    TextView  mHome_Size;
    TextView  mHome_Desc;
    RatingBar mHome_Star;
    @Override
    public View creatConvertView() {
        View view = View.inflate(MyAppliocation.sContext, R.layout.home_item, null);
        mHome_Icon = (ImageView) view.findViewById(R.id.home_item_iv_icon);
        mHome_Name = (TextView) view.findViewById(R.id.home_item_tv_name);
        mHome_Size = (TextView) view.findViewById(R.id.home_item_tv_size);
        mHome_Desc = (TextView) view.findViewById(R.id.home_item_tv_desc);
        mHome_Star = (RatingBar) view.findViewById(R.id.home_item_iv_star);
        return view;
    }

    @Override
    public void bindData(HomeBean.AppInfo info) {
        mHome_Name.setText(info.getName());
        mHome_Size.setText(info.getSize()+"");
        mHome_Desc.setText(info.getDes());
        mHome_Star.setRating(info.getStars());
    }

}

