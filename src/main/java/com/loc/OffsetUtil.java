package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.CoordUtil;
import com.amap.api.location.DPoint;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.loc.ch */
public final class OffsetUtil {

    /* renamed from: a */
    static double f2993a = 3.141592653589793d;

    /* renamed from: b */
    private static final List<DPoint> f2994b = new ArrayList(Arrays.asList(new DPoint[]{new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)}));

    /* renamed from: a */
    public static DPoint m3400a(Context context, double d, double d2) {
        if (context == null) {
            return null;
        }
        return m3401a(context, new DPoint(d2, d));
    }

    /* renamed from: a */
    public static DPoint m3401a(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        String a = CoordinatorSoDownloader.m3773a(context, "libwgs2gcj.so");
        if (!TextUtils.isEmpty(a) && new File(a).exists() && !CoordUtil.m515a()) {
            try {
                System.load(a);
                CoordUtil.m514a(true);
            } catch (Throwable unused) {
            }
        }
        return m3402a(dPoint, CoordUtil.m515a());
        CoreUtil.m3389a(th, "OffsetUtil", "offset");
        return m3402a(dPoint, CoordUtil.m515a());
    }

    /* renamed from: a */
    private static DPoint m3402a(DPoint dPoint, boolean z) {
        double a;
        double b;
        try {
            if (!CoreUtil.m3390a(dPoint.mo8585b(), dPoint.mo8584a())) {
                return dPoint;
            }
            double[] dArr = new double[2];
            if (z) {
                try {
                    if (CoordUtil.convertToGcj(new double[]{dPoint.mo8584a(), dPoint.mo8585b()}, dArr) != 0) {
                        a = dPoint.mo8584a();
                        b = dPoint.mo8585b();
                    }
                } catch (Throwable th) {
                    CoreUtil.m3389a(th, "OffsetUtil", "cover part1");
                    a = dPoint.mo8584a();
                    b = dPoint.mo8585b();
                }
                return new DPoint(dArr[1], dArr[0]);
            }
            a = dPoint.mo8584a();
            b = dPoint.mo8585b();
            dArr = C1080cq.m3559a(a, b);
            return new DPoint(dArr[1], dArr[0]);
        } catch (Throwable th2) {
            CoreUtil.m3389a(th2, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }
}
