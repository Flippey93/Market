package com.flippey.market.utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 22:11
 */
public class HttpUtil {

    private HttpUtil() {

    }
    private static HttpUtil mHttpUtil = new HttpUtil();

    public static HttpUtil getHttpUtil() {
        return mHttpUtil;
    }

    /**
     * get方式获取数据
     * @param url url链接
     * @return
     */
    public String dataGet(String url) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
