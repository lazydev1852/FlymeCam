package com.meizu.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/* renamed from: com.meizu.common.util.g */
public class ScreenUtil {
    /* renamed from: a */
    public static int m5166a(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(ResourceUtils.m5162a(resources, "navigation_bar_height", "dimen", "android"));
    }

    /* renamed from: a */
    public static int m5168a(Context context, int i) {
        return (int) TypedValue.applyDimension(2, (float) i, context.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    public static int m5167a(Context context, double d) {
        return (int) TypedValue.applyDimension(1, (float) d, context.getResources().getDisplayMetrics());
    }
}
