package com.flippey.market.uimanager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.flippey.market.R;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 19:55
 */
public abstract class LoadPager extends FrameLayout {

    private View mLoadPager;
    private View mErrorPager;
    private View mSuccessPager;

    public static final int mLoadingState = 100; //加载状态
    public static final int mSuccessState = 200; //加载成功状态
    public static final int mErrorState = 400; //加载失败状态
    public  int mCurrentState = mLoadingState;


    public LoadPager(Context context) {
        this(context,null);
    }

    public LoadPager(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoadPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 初始化界面，三个状态的界面叠加在一起
     * @param context
     */
    public void initView(Context context) {
        if (mLoadPager == null) {
            mLoadPager = View.inflate(context, R.layout.page_loading, null);
        }
        addView(mLoadPager);
        if (mErrorPager == null) {
            mErrorPager = View.inflate(context, R.layout.page_error, null);
        }
        addView(mErrorPager);
        if (mSuccessPager == null) {
            mSuccessPager = creatSuccessPager();
        }
        addView(mSuccessPager);
        showRightPager();
    }

    /**
     * 显示正确的page,根据当前的状态显示
     */
    public void showRightPager(){
        mLoadPager.setVisibility(GONE);
        mErrorPager.setVisibility(GONE);
        mSuccessPager.setVisibility(GONE);
        switch (mCurrentState) {
            case mLoadingState:
                mLoadPager.setVisibility(VISIBLE);
                break;
            case mSuccessState:
                mSuccessPager.setVisibility(VISIBLE);
                break;
            case mErrorState:
                mErrorPager.setVisibility(VISIBLE);
                break;
            default:
                break;
        }

    }
    /**
     * 由具体的实现类返回加载成功的布局
     * @return
     */
    protected abstract View creatSuccessPager();
}
