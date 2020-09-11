package com.meizu.sharewidget.p080a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: com.meizu.sharewidget.a.j */
/* compiled from: ShareWidgetUsageSharedPreferences */
public class C2878j {
    /* renamed from: a */
    public static void m17281a(Context context, ResolveInfo resolveInfo) {
        SharedPreferences a = m17279a(context);
        if (resolveInfo != null && a != null) {
            ComponentInfo componentInfo = resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo;
            SharedPreferences.Editor edit = a.edit();
            edit.putInt(componentInfo.name, a.getInt(componentInfo.name, 0) + 1);
            edit.putLong(componentInfo.name + "_LastTime", System.currentTimeMillis());
            edit.apply();
        }
    }

    /* renamed from: a */
    private static SharedPreferences m17279a(Context context) {
        return context.getSharedPreferences("ShareView_Usage", 0);
    }

    /* renamed from: a */
    public static LinkedHashMap<String, C2882l> m17280a(Context context, List<ResolveInfo> list) {
        LinkedHashMap<String, C2882l> linkedHashMap = new LinkedHashMap<>();
        SharedPreferences a = m17279a(context);
        for (ResolveInfo next : list) {
            ComponentInfo componentInfo = next.activityInfo != null ? next.activityInfo : next.serviceInfo;
            int i = a.getInt(componentInfo.name, 0);
            linkedHashMap.put(componentInfo.name, new C2882l(i, a.getLong(componentInfo.name + "_LastTime", 0)));
        }
        return linkedHashMap;
    }
}
