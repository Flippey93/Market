package com.flippey.market.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.flippey.market.R;
import com.flippey.market.bean.AppInfoBean;
import com.flippey.market.global.MyAppliocation;
import com.flippey.market.utils.UrlUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;


/**
 * Created by sy_heima on 2016/7/15.
 */
public class AppInfoHeaderViewHolder extends BasicHolder<AppInfoBean> {

    @BindView(R.id.iv_include_appinfo_icon)
    ImageView mIvIncludeAppinfoIcon;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.rb_star)
    RatingBar mRbStar;
    @BindView(R.id.tv_down)
    TextView mTvDown;
    @BindView(R.id.tv_date)
    TextView mTvDate;
    @BindView(R.id.tv_version)
    TextView mTvVersion;
    @BindView(R.id.tv_size)
    TextView mTvSize;

    //创建布局
    @Override
    public View creatConvertView() {
        View view = View.inflate(MyAppliocation.sContext, R.layout.include_appinfo, null);
        return view;
    }

    //绑定数据
    @Override
    public void bindData(AppInfoBean appInfoBean) {

        //设置
        mTvDown.setText("下载:" + appInfoBean.getDownloadNum());

        mTvDate.setText("日期:" + appInfoBean.getDate());

        mTvSize.setText("大小:" + appInfoBean.getSize() + "");

        mTvTitle.setText(appInfoBean.getName());

        mTvVersion.setText("版本:" + appInfoBean.getVersion());

        mRbStar.setRating(appInfoBean.getStars());

        //图片加载
        ImageLoader.getInstance().displayImage(UrlUtil.imgURL + appInfoBean.getIconUrl(),
                mIvIncludeAppinfoIcon, options);

    }
}
