package com.flippey.market.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flippey.market.global.MyAppliocation;
import com.flippey.market.uimanager.LoadPager;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:31
 * Fragment基类
 */
public abstract class BaseFragment extends Fragment {

    public LoadPager mLoadPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLoadPager = new LoadPager(MyAppliocation.sContext){
            @Override
            public Object loadData() {
                return initData();
            }

            @Override
            protected View creatSuccessPager() {
                return onCreateSuccess();
            }
        };
        return mLoadPager;
    }

    protected abstract Object initData();

    public abstract View onCreateSuccess();

}
