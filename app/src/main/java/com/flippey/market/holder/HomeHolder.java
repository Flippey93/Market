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
public class HomeHolder extends BasicHolder <HomeBean.AppInfo>{

    ImageView mIcon;
    TextView mName;
    RatingBar mStar;
    TextView mSize;
    TextView mDes;
    View convertView;
    @Override
    public View CreateItemView() {
        convertView = View.inflate(MyAppliocation.sContext, R.layout.home_item, null);
        mIcon = (ImageView) convertView.findViewById(R.id.home_item_iv_icon);
        mName = (TextView) convertView.findViewById(R.id.home_item_tv_name);
        mStar = (RatingBar) convertView.findViewById(R.id.home_item_iv_star);
        mSize = (TextView) convertView.findViewById(R.id.home_item_tv_size);
        mDes = (TextView) convertView.findViewById(R.id.home_item_tv_desc);
        return convertView;
    }

    @Override
    public void bindData(HomeBean.AppInfo info) {
        mName.setText(info.getName());
        mStar.setRating(info.getStars());
        mSize.setText(info.getSize() + "");
        mDes.setText(info.getDes());
    }

}
