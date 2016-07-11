package com.flippey.market.ui.fragment;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:14
 */
public class FragmentFactory {
    //用集合将fragmen保存起来
    private static Map<Integer, BaseFragment> mFragmentMap = new HashMap<>();

    public static BaseFragment createFragment(int position) {
        //先从集合中取出，没有的话再new出来
        BaseFragment fragment = mFragmentMap.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new AppFragment();
                    break;
                case 2:
                    fragment = new GameFragment();
                    break;
                case 3:
                    fragment = new SubjectFragment();
                    break;
                case 4:
                    fragment = new RecomendFragment();
                    break;
                case 5:
                    fragment = new SortFragment();
                    break;
                case 6:
                    fragment = new HotFragment();
                    break;
                default:
                    break;
            }
            //将fragment保存到map集合
            mFragmentMap.put(position, fragment);
        }
        return fragment;
    }

}
