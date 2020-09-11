package com.meizu.statsapp.p081v3.lib.plugin.net;

import android.content.Context;
import android.text.TextUtils;
import com.meizu.statsapp.p081v3.utils.log.Logger;
import com.meizu.statsapp.p081v3.utils.reflect.ReflectHelper;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.statsapp.v3.lib.plugin.net.GslbWrapper */
public class GslbWrapper {
    private static GslbWrapper sInstance;
    private final String TAG = "GslbWrapper";
    private Object mGslbManager;
    private Map<String, Object> mIPMap;

    public static synchronized GslbWrapper getsInstance(Context context) {
        GslbWrapper gslbWrapper;
        synchronized (GslbWrapper.class) {
            if (sInstance == null) {
                sInstance = new GslbWrapper(context);
            }
            gslbWrapper = sInstance;
        }
        return gslbWrapper;
    }

    private GslbWrapper(Context context) {
        try {
            this.mGslbManager = ReflectHelper.reflectConstructor("com.meizu.gslb2.GslbManager", new Class[]{Context.class}, new Object[]{context});
            if (this.mGslbManager != null) {
                Logger.m17378d("GslbWrapper", "### gslb manager constructed");
            }
            this.mIPMap = new HashMap();
        } catch (Exception e) {
            Logger.m17379e("GslbWrapper", e.getMessage());
        }
    }

    public String convert(String str) {
        if (this.mGslbManager != null) {
            try {
                Object invoke = ReflectHelper.invoke(this.mGslbManager, "convert", (Class<?>[]) new Class[]{String.class}, new Object[]{str});
                if (invoke != null) {
                    String str2 = (String) ReflectHelper.invoke(invoke, "getAvailableIp", (Object[]) null);
                    if (!TextUtils.isEmpty(str2)) {
                        this.mIPMap.put(str2, invoke);
                        Logger.m17378d("GslbWrapper", "### gslb convert return: " + str2);
                        return str2;
                    }
                }
            } catch (Exception e) {
                Logger.m17379e("GslbWrapper", e.getMessage());
            }
        } else {
            Logger.m17378d("GslbWrapper", "### gslb manager not found");
        }
        Logger.m17378d("GslbWrapper", "### gslb convert return: " + str);
        return str;
    }

    public void onResponse(String str, int i) {
        if (this.mGslbManager != null) {
            Logger.m17378d("GslbWrapper", "### gslb  onResponse, ip: " + str + ", code: " + i);
            Object obj = this.mIPMap.get(str);
            if (obj != null) {
                try {
                    ReflectHelper.invoke(this.mGslbManager, "onResponseSuccess", (Class<?>[]) new Class[]{obj.getClass(), Integer.TYPE}, new Object[]{obj, Integer.valueOf(i)});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            Logger.m17378d("GslbWrapper", "### gslb manager not found");
        }
    }
}
