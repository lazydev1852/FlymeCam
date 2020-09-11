package com.meizu.sharewidget.p080a;

import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: com.meizu.sharewidget.a.i */
public class ShareWidgetUsageComparator implements Comparator<ResolveInfo> {

    /* renamed from: a */
    private final LinkedHashMap<String, C2882l> f15897a;

    public ShareWidgetUsageComparator(Context context, List<ResolveInfo> list) {
        this.f15897a = C2878j.m17280a(context, list);
    }

    /* renamed from: a */
    public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
        if (resolveInfo == null && resolveInfo2 == null) {
            return 0;
        }
        if (resolveInfo == null) {
            return 1;
        }
        if (resolveInfo2 == null) {
            return -1;
        }
        ComponentInfo componentInfo = resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo;
        ComponentInfo componentInfo2 = resolveInfo2.activityInfo != null ? resolveInfo2.activityInfo : resolveInfo2.serviceInfo;
        if (componentInfo == null && componentInfo2 == null) {
            return 0;
        }
        if (componentInfo == null) {
            return 1;
        }
        if (componentInfo2 == null) {
            return -1;
        }
        C2882l lVar = this.f15897a.get(componentInfo.name);
        C2882l lVar2 = this.f15897a.get(componentInfo2.name);
        int a = lVar2.mo24075a() - lVar.mo24075a();
        if (a == 0) {
            int i = ((lVar2.mo24076b() - lVar.mo24076b()) > 0 ? 1 : ((lVar2.mo24076b() - lVar.mo24076b()) == 0 ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i < 0 ? -1 : 0;
        } else if (a > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
