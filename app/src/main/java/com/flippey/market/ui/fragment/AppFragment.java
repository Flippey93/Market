package com.flippey.market.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.flippey.market.global.MyAppliocation;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:39
 */
public class AppFragment extends BaseFragment {
    @Override
    protected Object initData() {
        return null;
    }

    @Override
    public View onCreateSuccess() {
        TextView textView = new TextView(MyAppliocation.sContext);
        textView.setText("AppFragment");
        return textView;
    }
}
