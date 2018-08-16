package com.acerolla.samples.fragments.first;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatTextView;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.acerolla.samples.utils.UiUtils;

/**
 * Created by Evgeniy Solovev
 * Date: 09.08.2018
 * Email: solevur@gmail.com
 */
public class FirstView extends SwipeRefreshLayout {

    public FirstView(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {

        NestedScrollView sv = new NestedScrollView(getContext());

        CoordinatorLayout.LayoutParams svParams = new CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        svParams.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        sv.setLayoutParams(svParams);
        addView(sv);

        LinearLayout linear = new LinearLayout(getContext());
        linear.setOrientation(LinearLayout.VERTICAL);

        LayoutParams linearParams = new LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        linear.setLayoutParams(linearParams);
        sv.addView(linear);

        for (int i = 0; i < 30; i++) {
            AppCompatTextView tv = new AppCompatTextView(getContext());
            tv.setTextSize(20);
            tv.setText("TextView №" + i);
            int padding = UiUtils.dp2px(UiUtils.DP_10);
            tv.setPadding(padding, padding, padding, padding);
            linear.addView(tv);
        }
    }
}
