package com.flippey.market.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.flippey.market.R;
import com.flippey.market.adapter.FragmentAdapter;
import com.flippey.market.ui.widget.PagerSlidingTab;
import com.flippey.market.utils.UiUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_fl)
    FrameLayout mLeftMenu;
    @BindView(R.id.main_drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.main_pst)
    PagerSlidingTab mSlidingTab;
    @BindView(R.id.main_viewpager)
    ViewPager mViewpager;
    private ActionBar mActionBar;
    private ActionBarDrawerToggle mToggle;
    private String[] mTabsName;
    private FragmentAdapter mFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initActionBar();
        initView();
    }


    /**
     * 初始化actionbar
     */
    private void initActionBar() {
        mActionBar = getSupportActionBar();
        mActionBar.setTitle(R.string.action_title);
        mActionBar.setDisplayShowHomeEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string
                .open, R.string.close);
        mToggle.syncState();
        mDrawerLayout.setDrawerListener(mToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mToggle.onOptionsItemSelected(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 初始化Fragment
     */
    private void initView() {
        mTabsName = UiUtil.getStringArray(R.array.tab_names);
        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), mTabsName);
        mViewpager.setAdapter(mFragmentAdapter);
        //记得要绑定viewpager
        mSlidingTab.setViewPager(mViewpager);
    }
}
