package com.meizu.update.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.meizu.update.PlatformImpl;
import com.meizu.update.UpdateInfo;

/* renamed from: com.meizu.update.component.c */
public class MzUpdatePlatform {
    /* renamed from: a */
    public static void m17665a(Context context, CheckListener aVar) {
        PlatformImpl.m17564a(context, aVar, -1, false);
    }

    /* renamed from: a */
    public static void m17664a(Activity activity, UpdateInfo updateInfo) {
        PlatformImpl.m17565a(activity, (UpdateEndListener) null, updateInfo, false, (String) null, (String) null);
    }

    /* renamed from: b */
    public static boolean m17668b(Activity activity, UpdateInfo updateInfo) {
        return PlatformImpl.m17561a(activity, (UpdateEndListener) null, updateInfo, false, true) != null;
    }

    /* renamed from: a */
    public static final boolean m17667a(Context context, String str) {
        return PlatformImpl.m17567a(context, str);
    }

    /* renamed from: a */
    public static final boolean m17666a(Context context, Intent intent) {
        return PlatformImpl.m17566a(context, intent);
    }
}
