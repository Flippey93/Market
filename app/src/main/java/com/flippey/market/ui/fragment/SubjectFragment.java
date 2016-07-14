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
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

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
    private PullToRefreshListView mPullToRefreshListView;

    @Override
    protected Object initData() {
        //判断当前的状态
        if (mPullToRefreshListView.getCurrentMode() == PullToRefreshBase.Mode.PULL_FROM_START) {
            mData.clear();
        }
        Type type = new TypeToken<List<SubjectBean>>(){}.getType();
        final List<SubjectBean> list = (List<SubjectBean>) DataLoader.getDataLoader().getDataList(UrlUtil.subURL+mData.size(), type);
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
        mPullToRefreshListView = (PullToRefreshListView) View.inflate(MyAppliocation
                .sContext, R.layout.listview, null);
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);//设置两边都可以刷新
        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                //加载数据
                mLoadPager.loadData();
            }
        });
        mListView = mPullToRefreshListView.getRefreshableView();
        mSubAdapter = new SubAdapter(mData);
        mListView.setAdapter(mSubAdapter);
        return mPullToRefreshListView;
    }
}
