package com.flippey.market.datamanager;

import android.text.TextUtils;

import com.flippey.market.utils.CacheUtil;
import com.flippey.market.utils.GsonUtil;
import com.flippey.market.utils.HttpUtil;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 22:09
 */
public class DataLoader {

    private DataLoader() {
    }

    private static DataLoader mDataLoader = new DataLoader();

    public static DataLoader getDataLoader() {
        return mDataLoader;
    }

    public <T> T getDataBean(String url, Class<T> clazz) {
        //先去网络获取数据，如果没有再去本地获取数据
        String data = "";
        data = HttpUtil.getHttpUtil().dataGet(url);
        if (TextUtils.isEmpty(data)) {
            //如果data为空则从本地获取数据
//            System.out.println("....从本地获取数据");
            data = CacheUtil.getCacheUtil().getCacheData(url);
            if (TextUtils.isEmpty(data)) {
                return null;
            }
        } else {
//            System.out.println("从网络保存到本地................");
            //TODO 保存数据到本地缓存
            CacheUtil.getCacheUtil().saveCacheData(url, data);
        }
        return GsonUtil.parseJsonToBean(data, clazz);
    }

    public <T> T getDataList(String url) {
        //先去网络获取数据，如果没有再去本地获取数据
        String data = "";
        data = HttpUtil.getHttpUtil().dataGet(url);
        if (TextUtils.isEmpty(data)) {
            //如果json为空则从本地获取数据
            data = CacheUtil.getCacheUtil().getCacheData(url);
            //data = HttpUtil.getHttpUtil().dataGet(url);
            if (TextUtils.isEmpty(data)) {
                return null;
            }
        } else {
            //保存数据到本地缓存
            CacheUtil.getCacheUtil().saveCacheData(url, data);
        }
        return (T) data;
    }
}
