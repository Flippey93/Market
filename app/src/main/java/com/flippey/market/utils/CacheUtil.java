package com.flippey.market.utils;

import android.os.Environment;

import com.flippey.market.global.MyAppliocation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 22:26
 */
public class CacheUtil {

    private String mCacheDir;
    //缓存本地的路径为sd/包名/cache/
    private CacheUtil() {
        mCacheDir = Environment.getExternalStorageDirectory().getPath() + File.separator +
                MyAppliocation
                .sContext.getPackageName() + File.separator + "cache";
        File cacheFile = new File(mCacheDir);
        if (!cacheFile.exists()) {
            cacheFile.mkdir();
        }
    }
    private static CacheUtil mGetCacheUtil = new CacheUtil();
    public static CacheUtil getCacheUtil() {
        return mGetCacheUtil;
    }

    /**
     * 获取缓存的数据
     * @param url
     * @return
     */
    public String getCacheData(String url) {
        try {
            File file = new File(mCacheDir, md5FileName(url));
            FileInputStream is = new FileInputStream(file);
            int len = 0;
            byte[] buffer = new byte[1024];
            StringBuffer cacheData = new StringBuffer();
            while ((len = is.read(buffer)) != -1) {
                cacheData.append(new String(buffer, 0, len));
            }
            is.close();
            System.out.println("从本地缓存获取数据.................");
            return cacheData.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 缓存数据到本地
     * @param url
     * @param jsonData
     */
    public void saveCacheData(String url,String jsonData) {
        try {
            String filename = md5FileName(url);
            File file = new File(mCacheDir, filename);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(jsonData.getBytes());
            fos.flush();
            fos.close();
            System.out.println("缓存数据到本地................");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String  md5FileName(String url) throws NoSuchAlgorithmException {
        StringBuffer fileName = new StringBuffer();
        MessageDigest digester = MessageDigest.getInstance("MD5");
        digester.update(url.getBytes());//得到加密的字符
        byte[] digest = digester.digest();//加密
        for (int i = 0; i < digest.length; i++) {
            String hexString = Integer.toHexString(digest[i] & 0xff);//ffffffd7--->d7
            //System.out.println(hexString);
            fileName.append(hexString);
        }

        return fileName.toString();
    }
}
