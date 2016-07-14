package com.flippey.market.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.flippey.market.R;
import com.flippey.market.adapter.CategoryAdapter;
import com.flippey.market.bean.CategoryBean;
import com.flippey.market.datamanager.DataLoader;
import com.flippey.market.global.MyAppliocation;
import com.flippey.market.utils.UiUtil;
import com.flippey.market.utils.UrlUtil;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/14 20:06
 */
public class CategoryFragment extends BaseFragment {

    public List<Object> mData = new ArrayList<>();
    private CategoryAdapter mAdapter;

    @Override
    protected Object initData() {
        List<CategoryBean> dataList = (List<CategoryBean>) DataLoader.getDataLoader().getDataList(UrlUtil.catURL, new
                TypeToken<List<CategoryBean>>() {
        }.getType());
        if (dataList == null) {
            return null;
        }
        //当前的集合
        //把标题跟显示的每一个条目组成一个新的信息
        for (CategoryBean categoryBean : dataList) {
            mData.add(categoryBean.getTitle());
            //还要把内容也拼接上去
            mData.addAll(categoryBean.getInfos());
        }
        UiUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });
        return dataList;
    }
    @Override
    public View onCreateSuccess() {
        ListView view =  (ListView) View.inflate(MyAppliocation.sContext, R.layout.category_listview, null);
        mAdapter = new CategoryAdapter(mData);
        view.setAdapter(mAdapter);
        return view;
    }
}
