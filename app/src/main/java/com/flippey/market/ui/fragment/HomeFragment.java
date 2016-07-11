package com.flippey.market.ui.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.flippey.market.bean.HomeBean;
import com.flippey.market.datamanager.DataLoader;
import com.flippey.market.global.MyAppliocation;
import com.flippey.market.utils.UrlUtil;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:39
 */
public class HomeFragment extends BaseFragment {

    private TextView mTextView;

    @Override
    protected Object initData() {
        HomeBean homeBean = DataLoader.getDataLoader().getDataBean(UrlUtil.homeURL, HomeBean.class);
        mTextView.setText(homeBean.getList().get(0).getName());
        return homeBean;
    }

    @Override
    public View onCreateSuccess() {
        mTextView = new TextView(MyAppliocation.sContext);
        mTextView.setTextColor(Color.RED);
        return mTextView;
    }
}
