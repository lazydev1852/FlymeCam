package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.android.volley.u */
public class VolleyLog {

    /* renamed from: a */
    public static String f419a = "Volley";

    /* renamed from: b */
    public static boolean f420b = Log.isLoggable(f419a, 2);

    /* renamed from: c */
    private static final String f421c = VolleyLog.class.getName();

    /* renamed from: a */
    public static void m726a(String str, Object... objArr) {
        if (f420b) {
            Log.v(f419a, m730d(str, objArr));
        }
    }

    /* renamed from: b */
    public static void m728b(String str, Object... objArr) {
        Log.d(f419a, m730d(str, objArr));
    }

    /* renamed from: c */
    public static void m729c(String str, Object... objArr) {
        Log.e(f419a, m730d(str, objArr));
    }

    /* renamed from: a */
    public static void m727a(Throwable th, String str, Object... objArr) {
        Log.e(f419a, m730d(str, objArr), th);
    }

    /* renamed from: d */
    private static String m730d(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            } else if (!stackTrace[i].getClassName().equals(f421c)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }

    /* renamed from: com.android.volley.u$a */
    /* compiled from: VolleyLog */
    static class C0468a {

        /* renamed from: a */
        public static final boolean f422a = VolleyLog.f420b;

        /* renamed from: b */
        private final List<C0469a> f423b = new ArrayList();

        /* renamed from: c */
        private boolean f424c = false;

        C0468a() {
        }

        /* renamed from: com.android.volley.u$a$a */
        /* compiled from: VolleyLog */
        private static class C0469a {

            /* renamed from: a */
            public final String f425a;

            /* renamed from: b */
            public final long f426b;

            /* renamed from: c */
            public final long f427c;

            public C0469a(String str, long j, long j2) {
                this.f425a = str;
                this.f426b = j;
                this.f427c = j2;
            }
        }

        /* renamed from: a */
        public synchronized void mo8771a(String str, long j) {
            if (!this.f424c) {
                this.f423b.add(new C0469a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        /* renamed from: a */
        public synchronized void mo8770a(String str) {
            this.f424c = true;
            long a = m731a();
            if (a > 0) {
                long j = this.f423b.get(0).f427c;
                VolleyLog.m728b("(%-4d ms) %s", Long.valueOf(a), str);
                for (C0469a next : this.f423b) {
                    long j2 = next.f427c;
                    VolleyLog.m728b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(next.f426b), next.f425a);
                    j = j2;
                }
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (!this.f424c) {
                mo8770a("Request on the loose");
                VolleyLog.m729c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        /* renamed from: a */
        private long m731a() {
            if (this.f423b.size() == 0) {
                return 0;
            }
            return this.f423b.get(this.f423b.size() - 1).f427c - this.f423b.get(0).f427c;
        }
    }
}
