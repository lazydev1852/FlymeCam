package com.meizu.media.camera.util;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.meizu.media.camera.mode.CameraModeType;
import com.meizu.media.camera.util.LogUtil;
import com.meizu.savior.ChangeQuickRedirect;
import com.meizu.savior.PatchProxy;
import com.meizu.savior.PatchProxyResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.meizu.media.camera.util.ar */
public class TimingLoggerUtil {

    /* renamed from: a */
    public static ChangeQuickRedirect f14141a;

    /* renamed from: b */
    private static final LogUtil.C2630a f14142b = new LogUtil.C2630a("TimingLoggerUtil");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static boolean f14143c = (!Log.isLoggable(f14142b.toString(), 2));

    /* renamed from: d */
    private static Map<String, C2642a> f14144d = new HashMap();

    /* renamed from: a */
    public static void m16031a(String str) {
        if (!PatchProxy.proxy(new Object[]{str}, (Object) null, f14141a, true, 8219, new Class[]{String.class}, Void.TYPE).isSupported) {
            f14144d.put(str, new C2642a(f14142b.toString(), str));
        }
    }

    /* renamed from: b */
    public static boolean m16034b(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14141a, true, 8220, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return f14144d.get(str) != null;
    }

    /* renamed from: a */
    public static void m16032a(String str, String str2) {
        C2642a aVar;
        Class[] clsArr = {String.class, String.class};
        if (!PatchProxy.proxy(new Object[]{str, str2}, (Object) null, f14141a, true, 8221, clsArr, Void.TYPE).isSupported && (aVar = f14144d.get(str)) != null) {
            aVar.mo22685a(str2);
        }
    }

    /* renamed from: a */
    public static long m16029a(Context context, String str) {
        ChangeQuickRedirect changeQuickRedirect = f14141a;
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context, str}, (Object) null, changeQuickRedirect, true, 8223, new Class[]{Context.class, String.class}, Long.TYPE);
        if (proxy.isSupported) {
            return ((Long) proxy.result).longValue();
        }
        C2642a aVar = f14144d.get(str);
        long j = -1;
        if (aVar != null) {
            j = aVar.mo22684a(context);
        }
        f14144d.remove(str);
        return j;
    }

    /* renamed from: a */
    public static void m16030a() {
        if (!PatchProxy.proxy(new Object[0], (Object) null, f14141a, true, 8224, new Class[0], Void.TYPE).isSupported) {
            f14144d.clear();
        }
    }

    /* renamed from: com.meizu.media.camera.util.ar$a */
    /* compiled from: TimingLoggerUtil */
    private static class C2642a {

        /* renamed from: a */
        public static ChangeQuickRedirect f14145a;

        /* renamed from: b */
        ArrayList<Long> f14146b;

        /* renamed from: c */
        ArrayList<String> f14147c;

        /* renamed from: d */
        private String f14148d;

        /* renamed from: e */
        private String f14149e;

        public C2642a(String str, String str2) {
            m16037a(str, str2);
        }

        /* renamed from: a */
        private void m16037a(String str, String str2) {
            Class[] clsArr = {String.class, String.class};
            if (!PatchProxy.proxy(new Object[]{str, str2}, this, f14145a, false, 8226, clsArr, Void.TYPE).isSupported) {
                this.f14148d = str;
                this.f14149e = str2;
                m16036a();
            }
        }

        /* renamed from: a */
        private void m16036a() {
            if (!PatchProxy.proxy(new Object[0], this, f14145a, false, 8227, new Class[0], Void.TYPE).isSupported) {
                if (this.f14146b == null) {
                    this.f14146b = new ArrayList<>();
                    this.f14147c = new ArrayList<>();
                } else {
                    this.f14146b.clear();
                    this.f14147c.clear();
                }
                mo22685a((String) null);
            }
        }

        /* renamed from: a */
        public void mo22685a(String str) {
            if (!PatchProxy.proxy(new Object[]{str}, this, f14145a, false, 8228, new Class[]{String.class}, Void.TYPE).isSupported) {
                this.f14146b.add(Long.valueOf(SystemClock.elapsedRealtime()));
                this.f14147c.add(str);
            }
        }

        /* renamed from: a */
        public long mo22684a(Context context) {
            PatchProxyResult proxy = PatchProxy.proxy(new Object[]{context}, this, f14145a, false, 8229, new Class[]{Context.class}, Long.TYPE);
            if (proxy.isSupported) {
                return ((Long) proxy.result).longValue();
            }
            if (!TimingLoggerUtil.f14143c) {
                String str = this.f14148d;
                Log.d(str, this.f14149e + ": begin");
            }
            long longValue = this.f14146b.get(0).longValue();
            UsageStatsHelper atVar = null;
            HashMap hashMap = new HashMap();
            if (context != null && TimingLoggerUtil.m16035c(this.f14149e)) {
                atVar = UsageStatsHelper.m16042a(context.getApplicationContext());
            }
            long j = longValue;
            for (int i = 1; i < this.f14146b.size(); i++) {
                j = this.f14146b.get(i).longValue();
                String str2 = this.f14147c.get(i);
                long longValue2 = this.f14146b.get(i - 1).longValue();
                if (!TimingLoggerUtil.f14143c) {
                    String str3 = this.f14148d;
                    Log.d(str3, this.f14149e + ":      " + (j - longValue2) + " ms, " + str2);
                }
                hashMap.put(str2, String.valueOf(j - longValue2));
            }
            if (!TimingLoggerUtil.f14143c) {
                String str4 = this.f14148d;
                Log.d(str4, this.f14149e + ": end, " + (j - longValue) + " ms");
            }
            if (atVar != null) {
                hashMap.put(this.f14149e, String.valueOf(j - longValue));
                hashMap.put("mode", CameraModeType.m10946a().name());
                atVar.mo22693a("camera_start_up_time", (Map<String, String>) hashMap);
            }
            return j - longValue;
        }
    }

    /* renamed from: c */
    public static boolean m16035c(String str) {
        PatchProxyResult proxy = PatchProxy.proxy(new Object[]{str}, (Object) null, f14141a, true, 8225, new Class[]{String.class}, Boolean.TYPE);
        if (proxy.isSupported) {
            return ((Boolean) proxy.result).booleanValue();
        }
        return "startUp".equals(str);
    }
}
