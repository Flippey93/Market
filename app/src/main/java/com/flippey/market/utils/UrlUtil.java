package com.flippey.market.utils;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 21:12
 */
public class UrlUtil {
    //定义一个home界面的地址
    //    http://127.0.0.1:8090/home?index=0
    //主机地址
    public static final String hostURL = "http://127.0.0.1:8090/";
    //图片前缀
    public static final String imgURL = hostURL+"image?name=";
    //home地址
    public static final String homeURL = hostURL+"home?index=";
    //专题地址
    public static final String subURL = hostURL+"subject?index=";
    //推荐地址
    public static final String recURL = hostURL+"recommend?index=0";
    //分类地址
    public static final String catURL = hostURL + "category?index=0";
    //热门地址
    public static final String hotURL = hostURL + "hot?index=0";
}
