package com.flippey.market.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.flippey.market.global.MyAppliocation;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:40
 */
public class GameFragment extends BaseFragment {
    @Override
    protected Object initData() {
        return null;
    }

    @Override
    public View onCreateSuccess() {
        TextView textView = new TextView(MyAppliocation.sContext);
        textView.setText("GameFragment");
        return textView;
    }
}
