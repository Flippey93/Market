package com.flippey.market.uimanager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.flippey.market.R;
import com.flippey.market.utils.UiUtil;

import java.util.List;

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
    public int mCurrentState = mSuccessState;


    public LoadPager(Context context) {
        this(context, null);
    }

    public LoadPager(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 初始化界面，三个状态的界面叠加在一起
     *
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
        initPager();
        showRightPager();
    }

    /**
     * 初始化pager
     */
    public void initPager() {
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
     * 获取数据，展示pager
     */
    private void showRightPager() {
        UiUtil.runOnSubThread(new Runnable() {
            @Override
            public void run() {
                Object object = loadData();
                mCurrentState = checkData(object);
                UiUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //更新界面
                        initPager();
                    }
                });
            }
        });
    }

    private int checkData(Object object) {
        //判断对象是否为空，如果是集合，则判断大小是否为0
        if (object == null) {
            return mErrorState;
        } else {
            //判断是否属于集合
            if (object instanceof List) {
                if (((List) object).size() <= 0) {
                    return mErrorState;
                }
            }
        }
        return mSuccessState;
    }

    /**
     * 加载数据
     */
    protected abstract Object loadData();

    /**
     * 由具体的实现类返回加载成功的布局
     *
     * @return
     */
    protected abstract View creatSuccessPager();
}
