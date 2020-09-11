package com.meizu.share.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ComponentInfo;
import android.content.pm.ResolveInfo;
import androidx.annotation.NonNull;
import com.meizu.share.p079b.UsageInfo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.share.utils.f */
public class ShareWidgetUsageSharedPreferences {

    /* renamed from: a */
    private static ShareWidgetUsageSharedPreferences f15803a;

    /* renamed from: b */
    private final Map<String, UsageInfo> f15804b = new HashMap();

    /* renamed from: c */
    private final SharedPreferences f15805c;

    /* renamed from: a */
    public static ShareWidgetUsageSharedPreferences m17206a(Context context) {
        if (f15803a == null) {
            synchronized (ShareWidgetUsageSharedPreferences.class) {
                if (f15803a == null) {
                    f15803a = new ShareWidgetUsageSharedPreferences(context);
                }
            }
        }
        return f15803a;
    }

    private ShareWidgetUsageSharedPreferences(Context context) {
        this.f15805c = context.getSharedPreferences("ShareView_Usage", 0);
    }

    /* renamed from: a */
    public void mo24030a(ResolveInfo resolveInfo) {
        if (resolveInfo != null) {
            ComponentInfo componentInfo = resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo;
            UsageInfo cVar = this.f15804b.get(componentInfo.name);
            if (cVar == null) {
                cVar = new UsageInfo(1, System.currentTimeMillis());
                this.f15804b.put(componentInfo.name, cVar);
            } else {
                cVar.mo23984a(cVar.mo23983a() + 1);
                cVar.mo23985a(System.currentTimeMillis());
            }
            SharedPreferences.Editor edit = this.f15805c.edit();
            edit.putInt(componentInfo.name, cVar.mo23983a());
            edit.putLong(componentInfo.name + "_LastTime", cVar.mo23986b());
            edit.apply();
        }
    }

    @NonNull
    /* renamed from: b */
    public UsageInfo mo24031b(ResolveInfo resolveInfo) {
        ComponentInfo componentInfo = resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo;
        UsageInfo cVar = this.f15804b.get(componentInfo.name);
        if (cVar != null) {
            return cVar;
        }
        int i = this.f15805c.getInt(componentInfo.name, 0);
        SharedPreferences sharedPreferences = this.f15805c;
        UsageInfo cVar2 = new UsageInfo(i, sharedPreferences.getLong(componentInfo.name + "_LastTime", 0));
        this.f15804b.put(componentInfo.name, cVar2);
        return cVar2;
    }
}
