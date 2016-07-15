package com.flippey.market.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.flippey.market.R;
import com.flippey.market.bean.AppInfoBean;
import com.flippey.market.datamanager.DataLoader;
import com.flippey.market.holder.AppInfoHeaderViewHolder;
import com.flippey.market.holder.AppInfoSafeViewHolder;
import com.flippey.market.uimanager.LoadPager;
import com.flippey.market.utils.UrlUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/15 18:53
 */
public class AppInfoActivity extends AppCompatActivity {

    @BindView(R.id.ll_app_info_layout)
    LinearLayout mLlLayout;
    @BindView(R.id.sv_app_info_scroll)
    ScrollView mSvcroll;
    @BindView(R.id.fl_app_info_bottom_layout)
    FrameLayout mFlBottomLayout;
    private LoadPager mLoadPager;
    private String mPackageName;
    private AppInfoHeaderViewHolder mAppInfoHeaderViewHolder;
    private AppInfoSafeViewHolder mAppInfoSafeViewHolder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        mPackageName = intent.getStringExtra("p");
        mLoadPager = new LoadPager(this) {
            @Override
            public Object loadData() {
                final AppInfoBean dataBean = DataLoader.getDataLoader().getDataBean(UrlUtil.appURL + mPackageName, AppInfoBean.class);
                System.out.println(UrlUtil.appURL + mPackageName + "......................");
                if (dataBean == null) {
                    return null;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAppInfoHeaderViewHolder.bindData(dataBean);
                        mAppInfoSafeViewHolder.bindData(dataBean);
                    }
                });
                return dataBean;
            }

            @Override
            protected View creatSuccessPager() {
                View view = View.inflate(AppInfoActivity.this, R.layout.activity_app_info, null);
                return view;
            }
        };
        setContentView(mLoadPager);
        ButterKnife.bind(this);
        initActionbar();
        initView();
    }

    private void initView() {
        mAppInfoHeaderViewHolder = new AppInfoHeaderViewHolder();
        mLlLayout.addView(mAppInfoHeaderViewHolder.getConvertView());

        mAppInfoSafeViewHolder = new AppInfoSafeViewHolder();
        mLlLayout.addView(mAppInfoSafeViewHolder.getConvertView());

    }


    private void initActionbar() {
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("应用详情");
        supportActionBar.setDisplayShowHomeEnabled(true);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
