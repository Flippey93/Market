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
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:39
 */
public class HomeFragment extends BaseFragment {

    private List<HomeBean.AppInfo> mList = new ArrayList<>();
    private HomeAdapter mAdapter;
    private PullToRefreshListView mPullToRefreshListView;
    private ListView mListView;


    @Override
    protected Object initData() {
        //System.out.println(UrlUtil.homeURL+mList.size()+"...................z");
        final HomeBean homeBean = DataLoader.getDataLoader().getDataBean(UrlUtil.homeURL +
                mList.size(), HomeBean.class);
        //final List<HomeBean.AppInfo> list = homeBean.getList();
        //在这里判断是上拉还是下拉
        if (mPullToRefreshListView.getCurrentMode() == PullToRefreshBase.Mode.PULL_FROM_START) {
            //如果是下拉
            mList.clear();
        }
        UiUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mList.addAll(homeBean.getList());
                mAdapter.notifyDataSetChanged();
                mPullToRefreshListView.onRefreshComplete();
            }
        });
        return homeBean;
    }

    @Override
    public View onCreateSuccess() {
        mPullToRefreshListView = (PullToRefreshListView) View.inflate(MyAppliocation
                .sContext, R.layout.listview, null);
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);//设置两边都可以刷新
        mListView = mPullToRefreshListView.getRefreshableView();
        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>(){
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        mLoadPager.loadData();
                    }
                }).start();
            }
        });
        mAdapter = new HomeAdapter(mList);
        mListView.setAdapter(mAdapter);
        return mPullToRefreshListView;
    }
}
