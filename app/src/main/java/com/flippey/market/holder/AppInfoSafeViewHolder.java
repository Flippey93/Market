package com.flippey.market.holder;

import android.animation.ValueAnimator;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flippey.market.R;
import com.flippey.market.bean.AppInfoBean;
import com.flippey.market.global.MyAppliocation;
import com.flippey.market.utils.UrlUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;


/**
 * Created by sy_heima on 2016/7/15.
 */
public class AppInfoSafeViewHolder extends BasicHolder<AppInfoBean> {
    @BindView(R.id.iv_title_01)
    ImageView mIvTitle01;
    @BindView(R.id.iv_title_02)
    ImageView mIvTitle02;
    @BindView(R.id.iv_title_03)
    ImageView mIvTitle03;
    @BindView(R.id.iv_title_arrow)
    ImageView mIvTitleArrow;
    @BindView(R.id.iv_content_icon01)
    ImageView mIvContentIcon01;
    @BindView(R.id.tv_content_title01)
    TextView mTvContentTitle01;
    @BindView(R.id.iv_content_icon02)
    ImageView mIvContentIcon02;
    @BindView(R.id.tv_content_title02)
    TextView mTvContentTitle02;
    @BindView(R.id.iv_content_icon03)
    ImageView mIvContentIcon03;
    @BindView(R.id.tv_content_title03)
    TextView mTvContentTitle03;
    @BindView(R.id.ll_app_safe_show_layout)
    LinearLayout mLlAppSafeShowLayout;
    @BindView(R.id.ll_app_safe_root_layout)
    LinearLayout mLlAppSafeRootLayout;
    private int mMCurrentHeight;

    private boolean isOpen = false;//默认是关闭的

    @Override
    public View creatConvertView() {
        View view = View.inflate(MyAppliocation.sContext, R.layout.include_app_safe, null);
        return view;
    }

    @Override
    public void bindData(AppInfoBean appInfoBean) {

        //得到集合数据
        List<AppInfoBean.SafeBean> safe = appInfoBean.getSafe();

        //得到当前的图片地址
        System.out.println("得到当前的图片地址" + UrlUtil.imgURL + safe.get(0).getSafeUrl());

        //得到当前的数据大小
        int size = safe.size();

        ImageLoader.getInstance().displayImage(UrlUtil.imgURL + safe.get(0).getSafeUrl(),
                mIvTitle01, options);
        ImageLoader.getInstance().displayImage(UrlUtil.imgURL + safe.get(0).getSafeDesUrl(),
                mIvContentIcon01, options);
        mTvContentTitle01.setText(safe.get(0).getSafeDes());

        //在这里如果我们的size >=2 显示第二条,如果>=3显示第三条

        if (size >= 3) {
            //显示所有的
            //进行赋值,定义最大三条


            ImageLoader.getInstance().displayImage(UrlUtil.imgURL + safe.get(2).getSafeUrl(),
                    mIvTitle03, options);


            ImageLoader.getInstance().displayImage(UrlUtil.imgURL + safe.get(2).getSafeDesUrl(),
                    mIvContentIcon03, options);


            mTvContentTitle03.setText(safe.get(2).getSafeDes());
        }
        if (size >= 2) {
            //最后一条隐藏
            //进行赋值,定义最大三条
            ;
            ImageLoader.getInstance().displayImage(UrlUtil.imgURL + safe.get(1).getSafeUrl(),
                    mIvTitle02, options);


            ImageLoader.getInstance().displayImage(UrlUtil.imgURL + safe.get(1).getSafeDesUrl(),
                    mIvContentIcon02, options);

            mTvContentTitle02.setText(safe.get(1).getSafeDes());
        }

     /*   //进行赋值,定义最大三条
        ImageLoader.getInstance().displayImage(GoogleUri.imagePix + safe.get(0).getSafeUrl(),
        mIvTitle01, options);
        ImageLoader.getInstance().displayImage(GoogleUri.imagePix + safe.get(1).getSafeUrl(),
        mIvTitle02, options);
        ImageLoader.getInstance().displayImage(GoogleUri.imagePix + safe.get(2).getSafeUrl(),
        mIvTitle03, options);

        ImageLoader.getInstance().displayImage(GoogleUri.imagePix + safe.get(0).getSafeDesUrl(),
        mIvContentIcon01, options);
        ImageLoader.getInstance().displayImage(GoogleUri.imagePix + safe.get(1).getSafeDesUrl(),
        mIvContentIcon02, options);
        ImageLoader.getInstance().displayImage(GoogleUri.imagePix + safe.get(2).getSafeDesUrl(),
        mIvContentIcon03, options);

        mTvContentTitle01.setText(safe.get(0).getSafeDes());
        mTvContentTitle02.setText(safe.get(1).getSafeDes());
        mTvContentTitle03.setText(safe.get(2).getSafeDes());*/

        //设置一个监听,绘制完成的时候,告诉我一声,如果放在点击事件里,布局已经完成没有回调
        mLlAppSafeShowLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
                .OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //把当前的监听移除
                mLlAppSafeShowLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                //得到当前的控件的高度
                mMCurrentHeight = mLlAppSafeShowLayout.getHeight();
                System.out.println("得到完成后的高度：" + mMCurrentHeight);
                //初始化的时候我应该把当前的布局进行隐藏
                mLlAppSafeShowLayout.setPadding(0, -mMCurrentHeight, 0, 0);
            }


        });


        // mIvTitle01.setImageResource(R.mipmap.ic_launcher);

        //设置事件
        mLlAppSafeRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("当前控件被点击了");

                //这里需要注意,在快速执行动画时会有bug
                //旋转箭头
                ViewCompat.animate(mIvTitleArrow).rotationBy(180).setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {

                        mLlAppSafeRootLayout.setClickable(false);
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        mLlAppSafeRootLayout.setClickable(true);

                    }

                    @Override
                    public void onAnimationCancel(View view) {

                    }
                }).start();

                //现在的重点在于如何得到高度
                //在界面绘制完成前是没有高度的
        /*        int height = mLlAppSafeRootLayout.getHeight();
                System.out.println("当前的高度:"+height);*/

                //没有绘制完成前,请求父类把我高度先绘制出来
         /*       mLlAppSafeRootLayout.measure(0,0);
                int measuredHeight = mLlAppSafeRootLayout.getMeasuredHeight();
                System.out.println("当前的高度2:"+measuredHeight);*/
                //执行一个动画
                ValueAnimator mValueAnimator = new ValueAnimator();
                int height = -mMCurrentHeight;
                if (isOpen) {
                    //如果是打开,那么关闭
                    //如果做的收缩的效果,0,到负的控件高度
                    mValueAnimator.setIntValues(0, height);
                    //更改状态
                    isOpen = false;
                } else {
                    //如果是关闭的,那么打开
                    //如果做的收缩的效果,0,到负的控件高度
                    mValueAnimator.setIntValues(height, 0);
                    isOpen = true;
                }

                mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        //得到当前的动画值
                        System.out.println("当前的动画值:" + animation + "当前的高度:" + mMCurrentHeight);
                        int animatedValue = (int) animation.getAnimatedValue();
                        mLlAppSafeShowLayout.setPadding(0, animatedValue, 0, 0);
                    }
                });
                mValueAnimator.setDuration(1000);
                mValueAnimator.start();


            }
        });
    }
}
