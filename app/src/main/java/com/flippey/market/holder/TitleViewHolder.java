package com.flippey.market.holder;

import android.view.View;
import android.widget.TextView;

import com.flippey.market.R;
import com.flippey.market.global.MyAppliocation;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/14 20:41
 */
public class TitleViewHolder extends BasicHolder {

    private TextView mTv;

    @Override
    public View creatConvertView() {
        View view = View.inflate(MyAppliocation.sContext, R.layout.adapter_title, null);
        mTv = (TextView) view.findViewById(R.id.tv_title);
        return view;
    }

    //如果能传到这个地方,那么这个就是String
    @Override
    public void bindData(Object obj) {
        String showStr = (String) obj;
        mTv.setText(showStr);
    }
}
