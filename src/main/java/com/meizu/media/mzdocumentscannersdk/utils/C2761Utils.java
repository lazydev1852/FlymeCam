package com.meizu.media.mzdocumentscannersdk.utils;

import android.graphics.Point;

/* renamed from: com.meizu.media.mzdocumentscannersdk.utils.Utils */
public class C2761Utils {
    public static double getPointsDistance(Point point, Point point2) {
        return Math.sqrt(Math.pow((double) (point.x - point2.x), 2.0d) + Math.pow((double) (point.y - point2.y), 2.0d));
    }
}
