package com.baidu.p020ar.recorder.filter;

import android.content.Context;

/* renamed from: com.baidu.ar.recorder.filter.FilterManager */
public class FilterManager {

    /* renamed from: com.baidu.ar.recorder.filter.FilterManager$1 */
    static /* synthetic */ class C08661 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2158a = new int[FilterType.values().length];

        static {
            try {
                f2158a[FilterType.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: com.baidu.ar.recorder.filter.FilterManager$FilterType */
    public enum FilterType {
        Normal,
        Blend,
        SoftLight,
        ToneCurve
    }

    /* renamed from: a */
    public static C0869c m2502a(Context context, FilterType filterType) {
        int i = C08661.f2158a[filterType.ordinal()];
        return new C0868b(context);
    }

    /* renamed from: b */
    public static C0869c m2503b(Context context, FilterType filterType) {
        int i = C08661.f2158a[filterType.ordinal()];
        return new C0870d(context);
    }
}
