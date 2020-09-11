package com.meizu.flyme.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;

/* renamed from: com.meizu.flyme.sdk.b */
public class ContextBuilder {
    /* renamed from: a */
    public static Context m6349a(Context context, boolean z, boolean z2) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        if (z) {
            configuration.densityDpi = m6351a("persist.sys.density", m6351a("ro.sf.lcd_density", 480).intValue()).intValue();
        }
        if (z2) {
            configuration.fontScale = 1.0f;
        }
        Context createConfigurationContext = context.createConfigurationContext(configuration);
        if (context instanceof Activity) {
            createConfigurationContext.setTheme(m6350a((Activity) context, 0).intValue());
        }
        return createConfigurationContext;
    }

    /* renamed from: a */
    public static Integer m6351a(String str, int i) throws IllegalArgumentException {
        try {
            Class<?> a = ReflectionCache.m6352a().mo17607a("android.os.SystemProperties");
            return (Integer) ReflectionCache.m6352a().mo17609a(a, "getInt", String.class, Integer.TYPE).invoke(a, new Object[]{str, Integer.valueOf(i)});
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return Integer.valueOf(i);
        }
    }

    /* renamed from: a */
    public static Integer m6350a(Activity activity, int i) throws IllegalArgumentException {
        try {
            return (Integer) ReflectionCache.m6352a().mo17609a(Activity.class, "getThemeResId", new Class[0]).invoke(activity, new Object[0]);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception unused) {
            return Integer.valueOf(i);
        }
    }
}
