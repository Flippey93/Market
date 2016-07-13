package com.flippey.market.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flippey.market.R;
import com.flippey.market.bean.SubjectBean;
import com.flippey.market.global.MyAppliocation;
import com.flippey.market.utils.UrlUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/13 21:35
 */
public class SubHolder extends BasicHolder<SubjectBean> {

    private ImageView mAd;
    private TextView mDesc;

    @Override
    public View creatConvertView() {
        View view = View.inflate(MyAppliocation.sContext, R.layout.subject_item, null);
        mAd = (ImageView) view.findViewById(R.id.sub_item_iv_ad);
        mDesc = (TextView) view.findViewById(R.id.sub_item_tv_desc);
        return view;
    }

    @Override
    public void bindData(SubjectBean subjectBean) {
        mDesc.setText(subjectBean.getDes());
        ImageLoader.getInstance().displayImage(UrlUtil.imgURL+subjectBean.getUrl(),mAd,options);
    }
}
