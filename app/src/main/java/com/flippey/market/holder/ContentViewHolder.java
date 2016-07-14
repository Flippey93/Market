package com.flippey.market.holder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flippey.market.R;
import com.flippey.market.bean.CategoryBean;
import com.flippey.market.global.MyAppliocation;
import com.flippey.market.utils.UrlUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/14 20:47
 */
public class ContentViewHolder extends BasicHolder {
    @BindView(R.id.iv_image1)
    ImageView mIvImage1;
    @BindView(R.id.tv_name1)
    TextView mTvName1;
    @BindView(R.id.iv_image2)
    ImageView mIvImage2;
    @BindView(R.id.tv_name2)
    TextView mTvName2;
    @BindView(R.id.ll_info2)
    LinearLayout mLlInfo2;
    @BindView(R.id.iv_image3)
    ImageView mIvImage3;
    @BindView(R.id.tv_name3)
    TextView mTvName3;
    @BindView(R.id.ll_info3)
    LinearLayout mLlInfo3;

    @Override
    public View creatConvertView() {
        View view = View.inflate(MyAppliocation.sContext, R.layout.adapter_content, null);
        return view;
    }

    @Override
    public void bindData(Object o) {

        CategoryBean.InfosBean info = (CategoryBean.InfosBean)o;
        mTvName1.setText(info.getName1());
        mTvName2.setText(info.getName2());
        mTvName3.setText(info.getName3());

        //加载图片
        ImageLoader.getInstance().displayImage(UrlUtil.imgURL+ info.getUrl1(), mIvImage1, options);
        ImageLoader.getInstance().displayImage(UrlUtil.imgURL+ info.getUrl2(), mIvImage2, options);
        ImageLoader.getInstance().displayImage(UrlUtil.imgURL + info.getUrl3(), mIvImage3, options);

        //处理是否为空
        //以我多年的经验分析,他有可能一有,其他没有
        if (TextUtils.isEmpty(mTvName2.getText().toString())) {
            //隐藏
            mLlInfo2.setVisibility(View.INVISIBLE);
        } else {
            mLlInfo2.setVisibility(View.VISIBLE);


        }
        if (TextUtils.isEmpty(mTvName3.getText().toString())) {
            //隐藏
            mLlInfo3.setVisibility(View.INVISIBLE);
        } else {
            mLlInfo3.setVisibility(View.VISIBLE);
        }
    }
}
