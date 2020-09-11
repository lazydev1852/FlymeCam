package com.loc;

import android.content.Context;
import java.lang.Thread;

/* renamed from: com.loc.g */
public class BasicLogHandler {

    /* renamed from: a */
    protected static BasicLogHandler f3344a;

    /* renamed from: b */
    protected Thread.UncaughtExceptionHandler f3345b;

    /* renamed from: c */
    protected boolean f3346c = true;

    /* renamed from: a */
    public static void m3844a(Throwable th, String str, String str2) {
        if (f3344a != null) {
            f3344a.mo13291a(th, 1, str, str2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13288a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13289a(Context context, SDKInfo diVar, boolean z) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13290a(SDKInfo diVar, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo13291a(Throwable th, int i, String str, String str2) {
    }
}
