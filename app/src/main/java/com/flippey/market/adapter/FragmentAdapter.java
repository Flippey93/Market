package com.flippey.market.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.flippey.market.ui.fragment.FragmentFactory;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:52
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private String[] mTabsName;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragmentAdapter(FragmentManager fm, String[] tabsname) {
        super(fm);
        this.mTabsName = tabsname;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createFragment(position);
    }

    @Override
    public int getCount() {
        return mTabsName.length;
    }

    //返回tabs标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabsName[position];
    }
}
