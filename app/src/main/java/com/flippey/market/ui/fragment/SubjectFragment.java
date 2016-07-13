package com.flippey.market.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.flippey.market.R;
import com.flippey.market.adapter.SubAdapter;
import com.flippey.market.bean.SubjectBean;
import com.flippey.market.datamanager.DataLoader;
import com.flippey.market.global.MyAppliocation;
import com.flippey.market.utils.UiUtil;
import com.flippey.market.utils.UrlUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:41
 */
public class SubjectFragment extends BaseFragment {
    private List<SubjectBean> mData = new ArrayList<>();
    private ListView mListView;
    private SubAdapter mSubAdapter;

    @Override
    protected Object initData() {
        Type type = new TypeToken<List<SubjectBean>>(){}.getType();
        final List<SubjectBean> list = DataLoader.getDataLoader().getDataList(UrlUtil.subURL, type);
        UiUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mData.clear();
                mData.addAll(list);
                mSubAdapter.notifyDataSetChanged();
            }
        });
        return list;
    }

    @Override
    public View onCreateSuccess() {
        mListView = (ListView) View.inflate(MyAppliocation.sContext, R.layout.listview, null);
        mSubAdapter = new SubAdapter(mData);
        mListView.setAdapter(mSubAdapter);
        return mListView;
    }
}
