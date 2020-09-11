package com.meizu.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.TypedValue;
import com.meizu.common.R;
import java.util.ArrayList;

/* renamed from: com.meizu.common.util.f */
public class ResourceUtils {

    /* renamed from: a */
    private static Integer f4520a = null;

    /* renamed from: b */
    private static int f4521b = -1;

    /* renamed from: a */
    public static ArrayList<String> m5163a(Context context, TypedArray typedArray, int i) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i, typedValue)) {
            return null;
        }
        int i2 = typedValue.resourceId;
        if (i2 != 0) {
            TypedArray obtainTypedArray = context.getResources().obtainTypedArray(i2);
            int length = obtainTypedArray.length();
            ArrayList<String> arrayList = new ArrayList<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(obtainTypedArray.getString(i3));
            }
            obtainTypedArray.recycle();
            return arrayList;
        }
        throw new IllegalStateException("can't find the resourceId");
    }

    /* renamed from: a */
    public static int m5161a(Context context) {
        try {
            if (f4520a == null) {
                f4520a = Integer.valueOf(m5162a(context.getResources(), "status_bar_height", "dimen", "android"));
            }
            return context.getResources().getDimensionPixelSize(f4520a.intValue());
        } catch (Exception e) {
            Log.e("ResurceUtils", "get status bar height fail", e);
            return context.getResources().getDimensionPixelSize(R.dimen.status_bar_height);
        }
    }

    /* renamed from: b */
    public static Integer m5165b(Context context) {
        int identifier = context.getResources().getIdentifier("mzThemeColor", "attr", context.getPackageName());
        if (identifier <= 0) {
            return null;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{identifier});
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        if (color == -1) {
            return null;
        }
        return Integer.valueOf(color);
    }

    /* renamed from: a */
    public static float m5160a(float f, Context context) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    /* renamed from: b */
    public static float m5164b(float f, Context context) {
        return (float) ((int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f));
    }

    /* renamed from: a */
    public static int m5162a(Resources resources, String str, String str2, String str3) {
        if (!"android".equals(str3)) {
            return resources.getIdentifier(str, str2, str3);
        }
        return resources.getIdentifier("android:" + str2 + "/" + str, (String) null, (String) null);
    }
}
