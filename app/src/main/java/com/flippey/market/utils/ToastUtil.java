package com.flippey.market.utils;

import android.widget.Toast;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 21:08
 */
public class ToastUtil {
    private static Toast toast;
    public static void shwoToast(String text) {
        if (toast == null) {
            //创建toast
            toast = Toast.makeText(UiUtil.getContext(), text, Toast.LENGTH_SHORT);
        }
        //如果吐司已经创建，那么直接更改吐司的文本即可
        toast.setText(text);
        //最后显示
        toast.show();
    }
}
