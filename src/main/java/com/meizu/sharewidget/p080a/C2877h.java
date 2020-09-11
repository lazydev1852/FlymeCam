package com.meizu.sharewidget.p080a;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.sharewidget.a.h */
/* compiled from: ShareWidgetUsageCollector */
public class C2877h {
    /* renamed from: a */
    public static void m17276a(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sdk_share_view_open_form_package", str);
            C2876e.m17269a(context, "sdk_share_view_open_show", (String) null, hashMap, "com.meizu.flyme.sdk");
        }
    }

    /* renamed from: a */
    public static void m17275a(Context context) {
        if (context != null) {
            C2876e.m17269a(context, "sdk_share_view_whether_tick", (String) null, (Map<String, String>) null, "com.meizu.flyme.sdk");
        }
    }

    /* renamed from: b */
    public static void m17277b(Context context, String str) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sdk_share_view_app_selected_shareto_with_package", str);
            C2876e.m17269a(context, "sdk_share_view_app_shareto", (String) null, hashMap, "com.meizu.flyme.sdk");
        }
    }
}
