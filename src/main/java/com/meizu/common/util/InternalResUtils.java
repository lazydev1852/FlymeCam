package com.meizu.common.util;

import android.content.res.Resources;

/* renamed from: com.meizu.common.util.b */
public class InternalResUtils {
    /* renamed from: a */
    public static int m5123a(int i, String str) {
        Resources system;
        if (str == null || str.isEmpty() || (system = Resources.getSystem()) == null) {
            return -1;
        }
        switch (i) {
            case 0:
                return ResourceUtils.m5162a(system, str, "id", "android");
            case 1:
                return ResourceUtils.m5162a(system, str, "dimen", "android");
            case 2:
                return ResourceUtils.m5162a(system, str, "string", "android");
            case 3:
                return ResourceUtils.m5162a(system, str, "styleable", "android");
            case 4:
                return ResourceUtils.m5162a(system, str, "attr", "android");
            case 5:
                return ResourceUtils.m5162a(system, str, "layout", "android");
            case 6:
                return ResourceUtils.m5162a(system, str, "style", "android");
            case 7:
                return ResourceUtils.m5162a(system, str, "bool", "android");
            case 8:
                return ResourceUtils.m5162a(system, str, "array", "android");
            case 9:
                return ResourceUtils.m5162a(system, str, "integer", "android");
            case 10:
                return ResourceUtils.m5162a(system, str, "color", "android");
            case 11:
                return ResourceUtils.m5162a(system, str, "drawable", "android");
            default:
                return -1;
        }
    }
}
