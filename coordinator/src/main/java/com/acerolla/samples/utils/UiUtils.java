package com.acerolla.samples.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by Evgeniy Solovev
 * Date: 09.08.2018
 * Email: solevur@gmail.com
 */
public class UiUtils {
    public static final int DP_5 = 5;
    public static final int DP_10 = 10;
    public static final int DP_30 = 30;
    public static final int DP_48 = 48;
    public static final int DP_70 = 70;

    private static final int ZERO = 0;
    private static final String ID_NAME_NAVIGATION_BAR = "navigation_bar_height";
    private static final String ID_NAME_STATUS_BAR = "status_bar_height";
    private static final String ID_TYPE = "dimen";
    private static final String ID_PACKAGE = "android";

    private static final SparseIntArray CONVERTED_VALUES = new SparseIntArray();

    /*****************************************VALUES_CONVERTER*****************************************/

    public static int dp2px(final int dp) {
        Integer value = CONVERTED_VALUES.get(dp);
        if (value == 0) {
            value = (int) (dp * Resources.getSystem().getDisplayMetrics().density);
            CONVERTED_VALUES.put(dp, value);
        }
        return value;
    }

    public static int spToPx(final int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sp, Resources.getSystem().getDisplayMetrics());
    }

    public static int pxToDp(final int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
/***************************************END_VALUES_CONVERTER***************************************/


    /******************************************DEVICE_METRICS******************************************/

    public static int getToolbarHeight(final Context context) {
        final Resources resources = context.getResources();
        int resourceId = resources.getIdentifier(ID_NAME_NAVIGATION_BAR, ID_TYPE, ID_PACKAGE);
        if (resourceId > ZERO) {
            return resources.getDimensionPixelSize(resourceId);
        }

        return ZERO;
    }

    public static int getStatusBarHeight(final Context context) {
        final Resources resources = context.getResources();
        int resourceId = resources.getIdentifier(ID_NAME_STATUS_BAR, ID_TYPE, ID_PACKAGE);
        if (resourceId > ZERO) {
            return resources.getDimensionPixelSize(resourceId);
        }

        return ZERO;
    }

    public static int getScreenHeight(final Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(metrics);
            return metrics.heightPixels;
        }

        return ZERO;
    }

    public static int getScreenWidth(final Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(metrics);
            return metrics.widthPixels;
        }

        return ZERO;
    }
/****************************************END_DEVICE_METRICS****************************************/
}
