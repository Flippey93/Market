package com.flippey.market.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.flippey.market.R;
import com.flippey.market.bean.HomeBean;
import com.flippey.market.global.MyAppliocation;

import java.util.List;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/12 18:58
 */
public class HomeAdapter extends BaseAdapter {
    private List<HomeBean.AppInfo> mData;

    public HomeAdapter(List<HomeBean.AppInfo> data) {
        this.mData = data;
    }
    @Override

    public int getCount() {
        return mData.size();
    }

    @Override
    public HomeBean.AppInfo getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.bindData(mData.get(position));
        return holder.getConvertView();
    }

    class ViewHolder {
        ImageView mIcon;
        TextView mName;
        RatingBar mStar;
        TextView mSize;
        TextView mDes;
        View convertView;

        public ViewHolder() {
            convertView = View.inflate(MyAppliocation.sContext, R.layout.home_item, null);
            mIcon = (ImageView) convertView.findViewById(R.id.home_item_iv_icon);
            mName = (TextView) convertView.findViewById(R.id.home_item_tv_name);
            mStar = (RatingBar) convertView.findViewById(R.id.home_item_iv_star);
            mSize = (TextView) convertView.findViewById(R.id.home_item_tv_size);
            mDes = (TextView) convertView.findViewById(R.id.home_item_tv_desc);
        }

        public View getConvertView() {
            return convertView;
        }

        public void bindData(HomeBean.AppInfo info) {
            mName.setText(info.getName());
            mStar.setRating(info.getStars());
            mSize.setText(info.getSize() + "");
            mDes.setText(info.getDes());
        }
    }

}
