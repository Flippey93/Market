package com.flippey.market.ui.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.flippey.market.R;
import com.flippey.market.global.MyAppliocation;
import com.flippey.market.ui.widget.randomlayout.StellarMap;
import com.flippey.market.utils.UiUtil;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:41
 */
public class RecomendFragment extends BaseFragment {
    @Override
    protected Object initData() {
        return "";
    }

    @Override
    public View onCreateSuccess() {
        StellarMap stellarMap = new StellarMap(MyAppliocation.sContext);
        stellarMap.setAdapter(new StellarMap.Adapter(){
            //组数
            @Override
            public int getGroupCount() {
                return 3;
            }
            //一组个数
            @Override
            public int getCount(int group) {
                return 11;
            }
            //显示的view
            @Override
            public View getView(int group, int position, View convertView) {
                TextView textView = new TextView(MyAppliocation.sContext);
                textView.setText("ass");
                textView.setTextColor(Color.RED);
                return textView;
            }
            //用不到
            @Override
            public int getNextGroupOnPan(int group, float degree) {
                return 0;
            }
            //缩放以后显示那一个组
            @Override
            public int getNextGroupOnZoom(int group, boolean isZoomIn) {
                return (group+1)%getGroupCount();
            }
        });

        //设置第一次显示,第一组显示
        stellarMap.setGroup(0,true);
        //设置格子,一般就是当前的组的个数
        stellarMap.setRegularity(11,11);
        //设置padding
        int left  = UiUtil.getDimens(R.dimen.dp15);
        int top= UiUtil.getDimens(R.dimen.dp15);
        int right = UiUtil.getDimens(R.dimen.dp15);
        int bottom = UiUtil.getDimens(R.dimen.dp15);
        stellarMap.setPadding(left,top,right,bottom);
        return stellarMap;
    }
}
