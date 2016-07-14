package com.flippey.market.ui.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.flippey.market.R;
import com.flippey.market.datamanager.DataLoader;
import com.flippey.market.global.MyAppliocation;
import com.flippey.market.ui.widget.randomlayout.StellarMap;
import com.flippey.market.utils.UiUtil;
import com.flippey.market.utils.UrlUtil;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Random;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:41
 */
public class RecomendFragment extends BaseFragment {

    private StellarMap mStellarMap;
    private StellarMap.Adapter mAdapter;

    @Override
    protected Object initData() {
        final List<String> dataList = (List<String>) DataLoader.getDataLoader().getDataList(UrlUtil.recURL, new
                TypeToken<List<String>>() {
        }.getType());
        if (dataList == null) {
            return null;
        }
        //组数
        //一组个数
        //显示的view
        //设置文本数据
        //设置随机的文字大小,字体大小介于13-23之间
        //设置随机字体颜色
        //设置点击事件
        //用不到
        //缩放以后显示那一个组
        mAdapter = new StellarMap.Adapter() {
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
                //设置文本数据
                int listposition = group * getCount(group) + position;
                textView.setText(dataList.get(listposition));
                //设置随机的文字大小,字体大小介于13-23之间
                Random random = new Random();
                textView.setTextSize(random.nextInt(10) + 14);
                //设置随机字体颜色
                textView.setTextColor(Color.rgb(UiUtil.createTextColor(),UiUtil.createTextColor(),UiUtil.createTextColor()));
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
                return (group + 1) % getGroupCount();
            }
        };
        UiUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mStellarMap.setAdapter(mAdapter);
                //设置第一次显示,第一组显示
                mStellarMap.setGroup(0,true);
                //设置格子,一般就是当前的组的个数
                mStellarMap.setRegularity(11,11);
            }
        });

        return dataList;
    }

    @Override
    public View onCreateSuccess() {
        mStellarMap = new StellarMap(MyAppliocation.sContext);
        //设置padding
        int left  = UiUtil.getDimens(R.dimen.dp15);
        int top= UiUtil.getDimens(R.dimen.dp15);
        int right = UiUtil.getDimens(R.dimen.dp15);
        int bottom = UiUtil.getDimens(R.dimen.dp15);
        mStellarMap.setInnerPadding(left,top,right,bottom);
       /* TextView textView = new TextView(MyAppliocation.sContext);
        textView.setText("lallal........");
        textView.setTextColor(Color.RED);*/

        return mStellarMap;
    }
}
