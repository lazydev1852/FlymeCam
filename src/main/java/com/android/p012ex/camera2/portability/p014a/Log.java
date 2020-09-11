package com.android.p012ex.camera2.portability.p014a;

/* renamed from: com.android.ex.camera2.portability.a.a */
public class Log {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C0440a f279a = new C0440a("Log");

    /* renamed from: com.android.ex.camera2.portability.a.a$a */
    /* compiled from: Log */
    public static final class C0440a {

        /* renamed from: b */
        private static final int f280b = (23 - "CAM2PORT_".length());

        /* renamed from: a */
        final String f281a;

        public C0440a(String str) {
            int length = str.length() - f280b;
            if (length > 0) {
                C0440a a = Log.f279a;
                Log.m559b(a, "Tag " + str + " is " + length + " chars longer than limit.");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("CAM2PORT_");
            sb.append(length > 0 ? str.substring(0, f280b) : str);
            this.f281a = sb.toString();
        }

        public String toString() {
            return this.f281a;
        }
    }

    /* renamed from: a */
    public static void m556a(C0440a aVar, String str) {
        if (m558a(aVar.toString(), 6)) {
            android.util.Log.e(aVar.toString(), str);
        }
    }

    /* renamed from: a */
    public static void m557a(C0440a aVar, String str, Throwable th) {
        if (m558a(aVar.toString(), 6)) {
            android.util.Log.e(aVar.toString(), str, th);
        }
    }

    /* renamed from: b */
    public static void m559b(C0440a aVar, String str) {
        if (m558a(aVar.toString(), 5)) {
            android.util.Log.w(aVar.toString(), str);
        }
    }

    /* renamed from: a */
    private static boolean m558a(String str, int i) {
        try {
            if (LogHelper.m560a() != 0) {
                if (LogHelper.m560a() <= i) {
                    return true;
                }
                return false;
            } else if (android.util.Log.isLoggable("CAM2PORT_", i) || android.util.Log.isLoggable(str, i)) {
                return true;
            } else {
                return false;
            }
        } catch (IllegalArgumentException unused) {
            C0440a aVar = f279a;
            m556a(aVar, "Tag too long:" + str);
            return false;
        }
    }
}
