package flyme.support.p093v7.util;

import android.content.Context;
import android.util.TypedValue;
import com.meizu.common.util.ReflectUtils;

/* renamed from: flyme.support.v7.util.DensityUtils */
public class DensityUtils {

    /* renamed from: flyme.support.v7.util.DensityUtils$Type */
    public enum Type {
        WIDTH,
        HEIGHT
    }

    /* renamed from: a */
    public static int m18713a(Context context, double d) {
        return (int) TypedValue.applyDimension(1, (float) d, context.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    public static int m18712a(float f) {
        float f2;
        try {
            ReflectUtils.C1344h a = ReflectUtils.m5143a("android.os.SystemProperties").mo16008a("getInt", String.class, Integer.TYPE);
            f2 = ((float) ((Integer) a.mo16011a((Object) null, "persist.sys.density", Integer.valueOf(((Integer) a.mo16011a((Object) null, "ro.sf.lcd_density", 480)).intValue()))).intValue()) / 160.0f;
        } catch (Exception unused) {
            f2 = 3.0f;
        }
        return (int) (f * f2);
    }
}
