package com.acerolla.samples.container;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.acerolla.samples.R;
import com.acerolla.samples.utils.UiUtils;

/**
 * Created by Evgeniy Solovev
 * Date: 09.08.2018
 * Email: solevur@gmail.com
 */
public class MainView extends CoordinatorLayout {

    public static final int ID_CONTENT_FRAME = 5;
    public static final int ITEM_ID_CRYPTO = 0;
    public static final int ITEM_ID_ICO = 1;
    public static final int ITEM_ID_PORTFOLIO = 2;
    public static final int ITEM_ID_ALERT = 3;
    public static final int ITEM_ID_SETTINGS = 4;
    private static final int GROUP_ID = 0;

    public MainView(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        setFitsSystemWindows(true);

        AppBarLayout appBarLayout = new AppBarLayout(getContext());

        LayoutParams appBarParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        appBarLayout.setLayoutParams(appBarParams);
        addView(appBarLayout);

        Toolbar mToolbar = new Toolbar(getContext());
        mToolbar.setTitle("MY FUCKING TITLE!!!");

        AppBarLayout.LayoutParams toolbarParams = new AppBarLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                UiUtils.getToolbarHeight(getContext()));
        toolbarParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        mToolbar.setLayoutParams(toolbarParams);
        appBarLayout.addView(mToolbar);


        FrameLayout mContentFrame = new FrameLayout(getContext());
        mContentFrame.setPadding(0, 0, 0, UiUtils.dp2px(UiUtils.DP_48));
        mContentFrame.setId(ID_CONTENT_FRAME);

        LayoutParams contentParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        contentParams.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        mContentFrame.setLayoutParams(contentParams);
        addView(mContentFrame);

        BottomNavigationView mBottomNavigation = new BottomNavigationView(getContext());
        mBottomNavigation.setBackgroundColor(Color.WHITE);
        initializeMenu(mBottomNavigation.getMenu());

        LayoutParams menuParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                UiUtils.dp2px(UiUtils.DP_48));
        menuParams.gravity = Gravity.BOTTOM;
        mBottomNavigation.setLayoutParams(menuParams);
        addView(mBottomNavigation);
    }

    private void initializeMenu(Menu menu) {
        menu.add(GROUP_ID, ITEM_ID_CRYPTO, ITEM_ID_CRYPTO, R.string.main_menu_crypto)
                .setIcon(R.drawable.ic_menu_crypto);
        menu.add(GROUP_ID, ITEM_ID_ICO, ITEM_ID_ICO, R.string.main_menu_ico)
                .setIcon(R.drawable.ic_menu_ico);
        menu.add(GROUP_ID, ITEM_ID_PORTFOLIO, ITEM_ID_PORTFOLIO, R.string.main_menu_portfolio)
                .setIcon(R.drawable.ic_menu_portfolio);
        menu.add(GROUP_ID, ITEM_ID_ALERT, ITEM_ID_ALERT, R.string.main_menu_alert)
                .setIcon(R.drawable.ic_menu_alert);
        menu.add(GROUP_ID, ITEM_ID_SETTINGS, ITEM_ID_SETTINGS, R.string.main_menu_settings)
                .setIcon(R.drawable.ic_menu_settings);
        menu.setGroupCheckable(GROUP_ID, true, true);
    }

}
