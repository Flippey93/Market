package com.flippey.market.ui.fragment;

import android.view.View;
import android.widget.ListView;

import com.flippey.market.R;
import com.flippey.market.adapter.HomeAdapter;
import com.flippey.market.bean.HomeBean;
import com.flippey.market.datamanager.DataLoader;
import com.flippey.market.global.MyAppliocation;
import com.flippey.market.utils.UiUtil;
import com.flippey.market.utils.UrlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:39
 */
public class HomeFragment extends BaseFragment {

    private ListView mListView;
    private List<HomeBean.AppInfo> mList = new ArrayList<>();
    private HomeAdapter mAdapter;

    @Override
    protected Object initData() {
        HomeBean homeBean = DataLoader.getDataLoader().getDataBean(UrlUtil.homeURL, HomeBean.class);
        final List<HomeBean.AppInfo> list = homeBean.getList();
        UiUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mList.clear();
                mList.addAll(list);
                mAdapter.notifyDataSetChanged();
            }
        });
        return homeBean;
    }

    @Override
    public View onCreateSuccess() {
        /*mTextView = new TextView(MyAppliocation.sContext);
        mTextView.setTextColor(Color.RED);*/
        mListView = (ListView) View.inflate(MyAppliocation.sContext, R.layout.listview, null);
        //mListView.setAdapter();
        mAdapter = new HomeAdapter(mList);
        mListView.setAdapter(mAdapter);
        return mListView;
    }
}
