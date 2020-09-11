package com.baidu.p020ar.util;

import android.text.TextUtils;
import android.util.Log;
import com.mediatek.util.MtkPatterns;
import com.meizu.savior.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.baidu.ar.util.Debug */
public class Debug {

    /* renamed from: a */
    private static final Map<String, C0912a> f2359a = new HashMap();

    /* renamed from: b */
    private static long f2360b = 0;

    /* renamed from: com.baidu.ar.util.Debug$a */
    private static class C0912a {

        /* renamed from: a */
        public String f2361a;

        /* renamed from: b */
        public String f2362b;

        /* renamed from: c */
        public String f2363c;

        /* renamed from: d */
        public String f2364d;

        /* renamed from: e */
        public long f2365e;

        /* renamed from: f */
        public long f2366f;

        private C0912a() {
        }

        /* renamed from: e */
        private String m2714e() {
            String str = this.f2362b;
            int lastIndexOf = str.lastIndexOf(46);
            return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : str;
        }

        /* renamed from: a */
        public long mo10673a() {
            return this.f2366f - this.f2365e;
        }

        /* renamed from: b */
        public String mo10674b() {
            return this.f2361a + SystemInfoUtil.COLON + this.f2362b + SystemInfoUtil.COLON + this.f2364d + SystemInfoUtil.COLON + this.f2363c;
        }

        /* renamed from: c */
        public void mo10675c() {
            StringBuilder sb = new StringBuilder();
            sb.append(m2714e());
            sb.append("::");
            sb.append(this.f2363c);
            sb.append("--");
            sb.append(MtkPatterns.KEY_URLDATA_START);
            if (!TextUtils.isEmpty(this.f2364d)) {
                sb.append(SystemInfoUtil.COLON);
                sb.append(this.f2364d);
            }
            Debug.print(sb.toString(), this.f2365e);
        }

        /* renamed from: d */
        public void mo10676d() {
            StringBuilder sb = new StringBuilder();
            sb.append(m2714e());
            sb.append("::");
            sb.append(this.f2363c);
            sb.append("--");
            sb.append(MtkPatterns.KEY_URLDATA_END);
            if (!TextUtils.isEmpty(this.f2364d)) {
                sb.append(SystemInfoUtil.COLON);
                sb.append(this.f2364d);
            }
            sb.append(",cost:");
            sb.append(mo10673a());
            Debug.print(sb.toString(), this.f2366f);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof C0912a)) {
                return false;
            }
            return TextUtils.equals(mo10674b(), ((C0912a) obj).mo10674b());
        }

        public String toString() {
            return mo10674b();
        }
    }

    /* renamed from: a */
    private static C0912a m2708a() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String name = Debug.class.getName();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                stackTraceElement = null;
                break;
            }
            stackTraceElement = stackTrace[i];
            if (!name.equals(stackTraceElement.getClassName())) {
                break;
            }
            i++;
        }
        if (stackTraceElement == null) {
            return null;
        }
        String fileName = stackTraceElement.getFileName();
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        C0912a aVar = new C0912a();
        aVar.f2361a = fileName;
        aVar.f2362b = className;
        aVar.f2363c = methodName;
        return aVar;
    }

    /* renamed from: a */
    private static String m2709a(long j) {
        return new SimpleDateFormat("mm:ss.SSS", Locale.getDefault()).format(new Date(j));
    }

    /* renamed from: a */
    private static String m2710a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static void m2711a(String str) {
        C0912a a = m2708a();
        if (a != null) {
            a.f2365e = System.currentTimeMillis();
            a.f2364d = str;
            f2359a.put(a.mo10674b(), a);
            a.mo10675c();
        }
    }

    /* renamed from: b */
    private static String m2712b() {
        return new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
    }

    /* renamed from: b */
    private static void m2713b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        C0912a a = m2708a();
        if (a != null) {
            a.f2364d = str;
            C0912a remove = f2359a.remove(a.mo10674b());
            if (remove == null) {
                Log.d("Performance", "miss start method:" + a);
                return;
            }
            remove.f2366f = currentTimeMillis;
            remove.mo10676d();
        }
    }

    public static void onMethodEnd() {
        m2713b((String) null);
    }

    public static void onMethodEnd(Object obj) {
        m2713b(obj == null ? null : String.valueOf(obj.hashCode()));
    }

    public static void onMethodStart() {
        m2711a((String) null);
    }

    public static void onMethodStart(Object obj) {
        m2711a(obj == null ? null : String.valueOf(obj.hashCode()));
    }

    public static void print(String str) {
        print(str, System.currentTimeMillis());
    }

    public static void print(String str, long j) {
        String a = f2360b > 0 ? m2709a(j - f2360b) : m2712b();
        Log.e("Performance", Constants.ARRAY_TYPE + a + "]" + str);
    }

    public static void printStackTrace() {
        printStackTrace((Object) null);
    }

    public static void printStackTrace(Object obj) {
        printStackTrace(obj, 10);
    }

    public static void printStackTrace(Object obj, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String name = Debug.class.getName();
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!name.equals(stackTraceElement.getClassName())) {
                arrayList.add(stackTraceElement);
            }
        }
        int min = Math.min(i, arrayList.size());
        String a = m2710a((StackTraceElement[]) arrayList.subList(0, min).toArray(new StackTraceElement[min]));
        String valueOf = obj == null ? null : String.valueOf(obj.hashCode());
        String str = "=========begin=========\n" + a + "=========end=========\n";
        if (!TextUtils.isEmpty(valueOf)) {
            str = "[object:" + valueOf + "]" + str;
        }
        Log.e("Performance", str);
    }

    public static void resetBaseTime() {
        f2360b = System.currentTimeMillis();
    }
}
