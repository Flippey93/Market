package com.flippey.market.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.flippey.market.R;
import com.flippey.market.datamanager.DataLoader;
import com.flippey.market.global.MyAppliocation;
import com.flippey.market.ui.widget.FlowLayout;
import com.flippey.market.utils.ToastUtil;
import com.flippey.market.utils.UiUtil;
import com.flippey.market.utils.UrlUtil;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @ Author      Flippey
 * @ Creat Time  2016/7/11 20:42
 */
public class HotFragment extends BaseFragment {

    private FlowLayout mFlowLayout;

    @Override
    protected Object initData() {
        final List<String> dataList = (List<String>) DataLoader.getDataLoader().getDataList(UrlUtil.hotURL, new
                TypeToken<List<String>>() {
        }.getType());
        if (dataList == null) {
            return null;
        }
        UiUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (String s : dataList) {
                    final TextView textView = new TextView(getContext());
                    textView.setText(s);
                    //设置文字
                    textView.setTextSize(16);
                    //文字改成白色
                    textView.setTextColor(Color.WHITE);
                    //设置padding
                    int dp10 =  UiUtil.getDimens(R.dimen.dp10);
                    textView.setPadding(dp10, dp10, dp10, dp10);
                    //居中
                    textView.setGravity(Gravity.CENTER);
                    //用代码实现我们的形状
                    //ShapeDrawable shapeDrawable = new ShapeDrawable();//这个类不能用
                    GradientDrawable gradientDrawable = getGradientDrawable();
                    GradientDrawable gradientDrawable2 = getGradientDrawable();
                    //创建一个背景
                    //添加按压效果
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    //textView.setBackgroundDrawable(stateListDrawable);
                    stateListDrawable.addState(new int[]{android.R.attr.state_pressed},
                            gradientDrawable);
                    stateListDrawable.addState(new int[]{}, gradientDrawable2);
                    textView.setBackgroundDrawable(stateListDrawable);
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.shwoToast(textView.getText().toString());
                        }
                    });
                    mFlowLayout.addView(textView);
                }
            }
        });
        return dataList;
    }

    @Override
    public View onCreateSuccess() {
        ScrollView scrollView = new ScrollView(MyAppliocation.sContext);
        mFlowLayout = new FlowLayout(MyAppliocation.sContext);
        int left = UiUtil.getDimens(R.dimen.dp15);
        int top = UiUtil.getDimens(R.dimen.dp15);
        int rigth = UiUtil.getDimens(R.dimen.dp15);
        int bottom = UiUtil.getDimens(R.dimen.dp15);
        mFlowLayout.setPadding(left, top, rigth, bottom);
        scrollView.addView(mFlowLayout);
        return scrollView;
    }

    private GradientDrawable getGradientDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        //设置圆角
        gradientDrawable.setCornerRadius(8f);
        //设置颜色
        int red = UiUtil.createTextColor();
        int green =  UiUtil.createTextColor();
        int blue = UiUtil.createTextColor();
        gradientDrawable.setColor(Color.rgb(red,green,blue));
        return gradientDrawable;
    }
}
